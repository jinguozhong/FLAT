package com.flat.srm.system.web;

import com.flat.srm.common.core.BaseController;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.security.bean.ShiroToken;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.service.role.IRoleService;
import com.google.code.kaptcha.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController extends BaseController{
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 
	 * 进入登入页面<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：goLogin<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月8日-下午9:37:55 <br/>
	 * @return 
	 * 返回类型ModelAndView<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping(value="/login")
	public ModelAndView goLogin(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	/**
	 * 
	 * 登入提交<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：submitLogin<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月8日-下午9:38:07 <br/>
	 * @return 
	 * 返回类型String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping(value="/submitLogin",method=RequestMethod.POST)
	public String submitLogin(RedirectAttributes attributes){
		String name=request.getParameter("username");
		String password=request.getParameter("password"); 
		String role = request.getParameter("role");
		String validation = request.getParameter("validation");
		// 系统生成的验证码
		String validationSystem = (String) session
				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		Subject subject=SecurityUtils.getSubject();
		ShiroToken shiroToken=new ShiroToken(name, password);
		shiroToken.setRole(Long.valueOf(role));
		// 集如果提交用户希望他们的身份(校长(s))记得跨会话。除非覆盖,默认值是false,指示不记得跨会话。
		shiroToken.setRememberMe(true); 
		//if(validation.equals(validationSystem)){ 
		try {
			subject.login(shiroToken);
			return "redirect:/admin/index"; 
		} catch (Exception e) {
			String err=e.getMessage();
			attributes.addFlashAttribute("lodinErrorMg", err);
			shiroToken.clear();
			return "redirect:/login"; 
		}
//		}else{
//			attributes.addFlashAttribute("lodinErrorMg", "验证码错误"); 
//			return "redirect:/login"; 
//		}
		 
	}
	/**
	 * 
	 * 登入退出<br/>
	 * com.flat.srm.system.web <br/>
	 * 方法名：getLogout<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月19日-上午9:24:13 <br/>
	 * @return 
	 * 返回类型String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping(value = "/getLogout")
	public String getLogout() {
		// session.invalidate();
		Subject subject = SecurityUtils.getSubject();
		subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		// session.invalidate();
		// logger.debug("用户" + username + "退出登录");

		return "redirect:/login";

	}
	/**
	 * 登入时根据用户查询对应的角色 
	 * com.flat.srm.system.web <br/>
	 * 方法名：findRole<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月12日-上午8:04:50 <br/>
	 * @param params
	 * @return 
	 * 返回类型List<Role><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping(value = "/LodingfindRole", method = RequestMethod.POST)
	public List<Role> findRole(TzParams params) {
		List<Role> lRoles = roleService.findLodinRoles(params);
		return lRoles;

	}

}
