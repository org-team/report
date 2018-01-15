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
					<h4 class="modal-title" id="myModalLabel">新建服务器</h4>
				</div>
				<div class="modal-body">
					<div class="row mt12">
						<div class="form-group  col-xs-12">
							<label for="exampleInputEmail1">服务器名称</label>
							<input type="text" class="form-control" id="service_name">
						</div>
						<div class="form-group  col-xs-12">
							<label id="red_title" for="exampleInputEmail1">服务器ip</label>
							<input type="text" class="form-control" id="service_ip">
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