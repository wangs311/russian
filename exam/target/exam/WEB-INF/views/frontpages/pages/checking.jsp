<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
	<title>检查</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/exam/static/frontpages/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/exam/static/frontpages/css/common.css">
	<link rel="stylesheet" type="text/css" href="/exam/static/frontpages/css/checking.css">
</head>
<body>
<div id="header" >
	<div id="header-content">
		<div id="logo">
			<img src="/exam/static/frontpages/images/nenu-logo.png" class="img-responsive">
			<img src="/exam/static/frontpages/images/foreign-logo.png" class="img-responsive">
			<img src="/exam/static/frontpages/images/logo.png" class="img-responsive" style="margin-left: 40px;">
		</div>
		<div id="sign" >
			<div id="leaf"></div>
			<a href="/studentController/logout" id="login">登出</a>
		</div>
	</div>
</div>
<div id="main">
	<div id="examinationIda" style="display: none">${examinationId}</div>
	<div id="ida" style="display: none">${id}</div>
	<div id="left-main">
		<div id="nav">
		    <div id="xitileixing"><span>习题类型</span></div>
				<ul>
				</ul>
		</div>
		<div id="left-maincontent">
			<form id="que">

			</form>
		</div>
	</div>
	<div id="right-main">
		<div id="right-bottom">
			<div id="right-bottom-header">
			    所得成绩：<span id="que-score">0</span>
			</div>
			<div id="que-info">
			    <span>题目：</span><br/>
			</div>
			<a class="btn btn-default" href="http://localhost:8080/exam/ExaminationController/toIndex" id="toIndex">返回首页</a>
		</div>
	</div>
</div>
<script type="text/javascript" src="/exam/static/frontpages/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/exam/static/frontpages/js/checking.js"></script>

</body>
</html>
