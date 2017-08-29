package com.flat.srm.common.ex;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView modelAndView = new ModelAndView();
		String requestType = request.getHeader("X-Requested-With");
		String errString = ex.getClass() + ":" + ex.getMessage() + ":"
				+ ex.getCause();
		// 判断是否是ajax去请求
		if (requestType != null && requestType.equals("XMLHttpRequest")) { 
			/* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
			FastJsonJsonView view = new FastJsonJsonView();
			map.put("ex", errString);
			view.setAttributesMap(map);
			modelAndView.setView(view);
			return modelAndView;

		} else {
			System.out.println("非ajax发生了异常"); 
			modelAndView.addObject("ex", errString);
			modelAndView.setViewName("/error");
			return modelAndView;
		}

	}
}
