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
				<strong class="icon-reorder">空闲车辆信息</strong> 
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>车辆编号</th>
					<th>车辆类型</th>
					<th>可承载人数</th>
					<th>驾驶员</th>
					<th>性别</th>
					<th>年龄</th>
					<th width="310">操作</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.car_id}</td>
						<td>${c.car_type}</td>
						<td>${c.car_number}</td>
						<td>${c.driver_name}</td>
						<td>${c.driver_sex}</td>
						<td>${c.driver_age}</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="<%=path %>/carCtrl/queryCarById?carId=${c.car_id}"><span
									class="icon-edit"></span> 申请用车</a>
							</div></td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="8"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/carCtrl/queryCar?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/carCtrl/queryCar?currpage=${currpage+1}">下一页</a>
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
</script>
</html>