<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Profile HOME</title>
</head>
<body>
<%@include file="/WEB-INF/views/nav.jsp" %>
<a href="/springstore/users/${user.username}/edit"><button class="btn btn-info"></button></a>
<%-- <%@include file="..//nav.jsp" %> --%>
<h1>WELCOME BACK ${user.username}</h1>
<table>
<tr>
<h3> PERSONAL INFORMATION</h3>
</tr>
<tr>
<td>Full Name</td>
<td>${user.fullName}</td>
</tr>
<tr>
<td>Address</td>
<td>${user.getAddress()}</td>
</tr>
<tr>
<td>Billing</td>
<td>${user.card}</td>
</tr>


</table>

</body>
</html>