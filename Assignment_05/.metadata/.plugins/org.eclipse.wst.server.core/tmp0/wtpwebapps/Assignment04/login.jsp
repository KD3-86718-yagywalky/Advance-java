<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<h2>Login page</h2>
		
		<jsp:useBean id="lb" class="com.sunbaeam.jsp.UserLogin" scope="session"></jsp:useBean>
		
		<jsp:setProperty property="*" name="lb"/>
		${lb.login()}
		
		<c:choose>
		<c:when test="${lb.count == 1}">
			<c:choose>
			<c:when test="${lb.u.role=='admin'}"> 
				<c:redirect url="result.jsp"/>
				</c:when>
			<c:otherwise>	
			<c:redirect url="candidateList.jsp"/>
			</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
				<h3>Login Failed</h3>
		</c:otherwise>
	</c:choose>
	
</body>
</html>