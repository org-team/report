//公共模板下载方法
function downloadModel(modelname) {
	var _url = context + "/excelmodel";
	var form = $("<form>");
	form.attr("style", "display:none");
	form.attr("target", "");
	form.attr("method", "post");
	form.attr("action", _url);
	var input = $("<input>");
	input.attr("type", "hidden");
	input.attr("name", "modelname");
	input.attr("value", modelname);
	$("body").append(form);
	form.append(input);
	form.submit();
}