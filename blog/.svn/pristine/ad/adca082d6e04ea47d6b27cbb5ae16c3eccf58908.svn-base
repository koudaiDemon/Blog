package com.softeem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.AnnouncementDAO;
import com.softeem.dao.BaseDAO;
import com.softeem.dao.CommDAO;
import com.softeem.dao.LinkDAO;
import com.softeem.dao.LoginDAO;
import com.softeem.dto.Announcement;
import com.softeem.dto.Comm;
import com.softeem.dto.Link;
import com.softeem.dto.Login;
import com.softeem.dto.Manager;


@WebServlet("/doAllDelete")
public class DoAllDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DoAllDeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch(flag){
		case "notice":
			deleteAllNotice(request,response);
			break;
		case "deleteAll":
			deleteDeleteAll(request,response);
			break;
		case "currentLogin":
			deleteCurrentLogin(request,response);
			break;
		case "flink":
			deleteFlink(request,response);
			break;
		case "comm":
			deleteComm(request,response);
			break;
		default:
			break;
			
		}
	}
	
	private void deleteComm(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String info = request.getParameter("data");
		String[] datas = info.split(",");
		CommDAO dao = new CommDAO();
		Comm c = new Comm();
		boolean flag = true;
		for(String s:datas){
			c.setParentcommid(Integer.parseInt(s));
			if(dao.deleteByPid(c)){
				c.setId(Integer.parseInt(s));
				if(dao.delete(c)){
					System.out.println("评论删除成功!");
				}else{
					flag=false;
				}
			}else{
				flag= false;
			}
		}
		PrintWriter out = response.getWriter();
		if(flag){
			out.print("成功");
		}else{
			out.print("失败");
		}
		
	}


	private void deleteFlink(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String info = request.getParameter("data");
		String[] datas = info.split(",");
		BaseDAO<Link> dao = new LinkDAO();
		Link l = new Link();
		boolean flag = true;
		for(String s:datas){
			int id = Integer.parseInt(s);
			l.setId(id);
			if(dao.delete(l)){
				flag = false;
				break;
			}
		}
		PrintWriter out = response.getWriter();
		if(flag){
			out.print("成功");
		}else{
			out.print("失败");
		}
	}


	private void deleteCurrentLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LoginDAO dao = new LoginDAO();
		Login login = new Login();
		int mid = Integer.parseInt(request.getParameter("mid"));
		Manager m = new Manager();
		m.setId(mid);
		login.setManager(m);
		PrintWriter out = response.getWriter();
		if(dao.deleteAllByMid(login)){
			out.print("<script>alert('成功');location.href='loginlog.jsp';</script>");
		}else{
			out.print("<script>alert('失败');location.href='loginlog.jsp';</script>");
		}
	}


	private void deleteDeleteAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LoginDAO dao = new LoginDAO();
		PrintWriter out = response.getWriter();
		if(dao.deleteAll()){
			out.print("<script>alert('成功');location.href='loginlog.jsp';</script>");
		}else{
			out.print("<script>alert('失败');location.href='loginlog.jsp';</script>");
		}
	}


	/**
	 * 多选删除（实现，但是已经有了数据，前端也做了相应的处理）
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void deleteAllNotice(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String info = request.getParameter("data");
		String[] datas = info.split(",");
		BaseDAO<Announcement> dao = new AnnouncementDAO();
		Announcement a = new Announcement();
		boolean flag = true;
		for(String s:datas){
			int id = Integer.parseInt(s);
			a.setId(id);
			if(dao.delete(a)){
				flag = false;
				break;
			}
		}
		PrintWriter out = response.getWriter();
		if(flag){
			out.print("成功");
		}else{
			out.print("失败");
		}
	}

}
