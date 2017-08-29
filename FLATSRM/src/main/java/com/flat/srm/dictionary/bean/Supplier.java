package com.flat.srm.dictionary.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 供应商基本信息实例
 * 
 * Supplier<br/>
 * 创建人:JGZ<br/>
 * 时间：2017年7月21日-下午2:09:51 <br/>
 * 
 * @version 1.0.0<br/>
 *
 */

public class Supplier implements Serializable { 
	private static final long serialVersionUID = 1L;
	// id
	private Long id;
	// code
	private String code;
	// 上级节点ID
	private Long pId;
	// 状态
	private Integer state;
	// 修改人
	private String updateBy;
	// 新增人员
	private String newBy;
	// 是否汇总
	private String isParent;
	// 新增时间
	private Date newTime;
	// 修改时间
	private Date updateTime;
	// 企业类型:1 生产厂商,2 贸易商,3 物流商
	@NotEmpty(message="企业类型不能为空")
	@Length(min = 2,max = 30,message = "企业类型不能小于2个字符和大于30个字符长度")
	private String type;
	// 公司名称
	@NotEmpty(message="公司名称不能为空")
	@Length(min = 2,max = 30,message = "公司名称不能小于2个字符和大于30个字符长度")
	private String company;
	// 企业性质
	@NotEmpty(message="企业性质不能为空")
	@Length(min = 2,max = 30,message = "企业性质不能小于2个字符和大于30个字符长度")
	private String nature;
	// 所属行业
	@NotEmpty(message="所属行业不能为空")
	@Length(min = 2,max = 30,message = "所属行业不能小于2个字符和大于30个字符长度")
	private String industry;
	// 开户银行
	@NotEmpty(message="开户银行不能为空")
	@Length(min = 2,max = 30,message = "开户银行不能小于2个字符和大于30个字符长度")
	private String bank;
	// 银行账号
	@NotEmpty(message="银行账号不能为空")
	@Length(min = 2,max = 30,message = "银行账号不能小于2个字符和大于30个字符长度")
	private String bankAccount;
	// 法人
	@NotEmpty(message="法人不能为空")
	@Length(min = 2,max = 10,message = "法人不能小于2个字符和大于30个字符长度")
	private String legalPerson;
	// 法人联系电话
	@NotEmpty(message="法人联系电话不能为空")
	@Length(min = 2,max = 30,message = "法人联系电话不能小于2个字符和大于30个字符长度")
	private String legalPersonPhone;
	// 国家
	@NotEmpty(message="国家不能为空")
	@Length(min = 2,max = 30,message = "国家不能小于2个字符和大于30个字符长度")
	private String countries;
	// 省
	@NotEmpty(message="省不能为空")
	@Length(min = 2,max = 30,message = "省不能小于2个字符和大于30个字符长度")
	private String province;
	// 地址
	@NotEmpty(message="地址不能为空")
	@Length(min = 2,max = 40,message = "地址不能小于2个字符和大于40个字符长度")
	private String address;
	// 邮箱
	@NotEmpty(message="邮箱不能为空")
	@Email
	private String mail;
	// 用户名称
	@NotEmpty(message="用户名称不能为空")
	@Length(min = 2,max = 40,message = "用户名称不能小于2个字符和大于40个字符长度")
	private String userName;
	// 部门
	@NotEmpty(message="部门不能为空")
	@Length(min = 2,max = 30,message = "部门不能小于2个字符和大于30个字符长度")
	private String department;
	// 职务
	@NotEmpty(message="职务不能为空")
	@Length(min = 2,max = 30,message = "职务不能小于2个字符和大于30个字符长度")
	private String position;
	// 联系电话
	@NotEmpty(message="联系电话不能为空")
	@Length(min = 2,max = 30,message = "联系电话不能小于2个字符和大于30个字符长度")
	private String phone;
	// 生产执行情况
	@NotEmpty(message="生产执行情况不能为空")
	@Length(min = 2,max = 255,message = "生产执行情况不能小于2个字符和大于255个字符长度")
	private String production;
	// 质量保证
	@NotEmpty(message="质量保证不能为空")
	@Length(min = 2,max = 255,message = "质量保证不能小于2个字符和大于255个字符长度")
	private String quality;
	
	public Supplier(){
		super();
	}
	
	public Supplier(Long id, String code, Long pId, Integer state, String updateBy, String newBy, String isParent,
			Date newTime, Date updateTime, String type, String company, String nature, String industry, String bank,
			String bankAccount, String legalPerson, String legalPersonPhone, String countries, String province,
			String address, String mail, String userName, String department, String position, String phone,
			String production, String quality) {
		super();
		this.id = id;
		this.code = code;
		this.pId = pId;
		this.state = state;
		this.updateBy = updateBy;
		this.newBy = newBy;
		this.isParent = isParent;
		this.newTime = newTime;
		this.updateTime = updateTime;
		this.type = type;
		this.company = company;
		this.nature = nature;
		this.industry = industry;
		this.bank = bank;
		this.bankAccount = bankAccount;
		this.legalPerson = legalPerson;
		this.legalPersonPhone = legalPersonPhone;
		this.countries = countries;
		this.province = province;
		this.address = address;
		this.mail = mail;
		this.userName = userName;
		this.department = department;
		this.position = position;
		this.phone = phone;
		this.production = production;
		this.quality = quality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}


	
}
