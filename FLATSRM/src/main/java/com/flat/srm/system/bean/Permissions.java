package com.flat.srm.system.bean;

import java.io.Serializable;
import java.util.Date;

public class Permissions implements Serializable {

	private static final long serialVersionUID = 1L;
	// 主键
	private Long id;
	// 名称
	private String name;
	// 上级节点
	private Long pId;
	// 状态2是启用1是停用
	private Integer state;
	// 代码
	private String code;
	// 是否汇总节点
	private String isParent;
	// 新增时间
	private Date newTime;
	// 修改时间
	private Date updateTime;
	// 修改人员
	private String updateBy;
	// 新增人员
	private String newBy;

	// 父节点名称
	private String pname;
	// 父节点code
	private String pcode;

	public Permissions() {
		super();
	}
	
	public Permissions(Long id, String name, Long pId, Integer state, String code, String isParent, Date newTime,
			Date updateTime, String updateBy, String newBy, String pname, String pcode) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.state = state;
		this.code = code;
		this.isParent = isParent;
		this.newTime = newTime;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
		this.newBy = newBy;
		this.pname = pname;
		this.pcode = pcode;
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

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
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


}
