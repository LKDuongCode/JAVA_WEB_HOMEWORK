<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/05/2025
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách ghế phòng chiếu số 8</title>
    <style>
        .seat-btn {
            width: 50px;
            height: 30px;
            margin: 3px;
        }
        .booked {
            background-color: black;
            color: white;
        }
        .selected {
            background-color: blue;
            color: white;
        }
    </style>
</head>
<body>
<h2 style="text-align: center;">Danh sách ghế phòng chiếu số 8</h2>
<form method="post" action="hw09" style="text-align: center;">
    <c:forEach var="seat" items="${seats}">
        <c:if test="${seat.code.endsWith('1')}">
            <br/>
        </c:if>
        <c:choose>
            <c:when test="${seat.booked}">
                <button type="button" class="seat-btn booked" disabled>${seat.name}</button>
            </c:when>
            <c:otherwise>
                <input type="checkbox" name="selectedSeats" value="${seat.code}" hidden>
                <button type="button" class="seat-btn" onclick="toggleSeat(this)">${seat.name}</button>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <br/><br/>
    <button type="submit">Thanh toán</button>
</form>

<c:if test="${not empty total}">
    <c:choose>
        <c:when test="${hasSelection}">
            <p style="text-align:center;">Tổng số tiền phải thanh toán của bạn là: ${total}</p>
        </c:when>
        <c:otherwise>
            <p style="text-align:center; color:red;">Vui lòng chọn ghế trước khi thanh toán!</p>
        </c:otherwise>
    </c:choose>
</c:if>

<script>
    function toggleSeat(button) {
        const checkbox = button.previousElementSibling;
        checkbox.checked = !checkbox.checked;
        button.classList.toggle('selected', checkbox.checked);
    }
</script>
</body>
</html>

