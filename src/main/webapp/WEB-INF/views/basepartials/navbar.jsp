<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${contextPath}/index.html">EnterpriseCore</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${contextPath}/index.html">Home</a></li>
			<li><a href="#">Contact us</a></li>
			<li><a href="#">About</a></li>
		</ul>
	</div>
</nav>