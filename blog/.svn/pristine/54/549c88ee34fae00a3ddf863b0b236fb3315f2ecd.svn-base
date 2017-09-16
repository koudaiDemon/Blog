package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.AnnouncementDAO;
import com.softeem.dao.ArticleDAO;
import com.softeem.dao.BaseDAO;
import com.softeem.dao.CategoryDAO;
import com.softeem.dao.CommDAO;
import com.softeem.dao.LinkDAO;
import com.softeem.dao.LoginDAO;
import com.softeem.dao.UserDAO;
import com.softeem.dto.Announcement;
import com.softeem.dto.Article;
import com.softeem.dto.Category;
import com.softeem.dto.Comm;
import com.softeem.dto.Link;
import com.softeem.dto.Login;
import com.softeem.dto.User;


@WebServlet("/doDelete")
public class DoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoDeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch(flag){
		case "category":
			deleteCategory(request,response);
			break;
		case "flink":
			deleteFlink(request,response);
			break;
		case "article":
			deleteArticle(request,response);
			break;
		case "user":
			deleteUser(request,response);
			break;
		case "notice":
			deleteNotice(request,response);
			break;
		case "loginLog":
			deletLoginLog(request,response);
			break;
		case "comm":
			deletComm(request,response);
			break;
		case "doVDelete":
			doVDelete(request,response);
			break;
		default:
			break;
		}
	}

	private void doVDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids=request.getParameterValues("checkbox[]");
		for (int i = 0; i < ids.length; i++) {
			int articleid = Integer.parseInt(ids[i]);
			Article a = new Article();
			a.setId(articleid);

			ArticleDAO dao = new ArticleDAO();
			if (dao.delete(a)) {
				request.setAttribute("success", "删除成功！");
				request.getSession().setAttribute("article", a);
			} else {
				request.setAttribute("error", "格式错误");
			}
		}
		request.getRequestDispatcher("article.jsp").forward(request, response);
		
	}


	private void deletComm(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Comm c = new Comm();
		c.setParentcommid(Integer.parseInt(id));
		//删除
		CommDAO dao = new CommDAO();
		if(dao.deleteByPid(c)){
			c.setId(Integer.parseInt(id));
			if(dao.delete(c)){
				System.out.println("评论删除成功!");
			}
		}
	}


	private void deletLoginLog(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Login l = new Login();
		l.setId(Integer.parseInt(id));
		//删除
		BaseDAO<Login> dao = new LoginDAO();
		if(dao.delete(l)){
			System.out.println("登陆记录删除成功!");
		}
	}


	private void deleteNotice(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Announcement a = new Announcement();
		a.setId(Integer.parseInt(id));
		//删除
		BaseDAO<Announcement> dao = new AnnouncementDAO();
		if(dao.delete(a)){
			System.out.println("链接删除成功!");
		}

	}


	private void deleteArticle(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = new Article();
		article.setId(id);
		//删除
		BaseDAO<Article> dao = new ArticleDAO();
		if(dao.delete(article)){
			System.out.println("链接删除成功!");
		}
		
	}


	/**
	 * 删除用户时需要将用户的文章同时致为空
	 * @param request
	 * @param response
	 */
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Article a = new Article();
		a.setUid(id);
		ArticleDAO dao = new ArticleDAO();
		if(dao.updateByUid(a)){
			User u = new User();
			u.setId(id);
			BaseDAO<User> udao = new UserDAO();
			if(udao.delete(u)){
				System.out.println("删除成功");
			}
		}else{
			System.out.println("设置为空有问题");
		}
		
	}


	private void deleteFlink(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Link link = new Link();
		link.setId(Integer.parseInt(id));
		//删除
		BaseDAO<Link> dao = new LinkDAO();
		if(dao.delete(link)){
			System.out.println("链接删除成功!");
		}
	}


	private void deleteCategory(HttpServletRequest request,
			HttpServletResponse response) {
		//获取id
		String id = request.getParameter("id");
		Category c = new Category();
		c.setPid(Integer.parseInt(id));
		//删除子类别
		CategoryDAO dao = new CategoryDAO();
		if(dao.deleteByPid(c)){
			c.setId(Integer.parseInt(id));
			//删除父类别
			if(dao.delete(c)){
				System.out.println("删除成功！");
			}
		}
	}

}
