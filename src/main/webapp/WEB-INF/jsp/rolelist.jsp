<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="role_dg"></table>
<script type="text/javascript">
$("#role_dg").datagrid({
							url : "role/list",
							columns : [ [{
									field : 'check',
									checkbox : true,
									},{
										field : 'id',
										title : 'ID',
										width:100,
										hidden:true,
									},{
										field : 'rolename',
										title : '角色名称',
										width:100,
										align:'center'
									},{
										field : 'creationtime',
										title : '创建时间',
										width:200,
										align:'center',
										formatter:function(value){
											return formatDate(value);
										}
									},{
										field : 'isstart',
										title : '是否启用',
										width:100,
										align : 'center',
										formatter : function(value) {
											//formatter  表格格式化函数，返回3个参数：字段值，该行数据，该行索引
											switch (value) {
											case 0:
												return "未启用";
											case 1:
												return "启用";
											}
										},
										styler : function(value) {
											if (value == 0) {
												return 'background-color:#ffee00;color:red;';
											}
										}
									}, ] ],
							//工具条
							toolbar : [ {
								text : '添加',
								iconCls : 'icon-add',
								handler : function(){add_role();}
							}, '-', {
								text : '修改',
								iconCls : 'icon-edit',
								handler : function(){
									//获取id getselected
									var row=$('#role_dg').datagrid('getSelected');
									if(row==null){
										$.messager.alert('提示','您没有选中一行数据','warning');
										return;
									}
									update_role(row.id);
								}
							}, '-', {
								text : '删除',
								iconCls : 'icon-remove',
								handler :function(){
									var row=$('#role_dg').datagrid('getSelected');
									if(row==null){
										$.messager.alert('提示','您没有选中一行数据','warning');
										return;
									}{
										$.messager.confirm('删除确认','您确定要删除该【'+row.rolename+'】角色吗？',function(r){
											if(r){
												delete_role(row);
											}
										});
									}
								} 
							}, ],
							//表格属性
							fitColumns : true,//自适应宽度 
							striped : true,//列表是否有间隔底色
							//resizable : true,//列尺寸可调节
							singleSelect : true,
							frozenColumns:true,
							loadMsg : '正在努力加载中..',
							rownumbers : true, //行前显示行号
							idField : 'id', //指定选中时返回的维度字段名，如id

							//pagination : true,//是否显示分页
							//pageSize : 5,//每页条数 
							//pageList : [ 5, 10, 15 ]
						});
	//格式化时间
	function formatDate(date){
		var d=new Date(date);
		var year=d.getFullYear();
		var month=d.getMonth()+1;
		var day=d.getDate();
		var hour=d.getHours();
		var minute=d.getMinutes();
		var second=d.getSeconds();
		
		return year+"-"+(month<10?"0"+month:month)+"-"+(day<10?"0"+day:day)
		+" "+(hour<10?"0"+hour:hour)+":"+(minute<10?"0"+minute:minute)+":"+(second<10?"0"+second:second);
	}
	
		$('#oldpwd').blur(function(){
			validate_oldpwd($(this).val());
		});
		
		//新增函数
		function add_role() {
			$("#formbox").dialog({
				title : "添加角色",
				width : 300,
				height : 200,
				closed:false,
				cache:false,
				resizable : true,
				modal : true,
				href : "role/add",
				buttons : [ {
					text : '添加',
					iconCls : 'icon-save',
					handler : function() {
						//约束验证
						if($('#add_role').form('validate')){
							//检查角色名是否存在
							if(check_rolename()){
								$('#add_role').form('submit',{
									 success: function(msg){
										   if(msg =="success"){
											   $.messager.alert('提示','添加【'+$('#rolename').val()+'】角色成功!','info');
											   $('#formbox').dialog('close');
												$("#role_dg").datagrid('reload');
										   }else{
											   $.messager.alert('提示','添加角色失败!','error');
										   }
								}
							})
						}}}
				}, {
					text : '取消',
					iconCls : 'icon-undo',
					handler : function() {
						$("#formbox").dialog("close");
					}
				} ]
			});
		}
		
	//修改函数
	function update_role(id) {
		$("#formbox").dialog({
			title : "修改角色",
			width : 300,
			height : 200,
			closed:false,
			cache:false,
			resizable : true,
			modal : true,
			href : "role/update/"+id,
			buttons : [ {
				text : '修改',
				iconCls : 'icon-save',
				handler : function() {
					//约束验证
					if($('#update_role').form('validate')){
						//检查角色名是否存在
						var flag=false;
						if($('#rolename').val()!=old_rolename){
							flag=check_rolename();
						}else{
							flag=true;
						}if(flag){
						if(check_rolename()){
							$('#update_role').form('submit',{
								 success: function(msg){
									   if(msg =="success"){
										   $.messager.alert('提示','修改【'+$('#rolename').val()+'】角色成功!','info');
										   $('#formbox').dialog('close');
										   $("#role_dg").datagrid('reload');
									   }else{
										   $.messager.alert('提示','修改角色失败!','error');
									   }
									}
								})
							}
					}}}
			}, {
				text : '取消',
				iconCls : 'icon-undo',
				handler : function() {
					$("#formbox").dialog("close");
				}
			} ]
		});
	}
	//删除函数
	function delete_role(row) {
		//判断是否选中
		//$.ajax 删除数据，刷新datagrid 
		//判断是否选择了数据记录
		//var row = $("#dg").datagrid('getSelected');
		//if (row == null) {
		//	$.messager.alert('提示','你还没有选择任何数据记录','warning');			
		//	return;
		//}
		$.ajax({
			url:'role/delete/'+row.id,
			async:false,
			success:function(msg){
				   if(msg =="success"){
					   $.messager.alert('提示','删除【'+row.rolename+'】角色成功!','info');
					   //$('#formbox').dialog('close');
					   $("#role_dg").datagrid('reload');
				   }else{
					   $.messager.alert('提示','删除【'+row.rolename+'】角色失败!','error');
				   }
			 }
		})
	}
</script>

