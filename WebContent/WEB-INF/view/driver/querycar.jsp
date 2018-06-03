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
<link rel="stylesheet" href="<%=path %>/css/layer.css">
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/js/pintuer.js"></script>
<script src="<%=path %>/js/layer.js"></script>
</head>
<body>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">查询车辆信息</strong> 
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>车辆编号</th>
					<th>承载人数</th>
					<th>车辆类型</th>
					<th>司机姓名</th>
					<th>年检到期时间</th>
					<th>年检状态</th>
					<th>保险到期时间</th>
					<th>保险状态</th>
					<th>车辆部门</th>
				</tr>
					<tr>
						<td>${PublicCar.carId}</td>
						<td>${PublicCar.carNumber}</td>
						<td>${PublicCar.carType}</td>
						<td>${PublicCar.driverName}</td>
						<td>${PublicCar.carAnnualEndtime}</td>
						<td>${PublicCar.carAnnualStatus}</td>
						<td>${PublicCar.carInsuranceEndtime}</td>
						<td>${PublicCar.carInsuranceStatus}</td>
						<td>${PublicCar.dempName}</td>
					</tr>
			</table>
		</div>
</body>
<script>
	$(function(){
		//layer.msg("审核失败！");
	})
	function reviewed(status,dispatchid,carid){
		$.post("<%=path%>/dispatchCtrl/updateDispatch",{"dispatchStatus":status,"dispatchId":dispatchid,"carId":carid},
			function(result){
			if(result=="success"){
				$(".clickbutton"+dispatchid).attr("disabled","disabled");
				if(status=="通过"){
					$("#"+dispatchid).html('<b style="color: green">审核通过</b>');
				}else if(status=="未通过"){
					$("#"+dispatchid).html('<b style="color: grey">审核未通过</b>');
				}
			}else{
				layer.msg("审核失败！");
			}
		});
	}
</script>
</html>