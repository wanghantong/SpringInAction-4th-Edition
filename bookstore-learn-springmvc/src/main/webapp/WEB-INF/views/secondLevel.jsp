<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL配置路径学习页面</title>
</head>
<body>
	<h1>single1.jsp /single1</h1> 
	<h3>@RequestMapping(value = "/")  </h3>
	<h3> @RequestMapping(path = "/single1")</h3>
	
	<h1><a href="secondLevel">再次跳转到@RequestMapping(path = "/secondLevel")</a></h1>
	
	<h2><a href='/'>back</a></h2>
</body>
</html>