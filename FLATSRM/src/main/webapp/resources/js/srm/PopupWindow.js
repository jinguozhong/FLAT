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