<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from runecom26.runtime.vn/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 26 Jul 2017 10:25:46 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta charset="UTF-8" />
    <title>RUNECOM26</title>
    <meta content="RUNECOM26" name="description" />
    <meta content="" name="keywords" />

    <link href="/storeManagerSystem/view/template_3/Scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    
    <link href="/storeManagerSystem/view/template_3/App_Themes/Home/common.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_3/App_Themes/Home/animate.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_3/Scripts/jQuery-ui/jquery-ui.min.css" rel="stylesheet" type="text/css" />

    <script src="/storeManagerSystem/view/template_3/Scripts/jQuery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/jQuery/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/bootstrap/js/bootstrap.min.js"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/jQuery-ui/jquery-ui.min.js" type="text/javascript"></script>

    <script src="/storeManagerSystem/view/template_3/Scripts/common/fix-height.js" data-img-box=".image-resize" type="text/javascript"></script>
<!--     <script src="/storeManagerSystem/view/template_3/Scripts/common/common.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/common/jquery.cookie.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/common/mycard.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/lazyLoad/jquery.lazyload.min.js" type="text/javascript"></script>

    <script src="/storeManagerSystem/view/template_3/Scripts/angularJS/angular.min.js"></script>
    <script src="/storeManagerSystem/view/template_3/Scripts/angularJS/angular-sanitize.min.js"></script> -->
  <!--   <script type="text/javascript" src="/storeManagerSystem/view/template_3/Scripts/angular-loading-spinner/spin.min.js"></script>
    <script type="text/javascript" src="/storeManagerSystem/view/template_3/Scripts/angular-loading-spinner/angular-spinner.min.js"></script>
    <script type="text/javascript" src="/storeManagerSystem/view/template_3/Scripts/angular-loading-spinner/angular-loading-spinner.js"></script> 
 -->
<!--     <script src="/storeManagerSystem/view/template_3/app/appMain.js"></script>
    <script src="/storeManagerSystem/view/template_3/app/directives/directive.js"></script>
    <script src="/storeManagerSystem/view/template_3/app/directives/angular-summernote.js"></script>
    <script src="/storeManagerSystem/view/template_3/app/directives/paging.js"></script>
    <script src="/storeManagerSystem/view/template_3/app/services/ajaxServices.js"></script>
    <script src="/storeManagerSystem/view/template_3/app/services/alertsServices.js"></script> -->
    
    <link href="/storeManagerSystem/view/template_3/App_Themes/RUN026/style.css" rel="stylesheet" type="text/css" />
   
    <link href="/storeManagerSystem/view/template_3/Scripts/owl-carousel/owl.carousel.css" rel="stylesheet" />
	<link href="/storeManagerSystem/view/template_3/Scripts/owl-carousel/owl.theme.css" rel="stylesheet" />
	<script src="/storeManagerSystem/view/template_3/Scripts/owl-carousel/owl.carousel.min.js"></script>
<!-- 	<script src="/storeManagerSystem/view/template_3/app/services/moduleServices.js"></script>
	<script src="/storeManagerSystem/view/template_3/app/controllers/moduleController.js"></script> -->
    <style type="text/css">
    #wrap{margin:0 auto;
    position:relative;}
    #menu{
        display:block;
    }
    #menu li,#menu li a, #sub li a{
        display:block;
        text-align:center;
        background-color:#454545;
        color:#FFF;
         height:50px;
    }
    #menu li{
        float:left;
        list-style:none;
        height:52px;
        width:170px;
        padding:0px;
       	text-transform: uppercase;
       	margin-top: -1px;
       	margin-left: -1px;
        
        }
    #menu li a, #sub li a{
        text-decoration:none;
        padding:5px; 
    }
    #sub li{
        clear:both;
        border:thin #FFF solid;
        margin-top:0px;
            text-transform: uppercase;
    }
    #menu #sub{
        visibility:hidden;
        padding:0px;
        display:block; z-index:1000;position:relative;
    }
    #menu li:hover #sub{
        visibility:visible; z-index:1000;position:relative;
        background-color: #f46164;
        }
    #menu li:hover a {
        background-color: #f46164;
    }
    #menu li:hover #sub li a{
        background-color:#00000; 
    }
    #menu li #sub li:hover a{
        background-color:#00000;
        height:52px;
    }
