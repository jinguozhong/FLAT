package com.flat.srm.common.core.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ThrowingInterceptor {

	/**
	 * 
	 * 异常通知<br/>
	 * com.jgz.core.aop <br/>
	 * 方法名：getAfterThrowing<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月24日-下午12:41:02 <br/>
	 * 
	 * @param joinPoint
	 * @param e
	 *            返回类型void<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@AfterThrowing(value = "execution(* com.flat.srm.*.service.*.*.*(..))", throwing = "e")
	public void getAfterThrowing(JoinPoint joinPoint, Exception e) {
		Logger logger = Logger.getLogger(ThrowingInterceptor.class);
		// String methodName = joinPoint.getSignature().getName();
		// 执行该方法
		String className = joinPoint.getTarget().getClass().getName();// 拦截的类名
		logger.error("【Tm】【Service AOP异常拦截】【Class：" + className + "】", e);
	}

}
