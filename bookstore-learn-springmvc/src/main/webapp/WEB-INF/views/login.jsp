<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<head>
<title>58登录</title>
<meta charset="utf-8">
<link rel="stylesheet" href="../resources/reset.css">
<link rel="stylesheet" href="../resources/style.css">
</head>
<body>
	<form id="f" action="/login" method="post">
		<div class="body" id="body" style="background-size: 1440px auto;">
			<div class="bottom"></div>
		</div>
		<div class="main">
			<div class="logo"></div>
			<div class="word1">统一登录平台</div>
			<div class="inputBox">
				<div class="putBox">
					<input id="username" name="username" class="itext" tabindex="1"
						placeholder="请输入用户名" accesskey="n" autocomplete="off" type="text">
				</div>
				<div class="putBox" style="margin-top: 20px">
					<input id="password" name="password" class="ipassword" tabindex="2"
						placeholder="请输入密码" accesskey="p" value="" autocomplete="off"
						type="password">
				</div>
				<!-- 开启防止CSRF攻击 -->
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
				

				<button class="loginPut ibutton" type="submit">登录</button>

				<div class="passWord2">
					<span><a href="http://rp.sso.58.com/rpwd/refindpwd">忘记密码？</a></span>
				</div>
			</div>
		</div>
		<div></div>
	</form>

	<script src="../resources/jquery-1.js"></script>
	<script src="../resources/jsencrypt.js"></script>
	<script src="../resources/js.js"></script>

	<script src="../resources/fingerprint2.js"></script>
	<script language="JavaScript">
		var options = {
			excludeColorDepth : true,
			excludeScreenResolution : true,
			excludeAvailableScreenResolution : true,
			excludeAddBehavior : true,
			excludeDoNotTrack : true,
			excludeAdBlock : true,
			excludeJsFonts : true,
			excludePlugins : true,
			excludeIEPlugins : true,
			excludeTouchSupport : true
		};

		new Fingerprint2(options).get(function(result) {
			//console.log(result);
			document.getElementById("fingerPrint").value = result;
		});

		function login() {
			$.ajax({
				type : "post",
				url : "resources/getPublicKey",
				data : "",
				async : false,
				success : function(key) {
					var encryption = new JSEncrypt();
					encryption.setPublicKey(key);
					var encryptedPassword = encryption.encrypt($("#password")
							.val());
					$("#password").val(encryptedPassword);
					$("#fm1").submit();
				}
			});
		}
	</script>

</body>
</html>