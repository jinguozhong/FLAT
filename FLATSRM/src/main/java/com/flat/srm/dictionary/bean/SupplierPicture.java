package com.flat.srm.dictionary.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 供应商图片明细bean
 * classNmae SupplierPicture
 * package com.flat.srm.dictionary.bean
 * user jingu
 * date 2017/8/21
 * time 下午 2:49
*/

public class SupplierPicture implements Serializable {
	private static final long serialVersionUID = 1L;
	// id
	private Long id;
	// 修改人
	private String updateBy;
	// 新增人员
	private String newBy;
	// 新增时间
	private Date newTime;
	// 修改时间
	private Date updateTime;
	//供应商ID
	@NotNull(message = "供应商ID不能为null")
	private Long supplierId	;
	//供应商名称
	@NotEmpty(message="供应商名称不能为空")
	@Length(min = 2,max = 30,message = "供应商名称不能小于2个字符和大于30个字符长度")
	private String supplierName;
	//图片地址
	@NotEmpty(message="图片地址不能为空")
	@Length(min = 2,max = 100,message = "图片地址不能小于2个字符和大于30个字符长度")
	private String url;
	//图片名称
	@NotEmpty(message="图片名称不能为空")
	@Length(min = 2,max = 30,message = "图片名称不能小于2个字符和大于30个字符长度")
	private String name;
	//图片大小
	@NotEmpty(message="图图片大小不能为空")
	@Length(min = 2,max = 30,message = "图片大小不能小于2个字符和大于30个字符长度")
	private String size;

    public SupplierPicture(){
    		super();
    }

	public SupplierPicture(Long id, String updateBy, String newBy, Date newTime, Date updateTime, Long supplierId, String supplierName, String url, String name, String size) {
		this.id = id;
		this.updateBy = updateBy;
		this.newBy = newBy;
		this.newTime = newTime;
		this.updateTime = updateTime;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.url = url;
		this.name = name;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
