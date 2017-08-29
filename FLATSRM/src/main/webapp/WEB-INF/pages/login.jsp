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
    <link rel="stylesheet" href="${basePath}/resources/css/login/reset.css">
    <link rel="stylesheet" href="${basePath}/resources/css/login/supersized.css">
    <link rel="stylesheet" href="${basePath}/resources/css/login/style.css"> 
    <link rel="stylesheet" href="${basePath}/resources/css/jqueryUI/jquery-ui.css"> 
 	 <style type="text/css">
 		.hidden{display: none;}
 	 
 	 </style>
 	 
</head> 
<body oncontextmenu="return false"> 
        <div class="page-container">
            <h1>FLAT 供应平台 Login</h1>
            <div id="prompt"  class='hidden' style="color: red; padding: 13px;"></div> 
            <form id ="submitLogin" action="${basePath}/submitLogin" method="post">
				<div>
					<input type="text" id="username" name="username" class="username" placeholder="Username" autocomplete="off"  autofocus onblur="findRole(this)"/>
				</div>
                <div>
					<input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
                </div>
                <div>
					<select  placeholder="role" name="role" id="role"> 
						<option value ="role">role</option> 
                    </select>
                </div>
                <div>
                	<input id="validation" class="form-control" placeholder="验证码" name="validation" type="text" >
                   <img src="${basePath}/login/captcha-image"  id="kaptchaImage"
                    onclick="this.src=basePath+'/login/captcha-image?d='+new Date().getDate()"
                    style="margin-bottom: -3px;width: 125px;height: 42px;float: left;"/>
                </div>
                <button type="button" onclick="submitLogin(this)">Sign in</button>
                <div style="float: left;margin: 8px;">
                	<label> 
	                	<input id="remember" name="remember" style="width: 16px;height: 16px;margin-top: 1px;" type="checkbox" value="1"><p style="font-weight:700;float: right;">remember</p>
                	</label>
                </div>
                <div style="float: right;margin: 8px;">
                	<a href="${basePath}/registered" style="text-decoration:none;color:#ef4300;font-weight:700;">合作共赢</a>
                </div>
            </form>
            <div class="connect">

            </div>
           <div style="padding-top: 323px;">
            	COPYRIGHT © 2015 FLAT GLASS GROUP CO., LTD., ALL RIGHTS RESERVED. 福莱特玻璃集团股份有限公司 保留所有权利
            </div> 
        </div> 

        <!-- Javascript -->
		<script type="text/javascript" src="${basePath}/resources/js/jquery/jquery-2.1.4.min.js" ></script> 
        <script type="text/javascript" src="${basePath}/resources/js/login/supersized.3.2.7.min.js"></script>
        <script type="text/javascript" src="${basePath}/resources/js/login/supersized-init.js"></script>
        <script type="text/javascript" src="${basePath}/resources/sg/sgutil.js"></script>
        <script type="text/javascript" src="${basePath}/resources/sg/sg.js"></script>
        <script type="text/javascript">var basePath="${basePath}"; </script>
		<script type="text/javascript"> 
			var u = $("input[name=username]");
			var p = $("input[name=password]");
			var validation = $("input[name=validation]");
			var err="${lodinErrorMg}";//登入异常的返回
			function submitLogin(obj){ 
				$(obj).removeAttr("onclick");
				var remember=$("input[name='remember']:checked").val();
				//if(u.val() == '' || p.val() ==''||validation.val()==''){
				if(u.val() == '' || p.val() ==''){
					$("#prompt").html("用户名或密码或验证码不能为空~");
					$("#prompt").removeClass("hidden");
					return false;
				}else{ 
					if(remember==1){
						tzMap.put("flat_srm_mail",u.val(),1); 
						tzMap.put("flat_srm_remember", remember,1);
					}
					$("#submitLogin").submit(); 
					$(obj).attr("onclick","submitLogin(this)");
				}
				
			}
			
			//根据mail获取角色信息
	    	function findRole(obj){
	    		var $obj=$(obj);
	    		var mail=$obj.val();
	    		Jgzajax.request({
	    			url:basePath+"/LodingfindRole",
	    			success:function(data){ 

	    				$("#role").find("option").remove();
	    				var arry=new Array();
	    				for(var i=0;i<data.length;i++){
							var datas="<option value='"+data[i].id+"' >"+data[i].name+"</option>";
							arry.push(datas);
						}
						$("#role").append(arry);
	    			}
	    		},{mail:mail})
	    	};	
				
				
			
			window.onload = function()
			{
				$(".connect p").eq(0).animate({"left":"0%"}, 600);
				$(".connect p").eq(1).animate({"left":"0%"}, 400);
				/**
				 登入页面重定向加载时判断是否有异常内如
				*/
				if(err!=""&&err!=null){
					$("#prompt").html(err);
	         		$("#prompt").removeClass("hidden");
	         	} 
				
				var mail= tzMap.get("flat_srm_mail",1);
				var remember= tzMap.get("flat_srm_remember",1);
				if(remember==1){
					if(mail)$("#username").val(mail); 
					if(remember==1)$("#remember").attr("checked",'true');
				}
			}
			function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
			function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }
		</script>
    </body>
</html>
