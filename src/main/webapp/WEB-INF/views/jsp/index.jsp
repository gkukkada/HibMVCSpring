<jsp:include page="../basepartials/base.jsp" flush="true"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<title>Login Page</title>
<jsp:include page="../basepartials/navbar.jsp"></jsp:include>
<body>
	<div class="container topmargin">

		<c:if test="${err ne null}">
			<div class="alert alert-warning">
				<h4>This is somewhat embarrassing, isnt it?</h4>
				<c:out value="${err}"></c:out>
			</div>
		</c:if>

		<h2>Enter Login Details here to get Employee details.</h2>
		<form class="form-horizontal" role="form" action="/spring/submitForm"
			method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2">Username:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username"
						id="username" placeholder="Enter your username">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-10">
					<input type="password" name="password" class="form-control"
						id="pwd" placeholder="Enter password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" disabled> Remember
							me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="register-link">
						<a href="${contextPath}/register">Register me</a>
					</div>
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