/**
 * 
 */
$(function(){
	$('#mm').menu({    
		onClick:function(item){    
			if(item.text=="退出系統"){
				window.location.href="user/logout";
			}else if(item.text=="修改密碼"){
				$('#formbox').dialog({    
				    title: '修改密碼',    
				    width: 300,    
				    height: 280,    
				    closed: false,    
				    cache: false,    
				    href: 'user/pwd/update',    
				    modal: true,
				    buttons:[{
						text:'確認修改',
						handler:function(){
							//表單驗證
							if($('#update_pwd').form('validate')){
								//驗證舊密碼
								var flag=false;
								if($('#userpassword').val()!=pwd){
									flag=validate_oldpwd();
								}else{
									flag=true;
								}if(flag){
								if(validate_oldpwd($('#oldpwd').val())){
									//提交數據到遠程服務器進行修改
									$.ajax({
										   type: "POST",
										   url: "user/pwd/update",
										   data: "userpassword="+$('#newpassword').val(),
										   success: function(msg){
											   if(msg =="success"){
												   $.messager.alert('修改提示','修改密碼成功！','info');
												   $('#formbox').dialog('close');
											   }else{
												   $.messager.alert('修改提示','修改密碼失敗！','error');
											   }
									}});
								}
							}
						}}
					},{
						text:'取消',
						handler:function(){
							$('#formbox').dialog('close')
						}
					}],

				}); 
			}
		}    
	}); 
	
	//树形菜单
	$('#tree').tree({
		url : "main/tree",
	onClick: function(node){
		if(node.attributes.url !=""){
			if($('#tabs').tabs('exists',node.text)){
				$('#tabs').tabs('select',node.text);
			}else{
				create_tab(node);
			}
		}
	}
	});
})

function create_tab(node){
	$('#tabs').tabs('add',{    
	    title:node.text,    
	    //content:node.text,    
	    href:node.attributes.url ,
	    closable:true,    
	    tools:[{    
	        iconCls:'icon-mini-refresh',    
	        handler:function(){    
	            var tab=$('#tabs').tabs('getSelected');
	            tab.panel('refresh');
	        }    
	    }]    
	}); 
}