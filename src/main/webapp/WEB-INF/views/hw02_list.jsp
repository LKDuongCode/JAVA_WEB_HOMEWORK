<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 25/05/2025
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<style>
    .btn-basic {
        display: inline-block;
        padding: 2px 6px;
        font-size: 13px;
        line-height: normal;
        color: black;
        background-color: #e0e0e0;
        border: 1px solid #aaa;
        border-radius: 3px;
        text-decoration: none;
        font-family: sans-serif;
    }

    .btn-basic:hover {
        background-color: #d5d5d5;
    }
</style>
<body>
<h3>product list</h3>

<a href="${pageContext.request.contextPath}/products/add" class="btn-basic">add product</a>

<br>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>quantity</th>
        <th>image</th>
        <th>action</th>
    </tr>

    <c:choose>
        <c:when test="${empty products}">
            <tr>
                <td colspan="6">product list is empty!</td>
            </tr>
        </c:when>

        <c:otherwise>
            <c:forEach var="p" items="${products}" varStatus="loop">
                <tr>
                    <td>CODE-${p.id}</td>
                    <td>${p.name}</td>
                    <td>$${p.price}</td>
                    <td>${p.quantity}</td>
                    <td><img src="${pageContext.request.contextPath}/uploads/${p.image}" alt="${p.name}" width="200"></td>
                    <td>
                        <div style="display: flex; gap: 5px;">
                            <a href="${pageContext.request.contextPath}/products/edit/${p.id}" class="btn-basic">edit</a>

                            <form method="post"
                                  action="${pageContext.request.contextPath}/products/delete/${p.id}"
                                  onsubmit="return confirm('Are you sure to delete this product?')"
                                  style="display:inline;">
                                <button class="btn-basic" type="submit">delete</button>
                            </form>
                        </div>
                    </td>

                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>


</table>
</body>
</html>
