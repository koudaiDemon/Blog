package com.softeem.dto;

import java.util.Date;
/**
 * π‹¿Ì‘±DTO
 * @author lx
 *
 */
public class Manager {
	
	private int id;
	private String username;
	private String password;
	private String phone;
	private Head headImg;
	private Date regTime;
	private Date lastLoadTime;
	private int loadCount;
	private String lastLoadIp;
	
	public Manager() {
	}

	public Manager(int id, String username, String password, String phone, Head headImg, Date regTime,Date lastLoadTime,int loadCount,String lastLoadIp) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.headImg = headImg;
		this.regTime = regTime;
		this.lastLoadTime = lastLoadTime;
		this.loadCount = loadCount;
		this.lastLoadIp = lastLoadIp;
	}

	
	public Date getLastLoadTime() {
		return lastLoadTime;
	}

	public void setLastLoadTime(Date lastLoadTime) {
		this.lastLoadTime = lastLoadTime;
	}

	public int getLoadCount() {
		return loadCount;
	}

	public void setLoadCount(int loadCount) {
		this.loadCount = loadCount;
	}

	public String getLastLoadIp() {
		return lastLoadIp;
	}

	public void setLastLoadIp(String lastLoadIp) {
		this.lastLoadIp = lastLoadIp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Head getHeadImg() {
		return headImg;
	}

	public void setHeadImg(Head headImg) {
		this.headImg = headImg;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	
}
