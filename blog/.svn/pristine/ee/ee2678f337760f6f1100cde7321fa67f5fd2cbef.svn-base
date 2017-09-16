package com.softeem.dao;

import java.util.List;

import com.softeem.dto.PageBean;

/**
 * 分页的根基类
 * @author Administrator
 *
 * @param <T>
 */
public interface BasePageDAO<T>{
	
	/**
	 * 根据pagebean来获得分页集合
	 * @param bean
	 * @return
	 */
	public List<T> findByPage(PageBean<T> bean);
	
	
	/**
	 * 根据pagebean来获得分页集合可能会用到id
	 * @param bean
	 * @return
	 */
	public List<T> findByPageAndId(PageBean<T> bean,int id);
	
	/**
	 * 获取总数据数
	 * @return
	 */
	public int getCount();
	
	/**
	 * 获取总数据数根据外键
	 * @return
	 */
	public int getCountById(int id);
	
}
