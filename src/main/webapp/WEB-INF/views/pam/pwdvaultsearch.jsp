<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servers</title>


	<jsp:include page="../includes/header.jsp"></jsp:include>		 		







<div class="col-md-8 ml-md-2">
				<div class="row py-md-3">
					<nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%">
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto">
							      <li class="nav-item bg-warning">
							        <a class="nav-link" href="#">Modify Server<span class="sr-only">(current)</span></a>
							      </li>
							      <li class="nav-item bg-danger ml-md-2">
							        <a class="nav-link" href="#">Delete Server</a>
							      </li>
							      <li class="nav-item btn-info ml-md-2" data-toggle="modal" data-target="#changePassword">
							        <a class="nav-link" href="#">Reset Password</a>
							      </li>
    							  <li class="nav-item btn-info ml-md-2" data-toggle="modal" data-target="#unlockUser">
							        	<a class="nav-link" href="#">Unlock User</a>
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
				      <th scope="col">Server Name</th>
				      <th scope="col">Server Address</th>
				      <th scope="col">Server Port</th>
				      <th scope="col">User Name</th>
				      <th><input name="select_all_server" id="select_all_server" type="checkbox" /></th>
				    </tr>
				  </thead>
				  <tbody>	
				    
				    	 <c:if test="${pamserverlist == null}">
				    	 <tr>
		                         <td align="center" colspan="8" class="error">No Records Present</td>
                         </tr>
	                 	</c:if>
	                 	<c:if test="${pamserverlist != null}">
	                 	    <c:forEach var="serverlist" items="${pamserverlist}" varStatus="st">
	                 	    <tr>
                    			  <th scope="row">${serverlist.componentId}</th>
							      <td>${serverlist.displayname}</td>
							      <td>${serverlist.serveraddr}</td>
							      <td>${serverlist.port}</td>
							      <td>${serverlist.username}</td>
							      <td><input class="form-check-input" type="checkbox" name="serverId" id="serverId${serverlist.componentId}" value="${serverlist.componentId}" ></td>
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

                   
            <form:form method="POST" action = "/mvc/pamresetserver"	modelAttribute="serverinfocmd">
           		 <h3>ServerId : </h3><form:input path="serverId"/></br>
				<h3>Username : </h3><form:input path="username"/></br>
				<h3>New Password : </h3><form:input path="password" type="password" /></br></br>
		 		<input type="submit" value="Submit" name="action" />
		     </form:form> 
                   
                   
		          </div>
	          </div>
		      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			      
		      </div>
 
      
    </div>
  </div>
</div>


<div class="modal fade" id="changePassword" tabindex="-1" role="dialog" aria-labelledby="unlockUser" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Reset User</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">User Name:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">New Password</label>
            <input type="password" class="form-control" id="recipient-name">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Update User</button>
      </div>
    </div>
  </div>
</div>

<script>
$("#select_all_server").click(function(){
    $('input:checkbox').not(this).prop('checked', this.checked);
});


$('#changePassword').on('show.bs.modal', function (event) {
	  var items=document.getElementsByName('serverId');

	  for(var i=0; i<items.length; i++){
			if(items[i].type=='checkbox' && items[i].checked==true)
				selectedItems+=items[i].value+"\n";
		}

	  
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body type').val(selectedItems)
	})
	
	
$('#unlockUser').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(selectedItems)
	})
</script>


</body>
</html>



