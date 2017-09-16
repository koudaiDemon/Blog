package com.softeem.dto;

import java.util.Date;
/**
 * µÇÂ¼¼ÇÂ¼DTO
 * @author lx
 *
 */
public class Login {

	private int id;
	private String loadIp;
	private Date loadTime;
	private Manager manager;
	private User user;
	private int isSuccess;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(int id, String loadIp, Date loadTime, Manager manager, User user, int isSuccess) {
		super();
		this.id = id;
		this.loadIp = loadIp;
		this.loadTime = loadTime;
		this.manager = manager;
		this.user = user;
		this.isSuccess = isSuccess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoadIp() {
		return loadIp;
	}

	public void setLoadIp(String loadIp) {
		this.loadIp = loadIp;
	}

	public Date getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(Date loadTime) {
		this.loadTime = loadTime;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	
}
