package com.softeem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Announcement;
import com.softeem.dto.Article;
import com.softeem.dto.Category;
import com.softeem.dto.PageBean;

/**
 * 文章DAO
 * @author Administrator
 *
 */
public class ArticleDAO implements BaseDAO<Article>,BasePageDAO<Article>{

	@Override
	public boolean add(Article t) {
		String sql = "insert into tarticle(title,content,cid,lastTime,uid,imagesrc,isHide,description) values(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getTitle(),t.getContent(), t.getCategory()==null?null:t.getCategory().getId(),t.getLastTime(),t.getUid(),t.getImageSrc(), t.getIsHide(), t.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delete(Article t) {
		String sql = "delete from tarticle where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	/**
	 * 用于联表删除
	 * @param t
	 * @return
	 */
	public boolean updateByUid(Article t) {
		String sql = "update tarticle set title=?,content=? where uid=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getTitle(), t.getContent(), t.getUid());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	//title,content,cid,lastTime,uid,imagesrc,isHide,description
	@Override
	public boolean update(Article t) {
		String sql = "update tarticle set title=?,content=?,uid=?,description=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getTitle(),t.getContent(), t.getUid(), t.getDescription(), t.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<Article> findAll() {
		String sql = "select * from tarticle";
		return DBUtils.queryOne(sql, new CallBack<List<Article>>(){
			@Override
			public List<Article> getData(ResultSet rs) {
				List<Article> list = new ArrayList<>();
				Article at = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						int cid = rs.getInt("cid");
						Date submitTime = rs.getTimestamp("submitTime");
						Date lastTime = rs.getTimestamp("lastTime");
						int uid = rs.getInt("uid");
						int readTimes = rs.getInt("readTimes");
						int feedbackNum = rs.getInt("feedbackNum");
						String imagesrc = rs.getString("imagesrc");
						int isHide = rs.getInt("isHide");
						String description = rs.getString("description");
						Category category = new Category();
						category.setId(cid);
						at = new Article(id, title, content, category, submitTime, lastTime, uid, readTimes, feedbackNum, imagesrc, isHide, description);
						list.add(at);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Article findById(int id) {
		String sql = "select * from tarticle where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Article>(){
			@Override
			public Article getData(ResultSet rs) {
				Article at = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						int cid = rs.getInt("cid");
						Date submitTime = rs.getTimestamp("submitTime");
						Date lastTime = rs.getTimestamp("lastTime");
						int uid = rs.getInt("uid");
						int readTimes = rs.getInt("readTimes");
						int feedbackNum = rs.getInt("feedbackNum");
						String imagesrc = rs.getString("imagesrc");
						int isHide = rs.getInt("isHide");
						String description = rs.getString("description");
						Category category = new Category();
						category.setId(cid);
						at = new Article(id, title, content, category, submitTime, lastTime, uid, readTimes, feedbackNum, imagesrc, isHide, description);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return at;
			}
		},id);
	}

	@Override
	public List<Article> findByProperty(Article t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByPage(PageBean<Article> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tarticle limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Article>>(){
			@Override
			public List<Article> getData(ResultSet rs) {
				List<Article> list = new ArrayList<>();
				Article at = null;
				BaseDAO<Category> dao = new CategoryDAO();
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						int cid = rs.getInt("cid");
						Date submitTime = rs.getTimestamp("submitTime");
						Date lastTime = rs.getTimestamp("lastTime");
						int uid = rs.getInt("uid");
						int readTimes = rs.getInt("readTimes");
						int feedbackNum = rs.getInt("feedbackNum");
						String imagesrc = rs.getString("imagesrc");
						int isHide = rs.getInt("isHide");
						String description = rs.getString("description");
						Category category = dao.findById(cid);
						at = new Article(id, title, content, category, submitTime, lastTime, uid, readTimes, feedbackNum, imagesrc, isHide, description);
						list.add(at);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		},(current-1)*pageSize,pageSize);
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from tarticle";
		return DBUtils.queryOne(sql, new CallBack<Integer>(){
			@Override
			public Integer getData(ResultSet rs) {
				try {
					if(rs.next()){
						return rs.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
	}

	@Override
	public Article findByProper(Article t) {
		String sql = "select * from tarticle where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Article>(){
			@Override
			public Article getData(ResultSet rs) {
				Article at = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						int cid = rs.getInt("cid");
						Date submitTime = rs.getTimestamp("submitTime");
						Date lastTime = rs.getTimestamp("lastTime");
						int uid = rs.getInt("uid");
						int readTimes = rs.getInt("readTimes");
						int feedbackNum = rs.getInt("feedbackNum");
						String imagesrc = rs.getString("imagesrc");
						int isHide = rs.getInt("isHide");
						String description = rs.getString("description");
						Category category = new Category();
						category.setId(cid);
						at = new Article(id, title, content, category, submitTime, lastTime, uid, readTimes, feedbackNum, imagesrc, isHide, description);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return at;
			}
		}, t.getId());
	}

	@Override
	public List<Article> findByPageAndId(PageBean<Article> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
