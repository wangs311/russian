<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/skin.css" />
	<link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/style.css" />
	<title>俄语后台管理</title>
</head>

<body>
	<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs">俄语后台管理</a>
				<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			</div>
		</div>
	</header>
	<aside class="Hui-aside">
		<div class="menu_dropdown bk_2">


			<dl id="menu-makeQuestions">
				<dt><i class="Hui-iconfont">&#xe622;</i> <a data-href="/exam/backIndexController/toMakeQuestions" data-title="我要出题" href="javascript:void(0)">我要出题</a></dt>
			</dl>

			<dl id="menu-checkPaper">
				<dt><i class="Hui-iconfont">&#xe622;</i> <a data-href="/exam/backIndexController/toCheckPaper" data-title="我要判卷" href="javascript:void(0)">我要判卷</a></dt>
			</dl>

			<dl id="menu-makePaper">
				<dt><i class="Hui-iconfont">&#xe622;</i> <a data-href="/exam/backIndexController/toMakePaper" data-title="我要出卷" href="javascript:void(0)">我要出卷</a></dt>
			</dl>

			<dl id="menu-deleteQuestions">
				<dt><i class="Hui-iconfont">&#xe622;</i> <a data-href="/exam/backIndexController/toDeleteQuestions" data-title="试题删除" href="javascript:void(0)">试题删除</a></dt>
			</dl>
		</div>
	</aside>
	<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onclick="displaynavbar(this)"></a></div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active">
						<span title="我的桌面" data-href="welcome.html">后台管理首页</span>
						<em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a>
				<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display:none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="/exam/backIndexController/toWelcome"></iframe>
			</div>
		</div>
	</section>

	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前 </li>
			<li id="closeall">关闭全部 </li>
		</ul>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/exam/static/backpages/js/jquery.min.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/layer.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/exam/static/backpages/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

</body>

</html>