<!DOCTYPE html>
<html lang="en">
<head>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ page contentType="text/html; charset=UTF-8"%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
    <title>Hệ thống bán hàng</title>
<!-- <link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/bootstrap.min.css" /> 
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/fullcalendar.css" /> -->
<!-- <link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/matrix-style.css" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/matrix-media.css" />
<link href="/storeManagerSystem/view/layoutHeader/font-awesome/css/font-awesome.css" rel="stylesheet" /> -->
<!-- <link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'> -->
 <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %> 
 <link href="/storeManagerSystem/view/layoutHeader/font-awesome/css/font-awesome.css" rel="stylesheet" />
 <style type="text/css">
 #header {
	height: 47px;
	position: relative;
	width: 100%;
	z-index: -9;
}
#header h1 {
	background: url("/storeManagerSystem/view/layoutHeader/img/logo.png") no-repeat scroll 0 0 transparent;
	height: 41px;
	left: 20px;
	line-height: 600px;
	overflow: hidden;
	position: relative;
	width: 202px;
}
#header h1 a {
	display: block;
}
#header {
	background-color: #1f262d;
   margin-top:10px;
}
#sidebar > ul{border-bottom: 1px solid #37414b}
#sidebar > ul > li {
	border-top: 1px solid #37414b; border-bottom: 1px solid #1f262d;
}
#sidebar > ul > li.active {
    background-color: #27a9e3; border-bottom: 1px solid #27a9e3;  border-top: 1px solid #27a9e3;
}
#sidebar > ul > li.active a{ color:#fff; text-decoration:none;}

#sidebar > ul > li > a > .label {
	background-color:#F66;
}
#sidebar > ul > li > a:hover {
	background-color: #27a9e3; color:#fff;
}
#sidebar > ul li ul {
	background-color: #1e242b;
}
#sidebar > ul li ul li a{ color:#939da8}
#sidebar > ul li ul li a:hover, #sidebar > ul li ul li.active a {
	color: #fff;
	background-color: #28b779;
}
#sidebar {
	display: block;
	float: left;
	position: relative;
	width: 250px;
	z-index: 16;
	font-size: 15px;
}
#sidebar > ul {
	list-style: none;
	margin: 0px 0 0;
	padding: 0;
	position: absolute;
	width: 250px;
}
#sidebar > ul > li {
	display: block;
	position: relative;
}
#sidebar > ul > li > a {
	padding: 10px 0 10px 15px;
	display: block;
	color: #a8b3bf;
}
#sidebar > ul > li > a > i {
	margin-right: 10px;
}
#sidebar > ul > li.active > a {
	background: url("/storeManagerSystem/view/layoutHeader/img/menu-active.png") no-repeat scroll right center transparent !important;
	text-decoration:none;
}
#sidebar > ul > li > a > .label {
	margin: 0 20px 0 0;
	float: right;
	padding: 3px 5px 2px;
}
#sidebar > ul li ul {
	display: none;
	margin: 0;
	padding: 0;
}
#sidebar > ul li.open ul {
	display: block;
}
#sidebar > ul li ul li a {
	padding: 10px 0 10px 25px;
	display: block;
	color: #777777;
}
#sidebar > ul li ul li:first-child a {
	border-top: 0;
}
#sidebar > ul li ul li:last-child a {
	border-bottom: 0;
}
#sidebar  .content {
    padding:10px;
    position: relative; color:#939DA8;
}
#sidebar .percent {
    font-weight: 700;
    position: absolute;
    right: 10px;
    top:25px;
}
#sidebar .progress {
    margin-bottom: 2px;
    margin-top: 2px;
    width: 70%;
}
#sidebar .progress-mini {
    height: 6px;
}
#sidebar .stat {
    font-size: 11px;
}
#user-nav > ul > li > a {
	padding:9px 10px;
	display: block;
	font-size: 11px;
}
#user-nav > ul > li > a:hover, #user-nav > ul > li.open > a {
	color: #ffffff;  background:#000;
}
#user-nav > ul > li > a > i, #sidebar li a i {
	opacity: .5; 
	margin-top: 2px;
}
#user-nav > ul > li > a:hover > i, #user-nav > ul > li.open > a > i {
	opacity: 1;
}
#user-nav > ul > li > a > .label {
	vertical-align: middle;
	padding: 1px 4px 1px;
	margin: -2px 4px 0;
	display: inline-block;
}
#user-nav > ul ul > li > a {
	text-align: left;
}
#user-nav > ul ul > li > a:hover {
}
#user-nav {
	position: relative;
	left: auto;
	right: auto;
	width: 100%;
	margin-top: -31px;
	border-top:1px solid #363E48;
	margin-bottom: 0px;
	background:#2E363F;
	float:right;
}
.navbar > .nav {
	float: none;
}
#user-nav > ul {
	margin: 0;
	padding: 0;
	list-style: none; border-right: 1px solid #2e363f;border-left: 1px solid #000;
}
 </style>
</head>
<body>

 <div id="wrapper">
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;background-color:#1f262d ">
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<div >
  <ul class="nav">
    <li  style="margin-top: -50px;width: 120px;margin-left: 1550px" class=""><a title="" href="/storeManagerSystem/dangXuat"><i class="icon icon-share-alt"></i> <span class="text" style="margin-left: 5px;color: #a8b3bf;">Đăng xuất</span></a></li>
  </ul>
