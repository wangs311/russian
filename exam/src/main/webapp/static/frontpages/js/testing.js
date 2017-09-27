$(function () {
    /*得到题目数据*/
    var finishAnswers;
    var url = document.location.href.split("=")[1];
    $.ajax({
        type: "POST", //请求方式
        url: "http://localhost:8080/exam/ExaminationController/toExamination?examinationId=" + url + "", //请求的地址
        datatype: "json",
        cache: false,
        async: false,
        success: function (data) {
            finishAnswers = data;
            console.log(finishAnswers);
            // var data =(new Function("","return "+x))();
            for (var i = 0; i < data.length; i++) {
                // 将大题类型放到导航中
                $("#nav ul").append("<li class='nav-item'><a class='nav-href' to=" + data[i].questionsTitle + ">" + data[i].questionsTitle + "</a></li>");
                $("#que").append("<div class='nav-content' id='bigQuestion" + i + "'><div class='que-type'><span>" + data[i].questionsTitle + "</span></div></div>");
            }

            // //循环出大题 将大题放到对应的小题中
            for (var j = 0; j < data.length; j++) {
                if (data[j].questionsTypeId == "517ada9e-465c-4c78-9551-9bfe52e4d1a6") { //选择题
                    for (var h = 0; h < data[j].questionList.length; h++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques choice'></div>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='que-number' mark=" + data[j].questionList[h].questionMark + " analysis=" + data[j].questionList[h].questionAnalysis + "></span>");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append("<span class='que'>" + data[j].questionList[h].outline[0] + "</span><br />");
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[1] + '"><span class="ans ans-a">A. </span><span class="ans-content">' + data[j].questionList[h].outline[1] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[2] + '"><span class="ans ans-b">B. </span><span class="ans-content">' + data[j].questionList[h].outline[2] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[3] + '"><span class="ans ans-c">C. </span><span class="ans-content">' + data[j].questionList[h].outline[3] + '</span></label><br>');
                        if (data[j].questionList[h].outline[3]) {
                            $(".nav-content:eq(" + j + ")>.choice:eq(" + h + ")").append('<label><input type="radio" name="' + data[j].questionList[h].id + '" value="' + data[j].questionList[h].outline[4] + '"><span class="ans ans-d">D. </span><span class="ans-content">' + data[j].questionList[h].outline[4] + '</span></label><br>');
                        }
                    }
                } else if (data[j].questionsTypeId == "07aad1a5-d3c1-4f2d-b084-2be68fedc2a2") { //填空题
                    for (var m = 0; m < data[j].questionList.length; m++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques shortanswer'></div>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='que-number' mark=" + data[j].questionList[m].questionMark + " analysis=" + data[j].questionList[m].questionAnalysis + "></span>");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='que'>" + data[j].questionList[m].questionOutline + "</span><br />");
                        $(".nav-content:eq(" + j + ")>.shortanswer:eq(" + m + ")").append("<span class='answer'>作答: </span><input type='text' name='" + data[j].questionList[m].id + "'>")
                    }
                } else if (data[j].questionsTypeId == "61ee983d-3fce-4e13-a146-ca72b5a5a82e") { //俄译汉
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
                    $(".nav-content:eq(" + j + " )").append("<p class='longarticle'>" + data[j].questionsArticle + "</p>");
                    for (var p = 0; p < data[j].questionList.length; p++) {
                        $(".nav-content:eq(" + j + ")").append("<div class='ques articlechoice' mark=" + data[j].questionList[p].questionMark + " analysis=" + data[j].questionList[p].questionAnalysis + "></div>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='que-number'></span>");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append("<span class='que'>" + data[j].questionList[p].questionOutline + "</span><br />");
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[0] + '"><span class="ans ans-a">A. </span><span class="ans-content">' + data[j].questionList[p].outline[1] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[1] + '"><span class="ans ans-b">B. </span><span class="ans-content">' + data[j].questionList[p].outline[2] + '</span></label><br>');
                        $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[2] + '"><span class="ans ans-c">C. </span><span class="ans-content">' + data[j].questionList[p].outline[3] + '</span></label><br>');
                        if (data[j].questionList[p].outline[3]) {
                            $(".nav-content:eq(" + j + ")>.articlechoice:eq(" + p + ")").append('<label><input type="radio" name="' + data[j].questionList[p].id + '" value="' + data[j].questionList[p].outline[3] + '"><span class="ans ans-d">D. </span><span class="ans-content">' + data[j].questionList[p].outline[3] + '</span></label><br>');
                        }
                    }
                }
                // else if (data.questionsList[j].questionsTypeId == 2) { //划线句翻译
                //     for (var q = 0; q < data[j].questionlist.length; q++) {
                //         $(".nav-content:eq(" + j + ")").append("<div class='ques shortanswer' mark=" + data[j].questionlist[q].questionMark + " analysis=" + data[j].questionlist[q].questionAnalysis + "></div>");
                //         $(".ques:eq(" + j + ")").append("<div class=tran-article'>" + data[j].questionlist[q].article + "</div>");
                //         $(".ques:eq(" + j + ")").append("<span class='que-number'></span>");
                //         $(".ques:eq(" + j + ")").append("<span class='que'>" + data[j].questionlist[q].questionOutline + "</span><br />");
                //         $(".ques:eq(" + j + ")").append("<span class='answer'>作答: </span><input type='text' name='studentSubjectiveAnswer'>")
                //     }
                // }
            }
        }
    });

    /*最开始出现的模态框*/
    $('#demoModal').modal('show');
    var ques = document.getElementsByClassName("ques").length;
    var mins = 10;
    var str = "本次考试共有" + ques + "道小题。答题时间为" + mins + "分钟。确定开始答卷吗？"
    $("#doyouready").html(str);
    // if(!(confirm(str))){
    //     window.history.back(-1);
    // }
    /*计时*/
    var intDiff = parseInt(turnToSeconds(mins)); //倒计时总秒数量
    var leftime = true;

    function timer(intDiff) {
        window.setInterval(function () {
            var day = 0,
                hour = 0,
                minute = 0,
                second = 0; //时间默认值
            if (intDiff > 0) {
                day = Math.floor(intDiff / (60 * 60 * 24));
                hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
            } else {
                leftime = false;
                /*时间到自动挡提交试卷*/
                if (!leftime) {
                    // $("#button").attr("onclick","");
                    // alert("时间到！系统将自动提交试卷！")
                    // $("#button").click();
                    $("#ModalTimeOut").modal('show');
                    leftime = "hasDone";
                }
            }
            if (minute <= 9) minute = '0' + minute;
            if (second <= 9) second = '0' + second;
            $('#hour_show').html('<s id="h"></s>' + hour + '时');
            $('#minute_show').html('<s></s>' + minute + '分');
            $('#second_show').html('<s></s>' + second + '秒');
            intDiff--;
        }, 1000);
    }

    function turnToSeconds(mins) {
        return mins * 60;
    }
    /*开始答卷后触发*/
    $("#start").on('click', function () {
        timer(intDiff);
    });

    /*灵活的题型导航 */
    var navhref = document.getElementsByClassName("nav-href");
    var navcontent = document.getElementsByClassName("nav-content");
    var hrefto = [];
    for (var hr = 0; hr < navhref.length; hr++) {
        hrefto[hr] = navhref[hr].getAttribute("to");
        navcontent[hr].setAttribute("id", hrefto[hr]);
        hrefto[hr] = "#" + hrefto[hr];
        navhref[hr].setAttribute("href", hrefto[hr]);
    }

    /*为每道题增加index和id属性 给每道题写题号 为每道题增加对应的右侧按钮 */
    function addId() {
        var ques = document.getElementsByClassName("ques");
        for (var i = 0; i < ques.length; i++) {
            ques[i].setAttribute("index", i + 1);
            var index = ques[i].getAttribute("index");
            var id = "que" + index;
            ques[i].setAttribute("id", id);
            $(".que-number")[i].innerHTML = i + 1 + ".  ";
            var tihao = i + 1;
            $("#que-info").append("<a class='buttons' href='javascript:void(0);' index=" + tihao + ">" + tihao + "</a>")
        }
    }
    addId();


    /*习题类型导航选中样式*/
    $(".nav-item").click(function () {
        $(this).addClass("nav-item-selected");
        $(this).siblings().removeClass("nav-item-selected");
    })



    /*单选题*/
    $(".choice").on('click', checkChoice);
    $(".articlechoice").on('click', checkChoice);

    function checkChoice() {
        var inputs = this.getElementsByTagName("input");
        var index = this.getAttribute("index");
        var buttons = document.getElementsByClassName("buttons");
        for (var i = 0; i < inputs.length; i++) {
            if (inputs[i].checked) {
                buttons[index - 1].setAttribute("class", "buttons already");
            }
        }
        queDoneNumber();
    }
    /*多选题*/
    $(".multi-choice").on('click', checkMulitchoice);

    function checkMulitchoice() {
        var inputs = this.getElementsByTagName("input");
        var index = inputs[0].getAttribute("name");
        var buttons = document.getElementsByClassName("buttons");
        var isChecked = 0;
        for (var i = 0; i < inputs.length; i++) {
            if (inputs[i].checked) {
                //buttons[index-1].setAttribute("class","buttons already");
                $(".buttons:eq(" + index - 1 + ")").addClass("already");
                break;
            } else {
                buttons[index - 1].setAttribute("class", "buttons");
            }
        }
        queDoneNumber();
    }
    /*简答题*/
    $(".shortanswer").on('keyup', checkShortanswer);
    $(".russiantochina").on('keyup', checkShortanswer);

    function checkShortanswer() {
        var texts = this.getElementsByTagName("input");
        var index = this.getAttribute("index");
        var buttons = document.getElementsByClassName("buttons");
        if (texts[0].value.length) {
            buttons[index - 1].setAttribute("class", "buttons already");
        } else {
            buttons[index - 1].setAttribute("class", "buttons");
        };
        queDoneNumber();
    }
    /*长答题*/

    $(".article").on('keyup', checklonganswer);

    function checklonganswer() {
        var texts = this.getElementsByTagName("textarea");
        var index = this.getAttribute("index");
        var buttons = document.getElementsByClassName("buttons");
        if (texts[0].value.length) {
            buttons[index - 1].setAttribute("class", "buttons already");
        } else {
            buttons[index - 1].setAttribute("class", "buttons");
        };
        queDoneNumber();
    }
    /*已完成的题目数量及提交按钮*/
    var queTotal = document.getElementsByClassName("ques").length;
    $("#que-total").html(queTotal);

    function queDoneNumber() {
        var count = 0;
        var buttons = document.getElementsByClassName("buttons");
        for (var k = 0; k < buttons.length; k++) {
            if (buttons[k].getAttribute("class") == "buttons already") {
                ++count;
            }
        }
        $("#que-already").html(count);

        var queLeft = buttons.length - count;
        var str1 = "已完成" + count + "道题。还有" + queLeft + "道题未完成。确认要交卷吗？";
        $("#whensubmit").html(str1);
    }
    queDoneNumber();



    /*为每个按钮增加导航*/
    $(".buttons").click(function () {
        var h1 = $(".ques").eq(0).offset().top;
        var index = $(this).index();
        var hx = $(".ques").eq(index - 2).offset().top;
        var move;
        if (h1 > 0 && hx > 0) {
            move = hx - h1;
        } else if (h1 < 0 && hx > 0) {
            move = hx - h1;
        } else if (h1 < 0 && hx < 0) {
            move = Math.abs(h1) - Math.abs(hx);
        }
        $("#left-maincontent").scrollTop(move);

    });

    /*单选、多选后添加样式*/
    $(":radio").on("click", function () {
        $(this).parent("label").addClass("selected")
            .siblings().removeClass("selected");

    });
    $(":checkbox").on("click", function () {
        var hascheck = $(this).is(":checked");
        if (!(hascheck)) {
            $(this).parent("label").removeClass("selected");
        } else {
            $(this).parent("label").addClass("selected");
        }
    });

    /*调整高度*/
    var winHeight = $(document).height();
    var leftHeight = winHeight - 226;
    $("#left-maincontent").height(leftHeight);
    $("#right-bottom").height(leftHeight);
    $("#button").css("top", winHeight - 60);
    /*调整宽度*/
    var winWidth = $(document).width();
    var leftWidth = winWidth * 0.6;
    // $("#sign").css("margin-left",leftWidth);


    /*做完题向后台传送数据*/
    $("#submit").on("click", function () {
        for (var w = 0; w < finishAnswers.length; w++) {
            for (var y = 0; y < finishAnswers[w].questionList.length; y++) {
                for (var u = 0; u < ques; u++) {
                    var inputId = $(".ques:eq(" + u + ") input").attr("name");
                    var textareaId = $(".ques:eq(" + u + ") textarea").attr("name");
                    if (textareaId == finishAnswers[w].questionList[y].id) {
                        finishAnswers[w].questionList[y].finishAnswer = $(".ques:eq(" + u + ") textarea").val();
                    } else if (inputId == finishAnswers[w].questionList[y].id) {
                        finishAnswers[w].questionList[y].finishAnswer = $(".ques:eq(" + u + ") input").val();
                    }
                }
            }
        }
        console.log(finishAnswers);
        $.ajax({
            type: "POST", //请求方式
            data: {
                "answer": JSON.stringify(finishAnswer)
            },
            // data:$('#que').serialize(),
            url: "http://localhost:8080/exam/bg/front_exam?to=add_student_done", //请求的地址
            dataType: "json",
            cache: false,
            async: false
        });
    });
});