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
	<h1>secondLevel.jsp /secondLevel</h1> 
	<h3>@RequestMapping(value = "/one")  </h3>
	<h3> @RequestMapping(path = "/secondLevel")</h3>
	
	<h1><a href="secondLevel">再次跳转到@RequestMapping(path = "/secondLevel")</a></h1>
	
	<h2><a href='/'>back</a></h2>
</body>
</html>