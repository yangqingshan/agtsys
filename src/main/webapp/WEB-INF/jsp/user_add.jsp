<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="add_user" class="p30" method="post" action="user/add">
	<div id="user_add_tip"></div>
	<div class="h30 lh28">
		<label for="usercode">登录账户：</label>
		<input class="easyui-validatebox" type="text" onblur="check_usercode();" id="usercode" name="usercode" data-options="required:true" />
	</div>
		<div class="h30 lh28">
		<label for="username">用户名称：</label>
		<input class="easyui-validatebox" type="text"   id="username" name="username" data-options="required:true" />
	</div>
		<div class="h30 lh28">
		<label for="userpassword">登录密码：</label>
		<input class="easyui-validatebox" type="password" value="123456"  id="userpassword" name="userpassword" data-options="required:true" />
	</div>
		<div class="h30 lh28">
		<label for="roleid">角&nbsp;色：</label>
		<select class="easyui-validatebox"   id="roleid" name="roleid" data-options="required:true">
			<option value="">----请选择----</option>
			<c:forEach items="${roles}" var="role">
				<option value="${role.id}">${role.rolename}</option>
			</c:forEach>
		
		</select>
	</div>
	<div class="h30 lh28">
		<label for="isstart">是否启用：</label>
		<select name="isstart">
			<option value="1" selected="selected">启用</option>
			<option value="0">不启用</option>
		</select>
	</div>
</form>