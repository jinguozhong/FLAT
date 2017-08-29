package com.flat.srm.system.web;

import com.flat.srm.common.core.BaseController;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.util.JgzConstant;
import com.flat.srm.system.bean.Permissions;
import com.flat.srm.system.service.permissions.IPermissionsService;
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
public class PermissionsMGController extends BaseController {
	@Autowired
	private IPermissionsService permissionsService;

	/**
	 * 
	 * 进入权限管理页面<br/>
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
	@RequestMapping(value = "/permissionsMG")
	@RequiresPermissions("system/permissionsMG")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("system/PermissionsManagement");
		return modelAndView; 
	}

	/**
	 * 
	 * 权限管理ztree数据加载<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：liPermissionss<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年12月21日-下午7:12:30 <br/>
	 * 
	 * @return 返回类型List<Permissions><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/permissionsMG/findZtreeList", method = RequestMethod.POST)
	public List<Permissions> finds(TzParams params) { 
		List<Permissions> lisPermissionss = permissionsService.finds(params);
		return lisPermissionss; 
	}

	/**
	 * 查询权限明细信息 
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
	@RequestMapping(value = "/permissionsMG/find", method = RequestMethod.POST)
	public Map<String, Object> find(TzParams params) {
		Map<String, Object> map =new HashMap<>(); 
		Permissions permissions = new Permissions();
		permissions = permissionsService.find(params); 
		if(permissions.getPname()==null){
			permissions.setPname("-1,-1");
		} 
		map.put("permissions",permissions); 
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
	@RequestMapping(value = "/permissionsMG/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request,Permissions permissions) {   
		String updateName=(String) session
				.getAttribute(JgzConstant.SESSION_USER_USERNAME);
		String erry = null;
		try {
			return permissionsService.saveAll(permissions,updateName);
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
	@RequestMapping(value = "/permissionsMG/delete", method = RequestMethod.POST)
	public Map<String, Object> delete(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		Long id = Long.valueOf(request.getParameter("id"));
		try {
			Integer i = permissionsService.delete(id);
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
	 * @param permissions
	 * @return 
	 * 返回类型Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/permissionsMG/updatePid", method = RequestMethod.POST)
	public Map<String, Object> updatePid(Permissions permissions){
		Map<String, Object> map =new HashMap<>(); 
		Integer integer=permissionsService.update(permissions);
		if (integer>0) { 
			map.put("results", "success");
		}else{
			map.put("results", "file");
		}
		return map; 
	}
}
