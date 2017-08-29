<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp" %> 
 
<script type="text/javascript">var basePath="${basePath}" </script>
 <!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="${basePath}/resources/js/ztree/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="${basePath}/resources/js/ztree/zTreeStyle/demo.css" />
<%--<link rel="stylesheet" href="${basePath}/resources/assets/css/bootstrap-datepicker3.min.css" />--%>
<link rel="stylesheet" href="${basePath}/resources/js/Validform/css/demo.css" /> 
 <style> 
	.jgzTable{ font-size: 12px;}
	.line {background-color: #D7D3DB} 
</style>
<!--授权ztree显示  -->
<div style="height: 600px; "id="iframe_table_auto">
	 <div class="panel-body "   style="height:600px;overflow: auto;" >
		 <ul id="popupTreeDemo" class="ztree"></ul> 
     </div>
</div>
<script src="${basePath}/resources/assets/js/jquery-2.1.4.min.js"></script> 
<script type="text/javascript" src="${basePath}/resources/js/ztree/jquery.ztree.all.js"></script>  
<!-- page specific plugin scripts -->
<%--<script type="text/javascript" src="${basePath}/resources/assets/js/bootstrap-datepicker.min.js"></script>--%>
<script type="text/javascript" src="${basePath}/resources/js/srm/common.js"></script>
<script type="text/javascript" src="${basePath}/resources/js/srm/authorizationMG.js"></script>
<script type="text/javascript"> 
	$(function(){  
		zterrInt(); 
	 });
	 //ztree数据初始化
	function zterrInt(){ 
		var zNodes = [<c:forEach items="${lisauthorizationAll}" var="t"> { id:"${t.id}", name:"${t.name} ${t.code}", pId:"${t.pId}", }, </c:forEach> ];  
	     // var zNodes=general.filterChkDisabled(array); 
	     //初始化ztree数据
		 var popupTreeDemo=$.fn.zTree.init($("#popupTreeDemo"),checkSetting, zNodes);
		 //给有已有的权限打勾
		 <c:forEach items="${lisauthorization}" var="tt"> 
			 var nodes=popupTreeDemo.getNodeByParam("id",${tt.id});
		 	popupTreeDemo.checkNode(nodes,true,false);
		 </c:forEach>
	};	
	//获取当前勾选中的节点
	function getZtreeId(){
		var treeObj = $.fn.zTree.getZTreeObj("popupTreeDemo");
		var nodes=treeObj.getCheckedNodes(true);  //获取选中的节点
        var arr=new Array();
        for(var i=0;i<nodes.length;i++){//遍历
         	arr[i]=Number(nodes[i].id); 
        } 
		return arr;
	}
	//复选框
	var checkSetting={
			data: {
				simpleData: {
					enable: true,
					idKey:"id",
		            pIdKey:"pId"
				}
			},
			check: {
				enable: true, 
				chkStyle: "checkbox",
				chkboxType: { "Y" : "ps", "N" : "ps" }
			}
	 };
</script>