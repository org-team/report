$(function(){
	serviceList(1,15);
});

var crd_params = null;
/**
 * 项目列表
 */
function serviceList(start,limit){
	$("#operation_service_List").empty();
	$.ajax({
        url : path + "/project/getProjectList",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	projectName:$("#projectName").val(),
	    	projectPath:$("#projectPath").val(),
	    	packagePath:$("#packagePath").val(),
	    	projectType: $('#projectType option:selected').val(),
	    	projectStatus: $('#projectStatus option:selected').val(),
	    	curPage:start,
			pageCount:limit
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		var fly= data.data.list;
        	
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
            		"	<td>"+(item.PROJECTNAME?item.PROJECTNAME:"--")+"</td>"+
            		"	<td>"+(item.PROJECTPATH?item.PROJECTPATH:"--")+"</td>"+
            		"	<td>"+(item.PACKAGEPATH?item.PACKAGEPATH:"--")+"</td>"+
            		"	<td>"+(item.PROJECTTYPE?item.PROJECTTYPE:"--")+"</td>"+
            		"	<td>"+(item.PROJECTSTATUS?item.PROJECTSTATUS:"--")+"</td>"+
            		"	<td>"+(item.CREATE_BY?item.CREATE_BY:"--")+"</td>"+
            		"	<td>"+(item.CREATETIME?item.CREATETIME:"--")+"</td>"+
            		"	<td>"+(item.VALID?item.VALID:"--")+"</td>"+
            		"	<td>"+(item.PROJECTURL?item.PROJECTURL:"--")+"</td>"+
            		"</span></td>"+
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
function searchProject(){
	serviceList(1,15);
}

/**
 * 删除项目
 * @param isPass
 */

function deleteProject() {
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
		$.alert({text:"请选择一个项目！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
	        url : path + "/project/delProject",
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
 * 新建项目
 */
function showProjectModel(){
	openModule("../page/project/addProject.jsp",{},{},{},"");
}


$(document).on('click','#saves',function(){
	
		$.ajax({
			url : path + "/project/addProject",
		    type :"POST",
		    xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	projectName:$("#projectName").val(),
		    	projectPath:$("#projectPath").val(),
		    	packagePath:$("#packagePath").val(),
		    	projectType:$("#projectType option:selected").val(),
		    	projectUrl:$("#projectUrl").val()
		    },
		    dataType :"json",
		    success : function (data) {
		    	$.alert({text:data.message});
		    	closeModule();
		    	serviceList(1,15);
		    },
		    error: function (data){
		    	$.alert({text:"网络异常,请稍后重试!"});
		    }
		});
	
});


/**
 * 失去焦点事件,在输入服务器ip的时候去重
 */
/*$(document).on('blur','#service_ip',function(){
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
*/






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
