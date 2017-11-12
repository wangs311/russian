//打开留言页面时与后台交互异步刷新获得留言板的所有记录
$(document).ready(function(){
	var currentPage = document.getElementById("currentPage").innerHTML;
		$.ajax({
			type:"get",
			dateType:"application/json",
			url:"/exam/bg/front_usermessage?to=frontpage&currentPage=" + currentPage,    
			//async:true,
			success:function(datas){
				var data =(new Function("","return "+datas))();
//				alert(a.list[1].id);
					
				for(var i=0;i<data.list.length;i++){
//					alert data[0].id;
					$(".liu_record").append("<div class='liuyan_every1'><span class='touxiang'></span><span class='user'>"+data.list[i].id+"</span><div class='word_p'><p class='user_words'>"+data.list[i].messageContent+"</p></div><span class='huifu' data-toggle='modal' data-target='#mymodal-link2'>回复</span><span class='time'>"+data.list[i].messageTime+"</span></div>");
					
				}
			},
			error:function(){
                alert("阿欧~出错啦");
            }
		});
});
//结束
//添加留言（异步）
$("#woyao").click(function(){
	
		$.ajax({
			type:"post",
			dateType:"application/json",
			url:"msg.json",
//			data:{"name": "John" ,"commit": "第一条评论","date":"2013.11.11"},
			success:function(){
				alert("sucess");
			},
			error:function(){
             alert("阿欧~出错啦");
         }
		});
	
})
//静态服务器没有实现POST方法目前无法测试

//添加留言结束

   
