package com.flat.srm.dictionary.web;

import com.alibaba.fastjson.JSON;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.dictionary.bean.Supplier;
import com.flat.srm.dictionary.service.supplier.ISupplierService;
import com.flat.srm.dictionary.service.supplier.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商字典入库
 * classNmae SupplierController
 * package com.flat.srm.dictionary.web
 * user jingu
 * date 2017/8/19
 * time 上午 9:20
*/
@Controller
@RequestMapping(value="/admin/supplier")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    @RequestMapping(value = "/supplierMG")
    //@RequiresPermissions("system/roleMG")
    public ModelAndView goIndex(ModelAndView modelAndView) {
        /**
         *SupplierController方法goIndex的功能描述:进入供应商管理页面
         * @paam [modelAndView]
         * @return org.springframework.web.servlet.ModelAndView
         * @throws
         * @sice v1.0
         * @author jingu qq 274492196
         * 2017/8/19
        */
        modelAndView.setViewName("supplier/SupplierManagement");
        return modelAndView;
    }
    @RequestMapping(value = "/certificationMG")
    //@RequiresPermissions("system/roleMG")
    public ModelAndView goIndexCertification(ModelAndView modelAndView) {
        /**
         *SupplierController方法goIndex的功能描述:进入供应商认证管理页面
         * @paam [modelAndView]
         * @return org.springframework.web.servlet.ModelAndView
         * @throws
         * @sice v1.0
         * @author jingu qq 274492196
         * 2017/8/19
         */
        modelAndView.setViewName("supplier/CertificationMG");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/noCertificationFinds",method = RequestMethod.POST)
    public Map<String,Object> find(TzParams params){
        /**
         *SupplierController方法find的功能描述
         * 查询未认证的供应商信息
         * @paam [params]
         * @return java.util.Map<java.lang.String,java.lang.Object>
         * @throws
         * @sice v1.0
         * @author jingu qq 274492196
         * 2017/8/24
        */
        Map<String,Object> maps = null;
        if (params.getState()==0){
            maps = supplierService.find(params);
        }
        return  maps;
    }

    @RequestMapping(value = "/noCertificationFinds/{par}")
    public ModelAndView supplersTP(@PathVariable("par") String par){
        /**
         *SupplierController方法supplersTP的功能描述
         * 双击未认证供应商的信息显示该供应商的详细信息页面
         * @paam []
         * @return org.springframework.web.servlet.ModelAndView
         * @throws
         * @sice v1.0
         * @author jingu qq 274492196
         * 2017/8/28
        */
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("supplier/SupplierTP");
        return  modelAndView;
    }
}
