//页面加载时，游览器的高度
var height;
var width; 

var authorizationMG={ 
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
	 		            url:basePath+"/admin/system/roleMG/findZtreeList",    
	 		            autoParam:["id", "name"],       
	 			        type:"post",//默认post  
	 		            dataFilter: common.acfilter //异步返回后经过Filter  
	 		        },
	 		        callback:{  
	 		        	onClick: authorizationMG.zTreeOnClick,//点击事件
	 		        	beforeExpand:common.beforeExpand,//异步加载父节点展开
	 		        	onAsyncError:common.onAsyncError//异步加载发生异常
	 		        }  
	 				
	 		};
	 		//第一次书加载执行，点击汇总节点异步加载不执行该方法了
			Jgzajax.request({
				url:basePath+"/admin/system/roleMG/findZtreeList", 
				success:function(data){ 
					var zNodes=common.filter(eval(data)); 
					$.fn.zTree.init($ztreeId,asyncSetting, zNodes); 
				}
			},{id:"-1"})
			
		},
		/**
		 * 页面加载时初始化ztree
		 */
		permissionsZtreeIni:function($ztreeId){ 
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
	 		        	//onClick: permissionsMG.zTreeOnClick,//点击事件
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
		 * 编辑
		 */
		edit:function(){
			var treeObj = $.fn.zTree.getZTreeObj("roleGMTree"),
			node=treeObj.getSelectedNodes() 
			if(node!=null&&node.length>0){  
				var id=node[0].id;//角色id
				$.tzIframe({
					title:"授权",
					content:basePath+"/admin/system/authorizationMG/popup/"+id,
					dialogId:'Authorization',
					width:500,
					height:700,
					callback:function(perform,iframe,$dialog,opts){ 
						if(perform==true){
							var datas=iframe.getZtreeId(); 
							authorizationMG.save(id,datas);
						};
						$dialog.next().remove();//关闭阴影层
						$dialog.remove();//关闭主体
					}
				});
			}else{
				loading("请先选中，再点编辑",5);
			}
		}, 
		/**
		 * 保存
		 */
		save:function(id,datas){
			 var arrData={};
			 arrData.id=id;
			 arrData.listString=datas; 
			 Jgzajax.request({
				 url:basePath+"/admin/system/authorizationMG/save",
				 success:function(data){
					 var results=data.trim();
					 if(results=="scuuess"){
						 alert("授权成功"); 
						 authorizationMG.loadingPermissions(id);//根据角色加载权限
					 }else if(results=="null"){
						 alert("数据不能为空");
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
			 },{Data:JSON.stringify(arrData)})
			 
			
		}, 
		//根据角色加载权限
		loadingPermissions:function(rId){
			var zNodes;
			var Setting={
					data: {
						simpleData: {
							enable: true,
							idKey:"id",
				            pIdKey:"pId"
						}
					}
				};
			Jgzajax.request({
				url:basePath+"/admin/system/authorizationMG/finds",
				success:function(data){
					zNodes=authorizationMG.filterChkDisabled(eval(data),true); 
					$.fn.zTree.init($("#authorizationMG-content").find("#permissionsGMTree"),Setting, zNodes); 
				} 
			},{id:rId}) 
		},
		/**
		 * 角色ztree点击事件
		 */
		zTreeOnClick:function(event, treeId, treeNode){
			
			var rId=treeNode.id;
			authorizationMG.loadingPermissions(rId); 
		},
		/**
		 * 对ztree 复选框的操作   
		 */    
		filterChkDisabled:function(datas){
			//console.log(JSON.stringify(datas));
			if (!datas) return null;
			for (var i=0, l=datas.length; i<l; i++) {
				datas[i].name = datas[i].name+" "+datas[i].code;  
			} 
			return datas;
			
			
		}
};


