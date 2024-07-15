package in.lalit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.lalit.dto.Student;
import in.lalit.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	
    Connection connection = null;
    
    
	@Override
	public String save(Student student) {
		 String sqlInsertQuery="insert into students(`sname`,`sage`,`sadd`) values(?,?,?)";
		
		 PreparedStatement pstmt=null;
		 String status=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlInsertQuery);
			if(pstmt!=null) {
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSadd());
				}
			
			
			if(pstmt!=null) {
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1) {
				 status="success";	
				}else {
					status="failure";
				}
			}
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		String sqlSelectQuery="select sid, sname, sage,sadd from students where sid=? ";
		
		 PreparedStatement pstmt=null;
		 String status=null;
		 Student student = null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlSelectQuery);
			if(pstmt!=null) {
			      pstmt.setInt(1, sid);
			      
				}
			
			
			if(pstmt!=null) {
			ResultSet resultSet= pstmt.executeQuery();
			if (resultSet.next()) {
				//copy the resultSet data to StudentDto and Transfer to the view
				
				//create an pbject to send the data of resultset throught the student object
				student = new Student();
				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSadd(resultSet.getString(4));
				
			}
			}
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="failure";
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery="update students set sname=?, sage=?, sadd=? where sid=?";
		
		 PreparedStatement pstmt=null;
		 String status=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlUpdateQuery);
			if(pstmt!=null) {
				
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSadd());
				pstmt.setInt(4 , student.getSid());
				
				}
			
			
			if(pstmt!=null) {
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1) {
				 status="success";	
				}else {
					status="failure";
				}
			}
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		 String sqlDeleteQuery="delete from students where sid=?";
		 PreparedStatement pstmt=null;
		 String status=null;
		try {
			Student student = findById(sid);
			
			if (student != null) {
				
				connection=JdbcUtil.getJdbcConnection();
				if(connection!=null)
					pstmt=connection.prepareStatement(sqlDeleteQuery);
				if(pstmt!=null) {
					pstmt.setInt(1, sid);
				}
				
				
				if(pstmt!=null) {
					int rowAffected=pstmt.executeUpdate();
					if(rowAffected==1) {
						status="success";	
					}
				}
			}
			else {
				status="not available";
			}
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

}
