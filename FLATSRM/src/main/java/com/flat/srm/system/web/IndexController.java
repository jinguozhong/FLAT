package com.flat.srm.system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * srm系统的首页
 * 
 * indexController<br/>
 * 创建人:JGZ<br/>
 * 时间：2017年6月7日-上午11:20:58 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
@RequestMapping(value="/admin")
public class IndexController {
	/**
	 * 
	 * 进入首页<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：goIndex<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月8日-下午9:37:39 <br/>
	 * @return 
	 * 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	 
	@RequestMapping(value="/index")
	public ModelAndView goIndex(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView; 
	}

}
