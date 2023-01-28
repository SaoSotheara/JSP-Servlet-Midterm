<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.itstep.htmltip.model.Tip" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tip Detail</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>

		<%
			Tip tip = (Tip)request.getAttribute("tip");
			String[] htmlString = (String[])request.getAttribute("htmlString");
		%>


	<div class="container">

		<div class="overflow-auto">
			<div class="card w-85 mt-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">${ tip.getTitle() }</h5>
						<p class="card-text">${ tip.getDescription() } </p>
						<h5 class="card-title">Example</h5>
						<p class="card-text">${ tip.getExampleHtmlEscape() }</p>

						<p class="card-text">
							<c:forEach var="str" items="<%=htmlString%>">
								<br>
								<code>
									<c:out value="${str}" escapeXml="true"></c:out>
								</code>
							</c:forEach>

						</p>
					</div>
				</div>

			</div>
		</div>


	</div>




	<jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>