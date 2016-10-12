/**
 * 
 */
$(function(){
	$('#login-div').dialog({    
	    title: '系统登录',   
	    iconCls:'icon-ok',
	    width: 350,    
	    height: 260,    
	    closed: false,    
	    cache: false,    
	    modal: true,
	    buttons:[{
			text:'登录',
			handler:function(){
			if($('#login-form').form('validate')){
				$('#login-form').submit();
			}
			}
		},{
			text:'重置',
			handler:function(){
				$('#login-form').form('reset');
			}
		}]
	}); 
	//验证码輸入提示
	$("#captchca").keyup(function(){
		var captchca=$("#captchca").val();
		if(captchca.length>=4){
			$.ajax({
				   type: "POST",
				   url: "captchca/check",
				   data: "captchca="+captchca,
				   dataType:"text",
				   success: function(msg){
					   if(msg =="success"){
						   $("#tip").html("<font color='green'>验证码正确</font>");
					   }else{
						   $("#tip").html("<font color='red'>验证码不正确</font>");
					   }
				   }
				});
		}
	});
});
