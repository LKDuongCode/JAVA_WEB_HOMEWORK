
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>hw01</title>
</head>
<body>
<button>
    <a href="${pageContext.request.contextPath}/book?action=add">add new book</a>
</button>
<table border="1">
    <tr>
        <th>#</th>
        <th>TITLE</th>
        <th>AUTHOR</th>
        <th>CATEGORY</th>
        <th>QUANTITY</th>
        <th>ACTION</th>
    </tr>

    <c:if test="${empty books}">
        <tr>
            <td colspan="6" style="text-align: center;">
                Book list is empty!
            </td>
        </tr>
    </c:if>

    <c:if test="${not empty books}">
        <c:forEach var="b" items="${books}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${b.title}</td>
                <td>${b.author}</td>
                <td>${b.category}</td>
                <td>${b.quantity}</td>
                <td style="display: flex; gap: 10px">
                    <button><a href="${pageContext.request.contextPath}/book?action=edit&code=${b.id}">edit</a></button>
                    <button><a href="${pageContext.request.contextPath}/book?action=delete&code=${b.id}"  onclick="return confirm('Bạn có chắc muốn xóa sách này?');">delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </c:if>

</table>
<a href="${pageContext.request.contextPath}/auth?action=logout">logout</a>
</body>
</html>
