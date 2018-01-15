$(function(){
	serviceList(1,15);
});

var crd_params = null;
/**
 * @author zhangKangChuang
 * 服务器列表
 */
function serviceList(start,limit){
	$("#operation_service_List").empty();
//	alert(path + "/servers/selectServicelistPage");
	$.ajax({
        url : path + "/servers/selectServicelistPage",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	serverName:$("#serverName").val(),
	    	serverIp:$("#serverIp").val(),
	    	serverStatus: $('#serverStatus option:selected').val(),
	    	curPage:start,
			pageCount:limit
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		var fly= data.data.lst;
        	
            	$("#serviceListPaging").pagination(data.data.page,selectServiceTopage);
        		var pageCount = data.data.page.pageCount;
    			var curPage = data.data.page.curPage;
        		var total = curPage * pageCount;
        		var trHtml="";
            	$.each(fly, function(i, item) {
            		num = i+1;
            		trHtml ="<tr onclick=\"showQualityDetail(this);\">"+
        			"	<td><input name='rad' type='radio' value='"+item.ID+"'></td>"+	
            		"	<td>"+(total + num - pageCount)+"</td>"+
            		"	<td>"+(item.SERVER_NAME?item.SERVER_NAME:"--")+"</td>"+
            		"	<td>"+(item.SERVER_IP?item.SERVER_IP:"--")+"</td>"+
            		"	<td>"+(item.CREATE_BY?item.CREATE_BY:"--")+"</td>"+
            		"	<td>"+item.CREATE_TIME+"</td>"+            		           		
            		"	<td><span class=\"zy_flag\">"+(item.SERVER_STATUS?item.SERVER_STATUS:"--")+"</span></td>"+
            		"</tr>";
            		
            		var $t = $(trHtml);
            		$t.find(" td a").click(function(){
                		showOrderDetail(item);
                	});
            		
            		$("#operation_service_List").append($t);
            		
            	});
            	changeColor();
        	} else{
        		$("#operation_service_List").html('<tr><td colspan="17"><p class="table-empty">'+data.message+'</p></td></tr>');  
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
	var id = $("input[name=rad]:checked").val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一台服务器！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
	        url : path + "/servers/deleteService",
	        type :"POST",
	        xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	id:id
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
 * 新建服务器
 */
function showModel(){
	openModule("../page/service/service_create.jsp",{},{},{},"");
}



$(document).on('click','#saves',function(){
	//设置一个对象来控制是否进入AJAX过程
	var post_flag = false; 
	 //如果正在提交则直接返回，停止执行
    if(post_flag) return; 
    //标记当前状态为正在提交状态
    post_flag = true;
	
	if(isValidIP($("#service_ip").val())){
		$.ajax({
			url : path + "/servers/insertService",
		    type :"POST",
		    xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	serverName:$("#service_name").val(),
		    	serverIp:$("#service_ip").val()
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
	}
	else{
		$("#red_title").text("服务器ip:不合法");
		$("#service_ip").css("background-color","#FFAF60");
		$("#red_title").css("color","#FFAF60");
	}
	
});


/**
 * 失去焦点事件,在输入服务器ip的时候去重
 */
$(document).on('blur','#service_ip',function(){
	if(isValidIP($("#service_ip").val())){
		$.ajax({
			url : path + "/servers/selectIpCount",
		    type :"POST",
		    xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	serverIp:$("#service_ip").val(),
		    },
		    dataType :"json",
		    success : function (data) {
		    	if(data.code==-4){
		    		$("#red_title").text(data.message);
			    	$("#service_ip").css("background-color","#FFD2D2");
			    	$("#red_title").css("color","#FF5151");
		    	}if(data.code==1){
		    		$("#red_title").text("服务器ip:可以插入");
		    		$("#red_title").css("color","#02DF82");
		    	}
		    	
		    },
		    error: function (data){
		    	$.alert({text:"网络异常,请稍后重试!"});
		    }
		});	  
	}else{
		$("#red_title").text("服务器ip:不合法");
		$("#service_ip").css("background-color","#FFAF60");
		$("#red_title").css("color","#FFAF60");
	}
	
	
	

});


function testService(){
	$.ajax({
		url : path + "/shellTest/test",
	    type :"POST",
	    xhrFields: {
	        withCredentials: true
	    },
	    dataType :"json",
	    success : function (data) {
	    	alert("success");
	    }
	});
}



 /*************************************************以下是页面布局,样式js无需关注******************************************************************/ 
 
/**
 * ip正则校验
 */
function isValidIP(ip) {
    var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
    return reg.test(ip);
} 
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
  	$("#operation_service_List").empty();
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
