<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
		<h2>Register page</h2>
		
		<jsp:useBean id="cb" class="com.sunbaeam.jsp.Registration"></jsp:useBean>
		
		<jsp:setProperty property="*" name="cb"/>
		${cb.saveUser()}
		
		<c:choose>
		<c:when test="${cb.u == 1}">
			<h3>Registration Successful</h3>m
		</c:when>
		<c:otherwise>
				<h3>Registration Failed</h3>
		</c:otherwise>
	</c:choose>
		
	
</body>
</html>