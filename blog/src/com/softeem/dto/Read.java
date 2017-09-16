package com.softeem.dto;

import java.util.Date;

/**
 * ÔÄ¶Á¼ÇÂ¼ÀàDTO
 * @author lx
 *
 */
public class Read {

	private int id;
	private int aid;
	private String ip;
	private int uid;
	private Date readTime;
	
	public Read() {
		// TODO Auto-generated constructor stub
	}

	public Read(int id, int aid, String ip, int uid, Date readTime) {
		super();
		this.id = id;
		this.aid = aid;
		this.ip = ip;
		this.uid = uid;
		this.readTime = readTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	
	
	
}
