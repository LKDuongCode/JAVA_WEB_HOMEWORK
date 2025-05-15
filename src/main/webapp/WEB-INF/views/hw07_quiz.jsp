<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Quiz Game</title>
</head>
<body>
<h1>Đoán từ qua hình ảnh</h1>

<img src="${question.imageUrl}" alt="Câu hỏi" width="300" />

<c:if test="${not empty message}">
  <p style="color:blue;">${message}</p>
</c:if>

<c:if test="${not gameOver}">
  <form action="${pageContext.request.contextPath}/hw07/guess" method="post">
    Câu trả lời: <input type="text" name="answer" />
    <input type="submit" value="Đoán">
  </form>
</c:if>

<c:if test="${gameOver}">
  <form action="${pageContext.request.contextPath}/hw07/quiz" method="get">
    <input type="submit" value="Chơi lại">
  </form>
</c:if>
</body>
</html>
