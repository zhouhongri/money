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
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/css/admin.css">
    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改用户信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/userCtrl/updateUser">
    <input type="hidden" name="userId" value="${User.userId}">
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" readonly="readonly" name="userUsername" value="${User.userUsername}" style="width:25%; float:left" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userPassword" value="${User.userPassword}" style="width:25%; float:left" 
          data-validate="required:请输密码"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户身份：</label>
        </div>
        <div class="field">
          <input type="text" id="userIdentityipt" class="input" readonly="readonly" value="" style="width:25%; float:left" />
          <input type="hidden" name="userIdentity" value="${User.userIdentity}">
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>真实姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" readonly="readonly" name="userName" value="${User.userName}" style="width:25%; float:left" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input" readonly="readonly" name="userSex" value="${User.userSex}" style="width:25%; float:left" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userAge" value="${User.userAge}" style="width:25%; float:left" 
          data-validate="required:请输年龄"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>所属部门：</label>
        </div>
        <div class="field">
          <input type="text" class="input" readonly="readonly" name="userDemp" value="${User.userDemp}" style="width:25%; float:left" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>薪资：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userMoney" value="${User.userMoney}" style="width:25%; float:left" 
          data-validate="required:请输薪资数量"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
</div>
</body>
<script type="text/javascript">
	$(function(){
		if('${User.userIdentity}'=='0'){
			$("#userIdentityipt").val("管理员");
		}else if('${User.userIdentity}'=='1'){
			$("#userIdentityipt").val("驾驶员");
		}else if('${User.userIdentity}'=='2'){
			$("#userIdentityipt").val("车辆部门负责人");
		}else{
			$("#userIdentityipt").val("用车官员");
		}
		<%-- $.post("<%=path %>/dempCtrl/queryDempName",{},
			function(result){
			for(var i in result){
				$("#userDempSelect").append("<option value='"+result[i].dempName+"'>"+result[i].dempName+"</option>");
			}
		}); --%>
	})
</script>
</html>