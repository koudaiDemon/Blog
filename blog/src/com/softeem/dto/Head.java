package com.softeem.dto;

/**
 * Í·ÏñÍ¼±êDTO
 * 
 * @author Administrator
 *
 */
public class Head {

	private int id;
	private String path;

	public Head() {
	}

	public Head(int id, String path) {
		super();
		this.id = id;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
