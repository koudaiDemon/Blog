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
import com.softeem.dto.PageBean;

/**
 * ”—«È¡¥Ω”DAO
 * @author Administrator
 *
 */
public class LinkDAO implements BaseDAO<Link>,BasePageDAO<Link>{

	@Override
	public boolean add(Link t) {
		String sql = "insert into tlink(name,url,linkimgsrc,information,target,rel) value(?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getName(),t.getUrl(),t.getLinkimgSrc(),t.getInformation(),t.getTarget(),t.getRel());
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
	public boolean delete(Link t) {
		String sql = "delete from tlink where _id=?";
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
	public boolean update(Link t) {
		String sql = "update tlink set name=?,url=?,linkimgsrc=?,information=?,target=?,rel=?,utime=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getName(),t.getUrl(),t.getLinkimgSrc(),t.getInformation(),t.getTarget(),t.getRel(),t.getuTime(),t.getId());
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
	public List<Link> findAll() {
		String sql = "select * from tlink";
		return DBUtils.queryOne(sql, new CallBack<List<Link>>(){
			@Override
			public List<Link> getData(ResultSet rs) {
				List<Link> list = new ArrayList<>();
				Link link = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String url = rs.getString("url");
						String linkImgId = rs.getString("linkImgSrc");
						String information = rs.getString("information");
						int target = rs.getInt("target");
						int rel = rs.getInt("rel");
						Date addTime = rs.getTimestamp("addTime");
						Date uTime = rs.getTimestamp("uTime");
						link = new Link(id, name, url, linkImgId, information,target,rel,addTime,uTime);
						list.add(link);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Link findById(int id) {
		String sql = "select * from tlink where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Link>(){
			@Override
			public Link getData(ResultSet rs) {
				Link link = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String url = rs.getString("url");
						String linkImgId = rs.getString("linkImgSrc");
						String information = rs.getString("information");
						int target = rs.getInt("target");
						int rel = rs.getInt("rel");
						Date addTime = rs.getTimestamp("addTime");
						Date uTime = rs.getTimestamp("uTime");
						link = new Link(id, name, url, linkImgId, information,target,rel,addTime,uTime);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return link;
			}
		}, id);
	}

	@Override
	public List<Link> findByProperty(Link t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Link> findByPage(PageBean<Link> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tlink limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Link>>(){
			@Override
			public List<Link> getData(ResultSet rs) {
				List<Link> list = new ArrayList<>();
				Link link = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String url = rs.getString("url");
						String linkImgId = rs.getString("linkImgSrc");
						String information = rs.getString("information");
						int target = rs.getInt("target");
						int rel = rs.getInt("rel");
						Date addTime = rs.getTimestamp("addTime");
						Date uTime = rs.getTimestamp("uTime");
						link = new Link(id, name, url, linkImgId, information,target,rel,addTime,uTime);
						list.add(link);
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
		String sql = "select count(*) from tlink";
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
	public Link findByProper(Link t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Link> findByPageAndId(PageBean<Link> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
