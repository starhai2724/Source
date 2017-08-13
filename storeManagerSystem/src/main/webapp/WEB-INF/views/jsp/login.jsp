<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
                        <img alt="runtime" class="scroller-logo" src="/storeManagerSystem/view/templateDK/logoHeader.jpg">
                        <img src="/storeManagerSystem/view/templateDK/logoHeader.jpg" class="default-logo img-responsive" alt="runtime">
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
  <section class="theme-list create-web" ng-app="login" ng-controller="ctrllogin" >
    <div class="container">
        <h1 class="text-uppercase clearfix title">Hệ thống bán hàng</h1>
        <form:form class="step-block-box clearfix" id="loginform" modelAttribute="LoginForm" role="form" method="GET" > 
			<p style="color: red; font-weight: bold;">${LoginForm.messageErr }</p>
            <div class="col-sm-6 col-xs-12 col-sm-offset-3 step-block1 ">
                <div class="form-group has-feedback">
                    <form:input type="text" class="form-control" placeholder="Tên đăng nhập"  ng-model="username" path="username" ng-init="username='${username}'" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{username_err}}</p>
                </div>
                <div class="form-group has-feedback">
                    <form:input type="password" class="form-control" placeholder="Mật khẩu"   ng-model="password"  path="password" ng-init="password='${password}'"  />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{password_err}}</p>
                </div>
                <div class ="form-group has-feedback" align="left">
					<a href ="javascript:void(0)" ng-click="btnRegister();">Đăng kí</a>
					</br>
					<a href ="/storeManagerSystem/quenMatKhau/init" >Quên mật khẩu</a>
					</br>
					<a href ="/storeManagerSystem/doiMatKhau/init">Đổi mật khẩu</a>
					
				</div>
                <div class="form-group button-group">
                    <div class="button">
                        <input class="btn btn-default" id = "btnLogin" type="button" ng-click="btnLogin();" value="Đăng nhập" />
<!--                         <input type="button" id = "btnLogin" class="btn btn-lg btn-success btn-block" ng-click="btnLogin();" value="Đăng nhập" onkeydown = "if (event.keyCode == 13)document.getElementById('btnLogin').click()"> -->
                    </div>
                </div>
            </div>
       </form:form> 
    </div>
</section>   
  <!--Content (E) --> 
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
                    <li><a href="http://partner.runtime.vn/">Đối tác</a></li>
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
            <p class="text-left col-md-12">© Copyright 2014. All rights reserved. Runtime.vn - Giải pháp thương mại điện tử hàng đầu Việt nam</p>
        </div>
    </div>
</footer>
</body>
<script src="/storeManagerSystem/view/js/controllerLogin.js"></script>
</html>
