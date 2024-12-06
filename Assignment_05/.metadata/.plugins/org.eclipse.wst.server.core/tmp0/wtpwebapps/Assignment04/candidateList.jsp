<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Candidate List </h1>
	
	<jsp:useBean id="as" class="com.sunbaeam.jsp.ResultList"></jsp:useBean>
	${as.getAllCandidate()}
	
	<form action="vote.jsp" method="post">
	<c:forEach var="c" items="${as.candlist}">
	<input type="radio" name="candidate" value="${c.id}" /> ${c.name} ----- ${c.party}<br/>
	</c:forEach>
	
	<input type="submit" value="Vote">
	</form>
</body>
</html>