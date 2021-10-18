<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import = "userRegistration. model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Display Users</title>
</head>
<style>
<body>
body {
  background-color: pink;
}
h2 {
  color: yellow;
  text-align: center;
}

table, th, td   {
  border: 1px solid blue;
  border-collapse: collapse;
  
}
th, td {
  padding: 15px;
  text-align: left;
}
#User td, #User th {
  border: 1px solid #ddd;
  padding: 8px;
}

#User th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: Lightgreen;
  color: red;
}

</style>
</head>
<body>
<div>
<%
	String UserAddMsg = (String)request.getAttribute("UserAddMsg");
	if(null!= UserAddMsg){
 %>
	<%= UserAddMsg %>
<%} %>
</div>


<div>
<%
	String UserUpdateMsg = (String)request.getAttribute("user");
	if(null!= UserUpdateMsg){
 %>
	<%= UserUpdateMsg %>
<%} %>
</div>
<h2>LIST OF Users</h2>
<div>
	<a href="userreg?action=add"> Add User</a>
</div>

  <table style="width:100%" id = "User" >
  <tr>
    <th>ID</th>
    <th>NAME</th> 
    <th>EMAIL</th>
    <th>PHONE NUMBER</th>
    <th>COUNTRY</th>
    <th> ACTION </th>
  </tr>
    <% 
    List<User> listUser = (List<User>) request.getAttribute("listUsers");
    if(null != listUser){
    for ( User u : listUser ) { %>
    <tr>
        <td><%= u.getId() %> 		</td>
        <td><%= u.getName() %> 		</td>
		<td><%= u.getEmail() %>		</td>
		<td><%= u.getPhonenum() %>		</td>
		<td><%= u.getCountry() %>		</td>
		<td><a href="/UserRegistration/RemoveUser?id=<%= u.getId()%>" > Delete </a>&nbsp;<a href="/UserRegistration/GetUser?id=<%= u.getId()%>" > Edit </a></td>
    </tr>
    <% } %>
    <% } %>
    </table>


</body>
</html>