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
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>维修信息添加</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/consumption/insertconsumption">
      <div class="form-group">
      <input type="hidden" class="input"  name="carId" value="${PublicCar.carId}" style="width:25%; float:left"/>
      <input type="hidden" class="input"  name="deiverId" value="${PublicCar.driverId}" style="width:25%; float:left"/>
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
          <label>加油地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="consumptionAddress" value="" 
          style="width:25%; float:left" placeholder="请输入加油地址" data-validate="required:请输入加油地址"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>加油日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input" name="consumptionDate" value="" 
          style="width:25%; float:left" placeholder="请输入维修时间"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>加油金额：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="consumptionMoney" value="" 
          style="width:25%; float:left" placeholder="请输入加油金额" data-validate="required:请输入加油金额"
           oninput="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>加油数量：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="consumptionNumber" value="" 
          style="width:25%; float:left" placeholder="请输入加油数量" data-validate="required:请输入加油数量"
          oninput="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
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