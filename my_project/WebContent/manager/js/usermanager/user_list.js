$(function(){
	serviceList(1,15);
});

var crd_params = null;
/**
 * 用户列表
 */
function serviceList(start,limit){
	$("#user_List").empty();
	$.ajax({
        url : path + "/usermanager/selectUserInfo_paging.action",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	userName:$("#userName").val(),
	    	phone:$("#phone").val(),
	    	roleName:$("#roleName").val(),
	    	roleId: $('#roleId option:selected').val(),
	    	curPage:start,
			pageCount:limit
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		var fly= data.data.lst;
        	
            	$("#userListPaging").pagination(data.data.page,selectServiceTopage);
        		var pageCount = data.data.page.pageCount;
    			var curPage = data.data.page.curPage;
        		var total = curPage * pageCount;
        		var trHtml="";
            	$.each(fly, function(i, item) {
            		num = i+1;
            		trHtml ="<tr onclick=\"showQualityDetail(this);\">"+
        			"	<td><input name='rad' type='radio' value='"+item.USER_ID+"'></td>"+	
            		"	<td>"+(total + num - pageCount)+"</td>"+
            		"	<td>"+(item.USER_NAME?item.USER_NAME:"--")+"</td>"+
            		"	<td>"+(item.NICK_NAME?item.NICK_NAME:"--")+"</td>"+
            		"	<td>"+(item.SEX?item.SEX:"--")+"</td>"+
            		"	<td>"+(item.EMAIL?item.EMAIL:"--")+"</td>"+
            		"	<td>"+(item.PHONE?item.PHONE:"--")+"</td>"+
            		"	<td>"+(item.ROLE_NAME?item.ROLE_NAME:"--")+"</td>"+
            		"	<td>"+(item.CREATE_TIME?item.CREATE_TIME:"--")+"</td>"+
            		"</tr>";
            		
            		var $t = $(trHtml);
            		$t.find(" td a").click(function(){
                		showOrderDetail(item);
                	});
            		
            		$("#user_List").append($t);
            		
            	});
            	changeColor();
        	} 
        	if(data.code==0){
        		$("#user_List").html('<tr><td colspan="17"><p class="table-empty">'+data.message+'</p></td></tr>');  
        	}
        }
	});
}
/**
 * 按条件查询
 */
function searchService(){
	serviceList(1,15);
}

/**
 * 删除服务器
 * @param isPass
 */

function deleteService() {
	//弹出框
	$.confirm({
		text : "是否继续操作",
		callback : function(a) {
			if (a == true) {
				isDelete();
				serviceList(1,15);
			}
		}
	});
}
function isDelete(){
	var userId = $("input[name=rad]:checked").val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一个用户！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
	        url : path + "/usermanager/deleteUserByuserId.action",
	        type :"POST",
	        xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	userId:userId
		    },
	        dataType :"json",
	        success : function (data) {
	        	$.alert({text:data.message});
	        },
	        error: function (data){
	        	$.alert({text:"网络异常,请稍后重试!"});
	        }
		});
	}
}

/**
 * 设置权限,回显权限 
 * @param isPass
 */
function quXianService(){
	openModule("../page/usermanager/quanXian_user.html",{},{},{},"");
	$.ajax({
        url : path + "/usermanager/showRoleList.action",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
        dataType :"json",
        success : function (data) {
        	console.log(data.data);
        	var trHtml="";
        	$.each(data.data, function(i, item) {
        		trHtml +="<option value='"+item.ROLE_ID+"'>"+item.ROLE_NAME+"</option>"
        	});
        	$("#quanxian_roleId").html(trHtml);
        },
        error: function (data){
        	$.alert({text:"网络异常,请稍后重试!"});
        }
	});
}
$(document).on('click','#isQuanXian',function(){
	var userId = $("input[name=rad]:checked").val();
	var roleId = $('#quanxian_roleId option:selected').val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一个用户！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
	        url : path + "/usermanager/updateRoleByUserId.action",
	        type :"POST",
	        xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	userId:userId,
		    	roleId:roleId
		    },
	        dataType :"json",
	        success : function (data) {
	        	$.alert({text:data.message});
	        	serviceList(1,15);
	        },
	        error: function (data){
	        	$.alert({text:"网络异常,请稍后重试!"});
	        }
		});
	}
});

