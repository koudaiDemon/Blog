package com.softeem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/exception", "/ExceptionServlet" })
public class ExceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ExceptionServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("出现异常，请各个项目组仔细检查");
		PrintWriter out = response.getWriter();
		request.getSession().removeAttribute("manager");
		out.print("<script>alert('页面出错，返回首页');location.href='login.jsp';</script>");
		out.flush();
	}

}
