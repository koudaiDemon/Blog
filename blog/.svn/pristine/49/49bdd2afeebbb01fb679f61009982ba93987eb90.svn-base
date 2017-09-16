package com.softeem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.softeem.dao.ArticleDAO;
import com.softeem.dao.CommDAO;
import com.softeem.dao.LinkDAO;
import com.softeem.dao.ManagerDAO;
import com.softeem.dao.ReadDAO;
import com.softeem.dto.InformationBean;
import com.softeem.utils.GetCount;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetCount get = new GetCount();
		int acount = get.getCount(new ArticleDAO());
		int ccount = get.getCount(new CommDAO());
		int lcount = get.getCount(new LinkDAO());
		int rcount = get.getCount(new ReadDAO());
		int managerCount = get.getCount(new ManagerDAO());
		String browser = "FireFox9.0";
		String loadIp = request.getRemoteAddr();
		InformationBean bean = new InformationBean(acount, ccount, lcount, rcount, managerCount, browser, loadIp ,null);
		
		String json = JSON.toJSONString(bean);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
