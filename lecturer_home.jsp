<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Giảng viên</title><meta name="viewport" content="width=device-width, initial-scale=1">

 
 <link rel="stylesheet" type="text/css" href="ThuVien/css/Main.css"/>
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
    <script type="text/javascript">
	$(document).ready(function(){

			var url,data;
			
			
			$("#tb1").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				
				//url = "files/file-001.php";
				$("#load").load(url);
				
			});
			
	});
	$('.carousel').carousel()
</script>
<style>
            .success{color:blue;}
            .error {color:red;}
        </style>
</head>
<body>
	
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
	     url="jdbc:mysql://localhost:3306/detainckh?useUnicode=true&characterEcoding=utf-8"     
	     user="root"  password="0123"/>
	 <sql:query dataSource="${snapshot}" var="dangky">
		select GVHD,count(DeTai_SinhVien.MaDeTai) as SlDangKy
    from DeTai_SinhVien,DeTai
    where DeTai_SinhVien.TrangThai='Đề tài chờ duyệt đăng ký'
    and DeTai_SinhVien.MaDeTai=DeTai.MaDeTai
    and GVHD='${sessionScope['loginUser']}'
	</sql:query>
	 <sql:query dataSource="${snapshot}" var="chohuy">
		select GVHD,count(DeTai_SinhVien.MaDeTai) as SlHuy
    from DeTai_SinhVien,DeTai
    where DeTai_SinhVien.MaDeTai=DeTai.MaDeTai
    and DeTai.GVHD='${sessionScope['loginUser']}'
	and DeTai_SinhVien.TrangThai='Đề tài chờ hủy'
	</sql:query>
	 <sql:query dataSource="${snapshot}" var="giahan">
		select GVHD,count(DeTai_SinhVien.MaDeTai) as SlGiaHan
    from DeTai_SinhVien,DeTai
    where DeTai_SinhVien.MaDeTai=DeTai.MaDeTai
    and DeTai.GVHD='${sessionScope['loginUser']}'
	and DeTai_SinhVien.TrangThai='Đề tài chờ gia han'
	</sql:query>
	 <sql:query dataSource="${snapshot}" var="phanbien">
			select phancongphanbien.MaCanBo, count(DeTai_SinhVien.MaDeTai) as SLPhanBien
       FROM DeTai,ThongTinCanBo,PhanCongPhanBien,DeTai_SinhVien
            where DeTai.MaDeTai=PhanCongPhanBien.MaDeTai 
            and DeTai.MaDeTai=DeTai_SinhVien.MaDeTai
            and PhanCongPhanBien.MaCanBo=ThongTinCanBo.MaCanBo   
            and phancongphanbien.MaCanBo='${sessionScope['loginUser']}'
	</sql:query>
		 <sql:query dataSource="${snapshot}" var="nghiemthu">
			select phancongphanbien.MaCanBo, count(DeTai_SinhVien.MaDeTai) as SLNghiemThu
       FROM DeTai,ThongTinCanBo,PhanCongPhanBien,DeTai_SinhVien
            where DeTai.MaDeTai=PhanCongPhanBien.MaDeTai 
            and DeTai.MaDeTai=DeTai_SinhVien.MaDeTai
            and PhanCongPhanBien.MaCanBo=ThongTinCanBo.MaCanBo   
            and phancongphanbien.MaCanBo='${sessionScope['loginUser']}'
	</sql:query>
	
	 <sql:query dataSource="${snapshot}" var="detai">
			 SELECT DeTai.MaDeTai,DeTai_SinhVien.MaCapDT,DeTai.TenDeTai,
			ThongTinSinhVien.HoTen as ChuNhiem,DeTai_SinhVien.TrangThai
          	 FROM DeTai,ThongTinCanBo,DeTai_SinhVien,ThongTinSinhVien
          	 where DeTai.MaDeTai=DeTai_SinhVien.MaDeTai
          	 and ThongTinCanBo.MaCanBo=DeTai.GVHD
             and ThongTinSinhVien.MSSV=detai_sinhvien.MSSV
	</sql:query>
<div id="load">

<div class="panel-group" align="center">
    <div class="panel panel-info">
      <div class="panel-heading" id="tieude" style="color: blue"><strong>Trang Chủ</strong></div>
    </div>
    </div>
<form style=" border: groove;width:100%; margin-left:1%; margin-right:10%;">	
<table class="table table-striped">
              <thead>
                <tr>
                  <th>Chờ duyệt đăng ký</th>
                  <th>Chờ duyệt hủy</th>
                  <th>Chờ duyệt gia hạn</th>
 					<th>Chờ phản biện</th>
					<th>Chờ nghiệm thu</th>
                </tr>

  <tr>
   <c:forEach var="row1" items="${dangky.rows}">
                   <th><c:out  value="${row1.SlDangKy}"/></th>
    </c:forEach>
        <c:forEach var="row2" items="${chohuy.rows}">
                   <th><c:out  value="${row2.SlHuy}"/></th>
    </c:forEach>
     <c:forEach var="row3" items="${giahan.rows}">
                   <th><c:out  value="${row3.SlGiaHan}"/></th>
    </c:forEach>
       <c:forEach var="row4" items="${phanbien.rows}">
                   <th><c:out  value="${row4.SLPhanBien}"/></th>
    </c:forEach>
     <c:forEach var="row5" items="${nghiemthu.rows}">
                   <th><c:out  value="${row5.SLNghiemThu}"/></th>
    </c:forEach>
                </tr>
              </thead>
              <tbody>
	</table>
		</form></br>

 <form style=" border: groove;width:100%; margin-left:1%; margin-right:1%;">	
 <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
              	  <th>Mã Đề Tài</th>
                  <th>Tên Đề Tài</th>
                  <th>Họ Tên Chủ Nhiệm</th>
                  <th>Trạng Thái</th>
	<th></th>
                </tr>
              </thead>
              <tbody>
               <c:forEach var="row6" items="${detai.rows}">
                <tr>
                  <td><c:out  value="${row6.MaCapDT}"/></td>
                  <td><c:out  value="${row6.TenDeTai}"/></td>
                  <td><c:out  value="${row6.HoTen}"/></td>
                   <td><c:out  value="${row6.TrangThai}"/></td>
				<td><div id="tb1"><a href = "Actor_GiaoVien_XemDeTai.jsp?MaDeTai=${row6.MaDeTai}">Xem chi tiết</a></div></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
         </form>
               <ul class="pagination" style="margin:auto; float:right; margin-right:10px; margin-bottom:12px;; margin-top:15px">
  <li><a href="#"><<</a></li>
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">>></a></li>
</ul>
          </div>

</div>


</body>
</html>