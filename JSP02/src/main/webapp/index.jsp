<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Here we count only the no of user entering to the website</h1>
<%
Integer count=(Integer)application.getAttribute("usercount");
if(session.isNew()){
	if(count == null)
		count = 1;
	else 
		count++;
	
}
application.setAttribute("usercount", count);
%>
<h2>The number of user entering to the browser is:: <%=count %></h2>
</body>
</html>