</style>
</head>
<body>
<div ng-app="LayoutForm" ng-controller="ctrl">
<form:form id="LayoutForm" modelAttribute="LayoutForm" role="form" method="GET" >
	<input type="hidden" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" >
<div class="wrapper page-home">
        <div class="header">
    <section class="top-link clearfix">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav navbar-nav topmenu-contact">
                        <li><i class="fa fa-phone"></i>Hotline: ${LayoutForm.soDienThoai}</li>
                    </ul>
                        <ul class="nav navbar-nav navbar-right topmenu  hidden-xs">
                            <li class="hotline"><a href="#"><i class="fa fa-phone"></i>Hotline: ${LayoutForm.soDienThoai}</a></li>
                            <li class="order-check"><a href="kiem-tra-don-hang.html"><i class="fa fa-pencil-square-o"></i>Kiểm tra đơn hàng</a></li>
                            <li class="order-cart"><a href="gio-hang.html"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                            <li class="account-login"><a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangNhap"><i class="fa fa-sign-in"></i>Đăng nhập </a></li>
                            <li class="account-register"><a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangkitaikhoan"><i class="fa fa-key"></i>Đăng ký </a></li>
                        </ul>
                    <div class="show-mobile hidden-lg hidden-md hidden-sm">
                        <div class="quick-cart">
                            <div class="quickaccess-toggle">
                                <a href="gio-hang.html" title="Giỏ hàng"><i class="fa fa-shopping-cart"></i></a>
                            </div>
                        </div>
                        <div class="quick-tracking">
                            <div class="quickaccess-toggle">
                                <a id="mobile-wishlist-total" href="kiem-tra-don-hang.html" title="Kiểm tra đơn hàng" class="wishlist"><i class="fa fa-pencil-square-o"></i></a>
                            </div>
                        </div>
                        <div class="quick-user">
                            <div class="quickaccess-toggle">
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="inner-toggle">
                                    <ul class="login links">
                                        <li>
                                            <a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangkitaikhoan"><i class="fa fa-sign-in"></i> Đăng ký</a>
                                        </li>
                                        <li>
                                            <a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangNhap"><i class="fa fa-key"></i>Đăng nhập</a>
                                        </li>
                                    </ul>
                            </div>
                        </div>
                        <div class="menu-mobile">
                            <div class="quickaccess-toggle">
                                <span class="ts-mobile-menu-icon-toggle visible-phone fa fa-list" id="menu-icon"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<div class="containter">
    <div class="row">
        <div class="col-xs-12 hidden-lg hidden-md hidden-sm">
            <!-- MENU MAIN -->
            <ul id='nav' class='sf-menu-phone'><li><a class='' href="/storeManagerSystem/${LayoutForm.pathJSP }"><span>Trang chủ</span></a></li>
				<li><a class='' ng-click="btnGioiThieu()"><span>Giới thiệu</span></a></li>
								<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
							        <li>
							            <a style="padding-top: 18px" href="#" data-toggle="dropdown"><span style="font-size: 16px">${items.nameProductCategory }</span> <b class="caret"></b></a>
							            <c:if test="${!empty items.menuRowForms }">
								            <ul id="sub">
											            <c:forEach var="menus" items="${items.menuRowForms }">
											            			<li><a style="font-size: 14px" href="#"><span style="font-size: 16px">${menus.tenLoaiSp }</span></a></li>
											            </c:forEach>
								            </ul>
							            </c:if>
							        </li>
						        </c:forEach>
				<li><a style="padding-top: 15px" class=''   ng-click="btnTinTuc()"><span>Tin tức</span></a></li>
				<li><a ng-click="btnLienHe()">Liên hệ</a></li>
			</ul id='nav' class='sf-menu-phone'>
        </div>
    </div>
