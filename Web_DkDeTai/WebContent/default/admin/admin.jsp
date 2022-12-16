<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý đề tài | Admin</title>

    <!-- logo title -->
    <link rel="icon" href="./asset/img/fit-logo.png" type="image/icon type">
    <!-- CSS -->
    <link rel="stylesheet" href="/asset/css/reset.css">
    <link rel="stylesheet" href="/asset/css/base.css">
    <link rel="stylesheet" href="<c:url value = "/default/admin/css/main.css"/>">
    <!-- icon -->
    <script src="https://kit.fontawesome.com/18ce1a4b11.js" crossorigin="anonymous"></script>
    <!-- Add html khác -->
    <script src="https://unpkg.com/htmlincludejs"></script>
</head>

<body>
<!-- Header -->
<!--<div id="header"></div>
script src="./asset/script/header-import.js"></script>-->
<jsp:include page="/default/header/header.jsp"/>

<!-- Content -->
<div id="content">
    <!-- Menu -->
    <div id="menu">
        <div class="content__menu">
            <div class="menu__header">
                <h3>Danh mục</h3>
            </div>
            <ul class="menu__nav">
                <li class="selected">
                    <a href="${pageContext.request.contextPath}/admin">
                        <i class="fa-solid fa-house"></i>
                        Trang chủ
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="fa-solid fa-circle-plus"></i>
                        Quản lý đợt đăng ký
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/committee">
                        <i class="fa-solid fa-users"></i>
                        Quản lý hội đồng
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="fa-solid fa-circle-info"></i>
                        Thông tin cá nhân
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/account">
                        <i class="fa-solid fa-user"></i>
                        Quản lý tài khoản
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div id="content-main">
        <!-- Breadcumb -->
        <div id="content-breadcumb">
            <p>Trang chủ</p>
        </div>
        <!-- Notify -->
        <div id="content-notify">
            <div id="content-notify-header">
                <i class="fa-sharp fa-solid fa-circle-exclamation"></i>
                <p>Thông báo</p>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <jsp:include page="/default/footer/footer.jsp"/>
</div>
<!-- Footer -->
<!--<div id="footer"></div>
<script src="./asset/script/footer-import.js"></script>-->
</body>

</html>