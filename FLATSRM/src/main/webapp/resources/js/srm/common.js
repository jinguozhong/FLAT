var curSrcNode;
var common={ 
		
	/**
	 * 页面加载时给指定的窗口设置高度
	 */
	setHeight:function($obj){
		//var height=getClientHeight();
		var height=window.innerHeight-214; 
		$obj.css({"height":height,"overflow": "auto"});
		//$obj.find(".box-content").css("height",height-35);
		return height;
	}, 
	/**
	 * 获取表格数据
	 */ 
	getFormRow:function(Management,JqGrid){
	    var tableObj=$("#"+Management+"").find("#"+JqGrid+""); 
	    return JSON.stringify(tableObj.jqGrid("getRowData"))
	},
	/**
	 * 新增按钮事件 
	 * 参数说明：this，模块ID，信息页面模块id，ztreeDemo，
	 */
	add:function(obj,management,basicContent,treeDemo){ 
		var treeObj = $.fn.zTree.getZTreeObj(""+treeDemo+""),
		nodes=treeObj.getSelectedNodes();
		var $management=$("#"+management+"");
		var $basicContent=$management.find("#"+basicContent+""); 
		//工具栏和from表格的是否可见和编辑的切换
		common.toolbarControl("add", $management, $basicContent,management,basicContent);  
		//给user 面板增加阴影层
		var $panel=$("#"+management+"").find(".tree-panel"); 
		$panel.append("<div class='overlay' id='overlay'></div>");
		$panel.find("#overlay").css({position:"absolute",top:39,width:"100%",height:$panel.innerHeight(),background:"rgba(222, 219, 219, 0.35)"});
		//给user 面板增加阴影层end
		if (nodes.length>0) { 
			//取消ztree选择状态
			treeObj.cancelSelectedNode(nodes[0]);
		}; 
		//清理表单
		$basicContent.find("input").each(function(){
			
			$(this).val(""); 
		})
		
		$basicContent.find("#NewBy").text("");
		$basicContent.find("#NewTime").text("");
		$basicContent.find("#UpdateBy").text("");
		$basicContent.find("#UpdateTime").text("");
		
		//给是否为汇总节点赋值
		$basicContent.find("#isParent").val("true");
		//给上级节点赋值
		$basicContent.find("#pname").val(-1);
		$basicContent.find("#pname").data("id",-1);
		
		var jqgrids=$management.find("#content").find("table[id$='gridTable']");//获取内容标签下多个jqgrid表格
		//循环处理jqgrid表
		for(var i=0;i<jqgrids.length;i++){ 
			var jqgridId=$(jqgrids[i]).attr("id");
			//清理表格
			$management.find("#"+jqgridId+"").jqGrid("clearGridData");
			var jqgrid=jqgridId.split("-"); 
			//给jqgrid 表格增加编辑按钮  
			$management.find("#"+jqgrid[0]+"-gridPager_left").children().show(); 
		}
		
		
	},
	/**
	 * 新增子节点按钮事件
	 */
	addChild:function(obj,management,basicContent,treeDemo){
		var treeObj = $.fn.zTree.getZTreeObj(""+treeDemo+""),
		nodes=treeObj.getSelectedNodes(); 
		//判断数组是否为空
		if(nodes.length>0){ 
			var $management=$("#"+management+"");
			var $basicContent=$management.find("#"+basicContent+""); 
			//工具栏和from表格的是否可见和编辑的切换
			common.toolbarControl("add", $management, $basicContent,management,basicContent);  
			//给user 面板增加阴影层
			var $panel=$("#"+management+"").find(".tree-panel"); 
			$panel.append("<div class='overlay' id='overlay'></div>");
			$panel.find("#overlay").css({position:"absolute",top:39,width:"100%",height:$panel.innerHeight(),background:"rgba(222, 219, 219, 0.35)"});
			//给user 面板增加阴影层end
			
			//清理表单
			$basicContent.find("input").each(function(){
				
				$(this).val(""); 
			})
			$basicContent.find("#NewBy").text("");
			$basicContent.find("#NewTime").text("");
			$basicContent.find("#UpdateBy").text("");
			$basicContent.find("#UpdateTime").text("");
			
			//给上级节点赋值
			$basicContent.find("#pname").val(nodes[0].name);
			$basicContent.find("#pname").data("id",nodes[0].id);
			
			var jqgrids=$management.find("#content").find("table[id$='gridTable']");//获取内容标签下多个jqgrid表格
			//循环处理jqgrid表
			for(var i=0;i<jqgrids.length;i++){ 
				var jqgridId=$(jqgrids[i]).attr("id");
				//清理表格
				$("#"+management+"").find("#"+jqgridId+"").jqGrid("clearGridData");
				var jqgrid=jqgridId.split("-"); 
				//给jqgrid 表格增加编辑按钮
				$management.find("#"+jqgrid[0]+"-gridPager_left").children().show(); 
			}
		}else{
			loading("请选择对应的父节点",7);
		}
		
	},
	
	/**
	 * 编辑按钮
	 */
	edit:function(obj,management,basicContent){ 
		var $obj=$(obj);
		var $management=$("#"+management+"");
		var $basicContent=$management.find("#"+basicContent+"");
		var mail=$basicContent.find("#mail").val();
		var code=$basicContent.find("#code").val();
		 if(isNotEmpty(mail)||isNotEmpty(code)){ 
			$obj.parent().attr("hidden","hidden");
			common.toolbarControl("edit", $management, $basicContent);  
			//给左 面板增加阴影层
			var $panel=$("#"+management+"").find(".tree-panel");
			$panel.append("<div class='overlay' id='overlay'></div>");
			$panel.find("#overlay").css({position:"absolute",top:39,width:"100%",height:$panel.innerHeight(),background:"rgba(222, 219, 219, 0.35)"});
			//给user 面板增加阴影层end 
			
			var jqgrids=$management.find("#content").find("table[id$='gridTable']");//获取内容标签下多个jqgrid表格
			//循环处理jqgrid表
			for(var i=0;i<jqgrids.length;i++){ 
				var jqgridId=$(jqgrids[i]).attr("id"); 
				var jqgrid=jqgridId.split("-"); 
				//给jqgrid 表格增加编辑按钮
				$management.find("#"+jqgrid[0]+"-gridPager_left").children().show(); 
			}
			
		}else{
			loading("请先选择对应的节点",6);
		}
	},
	/**
	 * 保存按钮
	 * 参数说明：this,模板ID，信息页面模块id，ztreeID，from表单ID
	 */
	saveFrom:function(obj,management,basicPills,treeDemo,formId){  
		var treeObj = $.fn.zTree.getZTreeObj(""+treeDemo+"");
		var pId=$("#"+management+"").find("#"+basicPills+"").find("#pname").data("id");
		var id=$("#"+management+"").find("#"+basicPills+"").find("#id").val();
		var variableNode;
		var judge=true;
		for(var i=0;i<6;i++){//当前设置ztree节点最多6级
			variableNode=treeObj.getNodeByParam("id",pId)==null?-1:treeObj.getNodeByParam("id",pId);
			//console.log(variableNode.pId)
			if(variableNode.pId==id){
				loading("上级节点不能设置为该节点下的子节点！",4);
				judge=false;
				break;
			}
			pId=variableNode.pId; 
		}
		
		if(judge){
			 
			  $("#"+management+"").find("#"+formId+"").submit();//触发表单验证 
			
		}
	}, 
	
	/**
	 * 删除按钮
	 * 参数说明：this，模块id，信息页面模块id，ztree的id，访问目标，jqgrid的id
	 */
	dele:function(obj, management,basicPills,treeDemo,object,jqGrid){
		var $management=$("#"+management+"");
		var $basicPills=$management.find("#"+basicPills+"");
		var treeObj = $.fn.zTree.getZTreeObj(""+treeDemo+"");
		var node=treeObj.getSelectedNodes();
		if(node[0]!=null&&node[0].children!=null&&node[0].children.length!=null&&node[0].children.length>0){
			loading("该节点下有子节点，不能直接删除",4);
		}else if(node[0].id==""||node[0].id==null){
			loading("id为空",4);
		}else{ 
			var id=node[0].id; 
			//提示框
			$.tzDialog({
				title:"友情提示",
				width: "400",
				height:"300",
				content:"确定需要删除吗？",
				callback:function(state,$dialog,opts){
					if(state==true){
						common.todele(object,$management,$basicPills,id,treeObj,node[0]); 
					}
					$dialog.next().remove();//关闭阴影层
					$dialog.remove(); 
				}
			}); 
		}
	},
	todele:function(object,$management,$basicPills,id,treeObj,node){
		Jgzajax.request({
			url:basePath+"/admin/"+object+"/delete",
			success:function(data){ 
				if(data.results=="success"){
					treeObj.removeNode(node);
					//清理表单
					$basicPills.find("input").each(function(){
						
						$(this).val(""); 
					})
					
					$basicPills.find("#NewBy").text("");
					$basicPills.find("#NewTime").text("");
					$basicPills.find("#UpdateBy").text("");
					$basicPills.find("#UpdateTime").text("");
					 
					
					var jqgrids=$management.find("#content").find("table[id$='gridTable']");//获取内容标签下多个jqgrid表格
					//循环处理jqgrid表
					for(var i=0;i<jqgrids.length;i++){ 
						var jqgridId=$(jqgrids[i]).attr("id");
						//清理表格
						$management.find("#"+jqgridId+"").jqGrid("clearGridData");
						var jqgrid=jqgridId.split("-"); 
						//给jqgrid 表格增加编辑按钮
						$management.find("#"+jqgrid[0]+"-gridPager_left").children().show(); 
					}
					
				}else if(data.results=="file"){
					loading("删除失败",4);
				}else {
					//提示框
					$.tzDialog({
						title:"友情提示",
						width: "400",
						height:"300",
						content:data.ex,
						callback:function(stats,$dialog,opts){
							$dialog.next().remove();//关闭阴影层
							$dialog.remove(); 
						}
					});
					
				}
			}
		},{id:id})
	},
	/**
	 * 查找
	 * 参数说明：this，模块id，ztree的id，访问目标
	 */
	find:function(obj,management,treeDemo,target){ 
		$.tzIframe({
			title:"查询",
			content:basePath+"/admin/dictionary/buttonQuery/"+target,
			dialogId:'Dictionary',
			width:600,
			height:550,
			callback:function(perform,iframe,$dialog,opts){
				if(perform){ //如果点击确定执行
					//document.getElementById('undefined_iframe').contentWindow.document.body
					var iframe_document=$(iframe.document.body);
					//console.log(iframe_document.find("tbody > .line").html());
					var id=iframe_document.find("tbody > .line >td").eq(1).text();
					var code=iframe_document.find("tbody > .line >td").eq(2).text();
					var name=iframe_document.find("tbody > .line >td").eq(3).text(); 
					//获取ztree对象
					var treeObj = $.fn.zTree.getZTreeObj(""+treeDemo+""); 
					//查找内容
					var nodes=treeObj.getNodeByParam("id",id);  
					//定位
					treeObj.selectNode(nodes); 
				} 
				$dialog.next().remove();//关闭阴影层
				$dialog.remove();//关闭主体
			}
		});
	},
	/**
	 * 节点移动
	 */
	mobile:function(obj, management,ztreeObj){
		var $management=$("#"+management+""); 
		var $content=$management.find("#content");
		
		var zTree = $.fn.zTree.getZTreeObj(""+ztreeObj+""),
		nodes = zTree.getSelectedNodes();
		if (nodes.length == 0) {
			loading("请先选择一个节点",6);
			return;
		} 
		common.setCurSrcNode(nodes[0],ztreeObj); 
		//工具栏的显示隐藏的控制
		common.toolbarControl("mobile",$management,$content); 
	},
	/**
	 * 节点移动至
	 */
	mobileTo:function(obj, management,ztreeObj,target){
		var $management=$("#"+management+""); 
		var $content=$management.find("#content");
	 
		var zTree = $.fn.zTree.getZTreeObj(""+ztreeObj+""),
		nodes = zTree.getSelectedNodes(),
		targetNode = nodes.length>0? nodes[0]:null;  
		if(!targetNode){
			loading("请选择需要移至的节点",6);
			return;
		}else if (curSrcNode === targetNode) {
			loading("不能移动，源节点 与 目标节点相同",6);
			return;
		} else if ( (curSrcNode.parentTId === targetNode.tId) ) {
			loading("不能移动，源节点 已经存在于 目标节点中",6);
			return;
		}  else {
			var pId=nodes[0].id;
			var variableNode,
			 	judge=true;
			for(var i=0;i<6;i++){//当前设置ztree节点最多6级 
				variableNode=zTree.getNodeByParam("id",pId)==null?-1:zTree.getNodeByParam("id",pId);
				//console.log(variableNode.pId)
				if(variableNode.pId==curSrcNode.id){
					loading("上级节点不能设置为该节点下的子节点！",4);
					judge=false;
					break;
				}
				pId=variableNode.pId; 
			} 
			if(judge){ 
				zTree.expandNode(targetNode, true, true, true);
				Jgzajax.request({
					url:basePath+"/admin/system/"+target+"/updatePid",
					success:function(data){ 
						//console.log(data);
						if(data!=null){ 
							if(data.ex!=null){
								promptBox(data.ex);
							}else if(data.results=="success"){
								zTree.moveNode(targetNode, curSrcNode, "inner");
								common.setCurSrcNode(); 
								zTree.selectNode(targetNode); 
								//工具栏的显示隐藏的控制
								common.toolbarControl("mobileTo",$management,$content);
							}else if (data.results=="file") {
								promptBox("节点移动失败");
							}
						}
					} 
				},{id:curSrcNode.id,pId:nodes[0].id})
			}
			 
		}
	},
	/**
	 * 工具栏的显示控制
	 */
	toolbarControl:function(name,$management,$content){
		if(name=="save"||name=="cancel"){ 
			//保存时候的按钮显示和隐藏
			$management.find(".toolbar").find(".tohidden").attr("hidden","hidden");
			$management.find(".toolbar").find(".according").removeAttr("hidden"); 
			//基本信息的内容
			$content.find(".from-control").attr("readonly","true");
			$content.find(".from-select").attr("disabled","disabled"); 
			 
		};
		if(name=="edit"){  //修改
			$management.find(".toolbar").find(".according").attr("hidden","hidden");
			$management.find(".toolbar").find(".tohidden").removeAttr("hidden"); 
			//表单的是否编辑切换 start
			$content.find(".from-control").not("[dictionary=true]").removeAttr("readonly"); 
			$content.find(".from-select").removeAttr("disabled"); 
			//表单的是否编辑切换 end 
		};
		if(name=="add"){  //新增
			$management.find(".toolbar").find(".according").attr("hidden","hidden");
			$management.find(".toolbar").find(".tohidden").removeAttr("hidden"); 
			//表单的是否编辑切换 start
			$content.find(".from-control").not("[dictionary=true]").removeAttr("readonly"); 
			$content.find(".from-select").removeAttr("disabled"); 
			//表单的是否编辑切换 end 
		};
		if(name=="mobile"){//节点移动
			$management.find(".toolbar").find(".according").attr("hidden","hidden");
			$management.find(".toolbar").find(".tohiddenMobile").removeAttr("hidden"); 
		};
		if(name=="mobileTo"){//节点移动至
			$management.find(".toolbar").find(".tohiddenMobile").attr("hidden","hidden");
			$management.find(".toolbar").find(".according").removeAttr("hidden");  
		}
	},
	/**
	 * 对ztree的name进行拼接处理  
	 */      
	filter:function(datas){
		 
		if (!datas) {
			return null;
		}else if(datas.ex){
			datas.name=datas.ex;
		}else{ 
			for (var i=0, l=datas.length; i<l; i++) {
				datas[i].name = datas[i].code+" "+datas[i].name; 
			} 
		}
		return datas;
		
		
	},
	 /**
	  * ztree异步加载时对name进行的拼接处理
	  */
    acfilter:function(treeId, parentNode, childNodes) {    
        if (!childNodes) return null;    
        for (var i=0, l=childNodes.length; i<l; i++) {    
            childNodes[i].name = childNodes[i].code+" "+childNodes[i].name;    
        }    
        return childNodes;    
    }, 
	/**
	 * ztree异步加载时发生的异常
	 */
	onAsyncError:function(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
		var zTree = $.fn.zTree.getZTreeObj(""+treeId+"");
		loading("异步获取数据出现异常。",10); 
	},

 	/**
 	 * 用于捕获父节点展开之前的事件回调函数，并且根据返回值确定是否允许展开操作
 	 */
	beforeExpand:function(treeId, treeNode){ 
 		//判断节点时候正在加载
		if (!treeNode.isAjaxing) { 
			//var zTreeObj = $.fn.zTree.getZTreeObj(""+treeId+"");
			//清空节点下的内如
			//zTreeObj.reAsyncChildNodes(treeNode,"refresh");
			return true;
		} else {
			alert("zTree 正在下载数据中，请稍后展开节点。。。");
			return false;
		}
	},
	/**
	 * 表格编辑角色的下拉选项,state 是标识是否是dialog弹窗中加载ztree
	 * 参数说明：模板ID，from表单ID，ztreeID，向后台请求路径，ztree初始化模板
	 */
	pnameDowntree:function(management,formId,ztreeDemo,target,idName,Setting,state){  
		var zNodes;  
		$("#"+management+"").append("<div id='menuContent' class='dictionaryDown'  style='display:none; position: absolute;z-index: 102;'>"+
				"<ul id='"+ztreeDemo+"' class='ztree ztree2' style='margin-top:0; width:350px;'></ul>"+
				"</div>");
		var ztreeHeight=$("#"+management+"").find("#"+ztreeDemo+"").height();
		Jgzajax.request({
			url:basePath+"/admin/"+target+"/findZtreeList",
			success:function(data){
				zNodes=common.filter(eval(data));
				$.fn.zTree.init($("#"+management+"").find("#"+ztreeDemo+""),Setting, zNodes);
				var par=$("#"+management+"").find("#"+formId+"").find("#"+idName+""); 
				var treeObj=$("#"+management+"").find("#menuContent");
				common.showMenu(par,ztreeHeight,treeObj,state);
			}
		},{isParent:"-1"})
	},
	//ztree下拉框显示
	showMenu:function (obj,ztreeHeight,ztreeObj,state) {
		var cityObj = $(obj);  
		var cityOffset = $(obj).offset(); 
		//console.log(ztreeHeight+"==="+cityOffset.left+"===="+cityOffset.top+"==="+cityObj.outerHeight()+"==="+getClientHeight()); 
		if(state=='false'){ 
			ztreeObj.css({left: "0px", top: cityOffset.top-ztreeHeight+100+"px"}).slideDown("fast");
		} else if((getClientHeight()-(cityOffset.top+cityObj.outerHeight()))<350){   
			ztreeObj.css({left:cityOffset.left + "px", top: cityOffset.top-ztreeHeight-10+"px"}).slideDown("fast"); 
		}else{   
			ztreeObj.css({"z-index":"102",left:cityOffset.left + "px", top:cityOffset.top+cityObj.outerHeight() + "px"}).slideDown("fast");
		} 
		$("body").bind("mousedown", common.onBodyDown);
	},
	//ztree下拉框隐藏
	hideMenu:function (ztreeObj) {
		ztreeObj.fadeOut("fast");
		ztreeObj.remove();
		$("body").unbind("mousedown", common.onBodyDown);
	},
	//ztree下拉框隐藏 
	onBodyDown:function (event) {
		
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents(".dictionaryDown").length>0)) {
			//console.log($(event.target).html());
			common.hideMenu($(".dictionaryDown"));
	      }
	
	
	},
	
	
	  /**
	   * jqgrid表格中翻页按钮的统一样式start
	   */
    updatePagerIcons:function(table) {
		var replacement = 
		{
			'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
			'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
			'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
			'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
		};
		$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
			var icon = $(this);
			var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
			
			if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
		})
	},
	enableTooltips:function(table) {
		$('.navtable .ui-pg-button').tooltip({container:'body'});
		$(table).find('.ui-pg-div').tooltip({container:'body'});
	},
	 /**
	   * jqgrid表格中翻页按钮的统一样式 end
	   */
	/**
	 * 字典表格数据加载
	 */
	jqgridDataLocal:function(grid_data,$jqgrid){ //参数说明：json数据，jqgrid表格对象
		//清理表格
		$jqgrid.jqGrid("clearGridData");
		//表格赋值
		$jqgrid.jqGrid("setGridParam",{ 
			data:grid_data,
		    datatype: 'local',
		}).trigger("reloadGrid"); 
		
	},
	
	
	
	/**
	 * 字典中from表单的赋值
	 */
	assignment:function(data,$form,$form1){ //参数：数据，from对象，系统信息对象
		//清空表单
		$form.find("input").each(function(){ 
			$(this).val(""); 
		}); 
		//给表单赋值
		formAssignment($form, data); 
		//$("#userManagement").find("#user-basic-pills").find("#pname").data("id",data.pId); 
		
		$form1.find("#NewBy").text(data.newBy==null?"":data.newBy);
		$form1.find("#NewTime").text(data.newTime==null?"":data.newTime);
		$form1.find("#UpdateBy").text(data.updateBy==null?"":data.updateBy);
		$form1.find("#UpdateTime").text(data.updateTime==null?"":data.updateTime);
		//user.roleShow();//加载角色数据 
	},
	/**
	 * 下拉框的模糊查询选择-父节点专用 
	 */ 
	fuzzy:function(obj,management,basicPills,pname,target){
		var $obj=$(obj);
		var name= $obj.val(); 
		if(isNotEmpty(name)){  
			$.tzIframe({
				title:"查询",
				content:basePath+"/admin/dictionary/"+target+"/"+name+"/0"+"/15",
				dialogId:'Dictionary',
				width:400,
				height:500,
				callback:function(perform,iframe,$dialog,opts){
					if(perform){ //如果点击确定执行
						//document.getElementById('undefined_iframe').contentWindow.document.body
						var iframe_document=$(iframe.document.body);
						//console.log(iframe_document.find("tbody > .line").html());
						var id=iframe_document.find("tbody > .line >td").eq(1).text();
						var code=iframe_document.find("tbody > .line >td").eq(2).text();
						var name=iframe_document.find("tbody > .line >td").eq(3).text();
						if(isNotEmpty(id)){
							
							$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").val( code+" "+name);
							$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").data("id",id);
						}else{
							$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").val(-1);
							$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").data("id",-1);
						}
					}else{
						$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").val(-1);
						$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").data("id",-1);
					}
					$dialog.next().remove();//关闭阴影层
					$dialog.remove();//关闭主体
				}
			});
		}else{
			$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").val(-1);
			$("#"+management+"").find("#"+basicPills+"").find("#"+pname+"").data("id",-1);
		}
    },
    /**
     * ztree节点移动start 的相关方法
     */
    fontCss:function(treeNode){//给点击需要移动的节点增加样式
    	var aObj = $("#" + treeNode.tId + "_a");
		aObj.removeClass("copy").removeClass("cut");
		if (treeNode === curSrcNode) {
			aObj.addClass("cut");		
		}
    	
    },
    setCurSrcNode:function(treeNode,ztreeObj){ 
    	var zTree = $.fn.zTree.getZTreeObj(""+ztreeObj+"");
		if (curSrcNode) {  
			var tmpNode = curSrcNode;
			curSrcNode = null;
			common.fontCss(tmpNode);
		}
		curSrcNode = treeNode;
		if (!treeNode) return;

		curSrcNode.isCur = true;			
		zTree.cancelSelectedNode();
		common.fontCss(curSrcNode);
    },
  //用户设置
	settings:function(){
		var content="<p>&nbsp;&nbsp;请输入密码...:</p>" +
				"<p><input type='password' class='dtext'   id='password' autofocus='autofocus' style='width:204px;height:25px;text-indent:0.5em;border:1px solid #ccc;' value='' placeholder='请输入密码...'>" +
				"</p>";
		$.tzDialog({ 
			title:"修改密码", 
			content:content,
			callback:function(status,$dialog,opts){
				if(status==true){ 
					var newPassword=$("#tzdialog_messageID").find("#password").val(); 
					if(newPassword<5){ 
						loading("密码复杂度不够，请重新设置！"); 
						$("#tzdialog_messageID").find("#password").focus(); 
						return false ;
					}
					Jgzajax.request({
						url:basePath+"/admin/system/userMG/updeletePass",
						success:function(data){
							if(data=="success"){
								loading("密码修改成功",5)
							}else{
								loading("密码修改失败",5)
							}
						} 
					},{newPass:newPassword})
					$dialog.next().remove();//关闭阴影层
					$dialog.remove(); 

				}else{
					
					$dialog.next().remove();//关闭阴影层
					$dialog.remove(); 
				}
			} 
		})
	}
};

