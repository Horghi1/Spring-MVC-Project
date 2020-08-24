<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href='<c:url value="/resource/css/styles.css" />' type="text/css" media="screen" />
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <title>Clients</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                 <a href='<c:url value="/products" />' class="btn btn-default pull-right"> <span class="glyphicon-inbox glyphicon"></span> Products </a>
                <a href='<c:url value="/sales" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> Sales</a>
                <h1>Clients</h1>
                <p>All clients for Web Store</p>
            </div>
        </div>
    </section>

    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${clients}" var="client" >
                <tr>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.email}</td>
                    <td>
                        <a href="<spring:url value="/clients/client?id=${client.clientId }" />" class="btn btn-primary"> Details </a>&nbsp;
                        <a href="<spring:url value="/clients/delete?id=${client.clientId }" />" class="btn btn-danger"> Delete </a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="<spring:url value="/clients/add"/>" class="btn btn-primary"> Add client </a>
    </div>


</body>
</html>
