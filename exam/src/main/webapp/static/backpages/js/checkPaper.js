$(function () {
    //请求册的地址
    var editionId;
    $.ajax({
        type: "POST",
        url: "/exam/backExaminationController/teacherEdition", //册的地址
        async: false,
        dataType: "text",
        //请求成功后
        success: function (data) {
            editionId = data;
        }
    });
    //请求单元地址
    $.ajax({
        type: "POST",
        url: "/exam/backExaminationController/unit?editionId=" +editionId+ "", //单元的地址
        async: false,
        dataType: "json",
        //请求成功后
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#selectUnit").append("<option id=" + data[i].id + " name=" + data[i].unitName + ">" + data[i].unitName + "</option>");
            }
        }
    });

    //试卷单元和类型选好后
    $("#unitSubmit").click(function (){
        $("table").empty();
        var unitIda = $("#selectUnit option:selected").attr("id");
        var finishalreadya = $("#finish-alreay option:selected").attr("id");;
        $.ajax({
            type: "POST",
            url: "/exam/backExaminationController/getCheckPaper", //请求未判过试卷或已经判过试卷的地址
            async: false,
            data:{
                unitId:unitIda,
                finishAlready:finishalreadya
            },
            dataType: "json",
            //请求成功后
            success: function (data) {
                if(finishalreadya=="0"){
                    $("table").append('<thead><tr class="text-c"><th width="60">姓名</th><th width="60">试卷名称</th><th width="60">完成时间</th></tr></thead><tbody></tbody>');
                    for (var i = 0; i < data.length; i++) {
                        $("tbody").append('<tr><td><a class="studentName" examinationId="'+data[i].examinationId+'" id="'+data[i].id+'">'+data[i].studentName+'</a></td> <td>'+data[i].examinationName+'</td><td class="111">'+data[i].dateFormat+'</td></tr>')
                    }
                }
                else{
                    $("table").append('<thead><tr class="text-c"><th width="60">姓名</th><th width="60">试卷名称</th><th width="60">完成时间</th><th width="60">试卷成绩</th></tr></thead><tbody></tbody>');
                    for (var i = 0; i < data.length; i++) {
                        $("tbody").append('<tr class="text-c"><td><a class="student-name" examinationId="'+data[i].examinationId+'" id="'+data[i].id+'">'+data[i].studentName+'</span></td> <td>'+data[i].examinationName+'</td><td>'+data[i].dateFormat+'</td><td>'+data[i].finishMark+'</td></tr>')
                    }
                }
            }
        });

        //点击学生姓名判卷
        $(".studentName").click(function () {
            var examinationIda = $(this).attr("examinationId");
            var ida = $(this).attr("id");
            window.location.href="/exam/backIndexController/toStudentPaper?examinationIda="+examinationIda+"&ida="+ida+"";
        });
    });

});

// 点击姓名后，跳转的地址是 http://localhost:8080/exam/backIndexController/toStudentPaper
// 传输指定的两个参数之后，访问试题数据的地址是 http://localhost:8080/exam/backExaminationController/getStudentPaper
// 老师判完之后点确定，提交的地址是