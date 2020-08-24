<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${client.firstName} ${client.lastName}</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href='<c:url value="/resource/css/styles.css" />' type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <a href='<c:url value="/products" />' class="btn btn-default pull-right"> <span class="glyphicon-inbox glyphicon"></span> Products </a>
            <a href='<c:url value="/sales" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> Sales</a>

            <h1>Client</h1>
        </div>
    </div>
</section>

<section class="container" ng-app="cartApp">

    <div class="row">
            <p>
                <strong>Client ID: </strong><span class="label label-warning">${client.clientId}</span>
            </p>
            <p>
                <strong>First Name</strong> : ${client.firstName}
            </p>
            <p>
                <strong>Last Name</strong> : ${client.lastName}
            </p>
            <p>
                <strong>Email </strong> : ${client.email}
            </p>
    </div><br>

    <div>
        <a href="<spring:url value="/clients/update?id=${client.clientId }" />" class="btn btn-primary"> Update </a>
        <a href="<spring:url value="/clients/delete?id=${client.clientId }" />" class="btn btn-danger"> Delete </a>
    </div> <br><br>

    <div>
        <h3>Products</h3>
        <hr>
    </div>
    <section class="container" ng-app="cartApp" >
        <div class="row">
            <c:forEach items="${client.products}" var="product" >
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>${product.name}</h3>
                            <a href='<spring:url value="/products/product?id=${product.productId}" />' >
                                <img src='<c:url value="/resources/images/${product.imageSource}" />' alt="image" width="200" />
                            </a>
                            <p>${product.description}</p>
                            <p>${product.unitPrice} EUR </p>
                            <p>${product.unitsInStock} units in stock</p>
                            <p ng-controller="cartController">
                                <a href="<spring:url value="/products/product?id=${product.productId }" />"  class="btn btn-primary" >
                                    <span class="glyphicon-info-sign glyphicon"> </span>  Details</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>


</section>

</body>
</html>
