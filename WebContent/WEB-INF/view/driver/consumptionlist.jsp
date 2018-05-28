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
				<strong class="icon-reorder">维修记录</strong> 
			</div>
            <div class="padding border-bottom">
				<ul class="search" style="padding-left: 10px;">
					<li><a class="button border-main icon-plus-square-o"
						href="<%=path %>/consumption/queryconsumption"> 添加加油记录</a></li>
					<li>搜索：</li>
					<li><input type="text" placeholder="请输入搜索关键字" id="keywords"
						name="keywords" class="input"
						style="width: 250px; line-height: 17px; display: inline-block" />
						<a href="javascript:void(0)"
						class="button border-main icon-search" onclick="changesearch()">
							普通用户编号搜索</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>加油编号</th>
					<th>车辆编号</th>
					<th>司机编号</th>
					<th>加油地址</th>					
					<th>加油日期</th>
					<th>加油金额</th>
					<th>加油数量</th>
					<th width="310">操作</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.consumption_id}</td>
						<td>${c.car_id}</td>
						<td>${c.deiver_id}</td>
						<td>${c.consumption_address}</td>
						<td>${c.consumption_date}</td>
						<td>${c.consumption_money}</td>
						<td>${c.consumption_number}</td>
						<td><div class="button-group">
								<a class="button border-main"href="<%=path %>/consumption/deleteconsumption?consumptionId=${c.consumption_id}">
								<span class="icon-edit"></span>删除</a>
							</div></td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="8"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/consumption/selectconsumption?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/consumption/selectconsumption?currpage=${currpage+1}">下一页</a>
							</c:if>
						</div></td>
				</tr>
			</table>
		</div>
</body>
<script>
	$(function(){
		alert('${list}');
	})
</script>
</html>