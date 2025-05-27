<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 25/05/2025
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<style>
    .add-container {
        display: flex;
        flex-direction: column;
        gap: 4px;
    }
    .add-form {
        width: 300px;
        display: flex;
        flex-direction: column;
        gap: 4px;
        border: black solid;
        padding: 6px;
    }
</style>
<body>
<h3>add new product</h3>
<form:form method="post" modelAttribute="createDTO" action="${pageContext.request.contextPath}/products/add" cssClass="add-form" enctype="multipart/form-data">
    <div class="add-container">
        <p>name</p>
        <form:input path="name"/>
        <form:errors path="name" cssStyle="color: red"/>
    </div>

    <div  class="add-container">
        <p>price</p>
        <form:input path="price" type="number"/>
        <form:errors path="price" cssStyle="color: red"/>
    </div>

    <div  class="add-container">
        <p>quantity</p>
        <form:input path="quantity" type="number"/>
        <form:errors path="quantity" cssStyle="color: red"/>
    </div>

    <div  class="add-container">
        <p>image</p>
        <form:input path="image" type="file"/><br><br>
        <form:errors path="image" cssStyle="color: red" />
    </div>

    <form:button>add</form:button>
</form:form>
</body>
</html>