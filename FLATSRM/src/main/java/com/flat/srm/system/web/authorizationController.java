package com.flat.srm.system.web;

import com.alibaba.fastjson.JSON;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Authorization;
import com.flat.srm.system.service.authorization.IAuthorizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/system")
public class authorizationController {

	@Autowired
	private IAuthorizationService authorizationService;

	/**
	 * 
	 * 页面跳转<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：EnterRole<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月10日-上午10:47:34 <br/>
	 * 
	 * @param modelAndView
	 * @return 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */ 
	@RequestMapping(value = "/authorizationMG", method = RequestMethod.GET)
	@RequiresPermissions("system/authorizationMG")
	public ModelAndView EnterRole(ModelAndView modelAndView) {
		modelAndView.setViewName("system/AuthorizationManagement");
		return modelAndView;

	}

	/**
	 * 
	 * 授权管理ztree数据加载<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：finds<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月10日-下午1:40:01 <br/>
	 * 
	 * @param params
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/authorizationMG/findZtreeList", method = RequestMethod.POST)
	public List<Authorization> findAll(TzParams params) {

		List<Authorization> lisauthorization = authorizationService
				.findAll(params);
		// return JSON.toJSONString(lisauthorization);
		return lisauthorization;

	}

	/**
	 * 
	 * 查询选中角色所对应的权限<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：finds<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月16日-下午1:27:00 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<Authorization><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/authorizationMG/finds", method = RequestMethod.POST)
	public List<Authorization> finds(TzParams params) {

		List<Authorization> lisauthorization = authorizationService
				.finds(params);
		// return JSON.toJSONString(lisauthorization);
		return lisauthorization;

	}

	/**
	 * 
	 * 编辑授权页面br/> com.jgz.web.system <br/>
	 * 方法名：queryInterface<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月15日-上午9:56:03 <br/>
	 * 
	 * @param id
	 * @return 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping("/authorizationMG/popup/{id}")
	@RequiresPermissions("system/authorizationMG/edit") 
	public ModelAndView queryInterface(@PathVariable("id") Long id) {
		// String formattingName = "%" + name + "%";
		Map<String, Object> map = authorizationService.findMap(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("lisauthorizationAll",
				map.get("lisauthorizationAll"));
		modelAndView.addObject("lisauthorization", map.get("lisauthorization"));
		modelAndView.setViewName("system/Authorization");

		return modelAndView;

	}

	/**
	 * 
	 * 授权保存<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：svae<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月15日-下午3:59:31 <br/>
	 * 
	 * @param request
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/authorizationMG/save", method = RequestMethod.POST)
	public String svae(HttpServletRequest request, TzParams params) {
		String data = request.getParameter("Data");
		params = JSON.parseObject(data, TzParams.class);
		String ret = "";
		try {
			String results = authorizationService.save(params);
			if (results == "ok") {
				ret = "scuuess";
			} else if (results == "null") {
				ret = "null";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = e.toString();
		}
		return ret;

	}
}
