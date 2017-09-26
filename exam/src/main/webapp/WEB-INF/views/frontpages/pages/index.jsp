<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-cn">

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="/exam/static/frontpages/css/common.css" />
	<link rel="stylesheet" href="/exam/static/frontpages/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/exam/static/frontpages/css/index.css" />
	<title>俄语学习系统</title>
</head>

<body>
<div class="wrap">
	<div id="header" class="row">
		<div id="logo" class="col-md-4"><img src="/exam/static/frontpages/images/logo.png" class="img-responsive"></div>
		<div id="sign" class="col-md-3">
			<div id="leaf"></div>
			<a href="/studentController/logout" id="login">登出</a>
		</div>
	</div>
	<!--头部-->
	<div id="main">
		<div class="menu">
			<ul>
				<li id="test"><a href="#"><img src="/exam/static/frontpages/images/test2.png" id="test2"></a></li>
				<li id="liuyan"><a href="liuyan.html"><img src="/exam/static/frontpages/images/liuyan2.png"></a></li>
				<li id="info"><a href="personInfo.html"><img src="/exam/static/frontpages/images/info2.png"></a></li>
			</ul>

			<div class="modal fade" id="demoModal" data-backdrop="static">
				<div class="modal-dialog" style="width: 800px;">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title" id="demoModalLabel">选择试卷</h4>
						</div>
						<div class="modal-body" style="height: 245px;" id="changePersonInfo">
							<form method="post" >
								<label for="zhang">请选择册：</label>
								<select class="form-control" name="zhang" id="large">
									<option>--请选择册--</option>
								</select>
								<label for="ce">请选择单元：</label>
								<select class="form-control" name="ce" disabled="disabled" id="medium">

								</select>
								<label for="paper">请选试卷：</label>
								<select class="form-control" name="paper" disabled="disabled" id="small">

								</select>
								<input type="reset" id="reset" name="reset" style="display:none;">
								<input type="submit" id="submit" name="submit" style="display:none;">
							</form>
						</div>
						<!-- /.modal-body -->
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal" id="confirm">确认</button>
							<button type="button" class="btn btn-default" data-dismiss="modal" id="cancel">取消</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="/exam/static/frontpages/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/exam/static/frontpages/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/exam/static/frontpages/js/index.js"></script>

</html>