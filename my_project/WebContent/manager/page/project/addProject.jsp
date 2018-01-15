<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="operation_service_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">增加项目</h4>
				</div>
				<div class="modal-body">
					<div class="row mt12">
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">项目名称</label>
							<input type="text" class="form-control" id="projectName" name="projectName">
						</div>
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">项目路径</label>
							<input type="text" class="form-control" id="projectPath" name="projectPath">
						</div>
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">包路径</label>
						</div>
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">包路径</label>
							<input type="text" class="form-control" id="packagePath" name="packagePath">
						</div>
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">包类型</label>
							<select class="form-control" id="projectType" name="projectType">
	                           <option value="">全部</option>
	                               <option value="1">jar</option>
	                               <option value="2">war</option>
                               <option value="3">静态</option>
                            </select>
						</div>
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">项目访问链接</label>
							<input type="text" class="form-control" id="projectUrl" name="projectUrl">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="saves">Save</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>