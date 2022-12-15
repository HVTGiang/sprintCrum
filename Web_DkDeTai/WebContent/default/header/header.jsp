<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/asset/css/reset.css">
    <link rel="stylesheet" href="/asset/css/base.css">
    <link rel="stylesheet" href="/asset/css/header-styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <title>Header</title>
</head>

<body>
<div id="header-container">
    <div id="header-content">
        <img src="/asset/img/UTE.png" alt="" srcset="">
        <div id="header-text">
            <p id="title-vi">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT TP.HCM</p>
            <p id="title-en">HCMC University of Technology and Education</p>
            <hr>
            <p id="sub-title">Khoa Công nghệ Thông tin</p>
        </div>
    </div>
    <div id="header-img">
        <img src="/asset/img/Banner_1.png" alt="Header image" srcset="">
    </div>
</div>
<div id="header-nav">
    <a id="header-home" href="">
        <i class="fa-solid fa-house"></i>
        <p>Trang chủ</p>
    </a>
    <a id="header-login" href="">
        <i class="fa-solid fa-right-to-bracket"></i>
        <c:if test="${not empty sessionScope.p}">
            <p>Đăng xuất</p>
        </c:if>
        <c:if test="${empty sessionScope.p}">
            <p>Đăng nhập</p>
        </c:if>
    </a>
</div>
</body>

</html>