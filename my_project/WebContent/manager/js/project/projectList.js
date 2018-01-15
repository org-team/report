
/**
 * 按条件查询
 */
function searchProject(){
	queryProject(1,15);
}
/**
 * 项目列表
 * @param start
 * @param limit
 */
function queryProject(start,limit){
	$("#operation_project_list").empty();
//	alert(path + "/project/getProjectList");
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
            	$("#projectListPaging").pagination(data.data.page,selectProjectTopage);
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
            		
            		$("#operation_project_List").append($t);
            		
            	});
            	changeColor();
        	} else{
        		$("#operation_project_List").html('<tr><td colspan="17"><p class="table-empty">'+data.message+'</p></td></tr>');  
        	}
        }
	});
}


$(function(){
	queryProject(1,15);
});

var crd_params = null;
/**
 * @author zhangKangChuang
 * 服务器列表
 */



/**
 * 删除项目
 * @param isPass
 */
function deleteService() {
	//弹出框
	$.confirm({
		text : "是否继续操作",
		callback : function(a) {
			if (a == true) {
				isDelete();
				queryProject(1,15);
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
 * 上传项目
 * @param isPass
 */
function uploadProject() {
	//弹出框
	$.confirm({
		text : "是否继续操作",
		callback : function(a) {
			if (a == true) {
				isUpload();
				queryProject(1,15);
			}
		}
	});
}
function isUpload(){
	var id = $("input[name=rad]:checked").val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一个项目！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
			url : path + "/project/uploadProject2Service",
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
 * 发布项目
 * @param isPass
 */
function uploadProject() {
	//弹出框
	$.confirm({
		text : "是否继续操作",
		callback : function(a) {
			if (a == true) {
				isRelease();
				queryProject(1,15);
			}
		}
	});
}
function isRelease(){
	var id = $("input[name=rad]:checked").val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一个项目！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
			url : path + "/project/releaseProject2Service",
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
 * 增加项目
 */
function showProjectModel(){
	openModule("../page/project/addProject.jsp",{},{},{},"");
}

$(document).on('click','#saves',function(){
	/*alert(document.getElementById("projectName").value);
	alert("项目名称"+$("#projectName").val());
	alert("项目路径" +$("#projectPath").val());
	alert("包路径"+$("#packagePath").val());
	alert("包类型"+$("#projectType option:selected").val());
	alert("路径"+$("#projectUrl").val());*/
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
	    	queryProject(1,15);
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
  function selectProjectTopage(num,count) {
  	if (null == num || "" == num || isNaN(parseInt(num))) {
  		alert("请输入数字");
   		return;
  	}
  	$("#operation_project_list").empty();
  	queryProject(num,(count?count:15));
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
