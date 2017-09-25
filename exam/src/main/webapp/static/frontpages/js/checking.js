$(function(){
    var ques = document.getElementsByClassName("ques");

    // $.ajax({
    //     type:"GET",
    //    url:"/russian test/js/test2.json",
    //     datatyps:"json",
    //     success:function(data){
    //         for(var i = 0;i<data.questionsList.length;i++){
    //            // 将大题类型放到导航中
    //             $("#nav ul").append("<li class='nav-item'><a class='nav-href' to=" + data.questionsList[i].questionsTitle + ">" + data.questionsList[i].questionsTitle + "</a></li>" );
    //             $("#que").append("<div class='nav-content'><div class='que-type'><span>"+data.questionsList[i].questionsTitle+"</span>题</div></div>");
    //         }
    //          //循环出大题 将大题放到对应的小题中
    //         for(var j=0;j<data.questionsList.length;j++){
    //             if(data.questionsList[j].questionsTypeId == "a"){//选择题
    //                 for(var h=0;h<data.questionsList[j].questionlist.length;h++){
    //                     $(".nav-content:eq("+j+")").append("<div class='ques choice' id="+data.questionsList[j].questionlist[h].id+"></div>");
    //                     $(".choice:eq("+h+")").append("<span class='que-number' mark="+data.questionsList[j].questionlist[h].questionMark+" analysis="+data.questionsList[j].questionlist[h].questionAnalysis+"></span>");
    //                     $(".choice:eq("+h+")").append("<span class='que'>"+data.questionsList[j].questionlist[h].outline[0]+"</span><br />");
    //                     $(".choice:eq("+h+")").append('<label><input type="radio" name="'+ data.questionsList[j].questionlist[h].questionNumber +'" value="'+data.questionsList[j].questionlist[h].outline[1]+'"><span class="ans ans-b">'+data.questionsList[j].questionlist[h].outline[1]+'.</span><span class="ans-content">'+data.questionsList[j].questionlist[h].outline[1]+'</span></label><br>');
    //                     $(".choice:eq("+h+")").append('<label><input type="radio" name="'+ data.questionsList[j].questionlist[h].questionNumber +'" value="'+data.questionsList[j].questionlist[h].outline[2]+'"><span class="ans ans-c">'+data.questionsList[j].questionlist[h].outline[2]+'.</span><span class="ans-content">'+data.questionsList[j].questionlist[h].outline[2]+'</span></label><br>');
    //                     $(".choice:eq("+h+")").append('<label><input type="radio" name="'+ data.questionsList[j].questionlist[h].questionNumber +'" value="'+data.questionsList[j].questionlist[h].outline[3]+'"><span class="ans ans-a">'+data.questionsList[j].questionlist[h].outline[3]+'.</span><span class="ans-content">'+data.questionsList[j].questionlist[h].outline[3]+'</span></label><br>');
    //                 } 
    //             }else if(data.questionsList[j].questionsTypeId == "b"){//俄译汉、汉译俄、造句、填空题
    //                 for(var m=0;m<data.questionsList[j].questionlist.length;m++){
    //                     $(".nav-content:eq("+j+")").append("<div class='ques shortanswer' id="+data.questionsList[j].questionlist[m].id+"></div>");
    //                     $(".shortanswer:eq("+m+")").append("<span class='que-number' mark="+data.questionsList[j].questionlist[m].questionMark+" analysis="+data.questionsList[j].questionlist[m].questionAnalysis+"></span>");
    //                     $(".shortanswer:eq("+m+")").append("<span class='que'>"+data.questionsList[j].questionlist[m].questionOutline+"</span><br />");
    //                     $(".shortanswer:eq("+m+")").append("<span class='answer'>作答: </span><input type='text' name="+data.questionsList[j].questionlist[m].questionNumber+">")
    //                 }
    //             }else if(data.questionsList[j].questionsTypeId == "c"){//作文
    //                 for(var n=0;n<data[j].questionlist.length;n++){
    //                     $(".nav-content:eq("+j+")").append("<div class='ques longanswer' mark="+data[j].questionlist[n].questionMark+" analysis="+data[j].questionlist[n].questionAnalysis+" id="+data.questionsList[j].questionlist[n].id+"></div>");
    //                     $(".ques:eq("+j+")").append("<span class='que-number'></span>");
    //                     $(".ques:eq("+j+")").append("<span class='que'>"+data[j].questionlist[n].questionOutline+"</span><br />");
    //                     $(".ques:eq("+j+")").append("<span class='answer'>作答: </span><textarea name="+data[j].questionlist[n].questionNumber+"/textarea>")
    //                 }
    //             }else if(data.questionsList[j].questionsTypeId == 4){//完形填空
    //                 for(var p=0;p<data[j].questionlist.length;p++){
    //                     $(".nav-content:eq("+j+")").append("<div class='ques choice' mark="+data[j].questionlist[p].questionMark+" analysis="+data[j].questionlist[p].questionAnalysis+"></div>");
    //                     $(".ques:eq("+j+")").append("<span class='que-number'></span>");
    //                     $(".ques:eq("+j+")").append("<span class='que'>"+data[j].questionlist[p].questionoutline[0]+"</span><br />");
    //                     $(".ques:eq("+j+")").append('<label><input type="radio" name="'+ data[j].questionlist[p].questionNumber +'" value="'+data[j].questionlist[p].outline[1]+'"><span class="ans ans-a">'+data[j].questionlist[p].outline[1]+'.</span><span class="ans-content">'+data[j].questionlist[p].outline[1]+'</span></label><br>');
    //                     $(".ques:eq("+j+")").append('<label><input type="radio" name="'+ data[j].questionlist[p].questionNumber +'" value="'+data[j].questionlist[p].outline[2]+'"><span class="ans ans-b">'+data[j].questionlist[p].outline[2]+'.</span><span class="ans-content">'+data[j].questionlist[p].outline[2]+'</span></label><br>');
    //                     $(".ques:eq("+j+")").append('<label><input type="radio" name="'+ data[j].questionlist[p].questionNumber +'" value="'+data[j].questionlist[p].outline[3]+'"><span class="ans ans-c">'+data[j].questionlist[p].outline[3]+'.</span><span class="ans-content">'+data[j].questionlist[p].outline[3]+'</span></label><br>');
    //                     if(data.questionsList[j].questionlist[n].outline[3]){
    //                         $(".choice:eq("+h+")").append('<label><input type="radio" name="'+ data.questionsList[j].questionlist[n].questionNumber +'" value="'+data.questionsList[j].questionlist[n].outline[4]+'"><span class="ans ans-d">'+data.questionsList[j].questionlist[n].outline[4]+'.</span><span class="ans-content">'+data.questionsList[j].questionlist[n].outline[4]+'</span></label><br>');
    //                     }
    //                 }
    //             }else if(data.questionsList[j].questionsTypeId == 2){//划线句翻译
    //                 for(var q=0;q<data[j].questionlist.length;q++){
    //                     $(".nav-content:eq("+j+")").append("<div class='ques shortanswer' mark="+data[j].questionlist[q].questionMark+" analysis="+data[j].questionlist[q].questionAnalysis+" id="+data.questionsList[j].questionlist[q].id+"></div>");
    //                     $(".ques:eq("+j+")").append("<div class=tran-article'>"+data[j].questionlist[q].article+"</div>");
    //                     $(".ques:eq("+j+")").append("<span class='que-number'></span>");
    //                     $(".ques:eq("+j+")").append("<span class='que'>"+data[j].questionlist[q].questionOutline+"</span><br />");
    //                     $(".ques:eq("+j+")").append("<span class='answer'>作答: </span><input type='text' name="+data[j].questionlist[q].questionNumber+">")
    //                 }
    //             }
    //         }
    //     }
    // })

    // $.ajax({
    //     type:"GET",
    //     url:"/russian test/js/checking.json",
    //     success:function(d){
    //         for(var m=0;m<ques.length;m++){
    //             var queid = ques[m].getAttribute("id");
    //             for(var n=0;n<d.getObjectiveAnwserAndComment.length;n++){
    //                 if( queid==d.getObjectiveAnwserAndComment[n].id){
    //                     $(".ques:eq("+m+")").append('<span class="xiala"></span><span class="jiexi">解析及教师评语</span><div class="analysis"><p>你的答案：<span>'+d.getObjectiveAnwserAndComment[n].studentAnswer+'</span><span class="upla"></span></p><p>正确答案：<span>'+d.getObjectiveAnwserAndComment[n].teacherComment+'</span><span class="upla"></span></p><p>解析：<span>'+d.getObjectiveAnwserAndComment[n].questionAnalysis+'</span></p><p>评语：<span>'+d.getObjectiveAnwserAndComment[n].questionAnalysis+'</span></p></div>');
    //                 }
    //             }
    //             for(var p=0;p<d.getSubjectiveAnwserAndComment.length;p++){
    //                 if( queid==d.getSubjectiveAnwserAndComment[p].id){
    //                 	$(".ques:eq("+m+")").append('<span class="xiala"></span><span class="jiexi">解析及教师评语</span><div class="analysis"><p>你的答案：<span>'+d.getObjectiveAnwserAndComment[n].studentAnswer+'</span><span class="upla"></span></p><p>正确答案：<span>'+d.getObjectiveAnwserAndComment[n].teacherComment+'</span><span class="upla"></span></p><p>解析：<span>'+d.getObjectiveAnwserAndComment[n].questionAnalysis+'</span></p><p>评语：<span>'+d.getObjectiveAnwserAndComment[n].questionAnalysis+'</span></p></div>');
    //                 }
    //             }
    //         }
    //     }
    // })
	/*解析下拉点击出现隐藏*/
	var $xiala = $(".xiala");
    $xiala.bind("click",function () {
    	$(this).hide();
    	var index = $xiala.index(this);
        $(".jiexi").eq(index).hide();
    	$(".analysis").eq(index).show(500);
    });
    var $jiexi = $(".jiexi");
    $jiexi.bind("click",function () {
        $(this).hide();
        var index = $jiexi.index(this);
        $(".xiala").eq(index).hide();
        $(".analysis").eq(index).show(500);
    });
    /*灵活的题型导航 */
    var navhref = document.getElementsByClassName("nav-href");
    var navcontent = document.getElementsByClassName("nav-content");
    var hrefto = [];
    for(var h=0;h<navhref.length;h++){
        hrefto[h] = navhref[h].getAttribute("to");
        navcontent[h].setAttribute("id",hrefto[h]);
        hrefto[h] = "#" + hrefto[h];
        navhref[h].setAttribute("href",hrefto[h]);
    }
    /*解析上拉点击出现隐藏*/
	var $upla = $(".upla");
    $upla.bind("click",function () {
    	var index = $upla.index(this);
        $(".analysis").eq(index).hide(500);
        $(".xiala").eq(index).show();
        $(".jiexi").eq(index).show();
    });
    /*为每个按钮增加导航*/
    function addHref(){
        var buttons = document.getElementsByClassName("buttons");
        for(var i=0;i < buttons.length;i++){
            var index = buttons[i].getAttribute("index");
            var href = "#que" + index;
            buttons[i].setAttribute("href",href);
        }
    }
    addHref();

    /*习题类型导航选中样式*/
    $(".nav-item").click(function(){
        $(this).addClass("nav-item-selected");
        $(this).siblings().removeClass("nav-item-selected");
    })

    /*为每道题div增加id属性*/
    function addId(){
        var ques = document.getElementsByClassName("ques");
        for(var i=0;i < ques.length;i++){
            var index = ques[i].getAttribute("index");
            var id = "que" + index;
            ques[i].setAttribute("id",id);
        }
    }
    addId();

    /*调整高度*/
    var winHeight = $(document).height();
    var leftHeight = winHeight - 226;
    $("#left-maincontent").height(leftHeight);
    $("#right-bottom").height(leftHeight + 90);
    $("#button").css("top",winHeight-60);
    /*调整宽度*/
    var winWidth = $(document).width();
    var leftWidth = winWidth * 0.6;
    // $("#sign").css("margin-left",leftWidth);

    /*为选中的添加样式*/
    $(":radio:checked").parent("label").addClass("selected");
    $(":checkbox:checked").parent("label").addClass("selected");
    // /*正确错误添加类 对应的按钮也作出相应的变化*/
    // function isCorrect(){
    //     var ques = document.getElementsByClassName("ques");
    //     var buttons = document.getElementsByClassName("buttons");
    //     for(var i=0;i < ques.length;i++){
    //         var isCorrect = ques[i].getAttribute("isCorrect");
    //         if(isCorrect == 1){
    //             ques[i].setAttribute("class","ques choice correct");
    //             buttons[i].setAttribute("class","buttons correctbtn")
    //         }else if(isCorrect == 0){
    //             ques[i].setAttribute("class","ques choice wrong");
    //             buttons[i].setAttribute("class","buttons wrongbtn");
    //         }
    //     }
    // }
    // isCorrect();
});