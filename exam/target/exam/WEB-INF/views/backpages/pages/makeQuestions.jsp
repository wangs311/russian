<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/skin.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/exam/static/backpages/css/table.css" />
    <style>
        .modal-body {
            max-height: 650px;
            overflow-y: scroll;
        }
    </style>
    <title>我要判卷</title>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 我要判卷 </nav>
<div class="page-container">

    <div class="cl pd-5 bg-1 bk-gray mt-20">  </div>
    <div class="mt-20">
        <div id="main">
            <div class="modal fade" id="demoModal" data-backdrop="static">
                <div class="modal-dialog" style="width: 800px;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" id="demoModalLabel">选择试卷</h4>
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
            <form action="#" method="post" class="basic-grey" id="question">

                <label>
                    <span class="text-r">请选择大题：</span>
                    <select id="questionsTypeId" name="questionsTypeId">
                        <option value=""></option>
                        <option value="07c14a5d-5759-421e-9434-cc4bcc9444e8">造句题</option>
                        <option value="2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae">作文题</option>
                        <option value="07aad1a5-d3c1-4f2d-b084-2be68fedc2a2">填空题</option>
                        <option value="517ada9e-465c-4c78-9551-9bfe52e4d1a6">选择题</option>
                        <option value="6167e20f-b0a8-4332-aa14-dd3dd1acda22">完型填空</option>
                        <option value="61ee983d-3fce-4e13-a146-ca72b5a5a82e">翻译题</option>
                    </select>
                </label>
                <label>
                    <span class="text-r">大题标题：</span>
                    <input class="questionsTitle"  placeholder="请输入大题题干。如：选择题。" type="text">
                </label>
                <label class="article" style="display: none;">
                    <span class="text-r">article：</span>
                    <textarea class="input questionsArticle"  style="width: 475px; height: 340px;resize:none;margin-left: 60px;" placeholder="请输入文章" type="text"></textarea>
                </label>
                <label>
                    <span>&nbsp;</span>
                    <input type="button" class="btn radius btn-primary size-L button" onclick="modaldemo()" value="下一步/增加小题" id="next"/>
                </label>

                <div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content radius">
                            <div class="modal-header">
                                <h3 class="modal-title">试题编辑</h3>
                                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
                            </div>
                            <div class="modal-body menu_form_body">

                            </div>
                            <div class="modal-footer">
                                <input class="btn btn-primary submit" type="button" name="确定" value="确定">
                                <input class="btn btn-primary" type="button" name="添加" value="添加下一题" id="add">
                                <%--<input class="btn btn-primary" type="button" name="删除" value="删除上一题" id="delete">--%>
                                <!-- <input class="btn" data-dismiss="modal" aria-hidden="true">关闭 -->
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/exam/static/backpages/js/jquery.min.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/layer.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/H-ui.min.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/H-ui.admin.js"></script>
<script type="text/javascript" src="/exam/static/backpages/js/table.js"></script>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
    function modaldemo() {
        $("#modal-demo").modal("show")
    }
    function together(event) {
        var index = $(event.target).parents("div").attr("index");
        $(".questionOutline" + index + "").val($(".choice-outline" + index + "").val() + "#" + $(".choice-a" +
                index + "").val() +
            "#" + $(".choice-b" + index + "").val() + "#" + $(".choice-c" + index + "").val() + "#" + $(
                ".choice-d" + index + "").val());
    }

</script>
</body>

</html>