<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/makePaper.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/exam.css" />
    <title>试题删除</title>
</head>

<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 试题删除
</nav>
<div class="page-container">
    <div class="modal fade" id="demoModal" data-backdrop="static">
        <div class="modal-dialog" style="width: 800px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="demoModalLabel">选择删除题目范围</h4>
                </div>
                <div class="modal-body" style="height: 245px;" id="changePersonInfo">
                    <form method="post">
                        <label for="zhang">请选择册：</label>
                        <select class="form-control" name="zhang" id="large">
                            <option>--请选择册--</option>
                        </select>
                        <label for="ce">请选择单元：</label>
                        <select class="form-control" name="ce" disabled="disabled" id="medium">

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
    <div class="cl pd-5 bg-1 bk-gray mt-20"></div>
    <div class="mt-20">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary mt-20">
                    <div class="panel-header">题库</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-2">
                                <select id="selectType" name="questionsTypeId" class="form-control">
                                    <option value="">请选择题型</option>
                                    <option id="07c14a5d-5759-421e-9434-cc4bcc9444e8">造句题</option>
                                    <option id="2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae">作文题</option>
                                    <option id="07aad1a5-d3c1-4f2d-b084-2be68fedc2a2">填空题</option>
                                    <option id="517ada9e-465c-4c78-9551-9bfe52e4d1a6">选择题</option>
                                    <option id="6167e20f-b0a8-4332-aa14-dd3dd1acda22">完型填空</option>
                                    <option id="61ee983d-3fce-4e13-a146-ca72b5a5a82e">翻译题</option>
                                </select>

                            </div>
                            <div class="col-md-4">
                                <button type="button" class="btn btn-default col-md-2" id="typeSubmit">确认</button>
                            </div>
                        </div>
                        <div id="left-maincontent">
                            <div id="que">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/exam/static/backpages/js/jquery.min.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/layer.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/H-ui.min.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/jquery-ui.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/deleteQuestions.js"></script>
<!--/_footer /作为公共模版分离出去-->

</body>

</html>