<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "userRegistration.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<h2>Edit Employee Details</h2>
	<form action="EditUser" method="post">
		<%
			User u = (User) request.getAttribute("user");
		%>

		<table style="boarder-width: 0px">
		<tr>
				<td><label for="id">ID:</label></td>
				<td><input type="text" id="id" name="id"
				value="<%=u.getId()%>"></td>
				
			</tr>
			<tr>
				<td><label for="Name">Name:</label></td>
				<td><input type="text" id="Name" name="Name"
				value="<%=u.getName()%>"></td>
			</tr>
			<tr>
				<td><label for="Email"> Email :</label></td>
				<td><input type="text" id="Email" name="Email" 
				value="<%=u.getEmail()%>"></td>
			</tr>
			<tr>
				<td><label for="Phonenum"> PhoneNumber :</label></td>
				<td><input type="text" id="Phonenum" name="Phonenum"
				value="<%=u.getPhonenum()%>"></td>
			</tr>
			<tr>
				<td><label for="Country"> Country :</label></td>
				<td><input type="text" id="Counttry" name="Country"
				value="<%=u.getCountry()%>"></td>
			</tr>
		</table>
		<input type="submit" value="Save Student">
	</form>
</body>
</html>