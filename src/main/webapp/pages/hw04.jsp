<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 06/05/2025
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <b>Các bước triển khai:</b>
    <br>
    1. Vào <b>Edit Configurations</b> 2. Click dấu + → chọn <b>Tomcat Server
    (Local)</b> (điều kiện: đã cài Tomcat trước đó) 3. Chuyển qua tab <b>Deployment</b> → click + để thêm
    <b>artifact</b> 4. (Option) Sửa lại <b>Application context</b> để dễ đọc hơn và chỉnh <b>URL</b> bên tab Server
    tương ứng 5. Bấm <b>Apply</b> → <b>OK</b> 6. Click nút tam giác xanh góc phải IDE để chạy
    <br><br>
    <b>Một số sự cố đã gặp:</b>
    <br>

    Tomcat cũ (v9) gây lỗi 404 khi chạy Jakarta (nên dùng Tomcat 10 trở lên)

    Quên sửa <b>Application context</b> hoặc quên chỉnh <b>URL</b> → URL dài, dễ sai hoặc 404

</div>
</body>
</html>
