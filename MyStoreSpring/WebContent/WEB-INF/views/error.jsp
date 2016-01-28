<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GlobAl ErrOR PaGe</title>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="alert alert-danger">
<h1>${exception} <p>occured</p></h1>
<h4> When You Try to Access this url</h4>
<h5>${url} <p></p></h5>
</div>
</body>
</html>