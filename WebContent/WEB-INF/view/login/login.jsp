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
<title>登录界面</title>
	<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
    <link rel="stylesheet" href="<%=path %>/css/layer.css">
    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/js/pintuer.js"></script>
    <script src="<%=path %>/js/layer.js"></script>
    <script type="text/javascript">
	function toLogin(){
		var userusername = $("#userusername").val();
		var userpassword = $("#userpassword").val();
		
		$.post("<%=path %>/loginCtrl/login",{
		"userUsername":userusername,
		"userPassword":userpassword},function(result){
			if(result.result){
				if(result.useridentity=="管理员"){
					window.location.href="";
				}else if(result.useridentity=="驾驶员"){
					window.location.href="<%=path %>/common/driver/index";
				}else if(result.useridentity=="车辆部门负责人"){
					window.location.href="";
				}else if(result.useridentity=="用车官员"){
					window.location.href="<%=path %>/common/officials/index";
				}
				layer.msg(result.mess,{icon:6});
			}else{
				layer.msg(result.mess,{icon:5});
			}
		});
	
	}
	
	function keyLogin(e){
		alert(666);
		var theEvent = window.event||e;
		var code = theEvent.keyCode||theEvent.which;
		if(code==13){
			toLogin();
		}
	}
	
	</script>  
</head>
<body style="background-image: url(<%=path %>/images/blue.jpg)">
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>政府车辆管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" id="userusername"
										placeholder="登录账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" id="userpassword"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field"></div>
							</div>
						</div>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录" onclick="toLogin();">
						</div>
					</div>
			</div>
		</div>
	</div>

</body>
</html>