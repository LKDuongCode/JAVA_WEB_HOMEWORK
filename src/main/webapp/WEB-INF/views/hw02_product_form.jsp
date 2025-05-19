<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 17/05/2025
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>add product form</title>
</head>
<body>
<br>
<c:choose>
    <c:when test="${product.name == null and product.des == null and product.price == 0}">
        <h3>add product</h3>
        <form:form method="post" action="hw02-result" modelAttribute="product">
            <form:input path="name" placeholder="name..."/>
            <form:input path="price" />
            <form:input path="des" placeholder="description..."/>
            <button type="submit">submit</button>
        </form:form>
    </c:when>

    <c:otherwise>
        <h3>Product Info</h3>
        <p>Name: ${product.name}</p>
        <p>Price: ${product.price}</p>
        <p>Description: ${product.des}</p>
    </c:otherwise>
</c:choose>

</body>
</html>
