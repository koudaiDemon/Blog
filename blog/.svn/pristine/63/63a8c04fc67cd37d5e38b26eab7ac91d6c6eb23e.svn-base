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
import com.softeem.dto.PageBean;
/**
 * 公告dao(实现接口分页)
 * @author Administrator
 *
 */
public class AnnouncementDAO implements BaseDAO<Announcement>,BasePageDAO<Announcement>{

	@Override
	public boolean add(Announcement t) {
		String sql = "insert into tannouncement(title,content,imgsrc,mid) values(?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getTitle(), t.getContent(),t.getImgSrc(),t.getMid());
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
	public boolean delete(Announcement t) {
		String sql = "delete from tannouncement where _id=?";
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

	@Override
	public boolean update(Announcement t) {
		String sql = "update tannouncement set title=?,content=?,imgSrc=?,submitTime=?,mid=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql,t.getTitle(), t.getContent(),t.getImgSrc(),t.getSubmitTime(),t.getMid(),t.getId());
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
	public List<Announcement> findAll() {
		String sql = "select * from tannouncement";
		return DBUtils.queryOne(sql, new CallBack<List<Announcement>>(){
			@Override
			public List<Announcement> getData(ResultSet rs) {
				List<Announcement> list = new ArrayList<>();
				Announcement ac = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String imgSrc = rs.getString("imgsrc");
						Date submitTime = rs.getTimestamp("submitTime");
						int mid = rs.getInt("mid");
						ac = new Announcement(id, title, content, imgSrc, submitTime, mid);
						list.add(ac);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Announcement findById(int id) {
		String sql = "select * from tannouncement where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Announcement>(){
			@Override
			public Announcement getData(ResultSet rs) {
				Announcement ac = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String imgSrc = rs.getString("imgsrc");
						Date submitTime = rs.getTimestamp("submitTime");
						int mid = rs.getInt("mid");
						ac = new Announcement(id, title, content, imgSrc, submitTime, mid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return ac;
			}
		},id);
	}

	@Override
	public List<Announcement> findByProperty(Announcement t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Announcement> findByPage(PageBean<Announcement> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tannouncement limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Announcement>>(){
			@Override
			public List<Announcement> getData(ResultSet rs) {
				List<Announcement> list = new ArrayList<>();
				Announcement ac = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String imgSrc = rs.getString("imgsrc");
						Date submitTime = rs.getTimestamp("submitTime");
						int mid = rs.getInt("mid");
						ac = new Announcement(id, title, content, imgSrc, submitTime, mid);
						list.add(ac);
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
		String sql = "select count(*) from tannouncement";
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
	public Announcement findByProper(Announcement t) {
		String sql = "select * from tannouncement where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Announcement>(){
			@Override
			public Announcement getData(ResultSet rs) {
				Announcement ac = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String imgSrc = rs.getString("imgsrc");
						Date submitTime = rs.getTimestamp("submitTime");
						int mid = rs.getInt("mid");
						ac = new Announcement(id, title, content, imgSrc, submitTime, mid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return ac;
			}
		}, t.getId());
	}

	@Override
	public List<Announcement> findByPageAndId(PageBean<Announcement> bean,
			int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
