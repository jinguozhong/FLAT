<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib  uri="/WEB-INF/tld/jgz.tld"  prefix="jgz" %>
<%@taglib uri="http://shiro.apache.org/tags"  prefix="shiro" %>
<%
String path = request.getContextPath();
Integer port= request.getServerPort();
String basePath=null;
if(port==80){
	basePath = request.getScheme()+"://"+request.getServerName()+path;

}else{
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
}
request.setAttribute("basePath", basePath);
%>  
<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="${basePath}/resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" /> 
<!-- page specific plugin styles --> 
<!-- text fonts -->
<link rel="stylesheet" href="${basePath}/resources/assets/css/fonts.googleapis.com.css" /> 

<!-- page specific plugin styles -->
<link rel="stylesheet" href="${basePath}/resources/assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="${basePath}/resources/assets/css/ui.jqgrid.min.css" />
<!-- ace styles -->
<link rel="stylesheet" href="${basePath}/resources/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" /> 
<link rel="stylesheet" href="${basePath}/resources/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${basePath}/resources/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${basePath}/resources/sg/css/sg.css"  >
<!--[if !IE]> -->
<script src="${basePath}/resources/assets/js/jquery-2.1.4.min.js"></script>
<!-- <![endif]--> 
 <!-- ace settings handler -->
<script src="${basePath}/resources/assets/js/ace-extra.min.js"></script>
<script src="${basePath}/resources/assets/js/bootstrap.min.js"></script>
<!-- page specific plugin scripts -->
<script src="${basePath}/resources/assets/js/jquery-ui.min.js"></script>  
<script src="${basePath}/resources/assets/js/jquery-ui.custom.min.js"></script>
<script src="${basePath}/resources/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${basePath}/resources/assets/js/jquery.easypiechart.min.js"></script>
<script src="${basePath}/resources/assets/js/jquery.sparkline.index.min.js"></script>
<script src="${basePath}/resources/assets/js/jquery.flot.min.js"></script>
<script src="${basePath}/resources/assets/js/jquery.flot.pie.min.js"></script>
<script src="${basePath}/resources/assets/js/jquery.flot.resize.min.js"></script> 
<script src="${basePath}/resources/assets/js/ace-elements.min.js"></script>
<script src="${basePath}/resources/assets/js/ace.min.js"></script> 
<script src="${basePath}/resources/assets/js/ace-extra.min.js"></script> 
<script  type="text/javascript" src="${basePath}/resources/assets/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/sg/sgutil.js"></script>
<script type="text/javascript" src="${basePath}/resources/sg/sg.js"></script>
<script type="text/javascript">var basePath="${basePath}"; </script> 