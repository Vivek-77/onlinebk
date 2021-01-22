package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class AccountsList
 */
@WebServlet("/AccountsList")
public class AccountsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		Connection con;
		Statement st;
		ResultSet rs;
		out.println("<h2>Accounts List</h2><hr>");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartdb?user=root&password=volkswagen");
			st=con.createStatement();
			rs=st.executeQuery("select accnm from accounts;");
			
			out.println("<ul>");
			while(rs.next())
			{
				out.println("<li>"+rs.getString("accnm"));
			}
			out.println("</ul>");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
