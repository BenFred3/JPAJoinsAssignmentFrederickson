<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet list edit</title>
</head>
<body>
	<!-- Create a form to allow the user to edit the values of the current vet. -->
	<form action = "editVetServlet" method="post">
		Vet Name: <input type = "text" name = "vetName" value= "${itemToEdit.vetName}">
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Vet">
	</form>
</body>
</html>