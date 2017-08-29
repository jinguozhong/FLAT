<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
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
<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="utf-8">
    <title>FLAT 供应平台登入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman"> 
    <!-- The fav icon -->
    <link rel="shortcut icon" href="${basePath}/resources/img/FGG.ico">
    <!-- CSS -->
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            font-family: arial, helvetica, sans-serif;
            background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAUElEQVQYV2NkYGAwBuKzQAwDID4IoIgxIikAMZE1oRiArBDdZBSNMIXoJiFbDZYDKcSmCOYimDuNSVKIzRNYrUYOFuQgweoZbIoxgoeoAAcAEckW11HVTfcAAAAASUVORK5CYII=) repeat;
            background-color: #212121;
            color: white;
            font-size: 28px;
            padding-bottom: 20px;
        }

        .error-code {
            font-family: 'Creepster', cursive, arial, helvetica, sans-serif;
            font-size: 200px;
            color: white;
            color: rgba(255, 255, 255, 0.98);
            width: 50%;
            text-align: right;
            margin-top: 5%;
            text-shadow: 5px 5px hsl(0, 0%, 25%);
            float: left;
        }

        .not-found {
            font-family: 'Audiowide', cursive, arial, helvetica, sans-serif;
            width: 45%;
            float: right;
            margin-top: 5%;
            font-size: 50px;
            color: white;
            text-shadow: 2px 2px 5px hsl(0, 0%, 61%);
            padding-top: 70px;
        }

        .clear {
            float: none;
            clear: both;
        }

        .content {
            text-align: center;
            line-height: 30px;
        }

        input[type=text] {
            border: hsl(247, 89%, 72%) solid 1px;
            outline: none;
            padding: 5px 3px;
            font-size: 16px;
            border-radius: 8px;
        }

        a {
            text-decoration: none;
            color: #9ECDFF;
            text-shadow: 0px 0px 2px white;
        }

        a:hover {
            color: white;
        }

    </style>
 	 
</head> 
<body  >  
	<p class="error-code">
	    ${pageContext.errorData.statusCode} 
	</p>
	
	<p class="not-found">Not<br/>Found</p>
	
	<div class="clear"></div>
	<div class="content">
	    The page your are looking for is not found.
	    <br>
	    <a href="${basePath}/admin/index">Go Home</a>
	    or
	    <br>
	    <br>
	
	    <form>   
	   	     请求地址: ${pageContext.errorData.requestURI} <br> 
	   	   异常 : ${ex}<br>   
		  servlet名称 :${pageContext.errorData.servletName} <br>   
	     
	    </form>
	   
	</div>
</body>     
</html>
