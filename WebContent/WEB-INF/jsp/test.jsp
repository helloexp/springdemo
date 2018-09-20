<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>项目首页</title>
</head>
<body>
	<h2>测试ModelAndView</h2><br>
	<p style="color: gray">返回的数据:${user }</p>
	<p style="color: gray">返回的数据:${user.id }</p>
	<p style="color: gray">返回的数据:${user.name }</p>
	<p style="color: gray">返回的数据:${user.age }</p>
	<hr>
	<hr>
	<p style="color: gray;">获取到的数据list集合：${list }</p>
	
	<c:forEach items="${list }" varStatus="1" var="user">
		<p style="color: gray;">获取到的数据单元：${user }</p>
		
	</c:forEach>
	
</body>
</html>