/**
 * 手动添加用户
 */
function showModel(){
	openModule("../page/usermanager/add_user.html",{},{},{},"");
}
$(document).on('click','#saves',function(){
	alert($('#add_sex option:selected').val());
	//设置一个对象来控制是否进入AJAX过程
	var post_flag = false; 
	 //如果正在提交则直接返回，停止执行
    if(post_flag) return; 
    //标记当前状态为正在提交状态
    post_flag = true;
    $.ajax({
		url : path + "/usermanager/addUser.action",
	    type :"POST",
	    xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	userName:$("#add_userName").val(),
	    	password:$("#add_password").val(),
	    	nickName:$("#add_nickName").val(),
	    	sex:$('#add_sex option:selected').val(),
	    	age:$("#add_age").val(),
	    	phone:$("#add_phone").val(),
	    	email:$("#add_email").val(),
	    	/*roleId:$('#add_roleId option:selected').val(),
	    	roleName:$('#add_roleId option:selected').text()*/
	    },
	    dataType :"json",
	    success : function (data) {
	    	post_flag =false; //在提交成功之后将标志标记为可提交状态
	    	$.alert({text:data.message});
	    	closeModule();
	    	serviceList(1,15);
	    },
	    error: function (data){
	    	$.alert({text:"网络异常,请稍后重试!"});
	    	post_flag =false; //AJAX失败也需要将标志标记为可提交状态
	    }
	});
	
});


/**
 * 失去焦点事件,在输入用户名的时候去重
 */
$(document).on('blur','#add_userName',function(){
	$.ajax({
		url : path + "/usermanager/isExistUserName.action",
	    type :"POST",
	    xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	userName:$("#add_userName").val(),
	    },
	    dataType :"json",
	    success : function (data) {
	    	if(data.code==1){
	    		$("#red_title").text("用户登录名:合法");
	    		$("#red_title").css("color","#02DF82");
	    	}else{
	    		$("#red_title").text(data.message);
		    	$("#service_ip").css("background-color","#FFD2D2");
		    	$("#red_title").css("color","#FF5151");
	    	}
	    	
	    },
	    error: function (data){
	    	$.alert({text:"网络异常,请稍后重试!"});
	    }
	});	
});


 /*************************************************以下是页面布局,样式js无需关注******************************************************************/ 
 
 /**
  * 分页跳转使用
  * @param num
  * @param count
  */
  function selectServiceTopage(num,count) {
  	if (null == num || "" == num || isNaN(parseInt(num))) {
  		alert("请输入数字");
   		return;
  	}
  	$("#user_List").empty();
  	serviceList(num,(count?count:15));
   }
  
  /**
   * 查看投诉详情
   * @param id
   */
 function showComplainDetail(content){
 	crd_params = content;
 	openModule("../page/complaint/complain_detail.html",{},{},{},"");
 }
  /**
   * tr 选中事件
   */
 function showQualityDetail(obj) {
 	$(obj).toggleClass('info').siblings().removeClass('info').css('cursor', 'pointer');
 	var currState = $(obj).find("input[type=radio]").is(':checked');
 	console.log(currState);
 	$(obj).find("input[type=radio]")[0].checked=!currState;
 }


 /**
  * 改变颜色
  */
 function changeColor(){
 	for(var i=0; i<$(".zy_flag").length; i++){
 		var obj = $(".zy_flag")[i];
 		var temp=$(obj).text();
 		if(temp=='通过'){
 			$(obj).removeClass("zy_hong");
 			$(obj).addClass("zy_lv");
 		}else if(temp=='未通过'){
 			$(obj).removeClass("zy_lv");
 			$(obj).addClass("zy_hong");
 		}
 	}
 }
