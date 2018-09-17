<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询所有用户</title>
</head>
<body>
<%-- 	${users }<br> --%>
	
	<table border="1">
	<caption>您拥有的英雄</caption>
	<tr><th>ID</th><th>姓名</th><th>年龄</th></tr>
	<c:forEach	items="${users }" var="item" varStatus="id">
	<%-- 	${id.index }   ${item.id }  <br> --%>
		<tr><td>${item.id }</td><td>${item.name }</td><td>${item.age }</td></tr>
	
	</c:forEach>
	
	</table>
</body>
</html>