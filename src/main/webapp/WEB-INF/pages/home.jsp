<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container py-5">
		<div class="d-flex justify-content-between">
			<c:url var="ownerHome" value="/owner/home"></c:url>
			<h3>Housing List <a href="${ownerHome}"></a></h3>
			<div>
				<c:url var="searchHouse" value="/owner/search" />
				<form action="${searchHouse}" method="GET" class="d-flex">
					<input type="text" name="keyword" class="form-control"
						placeholder="Search....." />
					<button type="submit" class="btn btn-success ml-3">Search</button>
				</form>
			</div>
		</div>
		
		<div class="table-responsive py-5">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Housing Name</th>
					<th>FLoor</th>
					<th>Master Room</th>
					<th>Single Room</th>
					<th>Address</th>
					<th>Amount</th>
				</tr>
				<c:forEach items="${houses}" var="house">
					<tr>
						<td>${house.housingName}</td>
						<td>${house.numberOfFloor}</td>
						<td>${house.numberOfMasterRoom}</td>
						<td>${house.numberOfSingleRoom}</td>
						<td>${house.address}</td>
						<td>${house.amount}</td>
					</tr>
					
					
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>