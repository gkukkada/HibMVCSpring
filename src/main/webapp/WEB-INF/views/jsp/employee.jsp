<%@page import="com.java.hibernate.core.entity.Employee"%>
<jsp:include page="../basepartials/base.jsp" flush="true"></jsp:include>
<jsp:include page="../basepartials/navbar.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<body>
	<div class="container report topmargin">
		<a href="${contextPath}/id" type="button" id="back"
			class="btn btn-success"><span
			class="glyphicon glyphicon-arrow-left" aria-hidden="true"> </span>
			Back</a>

		<div class="alert alert-success hidden">
			<h4>Employee record removed Successfully.</h4>
		</div>

		<h2>Employee Details</h2>
		<button id="add" class="add btn btn-sm btn-primary">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"> </span>
			Add
		</button>
		<!-- <form action="deleteEmployee" method="POST"> -->
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>Remove</th>
					<th>Edit/Update</th>
					<th>Employee ID</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Age</th>
					<th>Address</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empObj ne null}">
					<tr>
						<td><button id="remove" class="btn btn-sm btn-danger"
								data-toggle="modal" data-target="#modal">
								<span class="glyphicon glyphicon-remove" aria-hidden="true">
								</span> Remove
							</button></td>
						<td><button id="edit" class="btn btn-sm btn-primary disabled">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true">
								</span> Edit
							</button></td>
						<td data-id="${empObj.getId()}"><c:out
								value="${empObj.getId()}"></c:out></td>
						<td><c:out value="${empObj.getFname()}"></c:out></td>
						<td><c:out value="${empObj.getLname()}"></c:out></td>
						<td><c:out value="${empObj.getAge()}"></c:out></td>
						<td><c:out value="${empObj.getAddress()}"></c:out></td>
					</tr>

				</c:if>
			</tbody>
		</table>
	</div>
</body>
<footer>
	<jsp:include page="../basepartials/footer.jsp"></jsp:include>
	<script src="resources/static/js/employee.js"></script>
</footer>