/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.dao
 * TzParams.java
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午12:42:33 
 * 2015潭州教育公司-版权所有
 */
package com.flat.srm.common.publicBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * TzParams 创建人:xuchengfei 时间：2015年11月24日-上午12:42:33
 * 
 * @version 1.0.0
 * 
 */
public class TzParams implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String code;
	private String account;
	private String password;
	// 分页属性
	private Integer pageNo;
	// 分页属性
	private Integer pageSize;
	// 分页属性 jqgrid 统一使用rows为显示的行数
	private Integer rows;
	// 分页属性jqgrid 统一使用page为显示的页数
	private Integer page;

	private Integer pId;
	private String isParent;
	private List<Map<String, Object>> listMaps;
	private Integer uId;
	private Integer rId;
	private Integer rigId;
	private String role;
	private String target;
	private String mail;
	private List<String> listString;
	private Integer state;
	private String date;

	public TzParams() {
		super();
	}

	public TzParams(Long id, String name, String code, String account,
			String password, Integer pageNo, Integer pageSize, Integer pId,
			String isParent, List<Map<String, Object>> listMaps, Integer uId,
			Integer rId, Integer rigId, String role, String target, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.account = account;
		this.password = password;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pId = pId;
		this.isParent = isParent;
		this.listMaps = listMaps;
		this.uId = uId;
		this.rId = rId;
		this.rigId = rigId;
		this.role = role;
		this.target = target;
		this.mail = mail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getListString() {
		return listString;
	}

	public void setListString(List<String> listString) {
		this.listString = listString;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public List<Map<String, Object>> getListMaps() {
		return listMaps;
	}

	public void setListMaps(List<Map<String, Object>> listMaps) {
		this.listMaps = listMaps;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getRigId() {
		return rigId;
	}

	public void setRigId(Integer rigId) {
		this.rigId = rigId;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
