<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">

<h2>Add a New User </h2>
<center>
<div style="height: 300px; width: 300px; border: solid; align-self: center; margin: 10px" >

<form action="register.jsp" method="post">
<p style="margin: 20px;">
First Name : <input type="text" name="fname" placeholder="FirstName"> <br/><br/>
Last Name : <input type="text" name="lname" placeholder="LastName"> <br/><br/>
Email : <input type="email" name="email" placeholder="abc@gmail.com"> <br/><br/>
Password : <input type="password" name="passwd" placeholder="Password"> <br/><br/>
DOB : <input type="date" name="dob" placeholder="date"> <br/><br/>
<input type="submit" value="Register"> <br/><br/>
</p >
</form>
</div>

</body>
</html>