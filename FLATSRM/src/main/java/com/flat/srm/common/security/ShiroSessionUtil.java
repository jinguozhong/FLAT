package com.flat.srm.common.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroSessionUtil {
	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @return
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	public static void setSessions(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	/**
	 * 
	 * 获取shiro中的session<br/>
	 * com.jgz.security.session <br/>
	 * 方法名：getSession<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月25日-下午8:49:24 <br/>
	 * 
	 * @return 返回类型Session<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */

	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);

			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {

		}
		return null;
	}
}
