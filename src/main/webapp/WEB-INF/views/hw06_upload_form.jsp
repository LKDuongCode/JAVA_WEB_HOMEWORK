<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 19/05/2025
  Time: 06:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload form</title>
</head>
<body>
<h1>Upload form</h1>
<form:form action="hw06-cloudinary" method="post" modelAttribute="file-hw06" enctype="multipart/form-data">
    <p>
        file : <form:input path="file" type="file"/>
    </p>

    <p>
        des : <form:input path="des"/>
    </p>

    <form:button>upload</form:button>
</form:form>

<c:if test="${not empty fileURL}">
    <p>url : ${fileURL}</p>
    <img src="${fileURL}" width="150" alt="file uploaded"/>
    <p>des: ${des}</p>
</c:if>
</body>
</html>
