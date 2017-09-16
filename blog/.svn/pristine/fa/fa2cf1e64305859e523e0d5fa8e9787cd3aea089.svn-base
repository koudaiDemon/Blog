package com.softeem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Manager;
import com.softeem.dto.Message;
import com.softeem.dto.PageBean;

/**
 * 信息DAO(针对网站的信息)
 * @author Administrator
 *
 */
public class MessageDAO implements BaseDAO<Message>,BasePageDAO<Message>{

	@Override
	public boolean add(Message t) {
		String sql = "insert into tmessage(content,uid) value(?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getContent(),t.getUid());
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
	public boolean delete(Message t) {
		String sql = "delete from tmessage where _id=?";
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
	public boolean update(Message t) {
		String sql = "update tmessage set content=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getContent(),t.getId());
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
	public List<Message> findAll() {
		String sql = "select * from tmessage";
		return DBUtils.queryOne(sql, new CallBack<List<Message>>(){
			@Override
			public List<Message> getData(ResultSet rs) {
				List<Message> list = new ArrayList<>();
				Message message = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date submitTime = rs.getTimestamp("submitTime");
						int uid = rs.getInt("uid");
						message = new Message(id, content, submitTime, uid);
						list.add(message);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Message findById(int id) {
		String sql = "select * from tmessage where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Message>(){
			@Override
			public Message getData(ResultSet rs) {
				Message message = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date submitTime = rs.getTimestamp("submitTime");
						int uid = rs.getInt("uid");
						message = new Message(id, content, submitTime, uid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return message;
			}
		}, id);
	}

	@Override
	public List<Message> findByProperty(Message t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByPage(PageBean<Message> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tmessage limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Message>>(){
			@Override
			public List<Message> getData(ResultSet rs) {
				List<Message> list = new ArrayList<>();
				Message message = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date submitTime = rs.getTimestamp("submitTime");
						int uid = rs.getInt("uid");
						message = new Message(id, content, submitTime, uid);
						list.add(message);
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
		String sql = "select count(*) from tmessage";
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
	public Message findByProper(Message t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByPageAndId(PageBean<Message> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
