<%@ page import="com.duong.ss02.hw06.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 07/05/2025
  Time: 08:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
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
    <h3>Thêm sản phẩm</h3>
    <form action="product-servlet" method="post">
        <label for="name">Tên:</label>
        <input type="text" name="name" id="name">
        <br>
        <label for="price">Giá:</label>
        <input type="number" name="price" id="price">
        <br>

        <button type="submit" name="action" value="add">Thêm mới</button>
    </form>

    <hr>
</div>
<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>ACTION</th>
        </tr>
        <%
            Object obj = request.getAttribute("products");
            if (obj == null) {
        %>
        <p>Không có sản phẩm nào!</p>
        <%
        } else {
            List<Product> products = (List<Product>) obj;
            for (Product p : products) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td  style="display: flex; gap: 10px" >
                <form action="product-servlet" method="get">
                    <input type="hidden" name="action" value="showEdit">
                    <input type="hidden" name="productId" value="<%= p.getId() %>">
                    <button type="submit">sửa</button>
                </form>
                <form action="product-servlet" method="post" onsubmit="return confirm('Bạn có chắc muốn xóa sản phẩm này không?');">
                    <input type="hidden" name="productId" value="<%= p.getId() %>">
                    <button type="submit" name="action" value="delete">xóa</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>

    </table>
</div>
</body>
</html>
