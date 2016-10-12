<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="update_pwd" class="p30" method="post" action="user/pwd/update">
	<div id="pwd_tip" ></div>
	<div class="h30 lh28">
		<label for="userpassword">旧 密 码：</label>
		<input class="easyui-validatebox" type="password" id="userpassword"   name="userpassword" data-options="required:true" 
		onblur="if(this.value==pwd) return;validate_oldpwd();"
		/>
	</div>
	<div class="h30 lh28">
		<label for="newpassword">新 密 码：</label>
		<input class="easyui-validatebox" type="password" id="newpassword" name="newpassword" data-options="required:true" />
	</div>
	<div class="h30 lh28">
		<label for="twopassword">确认密码：</label>
		<input class="easyui-validatebox" type="password" id="twopassword" name="twopassword" data-options="required:true" validType="pwdEquals['newpassword']"/>
	</div>
</form>
<script type="text/javascript" >
$.extend($.fn.validatebox.defaults.rules, {    
	pwdEquals: {    
        validator: function(value,param){    
            return value == $('#'+param[0]).val();    
        },    
        message: '2次密码不相同'   
    }    
});  

//验证旧密码
	function validate_oldpwd(pwd){
		var pwd=$('#userpassword').val();
	alert(pwd)
	var flag=false;
		$.ajax({
			   type: "POST",
			   url: "user/pwd/check",
			   data: "pwd="+pwd,
			   async:false,
			   success: function(msg){
				   if(msg =="success"){
						alert(pwd);
					   $("#pwd_tip").html("<font color='green'>舊密碼輸入正确</font>");
				   	flag=true;
				   }else{
					   $("#pwd_tip").html("<font color='red'>舊密碼輸入不正确</font>");
				   }
		}});
		return flag;
}
/* 	$('#oldpwd').blur(function(){
		validate_oldpwd($(this).val());
	}); */
</script>