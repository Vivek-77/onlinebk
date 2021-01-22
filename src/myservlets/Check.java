package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		// TODO Auto-generated method stub
		String id,ps,typ,dt;
		PrintWriter out=response.getWriter();
		
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		dt=request.getParameter("logdt");
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartdb?user=root&password=volkswagen");
		pst=con.prepareStatement("select * from users where userid=? and pswd=?;");
		pst.setString(1, id);
		pst.setString(2,ps);
		rs=pst.executeQuery();
		
		if(rs.next())
		{
			HttpSession ses=request.getSession(true);
			ses.setAttribute("userid", id);
			ses.setAttribute("logintime", dt);
			
			typ=rs.getString("usertype");
			if(typ.equals("customer"))
				response.sendRedirect("User.jsp");
		
			if(typ.equals("admin"))
				response.sendRedirect("CompanyAdmin.jsp");
				
			
		}
		else
			response.sendRedirect("Failure.jsp");;
			
			con.close();	
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
