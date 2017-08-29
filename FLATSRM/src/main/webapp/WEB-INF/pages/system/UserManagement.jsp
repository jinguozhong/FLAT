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
							<li class="active">用户管理</li>
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
					 
					<div class="page-content" id="userMG-content"> 
						<div class="row">
							<div class="col-xs-12">  
								<div class="row">
									<div class="col-sm-3">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="widget-title lighter">
													<i class="ace-icon glyphicon glyphicon-list orange"></i>
													用户列表
												</h4>

												<div class="btn-group" style="float: right;">
													<button data-toggle="dropdown" class="btn btn-sm btn-success dropdown-toggle">
														操作内容
														<i class="ace-icon fa fa-angle-down icon-on-right"></i>
													</button> 
													<ul class="dropdown-menu dropdown-danger toolbar">
														<shiro:hasPermission name="system/userMG/add"> 
															<li class="according">
																<a href="javascript:void(this)" onclick="common.add(this,'userMG-content','content','userGMTree')">新增</a>
															 </li> 
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/addChild"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.addChild(this,'userMG-content','content','userGMTree')">新增子节点</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/edit"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.edit(this,'userMG-content','content')">修改</a>
														</li> 
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/save"> 
														<li hidden="hidden" class="tohidden">
															<a href="javascript:void(this)" onclick="common.saveFrom(this,'userMG-content','content','userGMTree','userFrom')">保存</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/dele"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.dele(this,'userMG-content','content','userGMTree','system/userMG','role-gridTable')">删除</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/find"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.find(this,'userMG-content','userGMTree','userMG')">查找</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/cancel"> 
														<li hidden="hidden" class="tohidden">
															<a href="javascript:void(this)" onclick="userMG.cancel(this,'userMG-content','userGMTree','userMG')">取消</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/mobile"> 
														<li class="according">
															<a href="javascript:void(this)" onclick="common.mobile(this,'userMG-content','userGMTree')">节点移动</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/mobileTo"> 
														<li hidden="hidden" class="tohiddenMobile">
															<a href="javascript:void(this)" onclick="common.mobileTo(this,'userMG-content','userGMTree','userMG')">节点移动至</a>
														</li>
														</shiro:hasPermission>
														<shiro:hasPermission name="system/userMG/passwordInit"> 
														<li   class="according">
															<a href="javascript:void(this)" onclick="userMG.passInit()">密码重置</a>
														</li>
														</shiro:hasPermission>
													</ul>
												</div><!-- /.btn-group -->
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding tree-panel" id="userColumn"  >
													  <!--ztree树节点  -->
         											  <ul id="userGMTree" class="ztree"></ul>
												</div><!-- /.widget-main -->
											</div><!-- /.widget-body -->
										</div><!-- /.widget-box -->
									</div><!-- /.col -->

									<div class="col-sm-8">
										<div class="tabbable">
											<ul class="nav nav-tabs" id="myTab">
												<li class="active">
													<a data-toggle="tab" href="#user_information">
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
												<div id="user_information" class="tab-pane fade in active" style="padding: 9px;">
													<form id="userFrom"> 
								                        <table>
								                        	<tbody>
								                        		<tr hidden="hidden">
								                        			<th > <label for="id">id:</label></th>
								                        			 <th class='thWidth'>  
									                        			 <input type="text" readonly="true" maxlength='60' id="id"  name="id" placeholder="id"   >
								                        			 
								                        			 </th> 
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="mail">邮箱地址:</label></th>
								                        			 <th class='thWidth'>  
									                        			 <input type="email" class='from-control'  readonly="true" maxlength='60' id="mail" name="mail" placeholder="Enter email"  datatype="e"  nullmsg="请输入邮箱">
								                        			 
								                        			 </th> 
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="username">用户名称:</label></th>
								                        			 <th class='thWidth'><input type="text" class='from-control'   readonly="true" maxlength='60' id="username" name="name"placeholder="用户名称" datatype="*"  nullmsg="请输入用户名" ></th> 
								                        			 
								                        		</tr>
								                        		<tr>
								                        			<th> <label for="company">公司名称:</label></th>
								                        			 <th class='thWidth'><input type="text"  class='from-control'  readonly="true" disabled="disabled"   maxlength='60' name="company"  id="company" placeholder="公司名称"></th> 
								                        			 
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
													 <table id="role-gridTable"></table>  
													 <div id="role-gridPager"></div> 
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
		<script type="text/javascript" src="${basePath}/resources/js/srm/system/userMG.js"></script>
		
		<script type="text/javascript">
			
		 	$(function(){
		 		//计算高度
		 		height=common.setHeight($("#userColumn"));
		 		width=$("#content").outerWidth();
		 		//初始化ztree
		 		userMG.ztreeIni($("#userGMTree")); 
		 		//初始化jqgrid
		 		userMG.jqgridIni($("#role-gridTable"));
		 		//上级节点点击事件
		 		userMG.onclickPname(); 
		 		//上级节点模糊查询回车事件
	 		    $("#pname").keydown(function(event){
	 		    	
 		    	 	event=document.all?window.event:event;
	 			    if((event.keyCode || event.which)==13){
	 			    	common.fuzzy(this,'userMG-content','content','pname','user');
	 			    }
	 		    });
		 		//表格验证
	 		    userMG.validation($("#content").find("#msgdemo2"));
		 	})
		  
		 	
		  </script>
	</body>
</html>




