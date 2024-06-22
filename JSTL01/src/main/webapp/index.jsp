<%@page import="java.util.ArrayList"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 %>
 
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<form action="./index.jsp" method="get">
<select  name="combo">
<option value='1'>1</option>
<option value='2'>2</option>
<option value='3'>3</option>
<option value='4'>4</option>
<option value='5'>5</option>
<option value='6'>6</option>
<option value='7'>7</option>
<option value='8'>8</option>
<option value='9'>9</option>
</select>
<input type="submit" value="sub" />
</form>
</h1>

<c:set var="day" value="${param.combo }"/>
<c:choose>
     <c:when test="${day==1 }">
          SUNDAY
	 </c:when>
	     <c:when test="${day==2 }">
          MONDAY
	 </c:when>
	     <c:when test="${day==3 }">
          TUESDAY
	 </c:when>
	     <c:when test="${day==4 }">
          WEDNESDAY
	 </c:when>
	     <c:when test="${day==5 }">
	     THRUSDAY
	 </c:when>
	     <c:when test="${day==6 }">
          FRIDAY
	 </c:when>
	     <c:when test="${day==7 }">
          SATURDAY
          </c:when>
      <c:otherwise>
      Enter the day between 1 to 7
      </c:otherwise>
          
	
</c:choose>


</br>

//using array list we are fetching data using for each loop in jstl

<%
 ArrayList<String> al= new ArrayList<String>();
al.add("lalit");
al.add("rahul");
al.add("saurav");
al.add("lokesh");
pageContext.setAttribute("names",al );	
%>
<c:forEach items="${names}" var="name">
<h1>${name}</h1>
</c:forEach>

</body>
</html>