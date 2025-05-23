<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 23/05/2025
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test phone</title>
</head>
<body>
<form:form method="post" modelAttribute="phoneDTO" action="hw06">
    <form:input path="phone" placeholder="phone..."/>
    <br>
    <form:errors path="phone" cssStyle="color: red"/>
    <br>
    <form:button>test</form:button>
</form:form>
</body>
</html>
