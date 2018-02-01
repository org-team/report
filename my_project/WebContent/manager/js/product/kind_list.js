$(function(){
	serviceList(1,15);
});
/**
 * 分类列表
 */
function serviceList(start,limit){
	$("#kind_List").empty();
	$.ajax({
        url : path + "/product/queryKind.action",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	curPage:start,
			pageCount:limit
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		var fly= data.data.lst;
        	
            	$("#kindListPaging").pagination(data.data.page,selectServiceTopage);
        		var pageCount = data.data.page.pageCount;
    			var curPage = data.data.page.curPage;
        		var total = curPage * pageCount;
        		var trHtml="";
            	$.each(fly, function(i, item) {
            		num = i+1;
            		trHtml ="<tr onclick=\"showQualityDetail(this);\">"+
        			"	<td><input name='rad' type='radio' value='"+item.kind_id+"'></td>"+	
            		"	<td>"+(total + num - pageCount)+"</td>"+
            		"	<td>"+(item.kind_id?item.kind_id:"--")+"</td>"+
            		"	<td>"+(item.kind_name?item.kind_name:"--")+"</td>"+
            		"</tr>";
            		var $t = $(trHtml);
            		$("#kind_List").append($t);
            		
            	});
        	} 
        	if(data.code==0){
        		$("#kind_List").html('<tr><td colspan="17"><p class="table-empty">'+data.message+'</p></td></tr>');  
        	}
        }
	});
}

/**
 * 手动添加分类
 */
function insertProduct(){
	openModule("../page/product/add_kind.html",{},{},{},"");
}
$(document).on('click','#saves',function(){
	//设置一个对象来控制是否进入AJAX过程
	var post_flag = false; 
	 //如果正在提交则直接返回，停止执行
    if(post_flag) return; 
    //标记当前状态为正在提交状态
    post_flag = true;
    $.ajax({
		url : path + "/product/addKind.action",
	    type :"POST",
	    xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	kindName:$("#add_kindName").val(),
	    	
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
 * 删除用户
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
	var kindId = $("input[name=rad]:checked").val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一个分类！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
	        url : path + "/product/deleteKindName2id.action",
	        type :"POST",
	        xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	kindId:kindId
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
 	$("#kind_List").empty();
 	serviceList(num,(count?count:15));
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




