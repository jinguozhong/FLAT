 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="sidebar" class="sidebar responsive ace-save-state">
<script type="text/javascript">
	try{ace.settings.loadState('sidebar')}catch(e){}
</script>

<div class="sidebar-shortcuts" id="sidebar-shortcuts">
	<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
		<button class="btn btn-success">
			<i class="ace-icon fa fa-signal"></i>
		</button>

		<button class="btn btn-info">
			<i class="ace-icon fa fa-pencil"></i>
		</button>

		<button class="btn btn-warning">
			<i class="ace-icon fa fa-users"></i>
		</button>

		<button class="btn btn-danger">
			<i class="ace-icon fa fa-cogs"></i>
		</button>
	</div>

	<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
		<span class="btn btn-success"></span>

		<span class="btn btn-info"></span>

		<span class="btn btn-warning"></span>

		<span class="btn btn-danger"></span>
	</div>
</div><!-- /.sidebar-shortcuts -->

<ul class="nav nav-list">
	<li class="">
		<a href="${basePath}/admin/index">
			<i class="menu-icon fa fa-tachometer"></i>
			<span class="menu-text"> Dashboard </span>
		</a> 
		<b class="arrow"></b>
	</li> 
	<shiro:hasPermission name="system">  
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-desktop"></i>
				<span class="menu-text">
					系统管理
				</span> 
				<b class="arrow fa fa-angle-down"></b>
			</a> 
			<b class="arrow"></b>
			<ul class="submenu">
				<shiro:hasPermission name="system/userMG"> 
					<li class="">
						<a href="${basePath}/admin/system/userMG">
							<i class="menu-icon fa fa-caret-right"></i>
							用户管理
						</a>
		
						<b class="arrow"></b>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="system/roleMG">  
					<li class="">
						<a href="${basePath}/admin/system/roleMG">
							<i class="menu-icon fa fa-caret-right"></i>
							角色管理
						</a>
		
						<b class="arrow"></b>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="system/permissionsMG"> 
					<li class="">
						<a href="${basePath}/admin/system/permissionsMG">
							<i class="menu-icon fa fa-caret-right"></i>
							权限管理
						</a>
		
						<b class="arrow"></b>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="system/authorizationMG"> 
					<li class="">
						<a href="${basePath}/admin/system/authorizationMG">
							<i class="menu-icon fa fa-caret-right"></i>
							授权管理
						</a>
		
						<b class="arrow"></b>
					</li>
				</shiro:hasPermission>
			</ul>
		</li>
	</shiro:hasPermission>
	<li class="">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-leaf"></i>
			<span class="menu-text">
				业务字典
			</span>
			<b class="arrow fa fa-angle-down"></b>
		</a>
		<b class="arrow"></b>
		<ul class="submenu">
			<li class="">
				<a href="#">
					<i class="menu-icon fa fa-caret-right"></i>
					 字典
				</a>
				<b class="arrow"></b>
			</li>

		</ul>
	</li>
	<li class="">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-users"></i>
			<span class="menu-text">
				供应商管理
			</span> 
			<b class="arrow fa fa-angle-down"></b>
		</a> 
		<b class="arrow"></b>
		<ul class="submenu">
			<li class="">
				<a href="${basePath}/admin/supplier/certificationMG">
					<i class="menu-icon fa fa-caret-right"></i>
					供应商认证
				</a>
				<b class="arrow"></b>
			</li>
			<li class="">
				<a href="${basePath}/admin/supplier/supplierMG">
					<i class="menu-icon fa fa-caret-right"></i>
					供应商信息
				</a>
				<b class="arrow"></b>
			</li>
			 
		</ul>
	</li>
	<li class="">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-leaf"></i>
			<span class="menu-text">
				采购报价管理
			</span> 
			<b class="arrow fa fa-angle-down"></b>
		</a> 
		<b class="arrow"></b>
		<ul class="submenu">
			<li class="">
				<a href="#">
					<i class="menu-icon fa fa-caret-right"></i>
					采购需求发布
				</a>

				<b class="arrow"></b>
			</li>
			 
		</ul>
	</li>
	
</ul><!-- /.nav-list -->

<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
	<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
</div>
</div>
