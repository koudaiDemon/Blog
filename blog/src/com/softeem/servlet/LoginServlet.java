package com.softeem.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.BaseDAO;
import com.softeem.dao.LoginDAO;
import com.softeem.dao.ManagerDAO;
import com.softeem.dao.UserDAO;
import com.softeem.dto.Login;
import com.softeem.dto.Manager;
import com.softeem.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseDAO<Login> ldao = new LoginDAO();   
	private Login login = null;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
//		System.out.println(flag);
		switch(flag){
		case "manager":
			managerLoad(request,response);
			break;
		case "user":
			userLoad(request,response);
			break;
		default:
			break;
		}
		
	}

	private void userLoad(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet");
		String email = request.getParameter("email");
		System.out.println(email);
		String pass = request.getParameter("password");
		System.out.println(pass);
		User user = new User();
		user.setEmail(email);
		UserDAO dao = new UserDAO();
		
		user = dao.findByProper(user);
		if(user != null){
			if(pass.equals(user.getPassword())){
				user.setLastLoadTime(new Date());
				if(dao.updateTime(user)){
					System.out.println("登陆成功！");
					String uri = request.getRequestURI();
			    	//获取ip地址
			    	String remoteAddr = request.getRemoteAddr();
			    	login = new Login(0, remoteAddr, null, null, user, 1);
			    	ldao.add(login);
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("/front/lw-index.jsp").forward(request, response);
					return;
				}
			}else{
				request.setAttribute("msg", "密码错误");
			}
		}else{
			request.setAttribute("msg", "用户不存在！");
		}
		request.getRequestDispatcher("/front/lw-log.jsp").forward(request, response);
	}

	private void managerLoad(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("userpwd");
		Manager manager = new Manager();
		manager.setUsername(username);
		
		BaseDAO<Manager> dao = new ManagerDAO();
		
		manager = dao.findByProper(manager);
		//获取ip地址
		String remoteAddr = request.getRemoteAddr();
		if(manager != null){
			if(pass.equals(manager.getPassword())){
		    	login = new Login(0, remoteAddr, null, manager, null, 1);
		    	ldao.add(login);
		    	request.getSession().setAttribute("manager", manager);
		    	request.getRequestDispatcher("index.jsp").forward(request, response);
		    	manager.setLastLoadIp(remoteAddr);
		    	manager.setLastLoadTime(new Date());
		    	//更新记录
		    	dao.update(manager);
		    	return;
			}else{
				request.setAttribute("msg", "密码错误");
			}
		}else{
			request.setAttribute("msg", "用户不存在！");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