</div>
      <div id="sidebar">
        <ul class="nav" id="side-menu">
          <!-- <li>
            <a href="/storeManagerSystem/storeOwnerList"><i class="fa fa-dashboard fa-fw"></i> Người dùng</a>
          </li> -->
              <li class="active"><a href="/storeManagerSystem/<%=session.getAttribute("pathURL")%>"><i class="icon icon-home"></i><span style="margin-left: 5px">  Bán hàng</span></a> </li>
    <li> <a href="/storeManagerSystem/customer/init"><i class="icon icon-signal"></i> <span style="margin-left: 5px">  Khách hàng</span></a> </li>
    <li> <a href="/storeManagerSystem/registerProductCategory/init"><i class="icon icon-inbox"></i> <span style="margin-left: 5px">  Nhóm sản phẩm</span></a> </li>
    <li><a href="/storeManagerSystem/product/init"><i class="icon icon-th"></i> <span style="margin-left: 5px">Sản phẩm</span></a></li>
    <li><a href="/storeManagerSystem/cardType/init"><i class="icon icon-fullscreen"></i> <span style="margin-left: 5px">Loại thẻ</span></a></li>
    <li class="submenu"> <a href="/storeManagerSystem/bill/init"><i class="icon icon-th-list"></i> <span style="margin-left: 5px">Hóa đơn</span></a></li>
    <li><a href="/storeManagerSystem/datHang/init"><i class="icon icon-tint"></i> <span style="margin-left: 5px">Đặt hàng</span></a></li>
    <li><a href="/storeManagerSystem/khoHang/init"><i class="icon icon-pencil"></i> <span style="margin-left: 5px">Kho hàng</span></a></li>
    <li class="submenu"> <a href="/storeManagerSystem/dotKhuyenMai/init"><i class="icon icon-file"></i> <span style="margin-left: 5px">Đợt khuyến mãi</span> </a></li>
    <li class="submenu"> <a href="/storeManagerSystem/thongKe/init"><i class="icon icon-info-sign"></i> <span style="margin-left: 5px">Thống kê</span> </a></li>
    <li><a href="/storeManagerSystem/lienHe/init"><i class="icon icon-pencil"></i> <span style="margin-left: 5px">Liên hệ</span></a></li>
    <li><a href="/storeManagerSystem/thongTinCuaHang/init"><i class="icon icon-pencil"></i> <span style="margin-left: 5px">Thông tin Cửa Hàng</span></a></li>
        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    <!-- /.navbar-static-side -->
  </nav>
  <!--Content (S) -->
  <%@include file="/WEB-INF/views/jsp/centerAdminStore.jsp" %>
  <!--Content (E) -->
<!-- /#wrapper -->
    </div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
    <!--Header-part-->
<%-- <div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
        <li class="divider"></li>
        <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
      </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="/storeManagerSystem/dangXuat"><i class="icon icon-share-alt"></i> <span class="text">Đăng xuất</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->
<!--sidebar-menu-->
<div id="sidebar">
  <ul>
    <li class="active"><a href="/storeManagerSystem/<%=session.getAttribute("pathURL")%>"><i class="icon icon-home"></i> <span>Bán hàng</span></a> </li>
    <li> <a href="/storeManagerSystem/customer/init"><i class="icon icon-signal"></i> <span>Khách hàng</span></a> </li>
    <li> <a href="/storeManagerSystem/registerProductCategory/init"><i class="icon icon-inbox"></i> <span>Nhóm sản phẩm</span></a> </li>
    <li><a href="/storeManagerSystem/product/init"><i class="icon icon-th"></i> <span>Sản phẩm</span></a></li>
    <li><a href="/storeManagerSystem/cardType/init"><i class="icon icon-fullscreen"></i> <span>Loại thẻ</span></a></li>
    <li class="submenu"> <a href="/storeManagerSystem/bill/init"><i class="icon icon-th-list"></i> <span>Hóa đơn</span> <span class="label label-important">3</span></a></li>
    <li><a href="/storeManagerSystem/datHang/init"><i class="icon icon-tint"></i> <span>Đặt hàng</span></a></li>
    <li><a href="/storeManagerSystem/khoHang/init"><i class="icon icon-pencil"></i> <span>Kho hàng</span></a></li>
    <li class="submenu"> <a href="/storeManagerSystem/dotKhuyenMai/init"><i class="icon icon-file"></i> <span>Đợt khuyến mãi</span> <span class="label label-important">5</span></a></li>
    <li class="submenu"> <a href="/storeManagerSystem/thongKe/init"><i class="icon icon-info-sign"></i> <span>Thống kê</span> <span class="label label-important">4</span></a></li>
    <li><a href="/storeManagerSystem/lienHe/init"><i class="icon icon-pencil"></i> <span>Liên hệ</span></a></li>
    <li><a href="/storeManagerSystem/thongTinCuaHang/init"><i class="icon icon-pencil"></i> <span>Thông tin Cửa Hàng</span></a></li>
  </ul>
</div>
  <!--Content (S) -->
  <%@include file="/WEB-INF/views/jsp/centerAdminStore.jsp" %>
  <!--Content (E) -->
<!-- /#wrapper -->
    </div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script> --%>
    <!--Header-part-->
</body>
</html>