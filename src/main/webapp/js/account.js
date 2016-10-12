/**
 * 
 */
//输入自动搜索用户功能
$("#searchUserText").keyup(function(){
		$("#searchUserId").val("");
		$("#serachresult").html("");
		//查询用户
		loadUsers();
});
	//单击搜索用户功能
	$("#searchUserText").click(function(){
		$("#searchUserId").val("");
		$("#serachresult").html("");
		loadUsers();
	});
function confirmUser(uid,ucode){
		$("#searchUserId").val(uid);
		$("#searchUserText").val(ucode);
		$("#serachresult").html("");
	}
	
	//加载用户
	function loadUsers(){
		$.get("account/usercode/load",{'usercode':$("#searchUserText").val()},
			function(result){
				var $ul = $("<ul></ul>");
				for(var i=0;i< result.length;i++){
					//jquery对象
					var $li = $("<li>"+result[i].usercode+"</li>");
					$li.attr("onclick","confirmUser("+result[i].id+",'"+result[i].usercode+"')");
					$ul.append($li);
				}
				$("#serachresult").append($ul);		
		},'json');
	}