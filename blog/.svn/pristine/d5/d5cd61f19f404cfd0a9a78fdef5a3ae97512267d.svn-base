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
import com.softeem.dto.Link;
import com.softeem.dto.Manager;
import com.softeem.dto.PageBean;
/**
 * π‹¿Ì‘±DAO
 * @author Administrator
 *
 */
public class ManagerDAO implements BaseDAO<Manager>,BasePageDAO<Manager>{

	@Override
	public boolean add(Manager t) {
		String sql = "insert into tmanager(username,password,phone,hid) value(?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getUsername(),t.getPassword(),t.getPhone(),t.getHeadImg().getId());
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
	public boolean delete(Manager t) {
		String sql = "delete from tmanager where _id=?";
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
	public boolean update(Manager t) {
		String sql = "update tmanager set password=?,phone=?,lastloadTime=?,loadCount=?,lastLoadIp=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getPassword(),t.getPhone(),t.getLastLoadTime(),t.getLoadCount(),t.getLastLoadIp(),t.getId());
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
	public List<Manager> findAll() {
		String sql = "select * from tmanager";
		return DBUtils.queryOne(sql, new CallBack<List<Manager>>(){
			@Override
			public List<Manager> getData(ResultSet rs) {
				List<Manager> list = new ArrayList<>();
				Manager manager = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String phone = rs.getString("phone");
						Date regTime = rs.getTimestamp("regTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int count = rs.getInt("loadcount");
						String lastLoadIp = rs.getString("lastloadip");
						manager = new Manager(id, username, password, phone, head, regTime, lastLoadTime, count, lastLoadIp);
						list.add(manager);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Manager findById(int id) {
		String sql = "select * from tmanager where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Manager>(){
			@Override
			public Manager getData(ResultSet rs) {
				Manager manager = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String phone = rs.getString("phone");
						Date regTime = rs.getTimestamp("regTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int count = rs.getInt("loadcount");
						String lastLoadIp = rs.getString("lastloadip");
						manager = new Manager(id, username, password, phone, head, regTime, lastLoadTime, count, lastLoadIp);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return manager;
			}
		}, id);
	}

	@Override
	public List<Manager> findByProperty(Manager t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> findByPage(PageBean<Manager> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tmanager limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Manager>>(){
			@Override
			public List<Manager> getData(ResultSet rs) {
				List<Manager> list = new ArrayList<>();
				Manager manager = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String phone = rs.getString("phone");
						Date regTime = rs.getTimestamp("regTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int count = rs.getInt("loadcount");
						String lastLoadIp = rs.getString("lastloadip");
						manager = new Manager(id, username, password, phone, head, regTime, lastLoadTime, count, lastLoadIp);
						list.add(manager);
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
		String sql = "select count(*) from tmanager";
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
	public Manager findByProper(Manager t) {
		String sql = "select * from tmanager where username=?";
		return DBUtils.queryOne(sql, new CallBack<Manager>(){
			@Override
			public Manager getData(ResultSet rs) {
				Manager manager = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String phone = rs.getString("phone");
						Date regTime = rs.getTimestamp("regTime");
						int hid = rs.getInt("hid");
						Head head = new Head();
						head.setId(hid);
						Date lastLoadTime = rs.getTimestamp("lastLoadTime");
						int count = rs.getInt("loadcount");
						String lastLoadIp = rs.getString("lastloadip");
						manager = new Manager(id, username, password, phone, head, regTime, lastLoadTime, count, lastLoadIp);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return manager;
			}
		}, t.getUsername());
	}

	@Override
	public List<Manager> findByPageAndId(PageBean<Manager> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
