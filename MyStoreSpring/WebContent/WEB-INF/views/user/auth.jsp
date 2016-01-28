<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="resources/css/main.css" > -->
<title>LOGIN</title>
</head>
<body>
 <%@include file="/WEB-INF/views/nav.jsp" %> 
<fieldset >
<legend>Login</legend>
<table  class="centerBox">

<tr>PLEASE ENTER THE INFORMATION.</tr>
<%-- <form:form name="input" action="users?login/auth" method="post"  modelAttribute="modelUser" style="text-align:left !important">


<tr>
<td><p>User Name</td>
<td><form:input type="text" path="username"/></td>
<td><form:errors class="textRed" path="username"/></td>
</tr>

<tr>
<td><p>Password</p></td>
<td><form:input type="password" path="password"/></td>
<td><form:errors class="textRed"  path="password"/></td>
</tr>

<tr><td></td>
<td></td>
<td><input type="Submit" value="Login"></td>
</tr>



</form:form> --%>


<form action="auth" method="post">

<p>${ErrorMessage}</p>
<tr>
<td><p>User Name</p></td>
<td>
<input type="text" id="username" name="username"  />
</td>

</tr>

<tr>
<td><p>Password</p></td>
<td><input type="password" id="password" name="password"  /></td>

</tr>

<tr>
<td></td>
<td><input type="Submit" value="Login"></td>
</tr>



</form>
</table>
</fieldset>
</body>
</html>