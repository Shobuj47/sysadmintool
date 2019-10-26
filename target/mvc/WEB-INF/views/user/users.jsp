	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
	
	<jsp:include page="../includes/header.jsp"></jsp:include>		 		
	
			<div class="col-md-8">
				<div class="row">
					<form class="row" style="width:100%">
					    <div class="col py-md-3">
					      <input type="text" class="form-control" placeholder="User Name">
					    </div>
					    <div class="col py-md-3">
					      <button type="submit" class="btn btn-primary">Search</button>
					    </div>
					</form>
				
                     <c:if test="${userlist == null}">
                     <tr>
                         <td align="center" colspan="8" class="error">No Records Present</td>
                     </tr>
                 	</c:if>
				     <c:if test="${userlist != null}">
                    		<c:forEach var="usr" items="${contactList}" varStatus="st">
                    			${usr.username}
                    		</c:forEach>
                 	</c:if>
		
				
				
				
				
				
				</div>
				<div class="row">
				<table class="table table-dark">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Username</th>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Email</th>
				      <th scope="col">Status</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				      <td>Otto</td>
				      <td>Otto</td>
				    </tr>
				    <tr>
				      <th scope="row">2</th>
			    	  <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				      <td>Otto</td>
				      <td>Otto</td>
				    </tr>
				    <tr>
				      <th scope="row">3</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				      <td>Otto</td>
				      <td>Otto</td>
				    </tr>
				  </tbody>
				</table>
				</div>
		</div>
	</div>





</body>
</html>