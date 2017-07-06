<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <title>Hệ thống bán hàng</title>
    <meta name="keywords" />
    <link href="/storeManagerSystem/view/templateDK/logo-runtime.png" rel="shortcut icon" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta content="vi_VN" property="og:locale" />
    <meta content="website" property="og:type" />
    <meta property="og:image" />
    <meta property="og:url" />

    
    <link href="/storeManagerSystem/view/templateDK/bootstrap.min.css" rel="stylesheet" />
<!--     <link href="/storeManagerSystem/view/templateDK/font-awesome.min.css" rel="stylesheet" /> -->
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
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand hidden-xs hidden-sm" href="index.html">
                        <img alt="runtime" class="scroller-logo" src="/storeManagerSystem/view/templateDK/logo01.png">
                        <img src="/storeManagerSystem/view/templateDK/logo.png" class="default-logo img-responsive" alt="runtime">
                    </a>
                    <button type="button" class="navbar-toggle collapsed pull-right " data-toggle="collapse" data-target="#menu" aria-expanded="false">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="">
                    <ul class="nav navbar-nav navbar-right menu-top collapse navbar-collapse" id="menu" aria-expanded="false">
                        <li><a href="gioi-thieu.html" id="" class="">Giới thiệu</a></li>
                        <li><a href="kho-giao-dien.html" id="">Kho giao diện</a></li>
                        <li><a href="bang-gia.html" id="">Bảng giá</a></li>
                        <li><a href="tinh-nang.html" id="">Tính năng</a></li>
                        <li><a href="/storeManagerSystem" id="">Đăng nhập</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <!-- End navbar -->
    </div>
</header>
<div class="inner-heading create-web-bg">
    <div class="overlay-bg"></div>
    <div class="container">
        <div class="row ">
            <div class="col-md-12 text-right">
            </div>
        </div>
    </div>
</div>
 <!--Content (S) -->
  <%@include file="/WEB-INF/views/jsp/centerIndex.jsp" %>
  <!--Content (E) --> 
<footer class="no-margin footer">
    <div class="footer-left-bg"></div>
    <div class="footer-right-bg"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-12 col-xs-12">
                <h2>Runtime.vn<span class="line"></span></h2>
                <ul>
                    <li><a href="kho-giao-dien.html">Kho giao diện</a></li>
                    <li><a href="dang-ky-ten-mien.html">Tên miền</a></li>
                    <li><a href="tinh-nang.html">Tính năng</a></li>
                    <li><a href="bang-gia.html">Bảng giá</a></li>
                    
                    <li><a href="lien-he.html">Liên hệ</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <h2>Giới thiệu<span class="line"></span></h2>
                <ul>
                    <li><a href="gioi-thieu.html">Về chúng tôi</a></li>
                    <li><a href="thanh-toan.html">Hình thức thanh toán</a></li>
                    <li><a href="dieu-khoan-su-dung.html">Điều khoản sử dụng</a></li>
                    <li><a href="chinh-sach-bao-mat.html">Chính sách bảo mật</a></li>
                    <li><a href="http://partner.runtime.vn/">Đối tác</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
                <h2>Hỗ trợ<span class="line"></span></h2>
                <ul>
                    <li><a href="tro-giup.html">Tài liệu hướng dẫn sử dụng</a></li>
                    <li><a href="video.html">Video hướng dẫn sử dụng</a></li>
                    <li><a href="hoi-dap.html">Câu hỏi thường gặp</a></li>
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
            <p class="text-left col-md-12">© Copyright 2014. All rights reserved. Runtime.vn - Giải pháp thương mại điện tử hàng đầu Việt nam</p>
        </div>
    </div>
</footer>
</body>
</html>