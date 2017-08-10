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

	<span>上一次跳转的结果</span>
	
	<h1>这是  父路径 + 子路径 拼接，通过<a>标签访问跳转的页面   	/double/parentControl</h1> 
	<h3>@RequestMapping(value = "/double")  </h3>
	<h3> @RequestMapping(path = "/parentControl")</h3>
	<span>结论:</span>
	
	<hr/>
	<p>
	<span>再次跳转的结果</span>
	<h3><a href="secondLevel">再次跳转到@RequestMapping(path = "/secondLevel")</a>(访问到的方法为:@RequestMapping(value = "/double")@RequestMapping(path = "/secondLevel") )</h3>
	<h3><a href="double/secondLevel">再次跳转到@RequestMapping(path = "/double/secondLevel")</a>(将会404)【真实请求路径为/double/double/secondLevel】</h3>
	<span>结论:由于第一次跳转的时候,父路径有值,那么该值将会保留,在当前页面再次通过<a>进行跳转时，只写子路径即path=""的部分即可,否则会多一层路径
	</span>
	<hr/>
	<p>
	<span>期望跳转到另外一个controller【SinglePathController.java】</span>
	<h3><a href="/single1">跳转到另外一个controller【SinglePathController】,@RequestMapping(value = "/") @RequestMapping(path = "/single1")</h3>
	<span>结论:期望跨Controller访问</span>
	<hr />
	<p>
	
	最终结论:
	1.在Controller中配置路径时,有无'/'均可
	2.如果类级别的@RequestMapping()中value 不为'/',那么在页面写跳转路径时,如果没有'/'则表示从上一个Controller中的@RequestMapping()中value的路径作为默认的第一层路径,
	3.如果类级别的@RequestMapping()中value 不为'/',期望跳转到其他Controller中配置的路径,则需要在页面写跳转路径时增加'/'
	
	<h2><a href='/'>back</a></h2>
</body>
</html>