package com.softeem.dao;

import java.util.List;

import com.softeem.dto.PageBean;

/**
 * ��ҳ�ĸ�����
 * @author Administrator
 *
 * @param <T>
 */
public interface BasePageDAO<T>{
	
	/**
	 * ����pagebean����÷�ҳ����
	 * @param bean
	 * @return
	 */
	public List<T> findByPage(PageBean<T> bean);
	
	
	/**
	 * ����pagebean����÷�ҳ���Ͽ��ܻ��õ�id
	 * @param bean
	 * @return
	 */
	public List<T> findByPageAndId(PageBean<T> bean,int id);
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public int getCount();
	
	/**
	 * ��ȡ���������������
	 * @return
	 */
	public int getCountById(int id);
	
}
