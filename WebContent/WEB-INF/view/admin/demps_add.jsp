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
    <form method="post" class="form-x" action="<%=path %>/dempCtrl/insertDemp">
      <div class="form-group">
        <div class="label">
          <label>部门名称：</label>
        </div>
        <div class="field">
          	<input type="text" id="dempNameipt" class="input" name="dempName" value="" style="width:25%; float:left" 
          	placeholder="请输入部门名称" data-validate="required:请输入部门名称"/>
			<div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>创建时间：</label>
        </div>
        <div class="field">
          	<input type="text" id="createtimeipt" class="input" value="" style="width:25%; float:left" readonly="readonly"/>
			<div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>创建人：</label>
        </div>
        <div class="field">
          	<input type="text" class="input"  value="${user.userName }" style="width:25%; float:left" readonly="readonly"/>
			<div class="tips"></div>
        </div>
      </div>
      <input id="submitipt" type="submit" style="display: none;">
    </form>
    <div>
    <div>
	   <button style="margin-left: 115px;" class="button bg-main icon-check-square-o" onclick="checkDempName();" > 提交</button>
	</div>
	</div>
</div>
</div>
</body>
<script type="text/javascript">
 $(function(){
	 var currentdate = getTime();
	 $("#createtimeipt").val(currentdate);
 })
 
 function getTime(){
		var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    var strMinutes = date.getMinutes();
	    var strSeconds = date.getSeconds();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    if (strMinutes >= 0 && strMinutes <= 9) {
	    	strMinutes = "0" + strMinutes;
	    }
	    if (strSeconds >= 0 && strSeconds <= 9) {
	    	strSeconds = "0" + strSeconds;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + date.getHours() + seperator2 + strMinutes
	            + seperator2 + strSeconds;
	    return currentdate;
 }
 
 function checkDempName(){
	var dempname = $("#dempNameipt").val();
	$.post("<%=path %>/dempCtrl/checkDempName",{"dempName":dempname},
		function(result){
			if(result=="exist"){
				layer.msg("部门已存在，请重新输入部门名称！");
				return;
			}else{
				$("#submitipt").click();
			}
	});
 }
</script>
</html>