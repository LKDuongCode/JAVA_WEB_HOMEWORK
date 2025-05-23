<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 23/05/2025
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<h3>Category Add Form</h3>

<form:form method="post" modelAttribute="categoryDTO"  action="${pageContext.request.contextPath}/hw0809-add-save">
    <form:input path="name" placeholder="name..." />
    <form:errors path="name" cssStyle="color:red"/>
    <br>
    <form:button>Add</form:button>
</form:form>

</body>
</html>
