<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Candidate</title>
</head>
<body>
	<jsp:useBean id="up" class="com.sunbaeam.jsp.UpdateCandidateBean" />
	<jsp:setProperty name="up" property="*" />
	${up.updateCandidate()}
	
	<c:choose>
	<c.when test="${up.count !=1 }" >
		<c:forword page="result.jsp" >
		<c:param name="msg" value="Candidate Updated Successfully." />
		</c:forword>
		
	</c.when>
	<c:otherwise>
	<c:forward page="result.jsp">
				<c:param name="msg" value="Candidate Update Failed." />
			</c:forward>	
	</c:otherwise>
	</c:choose>

</body>
</html>