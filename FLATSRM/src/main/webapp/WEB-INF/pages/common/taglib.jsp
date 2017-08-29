<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
