<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 16/05/2025
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Đặt vé xem phim</title>
  <style>
    .seat {
      display: inline-block;
      width: 30px;
      height: 30px;
      margin: 5px;
      text-align: center;
      line-height: 30px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .available {
      background-color: #e0ffe0;
      cursor: pointer;
    }

    .booked {
      background-color: #ffcccc;
      cursor: not-allowed;
    }

    .reserved {
      background-color: #ffe680;
    }
  </style>
</head>
<body>

<h2>Đặt vé xem phim</h2>

<c:if test="${not empty error}">
  <p style="color: red">${error}</p>
</c:if>

<c:if test="${not empty schedule}">
  <p><strong>Phòng chiếu:</strong> ${screenRoom.screenRoomName}</p>
  <p><strong>Thời gian chiếu:</strong> ${schedule.showTime}</p>
  <p><strong>Định dạng:</strong> ${schedule.format}</p>

  <h3>Danh sách ghế</h3>
  <form action="${pageContext.request.contextPath}/ticket/confirm" method="post">
    <input type="hidden" name="scheduleId" value="${schedule.id}"/>

    <c:forEach var="seat" items="${seats}">
      <label class="seat
                ${seat.status == 'AVAILABLE' ? 'available' : ''}
                ${seat.status == 'BOOKED' ? 'booked' : ''}
                ${seat.status == 'RESERVED' ? 'reserved' : ''}">
        <c:if test="${seat.status == 'AVAILABLE'}">
          <input type="checkbox" name="seatIds" value="${seat.id}" />
        </c:if>
          ${seat.id}
      </label>
    </c:forEach>

    <br/><br/>
    <button type="submit">Xác nhận đặt vé</button>
  </form>
</c:if>

<p><a href="<c:url value='/home'/>">Quay lại trang chủ</a></p>

</body>
</html>
