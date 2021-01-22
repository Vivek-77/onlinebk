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
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		int no=Integer.parseInt(request.getParameter("ano"));
		
		Connection con;
		PreparedStatement pst;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartdb?user=root&password=volkswagen");
			pst=con.prepareStatement("delete from accounts where accno=?;");
			pst.setInt(1, no);
			pst.executeUpdate();
			out.println("<h3>account deleted successfully");
			out.println("<hr><a href='CompanyAdmin.jsp'>Home</a>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}







