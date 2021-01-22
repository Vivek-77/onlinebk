<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:blue">Customer Home page</h2>
<%
String uid=session.getAttribute("userid").toString();
String dtm=session.getAttribute("logintime").toString();
%>
<h4>Logged in as : <%=uid %> at <%=dtm %></h4>
<h4>Session ID is : <%=session.getId() %></h4>
<hr>
<a href="Logout.jsp">Logout</a>
</body>
</html>