</div>
<!-- <script type="text/javascript">
    /********************************** Menu Mobile ********************************************/
    $(document).ready(function() {
        jQuery("#menu-icon").on("click", function() {
            jQuery(".sf-menu-phone").slideToggle();
            jQuery(this).toggleClass("active");
        });

        jQuery('.sf-menu-phone').find('li.parent').append('<i class="fa fa-angle-down"></i>');
        jQuery('.sf-menu-phone li.parent i').on("click", function() {
            if (jQuery(this).hasClass('fa-angle-up')) {
                jQuery(this).removeClass('fa-angle-up').parent('li.parent').find('> ul').slideToggle();
            } else {
                jQuery(this).addClass('fa-angle-up').parent('li.parent').find('> ul').slideToggle();
            }
        });
    });
</script> -->
        <section class="header-content clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-3 col-xs-12 logo text-center">
                        <a href="index.html" title="">
                            <img alt="" src="/storeManagerSystem/view/template_3/Uploads/shop150/images/adv/logo-black-magenta.png" class="img-responsive" />
                        </a>
                    </div>
                    <div class="col-md-6 col-sm-5 col-xs-12 top-search">
                        <div class="search">
                            <div class="input-cat form-search clearfix">
                                <div class="form-search-controls  input-group">
									<input style="width: 400px" type="text" placeholder="Nhập sản phẩm muốn tìm kiếm" path="timKiem_TenSP"  name="timKiem_TenSP" ng-model = "timKiem_TenSP"   />
									<input style="width: 150px;background-color: #f46164;font-weight: bold;" type="submit" value="Tìm kiếm" ng-click ="btnTimKiem()"/>
                                </div>
                            </div>
                        </div>
                        <div class="social-group">
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-4 col-xs-12 top-cart  hidden-xs">
                        <div class="cart" id="cart">
                            <div class="heading">
                                <a href="gio-hang.html">
                                    <span class="icon">icon</span><span id="cart-total">
                                        0
                                        sp - 0đ
                                    </span><i class="fa fa-arrow-right"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type="text/javascript">
            $("#btnsearch").click(function () {
                SearchProduct();
            });
            $("#txtsearch").keydown(function (event) {
                if (event.keyCode == 13) {
                    SearchProduct();
                }
            });
            function SearchProduct() {
                var key = $('#txtsearch').val();
                if (key == '' || key == 'Tìm kiếm...') {
                    $('#txtsearch').focus();
                    return;
                }
                window.location = 'tim-kiem08e2.html?key=' + key;
            }
        </script>

    <section class="navigation-menu clearfix hidden-xs">
        <div class="container">
            <div class="menu-top">
                <div class="row">
                    <div class="col-md-16">
                        <nav class="navbar nav-menu" style="width: 1500px">
                            <div class="navbar-header">
                                <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#mobile-menu" aria-controls="mobile-menu" aria-expanded="false">
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <nav id="mobile-menu" class="mobile-menu collapse navbar-collapse">
                            	<div id="wrap">
                                <ul id="menu"><li><a style="padding-top: 15px" class='' href='trang-chu.html'><span style="font-size: 16px;padding-top: 15px">Trang chủ</span></a></li>
								<li><a style="padding-top: 15px" class='' href='gioi-thieu.html'><span style="font-size: 16px;padding-top: 15px">Giới thiệu</span></a></li>
								<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
							        <li>
							            <a style="padding-top: 15px" href="#" data-toggle="dropdown"><span style="font-size: 16px">${items.nameProductCategory }</span> <b class="caret"></b></a>
							            <c:if test="${!empty items.menuRowForms }">
								            <ul id="sub">
											            <c:forEach var="menus" items="${items.menuRowForms }">
											            			<li><a style="font-size: 14px" href="#"><span style="font-size: 16px;">${menus.tenLoaiSp }</span></a></li>
											            </c:forEach>
								            </ul>
							            </c:if>
							        </li>
						        </c:forEach>
								<li><a style="padding-top: 15px" class='' href='tin-tuc.html'><span style="font-size: 16px;padding-top: 15px">Tin tức</span></a></li>
								<li><a style="padding-top: 15px" class='' hng-click="btnLienHe()"><span style="font-size: 16px;padding-top: 15px">Liên hệ</span></a></li>
								</ul>
							</div>
                            </nav>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>
