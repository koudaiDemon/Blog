package com.softeem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
		filterName="LoginFilter",
		urlPatterns={"*.jsp"},
		initParams={@WebInitParam(name = "pass", value = "login.jsp")}
		)
public class LoginFilter implements Filter {

	String[] pages;

    public LoginFilter() {
    	
    }


	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest)request;
    	HttpServletResponse reps = (HttpServletResponse)response;
    	//1.获取客户端请求的资源名称
    	String uri = req.getRequestURI();
    	uri = uri.substring(uri.lastIndexOf("/")+1);
    	//2.判断请求资源是否放行之列
    	boolean isPass = false;//假设当前请求不允许放行(标记)
    	for(String page : pages){
    		if(page.equals(uri)||uri.startsWith("lw-")){
    			isPass = true;
    			break;
    		}
    	}
    	if(isPass){
    		chain.doFilter(request, response);
    	}else{
    		//获取session中的数据 
    		Object obj = req.getSession().getAttribute("manager");
    		//3.如果不在放行之列，检查session中有没有用户信息
    		if(obj != null){
    			chain.doFilter(request, response);
    		}else{
    			request.setAttribute("msg", "请登陆后再试!");
    			request.getRequestDispatcher("login.jsp").forward(req, reps);
    		}
    		//4.有则放行,无则拦截
    	}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化");
    	pages = fConfig.getInitParameter("pass").split(",");
	}

}
