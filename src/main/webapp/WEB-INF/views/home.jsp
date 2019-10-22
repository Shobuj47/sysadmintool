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


                   
    <form:form method="POST" action = "/mvc/login"	>
		<form:input path="loginName"/>
		<form:input path="password" />
 		<input type="submit" value="Submit" name="action" />
      </form:form>


    </body>
</html>
