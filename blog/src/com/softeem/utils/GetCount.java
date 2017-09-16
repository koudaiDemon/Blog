package com.softeem.utils;

import com.softeem.dao.BasePageDAO;
import com.softeem.dto.PageBean;

public class GetCount {
	
	public <T> int getCount(BasePageDAO<T> dao){
		return dao.getCount();
	}
	
}
