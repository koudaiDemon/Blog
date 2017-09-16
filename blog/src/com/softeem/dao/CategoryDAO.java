package com.softeem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softeem.db.DBUtils;
import com.softeem.db.DBUtils.CallBack;
import com.softeem.dto.Article;
import com.softeem.dto.Category;
import com.softeem.dto.PageBean;

/**
 * 类别DAO
 * @author Administrator
 *
 */
public class CategoryDAO implements BaseDAO<Category>,BasePageDAO<Category>{
	
	//不需要管文章总数，因为有默认值
	@Override
	public boolean add(Category t) {
		String sql = "insert into tcategory(name , vname, description , pid,keywords) values(?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getName(),t.getVname(), t.getDescription(),t.getPid()==0?null:t.getPid(),t.getKeywords());
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
	public boolean delete(Category t) {
		String sql = "delete from tcategory where _id=?";
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
	 * 删除子节点
	 * @param t
	 * @return
	 */
	public boolean deleteByPid(Category t) {
		String sql = "delete from tcategory where pid=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getPid());
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
	public boolean update(Category t) {
		String sql = "update tcategory set name=?,vname=?,description=?,pid=?,keywords=? where _id=?";
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			return DBUtils.execUpdate(conn, sql, t.getName(),t.getVname(),t.getDescription(),t.getPid()==0?null:t.getPid(),t.getKeywords(),t.getId());
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
	public List<Category> findAll() {
		String sql = "select * from tcategory";
		return DBUtils.queryOne(sql, new CallBack<List<Category>>(){
			@Override
			public List<Category> getData(ResultSet rs) {
				List<Category> list = new ArrayList<>();
				Category c = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String vname = rs.getString("vname");
						String description = rs.getString("description");
						int fid =rs.getInt("pid");
						int acount = rs.getInt("acount");
						String keywords = rs.getString("keywords");
						c = new Category(id, name, vname, description, fid, acount, keywords);
						list.add(c);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	@Override
	public Category findById(int id) {
		String sql = "select * from tcategory where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Category>(){
			@Override
			public Category getData(ResultSet rs) {
				Category c = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String vname = rs.getString("vname");
						String description = rs.getString("description");
						int fid =rs.getInt("pid");
						int acount = rs.getInt("acount");
						String keywords = rs.getString("keywords");
						c = new Category(id, name, vname, description, fid, acount, keywords);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return c;
			}
		},id);
	}
	
	
	@Override
	public List<Category> findByProperty(Category t) {
		String sql = "";
		if(t.getPid() == 0){
			 sql = "select * from tcategory where pid is null";
			 return DBUtils.queryList(sql,new CallBack<Category>(){
					@Override
					public List<Category> getDatas(ResultSet rs) {
						List<Category> list = new ArrayList<>();
						Category c = null;
						try {
							while(rs.next()){
								int id = rs.getInt("_id");
								String name = rs.getString("name");
								String vname = rs.getString("vname");
								String description = rs.getString("description");
								int fid =rs.getInt("pid");
								int acount = rs.getInt("acount");
								String keywords = rs.getString("keywords");
								c = new Category(id, name, vname, description, fid, acount, keywords);
								list.add(c);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return list;
					}
				});
		}else{
			 sql = "select * from tcategory where pid = ?";
			 return DBUtils.queryList(sql,new CallBack<Category>(){
					@Override
					public List<Category> getDatas(ResultSet rs) {
						List<Category> list = new ArrayList<>();
						Category c = null;
						try {
							while(rs.next()){
								int id = rs.getInt("_id");
								String name = rs.getString("name");
								String vname = rs.getString("vname");
								String description = rs.getString("description");
								int fid =rs.getInt("pid");
								int acount = rs.getInt("acount");
								String keywords = rs.getString("keywords");
								c = new Category(id, name, vname, description, fid, acount, keywords);
								list.add(c);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return list;
					}
				}, t.getPid()==0?null:t.getPid());
		}
		
	}

	@Override
	public List<Category> findByPage(PageBean<Category> bean) {
		int current = bean.getCurrentPage();
		int pageSize = bean.getPageSize();
		String sql = "select * from tcategory limit ?,?";
		return DBUtils.queryOne(sql, new CallBack<List<Category>>(){
			@Override
			public List<Category> getData(ResultSet rs) {
				List<Category> list = new ArrayList<>();
				Category c = null;
				try {
					while(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String vname = rs.getString("vname");
						String description = rs.getString("description");
						int fid =rs.getInt("pid");
						int acount = rs.getInt("acount");
						String keywords = rs.getString("keywords");
						c = new Category(id, name, vname, description, fid, acount, keywords);
						list.add(c);
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
		String sql = "select count(*) from tcategory";
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
	public Category findByProper(Category t) {
		String sql = "select * from tcategory where _id=?";
		return DBUtils.queryOne(sql, new CallBack<Category>(){
			@Override
			public Category getData(ResultSet rs) {
				Category c = null;
				try {
					if(rs.next()){
						int id = rs.getInt("_id");
						String name = rs.getString("name");
						String vname = rs.getString("vname");
						String description = rs.getString("description");
						int fid =rs.getInt("pid");
						int acount = rs.getInt("acount");
						String keywords = rs.getString("keywords");
						c = new Category(id, name, vname, description, fid, acount, keywords);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return c;
			}
		}, t.getId());
	}

	@Override
	public List<Category> findByPageAndId(PageBean<Category> bean, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
