package com.flat.srm.system.web;

import com.flat.srm.dictionary.bean.Supplier;
import com.flat.srm.dictionary.bean.SupplierPicture;
import com.flat.srm.dictionary.service.supplier.ISupplierService;
import com.flat.srm.dictionary.service.supplierPicture.ISupplierPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegisteredController { 
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private ISupplierPictureService supplierPictureService;
	
	/**
	 * 
	 * 注册页面跳转<br/>
	 * com.jgz.web <br/>
	 * 方法名：goRegistered<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年4月8日-下午1:28:09 <br/>
	 * 
	 * @param modelAndView
	 * @return 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping("/registered")
	public ModelAndView goRegistered(ModelAndView modelAndView) {
		modelAndView.setViewName("/registered");
		return modelAndView;

	}
 
	
	 /**
	  * 
	  * 供应商注册保存<br/>
	  * com.flat.srm.system.web <br/>
	  * 方法名：save<br/>
	  * 创建人：JGZ <br/>
	  * 时间：2017年7月26日-下午1:57:59 <br/>
	  * @param supplier
	  * @return 
	  * 返回类型Map<String,Object><br/>
	  * @exception <br/>
	  * @since  1.0.0<br/>
	  */
	@ResponseBody
	@RequestMapping(value="/supplier/save")
	public Map<String, Object> save(@Valid Supplier supplier,Errors errors){
		Map<String, Object> map=new HashMap<String,Object>();
		//后台表单验证
		if(errors.hasErrors()){ 
			List<ObjectError> listError=errors.getAllErrors(); 
			String err="";
			for (ObjectError objectError : listError) {
				err+=objectError.getDefaultMessage()+","; 
			}
			map.put("results", err);
		}else{

			Long id=supplierService.save(supplier);
			if(id!=0){
                map.put("results", "ok"+supplier.getId());
            } else {
			    map.put("results","file");
            }
		}
		return map;
		
	}
	@ResponseBody
	@RequestMapping(value="/supplier/fileSave")
	public Map<String,Object> fileSave(@Valid SupplierPicture supplierPicture,Errors errors){
		/**
		 *RegisteredController方法fileSave的功能描述
		 * @paam [supplierPicture, errors]
		 * @return java.util.Map<java.lang.String,java.lang.Object>
		 * @throws
		 * @sice v1.0
		 * @author jingu qq 274492196
		 * 2017/8/14
		*/
		Map<String,Object> map=new HashMap<String,Object>();
		//后台表单验证
		if(errors.hasErrors()){
			List<ObjectError> listError=errors.getAllErrors();
			String err="";
			for (ObjectError objectError : listError) {
				err+=objectError.getDefaultMessage()+",";
			}
			map.put("results", err);
		}else{
			Integer i=supplierPictureService.save(supplierPicture);
			if(i!=0){
				map.put("results", "ok");
			} else {
				map.put("results","file");
			}
		}
		return  map;
	}

}
