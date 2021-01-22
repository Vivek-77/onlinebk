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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id,ps,nm,gn,mo,em,ct,sq,an;
		int ag;
		Connection con;
		PreparedStatement pst;
		PrintWriter out=response.getWriter();
		
		try
		{
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		nm=request.getParameter("unm");
		ag=Integer.parseInt(request.getParameter("age"));
		gn=request.getParameter("gender");
		mo=request.getParameter("mob");
		em=request.getParameter("email");
		ct=request.getParameter("ct");
		sq=request.getParameter("ques");
		an=request.getParameter("ans");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartdb?user=root&password=volkswagen");
		pst=con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,default,?,?);");
		pst.setString(1, id);
		pst.setString(2, ps);
		pst.setString(3, nm);
		pst.setInt(4, ag);
		pst.setString(5, gn);
		pst.setString(6, mo);
		pst.setString(7, em);
		pst.setString(8, ct);
		pst.setString(9, sq);
		pst.setString(10, an);
		
		pst.executeUpdate();
		con.close();
		response.sendRedirect("RegSuccess.jsp");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
