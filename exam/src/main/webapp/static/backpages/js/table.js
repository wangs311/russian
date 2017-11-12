$(function () {
    //刚开始的弹出框
    $('#demoModal').modal('show');
    $.ajax({
        type: "POST",
        url: "/exam/backExaminationController/edition", //册的地址
        dataType: "json",
        //请求成功后 将大范围的节点添加到第一个select中
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#large").append("<option id=" + data[i].id + " name=" + data[i].editionName + ">" + data[i].editionName + "</option>");
            }
        }
    });

    $("#large").change(function () {
        //清空第二个select的节点 不然会一直累计其中
        $("#medium").empty();
        $("#medium").removeAttr("disabled");
        $("#medium").append("<option>--请选择单元--</option>");
        var large = $("#large option:selected").attr("id");
        $.ajax({
            type: "POST",
            url: "/exam/backExaminationController/unit?editionId=" + large + "", //单元的地址
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    $("#medium").append("<option id=" + data[i].id + " name=" + data[i].id + ">" + data[i].unitName + "</option>");
                }
            },
            error: function (xhr) {
                console.log(xhr.status + ':' + xhr.statusText);
            }
        });
    });

    var titletype = $("#questionsTypeId").val();
    var count = 0;
    $("#questionsTypeId").change(function () {
        count = 0;
        titletype = $("#questionsTypeId").val();
        $("#title-content").html(titletype);
        if (titletype == "517ada9e-465c-4c78-9551-9bfe52e4d1a6") {//选择题
            $(".article").css("display", "none");
            $(".menu_form_body").empty();
            $(".menu_form_body").append('<div id="choice"></div>');
            $("#choice").append(
                '<div index="' + count +
                '"><label><span>题干：</span><textarea class="choice choice-outline' + count + '" onchange="together(event)" id="choice-outline" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><span>A：</span><input  class="choice choice-a' + count + '" onchange="together(event)" placeholder="请输入A选项" type="text"></label><label><span>B：</span><input class="choice choice-b' + count + '" onchange="together(event)" placeholder="请输入B选项" type="text"></label><label><span>C：</span><input class="choice choice-c' + count + '" onchange="together(event)" placeholder="请输入C选项" type="text"></label><label><span>D：</span><input class="choice choice-d' + count + '" onchange="together(event)" placeholder="请输入D选项" type="text"></label><label><span>解析：</span><textarea  class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>正确答案：</span><input class="questionAnswer' + count +
                '"  class="choice-answer" placeholder="请正确答案" type="text"></label><label><span>分值：</span><input class="questionMark' + count +
                '" class="choice-mark" placeholder="请输入分值" type="text"></label><label><input  style="display:none;" class="questionOutline' + count + '"></label><hr/></div>'
            );
        } else if (titletype == "07aad1a5-d3c1-4f2d-b084-2be68fedc2a2" || titletype == "07c14a5d-5759-421e-9434-cc4bcc9444e8" || titletype == "61ee983d-3fce-4e13-a146-ca72b5a5a82e") {//填空题、造句题、翻译
            $(".article").css("display", "none");
            $(".menu_form_body").empty();
            $(".menu_form_body").append('<div id="shortanswer"></div>');
            $("#shortanswer").append(
                '<div index="' + count +
                '"><label><span>题干：</span><textarea  class="questionOutline' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><span>正确答案：</span><textarea  class="questionAnswer' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入答案" type="text"></textarea></label><label><span>解析：</span><textarea  class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>分值：</span><input class="questionMark' + count + '"  placeholder="请输入分值" type="text"></label><hr/></div>'
            );
        } else if (titletype == "2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae") {//作文
            // $(".article").css("display", "block");
            $(".menu_form_body").empty();
            $(".menu_form_body").append('<div id="longanswer-huaxian"></div>');
            $("#longanswer-huaxian").append(
                '<div index="' + count + '"><label><span>题干：</span><textarea  class="questionOutline' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><label><span>正确答案：</span><textarea  class="questionAnswer' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入答案" type="text"></textarea></label><label><span>解析：</span><textarea  class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>分值：</span><input class="questionMark' + count + '"  placeholder="请输入分值" type="text"></label><hr/></div>'
            );
        } else if (titletype == "6167e20f-b0a8-4332-aa14-dd3dd1acda22") {//完形填空
            $(".article").css("display", "block");
            $(".menu_form_body").empty();
            $(".menu_form_body").append('<div id="choice"></div>');
            $("#choice").append(
                '<div index="' + count + '"><label><textarea style="display: none;" class="choice choice-outline' + count + '" onchange="together(event)" id="choice-outline" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><span>A：</span><input  class="choice choice-a' + count + '" onchange="together(event)" placeholder="请输入A选项" type="text"></label><label><span>B：</span><input class="choice choice-b' + count + '" onchange="together(event)" placeholder="请输入B选项" type="text"></label><label><span>C：</span><input class="choice choice-c' + count + '" onchange="together(event)" placeholder="请输入C选项" type="text"></label><label><span>D：</span><input class="choice choice-d' + count + '" onchange="together(event)" placeholder="请输入D选项" type="text"></label><label><span>解析：</span><textarea   class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>正确答案：</span><input class="questionAnswer' + count +
                '"  class="choice-answer" placeholder="请正确答案" type="text"></label><label><span>分值：</span><input class="questionMark' + count +
                '" class="choice-mark" placeholder="请输入分值" type="text"></label><label><input  style="display:none;" class="questionOutline' + count + '"></label><hr/></div>'
            );
        } else {
            $(".article").css("display", "none");
            $("#myform").children("div").css("display", "none");
        }
    });
    titletype = $("#questionsTypeId").val()
    $("#add").click(function () {
        count++;
        $("#number").val(count);
        if (titletype == "517ada9e-465c-4c78-9551-9bfe52e4d1a6") {
            $("#choice").append(
                '<br/><div index="' + count +
                '"><label><span>题干：</span><textarea class="choice choice-outline' + count + '" onchange="together(event)" id="choice-outline" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><span>A：</span><input  class="choice choice-a' + count + '" onchange="together(event)" placeholder="请输入A选项" type="text"></label><label><span>B：</span><input class="choice choice-b' + count + '" onchange="together(event)" placeholder="请输入B选项" type="text"></label><label><span>C：</span><input class="choice choice-c' + count + '" onchange="together(event)" placeholder="请输入C选项" type="text"></label><label><span>D：</span><input class="choice choice-d' + count + '" onchange="together(event)" placeholder="请输入D选项" type="text"></label><label><span>解析：</span><textarea class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>正确答案：</span><input class="questionAnswer' + count +
                '"  class="choice-answer" placeholder="请正确答案" type="text"></label><label><span>分值：</span><input class="questionMark' + count +
                '" class="choice-mark" placeholder="请输入分值" type="text"></label><label><input  style="display:none;" class="questionOutline' + count + '"></label><hr/></div>'
            )
        }else if(titletype == "6167e20f-b0a8-4332-aa14-dd3dd1acda22"){
            $("#choice").append(
                '<br/><div index="' + count + '"><label><textarea style="display: none;" class="choice choice-outline' + count + '" onchange="together(event)" id="choice-outline" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><span>A：</span><input  class="choice choice-a' + count + '" onchange="together(event)" placeholder="请输入A选项" type="text"></label><label><span>B：</span><input class="choice choice-b' + count + '" onchange="together(event)" placeholder="请输入B选项" type="text"></label><label><span>C：</span><input class="choice choice-c' + count + '" onchange="together(event)" placeholder="请输入C选项" type="text"></label><label><span>D：</span><input class="choice choice-d' + count + '" onchange="together(event)" placeholder="请输入D选项" type="text"></label><label><span>解析：</span><textarea class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>正确答案：</span><input class="questionAnswer' + count +
                '"  class="choice-answer" placeholder="请正确答案" type="text"></label><label><span>分值：</span><input class="questionMark' + count +
                '" class="choice-mark" placeholder="请输入分值" type="text"></label><label><input  style="display:none;" class="questionOutline' + count + '"></label><hr/></div>'
            )
        }else if (titletype == "07aad1a5-d3c1-4f2d-b084-2be68fedc2a2" || titletype == "07c14a5d-5759-421e-9434-cc4bcc9444e8" || titletype == "61ee983d-3fce-4e13-a146-ca72b5a5a82e") {
            $("#shortanswer").append(
                '<br/><div index="' + count +
                '"><label><span>题干：</span><textarea  class="questionOutline' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><span>正确答案：</span><textarea  class="questionAnswer' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入答案" type="text"></textarea></label><label><span>解析：</span><textarea  class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>分值：</span><input class="questionMark' + count + '"  placeholder="请输入分值" type="text"></label><hr/></div>'
            );
        } else if (titletype == "2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae") {
            $("#longanswer-huaxian").append(
                '<br><div index="' + count +
                '"><label><span>题干：</span><textarea  class="questionOutline' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入题干" type="text"></textarea></label><label><label><span>正确答案：</span><textarea  class="questionAnswer' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入答案" type="text"></textarea></label<span>解析：</span><textarea  class="questionAnalysis' + count + '" style="width: 475px; height: 80px;resize:none;" placeholder="请输入解析" type="text"></textarea></label><label><span>分值：</span><input class="questionMark' + count + '"  placeholder="请输入分值" type="text"></label><hr/></div>'
            )
        }
    });


    $("#delete").click(function () {
        count--;
        var counta = count - 1;
        $("#number").val(count);
        if (titletype == "517ada9e-465c-4c78-9551-9bfe52e4d1a6" || titletype == "6167e20f-b0a8-4332-aa14-dd3dd1acda22") {
            $("#choice div:eq(" + counta + ")").remove();
        } else if (titletype == "07aad1a5-d3c1-4f2d-b084-2be68fedc2a2" || titletype == "07c14a5d-5759-421e-9434-cc4bcc9444e8" ||
            titletype == "61ee983d-3fce-4e13-a146-ca72b5a5a82e") {
            $("#shortanswer div:eq(" + counta + ")").remove();
        } else if (titletype == "2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae") {
            $("#longanswer-huaxian div:eq(" + counta + ")").remove();
        }
    });

    $("#popup_exit1").click(function () {
        $("#reset").click();
    })

    //给后台传题
    var ques = [{
        "questionsTitle": "",
        "questionsArticle": "",
        "questionsTypeId": "",
        "questionsMark": "",
        "unitId": "",
        "questionList": []
    }]

    $(".submit").click(function () {
        var questionsTitle = $("#questionsTypeId option:selected").html();
        console.log(questionsTitle+"。"+$(".questionsTitle").val())
        ques[0].questionsTitle = questionsTitle+"。"+$(".questionsTitle").val();
        ques[0].questionsArticle = $(".questionsArticle").val();
        ques[0].questionsTypeId = $("#questionsTypeId").val();
        ques[0].unitId = $("#medium option:selected").attr("id");
        for (var i = 0; i <= count; i++) {
            ques[0].questionList[i] = {};
            ques[0].questionList[i].questionOutline = $(".questionOutline" + i + "").val();
            ques[0].questionList[i].questionAnswer = $(".questionAnswer" + i + "").val();
            ques[0].questionList[i].questionAnalysis = $(".questionAnalysis" + i + "").val();
            ques[0].questionList[i].questionMark = parseInt($(".questionMark" + i + "").val());
            ques[0].questionsMark += parseInt($(".questionMark" + i + "").val());
            ques[0].questionList[i].questionNumber = count;
        }

        $.ajax({
            type: "POST", //请求方式
            url: "/exam/backExaminationController/getNewQuestions", //题的请求的地址
            dataType: "JSON",
            data: {
                list: JSON.stringify(ques),
            }
        })

        window.location.href="/exam/backIndexController/toMakeQuestions";
    });


});