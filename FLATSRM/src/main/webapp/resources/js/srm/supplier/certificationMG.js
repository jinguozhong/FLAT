
/**
* jqgrid表格编辑模板
*/

var certificationMG={
    //jqgrid 表格初始化
    jqgridIni:function($gridTable,width,height){

        $gridTable.jqGrid({
            //data:data2,
            url:basePath+"/admin/supplier/noCertificationFinds",
            editurl:null,
            datatype:"json",
            mtype:"post",
            postData:{"state":0},
            height: height,
            width:width,
            colModel:[
                { label: "id", name: "id", hidden:true},
                { label: "公司类型", name: "type", width: "100"},
                { label: "公司名称", name: "company", width: "200"},
                { label: "企业性质", name: "nature", width: "200"},
                { label: "所属行业", name: "industry", width: "200"},
                { label: "开户银行", name: "bank", width: "200"},
                { label: "银行账号", name: "bankAccount", width: "200"},
                { label: "法人", name: "legalPerson", width: "200"},
                { label: "法人联系电话", name: "legalPersonPhone", width: "200"},
                { label: "国家", name: "countries", width: "200"},
                { label: "省/自治区/直辖市", name: "province", width: "200"},
                { label: "地址", name: "address", hidden:true},
                { label: "邮箱号", name: "mail",hidden:true},
                { label: "用户名称", name: "userName", hidden:true},
                { label: "部门", name: "department", hidden:true},
                { label: "职务", name: "position",hidden:true},
                { label: "电话", name: "phone", hidden:true},
                { label: "企业生产执行标准情况", name: "production",hidden:true},
                { label: "质量保证情况", name: "quality",hidden:true}
            ],
            rowNum:100,//显示的记录数
            rowList : [100,200,300],
            viewrecords : true,
            altRows: true,
            rownumbers:true,
            multiselect: false,
            shrinkToFit:false,
            autoScroll:false,
            pager:"#supplier-gridPager",
            loadComplete : function() {
                var table = this;
                setTimeout(function(){
                    certificationMG.updatePagerIcons(table);
                }, 0);
            },
            ondblClickRow:function(rowid,iRow,iCol,e){
                var data=$gridTable.jqGrid('getRowData',rowid);
                certificationMG.jqgridEdit(width,height,data);
            }
        });
        //隐藏表格中的工具栏目
        //$("#certificationMG-content").find("#supplier-gridPager_left").children().hide();
        $("#supplier-gridTable").closest(".ui-jqgrid-bdiv").css({ 'overflow-x' : 'scroll'});
        $(window).triggerHandler('resize.jqGrid');
    },
    /*工具栏样式*/
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
    //jqgrid 表格添加
    jqgridAdd:function(width,height,data){
        $.tzDialog({
            title:"供应商信息",
            width:width,
            height:height,
            content:content,
            callback:function(state,$dialog,opts){
                if(state==true){
                    certificationMG.jqgridAddLine();
                }
                //关闭弹窗
                $dialog.next().remove();
                tzUtil.animates($dialog,opts.animate);
            }
        });
        /*数据加载*/
        formAssignment($("#supplier"),data);
    },
    /**
     * 表格修改
     * 参数说明：选择的行ID
     */
    jqgridEdit:function(width,height,data){
        console.log(data);
        $.tzIframe({
            title:"未认证供应商信息",
            content:basePath+"/admin/supplier/noCertificationFinds/"+data.id,
            dialogId:'noCertificationSupplier',
            width:width,
            height:height,
            callback:function(perform,iframe,$dialog,opts){
                if(perform){ //如果点击确定执行

                }
                $dialog.next().remove();//关闭阴影层
                $dialog.remove();//关闭主体
            }
        });
        //弹窗加载end
        //将获取的行数据进行赋值
        formAssignment($(".tzui-dialog").find("#supplier"),data);
    },

    /**
     * 行删除
     */
    formDeleRow:function(e){
        var jqgrid = $("#roleMG-content").find("#user-gridTable");
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
    }

};


