<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Account Search Result</h2>
<hr>
<a href="CompanyAdmin.jsp">Home</a>
<br>
<table width="500px" cellspacing="0" border="1">
<tr style="background-color:seashell">
<th>Account Number
<th>Name
<th>Type
<th>Balance
</tr>
<%
String ty=request.getParameter("typ");

Connection con;
PreparedStatement pst;
ResultSet rs;

try
{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartdb?user=root&password=volkswagen");
		pst=con.prepareStatement("select * from accounts where acctype=?;");
		pst.setString(1,ty);
		rs=pst.executeQuery();
		
		while(rs.next())
		{
			%>
		<tr>
		<td><%=rs.getString("accno")%>
		<td><%=rs.getString("accnm")%>
		<td><%=rs.getString("acctype")%>
		<td><%=rs.getString("balance")%>
		</tr>
<%
		}
con.close();
}
catch(Exception e)
{
out.println(e);
}
%>

</table>

</body>
</html>