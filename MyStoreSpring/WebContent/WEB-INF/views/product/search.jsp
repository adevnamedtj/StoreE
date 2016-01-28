<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>product search</title>
</head>
<body>
<%@include file="..//nav.jsp"%>
<div class="form-group form">
<form:form name="input" method="get" action="/springstore/products" modelAttribute="product">
<div>
<label>Name:</label>
<form:input type="text" path="productName" class="form-control"/>
<form:errors path="productName"></form:errors>
</div>
<div>
<label>Category:</label>
<form:select path="productCategory" class="form-control">

<form:options path="productCategory" items="${Categories}" itemLabel="categoryName" itemValue="categoryName"></form:options>

</form:select>
</div>
</br>
<div>
<input type="submit" value="Search" class="form-control">
</div>

</form:form>
</div>








	<h2>~~~~~~~~~~~~~~~ Products LIST ~~~~~~~~~~~~~~~</h2>
	<c:forEach var="product" items="${productsList}">
		<div class="componenet">

			</br>

			<div class="alert alert-info fade in" id="datadisplayerhome">

				<ul class="list-groups">
					<li class="list-group-item active">
						<p>${product.productName}
							<a href="#" class="close" data-dismiss="alert" aria-label="close">
								<span>&times</span>
							</a>
						</p>
					</li>

					<li class="list-group-item"><p>
							<spring:message code="costs" />
							.
							<spring:message code="currency" />
							${product.productPrice} <a style="float: right;">
								<button class="btn btn-danger">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
							</a>
						</p></li>
					<li class="list-group-item">
						<p>
							${product.productDescription} <a ui-sref="activity"
								style="float: right;">
								<button class="btn">
									<spring:message code="comments" />
								</button>
							</a>

						</p>
					</li>
			</div>
			</ul>
		</div>
		</c:forEach>
		
</body>
</html>