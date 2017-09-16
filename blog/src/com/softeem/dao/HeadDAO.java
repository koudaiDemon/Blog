package com.softeem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Comm;
import com.softeem.dto.Head;
import com.softeem.dto.PageBean;

/**
 * 头像DAO
 * @author Administrator
 *
 */
public class HeadDAO implements BaseDAO<Head>,BasePageDAO<Head>{

	@Override
	public boolean add(Head t) {
		String sql = "insert into thead(path) values(?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getPath());
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

	/**
	 * 添加并返回id
	 * @param t
	 * @return
	 */
	public int addAndReturn(Head t){
		String sql = "insert into thead(path) values(?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getPath());
			if(ps.executeUpdate()>0){
				rs = ps.getGeneratedKeys();
				if(rs.next()){
					return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null){rs.close();}
				if(ps != null){ps.close();}
				if(conn != null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public boolean delete(Head t) {
		String sql = "delete from thead where _id=?";
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
	public boolean update(Head t) {
		String sql = "update thead set path=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getPath());
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
	public List<Head> findAll() {
		String sql = "select * from thead";
		return DBUtils.queryOne(sql, new CallBack<List<Head>>(){
			@Override
			public List<Head> getData(ResultSet rs) {
				List<Head> list = new ArrayList<>();
				Head h = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String path = rs.getString("path");
						h = new Head(id, path);
						list.add(h);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Head findById(int id) {
		String sql = "select * from thead where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Head>(){
			@Override
			public Head getData(ResultSet rs) {
				Head h = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String path = rs.getString("path");
						h = new Head(id, path);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return h;
			}
		});
	}

	@Override
	public List<Head> findByProperty(Head t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Head> findByPage(PageBean<Head> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from thead limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Head>>(){
			@Override
			public List<Head> getData(ResultSet rs) {
				List<Head> list = new ArrayList<>();
				Head h = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String path = rs.getString("path");
						h = new Head(id, path);
						list.add(h);
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
		String sql = "select count(*) from thead";
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
	public Head findByProper(Head t) {
		String sql = "select * from thead where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Head>(){
			@Override
			public Head getData(ResultSet rs) {
				Head h = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String path = rs.getString("path");
						h = new Head(id, path);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return h;
			}
		}, t.getId());
	}

	@Override
	public List<Head> findByPageAndId(PageBean<Head> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
