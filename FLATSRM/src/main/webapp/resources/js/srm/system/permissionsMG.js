//页面加载时，游览器的高度
var height;
var width; 
var permissionsMG={ 
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
	 		            url:basePath+"/admin/system/permissionsMG/findZtreeList",    
	 		            autoParam:["id", "name"],       
	 			        type:"post",//默认post  
	 		            dataFilter: common.acfilter //异步返回后经过Filter  
	 		        },
	 		        callback:{  
	 		        	onClick: permissionsMG.zTreeOnClick,//点击事件
	 		        	beforeExpand:common.beforeExpand,//异步加载父节点展开
	 		        	onAsyncError:common.onAsyncError//异步加载发生异常
	 		        }  
	 				
	 		};
	 		//第一次书加载执行，点击汇总节点异步加载不执行该方法了
			Jgzajax.request({
				url:basePath+"/admin/system/permissionsMG/findZtreeList", 
				success:function(data){ 
					var zNodes=common.filter(eval(data));
					$.fn.zTree.init($ztreeId,asyncSetting, zNodes); 
				}
			},{id:"-1"})
			
		},
	
		/**
		 * 角色列表中点击角色加载用户信息
		 */
		zTreeOnClick:function(event, treeId, treeNode){
			var id=treeNode.id;  
			//console.log(id);
			var targetId=$("#information>from").find("#id").val();  
			if(id!=targetId){ 
				//console.log(JSON.stringify(treeNode));
				Jgzajax.request({
					url:basePath+"/admin/system/permissionsMG/find",
					success:function(data){ 
						console.log(data.permissions);
						console.log(data.permissions.updateTime);
						if(data!=null){ 
							if(data.ex!=null){
								promptBox(data.ex);
							}else {		
								//form表单赋值
								common.assignment(data.permissions,$("#information>form"),$("#system")); 
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
			if(treeId=="permissionsGMTree1"){				
				$("#permissionsMG-content").find("#permissionsFrom").find("#pname").val( treeNode.name);
				$("#permissionsMG-content").find("#permissionsFrom").find("#pname").data("id",treeNode.id);
			};
			if(treeId=="permissionsGMUserTree"){
				var $obj=$("#dialogFrom"); 
				var jsonData={"id":treeNode.id,"code":treeNode.code,"name":treeNode.name.substr(treeNode.code.length+1)};
				formAssignment($obj,jsonData);
			}
			//下拉ztree的div ID 
			var ztreeObj=$("#menuContent");
			common.hideMenu(ztreeObj);
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
			 		            url:basePath+"/admin/system/permissionsMG/findZtreeList",    
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
					common.pnameDowntree("permissionsMG-content","permissionsFrom","permissionsGMTree1","system/permissionsMG","pname",asyncSetting);

				}
			})
		},
		/**
		 * 角色信息中角色信息编辑
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
	 		            url:basePath+"/admin/system/userMG/findZtreeList",    
	 		            autoParam:["id", "name"],       
	 			        type:"post",//默认post  
	 		            dataFilter: common.acfilter //异步返回后经过Filter  
	 		        },
	 		        callback:{  
	 		        	onClick: permissionsMG.zTreeOnClick1,//点击事件
	 		        	beforeExpand:common.beforeExpand,//异步加载父节点展开
	 		        	onAsyncError:common.onAsyncError//异步加载发生异常
	 		        }   
	 		};
	 		//显示下拉框
			common.pnameDowntree("bodyId","dialogFrom","permissionsGMUserTree","system/userMG","name",asyncSetting); 
			
		},  
		//jqgrid 表格添加
		jqgridAdd:function(){
			//打开弹窗
			//$( "#dialog-form-permissions" ).dialog( "open" ); 
		
			$.tzDialog({
				title:"用户修改",
				width:400,
				height:400,
				content:content,
				callback:function(state,$dialog,opts){
					if(state==true){
						permissionsMG.jqgridAddLine();
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
			var jqgrid=$("#user-gridTable");
			var data=jqgrid.jqGrid('getRowData',e); 
			$.tzDialog({
				title:"用户修改",
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
			formAssignment($("#dialog-form-user").find("#dialogFrom"),data);
		},
		
		/**
		 * 行删除
		 */
		formDeleRow:function(e){ 
			var jqgrid = $("#permissionsMG-content").find("#user-gridTable");  
			var len=e.length;
			for(var i=0;i<len;i++){  
				jqgrid.jqGrid("delRowData", e[0]);  
			} 
		},
	 	/**
	 	 * jqgrid 增加行数据
	 	 */
	 	jqgridAddLine:function(){ 
	 		var $jqgrid=$("#content").find("#user-gridTable");
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
			 $("#permissionsMG-content").find("#permissionsFrom").Validform({    
			 	tiptype:function(msg,o,cssctl){ //提示位置
			 	  cssctl($err,o.type);
			 	  $err.text(msg);  
				},
				callback:function(form){   
					permissionsMG.saveForm(form); //保存
					return false;
				} 
			});  
		},
		saveForm:function(form){ 
			//在验证成功后，表单提交前执行的函数，form参数是当前表单对象。   
			//获取tree对象
			var treeObj = $.fn.zTree.getZTreeObj("permissionsGMTree"),
			nodes=treeObj.getSelectedNodes(); 
			
			var $management=$("#permissionsMG-content");
			var $basicPills=$management.find("#content");
			
			 //获取参数 
			var fromData=formObtain($basicPills.find("#permissionsFrom")); 
			 
			//获取父节点
			var parentNode=treeObj.getNodeByParam("id",fromData.pId); 
			 
			if(nodes[0]!=null&&nodes[0].isParent && eval(isParent)==false&&nodes[0].children!=null){
				loading("保存失败！操作违规！该节点下有子节点，不能修改成明细节点",4);
				
			}else{  
				if(isNotEmpty(fromData)){
					Jgzajax.request({ 
						url:basePath+"/admin/system/permissionsMG/save",
						async: false,//设置为同步
						success:function(data){
							if(data.indexOf("SaveSuccess")>=0){ 
								var paramId=data.substring(12);  
								//调用ztree新增保存方法
								treeObj.addNodes(parentNode,{id:paramId,name:fromData.code+" "+fromData.name});  
								$basicPills.find("#id").val(paramId);
								//工具栏的显示隐藏的控制
								common.toolbarControl("save",$management,$basicPills);   
								//覆盖层取消
								$("#overlay").remove();	
								//覆盖层取消end
							}else if(data.indexOf("Null")>=0){
								loading("保存失败",6);
							}else if(data=="modifySuccess"){
								//调用ztree保存方法 
								nodes[0].name=fromData.code+" "+fromData.name;
								nodes[0].isParent=eval(fromData.isParent); 
								treeObj.updateNode(nodes[0]); 
								//工具栏的显示隐藏的控制
								common.toolbarControl("save",$management,$basicPills); 
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
					},fromData)
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
								common.assignment(data.permissions,$("#information>form"),$("#system"));
								//表格赋值
								common.jqgridDataLocal(data.jqgridData,$("#user-gridTable")); 
							}
						}
					}
				
				},{id:id}) 
				
					 
			}
			//工具栏的显示隐藏的控制
			common.toolbarControl("cancel",$management,$content);  
			//覆盖层取消
			$("#overlay").remove();	
			//覆盖层取消end
		},
		
		
		
};


