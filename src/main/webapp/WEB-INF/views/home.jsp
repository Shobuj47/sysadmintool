<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    </head>
    <s:url var="url_css" value="/resources/css/bootstrap.css"></s:url>
    <link href="${url_css}" rel="stylesheet" type="text/css" />
    <body>


 	<div class="container">
 		<div class="row">          
    	<div class="col-md-2"></div>
		   <div class="col-md-10">
		  	<div class="test">
		  		<div class="row">
		  		<h1>Welcome to the Sys Admin Tool</h1>
		  		</br>
		  		</div>
		  		<div class="row">
		    <form:form method="POST" action = "/mvc/login"	>
				<h3>Username : </h3><form:input path="loginName"/></br>
				<h3>Password : </h3><form:input path="password" type="password" /></br></br>
		 		<input type="submit" value="Login" name="action" />
		      </form:form>
		      </div>
		  </div>
		   </div>
    	
	</div>
</div>
    </body>
</html>