<script type="text/javascript">
    $(document).ready(function () {
        var str = location.href.toLowerCase();
        $("ul.menu li a").each(function () {
            if (str.indexOf(this.href.toLowerCase()) >= 0) {
                $("ul.menu li").removeClass("active");
                $(this).parent().addClass("active");
            }
        });
    });
</script>
		    <div class="container">
		        <div class="wpb_content_element hidden-sm hidden-md hidden-lg">
		            <section class="widget-container ts-menus-widget">
		                <div type="button" class="collapsed" data-toggle="collapse" data-target="#menu_mobile" aria-expanded="false">
		                    <div class="widget-title-wrapper">
		                        <h3 class="widget-title heading-title btn-navbar">Danh mục sản phẩm</h3>
		                    </div>
		                </div>
		                <nav class="vertical-menu ts-mega-menu-wrapper navbar-collapse collapse" aria-expanded="false" id="menu_mobile" role="tablist">
		                    <ul class='menu mobilemenu tree dhtml' id='menu-shop-by-category'><li class="child"><a href='san-pham/thoi-trang-nu-3592.html'><span class='menu-icon'><i class='fa '></i></span> <span class='menu-label'>Thời trang nữ</span></a><ul><li><a href='san-pham/ao-thun-nu-3593.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Áo thun nữ</span></a></li>
								<li><a href='san-pham/ao-so-mi-nu-3594.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Áo sơ mi nữ</span></a></li>
								<li><a href='san-pham/vay-nu-3595.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Váy nữ</span></a></li>
								<li><a href='san-pham/quan-nu-3596.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Quần nữ</span></a></li>
								</ul></li>
								<li class="child"><a href='san-pham/thoi-trang-nam-3597.html'><span class='menu-icon'><i class='fa '></i></span> <span class='menu-label'>Thời trang nam</span></a>
									<ul>
										<li><a href='san-pham/ao-thun-nam-3598.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Áo thun nam</span></a></li>
										<li><a href='san-pham/ao-so-mi-nam-3599.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Áo sơ mi nam</span></a></li>
										<li><a href='san-pham/quan-nam-3600.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Quần nam</span></a></li>
										<li><a href='san-pham/ao-khoac-nam-3601.html'><span class='menu-icon'><i class='fa fa-check'></i></span> <span class='menu-label'>Áo khoác nam</span></a></li>
									</ul>
								</li>
							</ul class='menu mobilemenu tree dhtml' id='menu-shop-by-category'>
		                </nav>
		            </section>
		        </div>
		    </div>
 </div>
<div class="slideshow" >
<div class="col-md-12">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh1" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh2" alt="Los Angeles" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh3" alt="Los Angeles" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh4" alt="Los Angeles" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh5" alt="Los Angeles" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
   </div>    
  </div>
</div>
    
            <div class="adv">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">

                 </div>
                    </div>
                </div>
            </div>

    
    <div class="main">
        <div class="container">
            <div class="row">
                    <div class="col-md-12">

