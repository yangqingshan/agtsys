<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="systemconfig_dg_${configtype}"></table>
<script type="text/javascript">
$('#systemconfig_dg_${configtype}').datagrid({
							url : "systemconfig/list/${configtype}",
							columns : [ [{
									field : 'check',
									checkbox : true,
									},{
										field : 'id',
										title : 'ID',
										width:100,
										hidden:true,
									},{
										field : 'configtypename',
										title : '配置类型',
										width:100,
										align:'center'
									},
									<c:if test="${configtype!=1 and configtype!=5 and configtype!=6 }">
									{
										field : 'configvalue',
										title : '配置数值',
										width:200,
										align:'center',
									},
									</c:if>
									{
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

						});
	
</script>