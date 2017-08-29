package com.flat.srm.system.bean;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * 
	 * @since 1.0.0
	 */

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
	// 创建时间
	private Date newTime;
	// 修改时间
	private Date updateTime;
	// 生日
	private Date shengri;
	// 是否汇总节点
	private String isParent;
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

	public Role() {

		super();
	}

	public Role(Long id, String name, Long pId, Integer state, String code,
			Date newTime, Date updateTime, Date shengri, String isParent,
			String pname, String pcode, String fIsParent, String updateBy,
			String newBy) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.state = state;
		this.code = code;
		this.newTime = newTime;
		this.updateTime = updateTime;
		this.shengri = shengri;
		this.isParent = isParent;
		this.pname = pname;
		this.pcode = pcode;
		this.fIsParent = fIsParent;
		this.updateBy = updateBy;
		this.newBy = newBy;
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

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
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

}
