<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />" type="text/css" >

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <title>Products</title>
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
           <a href='<c:url value="/clients" />' class="btn btn-default pull-right"> <span class="glyphicon glyphicon-user glyphicon"></span> Clients</a>
            <a href='<c:url value="/sales" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> Sales</a>
            <a href='<c:url value="/products/add" />' class="btn btn-default pull-right"  > <span class="glyphicon-plus-sign glyphicon"></span> Add Product</a>

            <h1>Product</h1>
            <p>Update product</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="updateProduct" enctype="multipart/form-data" class="form-horizontal">
        <fieldset>
            <legend>Add new product</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                <div class="col-lg-10">
                    <form:input id="name" type="text" path="name" class="form:input-large" value="${updateProduct.name}" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice">Price</label>
                <div class="col-lg-10">
                    <form:input type="text" id="unitPrice" path="unitPrice" class="form:input-large" value="${updateProduct.unitPrice}" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Stock</label>
                <div class="col-lg-10">
                    <form:input type="text" id="unitsInStock" path="unitsInStock" class="form:input-large"  value="${updateProduct.unitsInStock}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">Description</label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2" value="${updateProduct.description}" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
                <div class="col-lg-10">
                    <form:input type="text" class="form:input-large" id="manufacturer" path="manufacturer"  value="${updateProduct.manufacturer}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
                <div class="col-lg-10">
                    <form:input type="text" class="form:input-large" id="category" path="category"  value="${updateProduct.category}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="Update Product" />
                </div>
            </div>
                    <form:input name="condition" path="condition" value="${updateProduct.condition}" type="hidden"/>
        </fieldset>
    </form:form>
</section>
             <div><p style="margin-left: 150px; color: red; font-weight: bold">${error}</p></div>
<br><br>
</body>
</html>