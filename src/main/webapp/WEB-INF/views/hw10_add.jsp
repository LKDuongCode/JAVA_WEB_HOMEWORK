<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
</head>
<body>
<h2><spring:message code="form.title"/></h2>

<form action="${pageContext.request.contextPath}/categories/add" method="post">

    <label><spring:message code="label.name.vi"/></label><br>
    <input type="text" name="vi.categoryName" value="${vi.categoryName}"/><br><br>

    <label><spring:message code="label.description.vi"/></label><br>
    <input type="text" name="vi.description" value="${vi.description}"/><br><br>


    <label><spring:message code="label.name.en"/></label><br>
    <input type="text" name="en.categoryName" value="${en.categoryName}"/><br><br>

    <label><spring:message code="label.description.en"/></label><br>
    <input type="text" name="en.description" value="${en.description}"/><br><br>

    <button type="submit">
        <spring:message code="button.submit"/>
    </button>
</form>

</body>
</html>
