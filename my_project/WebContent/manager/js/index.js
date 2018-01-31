$(function(){
	$.ajax({
		url : path + "/usermanager/getLogger.action",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		$("#userName").text(data.data.userName);
        	}else{
        		window.setTimeout("window.location='login.html'",100);
        	}
        }
	});
});