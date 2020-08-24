<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
                <a href='<c:url value="/clients" />' class="btn btn-default pull-right"> <span class="glyphicon glyphicon-user glyphicon"></span> Clients</a>
                <a href='<c:url value="/products" />' class="btn btn-default pull-right"> <span class="glyphicon-inbox glyphicon"></span> Products </a>
                <a href='<c:url value="/sales" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> Sales</a>
				<h1>${greeting}</h1>
				<p>${tagline}</p>
			</div>
		</div>
	</section>
</body>
</html>