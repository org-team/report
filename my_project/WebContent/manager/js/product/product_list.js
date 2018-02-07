$(function(){
	serviceList(1,15);
});
/**
 * 产品列表
 */
function serviceList(start,limit){
	$("#role_List").empty();
	$.ajax({
        url : path + "/product/selectProductInfoList.action",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	curPage:start,
			pageCount:limit,
			productName:$("#productName").val()
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		var fly= data.data.lst;
        	
            	$("#roleListPaging").pagination(data.data.page,selectServiceTopage);
        		var pageCount = data.data.page.pageCount;
    			var curPage = data.data.page.curPage;
        		var total = curPage * pageCount;
        		var trHtml="";
            	$.each(fly, function(i, item) {
            		num = i+1;
            		trHtml ="<tr onclick=\"showQualityDetail(this);\">"+
        			"	<td><input name='rad' type='radio' value='"+item.product_id+"'></td>"+	
            		"	<td>"+(total + num - pageCount)+"</td>"+
            		"	<td>"+(item.product_name?item.product_name:"--")+"</td>"+
            		"	<td>"+(item.kind_name?item.kind_name:"--")+"</td>"+
            		"	<td>"+(item.price_old?item.price_old:"--")+"</td>"+
            		"	<td>"+(item.price_new?item.price_new:"--")+"</td>"+
            		"	<td>"+(item.unit?item.unit:"--")+"</td>"+
            		"	<td>"+(item.total?item.total:"--")+"</td>"+
            		"	<td>"+(item.surplus?item.surplus:"--")+"</td>"+
            		"	<td><a href='javascript:;' onclick=showProductDetail('"+item.product_id+"')>查看</a></td>"+
            		"</tr>";
            		var $t = $(trHtml);
            		$("#role_List").append($t);
            		
            	});
        	} 
        	if(data.code==0){
        		$("#role_List").html('<tr><td colspan="17"><p class="table-empty">'+data.message+'</p></td></tr>');  
        	}
        }
	});
}
/**
 * 查看商品详情
 */
function showProductDetail(productId){
	alert(productId);
}

/**
 * 条件查询
 */
function searchService(){
	serviceList();
}

/**
 * 手动添加商品
 */
function insertProduct(){
	openModule("../page/product/add_product.html",{},{},{},"");
}
$(document).on('click','#saves',function(){
	//设置一个对象来控制是否进入AJAX过程
	var post_flag = false; 
	 //如果正在提交则直接返回，停止执行
    if(post_flag) return; 
    //标记当前状态为正在提交状态
    post_flag = true;
    $.ajax({
		url : path + "/product/addProduct.action",
	    type :"POST",
	    xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	productName:$("#add_productName").val(),
	    	kindId:$("#add_kindId").val(),
	    	property:$("#add_property").val(),
	    	productDescribe:$("#add_productDescribe").val(),
	    	source: $('#add_source option:selected').val(),
	    	model:$("#add_model").val(),
	    	unit: $('#add_unit option:selected').text(),
	    	priceOld:$("#add_priceOld").val(),
	    	kindId: $('#add_kindId option:selected').val(),
	    	total:$("#add_total").val(),
	    	productImgMain:$("#add_productImgMain").val(),
	    	productImgAssist:$("#add_productImgAssist").val(),
	    	remark:$("#add_remark").val()
	    },
	    dataType :"json",
	    success : function (data) {
	    	post_flag =false; //在提交成功之后将标志标记为可提交状态
	    	$.alert({text:data.message});
	    	closeModule();
	    	//serviceList(1,15);
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
$(document).on('blur','#add_roleName',function(){
	$.ajax({
		url : path + "/roleManager/isExistRoleName.action",
	    type :"POST",
	    xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	roleName:$("#add_roleName").val(),
	    },
	    dataType :"json",
	    success : function (data) {
	    	if(data.code==1){
	    		$("#red_title").text("权限名:合法");
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
	var roleId = $("input[name=rad]:checked").val();
	var check=$("input[name=rad]:checked").length;
	if(check==0){
		$.alert({text:"请选择一个用户！"});
	}else if(check>1){
		$.alert({text:"不能进行批量操作"});
	}else if(check==1){
		$.ajax({
	        url : path + "/roleManager/deleteRoleByRoleId.action",
	        type :"POST",
	        xhrFields: {
		        withCredentials: true
		    },
		    data:{
		    	roleId:roleId
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
 	$("#role_List").empty();
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
