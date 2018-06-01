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
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>保险信息添加</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/insurance/insertinsurance">
      <div class="form-group">
      <input type="hidden" class="input"  name="carId" value="${PublicCar.carId}" style="width:25%; float:left"/>
      <input type="hidden" class="input"  name="driverId" value="${PublicCar.driverId}" style="width:25%; float:left"/>
        <div class="label">
          <label>车辆编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" readonly="readonly" value="${PublicCar.carId}" style="width:25%; float:left" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>驾驶员：</label>
        </div>
        <div class="field">
          <input type="text" class="input" readonly="readonly" name="driverName" value="${PublicCar.driverName}" style="width:25%; float:left"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>保险类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="insuranceType" value="" 
          style="width:25%; float:left" placeholder="请输入保险类型" data-validate="required:请输入保险类型"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>保险公司：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="insuranceCompany" value="" 
          style="width:25%; float:left" placeholder="请输入保险公司" data-validate="required:请输入保险公司"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>保险日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input" name="insuranceBegindate" value="" 
          style="width:25%; float:left" placeholder="请输保险时间"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>保险到期日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input" name="insuranceEnddate" value="" 
          style="width:25%; float:left" placeholder="请输入保险到期日期"/>
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
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>  
<script type="text/javascript">
	$(function(){
		//alert('${PublicCar}');
	})
</script>
</html>