<c:if test="${!empty LayoutForm.checkSearchBtn }">
<section class="tab-category-container clearfix">
        <div class="tabs-category clearfix">
            <div class="tab-content clearfix">
                <div class="tabs-title">
                    <div id="" class="tab-title">
                        <h3>
                            <span>Sản phẩm tìm kiếm</span>
                        </h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="product-content owl-carousel">
            <div id="product-tab-slide-3592" class="product-tab-slide row">
                		<div class="product-block product-grid clearfix">
                		<c:forEach var="items" items="${LayoutForm.products_SearchByMenu }">
		                        <div class="product-resize product-item-box">
		                            <div class="product-item">
		                                <div class="image image-resize">
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">
		                                        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}"  class="img-responsive" />
		                                    </a>
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}" class="box-inner">
		                                        <ul class="add-to-links">
		                                            <li><span class="add-view">Xem thêm</span></li>
		                                            
		                                        </ul>
		                                    </a>
		                                        <!-- <span class="promotion">-10%</span> -->
		                                </div>
		                                <div class="right-block">
		                                    <h2 class="name">
		                                        <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">${items.tenSP}</a>
		                                    </h2>
		                                    <h2 class="name"></h2>
		                                    <div class="ratings clearfix hidden">
		                                        <div class="rating-box">
		                                            <div class="rating">
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="price">
                                    <c:if test="${!empty items.giaBanKM }">
										<strike class="price-old"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
									</c:if>
									<c:if test="${empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
									</c:if>
									<c:if test="${!empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
									</c:if>
		                                    </div>
		                                    <div class="addtocart-button clearfix">
		                                        <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(3295,1)">Mua</a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                     </c:forEach> 
                		<c:if test="${ LayoutForm.idTenNhomSP_Search != items.nameProductCategory}">
                		<c:forEach var="items" items="${LayoutForm.products }">
		                        <div class="product-resize product-item-box">
		                            <div class="product-item">
		                                <div class="image image-resize">
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">
		                                        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}"  class="img-responsive" />
		                                    </a>
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}" class="box-inner">
		                                        <ul class="add-to-links">
		                                            <li><span class="add-view">Xem thêm</span></li>
		                                            
		                                        </ul>
		                                    </a>
		                                        <!-- <span class="promotion">-10%</span> -->
		                                </div>
		                                <div class="right-block">
		                                    <h2 class="name">
		                                        <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">${items.tenSP}</a>
		                                    </h2>
		                                    <h2 class="name"></h2>
		                                    <div class="ratings clearfix hidden">
		                                        <div class="rating-box">
		                                            <div class="rating">
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="price">
                                    <c:if test="${!empty items.giaBanKM }">
										<strike class="price-old"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
									</c:if>
									<c:if test="${empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
									</c:if>
									<c:if test="${!empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
									</c:if>
		                                    </div>
		                                    <div class="addtocart-button clearfix">
		                                        <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(3295,1)">Mua</a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                     </c:forEach> 
                		</c:if>
                </div>
                <div class="controls boxprevnext">
                    <a class="prev prevlogo"><i class="fa fa-angle-left"></i></a>
                    <a class="next nextlogo"><i class="fa fa-angle-right"></i></a>
                </div>
            </div>
        </div>
    </section>
