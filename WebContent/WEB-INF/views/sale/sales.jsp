<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href='<c:url value="/resource/css/styles.css" />' type="text/css" media="screen" />
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <title>Sales</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <a href='<c:url value="/products" />' class="btn btn-default pull-right"> <span class="glyphicon-inbox glyphicon"></span> Products </a>
            <a href='<c:url value="/clients" />' class="btn btn-default pull-right"> <span class="glyphicon glyphicon-user glyphicon"></span> Clients</a>
            <h1>Sales</h1>
            <p>All sales of WebStore</p>
        </div>
    </div>
</section>

<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Client</th>
            <th>Product</th>
            <th>Units</th>
            <th>State</th>
            <th>Sell/Decline</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sales}" var="sale" >
            <tr>
                <td><a href="<spring:url value="/clients/client?id=${sale.client.clientId }" />" >${sale.client.firstName} ${sale.client.lastName}</a></td>
                <td><a href="<spring:url value="/products/product?id=${sale.product.productId }" />">${sale.product.name}</a></td>
                <td>${sale.numberOfUnits}</td>
                <td>${sale.state}</td>
                <td>
                    <c:if test="${sale.state eq 'PENDING'}">
                        <a href="<spring:url value="/sales/sell?id=${sale.saleId }" />" class="btn btn-primary"> Sell </a>&nbsp;
                        <a href="<spring:url value="/sales/decline?id=${sale.saleId }" />" class="btn btn-danger"> Decline </a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br><br><br><br>

</body>
</html>
