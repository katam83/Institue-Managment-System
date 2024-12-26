package LoginPac;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Myserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myserver() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("userpass");
        //response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(userName);
		out.println(userPassword);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String path=request.getServletPath();
		switch(path)
		{
		case"/reg":
			registerUser(request,response);
			break;
		case "/login":
			validateUser(request,response);
			break;
		case "/saveStudent":
			String action=request.getParameter("action");
			switch(action)
			{
			case "Add":
				addStudent(request,response);
				break;
			case "Display":
				try {
					displayStudentData(request,response);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Update":
				updateStudentDetails(request,response);
				break;
			case "Delete":
				DeleteStudent(request,response);
				break;
			}
			break;
		case "/saveStudentDetails":
			studentDetails(request,response);
			break;
		case "/showStudentData":
			showStudentData(request,response);
			break;
		case "/updateStudentData":
			updateStudentData(request,response);
			break;
		case "/DeleteStudentDetails":
			DeleteStudentDetails(request,response);
			break;
		}
		
	}
	private void DeleteStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String Email=request.getParameter("Dname");
		Student s=new Student(Email);
		Dao d=new Dao();
		boolean boss=d.DeleteStu(s);
		if(boss)
		{
			request.setAttribute("Delete", "Deleted Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("Delete.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("Delete", "No record found with the given email.");
			RequestDispatcher rd=request.getRequestDispatcher("Delete.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	private void DeleteStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("Delete.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void updateStudentData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String Name=request.getParameter("txtName");
		int Age=Integer.parseInt(request.getParameter("txtAge"));
		long Mobile=Long.parseLong(request.getParameter("txtMobile"));
		String Address=request.getParameter("txtAddress");
		String Email=request.getParameter("txtEmail");
		String Course=request.getParameter("txtCourse");
		Student s=new Student(Name, Age, Mobile, Address, Email, Course);
		Dao d = new Dao();
		d.updateStudentData(s);
		request.setAttribute("message", "Updated SuccessFully");
		RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	private void showStudentData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		long mobile=Long.parseLong(request.getParameter("txtMobile"));
		Student s=new Student(mobile);
		Dao d=new Dao();
		Student s1=d.showDataToUpdate(s);
		if(s1!=null)
		{
			request.setAttribute("student data", s1);
			RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("student data", "Invalid mobile number");
			RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	}
	private void updateStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("Update.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void displayStudentData(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		Dao d=new Dao();
		ArrayList<Student> alist=d.getData();
		request.setAttribute("student list", alist);
		RequestDispatcher rd=request.getRequestDispatcher("Display.jsp");
		rd.forward(request, response);
		
		
		
		
	}
	private void studentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name=request.getParameter("Sname");
		int Age=Integer.parseInt(request.getParameter("Sage"));
		long Mobile=Long.parseLong(request.getParameter("Snumber"));
		String Address=request.getParameter("Saddress");
		String Email=request.getParameter("Smail");
		String Course=request.getParameter("Scourse");
		Student s=new Student(Name,Age,Mobile,Address,Email,Course);
		Dao d=new Dao();
		boolean isDataPresent=d.insertStudentInDataBase(s);
		if(isDataPresent)
		{
			request.setAttribute("message", "Mobile number or Email is already exist");
			RequestDispatcher rd=request.getRequestDispatcher("StudentInsert.jsp");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("StudentInsert.jsp");
		}
		
	}
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("StudentInsert.jsp");
		
	}
	private void validateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String userMail=request.getParameter("name");
		String password=request.getParameter("pass");
		Bea B=new Bea(userMail,password);
		Dao d=new Dao();
		boolean isDataPresent=d.validUser(B);
		if(isDataPresent)
		{
			response.sendRedirect("Home.jsp");
		}
		else
		{
			request.setAttribute("message", "User does not exist");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String name=request.getParameter("Uname");
		String email=request.getParameter("Umail");
		String password=request.getParameter("Upass");
		Bea B=new Bea(name,email,password);
		Dao d=new Dao();
		//PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(d.emailExists(email))
		{
			//pw.println("\"<h3 style='color:red;'>This email is already registered!</h3>\"");
			response.sendRedirect("login.jsp");
		}
		else
		{
			d.insert(B);
			//pw.println("<h3 style='color:green;'>Registration successful!</h3>");
			request.setAttribute("message", "Email is already exists");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