</c:if>
<c:if test="${empty LayoutForm.checkSearchBtn }">
<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
    <section class="tab-category-container clearfix">
        <div class="tabs-category clearfix">
            <div class="tab-content clearfix">
                <div class="tabs-title">
                    <div id="" class="tab-title">
                        <h3>
                            <span>${items.nameProductCategory }</span>
                        </h3>
                    </div>
                </div>
                <ul class="tab-cates">
					<c:if test="${!empty items.menuRowForms }">
							<ul>
								<c:forEach var="menus" items="${items.menuRowForms }">
									<li data-title="" rel="" class="">
										<a href="/storeManagerSystem/${LayoutForm.pathJSP }/searchByMenu/${menus.idLoaiSp}/${items.nameProductCategory}" >${menus.tenLoaiSp }</a>
									</li>
								</c:forEach>
							</ul>
					</c:if>
                </ul>
            </div>
        </div>
        <div class="product-content owl-carousel">
            <div id="product-tab-slide-3592" class="product-tab-slide row">
                		<div class="product-block product-grid clearfix">
                		<c:if test="${ LayoutForm.idTenNhomSP_Search == items.nameProductCategory}">
                		<c:forEach var="items" items="${LayoutForm.products_SearchByMenu }">
		                        <div class="product-resize product-item-box">
		                            <div class="product-item">
		                                <div class="image image-resize">
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">
		                                        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}"  class="img-responsive" />
		                                    </a>
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}" class="box-inner">
		                                        <ul class="add-to-links">
		                                            <li><span class="add-view">Xem thêm</span></li>
		                                            
		                                        </ul>
		                                    </a>
		                                        <!-- <span class="promotion">-10%</span> -->
		                                </div>
		                                <div class="right-block">
		                                    <h2 class="name">
		                                        <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">${items.tenSP}</a>
		                                    </h2>
		                                    <h2 class="name"></h2>
		                                    <div class="ratings clearfix hidden">
		                                        <div class="rating-box">
		                                            <div class="rating">
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="price">
                                    <c:if test="${!empty items.giaBanKM }">
										<strike class="price-old"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
									</c:if>
									<c:if test="${empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
									</c:if>
									<c:if test="${!empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
									</c:if>
		                                    </div>
		                                    <div class="addtocart-button clearfix">
		                                        <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(3295,1)">Mua</a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                     </c:forEach> 
                		</c:if>
                		<c:if test="${ LayoutForm.idTenNhomSP_Search != items.nameProductCategory}">
                		<c:forEach var="items" items="${LayoutForm.products }">
		                        <div class="product-resize product-item-box">
		                            <div class="product-item">
		                                <div class="image image-resize">
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">
		                                        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}"  class="img-responsive" />
		                                    </a>
		                                    <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}" class="box-inner">
		                                        <ul class="add-to-links">
		                                            <li><span class="add-view">Xem thêm</span></li>
		                                            
		                                        </ul>
		                                    </a>
		                                        <!-- <span class="promotion">-10%</span> -->
		                                </div>
		                                <div class="right-block">
		                                    <h2 class="name">
		                                        <a href="/storeManagerSystem/view/template_3/san-pham/ao-so-mi-nu-cong-so.html" title="${items.tenSP}">${items.tenSP}</a>
		                                    </h2>
		                                    <h2 class="name"></h2>
		                                    <div class="ratings clearfix hidden">
		                                        <div class="rating-box">
		                                            <div class="rating">
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="price">
                                    <c:if test="${!empty items.giaBanKM }">
										<strike class="price-old"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
									</c:if>
									<c:if test="${empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
									</c:if>
									<c:if test="${!empty items.giaBanKM }">
										<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
									</c:if>
		                                    </div>
		                                    <div class="addtocart-button clearfix">
		                                        <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(3295,1)">Mua</a>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                     </c:forEach> 
                		</c:if>
                </div>
                <div class="controls boxprevnext">
                    <a class="prev prevlogo"><i class="fa fa-angle-left"></i></a>
                    <a class="next nextlogo"><i class="fa fa-angle-right"></i></a>
                </div>
            </div>
        </div>
    </section>
 </c:forEach> 
</c:if>
<script type="text/javascript">
    var arr = $.parseJSON('[3592,3597]');
    $(document).ready(function () {
        $.each(arr, function (index, it) {
            var owlproductslide2 = $("#product-tab-slide-" + it + " .product-block");
            owlproductslide2.owlCarousel({
                autoPlay: true,
                autoPlay: 5000,
                items: 4,
                slideSpeed: 1000,
                pagination: false,
                itemsDesktop: [1200, 4],
                itemsDesktopSmall: [980, 3],
                itemsTablet: [767, 2],
                itemsMobile: [480, 2]
            });
            $("#product-tab-slide-" + it + " .nextlogo").click(function () {
                owlproductslide2.trigger('owl.next');
            })
            $("#product-tab-slide-" + it + " .prevlogo").click(function () {
                owlproductslide2.trigger('owl.prev');
            })
        });

    });
