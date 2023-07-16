<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
  String contextPath = request.getContextPath();
%>
<nav class="navbar-dark bg-dark">
	<div class="navbar navbar-expand navbar-dark">
		<a class="navbar-brand" href="<%= contextPath %>/owner/home"> Housing </a>
		<div class="dropdown">
			<security:authorize access="hasAuthority('Owner')">
				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    	${sessionScope.account}
				</button>
			</security:authorize>
		    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		      <a class="dropdown-item" href="/springblog/logout">Log Out</a>
		    </div>
		</div>
		<div class="d-flex justify-content-right">
			<security:authorize access="!hasAuthority('Owner')">
				<a class="btn btn-primary" href="<%= contextPath %>/owner/create">Sign Up</a>
			</security:authorize>
		</div>
	</div>
</nav>
