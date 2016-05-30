package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import entity.Dept;

public class DeptDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List getList(){
		List list=new Vector();
		String sql="select * from dept";
		try {
			conn=BaseDao.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				Dept dept=new Dept(id,name);
				list.add(dept);
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
