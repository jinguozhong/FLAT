package com.flat.srm.system.web;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Permissions;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.service.permissions.IPermissionsService;
import com.flat.srm.system.service.role.IRoleService;
import com.flat.srm.system.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 
 * 对字典字典功能的操作 Dictionary<br/>
 * 创建人:JGZ<br/>
 * 时间：2016年11月11日-下午3:29:05 <br/>
 * 
 * @version 1.0.0<br/>
 *
 */
@Controller
@RequestMapping("/admin/dictionary")
public class DictionaryController {
	@Autowired												
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermissionsService permissionsService;
	/**
	 * 
	 * 模糊查询弹窗页面跳转<br/>
	 * com.jgz.web.common <br/>
	 * 方法名：queryInterface<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年11月12日-下午1:04:54 <br/>
	 * 
	 * @return 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping("/{target}/{name}/{pageNo}/{pageSize}")
	public ModelAndView queryInterface(@PathVariable("target") String target,
			@PathVariable("name") String name,
			@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		// String formattingName = "%" + name + "%";
		TzParams params = new TzParams();
		params.setTarget(target);
		params.setName(name);
		params.setPageNo(pageNo);
		params.setPageSize(pageSize);
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (target.equals("user")) {
				List<User> lists = userService.findUserDictionary(params);
				modelAndView.addObject("lists", lists);
			}
			modelAndView.addObject("target", target);
			modelAndView.addObject("parname", name);
			modelAndView.setViewName("public/DictionaryQuery");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}

	/**
	 * 
	 * 查询按钮点出页面初始化<br/>
	 * com.jgz.web.common <br/>
	 * 方法名：queryIni<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月3日-上午10:07:55 <br/>
	 * 
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping(value = "/buttonQuery/{target}")
	public ModelAndView queryIni(@PathVariable("target") String target) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("target", target);
		modelAndView.setViewName("public/ButtonDictionaryQuery");
		return modelAndView;

	}

	/**
	 * 
	 * 用户页面滚动分页查询数据<br/>
	 * com.jgz.web.common <br/>
	 * 方法名：scrollQueryUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年11月25日-下午1:25:09 <br/>
	 * 
	 * @return 返回类型List<User><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/scrollQuery/userMG", method = RequestMethod.POST)
	public List<User> scrollQueryUsers(TzParams params) {
		List<User> lists = null;
		try {
			lists = userService.findUserDictionary(params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lists;

	}
	/**
	 *   角色页面滚动分页查询数据<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：scrollQueryUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月10日-上午10:41:15 <br/>
	 * @param params
	 * @return 
	 * 返回类型List<User><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/scrollQuery/roleMG", method = RequestMethod.POST)
	public List<Role> scrollQueryRoles(TzParams params) {
		List<Role> lists = null;
		try {
			lists = roleService.findRoles(params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lists;

	}
	
	/**
	 * 权限管理页面滚动分页查询数据<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：scrollQueryUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月10日-上午10:41:15 <br/>
	 * @param params
	 * @return 
	 * 返回类型List<User><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/scrollQuery/permissionsMG", method = RequestMethod.POST)
	public List<Permissions> scrollQueryPermissionss(TzParams params) {
		List<Permissions> lists = null;
		try {
			lists = permissionsService.findPermissionss(params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lists;

	}
  
}
