<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
td
{
font-family:tahoma;
font-size:13px;
color:darkblue;
}
a
{
color:green;
}
a:hover
{
color:red;
}
</style>
</head>
<body>
<%
if(session.getAttribute("userid")==null)
{
	out.println("<h3>invalid session..please login</h3>");
}
else
{
%>
<h2>Accounts Report</h2>
<hr>
<a href="CompanyAdmin.jsp">Home</a>
<br>
<table width="500px" cellspacing="0" border="1">
<tr style="background-color:seashell">
<th>Account Number
<th>Name
<th>Type
<th>Balance
<th>Action
</tr>
<%
Connection con;
Statement st;
ResultSet rs;
String no;

try
{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartdb?user=root&password=volkswagen");
		st=con.createStatement();
		rs=st.executeQuery("select * from accounts;");
		
		while(rs.next())
		{
			no=rs.getString("accno");
			%>
		<tr>
		<td><%=no%>
		<td><%=rs.getString("accnm")%>
		<td><%=rs.getString("acctype")%>
		<td><%=rs.getString("balance")%>
		<td><a href="DeleteAccount?ano=<%=no%>">Delete</a>
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
<%
}
%>
</body>
</html>