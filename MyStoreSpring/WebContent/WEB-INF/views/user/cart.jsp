<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/main.css">
<title>Cart</title>
</head>
<body>
 <%@include file="/WEB-INF/views/nav.jsp" %> 
<fieldset >
<legend>Cart</legend>
	<a href="cart/clear">
		<button class="btn btn-success"><spring:message code="clearCart"/></button>
	</a>
	<a href="cart/finalise">
		<button class="btn btn-danger"><spring:message code="FinalizeCart"/></button>
	</a>
	

	<h2> Products in Cart </h2> <h3>Total Cost= ${totalPrice}<p></p></h3>
	<c:forEach var="entry" items="${products}">
		<div class="componenet">
			
			<br/>

			<div class="alert alert-info fade in" id="datadisplayerhome">

				<ul class="list-groups">
					<li class="list-group-item active">
					<p>${entry.key.productName} 
					 <a href="#" class="close"
					  data-dismiss="alert"
					  aria-label="close"> <span>&times</span>
							</a>
						</p></li>
				
					<li class="list-group-item"><p>
						<spring:message code="costs"/> .<spring:message code="currency"/> ${entry.key.productPrice} X ${entry.value}<p></p> 
						</p></li>
						<li class="list-group-item"><p>
						${entry.key.productDescription}
						<a href="cart/add/${entry.key.productId}" style="float: right;">
								<button class="btn btn-info">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
								</button>
							</a>
						</p></li>
					<li class="list-group-item">
						<p>
							 <a href="cart/remove/${entry.key.productId}"
								style="float: right;">
								<button class="btn btn-danger"><spring:message code="removeFromCart"/></button>
							</a>

						</p>
					</li>
			</div>
			</ul>
		</div>
		



	</c:forEach>
	</fieldset>
</body>
</html>
