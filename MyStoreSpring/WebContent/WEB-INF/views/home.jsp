<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/main.css">
<title>CH&U.inc</title>
</head>
<body>
	<%@include file="nav.jsp"%>
	<h1><spring:message code="welcome"/></h1>
	${currentuser.username}
<c:choose>
<c:when test="${empty currentuser.username}">
	<a href="users?registration">
		<button class="btn btn-info"><spring:message code="newUser"/></button>
	</a>
	<a href="users/auth">
		<button class="btn btn-success"><spring:message code="existingUser"/></button>
	</a>
	
	<a href="products/search">
		<button class="btn btn-regular"><spring:message code="search"/></button>
	</a>

</c:when>
<c:otherwise>
<p>Hello ${currentuser.username}<p></p><a href="users/logout">
		<button class="btn btn-danger"><spring:message code="logout"/></button>
	</a></p>
</c:otherwise>

</c:choose>

	<h2>~~~~~~~~~~~~~~~ Products LIST ~~~~~~~~~~~~~~~</h2>
	<c:forEach var="product" items="${products}">
		<div class="componenet">
			
			</br>

			<div class="alert alert-info fade in" id="datadisplayerhome">

				<ul class="list-groups">
					<li class="list-group-item active">
					<p>${product.productName}
					 <a href="#" class="close"
					  data-dismiss="alert"
					  aria-label="close"> <span>&times</span>
							</a>
						</p></li>
				
					<li class="list-group-item"><p>
						<spring:message code="costs"/> .<spring:message code="currency"/> ${product.productPrice} <a style="float: right;">
								<button class="btn btn-danger">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
							</a>
						</p></li>
					<li class="list-group-item">
						<p>
							${product.productDescription} <a href="cart/add/${product.productId}"
								style="float: right;">
								<button class="btn"><spring:message code="addtocart"/></button>
							</a>

						</p>
					</li>
			</div>
			</ul>
		</div>
		



	</c:forEach>
</body>
</html>
