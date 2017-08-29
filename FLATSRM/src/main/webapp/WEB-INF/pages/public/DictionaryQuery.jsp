<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp" %> 
 
<script type="text/javascript">var basePath="${basePath}" </script>
 <!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="${basePath}/resources/assets/css/bootstrap.min.css" /> 
 <style> 
	.jgzTable{ font-size: 12px;}
	.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td{padding: 3px;}
	.line {background-color: #D7D3DB} 
</style>
<!--用户字典模糊查询  -->
<div style="height: 400px;overflow: auto;" id="iframe_table_auto">
	<table class="table table-hover jgzTable" id="iframe_table_1" data-name="${parname}" data-target="${target}">
	      <thead>
	         <c:if test="${target!='onlineUser'}">
		          <tr>
		              <th>#</th>
		              <th>Id</th>
		              <th>Code</th>
		              <th>Name</th>
		              <th>Pname</th> 
		          </tr>
	          </c:if>
	          <c:if test="${target=='onlineUser'}">
	          	  <tr>
		              <th>#</th>
		              <th>sessionId</th> 
		              <th>Name</th>
		              <th>Host</th>
		              <th>创建时间</th>
		              <th>最后此通讯时间</th>
	         	  </tr> 
	          </c:if>
	      </thead>
	      <tbody id="iframe_table_tbody"> 
      		   <c:if test="${target!='onlineUser'}">
			      	<c:forEach items="${lists}" var="obj" varStatus="on">
			      		<tr>
			              <td>${on.index+1}</td>
			              <td>${obj.id}</td>
			              <td>${obj.code}</td>
			              <td>${obj.name}</td>
			              <td>${obj.pname}</td> 
			          </tr>
			      	</c:forEach> 
		      	</c:if>  
		      	 <c:if test="${target=='onlineUser'}">
			      	<c:forEach items="${lists}" var="obj" varStatus="on">
			      		<tr>
			              <td>${on.index+1}</td>
			              <td>${obj.sessionId}</td>
			              <td>${obj.userNane}</td>
			              <td>${obj.host}</td> 
			              <td>${jgz:formatDate(obj.startTime,"yyyy-MM-dd hh:mm:ss")}</td> 
			              <td>${jgz:formatDate(obj.lastAccess,"yyyy-MM-dd hh:mm:ss")}</td> 
			          </tr>
			      	</c:forEach>  
		       	</c:if>
		    
	      </tbody>
	</table>
</div>
<script  type="text/javascript" src="${basePath}/resources/assets/js/jquery-2.1.4.min.js"></script> 
<script type="text/javascript" src="${basePath}/resources/sg/sgutil.js"></script>  
<script type="text/javascript" src="${basePath}/resources/js/srm/PopupWindow.js"></script>  
<script type="text/javascript">
	var pageNo =0;//分页查讯参数
	var pageSize=15;//分页查讯参数
	$(function(){ 
		 //监听滚动条滚动触发
			$("#iframe_table_auto").scroll(function(){
			 	 var nScrollHight = $(this)[0].scrollHeight;
		       	 var nScrollTop = $(this)[0].scrollTop;
		       	 var nDivHight = $(this).height();
		       	 if(nScrollTop + nDivHight >= nScrollHight){
		       	 	//console.log($("#iframe_table_tbody").html());
		       	 	var target=$("#iframe_table_1").data("target");//当前查找对象
		       	 	var name=$("#iframe_table_1").data("name");//当前查询条件的名称参数
		       	 	var no=$("#iframe_table_tbody>tr:last").find("td").eq(0).text();//当前最后一行的序号 
		       	 	pageNo=pageNo+pageSize;  
		       	 	popupWindow.loadData(name,pageNo, pageNo+pageSize,no,target);
		        	
		       	 };
		 	})
	 });
	
	$("#iframe_table_tbody").on("click","tr",function(){
		$this=$(this);  
		popupWindow.tableLine($this);
	})
	
</script>