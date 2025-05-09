<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/05/2025
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Check Product Info</title>
</head>
<body>

<c:choose>
    <c:when test="${not empty product}">
        <p>Sản phẩm: ${product}</p>
    </c:when>
    <c:otherwise>
        <p style="color: red;">Sản phẩm không có thông tin</p>
    </c:otherwise>
</c:choose>

</body>
</html>

