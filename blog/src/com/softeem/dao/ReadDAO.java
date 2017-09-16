package com.softeem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Message;
import com.softeem.dto.PageBean;
import com.softeem.dto.Read;

/**
 * ÔÄ¶ÁÁ¿DAO
 * @author Administrator
 *
 */
public class ReadDAO implements BaseDAO<Read>,BasePageDAO<Read>{

	@Override
	public boolean add(Read t) {
		String sql = "insert into tread(aid,ip,uid) value(?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getAid(),t.getIp(),t.getUid());
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
	public boolean delete(Read t) {
		String sql = "delete from tread where _id=?";
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
	public boolean update(Read t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Read> findAll() {
		String sql = "select * from tread";
		return DBUtils.queryOne(sql, new CallBack<List<Read>>(){
			@Override
			public List<Read> getData(ResultSet rs) {
				List<Read> list = new ArrayList<>();
				Read read = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						int aid = rs.getInt("aid");
						String ip = rs.getString("ip");
						int uid = rs.getInt("uid");
						Date readTime = rs.getTimestamp("readTime");
						read = new Read(id, aid, ip, uid, readTime);
						list.add(read);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Read findById(int id) {
		String sql = "select * from tread where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Read>(){
			@Override
			public Read getData(ResultSet rs) {
				Read read = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						int aid = rs.getInt("aid");
						String ip = rs.getString("ip");
						int uid = rs.getInt("uid");
						Date readTime = rs.getTimestamp("readTime");
						read = new Read(id, aid, ip, uid, readTime);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return read;
			}
		}, id);
	}

	@Override
	public List<Read> findByProperty(Read t) {
		String sql = "select * from tread where uid=?";
		return DBUtils.queryList(sql, new CallBack<Read>(){
			@Override
			public List<Read> getDatas(ResultSet rs) {
				List<Read> list = new ArrayList<>();
				Read read = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						int aid = rs.getInt("aid");
						String ip = rs.getString("ip");
						int uid = rs.getInt("uid");
						Date readTime = rs.getTimestamp("readTime");
						read = new Read(id, aid, ip, uid, readTime);
						list.add(read);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		}, t.getUid());
	}

	@Override
	public List<Read> findByPage(PageBean<Read> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tread limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Read>>(){
			@Override
			public List<Read> getData(ResultSet rs) {
				List<Read> list = new ArrayList<>();
				Read read = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						int aid = rs.getInt("aid");
						String ip = rs.getString("ip");
						int uid = rs.getInt("uid");
						Date readTime = rs.getTimestamp("readTime");
						read = new Read(id, aid, ip, uid, readTime);
						list.add(read);
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
		String sql = "select count(*) from tread";
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
	public Read findByProper(Read t) {
		return null;
	}

	@Override
	public List<Read> findByPageAndId(PageBean<Read> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
