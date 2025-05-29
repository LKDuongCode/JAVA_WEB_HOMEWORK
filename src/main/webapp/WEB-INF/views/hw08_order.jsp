<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Đặt hàng</title>
</head>
<body>
<h2>Đặt hàng</h2>
<form action="${pageContext.request.contextPath}/hw08/order" method="post">
  <label>Họ tên:</label><br>
  <input type="text" name="customerName"><br><br>

  <label>Sản phẩm:</label><br>
  <input type="text" name="product"><br><br>

  <label>Số lượng:</label><br>
  <input type="number" name="quantity" min="1" value="1"><br><br>

  <button type="submit">Đặt hàng</button>
</form>
</body>
</html>
