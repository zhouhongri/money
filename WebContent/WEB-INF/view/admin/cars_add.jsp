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
    <form method="post" class="form-x" action="<%=path %>/carCtrl/insertCar">
       <div class="form-group">
        <div class="label">
          <label>驾驶员：</label>
        </div>
        <div class="field">
          <select name="userId" id="driverNameSelect" class="input w50">
				
			</select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>车辆类型：</label>
        </div>
        <div class="field">
          <select name="carType" id="carTypeSelect" class="input w50">
          	<option value='小型' selected="selected">小型</option>
          	<option value='中型'>中型</option>
          	<option value='大型'>大型</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>支持人数：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="carNumber" value="${PublicCar.carNumber}" 
          style="width:25%; float:left" placeholder="请输入用车人数" data-validate="required:请输入用车人数"
          oninput="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
          <div class="tips"></div>
        </div>
      </div>
      <input id="submitipt" type="submit" style="display: none;">
    </form>
    <div>
    <div>
	   <button style="margin-left: 115px;" class="button bg-main icon-check-square-o" onclick="post();" > 提交</button>
	</div>
	</div>
</div>
</div>
</body>
<script type="text/javascript">
 $(function(){
	 $.post("<%=path %>/carCtrl/queryOtherDriverName",{},
				function(result){
					if(result!=null&&result!=""){
						$("#driverNameSelect").html("");
						$("#driverNameSelect").append("<option value='"+result[0].user_id+"' selected='selected'>"+result[0].user_name+"</option>");
						for(var i=1;i<result.length;i++){
							$("#driverNameSelect").append("<option value='"+result[i].user_id+"'>"+result[i].user_name+"</option>");
						}
					}
			});
 });
 function post(){
	 if($("#driverNameSelect").find("option").length==0){
		 layer.msg("没有可用的驾驶员！");
		 return;
	 }else{
		 $("#submitipt").click();
	 }
 }
</script>
</html>