</script>    <div class="box-html">
        <div class="policy-content clearfix">
                    <div class="col-md-3  clearfix">
                        <div class="sale-policy-block">
                            <i class="fa fa-refresh"></i>
                            <span>Hoàn trả trong<br>30 ngày</span>
                        </div>
                    </div>
                    <div class="col-md-3 clearfix">
                        <div class="sale-policy-block">
                            <i class="fa fa-truck"></i>
                           <span>Giao hàng<br>miễn phí</span>
                        </div>
                    </div>
                    <div class="col-md-3 clearfix">
                        <div class="sale-policy-block">
                            <i class="fa fa-life-saver"></i>
                            <span>Thanh toán<br>linh hoạt</span>
                        </div>
                    </div>
                    <div class="col-md-3 clearfix">
                        <div class="sale-policy-block">
                            <i class="fa fa-users"></i>
                            <span>Hỗ trợ<br>khách hàng</span>
                        </div>
                    </div>
                </div>
    </div>
                    </div>
            </div>
        </div>
    </div>

    
            <div class="partner">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
    <!--Begin-->
 <!--    <script type="text/javascript">
        $(document).ready(function () {
            var owl = $(".partner-block");
            owl.owlCarousel({
                autoPlay: true,
                autoPlay: 5000,
                items: 6,
                slideSpeed: 1000,
                pagination: false,
                itemsDesktop: [1200, 6],
                itemsDesktopSmall: [980, 5],
                itemsTablet: [767, 4],
                itemsMobile: [480, 2]
            });
            $(".partner-content .nextlogo").click(function () {
                owl.trigger('owl.next');
            });
            $(".partner-content .prevlogo").click(function () {
                owl.trigger('owl.prev');
            });
        });
    </script> -->
    <!--End-->
<script type="text/javascript">
    window.Partners = [{"Id":236,"ShopId":150,"Name":"1","Link":"#","Logo":"/Uploads/shop150/images/adv/partner07.png","Index":1,"Inactive":false},{"Id":237,"ShopId":150,"Name":"2","Link":"#","Logo":"/Uploads/shop150/images/adv/partner08.png","Index":2,"Inactive":false},{"Id":238,"ShopId":150,"Name":"3","Link":"#","Logo":"/Uploads/shop150/images/adv/partner09.png","Index":3,"Inactive":false},{"Id":239,"ShopId":150,"Name":"4","Link":"#","Logo":"/Uploads/shop150/images/adv/partner10.png","Index":4,"Inactive":false},{"Id":240,"ShopId":150,"Name":"5","Link":"#","Logo":"/Uploads/shop150/images/adv/partner11.png","Index":5,"Inactive":false},{"Id":250,"ShopId":150,"Name":"6","Link":"#","Logo":"/Uploads/shop150/images/adv/partner12.png","Index":6,"Inactive":false}];
</script>                        </div>
                    </div>
                </div>
            </div>

    
        <div class="footer">

    <div class="footer-content clearfix">
        <div class="container">
            <div class="row">
                    <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                        <div class="item">
                            <h3>
                                <span>Giới thiệu</span>
                            </h3>
                            <div class="toggle-footer">
                                    <ul>
                                                        <li>
                                                            <a ng-click="btnGioiThieu()">
                                                                Về ch&#250;ng t&#244;i
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="content/hoi-dap.html">
                                                                Hỏi đ&#225;p
                                                            </a>
                                                        </li>
                                    </ul>
                            </div>
                        </div>
                    </div>
                    <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                        <div class="item">
                            <h3>
                                <span>Trợ gi&#250;p</span>
                            </h3>
                            <div class="toggle-footer">
                                    <ul>
                        <li>
                            <a href="content/huong-dan-thanh-toan.html">
                                Hướng dẫn thanh to&#225;n
                            </a>
                        </li>
                        <li>
                            <a href="content/chinh-sach-ban-hang.html">
                                Hướng dẫn đặt hàng
                            </a>
                        </li>
                                    </ul>
                            </div>
                        </div>
                    </div>
                <div class="footer-box box-address col-md-3 col-sm-12 col-xs-12">
                    <div class="item">
                        <h3>
                            Thông tin công ty
                        </h3>
                        <div class="box-address-content toggle-footer">
                            <b>${LayoutForm.tenCuaHang}</b>
                            <p><i class="fa fa-map-marker"></i> ${LayoutForm.diaChi}</p>
                            <p>
                                <i class="fa fa-envelope"></i>
                                <a href="mailto:info@runtime.vn">info@runtime.vn</a>
                            </p>
                            <p>
                                <i class="fa fa-phone"></i>
                                Phone: ${LayoutForm.soDienThoai}
                            </p>
                        </div>
                    </div>
                </div>
                <div class="footer-box box-social col-md-3 col-sm-12 col-xs-12">
                    <div class="item">
                        <h3>
                            Facebook
                        </h3>
                        <div class="toggle-footer">
                            <div class="fb-like-box" data-href="https://www.facebook.com/C%E1%BB%ADa-h%C3%A0ng-th%E1%BB%9Di-trang-255302581636729/" data-width="289"
                                 data-height="190" data-colorscheme="dark" data-show-faces="true" data-header="false"
                                 data-stream="false" data-show-border="false">
                            </div>
                            <div class="social-icon">
                                <ul>
                                    <div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="true"></div>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/nl_NL/sdk.js#xfbml=1&version=v2.10";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
