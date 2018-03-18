<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<!-- css -->
<link rel="stylesheet" href="public/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="public/css/font-awesome.css">
<link rel="stylesheet" href="public/css/vs.css">
<link rel="stylesheet" type="text/css" href="/public/css/screen.css">
<link rel="stylesheet" href="/public/css/jquery.mloading.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>URL名称</th>
				<th>URL</th>
			</tr>
		</thead>
		<tbody class="table-hover">

			<sec:authorize access="hasRole('xxx') and principal.username=='wanghantong'">
				<tr>
					<td>二级路径</td>
					<td><a href="/double/parentControl">/double/parentControl</td>
				</tr>
			</sec:authorize>
			
			<tr>
				<td>redirect</td>
				<td><a href="/redirect">redirect</td>
			</tr>
			<tr>
				<td>forward</td>
				<td><a href="/forward">redirect</td>
			</tr>
			<tr>
				<td>redirectWithData</td>
				<td><a href="/redirectWithData">redirect</td>
			</tr>
			<tr>
				<td>register</td>
				<td><a href="/register">register</td>
			</tr>
			<tr>
				<td>register_map</td>
				<td><a href="/register_map">register_map</td>
			</tr>
			<tr>
				<td>registerMutipart</td>
				<td><a href="/registerMutipart">registerMutipart</td>
			</tr>
			<tr>
				<td>register_mutipart2</td>
				<td><a href="/registerMutipart2">register_mutipart2</td>
			</tr>
		</tbody>
	</table>


	<sec:authorize access="hasRole('ADMIN')">

This content will only be visible to users who have the "ADMIN" authority in their list of <tt>GrantedAuthority</tt>s.

</sec:authorize>
</body>
</html>


