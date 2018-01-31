$(document).on('click','#submit',function(){
	$.ajax({
		url : path + "/usermanager/login.action",
        type :"POST",
        xhrFields: {
	        withCredentials: true
	    },
	    data:{
	    	userName:$("#userName").val(),
	    	password:$("#password").val()
	    },
	    dataType :"json",
        success : function (data) {
        	if(data.code==1){
        		window.setTimeout("window.location='index.html'",1000); 
        	}else{
        		alert(data.message);
        	}
        }
	});
});