<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Add Modify</title>	
	
	
	<jsp:include page="../includes/header.jsp"></jsp:include>		 		
	
		<div class="col-md-8 m-md-5">

					<section>
					    <div class="container">
					      <div class="row justify-content-center">
					        <div class="col-12 col-md-8 col-lg-8 col-xl-6">
					        	<div class="p-5 border">
					          <div class="row">
					            <div class="col text-center">
					              <h1>User Add/Modify</h1>
					              <p class="text-h3">The worst code is another coder's best.</p>
					            </div>
					          </div>
					          
					          
					          <s:url var="save_user"  value="/userModify"/>
                    			<form:form action="${save_user}" modelAttribute="user">
					          		  <form:input path="componentId" value="${user.componentId}" hidden="true" />

							          <div class="row align-items-center">
							            <div class="col mt-4">
							            	<form:input path="username" value="${user.username}" class="form-control" placeholder="Username"  />
							            </div>
							          </div>
							          <div class="row align-items-center mt-4">
							            <div class="col">
							              <form:input path="fname" value="${user.fname}" class="form-control" placeholder="First Name"  />
							            </div>
							            <div class="col">
							              <form:input path="lname" value="${user.lname}" class="form-control" placeholder="Last Name"  />
							            </div>
							          </div>
							          <div class="row align-items-center mt-4">
							            <div class="col">
							            <form:input path="password" type="password" value="${user.password}" class="form-control" placeholder="Password"  />
							            </div>
							            <div class="col">
							              <input type="password" class="form-control" placeholder="Confirm Password">
							            </div>
							          </div>
							          <div class="row align-items-center">
							            <div class="col mt-4">
							            <form:input path="email" value="${user.email}" class="form-control" placeholder="Email Address"  />
							            </div>
							          </div>
							          <div class="row justify-content-start mt-4">
							            <div class="col">
							              <button class="btn btn-primary mt-4">Submit</button>
							            </div>
					            </form:form>
					            <div class="col">
					              <a href="/users"><button class="btn btn-secoundary mt-4">Cancel</button></a>
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