package com.flat.srm.common.security.bean;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

@SuppressWarnings("unused")
public class ShiroToken extends UsernamePasswordToken implements Serializable {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = -6115546542162212537L;
	// 角色
	private Long role;
	private String name; 
	private String password;
	private Boolean rememberMe;
	private String host;

	// 初始化父节点
	public ShiroToken(String name, String password) {
		super(name, password);
		this.name = name;
		this.password = password;
	}

	// 初始化父节点
	public ShiroToken(String name, String password, Boolean rememberMe,
			String host) {
		super(name, password, rememberMe, host);
		this.name = name;
		this.password = password;
		this.rememberMe = rememberMe;
		this.host = host;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
