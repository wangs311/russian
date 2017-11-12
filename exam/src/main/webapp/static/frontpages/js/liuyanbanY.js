//打开留言页面时与后台交互异步刷新获得留言板的所有记录
$(document).ready(function(){
	var currentPage = document.getElementById("currentPage").innerHTML;
	var userInfoId="1";
		$.ajax({
			type:"get",
			dateType:"application/json",
			url:"/exam/bg/front_usermessage?to=frontpage&currentPage=" + currentPage,    
			//async:true,
			success:function(datas){
				var data =(new Function("","return "+datas))();
					
				for(var i=0;i<data.list.length;i++){
					   
					$(".liu_record").append("<div id="+data.list[i].id+"><div class='liuyan_every1'><span class='touxiang'></span><p class='username'><span class='relativeMessageId' style='display:none'>"+data.list[i].userInfoId+"</span>"+data.list[i].username+"</p><span class='con_display'></span><p class='user_words'>"+data.list[i].messageContent+"</p><span class='huifu' data-toggle='modal' data-target='#mymodal-link'>回复</span><span class='time'>"+data.list[i].messageTime+"</span></div></div>");
					if(data.list[i].replyList.length!=0){
						for(var j=0;j<data.list[i].replyList.length;j++){
							$("#"+data.list[i].id+"").append("<div class='liuyan_every2'><span class='touxiang'></span><p class='username'>"+data.list[i].replyList[j].username+"(回复"+data.list[i].replyList[j].replyName+"):</p><p class='user_words'>"+data.list[i].replyList[j].messageContent+"</p><span class='huifu' data-toggle='modal' data-target='#mymodal-link'>回复</span><span class='time'>"+data.list[i].replyList[j].messageTime+" </span></div>");
						}
					}
			 }
				$(".huifu").click(function(){
					var relativeMessageId=$(this).parent("div").children(".relativeMessageId")[0].innerHTML;
					$("#molBu").click(function(){
						var messageContent=$("#messageContent").val();
						alert(relativeMessageId);
						alert(messageContent);
						alert(userInfoId);
						$.ajax({
							type:"get",
							cache:false,
							url:"/exam", 
							data:{
								relativeMessageId:relativeMessageId,
								messageContent:messageContent,
								userInfoId:userInfoId
							},
							success:function(){
								alert("success");
							},
							error:function(){
								alert("error");
							}
						
						})
					})
				})
			},
			error:function(){
                alert("阿欧~出错啦");
            }
		});
});
//结束
//添加留言（异步）
$("#woyaoliuyan").click(function(){
	$("#molB").click(function(){
		$.ajax({
			type:"post",
			dateType:"application/json",
			url:"msg.json",
			data:{"name": "John" ,"commit": "第一条评论","date":"2013.11.11"},
			success:function(){
				alert("sucess");
			},
			error:function(){
             alert("阿欧~出错啦");
         }
		});
	})
})
//静态服务器没有实现POST方法目前无法测试

//添加留言结束


$(function(){
	if($(this).parent(".liuyan_every1").siblings(".liuyan_every2").length!=0){
		$(this).css("background-image","url(../frontpages/images/liuyan_14.gif)");
	}
	$(".con_display").toggle(function(){
		if($(this).parent(".liuyan_every1").siblings(".liuyan_every2").length!=0){
			$(this).css("background-image","url(../frontpages/images/shouqi.gif)");
			$(this).parent(".liuyan_every1").siblings(".liuyan_every2").toggle();
		}		
	},function(){
		if($(this).parent(".liuyan_every1").siblings(".liuyan_every2").length!=0){
			$(this).css("background-image","url(../frontpages/images/liuyan_14.gif)");
			$(this).parent(".liuyan_every1").siblings(".liuyan_every2").toggle();
		}
	});
	
	$("#myWords").click(function(){
		$("#wode").css("display","block");
		$("#all").css("display","none");
		$("#woyao").css("display","none");
	});
	
	$("#allWords").click(function(){
		$("#wode").css("display","none");
		$("#all").css("display","block");
		$("#woyao").css("display","none");
	});
   
   

  
   
   
   
   
});
