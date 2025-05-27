<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit Student</title></head>
<body>
<h3>Edit Student</h3>

<form:form method="post" modelAttribute="updateDTO"
           action="${pageContext.request.contextPath}/students-lark/edit"
           enctype="multipart/form-data">
    <form:hidden path="id"/>
    <form:hidden path="avatar"/>

    Name: <form:input path="name"/><form:errors path="name" cssStyle="color:red"/><br>
    Email: <form:input path="email"/><form:errors path="email" cssStyle="color:red"/><br>
    Phone: <form:input path="phone"/><form:errors path="phone" cssStyle="color:red"/><br>

    Sex:
    <form:select path="sex">
        <form:option value="MALE"/>
        <form:option value="FEMALE"/>
        <form:option value="OTHER"/>
    </form:select>
    <form:errors path="sex" cssStyle="color:red"/><br>

    Birthdate: <form:input path="bod" type="datetime-local"/><form:errors path="bod" cssStyle="color:red"/><br>

    Current Avatar:
    <img src="${pageContext.request.contextPath}/uploads/${updateDTO.avatar}" width="100"/><br>
    Upload New: <form:input path="avatarFile" type="file"/><br>

    Status:
    <form:select path="status">
        <form:option value="ACTIVE"/>
        <form:option value="INACTIVE"/>
    </form:select>
    <form:errors path="status" cssStyle="color:red"/><br>

    <form:button>Update</form:button>
</form:form>
</body>
</html>
