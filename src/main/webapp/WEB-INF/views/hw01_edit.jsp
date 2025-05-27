<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 25/05/2025
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit student</title>
</head>
<style>
    .container {
        display: flex;
        flex-direction: column;
        gap: 4px;
    }
    .form {
        width: 300px;
        display: flex;
        flex-direction: column;
        gap: 4px;
        border: black solid;
        padding: 6px;
    }
</style>
<body>
<h3>edit student</h3>
<form:form method="post" modelAttribute="updateDTO" action="${pageContext.request.contextPath}/students/edit" cssClass="form">
    <form:hidden path="id"/>

    <div class="container">
        <p>name</p>
        <form:input path="name"/>
        <form:errors path="name" cssStyle="color: red"/>
    </div>

    <div  class="container">
        <p>email</p>
        <form:input path="email"/>
        <form:errors path="email" cssStyle="color: red"/>
    </div>

    <div  class="container">
        <p>date of birth</p>
        <form:input path="dob" type="date"/>
        <form:errors path="dob" cssStyle="color: red"/>
    </div>

    <form:button>update</form:button> <br>
    <a href="${pageContext.request.contextPath}/students">back</a>
</form:form>
</body>
</html>
