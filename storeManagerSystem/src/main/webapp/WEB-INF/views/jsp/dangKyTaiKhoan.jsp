<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<!-- Mirrored from runtime.vn/dang-ky.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 29 May 2017 14:23:51 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <title>Đăng kí tài khoản</title>

    <link href="/storeManagerSystem/view/templateDK/bootstrap.min.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/font-awesome.min.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/simple-line-icons.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/animate.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/toTop.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/owl.carousel.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/owl.theme.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/overwrite.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/styles.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/responsive.css" rel="stylesheet" />

    <script src="/storeManagerSystem/view/templateDK/jquery-2.1.0.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/templateDK/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/templateDK/bootstrap.min.js"></script>
    <script src="/storeManagerSystem/view/js/angular.min.js"></script>
    <!--End of Zopim Live Chat Script-->
</head>
<body>
    
<!-- START HEADER -->
<header class="clearfix">
    <div class="container clearfix">
        <!-- Start navbar -->
        <nav class="navbar navbar-default navbar-fixed-top top-nav-collapse">
        </nav>
        <!-- End navbar -->
    </div>
</header>
<div class="inner-heading create-web-bg">
    <div class="overlay-bg"></div>
</div>
<section class="theme-list create-web" ng-app="dangKyTaiKhoanForm" ng-controller="ctrl">
    <div class="container">
        <h1 class="text-uppercase clearfix title">Đăng ký tài khoản</h1>
        <form:form id="dangKyTaiKhoanForm" class="step-block-box clearfix" modelAttribute="dangKyTaiKhoanForm"  method="get" autocomplete="off"> 
            <div class="col-sm-6 col-xs-12 col-sm-offset-3 step-block1 ">
                <div class="form-group" >
                    <form:input type="text" class="form-control" path="soDienThoai" placeholder="Số điện thoại"  ng-model="sdt" ng-init="sdt='${dangKyTaiKhoanForm.soDienThoai}'" maxlength="11" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <label id="Email-error" class="error help-block">{{sdt_err}}</label>
                </div>
                 <div class="form-group has-feedback">
                    <form:input  path="password" type="password" class="form-control" placeholder="Mật khẩu" ng-model="password" ng-init="password='${dangKyTaiKhoanForm.password}'" autocomplete="off"  maxlength="8" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                	<label id="Email-error" class="error help-block">{{password_err}}</label>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" placeholder="Nhập lại mật khẩu" ng-model="repassword" autocomplete="off"  maxlength="8" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                	<label id="Email-error" class="error help-block">{{repassword_err}}</label>
                </div>
                <div class="form-group has-feedback" >
                    <form:input type="text" class="form-control" path="tenKhachHang" placeholder="Tên"  ng-model="tenKhachHang" ng-init="tenKhachHang='${dangKyTaiKhoanForm.tenKhachHang}'" maxlength="50" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <label id="Email-error" class="error help-block">{{tenKhachHang_err}}</label>
                </div>
                <div class="form-group has-feedback" >
                    <form:input type="text" class="form-control" path="diaChi" placeholder="Địa chỉ"  ng-model="diaChi"  maxlength="50" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                </div>
                <div class="form-group has-feedback" >
                    <form:input type="text" class="form-control" path="ngaySinh" placeholder="Ngày sinh"  ng-model="ngaySinh" ng-init="ngaySinh='${dangKyTaiKhoanForm.ngaySinh}'"  maxlength="50" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <label id="Email-error" class="error help-block">{{ngaySinh_err}}</label>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" checked="checked" >Tôi đồng ý với <a href="#">quy định sử dụng</a>&<a href="#">chính sách bảo mật</a> của chúng tôi
                        </label>
                    </div>
                </div>
                <form:input path="pathJSP" type="hidden"/>
                <div class="form-group button-group">
                    <div class="button">
                        <input class="btn btn-default" type="button" ng-click="btnCreate('${dangKyTaiKhoanForm.pathJSP }');" value="Đăng ký" />
                        <a href="/storeManagerSystem/${dangKyTaiKhoanForm.pathJSP }"><input class="btn btn-default" type="button"  value="Quay về" /></a>
                    </div>
                </div>
            </div>
       </form:form> 
    </div>
</section>   
<footer class="no-margin footer">
    <div class="footer-left-bg"></div>
    <div class="footer-right-bg"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-12 col-xs-12">
                <h2>Runtime.vn<span class="line"></span></h2>
                <ul>
                    <li><a href="bang-gia.html">Bảng giá</a></li>
                    <li><a href="lien-he.html">Liên hệ</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <h2>Giới thiệu<span class="line"></span></h2>
                <ul>
                    <li><a href="gioi-thieu.html">Về chúng tôi</a></li>
                    <li><a href="thanh-toan.html">Hình thức thanh toán</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <h2>Hỗ trợ<span class="line"></span></h2>
                <ul>
                    <li><a href="tro-giup.html">Tài liệu hướng dẫn sử dụng</a></li>
                    <li><a href="tro-giup/huong-dan-tao-web.html">Hướng dẫn tạo website</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12 social-icon">
                <h2><span class="line"></span>Kết nối với chúng tôi</h2>
                <p class="text-uppercase color1">C&#212;NG TY TNHH PH&#193;T TRIỂN C&#212;NG NGHỆ RUNTIME</p>
                <p><i class="fa fa-envelope-o"></i> runtimevn@gmail.com</p>
                <p><i class="fa fa-phone"></i> 0908 77 00 95</p>
                <p><i class="fa fa-home"></i> 36Bis Ho&#224;ng Sa, Phường T&#226;n Định, Quận 1, Tp.Hồ Ch&#237; Minh</p>
                <ul class="">
                    <li><a target="_blank"><i class="fa fa-facebook fa-2"></i></a></li>
                    <li><a target="_blank"><i class="fa fa-google-plus fa-2"></i></a></li>
                    <li><a target="_blank"><i class="fa fa-twitter fa-2"></i></a></li>
                    <li><a target="_blank"><i class="fa fa-youtube fa-2"></i></a></li>
                </ul>
            </div>

        </div>
    </div>
    <div class="reserved">
        <div class="container">
        </div>
    </div>
</footer>
<script src="/storeManagerSystem/view/js/dangKyTaiKhoan.js"></script>
</body>
</html>
