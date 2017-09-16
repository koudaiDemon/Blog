package com.softeem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Head;
import com.softeem.dto.Manager;
import com.softeem.dto.PageBean;
import com.softeem.dto.User;

/**
 * ÓÃ»§DAO
 * @author Administrator
 *
 */
public class UserDAO implements BaseDAO<User>,BasePageDAO<User>{

	@Override
	public boolean add(User t) {
		String sql = "insert into tuser(username,password,nickname,desciption,email,hid,lastLoadTime,acount) value(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getUsername(),t.getPassword(),t.getNickName(),t.getDesciption(),t.getEmail(),t.getHeadImg()==null?null:t.getHeadImg().getId(), new Date(), t.getAcount());
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
	public boolean delete(User t) {
		String sql = "delete from tuser where _id=?";
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
	public boolean update(User t) {
		String sql = "update tuser set username=?,nickname=?,password=?,desciption=?,email=?,hid=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getUsername(),t.getNickName(),t.getPassword(),t.getDesciption(),t.getEmail(),t.getHeadImg()==null?null:t.getHeadImg().getId(),t.getId());
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

	public boolean updateTime(User t) {
		String sql = "update tuser set lastLoadTime=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getLastLoadTime(),t.getId());
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
	public List<User> findAll() {
		String sql = "select * from tuser";
		return DBUtils.queryOne(sql, new CallBack<List<User>>(){
			@Override
			public List<User> getData(ResultSet rs) {
				List<User> list = new ArrayList<>();
				User user = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String nickName = rs.getString("nickName");
						String desciption = rs.getString("desciption");
						String email = rs.getString("Email");
						Date registerTime = rs.getTimestamp("registerTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int acount = rs.getInt("acount");
						user = new User(id, username, password, nickName, desciption, email, registerTime, lastLoadTime, head, acount);
						list.add(user);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public User findById(int id) {
		String sql = "select * from tuser where _id=?";
		return DBUtils.queryOne(sql, new CallBack<User>(){
			@Override
			public User getData(ResultSet rs) {
				User user = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String nickName = rs.getString("nickName");
						String desciption = rs.getString("desciption");
						String email = rs.getString("Email");
						Date registerTime = rs.getTimestamp("registerTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int acount = rs.getInt("acount");
						user = new User(id, username, password, nickName, desciption, email, registerTime, lastLoadTime, head, acount);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
		}, id);
	}

	@Override
	public List<User> findByProperty(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> findByPage(PageBean<User> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tuser limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<User>>(){
			@Override
			public List<User> getData(ResultSet rs) {
				List<User> list = new ArrayList<>();
				User user = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String nickName = rs.getString("nickName");
						String desciption = rs.getString("desciption");
						String email = rs.getString("Email");
						Date registerTime = rs.getTimestamp("registerTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int acount = rs.getInt("acount");
						user = new User(id, username, password, nickName, desciption, email, registerTime, lastLoadTime, head, acount);
						list.add(user);
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
		String sql = "select count(*) from tuser";
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
	public User findByProper(User t) {
		String sql = "select * from tuser where email=?";
		return DBUtils.queryOne(sql, new CallBack<User>(){
			@Override
			public User getData(ResultSet rs) {
				User user = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String nickName = rs.getString("nickName");
						String desciption = rs.getString("desciption");
						String email = rs.getString("Email");
						Date registerTime = rs.getTimestamp("registerTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int acount = rs.getInt("acount");
						user = new User(id, username, password, nickName, desciption, email, registerTime, lastLoadTime, head, acount);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return user;
			}
		}, t.getEmail());
	}

	@Override
	public List<User> findByPageAndId(PageBean<User> bean, int id) {
		return null;
	}

	@Override
	public int getCountById(int id) {
		return 0;
	}

}
