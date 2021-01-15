<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Dishes</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet"/>
	<style><%@include file="./css/main.css"%></style>
</head>
<body>
	<div class="buttongroup">
		<button class="btn" onclick="location.href='dishes'">Dishes</button>
		<button class="btn" onclick="location.href='restaurants'">Restaurants</button>
	</div>
	<table>
		<tr>
			<th>ID</th> <th>Name</th> <th>Type</th> <th>Calorie</th> <th>Ingredients</th> <th>Price</th> 
		</tr>
		<tbody>
			<c:forEach items="${dishes}" var="dish">
				<tr><td> ${dish.id} </td>
				<td> ${dish.name} </td>
				<td> ${dish.cookery} </td>
				<td> ${dish.calorie} </td>
				<td> ${dish.ingredients} </td>
				<td> ${dish.cost} </td>
				<td class="td-but"> <button class="btn" onclick="location.href='addDish?edit=${dish.id}'">Update</button> </td>
				<td class="td-but"> <button class="btn" onclick="location.href='delDish?id=${dish.id}'">Delete</button> </td></tr>
			</c:forEach>
		</tbody>
	</table>
	<button class="btn btn-Add" onclick="location.href='addDish'">Add</button>
	<div class="wrapper">
		For testing purposes: 
		<button class="btn" onclick="location.href='fillTables'">Fill Tables</button>
	</div>
</body>