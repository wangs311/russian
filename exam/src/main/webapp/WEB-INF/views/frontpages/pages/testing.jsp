<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>

<head>
	<title>测试</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/exam/static/frontpages/css/testing.css">
	<link rel="stylesheet" type="text/css" href="/exam/static/frontpages/css/common.css">
	<link rel="stylesheet" type="text/css" href="/exam/static/frontpages/css/bootstrap.min.css">
</head>

<body>
	<div id="examinationId" style="display:none;"></div>
	<div id="header" class="row">
		<div id="logo" class="col-md-4"><img src="/exam/static/frontpages/images/logo.png" class="img-responsive"></div>
		<div id="sign" class="col-md-3">
			<div id="leaf"></div>
			<a href="/studentController/logout" id="login">登出</a>
		</div>
	</div>
	<div id="main">
		<div id="border"></div>
		<div id="left-main">
			<div id="nav">
				<div id="xitileixing"><span>习题类型</span></div>
				<ul>
				</ul>
			</div>
			<div id="left-maincontent" class="content">
				<form id="que">
					
				</form>
			</div>
		</div>
		<div id="right-main">
			<div class="time-item">
				<span id="time-icon"></span>
				<span id="hour_show">0时</span>
				<span id="minute_show">0分</span>
				<span id="second_show">0秒</span>
			</div>
			<div id="right-bottom">
				<div id="right-bottom-header">
					<div id="que-situation">已完成：
						<span id="que-already">0</span>/
						<span id="que-total"></span>
					</div>
				</div>
				<div id="que-info">
					<span>已做题目信息：</span><br/>
				</div>
				<input type="button" name="button" id="button" value="交卷" data-toggle="modal" data-target="#demoModalagain">
			</div>
		</div>
	</div>

	<div class="modal fade" id="demoModal" data-backdrop="static">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="demoModalLabel">确认要开始答卷了吗？</h4>
				</div>
				<div class="modal-body" style="height: 120px;" id="doyouready">

				</div>
				<!-- /.modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="start">开始答卷</button>
					<button type="button" class="btn btn-default" onclick="window.history.back(-1);">取消答卷</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div class="modal fade" id="demoModalagain" data-backdrop="static">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" >系统提示</h4>
				</div>
				<div class="modal-body" style="height: 120px;" id="whensubmit">

				</div>
				<!-- /.modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="submit">提交答卷</button>
					<button type="button" class="btn btn-default" onclick="$('#demoModalagain').modal('hide');">取消提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div class="modal fade" id="ModalTimeOut" data-backdrop="static">
		<div class="modal-dialog" style="width: 400px;">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" >系统提示</h4>
				</div>
				<div class="modal-body" style="height: 120px;">
					时间到！系统将自动提交试卷！
				</div>
				<!-- /.modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" onclick="submitTo()">确认</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<script type="text/javascript" src="/exam/static/frontpages/js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="/exam/static/frontpages/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/exam/static/frontpages/js/testing.js"></script>
</body>

</html>