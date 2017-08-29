package com.flat.srm.common.core.aop;

import com.flat.srm.common.util.JgzConstant;
import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.common.util.ip.TmIpUtil;
import com.flat.srm.system.bean.AdminLog;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.dao.adminlog.IAdminLogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Aspect
public class LogInterceptor implements ServletContextAware {
	private ServletContext application;

	@Autowired
	private IAdminLogMapper adminLogMapper;

	/**
	 * 拦截service包下面的下面的方法进行aop的环绕形通知<br/>
	 * com.jgz.core.aop <br/>
	 * 方法名：doBasicProfiling<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年6月24日-下午4:07:05 <br/>
	 * 
	 * @param point
	 * @return
	 * @throws Throwable
	 *             返回类型Object<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	// 方法拦截
	@Around("execution(* com.flat.srm.*.service.*.*.*(..))")
	// 环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint point) throws Throwable {
		String methodName = point.getSignature().getName();
		if (TmStringUtils.isNotEmpty(methodName) && methodName.equals("getLogin")) {
			return point.proceed();
		}
		// System.out.println("进了aop——LogInterceptor拦截器");
		// 执行该方法
		Object classObj = point.getTarget();// 拦截的类名
		long start = System.currentTimeMillis();
		Object object = point.proceed();// 执行目标方法
		long end = System.currentTimeMillis();
		long time = (end - start);
		Object[] params = point.getArgs();
		StringBuilder builder = new StringBuilder("");
		if (params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				builder.append(String.valueOf(params[i]));
				if (i < params.length - 1) {
					builder.append(",");
				}
			}
		}
		// 执行的类
		String className = classObj.getClass().getName();
		// 返回类型
		String returnType = null;
		if (object != null) {
			returnType = object.getClass().getName();
		}

		try {
			// 保存日记到数据库

			saveLog(className, methodName, time);
		} catch (Exception e) {
		}

		// System.out.println("【Tm】【Service AOP拦截】【Class：" + className +
		// "】【Method：" + methodName + "】【ReturnType："
		// + returnType + "】【Time：" + time + "ms】");
		return object;// 执行目标方法
	}

	/**
	 * 
	 * 保存日志方法<br/>
	 * com.jgz.core.aop <br/>
	 * 方法名：saveLog<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年6月24日-下午4:06:40 <br/>
	 * 
	 * @param className
	 * @param methodName
	 * @param time
	 *            返回类型void<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public void saveLog(String className, String methodName, long time) {
		AdminLog adminLog = new AdminLog();
		// 从servlat上下文中获取
		User user = (User) application.getAttribute(JgzConstant.USER_LOG);
		HttpServletRequest request = (HttpServletRequest) application.getAttribute(JgzConstant.REQUEST_LOG);
		// String ip = TmIpUtil.getIpAddress(request);
		adminLog.setClassname(className);
		adminLog.setMoethodname(methodName);
		adminLog.setTime(time);
		adminLog.setUserip(request == null ? "异常" : TmIpUtil.getIpAddress(request));
		adminLog.setUserid(user == null ? -1 : user.getId());
		adminLog.setUsername(user == null ? "异常" : user.getName());
		adminLog.setUseripLocation(request == null ? "异常" : TmIpUtil.ipLocation(request));
		adminLogMapper.save(adminLog);
		// System.err.println("日志保存=======>" + integer);
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;

	}
}
