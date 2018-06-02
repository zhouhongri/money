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
				<strong class="icon-reorder">申请车辆记录</strong> 
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>申请人</th>
					<th>车辆编号</th>
					<th>承载人数</th>
					<th>驾驶员</th>
					<th>申请时长</th>
					<th>申请原因</th>
					<th>状态</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr>
						<%-- <td><input type="hidden" value="${c.dispatch_id}"/></td> --%>
						<td>${c.applicant_name}</td>
						<td>${c.car_id}</td>
						<td>${c.dispatch_number}</td>
						<td>${c.driver_name}</td>
						<td>${c.dispatch_time_length}</td>
						<td>${c.dispatch_reason}</td>
						<td id="${c.dispatch_id}">
							<c:if test="${c.dispatch_status == '1'}">
								<b style="color: green">审核通过</b>
							</c:if>
							<c:if test="${c.dispatch_status == '0'}">
								<b style="color: red">审核中</b>
							</c:if>
							<c:if test="${c.dispatch_status == '2'}">
								<b style="color: grey">审核未通过</b>
							</c:if>
							<c:if test="${c.dispatch_status == '3'}">
								<b style="color: grey">已完成</b>
							</c:if>
						</td>
						<c:choose>
							<c:when test="${c.dispatch_status == '0'}">
								<td><button class="button bg-main icon-check-square-o clickbutton${c.dispatch_id}" onclick="reviewed('通过',${c.dispatch_id},${c.car_id}));">通过</button></td>
								<td><button class="button bg-main icon-check-square-o clickbutton${c.dispatch_id}" onclick="reviewed('未通过',${c.dispatch_id},${c.car_id});">未通过</button></td>
							</c:when>
							<c:otherwise>
								<td id="changebutton${c.dispatch_id}"><button class="button bg-main icon-check-square-o" disabled="disabled">已审核</button></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="9"><div class="pagelist">
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