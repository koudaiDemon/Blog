package com.softeem.service;

import java.util.List;

import com.softeem.dao.BasePageDAO;
import com.softeem.dao.LoginDAO;
import com.softeem.dto.Manager;
import com.softeem.dto.PageBean;

/**
 * 专注处理分页业务逻辑(所有的表)
 * @author Administrator
 *
 */
public class PaginationService<T> {

	private BasePageDAO<T> dao;//面向接口编程
	
	public PaginationService(BasePageDAO<T> dao) {
		super();
		this.dao = dao;
	}

	public PageBean<T> paging(PageBean<T> bean){
		
		//获取总记录数
		int totalNum = dao.getCount();
		//计算获取总页数
		int totalPage = totalNum%bean.getPageSize() == 0 ? totalNum/bean.getPageSize():totalNum/bean.getPageSize()+1;
		//防止无线上一页
		if(bean.getCurrentPage() < 1){
			bean.setCurrentPage(1);
		}
		//防止无线下一页
		if(bean.getCurrentPage() > totalPage){
			bean.setCurrentPage(totalPage);
		}
		//设置总记录数
		bean.setTotalNum(totalNum);
		//设置总页数
		bean.setTotalPage(totalPage);
		//设置上一页，下一页，尾页
		bean.setPre(bean.getCurrentPage()-1);
		bean.setNext(bean.getCurrentPage()+1);
		bean.setLast(totalNum);
		//查询指定页数据
		List<T> list = dao.findByPage(bean);
		//将数据存入分页的javabean中
		bean.setList(list);
		return bean;
	}
	
	public PageBean<T> pagingById(PageBean<T> bean,int id){
		//获取总记录数
		int totalNum = dao.getCountById(id);
		//计算获取总页数
		int totalPage = totalNum%bean.getPageSize() == 0 ? totalNum/bean.getPageSize():totalNum/bean.getPageSize()+1;
		//防止无线上一页
		if(bean.getCurrentPage() < 1){
			bean.setCurrentPage(1);
		}
		//防止无线下一页
		if(bean.getCurrentPage() > totalPage){
			bean.setCurrentPage(totalPage);
		}
		//设置总记录数
		bean.setTotalNum(totalNum);
		//设置总页数
		bean.setTotalPage(totalPage);
		//设置上一页，下一页，尾页
		bean.setPre(bean.getCurrentPage()-1);
		bean.setNext(bean.getCurrentPage()+1);
		bean.setLast(totalNum);
		//查询指定页数据
		List<T> list = dao.findByPageAndId(bean, id);
		//将数据存入分页的javabean中
		bean.setList(list);
		return bean;
	}
	
}
