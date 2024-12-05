<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<h2>Login page</h2>
		
		<jsp:useBean id="cb" class="com.sunbaeam.jsp.UserLogin"></jsp:useBean>
		
		<jsp:setProperty property="*" name="cb"/>
		${cb.login()}
		
		<c:choose>
		<c:when test="${cb.count == 1}">
			<c:redirect url="candidateList.jsp"/>
		</c:when>
		<c:otherwise>
				<h3>Login Failed</h3>
		</c:otherwise>
	</c:choose>
		
	
</body>
</html>