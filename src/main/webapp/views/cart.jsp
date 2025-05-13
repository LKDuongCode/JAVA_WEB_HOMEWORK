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
    <title>Giỏ hàng</title>
</head>
<body>
<h1>Giỏ hàng</h1>

<table border="1">
    <tr>
        <th>Sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Tổng</th>
        <th>Hành động</th>
    </tr>
    <c:set var="total" value="0" />
    <c:forEach var="item" items="${cartItems}">
        <c:forEach var="product" items="${products}">
            <c:if test="${item.productId == product.id}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${item.quantity}</td>
                    <td>${product.price * item.quantity}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/cart" method="post">
                            <input type="hidden" name="cartId" value="${item.id}">
                            <button type="submit">Xóa</button>
                        </form>
                    </td>
                </tr>
                <c:set var="total" value="${total + (product.price * item.quantity)}" />
            </c:if>
        </c:forEach>
    </c:forEach>
</table>

<h3>Tổng tiền: ${total}</h3>

<a href="${pageContext.request.contextPath}/products">Tiếp tục mua sắm</a>
</body>
</html>
