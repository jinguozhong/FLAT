package com.flat.srm.common.security.filter;

import com.flat.srm.common.util.JgzConstant;
import com.flat.srm.system.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFormAuthFilter extends FormAuthenticationFilter {
	/**
	 * 重写身份认证不成功方法
	 */
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		System.out.println("================登入失败");
		System.out.println("=======失败提示：" + e);
		String errorMg = "";
		if (e instanceof UnknownAccountException) {
			errorMg = "用户名不正确";
		} else if (e instanceof IncorrectCredentialsException) {
			errorMg = "密码不正确";
		} else {
			errorMg = "null,用户名不存在";
		}
		request.setAttribute("errorMg", errorMg);
		return true;
	}

	/**
	 * 重写身份认证成功以后返回地址
	 */
	protected void issueSuccessRedirect(ServletResponse response, ServletRequest request) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		// 获取shiro的session
		Session session = subject.getSession();
		// 获取SimpleAuthenticationInfo传进去的User参数
		User user = (User) subject.getPrincipal();
		// 获取<property name="successUrl" value= "/admin/index"></property> 配置的地址
		String successUrl = getSuccessUrl();
		System.out.println("=======进入了issueSuccessRedirect方法+++++");
		if (null != user) {

			if (null != session) {
				session.setAttribute(JgzConstant.SESSION_USER, user);
				session.setAttribute(JgzConstant.SESSION_USER_USERNAME, user.getName());
			}
			// 获取容器的servlet上下文，并且将user放到requset作用域中
			request.getServletContext().setAttribute(JgzConstant.USER_LOG, user);
			request.getServletContext().setAttribute(JgzConstant.REQUEST_LOG, request);

		}
		WebUtils.issueRedirect(request, response, successUrl, null, true);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// System.out.println("进入了onAccessDenied");
		return super.onAccessDenied(request, response);
	}

}
