package com.softeem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Comm;
import com.softeem.dto.PageBean;

/**
 * ∆¿¬€DAO(’Î∂‘Œƒ’¬)
 * @author Administrator
 *
 */
public class CommDAO implements BaseDAO<Comm>,BasePageDAO<Comm>{

	@Override
	public boolean add(Comm t) {
		String sql = "insert into tcomm(content, commTime, aid, parentcommid, uid) values(?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getContent(), t.getCommTime(), t.getAid(), t.getParentcommid(), t.getUid());
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
	public boolean delete(Comm t) {
		String sql = "delete from tcomm where _id=?";
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
	public boolean update(Comm t) {
		String sql = "update tcomm set content=?,commTime=?,aid=?,parentcommid=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getContent(),t.getCommTime(), t.getAid(), t.getParentcommid());
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
	public List<Comm> findAll() {
		String sql = "select * from tcomm";
		return DBUtils.queryOne(sql, new CallBack<List<Comm>>(){
			@Override
			public List<Comm> getData(ResultSet rs) {
				List<Comm> list = new ArrayList<>();
				Comm co = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date commTime = rs.getDate("commTime");
						int aid = rs.getInt("aid");
						int parentcommid = rs.getInt("parentcommid");
						int uid = rs.getInt("uid");
						co = new Comm(id, content, commTime, aid, parentcommid, uid);
						list.add(co);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Comm findById(int id) {
		String sql = "select * from tcomm where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Comm>(){
			@Override
			public Comm getData(ResultSet rs) {
				Comm co = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date commTime = rs.getDate("commTime");
						int aid = rs.getInt("aid");
						int parentcommid = rs.getInt("parentcommid");
						int uid = rs.getInt("uid");
						co = new Comm(id, content, commTime, aid, parentcommid, uid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return co;
			}
		});
	}

	@Override
	public List<Comm> findByProperty(Comm t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comm> findByPage(PageBean<Comm> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tcomm limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Comm>>(){
			@Override
			public List<Comm> getData(ResultSet rs) {
				List<Comm> list = new ArrayList<>();
				Comm co = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date commTime = rs.getTimestamp("commTime");
						int aid = rs.getInt("aid");
						int parentcommid = rs.getInt("parentcommid");
						int uid = rs.getInt("uid");
						co = new Comm(id, content, commTime, aid, parentcommid, uid);
						list.add(co);
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
		String sql = "select count(*) from tcomm";
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
	public Comm findByProper(Comm t) {
		String sql = "select * from tcomm where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Comm>(){
			@Override
			public Comm getData(ResultSet rs) {
				Comm co = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String content = rs.getString("content");
						Date commTime = rs.getDate("commTime");
						int aid = rs.getInt("aid");
						int parentcommid = rs.getInt("parentcommid");
						int uid = rs.getInt("uid");
						co = new Comm(id, content, commTime, aid, parentcommid, uid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return co;
			}
		}, t.getId());
	}

	@Override
	public List<Comm> findByPageAndId(PageBean<Comm> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean deleteByPid(Comm c) {
		String sql = "delete from tcomm where parentcommid=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, c.getParentcommid());
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

}
