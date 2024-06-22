<%@   taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>It is for c:out </h1>
<c:out value="Welcome to the jungle"></c:out></br>
The user name is:: <c:out value="${param.user }" default="lalit"></c:out></br>
The user password is :: <c:out value="${param.pass }" default="guest" />



<h1>It is for c:set </h1>
<c:set var="x"  value="10" scope="request"></c:set>
<c:set var="y" value ="20" scope="request" />
<c:set var="sum" value="${x+y }" scope="session"/>
<h2> The result is :: <c:out value=" ${sum}" /> </h2></br>



<h1> It is for c:remove</h1>
<c:remove var="sum"/>
<h2> The resut after removing is :: <c:out value="${sum}" default="0000" /></h2>



<h1>It is for c:if</h1>
//if the conditionn evaluates to true only then body of "if" will be execute
//otherwise the reamining statement present in jsp page will be executed.	 
<c:set var="x" value="10"></c:set>
<c:set var="y" value ="20" />
<c:if test="${x<y }" var ="result">
<c:out value="${x }"/></br>
<c:out value="${result }"/>
</c:if>



<h1> It is for c:choose, c:when, c:otherwise</h1>
//we use these tag for implementing if else and switch statements.
// example demonstrate in index.jsp file in JSTL01	

</body>
</html>