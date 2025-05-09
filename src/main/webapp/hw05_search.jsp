<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/05/2025
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Search Product</title>
</head>
<body>
<h2>Search Product by ID</h2>

<form method="post" action="hw05">
  <input type="text" name="productId" placeholder="Enter product ID">
  <button type="submit">Search</button>
</form>

<c:choose>
  <c:when test="${not empty product}">
    <h3>Product Found:</h3>
    <p>ID: ${product.id}</p>
    <p>Name: ${product.name}</p>
    <p>Price: $${product.price}</p>
    <p>Description: ${product.description}</p>
  </c:when>
  <c:otherwise>
    <c:if test="${param.productId != null}">
      <p style="color:red;">Sản phẩm không tìm thấy</p>
    </c:if>
  </c:otherwise>
</c:choose>

</body>
</html>
