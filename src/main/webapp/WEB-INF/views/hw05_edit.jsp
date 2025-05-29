<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Sửa đơn hàng</title></head>
<body>
<h2>Sửa đơn hàng</h2>

<form action="${pageContext.request.contextPath}/hw05/edit" method="post">
  <input type="hidden" name="originalId" value="${originalId}"/>
  Mã đơn hàng: <input type="text" name="orderId" value="${orderItem.orderId}"/><br>
  Tên sản phẩm: <input type="text" name="productName" value="${orderItem.productName}"/><br>
  Số lượng: <input type="number" name="quantity" value="${orderItem.quantity}"/><br>
  <button type="submit">Cập nhật</button>
</form>

</body>
</html>
