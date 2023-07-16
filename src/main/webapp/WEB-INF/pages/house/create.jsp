<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container py-5">
		<h3 class="mb-3">Create House</h3>
		<c:url value="/house/create/save" var="createHouse"></c:url>
		<form:form method="POST" modelAttribute="houseCreate" action="${createHouse}">
			<div class="row mb-3">
				<div class="form-group mb-3 col-5">
					<form:label path="housingName" cssClass="mb-1">Housing Name</form:label>
					<form:input path="housingName" class="form-control"
						placeholder="Enter Housing Name" />
					<form:errors path="housingName" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3 col-5">
					<form:label path="address" cssClass="mb-1">Address</form:label>
					<form:input path="address" class="form-control"
						placeholder="Enter Address" />
					<form:errors path="address" cssClass="text-danger"></form:errors>
				</div>
			</div>
			
			<div class="row mb-3">
				<div class="form-group mb-3 col-5">
					<form:label path="numberOfFloor" cssClass="mb-1">Floor</form:label>
					<form:input path="numberOfFloor" class="form-control"
						placeholder="Enter number of floors"/>
					<form:errors path="numberOfFloor" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3 col-5">
					<form:label path="numberOfMasterRoom" cssClass="mb-1">Master Room</form:label>
					<form:input path="numberOfMasterRoom" class="form-control"
						placeholder="Enter number of master rooms" />
					<form:errors path="numberOfMasterRoom" cssClass="text-danger"></form:errors>
				</div>
			</div>
			
			<div class="row mb-3">
				<div class="form-group mb-3 col-5">
					<form:label path="numberOfSingleRoom" cssClass="mb-1">Single Room</form:label>
					<form:input path="numberOfSingleRoom" class="form-control"
						placeholder="Enter number of single rooms"/>
					<form:errors path="numberOfSingleRoom" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3 col-5">
					<form:label path="amount" cssClass="mb-1">Amount</form:label>
					<form:input path="amount" class="form-control"
						placeholder="Enter amount" />
					<form:errors path="amount" cssClass="text-danger"></form:errors>
				</div>
			</div>
			<button type="submit" class="btn btn-primary rounded-0">Create</button>
		</form:form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>