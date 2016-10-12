<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include  file="head.html" %>
<title>登录</title>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div id="login-div">
	<div id="tip" >
		<c:if test="${user_validate_errors != null }">
			<c:forEach items="${user_validate_errors }" var="error">
				<p style="color: red;">${error.defaultMessage }</p>
			</c:forEach>
		</c:if>
		<c:if test="${captchca_errors != null }">
				<p style="color: red;">${captchca_errors }</p>
		</c:if>
		<c:if test="${user_login_errors != null }">
				<p style="color: red;">${user_login_errors}</p>
		</c:if>
	</div>
	<form id="login-form" class="p30" action="user/login" method="post">
	<div class="h30 lh28">
		<label for="name">用户名：</label>
		<input class="easyui-validatebox" type="text" id="usercode" name="usercode" data-options="required:true" missingMessage="请输入用户名"/>
	</div>
		<div class="h30 lh28">
		<label for="userpassword">密&nbsp;码：</label>
		<input class="easyui-validatebox" type="password" id="userpassword" name="userpassword" data-options="required:true" missingMessage="请输入用户密码"/>
	</div>
		<div class="h30 lh28">
		<label for="captchca">验证码：</label>
		<input class="easyui-validatebox" type="text" id="captchca" name="captchca" data-options="required:true" missingMessage="请输入验证码"/>
		<img alt="看不清，刷新一下" src="captchca/get" title="看不清，刷新一下" onclick="this.src='captchca/get?'+Math.random() "/>
	</div>
	</form>
</div>
</body>
</html>