<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/resource/css/styles.css" />" type="text/css" >

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <title>Add new client</title>
</head>
<body>

    <section>
        <div class="jumbotron">
            <div class="container">
                <a href='<c:url value="/products" />' class="btn btn-default pull-right"> <span class="glyphicon-inbox glyphicon"></span> Products </a>
                <a href='<c:url value="/sales" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> Sales</a>

                <div class="pull-right" style="padding-right: 50px">

                </div>
                <h1>Clients</h1>
                <p>Add new client</p>
            </div>
        </div>
    </section>

    <section class="container">
        <form:form modelAttribute="newClient" enctype="multipart/form-data" class="form-horizontal">
            <fieldset>
                <legend>Add new client</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="firstName">First Name</label>
                    <div class="col-lg-10">
                        <form:input id="firstName" type="text" path="firstName" class="form:input-large" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="lastName">Last Name</label>
                    <div class="col-lg-10">
                        <form:input type="text" id="lastName" path="lastName" class="form:input-large" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="email">Email</label>
                    <div class="col-lg-10">
                        <form:input type="text" id="email" path="email" class="form:input-large" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary" value="Add Client" />
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
                <div><p style="margin-left: 150px; color: red; font-weight: bold">${error}</p></div>
</body>
</html>
