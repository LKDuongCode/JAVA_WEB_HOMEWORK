<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Edit Seat</title></head>
<style>
    .form-container { display: flex; flex-direction: column; gap: 4px; width: 300px; border: black solid; padding: 6px; }
</style>
<body>
<h3>Edit Seat</h3>

<form:form method="post" modelAttribute="updateSeatDTO"
           action="${pageContext.request.contextPath}/seats/edit"
           cssClass="form-container">

    <form:hidden path="id"/>

    <p>Seat Name</p>
    <form:input path="nameSeat"/>
    <form:errors path="nameSeat" cssStyle="color:red"/>

    <p>Price</p>
    <form:input path="price" type="number"/>
    <form:errors path="price" cssStyle="color:red"/>

    <p>Status</p>
    <form:select path="status">
        <form:option value="AVAILABLE"/>
        <form:option value="BOOKED"/>
    </form:select>
    <form:errors path="status" cssStyle="color:red"/>

    <form:button>Update Seat</form:button>
</form:form>

<a href="${pageContext.request.contextPath}/seats/bus/${updateSeatDTO.busId}" class="btn-basic">Back</a>
</body>
</html>
