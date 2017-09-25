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
    })
});