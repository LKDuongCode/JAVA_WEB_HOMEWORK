<%@ page import="com.ss01.homework_ss01.StudentTicket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 06/05/2025
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2 style="text-align:center;">Danh sách sinh viên</h2>
<table>
    <tr>
        <th>Họ và tên</th>
        <th>Lớp</th>
        <th>Loại xe</th>
        <th>Biển số xe</th>
    </tr>
    <table>
        <%
            List<StudentTicket> studentList = (List<StudentTicket>) request.getAttribute("studentList");
            for (StudentTicket student : studentList) {
        %>
        <tr>
            <td><%= student.getFullName() %></td>
            <td><%= student.getClassName() %></td>
            <td><%= student.getVehicleType() %></td>
            <td><%= student.getLicensePlate() %></td>
        </tr>
        <%
            }
        %>
    </table>

</table>
</body>
</html>
