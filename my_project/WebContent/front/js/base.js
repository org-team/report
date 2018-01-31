function loadjscssfile(filename, filetype) {
	if (filetype == "js") { //判定文件类型
		var fileref = document.createElement("script");//创建标签
		fileref.setAttribute("type", "text/javascript");//定义属性type的值为text/javascript
		fileref.setAttribute("src", filename);//文件的地址            
	} else if (filetype == "css") { //判定文件类型
		var fileref = document.createElement("link");
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", filename);
	}
	if (typeof fileref != "undefined")
		document.getElementsByTagName("head")[0].appendChild(fileref);
}

function getRootPath_web() {
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
//监控退出登录按钮
function seeLogin(){
	var token=localStorage.token;
	if(token==null||token==""){
		$(".check_button").hide();
		$(".login_button").show();	
	}
	else{
		$(".check_button").show();
		$(".login_button").hide();	
	}	
}
//退出登录
function checkOut(){
	var con;
	con=confirm("您将要退出登录")
	if(con==true){
	localStorage.token="";
	}
	location.reload();
}
