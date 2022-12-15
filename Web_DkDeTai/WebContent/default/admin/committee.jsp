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
    <link rel="icon" href="/asset/img/fit-logo.png" type="image/icon type">
    <!-- CSS -->
    <link rel="stylesheet" href="/asset/css/reset.css">
    <link rel="stylesheet" href="/asset/css/base.css">
    <link rel="stylesheet" href="<c:url value = "/default/admin/css/committee.css"/>">
    <!-- icon -->
    <script src="https://kit.fontawesome.com/18ce1a4b11.js" crossorigin="anonymous"></script>
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
                <li class="">
                    <a href="">
                        <i class="fa-solid fa-circle-plus"></i>
                        Quản lý đợt đăng ký
                    </a>
                </li>
                <li class="selected">
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
                    <a href="">
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
            <p>
                <a href="#" class="breadcumb-item hover-item">
                    <span>Trang chủ</span>
                </a>
                <span class="breadcumb-item"> > </span>
                <span>Quản lý hội đồng</span>
            </p>
        </div>

        <c:if test="${not empty message}">
            <div id="message-box"
                 style="display: flex;
                        padding: 12px;
                        justify-content: space-between;
                        background-color: var(--light__blue-color);
                        margin-bottom: 16px;"
            >
                <p style="color: var(--orange-color)">
                        ${message}
                </p>
                <span id="close-message-button"><i class="fa-solid fa-xmark"
                                                   style="color: var(--orange-color);"></i></span>
            </div>
        </c:if>

        <%--Action zone--%>
        <div id="action-zone">
            <%--Add button--%>
            <div class="add-button">
                <i class="fa-solid fa-circle-plus"></i>
                <a href="/admin/committee?action=insert">Tạo đợt</a>
            </div>
            <%--Find button--%>
            <div class="find-zone">
                <form action="/admin/committee" method="get">
                    <%--                    <label for="">Tìm kiếm</label>--%>
                    <input type="text" placeholder="Nhập tên hội đồng" class="find-text-box" name="find">
                    <input type="hidden" value="find" name="action">
                    <button><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>

            </div>
        </div>

        <!-- Notify -->
        <div id="content-notify">
            <div id="content-notify-header">
                <i class="fa-sharp fa-solid fa-circle-exclamation"></i>
                <p>Danh sách hội đồng</p>
            </div>
            <div id="content-notity-data-list">

                <%-- Data table--%>
                <c:if test="${not empty committeList}">
                    <table class="datatable">

                            <%-- Table header--%>
                        <thead>
                        <tr class="center-data align-item-center">
                            <th scope="col" class="center-cell witdh-column-5rem">#</th>
                            <th scope="col" class="center-cell">Tên hội đồng</th>
                            <th scope="col" class="center-cell witdh-column-10rem">Số thành viên</th>
                            <th scope="col" class="witdh-column-27rem center-cell">Mô tả</th>
                            <th scope="col" class="center-cell">Lựa chọn</th>
                        </tr>
                        </thead>
                            <%--End table header--%>

                            <%-- Table body--%>
                        <tbody>

                        <c:forEach items="${committeList}" var="c">
                            <tr class="center-data data-row">
                                <th scope="row" class="center-cell witdh-column-5rem"><a href="#">1</a></th>
                                <td class="justify-cell"><a href="">${c.committeName}</a></td>
                                <td class="center-cell witdh-column-10rem">${c.numMember}</td>
                                <td colspan="1" class="witdh-column-27rem justify-cell">
                                        ${c.description}
                                </td>
                                <td class="center-cell">
                                    <a href="/admin/committee?action=edit&committeeId=${c.committeId}"
                                       class="btn btn-primary edit-button action-column-element">Sửa</a>
                                    <form action="" method="post">
                                        <input class="delete-button action-column-element" type="submit"
                                               value="Xóa"
                                               onclick="if (confirm('Bạn có chắc chắn muốn xóa hội đồng này?')) { form.action=''; } else { return false; }"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                            <%--End table body--%>

                    </table>
                    <%--End data table--%>
                </c:if>

                <c:if test="${empty committeList}">
                    <div style="text-align: center; padding: 25px; color: var(--blue-color)">
                        Chưa có hội đồng
                    </div>
                </c:if>
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
<script>

    document.getElementById('close-message-button').addEventListener('click', (e) => {
        let parentElm = e.target.closest('#message-box')
        parentElm.remove()
    })

</script>

</body>

</html>