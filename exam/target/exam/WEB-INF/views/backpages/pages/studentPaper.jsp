<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/skin.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/exam.css" />
	<title>学生试卷</title>
</head>

<body>
	<div id="examinationIda" style="display: none">${examinationId}</div>
	<div id="ida" style="display: none">${id}</div>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 我要判卷 <span class="c-gray en">&gt;</span> </nav>
	<div class="page-container">

		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<button class="btn btn-primary" id="finalSubmit">提交</button>
		</div>
		<div class="mt-20" id="main">
			<div id="left-main">
				<div id="nav">
					<ul>
					</ul>
				</div>
				<div id="left-maincontent">
					<form id="que" >
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/exam/static/backpages/js/jquery.min.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/layer.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/H-ui.admin.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/exam.js"></script>
	<!--/_footer /作为公共模版分离出去-->



</body>

</html>