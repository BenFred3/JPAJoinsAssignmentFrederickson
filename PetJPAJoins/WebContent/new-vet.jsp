<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Vet</title>
</head>

<body>
<!-- Create a form to allow the user to add to the vet database. -->
<form action = "addNewVetServlet" method="post">
	Vet Name: <input type ="text" name = "vetName"><br />
	<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
			<td><input type="radio" name="petID" value="${currentitem.petID}">${currentitem.petID}</td>
		</tr>
	</c:forEach>
	<br /><br />
	<input type = "submit" value="Create Vet">
</form>
<br />
<a href = "index.html">Add a new pet instead</a>
</body>
</html>