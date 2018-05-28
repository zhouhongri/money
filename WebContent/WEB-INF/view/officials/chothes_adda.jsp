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

</head>
<body>

	<div class="form-group">
        <div class="label">
          <label>衣物选择：</label>
        </div>
        <div class="field">
          <select id="c_id" name="c_id" class="input w50">
							<c:forEach items="${list}" var="c"  >
								<option value="${c.chothes_id}">${c.chothes_name}</option>
							</c:forEach>
						</select>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>衣物价格：</label>
        </div>
        <div class="field">
		<input type="text" class="input" name="chothes.chothes_price" value="" style="width:25%; float:left" placeholder="请输入店面名称"/>
          <div class="tips"></div>
        </div>
      </div>
      
</body>
</html>