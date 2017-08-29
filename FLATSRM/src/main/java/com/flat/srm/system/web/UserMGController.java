package com.flat.srm.system.web;

import com.flat.srm.common.core.BaseController;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.util.JgzConstant;
import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.service.user.IUserService;
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
@RequestMapping(value="/admin/system")
public class UserMGController extends BaseController{
	@Autowired
	private IUserService userService;
	
	/**
	 * 
	 * 进入用户管理界面<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：goIndex<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月8日-下午9:37:39 <br/>
	 * @return 
	 * 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */ 
	@RequestMapping(value="/userMG")
	@RequiresPermissions("system/userMG")
	public ModelAndView goIndex(){ 
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("system/UserManagement");
		return modelAndView; 
	}
	/**
	 * 
	 * 获取用户树数据<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：findUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月16日-上午11:29:43 <br/>
	 * @return 
	 * 返回类型List<User><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value="/userMG/findZtreeList",method=RequestMethod.POST)
	public List<User> findUsers(TzParams params){
		 
		List<User> users=userService.findUsers(params);
		return users;
		
		
	}
	/**
	 * 
	 * 查询用户信息和对应的角色<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：find<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月22日-上午8:58:05 <br/>
	 * @param params
	 * @return 
	 * 返回类型Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value="/userMG/find",method=RequestMethod.POST)
	public Map<String, Object> find(TzParams params){
		Map<String, Object> map =new HashMap<>(); 
		//查询用户信息
		User user=userService.findUser(params);  
		if (user.getPname()==null) {
			user.setPname("-1,-1");
		}
		List<HashMap<String, Object>> userRoles=userService.userRoles(params.getId());
		map.put("user", user); 
		map.put("jqgridData", userRoles);
		return map;
	}
	
	/**
	 * 
	 * 用户字典保存方法<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：save<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月29日-下午4:45:31 <br/>
	 * @param request
	 * @return 
	 * 返回类型String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/userMG/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request) {
		String datas = request.getParameter("datas");
		String updateNmae = (String) session.getAttribute(JgzConstant.SESSION_USER_USERNAME);
		String results = null;
		try {
			results = userService.saveAll(datas, updateNmae);
		} catch (Exception e) {
			// System.out.println("e====" + e.toString());
			results = e.toString();
		}
		return results;

	}
	/**
	 * 
	 * 修改ztree节点上级节点<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：updatePid<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月3日-下午1:19:04 <br/>
	 * @return 
	 * 返回类型Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */ 
	@ResponseBody
	@RequestMapping(value = "/userMG/updatePid", method = RequestMethod.POST)
	public Map<String, Object> updatePid(User user){
		Map<String, Object> map =new HashMap<>(); 
		Integer integer=userService.update(user);
		if (integer>0) { 
			map.put("results", "success");
		}else{
			map.put("results", "file");
		}
		return map; 
	}
	/**
	 * 
	 * 删除功能<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：delete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月5日-上午9:35:45 <br/>
	 * @param request
	 * @return 
	 * 返回类型String<br/>
	 * @throws Exception 
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/userMG/delete", method = RequestMethod.POST)
	public Map<String, Object> delete(HttpServletRequest request) throws Exception {
		Map<String, Object> map =new HashMap<>(); 
		Long id = Long.valueOf(request.getParameter("id"));  
	 	Integer i;
		try {
			i = userService.deleteAll(id); 
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
	 * 
	 * 用户密码修改
	 * com.flat.srm.system.web <br/>
	 * 方法名：updeletePass<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月13日-下午5:20:51 <br/>
	 * @param request
	 * @return 
	 * 返回类型String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/userMG/updeletePass", method = RequestMethod.POST)
	public String updeletePass(HttpServletRequest request) {
		String newPass = request.getParameter("newPass");
		User user = (User) session.getAttribute(JgzConstant.SESSION_USER);
		String passwordMd5 = "sb" + TmStringUtils.md5Base64(newPass);// 将密码进行加密
		user.setPassword(passwordMd5);
		Integer integer = userService.updeletePass(user);
		String results = "success";
		if (integer == 0) {
			results = "fille";
		}
		return results;
	}
	
	
	/**
	 * 
	 * 用户密码初始化<br/>
	 * com.flat.edms.system.web <br/>
	 * 方法名：passInit<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年5月27日-上午9:31:54 <br/>
	 * @return 
	 * 返回类型String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/userMG/passInit", method = RequestMethod.POST)
	public  Map<String, Object> passInit( ){ 
		String id=request.getParameter("id");
		User user=new User();
		user.setId( Long.parseLong( id));
		Map<String, Object> map=new HashMap<String,Object>(); 
		Integer integer=userService.updeletePass(user);
		if(integer!=0){
			map.put("results", "success");
		}else{
			map.put("results", "fail");
		} 
		return map;
		
	}
 
}
