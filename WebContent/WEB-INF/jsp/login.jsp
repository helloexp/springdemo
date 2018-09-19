<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
	<h1 style="color: red">${msg} </h1>
	<div>
		<table>
			<p>登录界面</p>
			<form method="post"	action="">
				username<input type="text" name="username"><br>
				password<input type="text" name="password"><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
			</form>			
		</table>
		
	</div>
</body>
</html>