<jsp:include page="../basepartials/base.jsp" flush="true"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Employee Validation</title>
<body>
	<jsp:include page="../basepartials/navbar.jsp"></jsp:include>
<body>
	<div class="container topmargin">
		<c:if test="${err ne null}">
			<div class="alert alert-warning">
				<h4>This is somewhat embarrassing, isnt it?</h4>
				<c:out value="${err}"></c:out>
			</div>
		</c:if>

		<h3>Enter Employee ID to get Employee details.</h3>
		<form class="form-horizontal" role="form" action="/spring/empID"
			method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2">Employee ID:</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" name="id" id="id"
						placeholder="Enter ID">
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Employee Firstname or
					Lastname:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" id="name"
						placeholder="Enter Name">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
<footer><jsp:include page="../basepartials/footer.jsp"></jsp:include></footer>