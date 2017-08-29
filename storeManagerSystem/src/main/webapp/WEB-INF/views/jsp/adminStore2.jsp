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
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/bootstrap.min.css" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/fullcalendar.css" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/matrix-style.css" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/matrix-media.css" />
<link href="/storeManagerSystem/view/layoutHeader/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/storeManagerSystem/view/layoutHeader/css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="wrapper">
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
     <!--  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar">Đăng xuất</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button> -->
      <a class="navbar-brand" href="javascript:void(0)">Quản lý</a>
    </div>
    <!-- /.navbar-header -->
    <ul class="nav navbar-top-links navbar-right" style="margin-right:3px">
      <!-- /.dropdown -->
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" href="/storeManagerSystem/dangXuat">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"> Đăng xuất</i>
        </a>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
          <!-- <li>
            <a href="/storeManagerSystem/storeOwnerList"><i class="fa fa-dashboard fa-fw"></i> Người dùng</a>
          </li> -->
          <li>
            <a href="/storeManagerSystem/<%=session.getAttribute("pathURL")%>"><i class="fa fa-dashboard fa-fw"></i> Bán hàng</a>
          </li>
          <li>
            <a href="/storeManagerSystem/customer/init"><i class="fa fa-user fa-fw" aria-hidden="true"></i> Khách hàng</a>
          </li>
          <li>
            <a href="/storeManagerSystem/registerProductCategory/init"><i class="fa fa-list-alt fa-fw"></i> Nhóm sản phẩm</a>
          </li>
          <li>
            <a href="/storeManagerSystem/product/init"><i class="fa fa-list-alt fa-fw"></i> Sản phẩm</a>
          </li>
          <li>
            <a href="/storeManagerSystem/cardType/init"><i class="fa fa-list-alt fa-fw"></i> Loại thẻ</a>
          </li>
          <li>
            <a href="/storeManagerSystem/bill/init"><i class="fa fa-list-alt fa-fw"></i> Hóa đơn</a>
          </li>
          <li>
            <a href="/storeManagerSystem/datHang/init"><i class="fa fa-list-alt fa-fw"></i> Đặt hàng</a>
          </li>
          <li>
            <a href="/storeManagerSystem/khoHang/init"><i class="fa fa-list-alt fa-fw"></i> Kho hàng</a>
          </li>
          <li>
            <a href="/storeManagerSystem/dotKhuyenMai/init"><i class="fa fa-list-alt fa-fw"></i> Đợt khuyến mãi</a>
          </li>
          <li>
            <a href="/storeManagerSystem/thongKe/init"><i class="fa fa-list-alt fa-fw"></i> Thống kê</a>
          </li>
          <li>
            <a href="/storeManagerSystem/lienHe/init"><i class="fa fa-list-alt fa-fw"></i> Liên hệ</a>
          </li>
          <li>
            <a href="/storeManagerSystem/thongTinCuaHang/init"><i class="fa fa-list-alt fa-fw"></i> Thông tin Cửa Hàng</a>
          </li>
        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
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
<div id="header">
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
<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch-->
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Bán hàng</a>
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
</body>
</html>