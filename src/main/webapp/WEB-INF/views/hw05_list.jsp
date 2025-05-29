
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Danh sách đơn hàng</title></head>
<body>
<h2>Danh sách đơn hàng</h2>

<table border="1">
  <tr>
    <th>#</th>
    <th>Mã đơn</th>
    <th>Sản phẩm</th>
    <th>Số lượng</th>
    <th>Thao tác</th>
  </tr>
  <c:forEach items="${orders}" var="o" varStatus="i">
    <tr>
      <td>${i.index+1}</td>
      <td>${o.orderId}</td>
      <td>${o.productName}</td>
      <td>${o.quantity}</td>
      <td>
        <a href="${pageContext.request.contextPath}/hw05/edit/${o.orderId}">
          Sửa
        </a>
        <a href="${pageContext.request.contextPath}/hw05/delete/${o.orderId}">
          Xoá
        </a>

      </td>
    </tr>
  </c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/hw05/add">Thêm đơn hàng mới</a></p>
</body>
</html>

