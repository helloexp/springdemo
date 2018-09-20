<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>项目首页</title>
</head>
<body>
	<h2>项目默认首页</h2><br>
	<a href="test/add" target="_blank">添加用户</a><br>
	<a href="test/selectAll" target="_blank">查询用户</a><br>
	<a href="test/login" target="_blank">登录</a><br>
	<a href="test/mvtest">测试ModelAndView</a><br>
	<hr>
	<a href="test/upload">上船头像</a><br>
	<form action="test/upload" method="post" enctype="multipart/form-data">
		选择文件<input type="file" name="filename">
		<input type="submit" value="上传">
	</form>
</body>
</html>