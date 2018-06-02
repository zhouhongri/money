<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="panel-head">
				<strong class="icon-reorder">用户管理</strong> 
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>用户名</th>
					<th>用户密码</th>
					<th>用户身份</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>所属部门</th>
					<th>薪资</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr id="tr${c.user_id}">
						<td>${c.user_username}</td>
						<td>${c.user_password}</td>
						<c:if test="${c.user_identity=='0'}">
							<td>管理员</td>
						</c:if>
						<c:if test="${c.user_identity=='1'}">
							<td>驾驶员</td>
						</c:if>
						<c:if test="${c.user_identity=='2'}">
							<td>车辆部门负责人</td>
						</c:if>
						<c:if test="${c.user_identity=='3'}">
							<td>用车官员</td>
						</c:if>
						<td>${c.user_name}</td>
						<td>${c.user_sex}</td>
						<td>${c.user_age}</td>
						<td>${c.user_demp}</td>
						<td>${c.user_money}</td>
						<td><div class="button-group">
								<a class="button border-main"
									onclick="del(${c.user_id});"><span
									class="icon-edit"></span>删除</a>
							</div></td>
						<td>
						<a class="button border-main" href="<%=path %>/userCtrl/queryUserById?userId=${c.user_id}">
						<span class="icon-edit"></span>修改</a>
						</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="10"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/userCtrl/queryUser?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/userCtrl/queryUser?currpage=${currpage+1}">下一页</a>
							</c:if>
						</div></td>
				</tr>
			</table>
		</div>
</body>
<script>
	$(function(){
		//alert('${list}');
	})
	function del(userid){
		$.post("<%=path %>/userCtrl/delUserById",{"userId":userid},
			function(result){
				if(result=="success"){
					$("#tr"+userid).css("display","none");
				}else{
					layer.msg("删除失败");
				}
		});
	}
</script>
</html>