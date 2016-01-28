<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="/resources/css/chu.css">
<link rel="stylesheet" href="/resources/css/main.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
/**
 * Created by tejarkalagara on 7/24/15.
 */
window.addEventListener("load",onload);

function onload(){
    var cktoggletriggerchanger;
    var cktoggletriggerchangercount = 0;
    $("#toggle-trigger").click(function(e){
        e.preventDefault();

        if(cktoggletriggerchangercount == 0)
        {
            console.log("open")
            $(ttcc).toggleClass('glyphicon glyphicon-triangle-left');
            cktoggletriggerchangercount=1;
        }
        if(cktoggletriggerchangercount == 1){
            console.log("close")
            $(ttcc).toggleClass('glyphicon glyphicon-triangle-right');
            cktoggletriggerchangercount=0;
        }
    $("#wrapper").toggleClass("afterToggle");
    });
}
</script>




<title>CH&U</title>
</head>
<body>
	<nav class="nav navbar-inverse" background="none">
	<div class="container-fluid">

		<div class="navbar-header">
			<a href="#" class="navbar-brand" id="brandName"> CH&U.inc </a>
		</div>

		<ul class="nav navbar-nav">
			<li><a id="toggle-trigger" href="#"> <span
					class="glyphicon glyphicon-menu-hamburger"></span> <span id="ttcc"
					class="glyphicon glyphicon-triangle-right"></span>

			</a></li>
			<li class="active"><a href="home"><spring:message code="nav.home"/></a></li>
			<li><a href="activity"><spring:message code="nav.activity"/></a></li>
			<li><a href="events"><spring:message code="nav.events"/></a></li>
			<li><a href="production"><spring:message code="nav.production"/></a></li>
			<li><a href="aboutus"><spring:message code="nav.aboutus"/></a></li>
			<li></li>


		</ul>

		<ul class="nav navbar-nav navbar-right">

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> 
				<%-- <p>${currentuser.username}</p> --%>
				<spring:message code="nav.dropdown.you"/> 
				<span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#"><spring:message code="nav.dropdown.info"/></a></li>
					<li><a href="#"><spring:message code="nav.dropdown.privacy"/></a></li>
					<li><a href="#"><spring:message code="nav.dropdown.settings"/></a></li>
					<li><a href="#"><spring:message code="nav.dropdown.cart"/></a></li>
					<li><a href="#"><spring:message code="nav.dropdown.billing"/></a></li>
					<li><a href="#"><spring:message code="nav.dropdown.shipping"/></a></li>
					<li><a href="#"><spring:message code="nav.dropdown.logout"/></a></li>

				</ul></li>

		</ul>


		<div></div>
	</div>

	</nav>


	<!--<div class="container-fluid">-->


	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">

			<!-- <li><a href="#">Information</a></li>
			<li><a href="#">Privacy</a></li>
			<li><a href="#">Settings</a></li>
			<li><a href="#">Cart</a></li>
			<li><a href="#">Billing</a></li>
			<li><a href="#">Shipping</a></li>
			<li><a href="#">Logout</a></li> -->
		</ul>
		<div class="colorblockssidenav">
		</div>

	</div>

	<div id="wrapper">

		<div id="pagecontent-wrapper" class="viewcontainerAnimationmain">


			<div ui-view id="container-fluid" class="viewcontainerAnimation">

				<!--<a href="#" class="btn btn-info" id="menu-toggle">Menu</a>-->