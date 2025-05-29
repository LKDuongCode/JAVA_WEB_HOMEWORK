<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách giỏ hàng</title>
</head>
<body>
<h2>Sản phẩm vừa thêm: ${lastProduct}</h2>

<table border="1">
  <tr>
    <th>Tên sản phẩm</th>
    <th>Số lượng</th>
    <th>Xóa</th>
  </tr>
  <c:forEach items="${cart}" var="item">
    <tr>
      <td>${item.name}</td>
      <td>${item.quantity}</td>
      <td>
        <a href="${pageContext.request.contextPath}/hw04/delete/${item.name}">
          Xóa
        </a>
      </td>
    </tr>
  </c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/hw04/add">Thêm sản phẩm mới</a></p>
</body>
</html>
