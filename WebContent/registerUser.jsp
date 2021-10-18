<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register user</title>
</head>
<body>
<form action="RegisterUser" method="post">
		<table style="boarder-width: 0px">
		<!--  TODO enable logger  -->
		<!--  TODO Id should be auto generate -->
		<%-- String nextId =  request.getAttribute("nextId").toString(); --%>
		<%int nextId =  19; %>
		<!--  TODO Id should be read only -->
			<tr>
				<td><label for="id"> ID:</label></td>
				<td><input type="text" id="id" name="id" readonly="readonly" value="<%=nextId %>"></td>
			</tr>
			<tr>
				<td><label for="Name">Name:</label></td>
				<td><input type="text" id="Name" name="Name" style="border: 1px solid red"> 
					<%= (request.getAttribute("userError")!=null) ? "Username Mandatory" : "" %>
				</td>
			</tr>
			<tr>
				<td><label for="Email"> Email :</label></td>
				<td><input type="text" id="Email" name="Email" ></td>
			</tr>
			<tr>
				<td><label for="Phonenum"> Phone Number :</label></td>
				<td><input type="text" id="Phonenum" name="Phonenum"></td>
			</tr>
			<tr>
				<td><label for="Country"> Country :</label></td>
				<td><input type="text" id="Country" name="Country"></td>
			</tr>
		</table>
		<input type="submit" value="Add User"> 
		</form>
</body>
</html>