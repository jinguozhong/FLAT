//页面加载时，游览器的高度
var height;
var width;
/**
 * jqgrid表格编辑模板
 */
var content="<div id='dialog-form-role'>"+
"		  <p class='validateTips'>所有的表单字段都是必填的。</p> "+
"		  <form id='dialogFrom'>"+
"		  	<table>"+
"		  		<tbody>"+
"		  			<tr >"+
"		  				<th class='lableWidth'><lable for='id'>id:</lable></th>"+
"		  				<th class='thWidth'><input type='text' name='id' id='id' class='form-control' placeholder='id'  readonly='true' ></th>"+
"		  			</tr>"+
"		  			<tr>"+
"		  				<th class='lableWidth'><lable for='code'>代码:</lable></th>"+
"		  				<th class='thWidth'><input type='text' name='code' id='code' class='form-control' placeholder='代码' readonly='true'></th>"+
"		  			</tr>"+
"		  			<tr>"+
"		  				<th class='lableWidth'><lable for='name'>角色:</lable></th>"+
"		  				<th class='thWidth'><input type='text' name='name' id='name' class='form-control' placeholder='角色'"+
"		      				onclick='userMG.onclickRole(this)'>"+
"		      			</th>"+
"		  			</tr>"+
"		  		</tbody>"+					
"		  	</table> "+
"	     </form>"+
"		</div>"; 
var userMG={ 
		/**
		 * 页面加载时初始化ztree
		 */
		ztreeIni:function($ztreeId){ 
	 		//ztree异步加载
	 		var asyncSetting={
	 				data: {    
	 		            simpleData: {    
	 		            	enable: true,
	 		    			idKey:"id",
	 		                pIdKey:"pId"  
	 		            }    
	 		        },
	 		        async: {    
	 		            enable: true,    
	 		            url:basePath+"/admin/system/userMG/findZtreeList",    
	 		            autoParam:["id", "name"],       
	 			        type:"post",//默认post  
	 		            dataFilter: common.acfilter //异步返回后经过Filter  
	 		        },
	 		        callback:{  
	 		        	onClick: userMG.zTreeOnClick,//点击事件
	 		        	beforeExpand:common.beforeExpand,//异步加载父节点展开
	 		        	onAsyncError:common.onAsyncError//异步加载发生异常
	 		        }  
	 				
	 		};
	 		//第一次书加载执行，点击汇总节点异步加载不执行该方法了
			Jgzajax.request({
				url:basePath+"/admin/system/userMG/findZtreeList", 
				success:function(data){ 
					var zNodes=common.filter(eval(data));
					$.fn.zTree.init($ztreeId,asyncSetting, zNodes); 
				}
			},{id:"-1"})
			
		},
	
		/**
		 * 用户列表中点击用户加载用户信息
		 */
		zTreeOnClick:function(event, treeId, treeNode){
			var id=treeNode.id;  
			//console.log(id);
			var targetId=$("#user_information>from").find("#id").val();  
			if(id!=targetId){ 
				//console.log(JSON.stringify(treeNode));
				Jgzajax.request({
					url:basePath+"/admin/system/userMG/find",
					success:function(data){ 
						//console.log(data.user);
						if(data!=null){ 
							if(data.ex!=null){
								promptBox(data.ex);
							}else {		
								//form表单赋值
								common.assignment(data.user,$("#user_information>form"),$("#system"));
								//表格赋值
								common.jqgridDataLocal(data.jqgridData,$("#role-gridTable"));
							}
						}
					}
				
				},{id:id})
			}else{
				loading("重复点击！",3);
			}
			 
			
		}, 
		/**
		 * ztree点击事件
		 */
		zTreeOnClick1:function(event, treeId, treeNode){
			if(treeId=="userGMTree1"){				
				$("#userMG-content").find("#userFrom").find("#pname").val( treeNode.name);
				$("#userMG-content").find("#userFrom").find("#pname").data("id",treeNode.id);
			};
			if(treeId=="userGMRoleTree"){
				var $obj=$("#dialogFrom"); 
				var jsonData={"id":treeNode.id,"code":treeNode.code,"name":treeNode.name.substr(treeNode.code.length+1)};
				formAssignment($obj,jsonData);
			}
			//下拉ztree的div ID 
			var ztreeObj=$("#menuContent");
			common.hideMenu(ztreeObj);
		},
		//jqgrid 表格初始化
	   jqgridIni:function($obj){
			 
			$obj.jqGrid({       
				datatype: "jsoup",
				height: height-100, 
				width:width-2,
				colModel:[ 
					{ label: "rid", name: "id", width: 75,hidden:true},
	                { label: "代码", name: "code", width: 240},
	                { label: "角色", name: "name", width: 240,editable: true}
				],  
				viewrecords : true,  
				altRows: true,  
				rownumbers:true,
				multiselect: true, 
		        multiboxonly: true,
				pager:"#role-gridPager"
	        }); 
			/**
			 * jqgrid 编辑通用样式 start
			 */ 
			//navButtons
			$obj.jqGrid('navGrid',"#role-gridPager",{ 	//navbar options 
					editfunc: userMG.jqgridEdit,
					editicon : 'ace-icon fa fa-pencil blue',  
					addfunc:userMG.jqgridAdd,
					addicon : 'ace-icon fa fa-plus-circle purple',
					delfunc: userMG.formDeleRow,
					delicon : 'ace-icon fa fa-trash-o red',
					search: true,
					searchicon : 'ace-icon fa fa-search orange', 
					view: true,
					viewicon : 'ace-icon fa fa-search-plus grey',
					alerttext : "请选择需要操作的数据行!"
				} 
			) 
			/**
			 * jqgrid 编辑通用样式 end
			 */
			//隐藏表格中的工具栏目
			$("#userMG-content").find("#role-gridPager_left").children().hide(); 
			
		},
		//点击上级节点触发
		onclickPname:function(){
			$("#pname").click(function(){
				var para=$(this).attr("readonly");
				if(isEmpty(para)||para!="readonly"){ 
					//ztree异步加载
			 		var asyncSetting={
			 				data: {    
			 		            simpleData: {    
			 		            	enable: true,
			 		    			idKey:"id",
			 		                pIdKey:"pId"  
			 		            }    
			 		        },
			 		        async: {    
			 		            enable: true,    
			 		            url:basePath+"/admin/system/userMG/findZtreeList",    
			 		            autoParam:["id", "name"],       
			 			        type:"post",//默认post  
			 		            dataFilter: common.acfilter //异步返回后经过Filter  
			 		        },
			 		        callback:{  
			 		        	onClick: userMG.zTreeOnClick1,//点击事件
			 		        	beforeExpand:common.beforeExpand,//异步加载父节点展开
			 		        	onAsyncError:common.onAsyncError//异步加载发生异常
			 		        }   
			 		};
			 		//显示下拉框
					common.pnameDowntree("userMG-content","userFrom","userGMTree1","system/userMG","pname",asyncSetting);

				}
			})
		},
		/**
		 * 用户信息中角色信息编辑
		 */
		onclickRole:function(){
			//ztree异步加载
	 		var asyncSetting={
	 				data: {    
	 		            simpleData: {    
	 		            	enable: true,
	 		    			idKey:"id",
	 		                pIdKey:"pId"  
	 		            }    
	 		        },
	 		        async: {    
	 		            enable: true,    
	 		            url:basePath+"/admin/system/roleMG/findZtreeList",    
	 		            autoParam:["id", "name"],       
	 			        type:"post",//默认post  
	 		            dataFilter: common.acfilter //异步返回后经过Filter  
	 		        },
	 		        callback:{  
	 		        	onClick: userMG.zTreeOnClick1,//点击事件
	 		        	beforeExpand:common.beforeExpand,//异步加载父节点展开
	 		        	onAsyncError:common.onAsyncError//异步加载发生异常
	 		        }   
	 		};
	 		//显示下拉框
			common.pnameDowntree("bodyId","dialogFrom","userGMRoleTree","system/roleMG","name",asyncSetting); 
			
		},  
		//jqgrid 表格添加
		jqgridAdd:function(){
			//打开弹窗
			//$( "#dialog-form-role" ).dialog( "open" ); 
		
			$.tzDialog({
				title:"角色添加",
				width:400,
				height:400,
				content:content,
				callback:function(state,$dialog,opts){
					if(state==true){
						userMG.jqgridAddLine();
					}
					//关闭弹窗
		    		$dialog.next().remove();
		    		tzUtil.animates($dialog,opts.animate); 
				}
			})
			
		},
		/**
		 * 表格修改
		 * 参数说明：选择的行ID
		 */
		jqgridEdit:function(e){ 
			var jqgrid=$("#role-gridTable");
			var data=jqgrid.jqGrid('getRowData',e); 
			$.tzDialog({
				title:"角色修改",
				width:400,
				height:400,
				content:content,
				callback:function(state,$dialog,opts){
					if(state==true){ 
						//获取数据
                        formObtain($dialog.find("#dialogFrom"));
						//获取数据end 
						//获取表格中所有的数据
						var datas=jqgrid.jqGrid("getRowData");
						//判断添加行的内容是否重复
						for(var i=0;i <datas.length;i++){
							
							if(data.code!=code&&code==datas[i].code){
								loading("重复添加",7);
								return;
							}
						};
						if(isNotEmpty(code)&&code!=-1){ 
							//修改对应的行数据
							jqgrid.setRowData(gr,{id:id,code:code,name:name});
							//关闭弹窗
							$dialog.next().remove();
							tzUtil.animates($dialog,opts.animate);
						}else{
							loading("数据有误，请确定",4);
						}
					}else{
						//关闭弹窗
						$dialog.next().remove();
						tzUtil.animates($dialog,opts.animate);
					}
				} 
			});
			//弹窗加载end
			//将获取的行数据进行赋值
			formAssignment($("#dialog-form-role").find("#dialogFrom"),data);
		},
		
		/**
		 * 行删除
		 */
		formDeleRow:function(e){ 
			var jqgrid = $("#userMG-content").find("#role-gridTable");  
			var len=e.length;
			for(var i=0;i<len;i++){  
				jqgrid.jqGrid("delRowData", e[0]);  
			} 
		},
	 	/**
	 	 * jqgrid 增加行数据
	 	 */
	 	jqgridAddLine:function(){ 
	 		var $jqgrid=$("#content").find("#role-gridTable");
	 		//获取表单中的数据
	 		var fromData=formObtain($("#dialogFrom")); 
	 		 //获取选择行id
            var selectedId = $jqgrid.jqGrid("getGridParam", "selrow");
            //获取是否在表格中的行数
            var ids = $jqgrid.jqGrid("getDataIDs");
            //获取表格中所有的数据
            var datas=$jqgrid.jqGrid("getRowData"); 
            //判断添加行的内容是否重复
            if(datas!=null&&datas.length>0){ 
            	for(var i=0;i <datas.length;i++){
            		
            		if(fromData.code==datas[i].code){
            			loading("重复添加",4);
            			return;
            		}
            	};
            }
            
            if(isNotEmpty(fromData.code)&&code!=-1){
           	 	var rowid;
            	if(ids==""){
           	 		rowid=0	
           	 	}else{
	           	 	//获得当前最大行号（数据编号）
	           	 	rowid = Math.max.apply(Math,ids);
           	 	}
            	if(selectedId){
            		$jqgrid.addRowData(rowid+1, fromData, "before",selectedId);
                }else{
                	$jqgrid.addRowData(rowid+1, fromData);
                } 
            }else{
                loading("数据有误，请确定",4);
            }
	 		//清理表单
			$("#dialogFrom").find("input").each(function(){ 
				$(this).val(""); 
			}) 
	 	},
	 	/**
	 	 * 表单验证
	 	 */
		validation:function($err){  
			//basicFrom的表单验证
			 $("#userMG-content").find("#userFrom").Validform({    
			 	tiptype:function(msg,o,cssctl){ //提示位置
			 	  cssctl($err,o.type);
			 	  $err.text(msg);  
				},
				callback:function(form){   
					userMG.saveForm(form); //保存
					return false;
				} 
			});  
		},
		saveForm:function(form){ 
			//在验证成功后，表单提交前执行的函数，form参数是当前表单对象。   
			//获取tree对象
			var treeObj = $.fn.zTree.getZTreeObj("userGMTree"),
			nodes=treeObj.getSelectedNodes(); 
			
			var $management=$("#userMG-content");
			var $basicPills=$management.find("#content");
			
			 //获取参数 
			var fromData=formObtain($basicPills.find("#userFrom")); 
			
			//获取表格中的数据
			var roleDatas=common.getFormRow('userMG-content','role-gridTable'); 
			//获取父节点
			var parentNode=treeObj.getNodeByParam("id",fromData.pId); 
			 
			if(nodes[0]!=null&&nodes[0].isParent && eval(isParent)==false&&nodes[0].children!=null){
				loading("保存失败！操作违规！该节点下有子节点，不能修改成明细节点",4);
				
			}else{
				var json={"basicFrom":fromData,"roleDatas":roleDatas}; 
				//console.log(json);
				var datas=JSON.stringify(json);  
				if(isNotEmpty(datas)){
					Jgzajax.request({ 
						url:basePath+"/admin/system/userMG/save",
						async: false,//设置为同步
						success:function(data){
							if(data.indexOf("SaveSuccess")>=0){ 
								var paramId=data.substring(12);  
								//调用ztree新增保存方法
								treeObj.addNodes(parentNode,{id:paramId,name:json.basicFrom.mail+" "+json.basicFrom.name});  
								$basicPills.find("#id").val(paramId);
								//工具栏的显示隐藏的控制
								common.toolbarControl("save",$management,$basicPills); 
								$management.find("#role-gridPager_left").children().hide(); 
								//覆盖层取消
								$("#overlay").remove();	
								//覆盖层取消end
							}else if(data.indexOf("Null")>=0){
								loading("保存失败",6);
							}else if(data=="modifySuccess"){
								//调用ztree保存方法 
								nodes[0].name=json.basicFrom.mail+" "+json.basicFrom.name;
								nodes[0].isParent=eval(json.basicFrom.isParent); 
								treeObj.updateNode(nodes[0]); 
								//工具栏的显示隐藏的控制
								common.toolbarControl("save",$management,$basicPills);
								$management.find("#role-gridPager_left").children().hide(); 
								//覆盖层取消
								$("#overlay").remove();	
								//覆盖层取消end
							}else if(data=="modifyFail"){
								loading("修改失败",6);
							}else{ 
								//提示框
								$.tzDialog({
									title:"友情提示",
									width: "400",
									height:"300",
									content:data,
									callback:function(stats,$dialog,opts){
										$dialog.next().remove();//关闭阴影层
										$dialog.remove(); 
									}
								});
							} 
						}
					},{datas:datas})
				}else{
					loading("数据获取为null",4);
				}
			}
		},
		/**
		 * 取消按钮
		 */
		cancel:function(obj, management,ztreeObj,target){
			var $management=$("#"+management+""); 
			var $content=$management.find("#content"); 
			var treeObj = $.fn.zTree.getZTreeObj(""+ztreeObj+""); 
			var node=treeObj.getSelectedNodes();  
			if(node==null||node==""){
				//loading("没有选择节点",4); 
			}else{  
				var id=node[0].id; 
				Jgzajax.request({
					url:basePath+"/admin/system/"+target+"/find",
					success:function(data){
						if(data!=null){ 
							if(data.ex!=null){
								promptBox(data.ex);
							}else {		
								//form表单赋值
								common.assignment(data.user,$("#user_information>form"),$("#system"));
								//表格赋值
								common.jqgridDataLocal(data.jqgridData,$("#role-gridTable")); 
							}
						}
					}
				
				},{id:id}) 
			}
			//工具栏的显示隐藏的控制
			common.toolbarControl("cancel",$management,$content); 
			$management.find("#role-gridPager_left").children().hide(); 
			//覆盖层取消
			$("#overlay").remove();	
			//覆盖层取消end
		},
		/**
		 * 用户密码初始
		 */
		passInit:function(){
			var id=$("#user_information").find("#id").val();
			if(isNotEmpty(id)){ 
				Jgzajax.request({
					url: basePath+"/admin/system/userMG/passInit",  
					success: function(data){ 
						if(data.results=="success"){
							loading("密码已经初始化",6);
						}else{
							loading("密码初始化失败",6);
						}
					}
				},{id:id})
			}else{
				loading("请先选择");
			}
		}
		
		
};


