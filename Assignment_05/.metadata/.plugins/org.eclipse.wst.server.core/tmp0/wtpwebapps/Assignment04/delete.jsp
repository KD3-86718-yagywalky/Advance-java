<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>
		<jsp:useBean id="dc" class="com.sunbaeam.jsp.DeleteCandidate" />
		<jsp:setProperty name="dc" property="candId" param="id" />
		${dc.deleteCandidate()}
		
		<c:choose>
		 	<c:when test="${dc.count==1}" >
		 	<c:redirect url="result.jsp" />
		 	</c:when>
		 	<c:otherwise>
		 		<h1>failed to delete</h1>	
		 	</c:otherwise>
		
		</c:choose>
</body>
</html>