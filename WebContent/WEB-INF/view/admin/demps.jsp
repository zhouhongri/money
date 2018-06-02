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
				<strong class="icon-reorder">部门管理</strong> 
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>部门编号</th>
					<th>部门名称</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${list}" var="c">
					<tr id="tr${c.demp_id}">
						<td>${c.demp_id}</td>
						<td>${c.demp_name}</td>
						<td><div class="button-group">
								<a class="button border-main"
									onclick="del(${c.demp_id});"><span
									class="icon-edit"></span>删除</a>
							</div></td>
						<td>
						<a class="button border-main" href="<%=path %>/dempCtrl/queryDempById?dempId=${c.demp_id}">
						<span class="icon-edit"></span>修改</a>
						</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="8"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/dempCtrl/queryDemp?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/dempCtrl/queryDemp?currpage=${currpage+1}">下一页</a>
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
	function del(dempid){
		$.post("<%=path %>/dempCtrl/delDempById",{"dempId":dempid},
			function(result){
				if(result=="success"){
					$("#tr"+dempid).css("display","none");
				}else{
					layer.msg("删除失败");
				}
		});
	}
</script>
</html>