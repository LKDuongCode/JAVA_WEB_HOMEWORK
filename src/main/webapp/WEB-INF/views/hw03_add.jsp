<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Add Bus</title></head>
<style>
    .form-container { display: flex; flex-direction: column; gap: 4px; width: 300px; border: black solid; padding: 6px; }
</style>
<body>
<h3>Add New Bus</h3>
<form:form method="post" modelAttribute="createDTO" action="${pageContext.request.contextPath}/buses/add"
           enctype="multipart/form-data" cssClass="form-container">

    <p>License Plate</p>
    <form:input path="licensePlate"/>
    <form:errors path="licensePlate" cssStyle="color:red"/>

    <p>Bus Type</p>
    <form:select path="busType">
        <form:option value="" label="--Select Type--"/>
        <form:option value="NORMAL"/>
        <form:option value="VIP"/>
        <form:option value="LUXURY"/>
    </form:select>
    <form:errors path="busType" cssStyle="color:red"/>

    <p>Row Seat</p>
    <form:input path="rowSeat" type="number"/>
    <form:errors path="rowSeat" cssStyle="color:red"/>

    <p>Col Seat</p>
    <form:input path="colSeat" type="number"/>
    <form:errors path="colSeat" cssStyle="color:red"/>

    <p>Image</p>
    <form:input path="imageFile" type="file"/>
    <form:errors path="imageFile" cssStyle="color:red"/>

    <form:button>Add</form:button>
</form:form>
</body>
</html>
