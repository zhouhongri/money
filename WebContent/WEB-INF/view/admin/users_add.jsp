<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
<script type="text/javascript">
    	    //var url = "goods_searchgid.action?chothes_id="+id;
    	function ajax() {
    		var bs = document.getElementById("bs").value;
    	           //先声明一个异步请求对象
    		           var xmlHttpReg = null;
    		           if (window.ActiveXObject) {//如果是IE
    		 
    		               xmlHttpReg = new ActiveXObject("Microsoft.XMLHTTP");
    		 
    		           } else if (window.XMLHttpRequest) {
    		 
    		               xmlHttpReg = new XMLHttpRequest(); //实例化一个xmlHttpReg
    		           }
    		 
    		           //如果实例化成功,就调用open()方法,就开始准备向服务器发送请求
    		           if (xmlHttpReg != null) {
    		               xmlHttpReg.open("post", "chothes_addch.action?bs="+bs, true);1
    		                xmlHttpReg.send(null);
    		               xmlHttpReg.onreadystatechange = doResult; //设置回调函数
    		 
    		           }
    		 
    		           //回调函数
    		          //一旦readyState的值改变,将会调用这个函数,readyState=4表示完成相应
    		 
    		           //设定函数doResult()
    		           function doResult() {
    		           
    		               if (xmlHttpReg.readyState == 4) {//4代表执行完成
    		                  
    		                  
    		                   if (xmlHttpReg.status == 200) {//200代表执行成功
    		                       //将xmlHttpReg.responseText的值赋给ID为resText的元素
    		                       document.getElementById("resText").innerHTML = xmlHttpReg.responseText;
    		                       
    		 
    		                   }
    		               }
    		 
    		           }
    		         
    		 
    		       }

    
    
    </script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加衣物</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="chothes_add.action">
      <div class="form-group">
        <div class="label">
          <label>衣物名称：</label>
        </div>
        <div class="field">
          	<input type="text" class="input" name="chothes.chothes_name" value="" style="width:25%; float:left" placeholder="请输入店面名称"/>
			<div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>衣物等级：</label>
        </div>
        <div class="field">
			<select name="bs" id="bs" class="input w50" onclick="ajax()">
				<option value="0">第一联级</option>
				<option value="1">第二联级</option>
			</select>
          <div class="tips"></div>
        </div>
      </div>
      <div id="resText"></div>
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
</div>
</body>
</html>