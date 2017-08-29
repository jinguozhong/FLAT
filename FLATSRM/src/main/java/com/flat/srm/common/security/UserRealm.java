package com.flat.srm.common.security;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.security.bean.ShiroToken;
import com.flat.srm.common.util.JgzConstant;
import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.system.bean.Authorization;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.service.authorization.IAuthorizationService;
import com.flat.srm.system.service.user.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private IUserService userService;
	@Autowired
	private SessionDAO sessionDAO;
	@Autowired
	private IAuthorizationService authorizationService;

	// 身份认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		// 从传入的token获取我们的身份信息(userName)
		// UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		ShiroToken token = (ShiroToken) authcToken; 
		String userName = token.getUsername();
		String password = new String((char[]) token.getPassword());
		// 将前台获取的密码进行加密
		String passwordMd5 = "sb" + TmStringUtils.md5Base64(password);
		// 将加密好的密码赋给shiro，UsernamePasswordToken中
		token.setPassword(passwordMd5.toCharArray());
		User user  = userService.getLogin(userName); 
		
		if(null==user){
			throw new UnknownAccountException("用户名或密码无效");
		}
		if (userName.equals(user.getMail())) {// 身份信息已经确认，接下来进行凭证信息匹配
			if (passwordMd5.equals(user.getPassword())) { 
				//
				user.setRoleId(token.getRole());
				// 身份信息确认以后，凭证信息的确认由SimpleAuthenticationInfo
				// 的父类AuthenticationInfo进行验证
				SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,
						user.getPassword(), getName()); 
				ShiroSessionUtil.setSessions(JgzConstant.SESSION_USER, user);
				ShiroSessionUtil.setSessions(JgzConstant.SESSION_USER_USERNAME, user.getName());
				return simpleAuthenticationInfo;
			} else {
				throw new IncorrectCredentialsException("密码或用户名无效");
			}
		} else {
			throw new UnknownAccountException("用户名或密码无效");
		} 
	}

	// 授权认证

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principle) {
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		User user = (User) principle.getPrimaryPrincipal(); 
		if(user.getRoleId()!=null){ 
			// 模拟根据的到的user对象的userName或者userId去数据库查询这个用户存在哪些资源操作权限
			List<String> permissions = new ArrayList<String>(); 
			TzParams params = new TzParams();
			params.setId(user.getRoleId());
			List<Authorization> lisAuthorizations = authorizationService.finds(params);
			for (Authorization authorization : lisAuthorizations) {
				permissions.add(authorization.getCode());
			}
			// 将得到的权限信息放入simpleAuthorizationInfo对象保存
			for (String permission : permissions) {
				simpleAuthorizationInfo.addStringPermission(permission);
			} 
		}
		return simpleAuthorizationInfo;
	}

}
