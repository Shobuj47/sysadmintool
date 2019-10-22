<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.userId == null} }">
	<% response.sendRedirect("localhost/mvc/login"); %>
</c:if>
<c:if test="${sessionScope.userId != null} }">
	User Found
	<c:forEach var="item" items="${sessionScope.rolelist}">
		<c:if test="${request.getContextPath() != item}">
			No Match
		</c:if>
		<c:if test="${request.getContextPath() == item}">
			Match
		</c:if>
	 <tr>
	   <td>Item : <c:out value="${item}" /></td>
	 </tr>
	</c:forEach>
</c:if>