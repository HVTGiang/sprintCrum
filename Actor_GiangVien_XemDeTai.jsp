<%@ page import="connectdatabase.User" %>
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
<link rel="icon" href="ThuVien/favicon.ico" type="image/x-icon" /><title>
	Đăng ký đề tài 
</title><meta name="Keywords" content="UTE Portal :: HCMC University of Technology and Education, Đại học Sư phạm Kỹ thuật" />
<meta name="viewport" content="width=device-width, initial-scale=1">


 <link rel="stylesheet" type="text/css" href="ThuVien/css/Main.css"/>
  <link rel="stylesheet" type="text/css" href="ThuVien/css/bootstrap.css"/>
    <script src="ThuVien/Jquery/jquery-1.11.3.min.js"></script>
     <script src="ThuVien/Js/bootstrap.min.js"></script>
    <script src="ThuVien/Jquery/jquery.bootstrap-autohidingnavbar.js"></script>
<script src="ThuVien/Jquery/jquery.validate.min.js"></script> 
<script type="text/javascript" src="ThuVien/Jquery/localization/messages_vi.js"></script>
<script src="ThuVien/Js/jquery-ui.min.js"></script>
<script src="ThuVien/Js/script.js"></script>
    <script>
      $("nav.navbar-fixed-top").autoHidingNavbar();
    </script>
    <script type="text/javascript">
	$(document).ready(function(){

			var url,data;

			$("#trangchu").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "TrangChu_GiaoVien.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#thongtincanhan").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "ThongTinCaNhanGV_NV.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#xemdetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "TimKiem.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#detaiduocphancongpheduyet").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DeTaiDuocPhanCongPheDuyet.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#detaiduocphancongphanbien").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DeTaiDuocPhanCongPhanBien.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#detaidanghuongdan").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DeTaiDangHuongDan.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#duyethuydetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DuyetHuyDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#duyetgiahandetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DuyetGiaHanDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#duyetdangkydetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DuyetDangKyDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			

			$("#xemdanhgia").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "XemDanhGia.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#trangthaidetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "TrangThaiDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#diemdanhgia").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DiemDanhGia.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#dangkydetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DangKyDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#xemmadetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "XemMaDeTai.jsp";
				$("#load").load(url);
				
	        });
			
			$("#giahandetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "GiaHanDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#huydetai").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "HuyDeTai.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			
			$("#nopbaocao").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "NopBaoCao.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#nhapdiemdanhgia").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "NhapDiemDanhGia.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#detaidanghuongdan").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "DeTaiDangHuongDan.jsp";
				//url = "files/file-001.php";
				$("#load").load(url);
				
	        });
			$("#tb1").click(function(e) {
				//=======.load(url)================
				var url,data;
				
				url = "https://docs.google.com/document/d/15-zwTehY0-D3mKTVEkqpwWRb25kWzZ0b-5M1UkMfW7k/pub?embedded=true";
				//url = "files/file-001.php";
				$("#load").load(url);
				
			});

			if (top !== self) {
				$.ui.dialog.prototype._focusTabbable = $.noop;
			}	
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
    
     <sql:query dataSource="${snapshot}" var="result">
	  	SELECT * FROM DeTai,DeTai_ThongTin,DeTai_SinhVien,ThongTinSinhVien
		Where DeTai.MaDeTai=DeTai_ThongTin.MaDeTai 
		and DeTai_SinhVien.MSSV = ThongTinSinhVien.MSSV and DeTai_SinhVien.MaDeTai=DeTai.MaDeTai
		and DeTai.MaDeTai='${param.MaDeTai}'   
</sql:query>

<div class="col-xs-12 col-sm-12 ">

	<div class="page-header no-margin no-padding">
	<div class="container" >
	 <a  href="http://hcmute.edu.vn/">
	 <img src="ThuVien/Images/banner.jpg" class="img-responsive" /></a>
 <img src="ThuVien/Images/line_ngang.jpg" class="img-responsive" /></a>
	</div>
</div>
</div>

<div id="Main">
<div class="container">
<div class="col-xs-12 col-md-3 ">	
<nav class="navbar navbar-default navbar-static-top" role="navigation">
  <div class="container-fluid">
