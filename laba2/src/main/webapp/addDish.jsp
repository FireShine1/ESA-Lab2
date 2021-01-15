<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add Dish</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<style><%@include file="./css/main.css"%></style>
</head>
<body>
	<div class="form">
		<h2>Add/Edit Dish</h2>
		<form:form action="addDish" method="post" modelAttribute="dish">
			<form:hidden path="id"/>

			<form:input path="name" class="input input-dish" placeholder = "Dish's Name" required="required" maxlength="255"/>

			<form:input path="cookery" class="input input-dish" placeholder = "Dish's Type" required="required" maxlength="255"/>

			<form:input path="calorie" class="input input-dish" placeholder = "Calorie" required="required" pattern="[0-9]*\.?[0-9]*"/>
				
			<form:input path="ingredients" class="input input-dish" placeholder = "Ingredients" required="required" maxlength="1024"/>
			
			<form:input path="cost" class="input input-dish" placeholder = "Price" required="required" pattern="[1-9][0-9]*\.?[0-9]*"/>
			<div class="buttongroup buttongroup-form">
				<button class="btn" type="submit">Confirm</button>
				<button class="btn" onclick="location.href='dishes'">Cancel</button>
			</div>
		</form:form>
	</div>
</body>