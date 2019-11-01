<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Server Password</title>


	<jsp:include page="../includes/header.jsp"></jsp:include>		 		





		<div class="col-md-8 m-md-5">

					<section>
					    <div class="container">
					      <div class="row justify-content-center">
					        <div class="col-12 col-md-8 col-lg-8 col-xl-6">
					        	<div class="p-5 border">
					          <div class="row">
					            <div class="col text-center">
					              <h1>PAM Server Add/Modify</h1>
					              <p class="text-h3">The real danger is not that computers will begin to think like men, but that men will begin to think like computers. - Sydney Harris (Journalist)</p>
					            </div>
					          </div>
					          <div class="row align-items-center">
					            <div class="col mt-4">
					              <input type="text" class="form-control" placeholder="Server Name">
					            </div>
					          </div>
					          <div class="row align-items-center">
					            <div class="col mt-4">
					              <input type="text" class="form-control" placeholder="Server Address">
					            </div>
					          </div>
					          <div class="row align-items-center mt-4">
					            <div class="col">
					              <input type="password" class="form-control" placeholder="Sudo Username">
					            </div>
					            <div class="col">
					              <input type="password" class="form-control" placeholder="Sudo Password">
					            </div>
					          </div>
					          <div class="row align-items-center mt-4">
					            <div class="col">
					              <input type="text" class="form-control" placeholder="port">
					            </div>
					          </div>
					          <div class="row justify-content-start mt-4">
					            <div class="col">
					              <button class="btn btn-primary mt-4">Submit</button>
					            </div>
					            <div class="col">
					              <button class="btn btn-secoundary mt-4">Cancel</button>
					            </div>
					          </div>
					        </div>
					        </div>
					      </div>
					    </div>
					  </section>
		</div>

</div>

</body>
</html>