<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 13/05/2025
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<c:forEach var="product" items="${products}">
    <div style="border: 1px solid black; margin: 10px; padding: 10px;">
        <h3>${product.name}</h3>
        <p>Giá: ${product.price}</p>
        <img src="${product.imageUrl}" width="150">
        <form action="${pageContext.request.contextPath}/products" method="post">
            <input type="hidden" name="productId" value="${product.id}">
            <input type="number" name="quantity" value="1" min="1">
            <button type="submit">Thêm vào giỏ</button>
        </form>
    </div>
</c:forEach>

<a href="${pageContext.request.contextPath}/cart">Xem giỏ hàng</a>
</body>
</html>

