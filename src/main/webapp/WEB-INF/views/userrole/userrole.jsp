	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Roles</title>


<jsp:include page="../includes/header.jsp"></jsp:include>	

 <div class="col-md-8 my-md-5">
			<c:if test="${userlist != null}">
				<label for="rolelist">Select User (select one):</label>
				<form:select class="form-control" path="userlist" id="userlist">	
					<c:forEach var="user" items="${userlist}" varStatus="st">
						<form:option value="${user.componentId}" label="${user.username}"/>
					</c:forEach>
				</form:select>
 			</c:if>
<div class="row">
	<div class="col-md-4 my-md-5">
			<c:if test="${rolelist != null}">
				<label for="roleidlist">Select Role list:</label>
				<form:select class="form-control" id="roleidlist" path="rolelist" multiple="true">
					<c:forEach var="role" items="${rolelist}" varStatus="st">
						<form:option value="${role.componentId}" label="${role.displayname}"/>
					</c:forEach>
				</form:select>
			</c:if>
	</div>	
	<div class="col-md-2 my-md-5 ">
		<div class="row justify-content-center">	
			<button type="button" class="btn btn-xs btn-primary mt-md-4" id="add">Add >></button>
		</div>
		<div class="row justify-content-center">	
			<button type="button" class="btn btn-xs btn-danger mt-md-2" id="remove"><< Remove</button> 
		</div>
	</div>
	<div class="col-md-4 my-md-5">
			<label for="newfclist">Role list:</label>
			<form:select class="form-control" id="newrolelist" path="rolelist" multiple="true">
	
			</form:select>
	</div>
</div>
</div>
</div>
<script>
       $(document).ready(function(){
    	   $('#add').click(function() {  
    	    return !$('#roleidlist option:selected')
    	.remove().appendTo('#newrolelist');  
    	   });  
    	   $('#remove').click(function() {  
    	    return !$('#newrolelist option:selected')
    	.remove().appendTo('#roleidlist');  
    	   });  
    	    
    	function selectall()  {  
    	$('#newfclist').find('option').each(function() {  
    	   $(this).attr('selected', 'selected');  
    	  });  
    	}  
    	});  
</script>
     



</body>
</html>