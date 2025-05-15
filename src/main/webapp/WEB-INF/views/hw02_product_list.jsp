<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<ul>
    <c:forEach var="product" items="${products}">
        <li>${product}</li>
    </c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/hw02/add">Thêm sản phẩm mới</a>
</body>
</html>
