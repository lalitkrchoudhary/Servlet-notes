<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>DATA PAGE</h1>

<jsp:useBean id="student" class="in.lalit.bean.Student" scope="page">
 <jsp:setProperty property="id"  name="student" value='<%= Integer.parseInt(request.getParameter("id")) %>' />
 <jsp:setProperty property="name"  name="student" value='<%= request.getParameter("name")%>' />
 <jsp:setProperty property="address"  name="student" value='<%=request.getParameter("address")%>'/>
 <jsp:setProperty property="age"  name="student" value='<%=Integer.parseInt(request.getParameter("age"))%>' />
</jsp:useBean>
<center>
<table border='1px'>
<tr><th>ID</th><td><jsp:getProperty property="id" name="student" /><td/></tr>
<tr><th>NAME</th><td><jsp:getProperty property="name" name="student" /><td/></tr>
<tr><th>ADDRESS</th><td><jsp:getProperty property="address" name="student" /><td/></tr>
<tr><th>AGE</th><td><jsp:getProperty property="age" name="student" /><td/></tr>
</table>
</center>

</body>
</html>
