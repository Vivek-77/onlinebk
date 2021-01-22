package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RememberChoice
 */
@WebServlet("/RememberChoice")
public class RememberChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RememberChoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nm,cho;
		PrintWriter out=response.getWriter();
		nm=request.getParameter("unm");
		cho=request.getParameter("comp");
		
		Cookie c1=new Cookie("choice",cho);
		c1.setMaxAge(30);
		response.addCookie(c1);
		
		out.println("Cookies written to client browser");
		
	}

}










