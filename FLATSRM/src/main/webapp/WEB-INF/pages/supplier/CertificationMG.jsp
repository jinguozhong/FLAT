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
    	<style type="text/css">
			.page-content{
				padding: 0px 0px 0px 0px;
			}
			.formWidth table {width: 100%;}
			.formWidth td{padding: 6px;}
			.formWidth input {width: 100%;
				border-style: none;
				border-bottom: 1px solid #000;
			}
			.formWidth textarea {width: 100%;
				border-style: none;
				border-bottom: 1px solid #000;
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
							<li class="active">供应商管理/供应商认证</li><!--模板修改-->
						</ul><!-- /.breadcrumb -->
						<div class="nav-search" id="nav-search">
							<div class="btn-group" style="float: right;">
								<button data-toggle="dropdown" class="btn btn-sm btn-success dropdown-toggle">
									操作内容
									<i class="ace-icon fa fa-angle-down icon-on-right"></i>
								</button>
								<ul class="dropdown-menu dropdown-danger toolbar">
									<li class="according">
										<a href="javascript:void(this)" >新增</a>
									</li>
								</ul>
							</div><!-- /.btn-group -->
						</div><!-- /.nav-search -->
					</div>
					<div class="page-content" id="certificationMG-content"> <!--模板修改-->
						<div class="row">
							<div class="col-xs-12">
								<table id="supplier-gridTable"></table>
								<div id="supplier-gridPager"></div>
							</div>
						</div>
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<%--  <%@include file="/WEB-INF/pages/common/footer.jsp" %> --%>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->   

		<script type="text/javascript"  src="${basePath}/resources/assets/js/grid.locale-cn.js"></script>
		<!-- page specific plugin scripts -->
		<script type="text/javascript" src="${basePath}/resources/js/srm/supplier/certificationMG.js"></script>

		<script type="text/javascript">
		 	$(function(){
		 	    var gridTable=$("#supplier-gridTable");
                var parent_column = gridTable.closest('[class*="col-"]');
		 		//计算高度
                var height=window.innerHeight-193;
		 		var width=parent_column.width();
		 		//初始化jqgrid
                certificationMG.jqgridIni(gridTable,width,height);
                //resize to fit page size
                $(window).on('resize.jqGrid', function () {
                    gridTable.jqGrid( 'setGridWidth', parent_column.width());
                })
		 	})


		  </script>
	</body>
</html>




