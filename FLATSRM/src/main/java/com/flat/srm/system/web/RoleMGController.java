package com.flat.srm.system.web;

import com.flat.srm.common.core.BaseController;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.util.JgzConstant;
import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.service.role.IRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/system")
public class RoleMGController extends BaseController {
	@Autowired
	private IRoleService roleService;

	/**
	 * 
	 * 进入角色管理页面<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：goIndex<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月7日-下午1:26:29 <br/>
	 * @param modelAndView
	 * @return 
	 * 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping(value = "/roleMG")
	@RequiresPermissions("system/roleMG")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("system/RoleManagement");
		return modelAndView; 
	}

	/**
	 * 
	 * 角色管理ztree数据加载<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：liRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年12月21日-下午7:12:30 <br/>
	 * 
	 * @return 返回类型List<Role><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/roleMG/findZtreeList", method = RequestMethod.POST)
	public List<Role> finds(TzParams params) { 
		List<Role> lisRoles = roleService.finds(params);
		return lisRoles; 
	}

	/**
	 * 查询角色明细信息 
	 * com.flat.srm.system.web <br/>
	 * 方法名：find<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月7日-下午2:20:04 <br/>
	 * @param params
	 * @return 
	 * 返回类型Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/roleMG/find", method = RequestMethod.POST)
	public Map<String, Object> find(TzParams params) {
		Map<String, Object> map =new HashMap<>(); 
		Role role = new Role();
		role = roleService.find(params); 
		if(role.getPname()==null){
			role.setPname("-1,-1");
		}
		List<HashMap<String, Object>> jqgridData=roleService.findRoleUsers(role.getId());
		map.put("role",role);
		map.put("jqgridData", jqgridData);
		return map;

	}

	/**
	 * 
	 * 根据角色查询对应的用户<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：findRoleUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月7日-下午2:22:07 <br/>
	 * 
	 * @return 返回类型List<HashMap<String,Object>><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/roleMG/findRoleUsers", method = RequestMethod.POST)
	public Map<String, Object> findRoleUsers(HttpServletRequest request) {
		String par = request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		List<HashMap<String, Object>> lists = null;
		if (TmStringUtils.isNotEmpty(par)) {

			Long id = Long.valueOf(par);
			lists = roleService.findRoleUsers(id);
			map.put("page", "1");
			map.put("total", "1");
			map.put("records", "1");
			map.put("rows", lists);
		}
		return map;

	}

	/**
	 * 
	 * 保存数据<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：save<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月8日-上午10:37:37 <br/>
	 * 
	 * @param request
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/roleMG/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request) {
		String datas = request.getParameter("datas");
		String updateNmae = (String) session
				.getAttribute(JgzConstant.SESSION_USER_USERNAME);
		String erry = null;
		try {
			return roleService.saveAll(datas, updateNmae);
		} catch (Exception e) {
			System.out.println("e====" + e.toString());
			erry = e.toString();
			return erry;
		}

	}

	/**
	 * 
	 * 删除数据<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：delete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月9日-下午1:29:02 <br/>
	 * 
	 * @param request
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/roleMG/delete", method = RequestMethod.POST)
	public Map<String, Object> delete(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		Long id = Long.valueOf(request.getParameter("id"));
		try {
			Integer i = roleService.deleteAll(id);
			if (i != 0) {
				map.put("results", "success");
			} else {
				map.put("results", "file");
			}
		} catch (Exception e) { 
			e.printStackTrace();
			map.put("ex", e.toString());

		}
		return map;

	}
	
	
	/**
	 * 修改ztree节点上级节点 
	 * com.flat.srm.system.web <br/>
	 * 方法名：updatePid<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月10日-上午9:44:12 <br/>
	 * @param role
	 * @return 
	 * 返回类型Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/roleMG/updatePid", method = RequestMethod.POST)
	public Map<String, Object> updatePid(Role role){
		Map<String, Object> map =new HashMap<>(); 
		Integer integer=roleService.update(role);
		if (integer>0) { 
			map.put("results", "success");
		}else{
			map.put("results", "file");
		}
		return map; 
	}
}