<!-- <script type="text/javascript">
    var responsiveflag = false;
    $(document).ready(function(){
        responsiveResize();
        $(window).resize(responsiveResize);
    });
    function responsiveResize()
    {
        if ($(window).width() <= 767 && responsiveflag == false)
        {
            accordion('enable');
            accordionFooter('enable');
            responsiveflag = true;
        }
        else if ($(window).width() >= 768)
        {
            accordion('disable');
            accordionFooter('disable');
            responsiveflag = false;
        }

    }

    function accordionFooter(status)
    {
        if(status == 'enable')
        {
            $('.footer .footer-box h3').on('click', function(){
                $(this).toggleClass('active').parent().find('.toggle-footer').stop().slideToggle('medium');
            })
            $('.footer').addClass('accordion').find('.toggle-footer').slideUp('fast');
        }
        else
        {

            $('.footer .footer-box h3').removeClass('active').off().parent().find('.toggle-footer').removeAttr('style').slideDown('fast');
            $('.footer').removeClass('accordion');
        }
    }

</script>  -->       </div>

</div>

    <div style="display: none;" id="loading-mask">
        <div id="loading_mask_loader" class="loader">
            <img alt="Loading..." src="/storeManagerSystem/view/template_3/Images/ajax-loader-main.gif" />
            <div>
                Please wait...
            </div>
        </div>
    </div>
    <a class="back-to-top" href="#" style="display: inline;">
        <i class="fa fa-angle-up">
        </i>
    </a>
		  <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));</script>
  <style>#cfacebook{position:fixed;bottom:0px;right:100px;z-index:999999999999999;width:250px;height:auto;box-shadow:6px 6px 6px 10px rgba(0,0,0,0.2);border-top-left-radius:5px;border-top-right-radius:5px;overflow:hidden;}#cfacebook .fchat{float:left;width:100%;height:270px;overflow:hidden;display:none;background-color:#fff;}#cfacebook .fchat .fb-page{margin-top:-130px;float:left;}#cfacebook a.chat_fb{float:left;padding:0 25px;width:250px;color:#fff;text-decoration:none;height:40px;line-height:40px;text-shadow:0 1px 0 rgba(0,0,0,0.1);background-image:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAqCAMAAABFoMFOAAAAWlBMV…8/UxBxQDQuFwlpqgBZBq6+P+unVY1GnDgwqbD2zGz5e1lBdwvGGPE6OgAAAABJRU5ErkJggg==);background-repeat:repeat-x;background-size:auto;background-position:0 0;background-color:#3a5795;border:0;border-bottom:1px solid #133783;z-index:9999999;margin-right:12px;font-size:18px;}#cfacebook a.chat_fb:hover{color:yellow;text-decoration:none;}</style>
  <script>
  jQuery(document).ready(function () {
  jQuery(".chat_fb").click(function() {
jQuery('.fchat').toggle('slow');
  });
  });
  </script>
  <div id="cfacebook">
  <a href="javascript:;" class="chat_fb" onclick="return:false;"><i class="fa fa-facebook-square"></i> Phản hồi của bạn</a>
  <div class="fchat">
  <div class="fb-page" data-tabs="messages" data-href="${LayoutForm.linkFanpage}" data-width="250" data-height="400" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="false"></div>
  </div>
  </div>
<div id="fb-root"></div>
</form:form>
</div>
</body>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</html>


