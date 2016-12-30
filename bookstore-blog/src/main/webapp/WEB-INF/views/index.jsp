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
<title>Dragon Wang 技术博客</title>
<meta name="description" content="maven 持续集成 testng junit">
<meta name="keywords" content="maven 持续集成 testng junit">
<meta name="HandheldFriendly" content="True">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="referrer" content="origin">
<meta name="generator" content="Ghost 0.7">
<!-- css -->
<link rel="stylesheet" href="../../public/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../../public/css/font-awesome.css">
<link rel="stylesheet" href="../../public/css/vs.css">
<link rel="stylesheet" type="text/css" href="../../public/css/screen.css">
<link rel="canonical" href="http://www.golaravel.com/">
<link rel="next" href="http://www.golaravel.com/page/2/">
<link rel="alternate" type="application/rss+xml"
	title="Laravel-简洁、优雅的PHP开发框架(PHP Web Framework)。- Laravel中文网（Laravel中国社区）"
	href="http://www.golaravel.com/rss/">
<style id="fit-vids-style">
.fluid-width-video-wrapper {
	width: 100%;
	position: relative;
	padding: 0;
}

.fluid-width-video-wrapper iframe, .fluid-width-video-wrapper object,
	.fluid-width-video-wrapper embed {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>
<!-- javascript -->
<script>
	var _hmt = _hmt || [];
</script>
<script type="text/javascript" src="style/js/ghost-url.js"></script>
<script type="text/javascript">
	ghost.init({
		clientId : "ghost-frontend",
		clientSecret : "26b0e31d612d"
	});
</script>
</head>
<body class="home-template">
	<!-- start header -->
	<header class="main-header"
		style="background-image: url(style/image/backgroundfloat.jpg)">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<h1>
						<span class="hide">Dragon </span>世界很大,圈子很小 | 持之以恒是正道
					</h1>
					<!-- <img
						src="Laravel-%E7%AE%80%E6%B4%81%E3%80%81%E4%BC%98%E9%9B%85%E7%9A%84PHP%E5%BC%80%E5%8F%91%E6%A1%86%E6%9E%B6%28PHP%20Web%20Framework%29%E3%80%82-%20Laravel%E4%B8%AD%E6%96%87%E7%BD%91%EF%BC%88Laravel%E4%B8%AD%E5%9B%BD%E7%A4%BE%E5%8C%BA%EF%BC%89_files/4e4bd788405aab87f03d26edc4ab4.png"
						alt="Laravel" class="hide"> -->
				</div>
				<div class="col-sm-12">
					<a href="http://www.golaravel.com/laravel/docs/5.1/"
						class="btn btn-default btn-doc" target="_blank">设计模式</a> <a
						href="http://blog.csdn.net/wanghantong/article/details/41315503"
						class="btn btn-default btn-doc" target="_blank">Git</a> <a
						href="http://www.golaravel.com/laravel/docs/4.2/"
						class="btn btn-default btn-doc" target="_blank">Java Core</a> <a
						href="http://www.golaravel.com/laravel/docs/4.1/"
						class="btn btn-default btn-doc" target="_blank">软件架构</a> <a
						href="http://www.golaravel.com/laravel/docs/4.0/"
						class="btn btn-default btn-doc" target="_blank">我的成长心得</a> <a
						href="http://lumen.golaravel.com/docs/"
						class="btn btn-default btn-doc" target="_blank">每日英语</a> <a
						href="http://wenda.golaravel.com/" class="btn btn-default btn-doc"
						target="_blank">问答社区</a> <a href="/publish/blog"
						class="btn btn-default btn-doc" target="_blank">发布文章</a>
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->
	<!-- start navigation -->
	<nav class="main-navigation">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar-header">
						<span class="nav-toggle-button collapsed" data-toggle="collapse"
							data-target="#main-menu"> <span class="sr-only">Toggle
								navigation</span> <i class="fa fa-bars"></i>
						</span>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
						<ul class="menu">
							<li class="nav-current" role="presentation"><a
								href="http://www.golaravel.com/">首页</a></li>
							<li role="presentation"><a
								href="http://blog.csdn.net/column/details/best-practice.html"
								title="maven技术详解" target="_blank">Maven技术详解</a></li>
							<li role="presentation"><a
								href="http://blog.csdn.net/wanghantong/article/category/2632203"
								title="TestNG技术详解" target="_blank">TestNG技术详解</a></li>
							<li role="presentation"><a
								href="http://blog.csdn.net/column/details/selenium2-webdriver.html"
								title="WebDriver/JSoup" target="_blank">WebDriver/JSoup</a></li>
							<li role="presentation"><a href="#"
								title="Spring In Action学习笔记">Spring In Action学习笔记</a></li>
							<li role="presentation"><a href="#" title="Docker学习笔记">Docker学习笔记</a></li>
							<li role="presentation"><a href="#" title="DataBase">DataBase</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- end navigation -->
	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">

				<article id="70" class="post">

					<div class="post-head">
						<h1 class="post-title">
							<a href="detail.html">Dragon's Blog 正式发布${取出文章题目}</a>
						</h1>
						<div class="post-meta">
							<span class="author">作者：<a
								href="http://blog.csdn.net/wanghantong">Dragon${取出作者}</a></span> •
							<time class="post-date" datetime="2016年11月25日星期五凌晨0点00分${取出文章时间}"
								title="2016年11月25日星期五凌晨0点00分${取出文章时间}">2016年11月25日${取出文章时间}</time>
						</div>
					</div>
					<!-- <div class="featured-media">
       <a href="http://www.golaravel.com/post/laravel-5-3-is-now-released/"><img src="Laravel-%E7%AE%80%E6%B4%81%E3%80%81%E4%BC%98%E9%9B%85%E7%9A%84PHP%E5%BC%80%E5%8F%91%E6%A1%86%E6%9E%B6%28PHP%20Web%20Framework%29%E3%80%82-%20Laravel%E4%B8%AD%E6%96%87%E7%BD%91%EF%BC%88Laravel%E4%B8%AD%E5%9B%BD%E7%A4%BE%E5%8C%BA%EF%BC%89_files/c367f99a8366ca86f7b889da25022.dms" alt="Laravel 5.3 正式发布"></a>
    </div>  -->
					<div class="post-content">
						<p>经过两天的努力,搭建好了基础环境,博客开始从CSDN陆续迁出...${取出文章概要}</p>
					</div>
					<div class="post-permalink">
						<a
							href="http://www.golaravel.com/post/laravel-5-3-is-now-released/"
							class="btn btn-default">阅读全文${href取文件详情页的URL}</a>
					</div>

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i>

						</div>
						<div class="pull-right share"></div>
					</footer>
				</article>



				<nav class="pagination" role="navigation">
					<span class="page-number">第 1 页 ⁄ 共 5 页</span> <a
						class="older-posts" href="http://www.golaravel.com/page/2/"><i
						class="fa fa-angle-right"></i></a>
				</nav>


				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">联系方式</h4>
						<div class="content community">
							<p>QQ/WeChat：296222242</p>
							<p>E-mail：hantong4510#163.com</p>
							<p>
								<a href="http://blog.csdn.net/wanghantong" title="CSDN博客"
									target="_blank"
									onclick="_hmt.push(['_trackEvent', 'big-button', 'click', 'CSDN博客'])"><i
									class="fa fa-comments"></i>CSDN博客</a>
							</p>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start widget -->
					<div class="widget">
						<h4 class="title">打赏</h4>
						<div class="content download">
							<img src="" alt="微信打赏" /> <img src="" alt="支付宝打赏" />
						</div>
					</div>
					<!-- end widget -->


					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">标签云</h4>
						<div class="content tag-cloud">
							<a href="http://www.golaravel.com/tag/lravel/">Maven</a><a
								href="http://www.golaravel.com/tag/installation/">TestNG</a> <a
								href="http://www.golaravel.com/tag/installation/">WebDriver</a>
							<a href="http://www.golaravel.com/tag/installation/">Selenium</a>
							<a href="http://www.golaravel.com/tag/installation/">Spring</a> <a
								href="http://www.golaravel.com/tag/installation/">Mysql</a> <a
								href="http://www.golaravel.com/tag/installation/">Docker</a> <a
								href="http://www.golaravel.com/tag/installation/">设计模式</a> <a
								href="http://www.golaravel.com/tag/installation/">软件架构</a> <a
								href="http://www.golaravel.com/tag-cloud/">...</a>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start widget -->
					<!-- end widget -->

					<!-- start widget -->
					<!-- end widget -->
				</aside>

			</div>
		</div>
	</section>
	<footer class="main-footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">最新文章</h4>
						<div class="content recent-post">
							<div class="recent-single-post">
								<a
									href="http://www.golaravel.com/post/laravel-5-3-is-now-released/"
									class="post-title">Dragon's Blog 正式发布${列表的第一个的标题}</a>
								<div class="date">2016年11月25日${列表的第一个的时间}</div>
							</div>

						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">标签云</h4>
						<div class="content tag-cloud">
							<a href="http://www.golaravel.com/tag/lravel/">Maven</a><a
								href="http://www.golaravel.com/tag/installation/">TestNG</a> <a
								href="http://www.golaravel.com/tag/installation/">WebDriver</a>
							<a href="http://www.golaravel.com/tag/installation/">Selenium</a>
							<a href="http://www.golaravel.com/tag/installation/">Spring</a> <a
								href="http://www.golaravel.com/tag/installation/">Mysql</a> <a
								href="http://www.golaravel.com/tag/installation/">Docker</a> <a
								href="http://www.golaravel.com/tag/installation/">设计模式</a> <a
								href="http://www.golaravel.com/tag/installation/">软件架构</a><a
								href="http://www.golaravel.com/tag-cloud/">...</a>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">合作伙伴</h4>
						<div class="content tag-cloud friend-links">
							<a href="http://www.bootcss.com/" title="Bootstrap中文网"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcsscom'])"
								target="_blank">Bootstrap中文网</a> <a
								href="http://www.bootcdn.cn/" title="开放CDN服务"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcdncn'])"
								target="_blank">开放CDN服务</a> <a href="http://www.gruntjs.net/"
								title="Grunt中文网"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'gruntjsnet'])"
								target="_blank">Grunt中文网</a> <a href="http://www.gulpjs.com.cn/"
								title="Gulp中文网"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'gulpjscomcn'])"
								target="_blank">Gulp中文网</a>
							<hr>
							<a href="http://lodashjs.com/" title="Lodash中文文档"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'lodashjscom'])"
								target="_blank">Lodash中文文档</a> <a
								href="http://www.jquery123.com/" title="jQuery中文文档"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'jquery123com'])"
								target="_blank">jQuery中文文档</a>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<span>Copyright © <a href="http://www.golaravel.com/">Dragon's
							Blog</a></span> | <span><a href="http://www.miibeian.gov.cn/"
						target="_blank">京ICP备11000510号</a></span> | <span>京公网安备11010510014853</span>
				</div>
			</div>
		</div>
	</div>
	<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>
	<!-- javascript -->
	<script src="public/bootstrap/js/jquery.js"></script>
	<script src="public/bootstrap/js//bootstrap.js"></script>
	<script src="public/bootstrap/js/jquery_002.js"></script>
	<script src="public/js/highlight.js"></script>
	<script src="public/js/main.js"></script>
	<script>
		$(document).ready(function() {
			var qqgroup = 'QQ群：462694081';
			$('.qq-group').text(qqgroup);
		});
	</script>
	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cscript src='"
						+ _bdhmProtocol
						+ "hm.baidu.com/h.js%3Fc8d13872a523d9c286aa7affbe0921f1' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<script src="public/js/h.js" type="text/javascript"></script>
</body>
</html>
