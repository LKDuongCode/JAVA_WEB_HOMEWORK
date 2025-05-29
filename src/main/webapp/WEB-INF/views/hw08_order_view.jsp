<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Đơn hàng của bạn</title>
</head>
<body>
<h2>Thông tin đơn hàng:</h2>
<p>Họ tên: ${order.customerName}</p>
<p>Sản phẩm: ${order.product}</p>
<p>Số lượng: ${order.quantity}</p>

<p><a href="${pageContext.request.contextPath}/hw08/order">Đặt đơn mới</a></p>
</body>
</html>

