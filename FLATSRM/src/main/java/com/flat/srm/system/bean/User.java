/**
 * Project Name:tzupload
 * File Name:User.java
 * Package Name:bean
 * Date:2015年11月6日下午9:04:29
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.flat.srm.system.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户类
 * 
 * User<br/>
 * 创建人:JGZ<br/>
 * 时间：2017年6月15日-下午4:09:52 <br/>
 * @version 1.0.0<br/>
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// 主键
	private Long id;
	// 用户名
	private String name;
	// 邮箱
	private String mail;
	// 密码
	private String password;
	// 新增时间
	private Date newTime;
	// 修改时间
	private Date updateTime;
	// 生日
	private Date shengri;
	// 父节点
	private Long pId;
	// 是否汇总节点
	private String isParent;
	// 代码
	private String code;
	// 状态2启用，1未启用
	private Integer state;
	// 父节点名称
	private String pname;
	// 父节点code
	private String pcode;
	// 父节点是否汇总节点
	private String fIsParent;
	// 修改人员
	private String updateBy;
	// 新增人员
	private String newBy;
	// 角色ID
	private Long roleId;
	// 公司id
	private Long companyId;
	// 公司
	private String company;
	// 部门
	private Integer department;
	// 备注
	private String note;
	public User(Long id, String name, String mail, String password, Date newTime, Date updateTime, Date shengri,
			Long pId, String isParent, String code, Integer state, String pname, String pcode, String fIsParent,
			String updateBy, String newBy, Long roleId, Long companyId, String company, Integer department,
			String note) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.newTime = newTime;
		this.updateTime = updateTime;
		this.shengri = shengri;
		this.pId = pId;
		this.isParent = isParent;
		this.code = code;
		this.state = state;
		this.pname = pname;
		this.pcode = pcode;
		this.fIsParent = fIsParent;
		this.updateBy = updateBy;
		this.newBy = newBy;
		this.roleId = roleId;
		this.companyId = companyId;
		this.company = company;
		this.department = department;
		this.note = note;
	}
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getNewTime() {
		return newTime;
	}
	public void setNewTime(Date newTime) {
		this.newTime = newTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getShengri() {
		return shengri;
	}
	public void setShengri(Date shengri) {
		this.shengri = shengri;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getfIsParent() {
		return fIsParent;
	}
	public void setfIsParent(String fIsParent) {
		this.fIsParent = fIsParent;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getNewBy() {
		return newBy;
	}
	public void setNewBy(String newBy) {
		this.newBy = newBy;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
