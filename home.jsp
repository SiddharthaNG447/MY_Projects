<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
 <style>
	body{
	   background:gray;
	
	   }
	  h2{
     background-color:red;
	 font-size:40px;
	 color:black;
        }	 
  </style>
	
</head>
<body>

<center>
<h2>Registration Forn</h2>

<form:form action="save" method="post" modelAttribute="reg">
		<table>
			
			<tr>
				<td>Name:</td>
				<td><form:input path="nm" placeholder="enter your name"/></td>
			</tr>
			
			<tr>
				<td>Gender:</td>
				<td><form:input path="gender" placeholder="enter your gender" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
</body>
</html>

























</body>
</html>
