 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html lang="en">
	<%@ include file="/WEB-INF/pages/common/common.jsp" %>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>FLAT供应平台</title> 
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- The fav icon -->
    	<link rel="shortcut icon" href="${basePath}/resources/img/FGG.ico"> 
    	<link rel="stylesheet" href="${basePath}/resources/js/ztree/zTreeStyle/zTreeStyle.css" />
    	<link rel="stylesheet" href="${basePath}/resources/js/ztree/zTreeStyle/demo.css" />
    	<%--<link rel="stylesheet" href="${basePath}/resources/assets/css/bootstrap-datepicker3.min.css" />--%>
		<link rel="stylesheet" href="${basePath}/resources/js/Validform/css/demo.css" /> 
    	<style type="text/css">
    		 .thWidth{
	   				width:500px;
	   				padding: 4px;
	   			} 
	   		.lableWidth{
	   			width:100px;
	   		}	
    		.thWidth>input {
				width:100%;
			}
			.tab-content{
				 padding: 0 0
			}
    	</style>
	</head>

	<body class="no-skin" id="bodyId">
		<%@include file="/WEB-INF/pages/common/head.jsp" %>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
 			<%@include file="/WEB-INF/pages/common/menu.jsp" %>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="${basePath}/admin/index">Home</a>
							</li>
							<li class="active">授权管理</li><!--模板修改-->
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>
					 
					<div class="page-content" id="authorizationMG-content"> <!--模板修改-->
						<div class="row">
							<div class="col-xs-12">  
								<div class="row">
									<div class="col-sm-3">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="widget-title lighter">
													<i class="ace-icon glyphicon glyphicon-list orange"></i>
													角色列表<!--模板修改-->
												</h4>

												<div class="btn-group" style="float: right;">
													<button data-toggle="dropdown" class="btn btn-sm btn-success dropdown-toggle">
														操作内容
														<i class="ace-icon fa fa-angle-down icon-on-right"></i>
													</button> 
													<ul class="dropdown-menu dropdown-danger toolbar">
														<shiro:hasPermission name="system/authorizationMG/edit">
														<li class="according">
															<a href="javascript:void(this)" onclick="authorizationMG.edit()">授权编辑</a><!--模板修改-->
														</li> 
														</shiro:hasPermission>
													</ul>
												</div><!-- /.btn-group -->
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding tree-panel" id="roleColumn"  ><!--模板修改-->
													  <!--ztree树节点  -->
         											  <ul id="roleGMTree" class="ztree"></ul><!--模板修改-->
												</div><!-- /.widget-main -->
											</div><!-- /.widget-body -->
										</div><!-- /.widget-box -->
									</div><!-- /.col -->

									<div class="col-sm-8">
										<div class="tabbable">
											<ul class="nav nav-tabs" id="myTab">
												<li class="active">
													<a data-toggle="tab" href="#information"> 
														<i class="green ace-icon fa fa-home bigger-120"></i>
														操作授权信息
													</a>
												</li> 
												<li class="dropdown">
													<a data-toggle="tab" href="#system">
														数据授权信息 &nbsp; 
													</a> 
												</li>
											</ul>

											<div class="tab-content" id="content">
												<div id="information" class="tab-pane fade in active"  >
													 <!--ztree树节点  -->
         											  <ul id="permissionsGMTree" class="ztree"></ul><!--模板修改-->
												</div> 
												<div id="system" class="tab-pane fade">  
												 	 
												</div> 
											</div>
										</div>
									</div><!-- /.col -->
								</div><!-- /.row --> 
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row --> 
					</div><!-- /.page-content -->
				</div> 
			</div><!-- /.main-content -->

			<%--  <%@include file="/WEB-INF/pages/common/footer.jsp" %> --%>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->   
		
		<script type="text/javascript" src="${basePath}/resources/js/ztree/jquery.ztree.all.js"></script> 
		<script type="text/javascript"  src="${basePath}/resources/assets/js/grid.locale-cn.js"></script>
		<!-- page specific plugin scripts -->
		<%--<script type="text/javascript" src="${basePath}/resources/assets/js/bootstrap-datepicker.min.js"></script> --%>
		<script type="text/javascript" src="${basePath}/resources/js/srm/common.js"></script>
		<script type="text/javascript" src="${basePath}/resources/js/srm/system/authorizationMG.js"></script>
		
		<script type="text/javascript">
			
		 	$(function(){
		 		//计算高度
		 		height=common.setHeight($("#roleColumn"));
		 		width=$("#content").outerWidth();
		 		//初始化ztree
		 	    authorizationMG.ztreeIni($("#roleGMTree"));  
		 		authorizationMG.permissionsZtreeIni($("#permissionsGMTree")) 
		 		
		 	})
		  
		 	
		  </script>
	</body>
</html>




