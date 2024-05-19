<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP page for tracking how many user hit the request 
</h1>

<%
Integer count = (Integer) application.getAttribute("hitcount");
		if(count==null)
			count =1;
else
	count++;
		application.setAttribute("hitcount", count);
%>

<h2>The hit count is ::  <%= count %></h2>
</body>
</html>