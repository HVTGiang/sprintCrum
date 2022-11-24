<%--
  Created by IntelliJ IDEA.
  User: Trường Giang
  Date: 23-Nov-22
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<form action="login" method="post">
    <p>${message}</p>
    <label for="">Username</label>
    <br>
    <input type="text" name="username" id="username">
    <br>
    <label for="">Password</label>
    <br>
    <input type="password" name="password" id="password">
    <br>
    <input type="radio" name="role" id="student" value="student">
    <label>Student</label>
    <br>
    <input type="radio" name="role" id="admin" value="admin">
    <label>Admin</label>
    <br>
    <input type="radio" name="role" id="lecturer" value="lecturer">
    <label>Lecturer</label>
    <br>
    <input type="radio" name="role" id="head" value="head">
    <label>Head lecturer</label>
    <br>
    <input type="submit" value="Đăng nhập">
</form>
</body>
</html>
