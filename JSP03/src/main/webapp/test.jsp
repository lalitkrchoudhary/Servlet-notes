<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Page Scope </h1>
<% 
   pageContext.setAttribute("p", "page");
   session.setAttribute("s", "session");
   request.setAttribute("r", "request");
   application.setAttribute("a", "applicationn");
	   
%>
<h2>The page scope in Find Atribute:: <%= pageContext.findAttribute("b") %></h2>
</body>
</html>