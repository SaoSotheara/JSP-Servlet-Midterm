<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"  %>
<%@ page import="com.itstep.htmltip.model.Tip" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>HTML Tips</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"/>

</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			

			
			<%
				List<Tip> tips = (ArrayList<Tip>)request.getAttribute("tips");
				String message = (String)request.getAttribute("message");
		  		String user = null;
		  		Cookie[] cookies = request.getCookies();
		  		if(cookies !=null){
					for(Cookie cookie : cookies){
						if(cookie.getName().equals("usernameAndPassword")) user = (String)cookie.getValue();
					}
				}
  			%>
			<c:if test="${ message != null }">
				<div class="col-md-12 col-md-offset-3 mt-2">
					<div class="alert alert-success center" role="alert">
						<p>${message}</p>
					</div>
				</div>
			</c:if>
			
			<c:if test="${ tips.size() > 0 } "> 
				<div class="col-sm-12 mt-3">
					<h3>There is no any tip yet!</h3>
				</div>
			</c:if>

			<c:forEach items="${ tips }" var="tip">
			<div class="col-sm-3 mt-3">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title"> ${tip.getTitle()}</h5>
							<p class="card-text">${tip.getDescription()}</p>
							<a
							href="<%= request.getContextPath() %>?action=DETAIL&id=${tip.getId()}"
							class="btn btn-primary">Details</a>
							<c:if test="<%= user != null %>">
								<a
								href="<%= request.getContextPath() %>?action=DELETE&id=${tip.getId()}"
								class="btn btn-danger">Delete</a>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>