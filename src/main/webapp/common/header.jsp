<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Locale"%>
<%@ page import="javax.servlet.http.Cookie" %>

<header>
 <nav class="navbar navbar-expand-md navbar-dark"
  style="background-color: #2596be;">
  <div>
   <a href="<%= request.getContextPath() %>/" class="navbar-brand"> HTML Tips</a>
  </div>

  	<%
  		String user = null;
  		Cookie[] cookies = request.getCookies();
  		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("usernameAndPassword")) user = (String)cookie.getValue();
			}
		}
  	%>
  	
  <ul class="navbar-nav navbar-collapse justify-content-end">
  	<c:if test="<%= user != null %>">
		<li><a href="<%= request.getContextPath() %>/Logout" class="nav-link">Logout</a></li>
   		<li><a href="<%= request.getContextPath() %>/tipCreation.jsp" class="nav-link">Create Tip</a></li>
  	</c:if>
  </ul>
 </nav>
</header>