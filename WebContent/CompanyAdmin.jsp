<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:purple">Company Admin Page</h2>
<%
String uid=session.getAttribute("userid").toString();
String dtm=session.getAttribute("logintime").toString();
%>
<h4>Logged in as : <%=uid %> at <%=dtm %></h4>
<hr>
<a href="BankAccountsReport.jsp">Accounts Report</a> | 
<a href="Logout.jsp">Logout</a> 
<br>
<a href="SearchAccountType.jsp?typ=saving">Saving</a> | 
<a href="SearchAccountType.jsp?typ=fixed">Fixed</a> | 
<a href="SearchAccountType.jsp?typ=current">Current</a>
</body>
</html>




