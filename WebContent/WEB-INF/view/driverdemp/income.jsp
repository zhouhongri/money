<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/css/admin.css">
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/js/pintuer.js"></script>
</head>
<body>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">收入信息</strong> 
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>姓名</th>
					<th>职位</th>
					<th>所属部门</th>
					<th>维修费用</th>
					<th>薪资</th>
					<th>总共工资</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.user_name}</td>
						<c:if test="${c.user_identity=='0'}">
							<td>管理员</td>
						</c:if>
						<c:if test="${c.user_identity=='1'}">
							<td>驾驶员</td>
						</c:if>
						<c:if test="${c.user_identity=='2'}">
							<td>车辆部门负责人</td>
						</c:if>
						<c:if test="${c.user_identity=='3'}">
							<td>用车官员</td>
						</c:if>
						<td>${c.user_demp}</td>
						<c:choose>
							<c:when test="${c.consumption_money!='' && c.consumption_money!=null}">
								<td>${c.consumption_money}</td>
								<input type="hidden" name="consumptionmoneyname" value="${c.consumption_money},${c.user_id}"/>
							</c:when>
							<c:otherwise>
								<td>无</td>
								<input type="hidden" name="consumptionmoneyname" value="0,${c.user_id}"/>
							</c:otherwise>
						</c:choose>
						<td>${c.user_money}</td>
						<input type="hidden" name="usermoneyname" value="${c.user_money}"/>
						<td id="total${c.user_id}"></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/incomeCtrl/queryIncome?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/incomeCtrl/queryIncome?currpage=${currpage+1}">下一页</a>
							</c:if>
						</div></td>
				</tr>
			</table>
		</div>
</body>
<script>
	$(function(){
		var cmoneyElements = document.getElementsByName("consumptionmoneyname");
		var umoneyElements = document.getElementsByName("usermoneyname");
		for(var i in cmoneyElements){
			var cmoneyElementsArray = (cmoneyElements[i].value+"").split(",");
			var total = cmoneyElementsArray[0]*1+umoneyElements[i].value*1;
			$("#total"+cmoneyElementsArray[1]).text(total);
		}
	})
</script>
</html>