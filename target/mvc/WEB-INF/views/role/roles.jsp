	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Search</title>
	
	
	
	<jsp:include page="../includes/header.jsp"></jsp:include>		 		





<div class="col-md-8 ml-md-2">
				<div class="row py-md-3">
					<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%">
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto">
							      <li class="nav-item bg-warning">
							        <a class="nav-link" href="#">Modify User<span class="sr-only">(current)</span></a>
							      </li>
							      <li class="nav-item bg-danger ml-md-2">
							        <a class="nav-link" href="#">Delete Users</a>
							      </li>
						      </ul>
						      <form class="form-inline my-2 my-lg-0">
							      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
							      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
							   </form>
                     	 </div>
					</nav>
				</div>
				<div class="row">
				<table class="table table-dark">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Role Name</th>
				      <th scope="col">Role Status</th>
				      <th><input name="select_all" value="1" id="example-select-all" type="checkbox" /></th>
				    </tr>
				  </thead>
				  <tbody>	
				    
				    	 <c:if test="${roleslist == null}">
				    	 <tr>
		                         <td align="center" colspan="8" class="error">No Records Present</td>
                         </tr>
	                 	</c:if>
	                 	<c:if test="${roleslist != null}">
	                 	    <c:forEach var="rr" items="${roleslist}" varStatus="st">
	                 	    <tr>
                    			  <th scope="row">${rr.componentid}</th>
							      <td>${rr.displayname}</td>
							      <td>${rr.status}</td>
							      <td><input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1"></td>
							</tr>
				    		</c:forEach>
				    		
	                 </c:if>
	                 
				  </tbody>
				</table>
				
				</div>
				
				
				
				
				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-end">
				    <li class="page-item disabled">
				      <a class="page-link" href="#" tabindex="-1">Previous</a>
				    </li>
				    <li class="page-item active"><a class="page-link" href="#">1</a></li>
				    <li class="page-item disabled">
				      <a class="page-link" href="#">Next</a>
				    </li>
				  </ul>
				</nav>
				
				
				
				
				
				
		</div>
	</div>





</body>
</html>