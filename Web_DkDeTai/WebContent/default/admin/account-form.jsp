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
    <link rel="stylesheet" href="<c:url value = "/default/admin/css/account-form.css"/>">
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
                    <a href="${pageContext.request.contextPath}/admin">
                        <i class="fa-solid fa-house"></i>
                        Trang chủ
                    </a>
                </li>
                <li class="">
                    <a href="">
                        <i class="fa-solid fa-circle-plus"></i>
                        Quản lý đợt đăng ký
                    </a>
                </li>
                <li class="">
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
                <li class="selected">
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
            <p>
                <a href="#" class="breadcumb-item hover-item">
                    <span>Trang chủ</span>
                </a>
                <span class="breadcumb-item"> > </span>
                <span>Quản lý tài khoản</span>
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
        <%--&lt;%&ndash;Action zone&ndash;%&gt;
        <div id="action-zone">
          &lt;%&ndash;Add button&ndash;%&gt;
          <div class="add-button">
            <i class="fa-solid fa-circle-plus"></i>
            <a href="">Tạo đợt</a>
          </div>
          &lt;%&ndash;Find button&ndash;%&gt;
          <div class="find-zone">
            <form action="">
              &lt;%&ndash;                    <label for="">Tìm kiếm</label>&ndash;%&gt;
              <input type="text" placeholder="Nhập tên hội đồng" class="find-text-box">
              <button><i class="fa-solid fa-magnifying-glass"></i></button>
            </form>

          </div>
        </div>--%>

        <!-- Notify -->
        <div id="content-notify">
            <div id="content-notify-header">
                <i class="fa-sharp fa-solid fa-circle-exclamation"></i>
                <p>${action.equals("insert")?"Thêm tài khoản":"Chi tiết tài khoản"}</p>
            </div>
            <div id="content-notity-data-list">

                <form action="${pageContext.request.contextPath}/admin/account" method="post" class="input-form">
                    <div class="input-value">
                        <label class="input-label">Họ tên</label>
                        <input type="text" name="accountFullName" class="input-text-box"
                               value="${account.person.fullName}" ${action.equals("insert")?"required":"readonly"}>

                    </div>
                    <div class="input-value">
                        <label class="input-label">Username</label>
                        <input type="text" name="accountUsername" class="input-text-box"
                               value="${account.username}" ${action.equals("insert")?"required":"readonly"}>

                    </div>
                    <div class="input-value">
                        <label class="input-label">Password</label>
                        <input type="text" name="accountPassword" class="input-text-box"
                               value="${account.password}" ${action.equals("insert")?"required":"readonly"}>

                    </div>
                    <div class="input-value">
                        <label class="input-label">Giới tính</label>
                        <div class="input-value-row">
                            <div style="margin-right: 4rem;">
                                <span>Nam</span>
                                <input type="radio" name="accountGender"
                                       class="" ${account.person.gender==1?"checked":""} checked value="male" ${action.equals("insert")?"":"disabled"}>
                            </div>
                            <div>
                                <span>Nữ</span>
                                <input type="radio" name="accountGender"
                                       class="" ${account.person.gender==0?"checked":""} value="female" ${action.equals("insert")?"":"disabled"}>
                            </div>
                        </div>
                    </div>
                    <div class="input-value">
                        <label class="input-label">Số điện thoại</label>
                        <input type="text" name="accountPhone" class="input-text-box"
                               value="${account.person.phonenumber}" ${action.equals("insert")?"required":"readonly"}>
                    </div>
                    <div class="input-value">
                        <label class="input-label">Email</label>
                        <input type="email" name="accountEmail" class="input-text-box"
                               value="${account.person.email}" ${action.equals("insert")?"required":"readonly"}>
                    </div>
                    <div class="input-value">
                        <label class="input-label">Vai trò</label>
                        <select type="date" name="accountRole" class="input-text-box"
                                value="${account.person.role}" ${action.equals("insert")?"":"disabled"}>
                            <option value="admin">Admin</option>
                            <option value="head_lecturer">Trưởng bộ môn</option>
                            <option value="lecturer">Giảng viên</option>
                            <option value="student" selected>Sinh viên</option>
                        </select>
                    </div>
                    <div class="input-value">
                        <label class="input-label">Địa chỉ</label>
                        <input type="text" name="accountAddress" class="input-text-box"
                               value="${account.person.address}" ${action.equals("insert")?"":"readonly"}>
                    </div>
                    <a href="${pageContext.request.contextPath}/admin/account"
                       class="add-button red-color">${action.equals("insert")?"Hủy":"OK"}</a>
                    <input type="hidden" name="action" value="save">
                    <%--<input type="hidden" name="committeeId" value="${committee.committeId}">--%>
                    <input type="submit" class="add-button" value="Lưu" ${action.equals("insert")?"":"hidden"}>

                </form>
                <%-- Data table--%>
                <%--<table class="datatable">

                  &lt;%&ndash; Table header&ndash;%&gt;
                  <thead>
                  <tr class="center-data align-item-center">
                    <th scope="col" class="center-cell witdh-column-5rem">#</th>
                    <th scope="col" class="center-cell">Tên hội đồng</th>
                    <th scope="col" class="center-cell witdh-column-10rem">Số thành viên</th>
                    <th scope="col" class="witdh-column-27rem center-cell">Mô tả</th>
                    <th scope="col" class="center-cell">Lựa chọn</th>
                  </tr>
                  </thead>
                  &lt;%&ndash;End table header&ndash;%&gt;

                  &lt;%&ndash; Table body&ndash;%&gt;
                  <tbody>
                  <c:if test="${not empty committeList}">
                    <c:forEach items="${committeList}" var="c">
                      <tr class="center-data data-row">
                        <th scope="row" class="center-cell witdh-column-5rem"><a href="#">1</a></th>
                        <td class="justify-cell"><a href="">${c.committeName}</a></td>
                        <td class="center-cell witdh-column-10rem">${c.numMember}</td>
                        <td colspan="1" class="witdh-column-27rem justify-cell">
                            ${c.description}
                        </td>
                        <td class="center-cell">
                          <a href=""
                             class="btn btn-primary edit-button action-column-element">Sửa</a>
                          <form action="" method="post">
                            <input class="delete-button action-column-element" type="submit"
                                   value="Xóa"
                                   onclick="if (confirm('Bạn có chắc chắn muốn xóa hội đồng này?')) { form.action='/admin/book'; } else { return false; }"/>
                          </form>
                        </td>
                      </tr>
                    </c:forEach>
                  </c:if>

                  </tbody>
                  &lt;%&ndash;End table body&ndash;%&gt;

                </table>--%>
                <%--End data table--%>


            </div>
        </div>
    </div>
</div>

<div id="footer">
    <jsp:include page="/default/footer/footer.jsp"/>
</div>

<script>

    document.getElementById('close-message-button').addEventListener('click', (e) => {
        let parentElm = e.target.closest('#message-box')
        parentElm.remove()
    })

</script>

<!-- Footer -->
<!--<div id="footer"></div>
<script src="./asset/script/footer-import.js"></script>-->
</body>

</html>