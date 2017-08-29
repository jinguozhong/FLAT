<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp" %>
 
<script type="text/javascript">var basePath="${basePath}" </script>
 <!-- Bootstrap Core CSS -->
 <link href="${basePath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">  
 <style>

	.jgzTable{ font-size: 12px;}
	.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td{padding: 3px;}
	.line {background-color: #D7D3DB}
	.iframe_table_head .iframe_table_head_td { padding: 0px 3px;}

</style>
<!--用户字典查询按钮查询  -->
<div  > 
	<div  class="iframe_table_head" id="iframe_table_headId">
		<table>
			<tbody>
				<tr>
					<td class="iframe_table_head_td">
						<select name="conditions" id="conditions"> 
							<option value="code" selected="selected">代码</option>
							<option value="name">名称</option>
						</select>
					</td>
					<td class="iframe_table_head_td">
						<input  class="form-control" type="text" name="parameter" id="parameter" placeholder="输入查找的内容">
					</td>
					<td class="iframe_table_head_td">
						<button type="button" class="btn btn-outline btn-success" style="padding: 2px 12px;" onclick="popupWindow.queryButton(this)"  data-target="${target}">查找</button> 
					</td> 
				</tr>
			</tbody>
		</table>
	</div>
	<div   >
		<div >
			<table class="table table-hover jgzTable" >
				<thead>
		          <tr>
		              <th>#</th>
		              <th>Id</th>
		              <th>Code</th>
		              <th>Name</th>
		              <th>Pname</th> 
		          </tr>
		      </thead>
			</table>
		</div>
		<div style="height: 352px;overflow: auto;" id="iframe_table_auto">
			<table  class="table table-hover jgzTable" id="iframe_table_1"  > 
		      <tbody id="iframe_table_tbody"  >  
		      	  <tr><td>请填写查询条件...</td></tr>
			        
		      </tbody>
			</table>
		</div> 
	</div>
</div>
<script type="text/javascript" src="${basePath}/resources/assets/js/jquery-2.1.4.min.js"></script> 
<script type="text/javascript" src="${basePath}/resources/sg/sgutil.js"></script> 
<script type="text/javascript" src="${basePath}/resources/sg/sg.js"></script> 
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
		       	 	var target=$("#iframe_table_headId").find(".btn-success").data("target");//当前查找对象 
		       	 	var conditions= $("#iframe_table_headId").find("#conditions").val();
					var parameter= $("#iframe_table_headId").find("#parameter").val();  
		       	 	var no=$("#iframe_table_tbody>tr:last").find("td").eq(0).text();//当前最后一行的序号 
		       	   
		       	 	pageNo=pageNo+pageSize;  
		       	 	popupWindow.loadData(parameter,pageNo, pageNo+pageSize,no,target,conditions);
		        
		       	 };
		 	})             
	 });
	
	 
	$("#iframe_table_tbody").on("click", "tr", function(){ 
		var $this=$(this); 
		popupWindow.tableLine($this);
	});
	
	
	 
	//管理弹窗操作
	var popupWindow={
		//选择行操作
		tableLine:function($obj){
			$obj.parent().find(".line").removeClass("line");
			$obj.addClass("line");
		},
		//滚动加载数据
		loadData:function(name,pageNo,pageSize,no,target,conditions){  
			var data=null;
			if(conditions=="code"){
				data={code:name,pageNo:pageNo,pageSize:pageSize,target:target};
			}else{
				data={name:name,pageNo:pageNo,pageSize:pageSize,target:target};
			}
			Jgzajax.request({
				url:basePath+"/admin/dictionary/scrollQuery/"+target,
				async: false,//设置为同步
				beforeSend:function(){
					$("#iframe_table_auto").append( 
							" <div class='loader' id='loaderId' style='background: #88e1b2'> "+
							"	<div class='loader-inner ball-beat'>  "+
							"		<div></div> <div></div> <div></div> "+
							"	疯狂加载中...</div> "+
							"</div> " );  
				},
				success:function(data){
					//console.log(JSON.stringify(data)); 
					var arr=new Array();
					for(var i=0;i<data.length;i++){
						var datas="<tr>"+
						"   <td>"+(Number(no)+i+1)+"</td>"+
						"   <td>"+data[i].id+"</td>"+
						"   <td>"+data[i].code+"</td>"+
						"   <td>"+data[i].name+"</td>"+
						"   <td>"+data[i].pname+"</td>"+ 
						"</tr>"
						arr.push(datas);
					}
					$("#iframe_table_tbody").append(arr);
					$("#iframe_table_auto").find("#loaderId").remove();
				}
				
			},data);
		},
		//查询按钮点击事件
		queryButton:function(obj){
			var $this=$(obj);
			var conditions= $(".iframe_table_head").find("#conditions").val();
			var parameter= $(".iframe_table_head").find("#parameter").val(); 
			var target=$this.data("target"); 
			var data=null;
			if(conditions=="name"){
				data={name:parameter,pageNo:"0",pageSize:"15",target:target};
			}else{
				data={code:parameter,pageNo:"0",pageSize:"15",target:target};
			};
			//去事件,防止重复提交
			$this.removeAttr("onclick"); 
			$("#iframe_table_tbody>tr").remove();//查询前先清空数据
			Jgzajax.request({
				url:basePath+"/admin/dictionary/scrollQuery/"+target,
				success:function(data){
					var arr=new Array();
					for(var i=0;i<data.length;i++){
						var datas="<tr>"+
						"   <td>"+(i+1)+"</td>"+
						"   <td>"+data[i].id+"</td>"+
						"   <td>"+data[i].code+"</td>"+
						"   <td>"+data[i].name+"</td>"+
						"   <td>"+data[i].pname+"</td>"+ 
						"</tr>"
						arr.push(datas);
					}; 
					//追加数据
					$("#iframe_table_tbody").append(arr); 
					$this.attr("onclick","popupWindow.queryButton(this)"); 
				}
			},data)
			
		}
		
	}
</script>