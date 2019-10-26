<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.userId == null} }">
	<% response.sendRedirect("localhost/mvc/login"); %>
</c:if>
<c:if test="${sessionScope.userId != null} }">
	User Found
	<c:forEach items="${rolelist}" var="accessurl">
		<c:if test="${request.getContextPath() != accessurl}">
			No Match
		</c:if>
		<c:if test="${request.getContextPath() == accessurl}">
			Match
		</c:if>
	 <tr>
	   <td>Item : <c:out value="${accessurl}" /></td>
	 </tr>
	</c:forEach>
</c:if>