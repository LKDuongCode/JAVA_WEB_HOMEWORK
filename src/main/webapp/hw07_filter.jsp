<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/05/2025
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Lọc sản phẩm theo giá</title>
</head>
<body>

<h2>Lọc sản phẩm theo khoảng giá</h2>
<form method="post" action="hw07">
    Giá tối thiểu: <input type="text" name="minPrice" />
    Giá tối đa: <input type="text" name="maxPrice" />
    <button type="submit">Lọc</button>
</form>

<c:if test="${not empty filteredProducts}">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
        </tr>
        <c:forEach var="p" items="${filteredProducts}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${fn:length(filteredProducts) == 0}">
        <p style="color:red;">Không có sản phẩm nào trong khoảng giá này</p>
    </c:if>
</c:if>

</body>
</html>
