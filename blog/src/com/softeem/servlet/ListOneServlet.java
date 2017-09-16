package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.softeem.dao.AnnouncementDAO;
import com.softeem.dao.ArticleDAO;
import com.softeem.dao.BaseDAO;
import com.softeem.dao.CategoryDAO;
import com.softeem.dao.LinkDAO;
import com.softeem.dto.Announcement;
import com.softeem.dto.Article;
import com.softeem.dto.Category;
import com.softeem.dto.Link;

/**
 * 用于数据代入
 * @author Administrator
 *
 */
@WebServlet("/listOne")
public class ListOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListOneServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch(flag){
		case "categorytype":
			listCategoryType(request,response);
			break;
		case "flink":
			listFlinks(request,response);
			break;
		case "notice":
			listNotice(request,response);
			break;
		case "article":
			listArticle(request,response);
			break;
		default:
			break;
		}
	}
	
	
	private void listArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BaseDAO<Article> dao = new ArticleDAO();
		Article at = dao.findById(Integer.parseInt(id));
		
		request.setAttribute("article", at);
		request.getRequestDispatcher("update-article.jsp").forward(request, response);
	}


	private void listNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BaseDAO<Announcement> dao = new AnnouncementDAO();
		Announcement a = dao.findById(Integer.parseInt(id));
		
//		String json = JSON.toJSONString(a);
		request.setAttribute("notice", a);
		request.getRequestDispatcher("update-notice.jsp").forward(request, response);
	}


	private void listFlinks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BaseDAO<Link> dao = new LinkDAO();
		Link c = dao.findById(Integer.parseInt(id));
		
//		String json = JSON.toJSONString(c);
		request.setAttribute("link", c);
		request.getRequestDispatcher("update-flink.jsp").forward(request, response);
	
	}


	/**
	 * 数据跳转代入
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listCategoryType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BaseDAO<Category> dao = new CategoryDAO();
		Category c = dao.findById(Integer.parseInt(id));
		
//		String json = JSON.toJSONString(c);
		request.setAttribute("category", c);
		request.getRequestDispatcher("update-category.jsp").forward(request, response);
	}
	
}
