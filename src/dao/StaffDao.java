package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Dept;
import entity.Job;
import entity.staff;

public class StaffDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List getList(){
		List list=new ArrayList();

		String  sql="select s.staff_id,s.staff_name,d.dept_id,d.dept_name,j.job_id,j.job_name,s.detail"+
			" from dept d,job j,staff s where s.staff_dept=d.dept_id and j.job_id=s.staff_job order by s.staff_id asc";
		try{
			conn=BaseDao.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int dId=rs.getInt(3);
				String dName=rs.getString(4);
				Dept dept=new Dept(dId,dName);
				int jId=rs.getInt(5);
				String jName=rs.getString(6);
				Job job=new Job(jId,jName);
				String detail=rs.getString(7);
				staff staff=new staff(id,name,dept,job,detail);
				list.add(staff);
			}
			return list;
		}catch(SQLException e){
			//ToDo Auto_gennerated catch block
			e.printStackTrace();
			return null;
		}finally{
			BaseDao.closeAll(conn,stmt, rs);
		}
	}
	public int insert(staff Staff){
		String sql="insert into staff(staff_name,staff_dept,staff_job,detail) values(?,?,?,?)";
		try{
			conn=BaseDao.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,Staff.getStaffName());
			stmt.setInt(2,Staff.getDept().getDeptId());
			stmt.setInt(3,Staff.getJob().getJobId());
			stmt.setString(4,Staff.getDetail());
			return stmt.executeUpdate();
		}catch(SQLException e){
			//ToDo Auto_gennerated catch block
			e.printStackTrace();
			return -1;
		}finally{
			BaseDao.closeAll(conn,stmt, rs);
		}
		
	}
	public int update(staff Staff){
		String sql="update staff set staff_name=?,staff_dept=?,staff_job=?,detail=? where staff_id=?";
		try{
			conn=BaseDao.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,Staff.getStaffName());
			stmt.setInt(2,Staff.getDept().getDeptId());
			stmt.setInt(3,Staff.getJob().getJobId());
			stmt.setString(4,Staff.getDetail());
			stmt.setInt(5,Staff.getStaffId());
			return stmt.executeUpdate();
		}catch(SQLException e){
			//ToDo Auto_gennerated catch block
			e.printStackTrace();
			return -1;
		}finally{
			BaseDao.closeAll(conn,stmt, rs);
		}
		
	}
	public int del(int id){
		String sql="delete from staff where staff_id=?";
		try{
			conn=BaseDao.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,id);
			return stmt.executeUpdate();
		}catch(SQLException e){
			//ToDo Auto_gennerated catch block
			e.printStackTrace();
			return -1;
		}finally{
			BaseDao.closeAll(conn,stmt, rs);
		}
		
	}

}
