<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC >
<html>

<head>
	<meta charset="utf-8">
	<title>登录</title>
	<link rel="stylesheet" href="static/frontpages/css/login.css" />
	<link rel="stylesheet" href="static/frontpages/css/common.css" />
	<link rel="stylesheet" href="static/frontpages/css/bootstrap.min.css" />
</head>

<body>
	<div class="wrap mask">
		<div id="header" class="row">
			<div id="header-content">
				<div id="logo" class="col-md-4"><img src="static/frontpages/images/logo.png" class="img-responsive"></div>
				<div id="sign" class="col-md-3">
					<div id="leaf"></div>
					<a href="##" id="login">返回首页</a>
				</div>
			</div>
		</div>
		<!--头部-->
	</div>
	<div id="LoginBox">
		<h1 class="row1">登录界面</h1>
		<form class="form-horizontal col-md-12" role="form" method="post" action="studentController/login">
			<div class="form-group">
				<lable class="col-md-2 control-label">
					学号：
				</lable>
				<div class="col-md-7">
					<input type="text" class="form-control" placeholder="请输入学号" name="studentNumber">
				</div>
			</div>
			<div class="form-group">
				<lable class="col-md-2 control-label">
					密码：
				</lable>
				<div class="col-md-7">
					<input type="password" class="form-control" placeholder="请输入密码" name="studentPassword">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-10">
					<input type="submit" name="submit" class="btn btn-deafault" id="submit" disabled="disabled">
					<input type="reset" name="reset" class="btn btn-deafault" id="reset">
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript" src="static/frontpages/js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="static/frontpages/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/frontpages/js/login.js"></script>
</body>

</html>