<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>政府车辆部门后台管理中心</title>
<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/css/admin.css">
<script src="<%=path %>/js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>
				<img src="<%=path %>/images/123456.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />政府车辆部门后台管理中心</h1>
  </div>
  <div class="head-l"> &nbsp;&nbsp;<a
				class="button button-little bg-red" href="user_exit.action"><span
				class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		  <h2>
					<span class="icon-pencil-square-o"></span>车辆管理</h2>
		  <ul>
		    <li><a href="<%=path %>/carCtrl/queryCar?currpage=1" target="right"><span
							class="icon-caret-right"></span>查询车辆信息</a></li>
			<li><a href="<%=path %>/common/admin/cars_add" target="right"><span
							class="icon-caret-right"></span>添加车辆信息</a></li>
		  </ul>  
		   <h2>
					<span class="icon-pencil-square-o"></span>用户管理</h2>
		  <ul>
		    <li><a href="<%=path %>/userCtrl/queryUser?currpage=1" target="right"><span
							class="icon-caret-right"></span>查询用户信息</a></li>
			<li><a href="<%=path %>/common/admin/users_add" target="right"><span
							class="icon-caret-right"></span>添加用户信息</a></li>
		  </ul>  
		  <h2>
					<span class="icon-pencil-square-o"></span>部门管理</h2>
		  <ul>
		    <li><a href="<%=path %>/dempCtrl/queryDemp?currpage=1" target="right"><span
							class="icon-caret-right"></span>查询部门信息</a></li>
			<li><a href="<%=path %>/common/admin/demps_add" target="right"><span
							class="icon-caret-right"></span>添加部门信息</a></li>
		  </ul>  
</div>
<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		})
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
</script>
<ul class="bread">
  <li><a href="#" class="icon-home"> 首页</a></li>
  <li><a href="#" id="a_leader_txt">订单管理</a></li>
  
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="<%=path %>/common/login/success" name="right"
			width="100%" height="100%" enctype="multipart/form-data"></iframe>
</div>
<div style="text-align:center;">

</div>
</body>
</html>