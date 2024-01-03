package bloodysweet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
			response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				String name=request.getParameter("name");
				String pass=request.getParameter("pass");
				Cookie c=new Cookie("fullname", name);
				response.addCookie(c);
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","pass123");
					Statement st=con.createStatement();
					String query="select * from login where name='"+name+"' and Pass='"+pass+"'";
					ResultSet ab=st.executeQuery(query);
					if(ab.next()) {
						out.print("<b>WELCOME</b>"+name);
						RequestDispatcher s1=request.getRequestDispatcher("bloodprofile.jsp");
						s1.include(request, response);
					}
					else {
						out.print("<script>alert('username and password incorrect!')</script>");
						RequestDispatcher s1=request.getRequestDispatcher("login.jsp");
						s1.include(request, response);
						
					}
					
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		
		
		
			}

}
