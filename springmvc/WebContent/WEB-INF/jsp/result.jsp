<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<body>
	<div>
		<table>
			<p>添加英雄表单</p>
			<form method="post"	action="">
				id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="id"><br>
				name<input type="text" name="name"><br>
				age&nbsp;&nbsp;&nbsp;<input type="text" name="age"><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
			</form>			
		</table>
		
	</div>
</body>
</html>