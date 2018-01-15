<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.zy_lv{color:green;}
.zy_hong{color:red;}
</style>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<ol class="page-header breadcrumb">
				<li><a href="#">Home</a></li>
				<li><a href="#">运维系统</a></li>
				<li><a href="#">服务器管理</a></li>
				<li class="active">服务器列表</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="dataTable_wrapper">
						<div class="dataTable-info">
							<header>
								<h4>查询</h4>
								<!--表单显示及隐藏-->
								<div class="drop-on">
									<span><i class="glyphicon glyphicon-chevron-up"></i></span>
								</div>
								<div class="drop-down">
									<span><i class="glyphicon glyphicon-chevron-down"></i></span>
								</div>
							</header>
							<div class="info-select clearfix dataTable-info">
								<form class="form-inline" id="crd_form_query">
									<div class="row mt10">
										<div class="form-group  col-xs-5">
											<label>
												<p style="width: 80px;">服务器名称：</p> <input type="text" class="form-control" id="serverName">
											</label>
										</div>
									</div>
									
									<div class="row mt10">
										<div class="form-group  col-xs-5">
											<label>
												<p style="width: 80px;">服务器ip：</p>
												<input type="text" class="form-control" id="serverIp">
											</label>
										</div>
										
										<div class="form-group  col-xs-5">
											<label>
												<p style="width: 80px;">运行状态：</p>
												<select id="serverStatus" class="form-control" name="serverStatus">
													<option value="">全部</option>		
													<option value="1">运行</option>			
													<option value="2">挂掉</option>			
													<option value="3">禁用</option>			
					                            </select>
											</label>
										</div>
									</div>
									
									<div class="row">
										<div class="col-xs-12">
											<button type="button" class="btn btn-default btn-sm fr mr20" onclick="searchService()">查询</button>
										</div>
									</div>
								</form>
							</div>
							
							<div class="panel-heading panel-new">
                            	<button class="btn btn-sm btn-default" type="button" onclick="showModel()">
                                 	<span class="glyphicon glyphicon-ok"></span>新建服务器
                                </button> 
                                <button class="btn btn-sm btn-default" type="button" onclick="deleteService()">
                                 	<span class="glyphicon glyphicon-remove"></span>删除服务器
                                </button> 
                                
                                <button class="btn btn-sm btn-default" type="button" onclick="testService()">
                                 	<span class="glyphicon glyphicon-remove"></span>测试脚本
                                </button>
                               
                            </div>				
							<!--列表开始-->
							<div class="panel-content table-responsive tab-content">
								<table class="table table-hover">
									<thead>
										<tr>
											<th></th>
											<th>序号</th>
											<th>服务器名称</th>
											<th>服务器ip</th>
											<th>创建人</th>
											<th>创建时间</th>
											<th>运行状态</th>
										</tr>
									</thead>
									<tbody id="operation_service_List">
										
									</tbody>
								</table>
							</div>
							<!--列表结束-->
							<!--分页-->
							<div class="pagination pagination-sm" id="serviceListPaging">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--列表结束-->
	<!--分页-->
	<div class="pagination pagination-sm" id="complainListPaging">
	</div>
	
	<script type="text/javascript" src="/operation/js/common/path.js"></script>
	<script type="text/javascript" src="/operation/js/service/service_list.js"></script>
	
	<script>
		$(function() {
			/*提示框*/
			$(function() {
				$('[data-toggle="tooltip"]').tooltip()
			})
			/*loading*/
			$('#shclDefault').shCircleLoader();
			/*tab栏选择*/
			tabx(".tab-item", ".main")
			/*表单合并*/
			drop(".drop-on", ".drop-down", ".info-select");
			/*Tab栏滑动*/
			tabs(".mytabs-wrap");
			/*邮箱验证*/
			$(function() {
				new EmailAutoComplete({})
			});
			/*表格点击行高亮*/
			trColor("#crd_comPlain_List > tr");
			/*阻止冒泡*/
			$("#complainListPaging > tr input[type=radio]").click(function(event) {
				event.stopPropagation();
			});
			/*表格单选*/
			radioColor("#radio_tbody > tr");
			
		});
	</script>
</body>
</html>