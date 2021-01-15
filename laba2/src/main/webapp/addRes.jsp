<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add Restaurants</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<!--<link rel="stylesheet" href="css/main.css">-->
	<style><%@include file="./css/main.css"%></style>
</head>
<body>
	<div class="form">
		<h2>Add/Edit Restaurant</h2>
		<form:form action="addRes" method="post" modelAttribute="restaurant">
			<form:hidden path="id"/>
			<form:input path="name" cssClass="input-dish" placeholder="Restaurant's Name" required="required" maxlength="255"/>
			<form:input path="cookery" cssClass="input-dish" placeholder="Restaurant's Type" required="required" maxlength="255"/>
			<form:input path="address" cssClass="input-dish" placeholder="Address" required="required" maxlength="255"/>
			<form:label cssClass="label-form" path="dishesId">List of dishes</form:label>
			<form:select path="dishesId" multiple="true" required="required">
				<form:options items="${dishes}" itemValue="id" itemLabel="name"/>
			</form:select>
			<div class="buttongroup buttongroup-form">
				<button class="btn" type="submit">Confirm</button>
				<button class="btn" onclick="location.href='restaurants'">Cancel</button>
			</div>
		</form:form>
	</div>
</body>