<div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">    
       <span class="icon-bar"></span> 
       <span class="icon-bar"></span> 
       <span class="icon-bar"></span> 
       </button>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-left nav-tabs">
        <li>  <a class="menu" id="trangchu"> <span class="glyphicon glyphicon-list-alt"></span>  Trang Chủ</a></li>
        <li> <a class="menu" id="thongtincanhan"> <span class="glyphicon glyphicon-user"></span>  Thông tin cá nhân</a></li>
        <li>   <a class="menu" id="xemdetai"> <span class="glyphicon glyphicon-th"></span>  Tìm Kiếm Đề Tài</a></li>
 		 <li><a class="menu" id="xemdanhgia"> <span class="glyphicon glyphicon-inbox"></span>  Xem Đánh Giá Đề Tài</a></li>
       <li>  <a class="menu" id="detaiduocphancongpheduyet"> <span class="glyphicon glyphicon-ok"></span>  Đề Tài Được Phân Công Phê Duyệt</a></li>
     <li>  <a class="menu" id="detaiduocphancongphanbien"> <span class="glyphicon glyphicon-bullhorn"></span>  Đề Tài Được Phân Công Phản Biện</a></li>
     <li>   <a class="menu" id="duyethuydetai"> <span class="glyphicon glyphicon-remove"></span> Duyệt Hủy Đề Tài</a></li>
     <li>   <a class="menu" id="duyetgiahandetai"> <span class="glyphicon glyphicon-remove"></span> Duyệt Gia Hạn Đề Tài</a></li>
     <li><a class="menu" id="duyetdangkydetai"> <span class="glyphicon glyphicon-tags"></span>  Duyệt Đăng Ký Đề Tài</a></li>
          <li><a class="menu" id="detaidanghuongdan"> <span class="glyphicon glyphicon-tags"></span> Đề Tài Được Hướng Dẫn</a></li>
     <li><a class="menu" id="nhapdiemdanhgia"> <span class="glyphicon glyphicon-tags"></span>  Nhập Điểm Đánh Giá Đề Tài</a></li>
     <li> <a class="menu" href="logout.jsp"> <span class="glyphicon glyphicon-eject"></span>  Đăng Xuất</a></li>
      </ul>
      <ul>
      <div id="menu1">
        <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" >Đề tài của tôi
        <span class="caret"></span></a>
        <ul class="sub-menu">
           <li><a  id="diemdanhgia"><span class="glyphicon glyphicon-briefcase"></span> Điểm Đánh Giá</a></li>
            <li><a  id="dangkydetai"> <span class="glyphicon glyphicon-hand-up"></span> Đăng Ký Đề Tài</a></li>
           <li><a  id="trangthaidetai"> <span class="glyphicon glyphicon-tasks"></span> Trạng Thái ĐT</a></li>
            <li><a  id="xemmadetai"> <span class="glyphicon glyphicon-sound-5-1"></span> Xem Mã Đề Tài</a></li>
        <li><a 	id="giahandetai"> <span class="glyphicon glyphicon-asterisk"></span> Gia Hạn Đề Tài</a></li>
        <li><a  id="huydetai"> <span class="glyphicon glyphicon-flag"></span> Hủy Đề Tài</a></li>
        <li><a  id="nopbaocao"> <span class="glyphicon glyphicon-floppy-open"></span> Nộp Báo Cáo</a></li>
        </ul>
      </li>
      </div>
</ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>

<div class="col-xs-12 col-md-9">

<div id="load">
<form id="signupForm1"  action="Data/DB_insert_DeTai.jsp" method="post" class="form-horizontal">
  <c:forEach var="row" items="${result.rows}">
  
     <div class="col-xs-12 col-md-12 ">
		<h3 style="color:red">Tên Đề Tài: <c:out  value="${row.TenDeTai}"/></h3>  </br> 	
    </div>

   <label for="name" class="col-xs-12 col-md-3 ">Chủ Nhiệm</label>
    <div class="col-xs-12 col-md-3 ">
<c:out  value="${row.HoTen}"/>       </br>
    </div>
  
<label for="name" class="col-xs-12 col-md-3 ">Ngày Sinh</label>
    <div class="col-xs-12 col-sm-3  ">
<c:out  value="${row.NgaySinh}"/>           </br>  </br>
    </div>
   
    <label class="col-xs-12 col-md-3 " for="name">Đơn Vị</label>
    <div class="col-xs-12 col-md-3">
    <c:out  value="${row.DonVi}"/>
       </br>  </br>
    </div>
     
         <label class="col-xs-12 col-md-3">Ngành</label>
    <div class="col-xs-12 col-md-3">
 <c:out  value="${row.Nganh}"/>        </br>  </br>
    </div>

    <label class="col-xs-12 col-md-3" >Email</label>
    <div class="col-xs-12 col-md-3">
 <c:out  value="${row.Email}"/>         </br>  </br>
    </div>
