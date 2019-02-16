<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Pet's Vets</title>
</head>

<body>
	<!-- Create a form to display the information from the vet database, and allow the user to edit or delete it. -->
	<form method = "post" action = "navigationVetServlet">
		<table>
			<c:forEach items="${requestScope.allVets}" var="currentvet">
				<tr>
				<td><input type="radio" name="id" value="${currentvet.id}"></td>
				<td>${currentvet.vetName} (ID: ${currentvet.id})</td></tr>
				<tr><td> Pet- </td></tr>
				<tr><td colspan="3">Pet ID: ${currentvet.pet.petID}</td></tr>
				<tr><td colspan="3">Type: ${currentvet.pet.type}</td></tr>
				<tr><td colspan="3">Owner: ${currentvet.pet.owner}</td></tr>
				<tr><td colspan="3">Name: ${currentvet.pet.name}</td></tr>
			</c:forEach>
		</table>
		<br />
		<input type = "submit" value = "edit" name="doThisToItem">
		<input type = "submit" value = "delete" name="doThisToItem">
	</form>
	<!-- Links to return to each page. -->
	<p><a href="addVetServlet">Add a new vet</a></p>
	<p><a href="viewAllPetsServlet">View all the pets</a></p>
	<p><a href="index.html">Insert a new pet</a></p>
 </body>
</html>