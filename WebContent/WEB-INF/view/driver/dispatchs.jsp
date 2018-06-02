<%@ page language="java" contentType="text/html; charset=UTF-8"
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
				<strong class="icon-reorder">申请车辆记录</strong> 
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>申请人</th>
					<th>申请人性别</th>
					<th>申请人年龄</th>
					<th>承载人数</th>
					<th>申请时长</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.applicant_name}</td>
						<td>${c.applicant_sex}</td>
						<td>${c.applicant_age}</td>
						<td>${c.dispatch_number}</td>
						<td>${c.dispatch_time_length}</td>
						<c:choose>
							<c:when test="${c.dispatch_status == '1'}">
								<td><button id="clickbutton${c.dispatch_id}" class="button bg-main icon-check-square-o" onclick="reviewed('已完成',${c.dispatch_id},${c.car_id});">已完成</button></td>
							</c:when>
							<c:otherwise>
								<td id="changebutton${c.dispatch_id}"><button class="button bg-main icon-check-square-o" disabled="disabled">已完成</button></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="8"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/dispatchCtrl/queryDispatch?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/dispatchCtrl/queryDispatch?currpage=${currpage+1}">下一页</a>
							</c:if>
						</div></td>
				</tr>
			</table>
		</div>
</body>
<script>
	$(function(){
		//alert('${list}');
	})
	function reviewed(status,dispatchid,carid){
		alert(66);
		$.post("<%=path%>/dispatchCtrl/updateDispatch",{"dispatchStatus":status,"dispatchId":dispatchid,"carId":carid},
			function(result){
			if(result=="success"){
				$("#clickbutton"+dispatchid).attr("disabled","disabled");
			}else{
				layer.msg("系统出现一个小问题！");
			}
		});
	}
</script>
</html>