<label class="col-xs-12 col-md-3">Giới tính</label>
    <div class="col-xs-12 col-md-3">
     <c:out value="${row.GioiTinh}"/>
  </br></br>
    </div>
    <label class="col-xs-12 col-md-3">Lớp</label>
    <div class="col-xs-12 col-md-3">
 		<c:out  value="${row.Lop}"/>  
 		    </br>  </br>
    </div>

<label  class="col-xs-12 col-md-3">Niên Khóa</label>
    <div class="col-xs-12 col-md-3">
 <c:out  value="${row.NienKhoa}"/>     </br>  </br>
    </div>

   
    <label  class="col-xs-12 col-md-3">Mã Số Giáo Viên Hướng Dẫn <span class="rq"> *</label>
    <div class="col-xs-12 col-md-3">
 <c:out  value="${row.GVHD}"/>       </br>  </br>
    </div>
    <label class="col-xs-12 col-md-3">Lĩnh Vực Nghiên Cứu</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.LinhVu}"/>
</br></br> </br>
    </div>

    <label class="col-xs-12 col-md-3">Loại Hình Cơ Bản</label>
    <div class="col-xs-12 col-md-3">

 <c:out  value="${row.LoaiHinh}"/>
</br></br>
    </div>

    <label  class="col-xs-12 col-md-3">Cơ Quan Chủ Trì</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.DonVi}"/>
        </br>  </br>
    </div>

    <label  class="col-xs-12 col-md-3">Tình Hình Trong Nước</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.TinhHinhTrongNuoc}"/>
      </br>  </br>
    </div>

    <label  class="col-xs-12 col-md-3">Tình Hình Ngoài Nước</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.TinhHinhNgoaiNuoc}"/>
    </br>  </br>
    </div>

    <label  class="col-xs-12 col-md-3">Các Công Trình Liên Quan</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.CacCongTrinhLienQuan}"/>
      </br>  </br>
    </div>

    <label  class="col-xs-12 col-md-3">Tính Cấp Thiết</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.TinhCapThiet}"/>
     </br>  </br>
    </div>

    <label class="col-xs-12 col-md-3">Mục Tiêu Đề Tài</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.MucTieu}"/>
     </br>  </br>
    </div>

    <label  class="col-xs-12 col-md-3">Phương Pháp Nghiên Cứu</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.PhuongPhapNghienCuu}"/>
     </br>  </br>
    </div>

    <label class="col-xs-12 col-md-3">Nôi Dung Nghiên Cứu</label>
    <div class="col-xs-12 col-md-3">
    <c:out  value="${row.NoiDung}"/>
    </br>  </br>
</div>
    <label class="col-xs-12 col-md-3">Loại Sản Phẩm</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.LoaiSanPham}"/>
</br></br>
    </div>

   
    

    <label class="col-xs-12 col-md-3">Địa Chỉ ứng Dụng</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.DiaChiUngDung}"/>
     </br>  </br>
    </div>

 <label class="col-xs-12 col-md-3">Kinh Phí Dự Trù</label>
    <div class="col-xs-12 col-md-3">
     <c:out  value="${row.KinhPhi}"/>
        </br>  </br>
    </div>
 
      </div>
      </c:forEach>
   </form>  

</div>
</div>
</div>
<footer class="site-footer">

<div class="container">
	<div class="row">
		<div class="col-md-5">
		<address>
		
		
		</address>	
		</div>
		</div>
		<div class="bottom-footer">
		<div class="col-md-5">
		Copyright @2013</br>
		Trường Đại học sư phạm kỹ thuật TP. HCM</br>
		Địa Chỉ 1, Võ Văn Ngân,Phường Linh Chiểu,Quận Thủ Đức,Thành Phố Hồ Chí Minh</br>
		Điện thoại:(+84-8)38968641 -(+84-8)3896133</br>
		E-mail:ic@hcmute.edu.vn
		</div>
		<div class="col-md-7">
		<ul class="footer-nav">
		<li><a href="http://hcmute.edu.vn/">Trang Chủ</a>
		<li><a href="https://www.facebook.com/SV.SPKT/?fref=ts">Fb</a>
		<li><a href="https://www.youtube.com/user/UTECommunicationDept">youtube</a>
		
		</ul>
		</div>
	</div>
</div>
</footer>
</body>
</html>