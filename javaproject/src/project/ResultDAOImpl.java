package project;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import project.ResultDAO;
import project.Result;
import project.ConnectionManager;

public class ResultDAOImpl implements ResultDAO {
	private Connection connection=ConnectionManager.getConnection();
	@Override
	public void addStudent(Result r)
	{
		try {
			CallableStatement call = connection.prepareCall("{?=call student}");
			call.registerOutParameter(1, Types.INTEGER);
			call.execute();
			int id1=call.getInt(1);
			System.out.println(id1);
			String sql="Insert into Result values( ?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id1);
			ps.setString(2, r.getFname());
			ps.setString(3, r.getLname());
			
			ps.setString(4, r.getCourse());
			ps.setString(5, r.getResult());
			int res=ps.executeUpdate();
			if (res==1)
			{
				System.out.println("Student added");
				
				
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public void searchStudent(String fname) {
		// TODO Auto-generated method stub
		String sql="select * from result where fname =?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, fname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void FailedStudent() {
		// TODO Auto-generated method stub

		String sql="select * from result where result ='fail'";

		try {
			Statement conn=connection.createStatement();

			ResultSet rs=conn.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Result> listAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteStudent(int id) {
		String sql="Delete from Result where rollno=?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id);

			int rs1=ps.executeUpdate();
			if (rs1==1)
			{
				System.out.println("Student deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



}
