package com.softeem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.softeem.dao.AnnouncementDAO;
import com.softeem.dao.ArticleDAO;
import com.softeem.dao.BaseDAO;
import com.softeem.dao.CategoryDAO;
import com.softeem.dao.LinkDAO;
import com.softeem.dao.UserDAO;
import com.softeem.dto.Announcement;
import com.softeem.dto.Article;
import com.softeem.dto.Category;
import com.softeem.dto.Head;
import com.softeem.dto.Link;
import com.softeem.dto.User;
import com.softeem.jspsmart.upload.Request;
import com.softeem.jspsmart.upload.SmartUpload;
import com.softeem.jspsmart.upload.SmartUploadException;


@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DoAddServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch(flag){
		case "category":
			addCategory(request,response);
			break;
		case "article":
			addArticle(request,response);
			break;
		case "flink":
			addLink(request,response);
			break;
		case "user":
			addUser(request,response);
			break;
		case "notice":
			addNotice(request,response);
			break;
		default:
			break;
		}
	}



	private void addNotice(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String mid = request.getParameter("mid");
		SmartUpload su = new SmartUpload();
		Request req = null;
		try {
			su.initialize(this, request, response);
			su.upload();
			req = su.getRequest();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
//		System.out.println(request.getParameter("hid"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String imgSrc = req.getParameter("imgSrc");
		//描述也没有使用
		String describe = req.getParameter("describe");
		//获取是否公开（默认公开，）
		String visibility = req.getParameter("visibility");
		Announcement a = new Announcement(0, title, content, imgSrc, new Date(), Integer.parseInt(mid));
		BaseDAO<Announcement> dao = new AnnouncementDAO();
		PrintWriter out = response.getWriter();
		if(dao.add(a)){
			out.print("<script>alert('添加成功');location.href='notice.jsp';</script>");
		}else{
			out.print("<script>alert('添加失败');location.href='notice.jsp';</script>");
		}
	}


	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		SmartUpload su = new SmartUpload();
		Request req = null;
		try {
			su.initialize(this, request, response);
			su.upload();
			req = su.getRequest();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
//		System.out.println(request.getParameter("hid"));
		int hid = Integer.parseInt(req.getParameter("hid"));
		String username = req.getParameter("username");
		String nickName = req.getParameter("nickName");
		String email = req.getParameter("email");
		String desciption = req.getParameter("deciption");
		String password = req.getParameter("password");
		String repPassword = req.getParameter("new_password");
		System.out.println(username+"--"+nickName+"--"+email+"--"+desciption+"--"+password);
		Head h = new Head();
		h.setId(hid);
		if(password.equals(repPassword)){
			User user = new User(0, username, password, nickName, desciption, email, null, null, h, 0);
			BaseDAO<User> dao = new UserDAO();
			PrintWriter out = response.getWriter();
			if(dao.add(user)){
				out.print("<script>alert('添加成功');location.href='manage-user.jsp';</script>");
			}else{
				out.print("<script>alert('添加失败');location.href='manage-user.jsp';</script>");
			}
		}else{
			response.sendRedirect("manage-user.jsp");
		}
		
	}


	private void addLink(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String imgSrc = request.getParameter("imgurl");
		String information = request.getParameter("describe");
		String target = request.getParameter("target");
		String rel = request.getParameter("rel");
		
		Link link = new Link(0, name, url, imgSrc, information, Integer.parseInt(target), Integer.parseInt(rel),null,null);
		BaseDAO<Link> dao = new LinkDAO();
		PrintWriter out = response.getWriter();
		if(dao.add(link)){
			out.println("<script>alert('添加成功');location.href='flink.jsp'</script>");
			System.out.println("添加成功");
		}else{
			out.println("<script>alert('添加失败');location.href='flink.jsp'</script>");
			System.out.println("添加失败");
		}
		out.flush();
		
	}


	private void addArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String describe = request.getParameter("describe");
		String categoryId = request.getParameter("category");
		String titlepic = request.getParameter("titlepic");
		int uid = Integer.parseInt(request.getParameter("uid"));
		int isHide = Integer.parseInt(request.getParameter("visibility"));
		Category c = new Category();
		c.setId(Integer.parseInt(categoryId));
		Article article = new Article(0,title,content,c,null,new Date(),uid,0,0,titlepic,isHide,describe);
		BaseDAO<Article> dao = new ArticleDAO();
		PrintWriter out = response.getWriter();
		if(dao.add(article)){
			out.println("<script>alert('添加成功');location.href='article.jsp'</script>");
			System.out.println("添加成功");
		}else{
			out.println("<script>alert('添加失败');location.href='article.jsp'</script>");
			System.out.println("添加失败");
		}
		out.flush();
		
	}


	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//获取名字
		String name = request.getParameter("name");
		//获取别名
		String vname = request.getParameter("alias");
		//获取父节点
		String fid = request.getParameter("fid");
		//获取关键字
		String keywords = request.getParameter("keywords");
		//获取描述
		String describe = request.getParameter("describe");
		Category category = new Category(0,name,vname,describe,Integer.parseInt(fid),0,keywords);
		BaseDAO<Category> dao = new CategoryDAO();
		PrintWriter out = response.getWriter();
		if(dao.add(category)){
			out.println("<script>alert('添加成功');location.href='category.jsp'</script>");
			System.out.println("添加成功");
		}else{
			out.println("<script>alert('添加失败');location.href='category.jsp'</script>");
			System.out.println("添加失败");
		}
		out.flush();
	}

}
