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
				<li><a href="#">服务器运维系统</a></li>
				<li><a href="#">项目管理</a></li>
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
							<h4>项目列表</h4>
							<div class="drop-on">
								<span><i class="glyphicon glyphicon-chevron-up"></i></span>
							</div>
							<div class="drop-down">
	                            <span><i class="glyphicon glyphicon-chevron-down"></i></span>
	                        </div>
						</header>
						<div class="info-select clearfix">
							<form id="bankflow-search-form" class="form-inline" >
								<div class="row">
									<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-4">
	                                    <label>
	                                    	<p>项目名： </p>
	                                        <input class="form-control inputElem" type="text" name="projectName" id="projectName" >
	                                    </label>
	                                </div>
	                                <div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-4">
	                                    <label>
	                                    	<p>上传路径：</p>
	                                        <input class="form-control inputElem" type="text" name="projectPath" id="projectPath" >
	                                    </label>
	                                </div>
	                                <div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-4">
	                                    <label>
	                                    	<p>上传包所在路径：</p>
	                                        <input class="form-control inputElem" type="text" name="packagePath" id="packagePath" >
	                                    </label>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-4">
	                                    <label>
	                                    	<p>包类型：</p>
	                                        <select class="form-control" id="projectType" name="projectType">
                                            	<option value="">全部</option>
                                                <option value="1">jar</option>
                                                <option value="2">war</option>
                                                <option value="3">静态</option>
                                             </select>
	                                    </label>
	                                 </div>
                                    <div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-4">
	                                    <label>
	                                    	<p>状态：</p>
	                                        <select class="form-control" id="projectStatus" name="projectStatus">
                                            	<option value="">全部</option>
                                                <option value="1">运行</option>
                                                <option value="2">停止</option>
                                                <option value="3">停用</option>
                                             </select>
	                                    </label>
                                    </div>
                                    <!-- <div class="form-group col-xs-24 col-sm-12 col-md-12 col-lg-8">
                                    	<label>
	                                    	<p>交易时间：</p>
	                                        <input class="Wdate form-control" type="text" id="beginTime" name="beginTime" readonly onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')||\'2020-10-01\'}',dateFmt:'yyyy-MM-dd HH:mm:ss'})">
	                           				-
	                                        <input class="Wdate form-control" type="text" id="endTime" name="endTime" readonly onFocus="WdatePicker({minDate:'#F{$dp.$D(\'beginTime\')}',maxDate:'2020-10-01',dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                           				</label>
                           			</div> -->
								<div class="row">
	                           		<div class="form-group col-xs-12">
	                           			<%-- 
	                           			<auth:menu menuId="425"><button class="xinzeng btn btn-sm btn-default fr mr20" type="button" onclick="javascript:search()">
	                           			<em class="glyphicon glyphicon-search"></em>查询</button></auth:menu>
	                           			 --%>
	                           			<button class="xinzeng btn btn-sm btn-default fr mr20" type="button" onclick="searchProject();">
	                           			<em class="glyphicon glyphicon-search"></em>查询</button>
	                           			
	                           		</div>
                                </div>
							</form>
							</div>
							
							<div class="panel-heading panel-new">
			                	<button class="btn btn-sm btn-default" type="button" onclick="showProjectModel()">
			                     	<span class="glyphicon glyphicon-ok"></span>增加项目
			                    </button> 
			                    <button class="btn btn-sm btn-default" type="button" onclick="deleteProject()">
			                     	<span class="glyphicon glyphicon-remove"></span>删除项目
			                    </button> 
			                    <button class="btn btn-sm btn-default" type="button" onclick="uploadProject()">
			                     	<span class="glyphicon glyphicon-arrow-up"></span>上传项目
			                    </button> 
			                    <button class="btn btn-sm btn-default" type="button" onclick="releaseProject()">
			                     	<span class="glyphicon glyphicon-plane"></span>发布项目
			                    </button> 
							</div>		
							<!--列表开始-->
							<div class="panel-content table-responsive">
								<table id="bankflow-table" class="table table-hover">
									<thead>
										<tr>
											<th><input id="all" type="checkbox" /></th>
											<th>序号</th>
											<th>项目名</th>
											<th>项目路径</th>
											<th>包路径</th>
											<th>项目类型</th>
											<th>项目运行状态</th>
											<th>创建人</th>
											<th>创建时间</th>
											<th>有效标志</th>
											<th>项目访问链接</th>
											<th>操作</th>
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
	<script type="text/javascript" src="/operation/js/project/project_list.js"></script>
	
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