$(document).ready(function(){
	//获取当前日期
	function p(s) {
    	return s < 10 ? '0' + s: s;
	}
	var myDate = new Date();
	var year=myDate.getFullYear();
	var month=myDate.getMonth()+1;
	var date=myDate.getDate(); 
	var h=myDate.getHours();       
	var m=myDate.getMinutes();    
	var s=myDate.getSeconds();  
	
	var now=year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s);
	
	//发表评论
	$("#btn1").click(function (a) {
		var $div=$('<div class="liuyan_every1"></div>');
		var $touxiang=$('<span class="touxiang"></span>');
		var $user=$('<span class="user">我</span>');
		var $word_p=$('<div class="word_p"></div>');
		var $p=$('<p class="user_words">'+$("#text1").val()+'</p>');
		var $huifu=$('<span class="huifu" data-toggle="modal" data-target="#mymodal-link2">回复</span>');
		var $time=$('<span class="time">'+now+'</span>');

		$div.append($touxiang);
		$div.append($user);
		$div.append($word_p);
		$div.append($huifu);
		$div.append($time);
		$word_p.append($p);

		$("#woyao").prepend($div);
		a.preventDefault();
	});
	
	//回复
	$(".huifu").click(function(){
		var username=$(this).parent().children(".user").html();//获取留言者的名字 
		var message=$(this).parent().children(".word_p").children(".user_words").html();//获得留言的内容
	
		$("#btn2").unbind("click").click(function (b) {
			
			var $div=$('<div class="liuyan_every1"></div>');
			var $touxiang=$('<span class="touxiang"></span>');
			var $user=$('<span class="user">我</span>');
			var $word_p=$('<div class="word_p"></div>');
			var $p=$('<p class="user_words">'+$("#text2").val()+'</p>');
			var $huifu=$('<span class="huifu" data-toggle="modal" data-target="#mymodal-link2">回复</span>');
			var $time=$('<span class="time">'+now+'</span>');
	
			var $back=$('<p class="user_words back"></p>');
			var $span=$('<span>@'+username+'&nbsp&nbsp</span>');
	
			$div.append($touxiang);
			$div.append($user);
			$div.append($word_p);
			$div.append($huifu);
			$div.append($time);
			$word_p.append($p);
	
			$word_p.append($back);
			$back.append($span).append(message);
	
			$("#woyao").prepend($div);
			
		});
		b.preventDefault();
	});
	//与后台交互异步刷新获得留言板信息
	/*$.ajax({
		type:"get",
		url:"test.json", 
		dateType:"json",
		data:"",
		success:function(data){
			//var data =(new Function("","return "+datas))();
			var div="";
			$.each(data,function(i,o){
				div+='<div class="liuyan_every1"><span class="touxiang"></span><span class="user" id'=+o.id+'>'+o.name+'</span><div class="word_p"><p class="user_words">'+o.words+'</p></div><span class="huifu" data-toggle="modal" data-target="#mymodal-link2">回复</span><span class="time"></span></div>';
			} 
			$("#woyao").append(div);		
		}	
	})*/
	//异步发表评论
	/*$("btn1").click(function(){
		$.ajax({
			type:"post",
			url:"test.json",
			dateType:"json",
			data:{"name": "小芳" ,"words": "dddddddd"},
			success:function(){
				alert("sucess");
			},		
		});
	})*/
	
});