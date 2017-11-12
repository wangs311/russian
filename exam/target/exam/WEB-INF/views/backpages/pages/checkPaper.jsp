<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/skin.css" />
    <title>我要判卷</title>
</head>

<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 我要判卷 </nav>
    <div class="page-container">

        <div class="cl pd-5 bg-1 bk-gray mt-20">
            <select id="selectUnit" name="questionsTypeId" class="form-control" style="display: inline-block;width: 30%;">
                <option value="">请选择单元</option>
            </select>
            <select id="finish-alreay" name="finish-alreay" class="form-control" style="display: inline-block;width: 30%;">
                <option value="">请选择类型</option>
                <option id="0">未判过</option>
                <option id="1">已判过</option>
            </select>
            <button type="button" class="btn btn-primary" id="unitSubmit">确定</button>
        </div>
        <div class="mt-20">
            <table class="table table-border table-bordered table-hover table-bg table-sort">
            </table>
        </div>
    </div>

    <!--_footer 作为公共模版分离出去-->
    <script type="text/javascript" src="/exam/static/backpages/js/jquery.min.js"></script>
    <script type="text/javascript" src="/exam/static/backpages/js/layer.js"></script>
    <script type="text/javascript" src="/exam/static/backpages/js/H-ui.min.js"></script>
    <script type="text/javascript" src="/exam/static/backpages/js/H-ui.admin.js"></script>
    <!--/_footer /作为公共模版分离出去-->
    <script type="text/javascript" src="/exam/static/backpages/js/checkPaper.js"></script>
    <%--<script type="text/javascript" src="/exam/static/backpages/js/exam.js"></script>--%>

</body>

</html>