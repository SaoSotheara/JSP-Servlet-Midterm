<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>


	<div class="container">
		<h2>Register for Admin only</h2>

		<div class="col-md-12 col-md-offset-3">

			<c:choose>
				    <c:when test="${success != null}">
						<div class="col-md-12 col-md-offset-3">
		        			<div class="alert alert-success center" role="alert">
								<p>${success}</p>
							</div>
						</div>
				    </c:when>    
				    <c:when test="${ error }">
							<div class="col-md-12 col-md-offset-3">
								<div class="alert alert-success center" role="alert">
									<p>${error}</p>
								</div>
							</div>
				    </c:when>
			</c:choose>
		</div>
		<form action="${pageContext.request.contextPath}/User" method="post">

			<div class="form-group">
				<label for="uname">User Name:</label> <input type="text"
					class="form-control" id="username" placeholder="User Name"
					name="username" required>
			</div>

			<div class="form-group">
				<label for="uname">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password" required>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

		</form>
		
	</div>


	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>