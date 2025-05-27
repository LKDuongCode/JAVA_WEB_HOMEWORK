<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 24/05/2025
  Time: 15:38
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
<h3>student list</h3>

<a href="${pageContext.request.contextPath}/students/add" class="btn-basic">add student</a>

<br>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>dob</th>
        <th>action</th>
    </tr>

    <c:choose>
        <c:when test="${empty students}">
            <tr>
                <td colspan="5">student list is empty!</td>
            </tr>
        </c:when>

        <c:otherwise>
            <c:forEach var="s" items="${students}" varStatus="loop">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>${s.dob.dayOfMonth}/${s.dob.monthValue}/${s.dob.year}</td>
                    <td>
                        <div  style="display: flex; gap: 5px;">
                            <a href="${pageContext.request.contextPath}/students/edit/${s.id}" class="btn-basic">edit</a>

                            <form method="post" action="${pageContext.request.contextPath}/students/delete/${s.id}" >
                                <button type="submit" onclick="return confirm('are you sure to delete this student?')">delete</button>
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
