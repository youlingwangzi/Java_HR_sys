package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import entity.Job;

public class JobDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List getList(){
		List list=new Vector();
		String sql="select * from job";
		try {
			conn=BaseDao.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				Job job=new Job(id,name);
				list.add(job);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}

}
