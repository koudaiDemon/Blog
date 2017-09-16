package com.softeem.dao;

import java.util.List;

/**
 * dao基类
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDAO <T>{
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public boolean add(T t);
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public boolean delete(T t);
	
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public T findById(int id);
	
	/**
	 * 根据属性查找所有
	 * @param t
	 * @return
	 */
	public List<T> findByProperty(T t);
	
	/**
	 * 根据属性查找单个
	 * @param t
	 * @return
	 */
	public T findByProper(T t);
	
}
