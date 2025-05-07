<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 07/05/2025
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="
padding: 20px;
display: flex;
flex-direction: column;
gap: 10px;
align-items: center;
justify-content: center;
width: max-content;
border: solid;
">
    <h3>Cập nhật sản phẩm</h3>
    <form action="product-servlet" method="post">
        <input type="hidden" name="productId" value="${product.id}">
        <label for="name">Tên:</label>
        <input type="text" name="name" id="name" value="${product.name}">
        <br>
        <label for="price">Giá:</label>
        <input type="number" name="price" id="price" value="${product.price}">
        <br>
        <button type="submit" name="action" value="edit">Cập nhật</button>
    </form>


    <hr>
</div>
</body>
</html>
