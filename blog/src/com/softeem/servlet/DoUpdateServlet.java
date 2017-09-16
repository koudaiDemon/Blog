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
import com.softeem.dao.ManagerDAO;
import com.softeem.dao.UserDAO;
import com.softeem.dto.Announcement;
import com.softeem.dto.Article;
import com.softeem.dto.Category;
import com.softeem.dto.Link;
import com.softeem.dto.Manager;
import com.softeem.dto.User;
import com.softeem.jspsmart.upload.Request;
import com.softeem.jspsmart.upload.SmartUpload;
import com.softeem.jspsmart.upload.SmartUploadException;


@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoUpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch(flag){
		case "manager":
			updateManager(request,response);
			break;
		case "category":
			updateCategory(request,response);
			break;
		case "flink":
			updateFlink(request,response);
			break;
		case "article":
			updateArticle(request,response);
			break;
		case "user":
			updateUser(request,response);
			break;
		case "notice":
			updateNotice(request,response);
			break;
		default:
			break;
		}
	}


	private void updateNotice(HttpServletRequest request,
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
		int id = Integer.parseInt(req.getParameter("noticeId"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String imgSrc = req.getParameter("imgSrc");
		//描述也没有使用
		String describe = req.getParameter("describe");
		//获取是否公开（默认公开，）
		String visibility = req.getParameter("visibility");
		Announcement a = new Announcement(id, title, content, imgSrc, new Date(), Integer.parseInt(mid));
		BaseDAO<Announcement> dao = new AnnouncementDAO();
		PrintWriter out = response.getWriter();
		if(dao.update(a)){
			out.print("<script>alert('修改成功');location.href='notice.jsp';</script>");
		}else{
			out.print("<script>alert('修改失败');location.href='notice.jsp';</script>");
		}
	}


	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("username");
		String nickName = request.getParameter("nickname");
		System.out.println(nickName);
		String email = request.getParameter("email");
		String desciption = request.getParameter("desciption");
		String oldpassword = request.getParameter("old_password");
		String password = request.getParameter("password");
		String repPassword = request.getParameter("new_password");
		BaseDAO<User> dao = new UserDAO();
		User u = dao.findById(id);
		PrintWriter out = response.getWriter();
		if(u.getPassword().equals(oldpassword)){
			if(password.equals(repPassword)){
				u = new User(id, username, password, nickName, desciption, email, null, null, null, 0);
				if(dao.update(u)){
					out.print("<script>alert('修改成功');location.href='manage-user.jsp';</script>");
				}else{
					out.print("<script>alert('修改失败');location.href='manage-user.jsp';</script>");
				}
			}else{
				out.print("<script>alert('两次密码不相同');location.href='manage-user.jsp';</script>");
			}
		}else{
			out.print("<script>alert('密码错误');location.href='manage-user.jsp';</script>");
		}
	}


	private void updateArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Manager m = (Manager) request.getSession().getAttribute("manager");
//		String imageSrc = request.getParameter("imageSrc");
		String description = request.getParameter("describe");
		Article article = new Article();
		article.setId(Integer.parseInt(id));
		article.setTitle(title);
		article.setContent(content);
		article.setUid(m.getId());
//		article.setImageSrc(imageSrc);
		article.setDescription(description);
		System.out.println(id);
		System.out.println(title);
		System.out.println(content);
		System.out.println(m.getId());
//		System.out.println(imageSrc);
		System.out.println(description);
		BaseDAO<Article> dao = new ArticleDAO();
		PrintWriter out = response.getWriter();
		if (dao.update(article)) {
			out.println("<script>alert('修改成功');location.href='article.jsp'</script>");
			System.out.println("修改成功");
		} else {
			out.println("<script>alert('修改失败');location.href='article.jsp'</script>");
			System.out.println("修改失败");
		}
		out.flush();
	}


	private void updateFlink(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String imgSrc = request.getParameter("imgurl");
		String information = request.getParameter("describe");
		String target = request.getParameter("target");
		String rel = request.getParameter("rel");
		Date uTime = new Date();
		Link link = new Link(Integer.parseInt(id), name, url, imgSrc, information, Integer.parseInt(target), Integer.parseInt(rel),null,uTime);
		BaseDAO<Link> dao = new LinkDAO();
		PrintWriter out = response.getWriter();
		if(dao.update(link)){
			out.println("<script>alert('修改成功');location.href='flink.jsp'</script>");
		}else{
			out.println("<script>alert('修改失败');location.href='flink.jsp'</script>");
		}
		out.flush();
	}


	private void updateCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String vname = request.getParameter("alias");
		String pid = request.getParameter("fid");
		String keywords = request.getParameter("keywords");
		String describe = request.getParameter("describe");
		Category c = new Category(Integer.parseInt(id), name, vname, describe, Integer.parseInt(pid), 0, keywords);
		BaseDAO<Category> dao = new CategoryDAO();
		PrintWriter out = response.getWriter();
		if(dao.update(c)){
			out.print("<script>alert('修改成功');location.href='category.jsp'</script>");
		}else{
			out.print("<script>alert('修改失败');location.href='category.jsp'</script>");
		}
	}


	


	private void updateManager(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String new_username = request.getParameter("username");
		String new_phone = request.getParameter("usertel");
		String old_password = request.getParameter("old_password");
		String new_password = request.getParameter("password");
		String rep_password = request.getParameter("new_password");
		BaseDAO<Manager> dao = new ManagerDAO();
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		String real_password = (manager).getPassword();
		if(real_password.equals(old_password)){
			manager.setUsername(new_username);
			manager.setPhone(new_phone);
			manager.setPassword(new_password);
			PrintWriter out = response.getWriter();
			if(new_password.equals(rep_password)){
				if(dao.update(manager)){
					request.getSession().setAttribute("manager", manager);
					out.println("<script>alert('更新成功');location.href='index.jsp';</script>");
				}else{
					out.println("<script>alert('更新失败');location.href='index.jsp';</script>");
				}
			}else{
				out.println("<script>alert('两次密码输入不一致');location.href='index.jsp';</script>");
			}
		}else{
			request.setAttribute("msg", "你不是本人操作！");
			//清空session
			request.getSession().removeAttribute("manager");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

	
	
}
