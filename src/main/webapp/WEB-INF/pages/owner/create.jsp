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
		<h3 class="mb-3">Create Owner</h3>
		<c:url value="/owner/create/save" var="createOwner"></c:url>
		<form:form method="POST" modelAttribute="ownerCreate" action="${createOwner}">
			<div class="row mb-3">
				<div class="form-group mb-3 col-5">
					<form:label path="ownerUserName" cssClass="mb-1">Your Name</form:label>
					<form:input path="ownerUserName" class="form-control"
						placeholder="Enter User Name" />
					<form:errors path="ownerUserName" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3 col-5">
					<form:label path="ownerName" cssClass="mb-1">Owner Name</form:label>
					<form:input path="ownerName" class="form-control"
						placeholder="Enter Owner Name" />
					<form:errors path="ownerName" cssClass="text-danger"></form:errors>
				</div>
			</div>
			
			<div class="row mb-3">
				<div class="form-group mb-3 col-5">
					<form:label path="email" cssClass="mb-1">Your email</form:label>
					<form:input path="email" class="form-control"
						placeholder="Enter email" type="email" />
					<form:errors path="email" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group mb-3 col-5">
					<form:label path="password" cssClass="mb-1">Your Password</form:label>
					<form:input path="password" class="form-control"
						placeholder="Enter Your Password" />
					<form:errors path="password" cssClass="text-danger"></form:errors>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary rounded-0">Create</button>
		</form:form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>