package bloodysweet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String email=request.getParameter("mail");
		String blood=request.getParameter("selectblood");
		String pass=request.getParameter("pass");
		String loca=request.getParameter("Donerlocation");
		String phone=request.getParameter("phone");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","pass123");
			PreparedStatement ps=con.prepareStatement("insert into login(name,pass,Age,Email,Address,Blood,Phone) values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2,age );
			ps.setString(3, email);
			ps.setString(4, blood);
			ps.setString(5, pass);
			ps.setString(6, loca);
			ps.setString(7, phone);
			int ab=ps.executeUpdate();
			if(ab>0)
			{
				out.print("<script>alert('Added Successfully')</script>");
//				RequestDispatcher s=request.getRequestDispatcher("Frontpage.jsp");
//				s.include(request, response);
				
			}else {
				out.print("<script>alert('Something wrong')</script>");
				RequestDispatcher s=request.getRequestDispatcher("Frontpage.jsp");
				s.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
	}

	
	

	}
}
