<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Product - ${product.name}</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>
<section>
	<div class="jumbotron">
		<div class="container">
			<a href='<c:url value="/clients" />' class="btn btn-default pull-right"> <span class="glyphicon glyphicon-user glyphicon"></span> Clients</a>
			<a href='<c:url value="/sales" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> Sales</a>
			<a href='<c:url value="/products/add" />' class="btn btn-default pull-right"  > <span class="glyphicon-plus-sign glyphicon"></span> Add Product</a>

			<h1>Product</h1>
		</div>
	</div>
</section>

	<section class="container">

		<div class="row">
			<div class="col-md-6">
				<img src='<c:url value="/resources/images/${product.imageSource}" />' class="single-img" alt="image" /> 
			</div>
			<div class="col-md-6">

				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>Category</strong> : ${product.category}
				</p>
                                <p>
					<strong>Condition </strong> : ${product.condition}
				</p>
				<p>
					<strong>Available units in stock </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice} EUR </h4>
				<p ng-controller="cartController">
					<a href="<spring:url value="/products/update?id=${product.productId}"  />" class="btn btn-success"> Update 	</a>
					<a href="<spring:url value="/products/delete?id=${product.productId}"  />"  class="btn btn-danger btn-large"> <span
						class="glyphicon-trash glyphicon"> </span> Delete
					</a>
				</p>
			</div>
			<br>

		</div>
	</section><br><br>
<section>
	<div class="container">
		<form:form modelAttribute="newSale" action="/WEB-INF/sales/add" enctype="multipart/form-data" method="post">
			<fieldset>
				<div class="form-group">
				<label class="control-label"> Select Client </label>
                                <br>
						<form:select path="client.clientId" name="client">
							<c:forEach items="${clients}" var="client">
								<option value="${client.clientId}">${client.firstName} ${client.lastName}</option>
							</c:forEach>
						</form:select>
				</div>

				<div class="form-group">
					<label class="control-label" for="units"> Units </label>
					<div class="">
						<form:input path="numberOfUnits" id="units" type="text" class="form:input-large" />
					</div>
				</div>

				<form:input path="product.productId" value="${product.productId}" type="hidden"/>
				<form:input path="state" value="PENDING" type="hidden"/>

				<div class="form-group">
					<div class="col-lg-offset- col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Order now" />
					</div>
				</div>
			</fieldset>
		</form:form>
            <br>
            <div>
                <p style="margin-left: 150px; color: red; font-weight: bold">${param.error}</p>
            </div>
            <br>
	</div>
</section><br><br><br><br>
</body>
</html>