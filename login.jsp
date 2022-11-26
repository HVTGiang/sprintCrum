<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
int couter=0;
%>
                <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="ThuVien/favicon.ico" type="image/x-icon" /><title>
	Quản lý đề tài
</title><meta name="Keywords" content="UTE Portal :: HCMC University of Technology and Education, Đại học Sư phạm Kỹ thuật" />
<meta name="viewport" content="width=device-width, initial-scale=1">

 <link rel="stylesheet" type="text/css" href="ThuVien/css/login.css"/>
  <link rel="stylesheet" type="text/css" href="ThuVien/css/bootstrap.css"/>
    <script src="ThuVien/Jquery/jquery-1.11.3.min.js"></script>
     <script src="ThuVien/Js/bootstrap.min.js"></script>
    <script src="ThuVien/Jquery/jquery.bootstrap-autohidingnavbar.js"></script>
<script src="ThuVien/Jquery/jquery.validate.min.js"></script> 
<script type="text/javascript" src="ThuVien/Jquery/localization/messages_vi.js"></script>
<script src="ThuVien/Js/script.js"></script>
    <script>
      $("nav.navbar-fixed-top").autoHidingNavbar();
    </script>
<style>
            .success{color:blue;}
            .error {color:red;}
        </style>
</head>

<body>
<div class="row">
  <div class="col-xs-6 col-md-12 ">
	<table align="center" border="0" width="1002" id="table1" cellspacing="0" cellpadding="0">
		<tr>
			<td height="24">&nbsp;</td>
		</tr>
		<tr>
			<td>
			    <img  border="0" src="ThuVien/Images/SPKT.jpg" height="143" style="width: 1002px"/>
			</td>
		</tr>
		</table>
</div>
<div class="col-xs-12 col-md-12 ">
						<table border="0" height="40" width="100%" id="table5" cellspacing="0" cellpadding="0">
						<td>
<nav class="navbar navbar-default" role="navigation">
  <div class="container">
<div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">
        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Trang Chủ</a></li>
        <li><a href="#"> <span class="glyphicon glyphicon-user"></span> Tin Tức</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        
      </ul>
      

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</td>
								</table>

</div>
 <div class="login-card">
    <h1 style="color:blue">Đăng Nhập</h1><br>
  <form action="loginAuthenticate.jsp" method="POST" id="signupForm1" class="form-horizontal">
   <div class="col-md-6">
     <label class="checkbox-inline">
  <input type="radio" id="sinhvien"  name="quyen"  value="sinhvien"> Sinh Viên
</label>
</div>
<div class="col-md-6">
<label class="checkbox-inline">
  <input type="radio" id="giangvien"   name="quyen" value="giangvien"> Giảng Viên
  </label>
    </div>
   <div class="col-md-6">
     <label class="checkbox-inline">
  <input type="radio" id="truongbomon"  name="quyen"  value="truongbomon"> Trưởng Bộ Môn
</label>
</div>
<div class="col-md-6">
<label class="checkbox-inline">
  <input type="radio" id="admin"   name="quyen" value="admin"> Admin
  </label>
    </br></br>
    </div>
    <input type="text" name="uname"  id="uname" placeholder="nhập mã số" required>
    <input type="password" name="pass" id="pass"  placeholder="nhập mật khẩu" required>
      <input type="submit" class="login login-submit" value="login"/>
  </form>
     <font color="red"><c:if test="${not empty param.errMsg}">
            <c:out value="${param.errMsg}" />
            </c:if></font>
<%
couter+=1;
%>
   <p>Truy Cập:<%=couter %>/10000</p>
  <div class="login-help">
     <a href="#">Quên mật khẩu</a></br>
  </div>

</div>   
	</br></br>		      
<div class="col-md-6" style="margin-left:100px;"><span >Copyright © 2022 HCMUTE - All Rights Reserved</span></div>
<div class="col-md-4" style="margin-left:100px;">

</div>
</div>
                   

</div>
</body>
</html>