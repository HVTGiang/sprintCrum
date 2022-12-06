<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login </title>
</head>
<body>
  <c:if test="${ empty param.uname or empty param.pass or empty param.quyen}">
      <c:redirect url="Login.jsp" >
              <c:param name="errMsg" value="Vui lòng Nhập Tên Đăng Nhập, Mật Khẩu hoặc Quyền truy cập" />
      </c:redirect>
       
    </c:if>
     
    <c:if test="${not empty param.uname and not empty param.pass}">
      <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/detainckh"
                       user="root" password="0123"/>
 
      <sql:query dataSource="${ds}" var="selectQ">
        SELECT count(*) as kount FROM dangnhap WHERE uName='${param.uname}'AND Pass='${param.pass}' AND Quyen='${param.quyen}'
      </sql:query>
 
      <c:forEach items="${selectQ.rows}" var="r">
        <c:choose>
          <c:when test="${r.kount gt 0}">
            <c:set scope="session"
                   var="loginUser"
                   value="${param.uname}"/>
           <c:set scope="session"
                   var="quyen"
                   value="${param.quyen}"/>
             <c:set scope="session"
                   var="madetai"
                   value="${param.uname}"/>
              <c:if test = "${param.quyen =='sinhvien'}">
            <c:redirect url="Actor_SinhVien.jsp"/>
            </c:if>
            <c:if test = "${param.quyen =='giangvien'}">
            <c:redirect url="Actor_GiaoVien.jsp"/>
            </c:if>
            <c:if test = "${param.quyen =='nhanvienql'}">
            <c:redirect url="Actor_NhanVien.jsp"/>
            </c:if>
            <c:if test = "${param.quyen =='admin'}">
            <c:redirect url="Actor_Admin.jsp"/>
            </c:if>
          </c:when>
          <c:otherwise>
            <c:redirect url="Login.jsp" >
              <c:param name="errMsg" value="Vui lòng kiểm tra lại mật khẩu hoặc tên đăng nhập" />
            </c:redirect>
          </c:otherwise>
        </c:choose>
 
      </c:forEach>
 
    </c:if>
</body>
</html>