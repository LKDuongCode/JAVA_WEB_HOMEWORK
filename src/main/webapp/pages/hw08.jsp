<%-- Created by IntelliJ IDEA. User: duong Date: 06/05/2025 Time: 08:13 To
change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.ss01.homework_ss01.Task" %>
<html>
<head>
  <title>Quản lý công việc</title>
</head>
<body>
<h2>Thêm công việc mới</h2>
<form action="hw08" method="post">
  <input type="text" name="title" placeholder="Tên công việc">
  <button type="submit">Thêm</button>
</form>

<h2>Danh sách công việc</h2>
<ul>
  <%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
    if (tasks != null) {
      for (int i = 0; i < tasks.size(); i++) {
        Task task = tasks.get(i);
  %>
  <li>
    <% if (task.isCompleted()) { %>
    <s><%= task.getTitle() %></s>
    <% } else { %>
    <%= task.getTitle() %>
    <form action="hw08" method="post" style="display:inline;">
      <input type="hidden" name="complete" value="<%= i %>">
      <button type="submit">tick hoàn thành</button>
    </form>
    <% } %>
  </li>
  <%
      }
    }
  %>
</ul>
</body>
</html>
