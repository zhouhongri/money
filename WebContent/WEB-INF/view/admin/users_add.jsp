<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加部门</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/userCtrl/insertUser">
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          	<input type="text" id="userUsernameipt" class="input" name="userUsername" value="" style="width:25%; float:left" 
          	placeholder="请输入用户名" data-validate="required:请输入用户名"/>
			<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          	<input type="text" id="userPasswordipt" class="input" name="userPassword" value="" style="width:25%; float:left" 
          	placeholder="请输入密码" data-validate="required:请输入密码"/>
			<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户身份：</label>
        </div>
        <div class="field">
          	<select onchange="changeIdentity();" name="userIdentity" id="userIdentitySelect" class="input w50">
				<option value="1">驾驶员</option>
				<option value="2">车辆部门负责人</option>
				<option value="3">用车管员</option>
				<option value="0">管理员</option>
			</select>
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>所属部门：</label>
        </div>
        <div class="field">
          	<select name="userDemp" id="userDempSelect" class="input w50">
				<option value="车辆部门">车辆部门</option>
			</select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>真实姓名：</label>
        </div>
        <div class="field">
          	<input type="text" id="userNameipt" class="input" name="userName" value="" style="width:25%; float:left" 
          	placeholder="请输入真实姓名" data-validate="required:请输入真实姓名"/>
			<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          	<input type="text" id="userSexipt" class="input" name="userSex" value="" style="width:25%; float:left" 
          	placeholder="请输入性别" data-validate="required:请输入性别"/>
			<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          	<input type="text" id="userAgeipt" class="input" name="userAge" value="" style="width:25%; float:left" 
          	placeholder="请输入年龄" data-validate="required:请输入年龄"/>
			<div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>薪资：</label>
        </div>
        <div class="field">
          	<input type="text" id="userMoneyipt" class="input" name="userMoney" value="" style="width:25%; float:left" 
          	placeholder="请输入薪资" data-validate="required:请输入薪资"/>
			<div class="tips"></div>
        </div>
      </div>
      <input id="submitipt" type="submit" style="display: none;">
    </form>
    <div>
    <div>
	   <button style="margin-left: 115px;" class="button bg-main icon-check-square-o" onclick="checkUserName();" > 提交</button>
	</div>
	</div>
</div>
</div>
</body>
<script type="text/javascript">
 $(function(){
	 
 });
 
 function changeIdentity(){
	 var userIdentitySelectval = $("#userIdentitySelect").val();
	 if(userIdentitySelectval=="0"){
		 $("#userDempSelect").html("<option value='管理员'>管理员</option>");
	 }else if(userIdentitySelectval=="1" || userIdentitySelectval=="2"){
		 $("#userDempSelect").html("<option value='车辆部门'>车辆部门</option>");
	 }else{
		 checkUserDemp();
	 }
 }
 
 function checkUserName(){
	var username = $("#userUsernameipt").val();
	$.post("<%=path %>/userCtrl/checkUsername",{"userUsername":username},
		function(result){
			if(result=="exist"){
				layer.msg("用户名已存在，请重新输入用户名！");
				return;
			}else{
				$("#submitipt").click();
			}
	});
 }
 
 function checkUserDemp(){
	 $.post("<%=path %>/dempCtrl/queryDempName",{},
				function(result){
					if(result!=null&&result!=""){
						$("#userDempSelect").html("");
						for(var i in result){
							if(result[i].dempName!="车辆部门"&&result[i].dempName!="管理员"){
								$("#userDempSelect").append("<option value='"+result[i].dempName+"'>"+result[i].dempName+"</option>");
							}
						}
					}
			});
 }
</script>
</html>