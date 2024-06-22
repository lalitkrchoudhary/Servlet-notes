<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Using sql in jstl with little different syntax</h1>

<sql:setDataSource var="ds" url="jdbc:mysql:///apple" driver="com.mysql.cj.jdbc.Driver"
user="root" password="lalit"/>

<sql:query var="result" dataSource="${ds}">
select * from student
</sql:query>

<h1>
<c:forEach items="${result.rows}" var="row">
${row.std_id} ---- ${row.std_name} ---- ${row.marks} ---- ${row.tech} </br>
</c:forEach>
</h1>



</body>
</html>