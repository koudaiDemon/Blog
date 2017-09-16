package com.softeem.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化信息类
 * @author Administrator
 *
 */
public class InformationBean {
	
	private int aticleCount;
	private int commCount;
	private int flinkCount;
	private int readCount;
	private int managerCount;
	
	private String browser;
	private String loadIp;
	
	private List<Login> list = new ArrayList<>();
	
	public InformationBean() {
		
	}

	public InformationBean(int aticleCount, int commCount, int flinkCount,
			int readCount, int managerCount, String browser, String loadIp ,List<Login> list) {
		super();
		this.aticleCount = aticleCount;
		this.commCount = commCount;
		this.flinkCount = flinkCount;
		this.readCount = readCount;
		this.managerCount = managerCount;
		this.browser = browser;
		this.loadIp = loadIp;
		this.list = list;
	}

	public List<Login> getList() {
		return list;
	}

	public void setList(List<Login> list) {
		this.list = list;
	}

	public int getAticleCount() {
		return aticleCount;
	}

	public void setAticleCount(int aticleCount) {
		this.aticleCount = aticleCount;
	}

	public int getCommCount() {
		return commCount;
	}

	public void setCommCount(int commCount) {
		this.commCount = commCount;
	}

	public int getFlinkCount() {
		return flinkCount;
	}

	public void setFlinkCount(int flinkCount) {
		this.flinkCount = flinkCount;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getManagerCount() {
		return managerCount;
	}

	public void setManagerCount(int managerCount) {
		this.managerCount = managerCount;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getLoadIp() {
		return loadIp;
	}

	public void setLoadIp(String loadIp) {
		this.loadIp = loadIp;
	}
	
}
