<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<!-- meta -->
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>发布文章</title>
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="../../public/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="../../public/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="../../public/simditor/styles/simditor.css" />
</head>
<body>
	<div class="container">
		<h2 class="text-center">
			发布文章
			</h1>
			<!-- nav -->
			<h5 class="text-center">
				<a href="###">首页</a> <a href="###">文章列表</a> <a href="###">草稿箱</a> <a
					href="###">回收站</a>
			</h5>
			<!-- form 不需要指定action,由spring controller控制-->
			<form class="form-horizontal col-md-11" method="post" role="form"
				data-form>
				<div class="form-group">
					<label for="articleTitle" class="col-sm-2 control-label">文章标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" namd="a-title"
							id="articleTitle" placeholder="文章标题" data-title />
					</div>
				</div>
				<div class="form-group">
					<label for="articleContent" class="col-sm-2 control-label">文章内容</label>
					<div class="col-sm-10">
						<textarea id="editor" placeholder="文章内容" name="a-content"
							data-content autofocus></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="articleTag" class="col-sm-2 control-label">文章标签</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" namd="a-tag"
							id="articleTag" placeholder="文章标签" /> <span class="help-block">（最多添加5个标签，多个标签之间用“,”分隔）</span>
					</div>
				</div>
				<div class="form-group">
					<label for="articleType" class="col-sm-2 control-label">文章分类</label>
					<div class="col-sm-10">
						<label class="checkbox-inline"> <input type="checkbox"
							id="articleType1" name="a-type" value="1"> 设计模式
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType2" name="a-type" value="2"> Git
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType3" name="a-type" value="3"> Java Core
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType4" name="a-type" value="4"> 设计模式
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType5" name="a-type" value="5"> 软件架构
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType6" name="a-type" value="6"> 我的成长心得
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType7" name="a-type" value="7"> 每日英语
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="articleType8" name="a-type" value="8"> 问答社区
						</label>
					</div>
				</div>
				<div class="form-group">
					<label for="articleSummary" class="col-sm-2 control-label">文章摘要</label>
					<div class="col-sm-10">
						<textarea cols="30" rows="10" class="form-control"
							name="a-summary" id="articleSummary" placeholder="文章摘要"></textarea>
					</div>
				</div>
				<div class="form-group text-right">
					<div class="col-sm-offset-2 col-sm-10">
						<span class="text-danger" data-tip></span>
						<button type="button" data-publish class="btn btn-primary">提交发布</button>
						<button type="button" data-hold class="btn btn-default">暂存</button>
					</div>
				</div>
			</form>
	</div>
	<script type="text/javascript"
		src="../../public/simditor/scripts/jquery.min.js"></script>
	<script type="text/javascript"
		src="../../public/simditor/scripts/module.js"></script>
	<script type="text/javascript"
		src="../../public/simditor/scripts/hotkeys.js"></script>
	<script type="text/javascript"
		src="../../public/simditor/scripts/uploader.js"></script>
	<script type="text/javascript"
		src="../../public/simditor/scripts/simditor.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		var $form = $('[data-form]'), $tip = $('[data-tip]');
		// 编辑器
		var editor = new Simditor({
			textarea : $('#editor')
		//optional options
		});
		// 提交表单
		$('[type="button"]').click(function(e) {
			var $target = $(e.target), formData = new FormData($form);
			$tip.text('');
			if ($('[data-title]').val() === '') {
				$tip.text('文章标题不能为空');
				return false;
			}
			if ($('[data-content]').val() === '') {
				$tip.text('文章内容不能为空');
				return false;
			}
			if ($target.data('publish') === '') {
				$.ajax({
					type : 'POST',
					url : '/',
					dataType : null,
				}).done(function(data) {

				}).fail(function(err) {

				})
			} else if ($target.data('hold') === '') {
				// do something 暂存
			}
			// switch($target.attr('data'))
		});
	});
</script>
</html>