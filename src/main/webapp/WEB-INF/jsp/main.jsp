<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="head.html"%>
<script type="text/javascript" src="js/main.js"></script>
<title>代理商管理系统</title>

</head>
<body class="easyui-layout" fit="true">
	<!-- 頁面頭部 -->
	<div data-options="region:'north',title:''"
		style="height: 122px; background: url('images/top_1px.gif') repeat-x; overflow: hidden;">
		<!-- 背景图片 -->
		<div style="height: 120px; background: url('images/top_bg.gif') no-repeat ;" >
			<!-- 系統菜單 -->
			<div style="float: right;">
					<a href="javascript:void(0)" id="mb" class="easyui-menubutton"
						data-options="menu:'#mm',iconCls:'icon-edit'">系統菜單</a>
						<div id="mm" style="width: 150px;">
							<div data-options="iconCls:'icon-edit'">修改密碼</div>
							<div class="menu-sep"></div>
							<div  data-options="iconCls:'icon-remove'">退出系統</div>
						</div>
					</div>
			<!--歡迎區域  -->
			<div style="height: 100%;line-height: 110px;margin-left:670px  ">歡迎你，${loginkey.username }~~~</div>
		</div>
	</div>
	<!-- 頁面底部 -->
	<div data-options="region:'south',title:'' "
		style="height: 40px;" >
		<!--版權聲明  -->
		<div style="text-align: center;line-height: 38px;">杭州匯道科技公司版權所有，侵權必究！</div>
		</div>
	<!-- 頁面左邊 —樹形功能菜單-->
	<div data-options="region:'west',title:'導航菜單',split:true"
		style="width: 200px;">
		<div>
			<ul id="tree" class="easyui-tree" ></ul>
		</div>
	</div>
	<!-- 頁面中間 -->
	<div data-options="region:'center',title:''"
		style="padding: 5px; background: #eee;">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
		</div>
	</div>
	<!-- 公共的表单容器 -->
	<div id="formbox"></div>
	
</body>
</html>