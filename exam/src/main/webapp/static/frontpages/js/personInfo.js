$(function () {
    var winWidth = $(document).width();
    mainWidth = winWidth * 0.8;
    // $("#content").width(mainWidth);

    // 模态框
    $("#btn").on("click", function () {
        $('#demoModal').modal('show');
    });

    // 表单验证
    $("#confirm").attr("disabled", "disabled");
    $("#repeatpsw").on("keyup", function () {
        if ($("#repeatpsw").val() == "" || $("#changepsw").val() == "" || $("#repeatpsw").val() != $("#changepsw").val()) {
            $(".warning:eq(0)").html("请输入正确密码！");
        } else {
            $(".warning:eq(0)").html("");
            $("#confirm").removeAttr("disabled");
        }
    });

    $("#confirm").click(function () {
        $("#submit").click();
        $("#reset").click();
        $(".warning:eq(0)").html("");
    });

    //取消的时候清空节点
    $("#cancel").on("click", function () {
        $("#reset").click();
        $(".warning:eq(0)").html("");
    });

    //表格里的数据请求
    $.ajax({
        type: "POST",
        url: "/exam/ExaminationController/getPersonal", //表格里的数据请求的地址
        async: false,
        dataType: "JSON",
        //请求成功后
        success: function (data) {
            var studentName = data[0].studentName;
            $(".student-name").html(studentName);
            for(var i=0;i<data[1].length;i++){
                $("tbody").append('<tr><td>'+data[1][i].editionName+'</td><td>'+data[1][i].unitName+'</td><td><a class="examinationName" id="'+data[1][i].id+'" examinationId="'+data[1][i].examinationId+'">'+data[1][i].examinationName+'</a></td><td>'+data[1][i].dateFormat+'</td><td>'+data[1][i].finishMark+'</td></tr>')
            }
        }
    });

    $(".examinationName").click(function () {
        var examinationIda = $(this).attr("examinationId");
        var ida = $(this).attr("id");
        window.location.href="/exam/studentController/toChecking?examinationIda="+examinationIda+"&ida="+ida+"";
    });
});