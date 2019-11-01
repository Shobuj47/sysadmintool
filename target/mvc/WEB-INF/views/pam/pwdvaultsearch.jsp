<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servers</title>


	<jsp:include page="../includes/header.jsp"></jsp:include>		 		







<div class="col-md-8 ml-md-2">
				<div class="row py-md-3">
					<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%">
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto" id="data-grid-ctrl">
							      <li class="nav-item btn-info ml-md-2 disabled" data-toggle="modal" data-target="#changePassword" onclick="addServerId()" >
							        <a class="nav-link" href="#">Reset Password</a>
							      </li>
    							  <li class="nav-item btn-info ml-md-2" data-toggle="modal" data-target="#unlockUser">
							        	<a class="nav-link" href="#">Unlock User</a>
							      </li>
						      </ul>
						      <form class="form-inline my-2 my-lg-0">
							      <input class="form-control mr-sm-2" type="search" placeholder="Search" id="searchInput" aria-label="Search">
							      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
							   </form>
                     	 </div>
					</nav>
				</div>
				<div class="row">
				<table class="table table-dark" >
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Server Name</th>
				      <th scope="col">Server Address</th>
				      <th scope="col">Server Port</th>
				      <th scope="col">User Name</th>
				      <th scope="col">Select Server</th>
				      <th scope="col">Operation</th>
				    </tr>
				  </thead>
				  <tbody id="tbldata">	
				    
				    	 <c:if test="${pamserverlist == null}">
				    	 <tr>
		                         <td align="center" colspan="8" class="error">No Records Present</td>
                         </tr>
	                 	</c:if>
	                 	<c:if test="${pamserverlist != null}">
	                 	    <c:forEach var="serverlist" items="${pamserverlist}" varStatus="st">
	                 	    <tr>
	                 	    	  <th><input type="radio" name="ss" onclick="showDataGridCtrl()" value="${serverlist.componentId}" /></td>
                    			  <td scope="row">${serverlist.componentId}</th>
							      <td>${serverlist.displayname}</td>
							      <td>${serverlist.serveraddr}</td>
							      <td>${serverlist.port}</td>
							      <td>${serverlist.username}</td>
								  <td>
									<s:url var="url_edit" value="/pamserversaddmodify">
									<s:param name="serverId" value="${serverlist.componentId}" />
									</s:url>
									<s:url var="url_delete" value="/pamserversdelete">
									<s:param name="serverId" value="${serverlist.componentId}" />
									</s:url>
							        <a href="${url_edit}">Modify</a> | <a href="${url_delete}">Delete</a>
							      </td>
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


<div class="modal fade" id="changePassword" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Reset User </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
        
	        <div class="modal-body">
		          <div class="form-group">

                   
            <form:form method="POST" id="serverList" action = "/mvc/pamresetserver"	modelAttribute="serverinfocmd">
           		<form:input path="serverId" id="srvId" hidden="true" /></br>
				<form:input path="username" class="form-control" placeholder="Username"/></br>
				<form:input path="password" type="password" class="form-control" placeholder="Password" /></br>
		 		<input type="submit" class="btn btn-primary" value="Submit" name="action" />
		 		<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		     </form:form> 
                   
                   
		          </div>
	          </div>      
    </div>
  </div>
</div>



<script>

function addServerId() {
	var selectedVal = "";
	var selected = $("input[type='radio'][name='ss']:checked");
	if (selected.length > 0) {
	    selectedVal = selected.val();
	}
	  document.getElementById("srvId").value = selectedVal;
	}


$("#data-grid-ctrl").hide();

function showDataGridCtrl(){
	$("#data-grid-ctrl").show();
}



</script>


</body>
</html>



