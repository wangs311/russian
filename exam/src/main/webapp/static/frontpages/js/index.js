$(document).ready(function () {
    $("#test2").on("click", function () {
        $('#demoModal').modal('show');
        $.ajax({
            type: "POST",
            url: "/exam/ExaminationController/edition",//册的地址
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
                url: "/exam/ExaminationController/unit?editionId="+large+"",//单元的地址
                dataType: "json",
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("#medium").append("<option id=" + data[i].id + " name=" + data[i].unitName + ">" + data[i].unitName + "</option>");
                    }
                },
                error:function(xhr){
                    console.log(xhr.status + ':' + xhr.statusText);
                }
            });
        });

        $("#medium").change(function () {
            $("#small").empty();
            $("#small").removeAttr("disabled");
            $("#small").append("<option>--请选择小范围--</option>");
            var medium = $("#medium option:selected").attr("id");
            // console.log(medium);
            $.ajax({
                type: "POSt",
                url: "/exam/ExaminationController/findExamination?unitId="+medium+"",//试卷的地址
                dataType:"json",
                success: function (data) {
                    // console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        $("#small").append("<option id=" + data[i].id + " name=" + data[i].examinationName + ">" + data[i].examinationName+ "</option>");
                    }
                }
            });
        });
    });

    $("#confirm").click(function () {
        var small = $("#small option:selected").attr("id");
        var str = "/exam/ExaminationController/toExamination?examinationId="+small+""//跳转到页面的地址
        $("form").attr("action", str)
        $("#submit").click();
    });

});