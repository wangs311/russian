$(function () {
    var examinationIda = $("#examinationIda").html();
    var ida = $("#ida").html();
    var finishAnswers;

    //请求题目
    $.ajax({
        type: "POST",
        url: "/exam/backExaminationController/getStudentPaper", //请求题目的地址
        async: false,
        data: {
            examinationId: examinationIda,
            id: ida
        },
        dataType: "JSON",
        //请求成功后 将大范围的节点添加到第一个select中
        success: function (data) {
            // console.log(data);
            // console.log(data.length);
            finishAnswers = data;
            for (var i = 0; i < data.length; i++) {
                var titleStr = new Array();
                var titleStra = new Array();
                var titleStrs = new Array();
                var titleLen = new Array();
                titleStr[i] = data[i].questionsTitle;
                titleLen[i] = titleStr[i].length;
                titleStra[i] = titleStr[i].substring(0, titleStr[i].indexOf("。"));
                titleStrs[i] = titleStr[i].substring(titleStr[i].indexOf("。"), titleLen[i]);
                // 将大题类型放到导航中
                $("#nav ul").append("<li class='nav-item'><a class='nav-href' to=" + titleStra[i] + ">" + titleStra[i] + "</a></li>");
                $("#que").append("<div class='nav-content' id='bigQuestion" + i + "'><div class='que-type'><span>" + titleStra[i]+titleStrs[i] + "</span></div></div>");

            }

            // //循环出大题 将大题放到对应的小题中
            for (var j = 0; j < data.length; j++) {
                if (data[j].questionsTypeId == "517ada9e-465c-4c78-9551-9bfe52e4d1a6") { //选择题
                    for (var h = 0; h < data[j].questionList.length; h++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques choice'></div>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='que-number' mark=" + data[j].questionList[h].questionMark + " analysis=" + data[j].questionList[h].questionAnalysis + "></span>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='que'>" + data[j].questionList[h].outline[0] + "</span><br />");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[1] + '"><span class="ans ans-a">A. </span><span class="ans-content">' + data[j].questionList[h].outline[1] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[2] + '"><span class="ans ans-b">B. </span><span class="ans-content">' + data[j].questionList[h].outline[2] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[3] + '"><span class="ans ans-c">C. </span><span class="ans-content">' + data[j].questionList[h].outline[3] + '</span></label><br>');
                        if (data[j].questionList[h].outline[3]) {
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[4] + '"><span class="ans ans-d">D. </span><span class="ans-content">' + data[j].questionList[h].outline[4] + '</span></label><br>');
                        }
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='answer-choice'>学生答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[h].id + "' value='"+data[j].questionList[h].finishAnswer.finishAnswerContent+"'><br>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='answer'>正确答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[h].id + "' value='"+data[j].questionList[h].questionAnswer+"'><br>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='answer'>本题满分: </span><input type='text' disabled='disabled' name='" + data[j].questionList[h].id + "' value='"+data[j].questionList[h].questionMark+"'><br>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='answer'>学生得分: </span><input class='mark' disabled='disabled' type='text' disabled='disabled' name='" + data[j].questionList[h].id + "' value='"+data[j].questionList[h].finishAnswer.finishAnswerMark+"'>");
                        if(data[j].questionList[h].finishAnswer.finishAnswerContent == 0){
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='right'></span>")
                        }else{
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='wrong'></span>")
                        }

                    }
                } else if (data[j].questionsTypeId == "07aad1a5-d3c1-4f2d-b084-2be68fedc2a2"||data[j].questionsTypeId == "61ee983d-3fce-4e13-a146-ca72b5a5a82e" || data[j].questionsTypeId == "07c14a5d-5759-421e-9434-cc4bcc9444e8") { //填空题、俄译汉、造句题
                    for (var m = 0; m < data[j].questionList.length; m++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques shortanswer'></div>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='que-number' mark=" + data[j].questionList[m].questionMark + "></span>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='que'>" + data[j].questionList[m].questionOutline + "</span><br />");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='answer'>学生答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[m].id + "' value='"+data[j].questionList[m].finishAnswer.finishAnswerContent+"'><br>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='answer'>正确答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[m].id + "' value='"+data[j].questionList[m].questionAnswer+"'><br>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='answer'>本题满分: </span><input type='text' disabled='disabled' name='" + data[j].questionList[m].id + "' value='"+data[j].questionList[m].questionMark+"'><br>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='answer'>老师评分: </span><input class='mark' type='text' name='" + data[j].questionList[m].id + "'>");
                    }
                }

                else if (data[j].questionsTypeId == "2c9903c4-d9ac-49f9-ab28-cf4a8fe906ae") { //作文
                    for (var n = 0; n < data[j].questionList.length; n++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques article' mark=" + data[j].questionList[n].questionMark + "></div>");
                        $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='que-number'></span>");
                        $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='que'>" + data[j].questionList[n].questionOutline + "</span><br />");
                        $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='answer'>学生答案: </span><textarea disabled='disabled' name='" + data[j].questionList[n].id + "' class='form-control' rows='3'>"+data[j].questionList[n].finishAnswer.finishAnswerContent+"</textarea><br>");
                        $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='answer'>正确答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[n].id + "' value='"+data[j].questionList[n].questionAnswer+"'><br>");
                        $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='answer'>本题满分: </span><input type='text' disabled='disabled' name='" + data[j].questionList[n].id + "' value='"+data[j].questionList[n].questionMark+"'><br>");
                        $(".nav-content:eq(" + j + ")>.article:eq(" + n + ")").append("<span class='answer'>老师评分: </span><input class='mark' type='text' name='" + data[j].questionList[n].id + "'>")
                    }
                } else if (data[j].questionsTypeId == "6167e20f-b0a8-4332-aa14-dd3dd1acda22") { //完形填空
                    $(".nav-content:eq(" + j + " )").append("<p class='longarticle'>" + data[j].questionsArticle + "</p>");
                    for (var p = 0; p < data[j].questionList.length; p++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques articlechoice' mark=" + data[j].questionList[p].questionMark + " analysis=" + data[j].questionList[p].questionAnalysis + "></div>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='que-number'></span>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='que'></span><br />");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[0] + '"><span class="ans ans-a">A. </span><span class="ans-content">' + data[j].questionList[p].outline[1] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[1] + '"><span class="ans ans-b">B. </span><span class="ans-content">' + data[j].questionList[p].outline[2] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[2] + '"><span class="ans ans-c">C. </span><span class="ans-content">' + data[j].questionList[p].outline[3] + '</span></label><br>');
                        if (data[j].questionList[p].outline[3]) {
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input disabled="disabled" type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[3] + '"><span class="ans ans-d">D. </span><span class="ans-content">' + data[j].questionList[p].outline[3] + '</span></label><br>');
                        }
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='answer'>学生答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[p].id + "' value='"+data[j].questionList[p].finishAnswer.finishAnswerContent+"'><br>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='answer'>正确答案: </span><input type='text' disabled='disabled' name='" + data[j].questionList[p].id + "' value='"+data[j].questionList[p].questionAnswer+"'><br>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='answer'>本题满分: </span><input type='text' disabled='disabled' name='" + data[j].questionList[p].id + "' value='"+data[j].questionList[p].questionMark+"'><br>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='answer'>学生得分: </span><input class='mark' type='text' disabled='disabled' name='" + data[j].questionList[p].id + "' value='"+data[j].questionList[p].finishAnswer.finishAnswerMark+"'>")
                        if(data[j].questionList[p].finishAnswer.finishAnswerContent == 0){
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='right'></span>")
                        }else{
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='wrong'></span>")
                        }

                    }
                }
            }
        }
    });

    var ques = document.getElementsByClassName("ques").length;
    console.log(ques);
    $("#finalSubmit").click(function () {
        for (var w = 0; w < finishAnswers.length; w++) {
            for (var y = 0; y < finishAnswers[w].questionList.length; y++) {
                for (var u = 0; u <ques; u++) {
                    var inputId = $(".ques:eq(" + u + ") input").attr("name");
                    var textareaId = $(".ques:eq(" + u + ") textarea").attr("name");
                    if (textareaId == finishAnswers[w].questionList[y].id) {
                        finishAnswers[w].questionList[y].studentMark = parseInt($(".mark:eq(" + u + ")").val());
                    } else if (inputId == finishAnswers[w].questionList[y].id) {
                        finishAnswers[w].questionList[y].studentMark = parseInt($(".mark:eq(" + u + ")").val());
                    }
                }
            }
        }
        console.log(finishAnswers);

        $.ajax({
            type: "POST", //请求方式
            data: {
                list: JSON.stringify(finishAnswers),
            },
            url: "/exam/backExaminationController/judgeOk", //请求的地址
            dataType: "json",
            success:function(x){
                console.log(x);
            }
        });

         window.location.href="/exam/backIndexController/toCheckPaper";
    });

});