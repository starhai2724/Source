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
    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
</head>
<body>
<div id="wrapper">
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar">Đăng xuất</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">Quản lý</a>
    </div>
    <!-- /.navbar-header -->
    <ul class="nav navbar-top-links navbar-right">
      <!-- /.dropdown -->
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" href="/storeManagerSystem/dangXuat">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"> Đăng xuất</i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="#"><i class="fa fa-gear fa-fw"></i> Cài đặt</a>
          </li>
          <li class="divider"></li>
          <li><a href="/storeManagerSystem/dangXuat"><i class="fa fa-sign-out fa-fw"></i> Đăng xuất</a>
          </li>
        </ul>
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
</body>
</html>