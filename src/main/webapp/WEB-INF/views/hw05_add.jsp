
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Thêm đơn hàng</title></head>
<body>
<h2>Thêm đơn hàng</h2>

<form action="${pageContext.request.contextPath}/hw05/add" method="post">
  Mã đơn hàng: <input type="text" name="orderId"/><br>
  Tên sản phẩm: <input type="text" name="productName"/><br>
  Số lượng: <input type="number" name="quantity"/><br>
  <button type="submit">Thêm</button>
</form>
</body>
</html>

