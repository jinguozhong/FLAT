var registere={ 
	/**
 	 * 表单验证
 	 */
	validation:function($err){  
		//basicFrom的表单验证
		 $("#submitLogin").Validform({    
		 	tiptype:function(msg,o,cssctl){ //提示位置
		 	  cssctl($err,o.type);
		 	  $err.text(msg);  
			},
			callback:function(form){     
				var data=formObtain(form);
				Jgzajax.request({
					url:basePath+"/supplier/save",
					success:function(data){
						if(data!=null){
							if(data.ex!=null){
								promptBox(data.ex);
							}else if(data.results.indexOf("ok")>=0) {
                                var id=data.results.substring(2);
								$("#submitLogin").data("id",id);
                                $("#company").slideUp("slow",function(){
                                    $("#certificate").slideDown();
                                });
							}else if(data.results=="file"){
                                promptBox("提交失败");
							}
						}
                        $("#next").attr("onclick","next(this)");
					}
				},data);
				return false;
			} 
		});  
	},
	/**
	 * 文件信息保存
	 */
	save:function(data){
		Jgzajax.request({
            url:basePath+"/supplier/fileSave",
            success:function(data){
                if(data!=null){
                    if(data.ex!=null){
                        promptBox(data.ex);
                    }else if(data.results="ok") {
						loading("保存成功！",6);
                    }else if(data.results=="file"){
                        promptBox("图片保存失败，请重新上传。");
                    }
                }
            }
		},data)
	}
} 
