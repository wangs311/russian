$().ready(function () {
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

    //确认题型
    $("#typeSubmit").click(function () {
        $("#que").empty();//清空
        var unitIda = $("#medium option:selected").attr("id");
        var typeIda = $("#selectType option:selected").attr("id");
        $.ajax({
            type: "POST", //请求方式
            url: "/exam/backExaminationController/getQuestionsByType", //请求题目的地址
            dataType: "JSON",
            data:{
                unitId:unitIda,
                questionsTypeId:typeIda
            },
            cache: false,
            async: false,
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var titleStr = new Array();
                    var titleStra = new  Array();
                    var titleStrs = new  Array();
                    var titleLen = new Array();
                    titleStr[i] = data[i].questionsTitle;
                    titleLen[i] = titleStr[i].length;
                    titleStra[i] = titleStr[i].substring(0,titleStr[i].indexOf("。"));
                    titleStrs[i]= titleStr[i].substring(titleStr[i].indexOf("。"),titleLen[i]);
                    $("#que").append("<div class='nav-content' id='bigQuestion" + i + "'questionId = "+data[i].id+"><div class='que-type' index=''><span class='type-name'>"+titleStra[i]+"</span><span class='index'></span>"+ titleStrs[i]+"</div></div>");
                }
                // //循环出大题 将大题放到对应的小题中
                for (var j = 0; j < data.length; j++) {
                    if (data[j].questionsTypeId == "517ada9e-465c-4c78-9551-9bfe52e4d1a6") { //选择题
                        for (var h = 0; h < data[j].questionList.length; h++) {
                            $(".nav-content:eq(" + j + ")").append("<div class='ques choice'></div>");
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='que-number' mark=" + data[j].questionList[h].questionMark + " analysis=" + data[j].questionList[h].questionAnalysis + "></span>");
                            var outline = new Array();
                            outline[h] = data[j].questionList[h].questionOutline;
                            outline[h] = outline[h].split("#");
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='que'>" + outline[h][0] + "</span><br />");
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + outline[h][1] + '"><span class="ans ans-a">A. </span><span class="ans-content">' + outline[h][1] + '</span></label><br>');
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + outline[h][2] + '"><span class="ans ans-b">B. </span><span class="ans-content">' + outline[h][2] + '</span></label><br>');
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + outline[h][3] + '"><span class="ans ans-c">C. </span><span class="ans-content">' + outline[h][3] + '</span></label><br>');
                            if (outline[h][4]) {
                                $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + outline[h][4] + '"><span class="ans ans-d">D. </span><span class="ans-content">' +outline[h][4] + '</span></label><br>');
                            }
                        }
                    } else if (data[j].questionsTypeId == "07aad1a5-d3c1-4f2d-b084-2be68fedc2a2") { //填空题
                        for (var m = 0; m < data[j].questionList.length; m++) {
                            $(".nav-content:eq(" + j + ")").append("<div class='ques shortanswer'></div>");
                            $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='que-number' mark=" + data[j].questionList[m].questionMark + " analysis=" + data[j].questionList[m].questionAnalysis + "></span>");
                            $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='que'>" + data[j].questionList[m].questionOutline + "</span><br />");
                            $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='answer'>作答: </span><input type='text' name='" + data[j].questionList[m].id + "'>")
                        }
                    } else if (data[j].questionsTypeId == "61ee983d-3fce-4e13-a146-ca72b5a5a82e" ||data[j].questionsTypeId == "07c14a5d-5759-421e-9434-cc4bcc9444e8") { //俄译汉、造句题
                        for (var k = 0; k < data[j].questionList.length; k++) {
                            $(".nav-content:eq(" + j + ")").append("<div class='ques russiantochina'></div>");
                            $(".nav-content:eq(" + j + ")>.russiantochina:eq(" + k + ")").append("<span class='que-number' mark=" + data[j].questionList[k].questionMark + " analysis=" + data[j].questionList[k].questionAnalysis + "></span>");
                            $(".nav-content:eq(" + j + ")>.russiantochina:eq(" + k + ")").append("<span class='que'>" + data[j].questionList[k].questionOutline + "</span><br />");
                            $(".nav-content:eq(" + j + ")>.russiantochina:eq(" + k + ")").append("<span class='answer'>作答: </span><input type='text' name='" + data[j].questionList[k].id + "'>")
                        }
                    } else if (data[j].questionsTypeId == "2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae") { //作文
                        for (var n = 0; n < data[j].questionList.length; n++) {
                            $(".nav-content:eq(" + j + ")").append("<div class='ques article' mark=" + data[j].questionList[n].questionMark + " analysis=" + data[j].questionList[n].questionAnalysis + "></div>");
                            $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='que-number'></span>");
                            $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='que'>" + data[j].questionList[n].questionOutline + "</span><br />");
                            $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='answer'>请在下方区域作答: </span><textarea name='" + data[j].questionList[n].id + "' class='form-control' rows='3'/textarea>")
                        }
                    } else if (data[j].questionsTypeId == "6167e20f-b0a8-4332-aa14-dd3dd1acda22") { //完形填空
                        $(".nav-content:eq(" + j + " )").append("<p class='longarticle' style='width:89%;margin:2% auto 0 auto;'>" + data[j].questionsArticle + "</p>");
                        for (var p = 0; p < data[j].questionList.length; p++) {
                            $(".nav-content:eq(" + j + ")").append("<div class='ques articlechoice' mark=" + data[j].questionList[p].questionMark + " analysis=" + data[j].questionList[p].questionAnalysis + "></div>");
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='que-number'></span>");
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='que'></span><br />");
                            var articleoutline = new Array();
                            articleoutline[p] = data[j].questionList[p].questionOutline;
                            articleoutline[p] = articleoutline[p].split("#");
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + articleoutline[p][1] + '"><span class="ans ans-a">A. </span><span class="ans-content">' +  articleoutline[p][1] + '</span></label><br>');
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + articleoutline[p][2] + '"><span class="ans ans-b">B. </span><span class="ans-content">' +  articleoutline[p][2] + '</span></label><br>');
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + articleoutline[p][3] + '"><span class="ans ans-c">C. </span><span class="ans-content">' +  articleoutline[p][3] + '</span></label><br>');
                            if (articleoutline[p][4]) {
                                $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + articleoutline[p][4] + '"><span class="ans ans-d">D. </span><span class="ans-content">' +  articleoutline[p][4] + '</span></label><br>');
                            }
                        }
                    }
                }
            }
        });


        var queslen = document.getElementsByClassName("nav-content").length;
        for (var i = 0; i < queslen; i++) {
            $(".nav-content:eq(" + i + ")").attr("index", i);
            $(".index:eq(" + i + ")").html(i + 1);
            var strId = $(".type-name:eq(" + i + ")").html() + (i + 1).toString();
            $(".nav-content:eq(" + i + ")").attr("id", strId);
        }

        //选中试题
        $(".nav-content").click(function () {
            $(this).toggleClass("selected");
            var questionId = $(this).attr("questionId");
            var name = $(this).find(".type-name").html();
            var index = $(this).find(".index").html();
            str = name + index;
            console.log($(this).hasClass("selected"));
            if ($(this).hasClass("selected")) {
                $(".alreadyselect").append("<a questionId="+questionId+" class='btn btn-deafualt "+str+"' href=#"+str+" role='button'>"+str+"</a>");
            } else {
                $("."+str+"").remove();
            }
        });

    });

    //给后台传送确认选择的大题
    var ques = {
        "unitId": "",
        "examinationName":"",
        "questionsId":""
    }
    $("#already").click(function(){
        $('#alreadyModal').modal('show');
        $("#final-submit").click(function () {
            ques.unitId = $("#medium option:selected").attr("id");
            ques.examinationName = $("#examinationName").val();
            var count = $(".alreadyselect").children("a").length;
            for (var i = 0; i < count; i++){
                ques.questionsId += $(".alreadyselect>a:eq("+i+")").attr("questionId");
                if(i!=count-1){
                    ques.questionsId += "#";
                }
            }


            $.ajax({
                type: "POST", //请求方式
                url: "/exam/backExaminationController/addPaper", //题的接收的地址
                dataType: "JSON",
                data: {
                    list: JSON.stringify(ques),
                }
            })

             window.location.href="/exam/backIndexController/toMakePaper";
        });
    });
});