package com.flat.srm.system.bean;

import java.io.Serializable;
import java.util.Date;

public class AdminLog implements Serializable {

	private static final long serialVersionUID = 1L;
	// 主键
	private Long id;
	// 新增时间
	private Date newtime;
	// 修改时间
	private Date udatettime;
	// 类名
	private String classname;
	// 方法名
	private String moethodname;
	// 毫秒时间
	private long time;
	// 用户id
	private Long userid;
	// 用户ip
	private String userip;
	// 用户ip地址
	private String useripLocation;
	// 用户名
	private String username;

	public AdminLog() {
		super();
	}

	public AdminLog(Long id, Date newtime, Date udatettime, String classname,
			String moethodname, long time, Long userid, String userip,
			String useripLocation, String username) {
		super();
		this.id = id;
		this.newtime = newtime;
		this.udatettime = udatettime;
		this.classname = classname;
		this.moethodname = moethodname;
		this.time = time;
		this.userid = userid;
		this.userip = userip;
		this.useripLocation = useripLocation;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getNewtime() {
		return newtime;
	}

	public void setNewtime(Date newtime) {
		this.newtime = newtime;
	}

	public Date getUdatettime() {
		return udatettime;
	}

	public void setUdatettime(Date udatettime) {
		this.udatettime = udatettime;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getMoethodname() {
		return moethodname;
	}

	public void setMoethodname(String moethodname) {
		this.moethodname = moethodname;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getUseripLocation() {
		return useripLocation;
	}

	public void setUseripLocation(String useripLocation) {
		this.useripLocation = useripLocation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
