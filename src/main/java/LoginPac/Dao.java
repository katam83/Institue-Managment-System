package LoginPac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Dao {
	String DriverClass="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vishnu";
	String UserName="root";
	String pass="Katam@mysql123";
	Connection con =null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public boolean emailExists(String email)

	{
		String query="select count(*) from users where Email=?;";
		String DriverClass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/vishnu";
		String UserName="root";
		String pass="Katam@mysql123";
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName(DriverClass);
			con=DriverManager.getConnection(url,UserName,pass);
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if (rs.next() && rs.getInt(1) > 0)
			{
				return true;
			}     
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}
	public void insert(Bea B) {
	    String insertQuery = "INSERT INTO users(name, Email, Password) VALUES (?, ?, ?);";
	    try {
	        Class.forName(DriverClass);
	        con = DriverManager.getConnection(url, UserName, pass);
	        ps = con.prepareStatement(insertQuery);
	        ps.setString(1, B.getName());
	        ps.setString(2, B.getEmail());
	        ps.setString(3, B.getPassword());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	public boolean validUser(Bea B)
	{
		boolean isDataPresent=false;
		try {
			Class.forName(DriverClass);
			con=DriverManager.getConnection(url,UserName,pass);
			String que="select * from users;";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(que);
			while(rs.next())
			{
				if(B.getEmail().equals(rs.getString("Email")) && B.getPassword().equals(rs.getString("Password")))
				{
					isDataPresent=true;
					break;
				}
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDataPresent;
		
	}
	public boolean insertStudentInDataBase(Student s) {
		// TODO Auto-generated method stub
		boolean isDataPresent=false;
		try {
			Class.forName(DriverClass);
			con=DriverManager.getConnection(url,UserName,pass);
			Statement st=con.createStatement();
			String Q="select * from Student;";
			ResultSet rs=st.executeQuery(Q);
			while(rs.next())
			{
				if(rs.getLong("Mobile")==s.getMobile() || rs.getString("Email").equals(s.getEmail()))
				{
					isDataPresent=true;
					break;
				}
			}
			if(!isDataPresent)
			{
				String insertDS="insert into Student(Name,age,mobile,adress,email,course) values(?,?,?,?,?,?);";
				ps=con.prepareStatement(insertDS);
				ps.setString(1, s.getName());
				ps.setInt(2, s.getAge());
				ps.setLong(3, s.getMobile());
				ps.setString(4, s.getAddress());
				ps.setString(5, s.getEmail());
				ps.setString(6, s.getCourse());
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDataPresent;
		
		
	}
	public ArrayList<Student> getData() throws ClassNotFoundException, SQLException
	{
		Class.forName(DriverClass);
		con=DriverManager.getConnection(url,UserName,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Student;");
		ArrayList<Student> al=new ArrayList<>();
		while(rs.next())
		{
			int sid=rs.getInt("id");
			String Name=rs.getString("Name");
			int Age=rs.getInt("age");
			long Mobile=rs.getLong("mobile");
			String Address=rs.getString("adress");
			String Email=rs.getString("email");
			String Course=rs.getString("course");
			Student s=new Student(sid, Name, Age, Mobile, Address, Email, Course);
	
			al.add(s);
			
			
			
		}
		return al;
		
	}
	public Student showDataToUpdate(Student s1) {
		// TODO Auto-generated method stub
		Student s=null;
		try {
			Class.forName(DriverClass);
			con=DriverManager.getConnection(url,UserName,pass);
			ps=con.prepareStatement("select * from Student where mobile=?;");
			ps.setLong(1, s1.getMobile());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String Name=rs.getString("Name");
				int Age=rs.getInt("age");
				long Mobile=rs.getLong("mobile");
				String Adress=rs.getString("adress");
				String Email=rs.getString("email");
				String Course=rs.getString("course");
				s=new Student(Name, Age, Mobile, Adress, Email, Course);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}
	public void updateStudentData(Student s) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DriverClass);
			con=DriverManager.getConnection(url,UserName,pass);
			ps=con.prepareStatement("update Student set Name=?,age=?,mobile=?,adress=?,email=?,course=? where mobile=?;");
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setLong(3, s.getMobile());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getEmail());
			ps.setString(6, s.getCourse());
			ps.setLong(7, s.getMobile());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public boolean DeleteStu(Student s)
	{
		boolean Deleted = false;
		try {
			Class.forName(DriverClass);
			con=DriverManager.getConnection(url,UserName,pass);
			PreparedStatement ps=con.prepareStatement("delete from student where email=? ");
			ps.setString(1, s.getEmail());
			int rs=ps.executeUpdate();
			if(rs>0)
			{
				Deleted=true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Deleted;
		
	}
	
	


}
