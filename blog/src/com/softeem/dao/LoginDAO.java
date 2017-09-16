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
import com.softeem.dto.Login;
import com.softeem.dto.Manager;
import com.softeem.dto.PageBean;
import com.softeem.dto.User;

public class LoginDAO implements BaseDAO<Login>,BasePageDAO<Login>{

	@Override
	public boolean add(Login t) {
		String sql = "insert into tlogin(loadIp,mid,uid,isSuccess) value(?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
//			System.out.println("数据库这边接收到的数据"+t.getManager());
			return DBUtils.execUpdate(conn, sql, t.getLoadIp(),t.getManager()==null?null:t.getManager().getId(),t.getUser()==null?null:t.getUser().getId(),t.getIsSuccess());
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
	public boolean delete(Login t) {
		String sql = "delete from tlogin where _id=?";
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
	 * 删除所有记录
	 * @param t
	 * @return
	 */
	public boolean deleteAll() {
		String sql = "delete from tlogin where 1=1";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql);
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
	 * 根据mid删除所有记录
	 * @param t
	 * @return
	 */
	public boolean deleteAllByMid(Login login) {
		String sql = "delete from tlogin where mid=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql ,login.getManager().getId());
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
	public boolean update(Login t) {
		return false;
	}

	@Override
	public List<Login> findAll() {
		String sql = "select * from tlogin";
		return DBUtils.queryList(sql, new CallBack<Login>(){
			@Override
			public List<Login> getDatas(ResultSet rs) {
				List<Login> list = new ArrayList<>();
				Login login = null;
				BaseDAO<Manager> mdao = new ManagerDAO();
				BaseDAO<User> udao = new UserDAO();
				Manager manager = null;
				User user = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String loadIp = rs.getString("loadIp");
						Date loadTime = rs.getTimestamp("loadTime");
						int mid = rs.getInt("mid");
						int uid = rs.getInt("uid");
						if(mid!=0){
							manager = mdao.findById(mid);
						}else if(uid!=0){
							user = udao.findById(uid);
						}
						int isSuccess = rs.getInt("isSuccess");
						login = new Login(id, loadIp, loadTime, manager, user, isSuccess);
						list.add(login);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Login findById(int id) {
		String sql = "select * from tlogin where _id =?";
		return DBUtils.queryOne(sql, new CallBack<Login>(){
			@Override
			public Login getData(ResultSet rs) {
				Login login = null;
				BaseDAO<Manager> mdao = new ManagerDAO();
				BaseDAO<User> udao = new UserDAO();
				Manager manager = null;
				User user = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String loadIp = rs.getString("loadIp");
						Date loadTime = rs.getTimestamp("loadTime");
						int mid = rs.getInt("mid");
						int uid = rs.getInt("uid");
						int isSuccess = rs.getInt("isSuccess");
						if(mid!=0){
							manager = mdao.findById(mid);
						}else if(uid!=0){
							user = udao.findById(uid);
						}
						login = new Login(id, loadIp, loadTime, manager, user, isSuccess);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return login;
			}
		},id);
	}

	@Override
	public List<Login> findByProperty(Login t) {
		String sql = "select * from tlogin where mid =?";
		return DBUtils.queryList(sql, new CallBack<Login>(){
			@Override
			public List<Login> getDatas(ResultSet rs) {
				List<Login> list = new ArrayList<>();
				Login login = null;
				BaseDAO<Manager> mdao = new ManagerDAO();
				BaseDAO<User> udao = new UserDAO();
				Manager manager = null;
				User user = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String loadIp = rs.getString("loadIp");
						Date loadTime = rs.getTimestamp("loadTime");
						int mid = rs.getInt("mid");
						int uid = rs.getInt("uid");
						int isSuccess = rs.getInt("isSuccess");
						if(mid!=0){
							manager = mdao.findById(mid);
						}else if(uid!=0){
							user = udao.findById(uid);
						}
						login = new Login(id, loadIp, loadTime, manager, user, isSuccess);
						list.add(login);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		},t.getManager().getId());
	}

	@Override
	public Login findByProper(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> findByPage(PageBean<Login> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tlogin limit ?,?";
		return DBUtils.queryList(sql, new CallBack<Login>(){
			@Override
			public List<Login> getDatas(ResultSet rs) {
				List<Login> list = new ArrayList<>();
				Login login = null;
				BaseDAO<Manager> mdao = new ManagerDAO();
				BaseDAO<User> udao = new UserDAO();
				Manager manager = null;
				User user = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String loadIp = rs.getString("loadIp");
						Date loadTime = rs.getTimestamp("loadTime");
						int mid = rs.getInt("mid");
						int uid = rs.getInt("uid");
						int isSuccess = rs.getInt("isSuccess");
						if(mid!=0){
							manager = mdao.findById(mid);
						}else if(uid!=0){
							user = udao.findById(uid);
						}
						login = new Login(id, loadIp, loadTime, manager, user, isSuccess);
						list.add(login);
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
		String sql = "select count(*) from tlogin ";
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
	public int getCountById(int id) {
		String sql = "select count(*) from tlogin where mid = ?";
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
		},id);
	}

	@Override
	public List<Login> findByPageAndId(PageBean<Login> bean, int id) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tlogin where mid=? limit ?,?";
		return DBUtils.queryList(sql, new CallBack<Login>(){
			@Override
			public List<Login> getDatas(ResultSet rs) {
				List<Login> list = new ArrayList<>();
				Login login = null;
				BaseDAO<Manager> mdao = new ManagerDAO();
				BaseDAO<User> udao = new UserDAO();
				Manager manager = null;
				User user = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String loadIp = rs.getString("loadIp");
						Date loadTime = rs.getTimestamp("loadTime");
						int mid = rs.getInt("mid");
						int uid = rs.getInt("uid");
						int isSuccess = rs.getInt("isSuccess");
						if(mid!=0){
							manager = mdao.findById(mid);
						}else if(uid!=0){
							user = udao.findById(uid);
						}
						login = new Login(id, loadIp, loadTime, manager, user, isSuccess);
						list.add(login);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		},id,(current-1)*pageSize,pageSize);
	}
	
}
