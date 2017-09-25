$(".form-control").on("keyup",function(){
    if($(".form-control:eq(0)").val() && $(".form-control:eq(1)").val()){
        $("#submit").removeAttr("disabled");
    }
});