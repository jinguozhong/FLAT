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
							<li class="active">角色管理</li><!--模板修改-->
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
					 
					<div class="page-content" id="roleMG-content"> <!--模板修改-->
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
														<shiro:hasPermission name="system/roleMG/add"> 
															<li class="according">
																<a href="javascript:void(this)" onclick="common.add(this,'roleMG-content','content','roleGMTree')">新增</a><!--模板修改-->
															 </li>
														</shiro:hasPermission> 	 
														<shiro:hasPermission name="system/roleMG/addChild"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.addChild(this,'roleMG-content','content','roleGMTree')">新增子节点</a><!--模板修改-->
														</li>
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/edit"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.edit(this,'roleMG-content','content')">修改</a><!--模板修改-->
														</li> 
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/save"> 
														<li hidden="hidden" class="tohidden">
															<a href="javascript:void(this)" onclick="common.saveFrom(this,'roleMG-content','content','roleGMTree','roleFrom')">保存</a><!--模板修改-->
														</li>
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/dele"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.dele(this,'roleMG-content','content','roleGMTree','system/roleMG','role-gridTable')">删除</a><!--模板修改-->
														</li>
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/find"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.find(this,'roleMG-content','roleGMTree','roleMG')">查找</a><!--模板修改-->
														</li>
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/cancel"> 
														<li hidden="hidden" class="tohidden">
															<a href="javascript:void(this)" onclick="roleMG.cancel(this,'roleMG-content','roleGMTree','roleMG')">取消</a><!--模板修改-->
														</li>
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/mobile"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.mobile(this,'roleMG-content','roleGMTree')">节点移动</a><!--模板修改-->
														</li>
														</shiro:hasPermission> 
														<shiro:hasPermission name="system/roleMG/mobileTo"> 
														<li hidden="hidden" class="tohiddenMobile">
															<a href="javascript:void(this)" onclick="common.mobileTo(this,'roleMG-content','roleGMTree','roleMG')">节点移动至</a><!--模板修改-->
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
														基本信息
													</a>
												</li>

												<li>
													<a data-toggle="tab" href="#messages">
														角色信息 
													</a>
												</li>

												<li class="dropdown">
													<a data-toggle="tab" href="#system">
														系统信息 &nbsp; 
													</a> 
												</li>
											</ul>

											<div class="tab-content" id="content">
												<div id="information" class="tab-pane fade in active" style="padding: 9px;">
													<form id="roleFrom"> <!--模板修改-->
								                        <table>
								                        	<tbody>
								                        		<tr hidden="hidden">
								                        			<th > <label for="id">id:</label></th>
								                        			 <th class='thWidth'>  
									                        			 <input type="text" readonly="true" maxlength='60' id="id"  name="id" placeholder="id"   >
								                        			 
								                        			 </th> 
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="code">代码:</label></th>
								                        			 <th class='thWidth'>  
									                        			 <input type="text" class='from-control'  readonly="true" maxlength='60' id="code" name="code" placeholder="代码"  datatype="*"  nullmsg="请输入代码">
								                        			 
								                        			 </th> 
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="name">角色名称:</label></th>
								                        			 <th class='thWidth'><input type="text" class='from-control'   readonly="true" maxlength='60' id="name" name="name"placeholder="角色名称" datatype="*"  nullmsg="请输入角色名" ></th> 
								                        			 
								                        		</tr> 
								                        		<tr>
								                        			<th> <label for="state">状态:</label></th>
								                        			 <th class='thWidth'> 
								                        			 	<select  id="state" name="state" class="form-control "   placeholder="状态"  disabled="disabled"  >
									                                            <option value="2">启用</option>
									                                            <option value="1">停用</option>
									                                    </select>
								                        			 </th> 
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="isParent">是否汇总节点:</label></th>
								                        			 <th class='thWidth'> 
							                        			 		 <select id="isParent" class="form-control from-select"   name="isParent"  disabled="disabled" 　placeholder="是否汇总节点"  > 
								                                            <option value="false">明细</option>
								                                            <option value="true">汇总</option>
								                                        </select>
								                        			 </th>
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="Pname">上级节点:</label></th>
								                        			 <th class='thWidth' >
								                        			 	<input type="text" class='from-control'   readonly="true"   maxlength='60' id="pname"  name="pname" datatype="*"  nullmsg="请输入上级节点"
								                        			 	 placeholder="上级节点" dictionary="true"  >
								                        			 </th>
								                        		</tr>
								                        		<tr>
									                        		<span id="msgdemo2" style="margin-left:30px;color: red"></span>
									                        	</tr>
								                        	</tbody>
								                        </table>
							                    	</form>
												</div>

												<div id="messages" class="tab-pane fade" style="overflow: auto;">
													 <table id="user-gridTable"></table>  <!--模板修改-->
													 <div id="user-gridPager"></div> <!--模板修改-->
												</div>

												<div id="system" class="tab-pane fade">  
												 	<table width="100%" class="table">
						                         		<tbody>
						                         			<tr>
						                         				<td>新增时间：</td> 
						                         				<td id="NewTime"> </td> 
						                         				<td>修改时间：</td> 
						                         				<td id="UpdateTime"></td> 
						                         			</tr>
						                         			<tr>
						                         				<td>新增人员：</td> 
						                         				<td id="NewBy"> </td> 
						                         				<td>修改人员：</td>
						                         				<td id="UpdateBy"> </td>  
						                         			</tr>
						                         		</tbody>
						                         	</table> 
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
		<script type="text/javascript" src="${basePath}/resources/js/Validform/js/Validform_v5.3.2.js"></script> 
		<script type="text/javascript" src="${basePath}/resources/js/srm/common.js"></script>
		<script type="text/javascript" src="${basePath}/resources/js/srm/system/roleMG.js"></script>
		
		<script type="text/javascript">
			
		 	$(function(){
		 		//计算高度
		 		height=common.setHeight($("#roleColumn"));
		 		width=$("#content").outerWidth();
		 		//初始化ztree
		 		 roleMG.ztreeIni($("#roleGMTree")); 
		 		//初始化jqgrid
		 		roleMG.jqgridIni($("#user-gridTable"));
		 		//上级节点点击事件
		 		roleMG.onclickPname(); 
		 		//上级节点模糊查询回车事件
	 		    $("#pname").keydown(function(event){
	 		    	
 		    	 	event=document.all?window.event:event;
	 			    if((event.keyCode || event.which)==13){
	 			    	common.fuzzy(this,'roleMG-content','content','pname','role');
	 			    }
	 		    });
		 		//表格验证
	 		    roleMG.validation($("#content").find("#msgdemo2")); 
		 		
	 		  
		 		 
		 		
		 	})
		  
		 	
		  </script>
	</body>
</html>




