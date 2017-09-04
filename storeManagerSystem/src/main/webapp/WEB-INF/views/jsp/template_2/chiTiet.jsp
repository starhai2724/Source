<!DOCTYPE html>
<html lang="en">
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <title>${LayoutForm.tenCuaHang}</title>
    <meta content="" name="keywords" />
    <link rel="shortcut icon" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/App_Themes/Home/font-awesome.min.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/App_Themes/Home/common.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/App_Themes/Home/animate.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/jQuery-ui/jquery-ui.min.css" rel="stylesheet" type="text/css" />
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/jQuery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/jQuery/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/bootstrap/js/bootstrap.min.js"></script>
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/jQuery-ui/jquery-ui.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/common/fix-height.js" data-img-box=".image-resize" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/common/common.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/common/jquery.cookie.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/js/angular.min.js"></script>
  <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/app/directives/paging.js"></script> 
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/../static.runtime.vn/App_Themes/RUN022/style.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/../static.runtime.vn/App_Themes/RUN022/responsive.css" rel="stylesheet" type="text/css" />
    
    
    <style type="text/css">
    #wrap{margin:0 auto;
    position:relative;}
    #menu{
        display:block;
    }
    #menu li,#menu li a, #sub li a{
        display:block;
        text-align:center;
        background-color:#42a8bf;
        color:#FFF;
         height:52px;
    }
    #menu li{
        float:left;
        list-style:none;
        height:52px;
        width:150px;
        padding:0px;
        
        }
    #menu li a, #sub li a{
        text-decoration:none;
        padding:5px; 
    }
    #sub li{
        clear:both;
        border:thin #FFF solid;
        margin-top:0px;
    }
    #menu #sub{
        visibility:hidden;
        padding:0px;
        display:block; z-index:1000;position:relative;
    }
    #menu li:hover #sub{
        visibility:visible; z-index:1000;position:relative;
        }
    #menu li:hover a {
        background-color:rgba(51,0,0,0.5); 
    }
    #menu li:hover #sub li a{
        background-color:#42a8bf; 
    }
    #menu li #sub li:hover a{
        background-color:#1a525e;
        height:52px;
    }
</style>
</head>
<body ng-app="appMain" style="" class="ng-scope">
        <div id="fb-root" class=" fb_reset"><div style="position: absolute; top: -10000px; height: 0px; width: 0px;"><div></div></div><div style="position: absolute; top: -10000px; height: 0px; width: 0px;"><div><iframe name="fb_xdm_frame_http" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" id="fb_xdm_frame_http" aria-hidden="true" title="Facebook Cross Domain Communication Frame" tabindex="-1" src=/storeManagerSystem/view/template_2/chiTiet_files/0sTQzbapM8j.html" style="border: none;"></iframe><iframe name="fb_xdm_frame_https" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" id="fb_xdm_frame_https" aria-hidden="true" title="Facebook Cross Domain Communication Frame" tabindex="-1" src=/storeManagerSystem/view/template_2/chiTiet_files/0sTQzbapM8j(1).html" style="border: none;"></iframe></div></div></div>
        <script>
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6&appId=227481454296289";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
    

<div class="wrapper">
    
        <div class="header">

<script src=/storeManagerSystem/view/template_2/chiTiet_files/login.js.tải xuống" type="text/javascript"></script>
    <section class="top-link clearfix">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav navbar-nav topmenu-contact pull-left">
                        <li><i class="fa fa-phone"></i> <span>Hotline:0908 77 00 95</span></li>
                    </ul>
                        <ul class="nav navbar-nav navbar-right topmenu  hidden-xs hidden-sm">
                            <li class="order-check"><a href="http://runecom22.runtime.vn/kiem-tra-don-hang.html"><i class="fa fa-pencil-square-o"></i> Kiểm tra đơn hàng</a></li>
                            <li class="order-cart"><a href="http://runecom22.runtime.vn/gio-hang.html"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a></li>
                            <li class="account-login"><a href="http://runecom22.runtime.vn/dang-nhap.html"><i class="fa fa-sign-in"></i> Đăng nhập </a></li>
                            <li class="account-register"><a href="http://runecom22.runtime.vn/dang-ky.html"><i class="fa fa-key"></i> Đăng ký </a></li>
                        </ul>
                    <div class="show-mobile hidden-lg hidden-md">
                        <div class="quick-user">
                            <div class="quickaccess-toggle">
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="inner-toggle">
                                    <ul class="login links">
                                        <li>
                                            <a href="http://runecom22.runtime.vn/dang-ky.html"><i class="fa fa-sign-in"></i> Đăng ký</a>
                                        </li>
                                        <li>
                                            <a href="http://runecom22.runtime.vn/dang-nhap.html"><i class="fa fa-key"></i> Đăng nhập</a>
                                        </li>
                                    </ul>
                            </div>
                        </div>
                        <div class="quick-access">
                            <div class="quickaccess-toggle">
                                <i class="fa fa-list"></i>
                            </div>
                            <div class="inner-toggle">
                                <ul class="links">
                                    <li><a id="mobile-wishlist-total" href="http://runecom22.runtime.vn/kiem-tra-don-hang.html" class="wishlist"><i class="fa fa-pencil-square-o"></i> Kiểm tra đơn hàng</a></li>
                                    <li><a href="http://runecom22.runtime.vn/gio-hang.html" class="shoppingcart"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

        <section class="header-content clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-xs-12 col-sm-12 header-left text-center">
                        <div class="logo">
                            <a href="http://runecom22.runtime.vn/" title="">
                                <img alt="" src=/storeManagerSystem/view/template_2/chiTiet_files/logo.png" class="img-responsive">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-9 col-xs-12 col-sm-12 header-right">
                        <div class="sale-policy clearfix hidden-sm hidden-xs">
                            <ul class="clearfix">
                                <li class="shipping">
                                    <i class="fa fa-truck"></i><span>
                                        Giao hàng miễn phí
                                    </span>
                                </li>
                                <li class="payment">
                                    <i class="fa fa-money"></i><span>
                                        Thanh toán linh hoạt
                                    </span>
                                </li>
                                <li class="return">
                                    <i class="fa fa-refresh"></i><span>
                                        Trả hàng trong 30 ngày
                                    </span>
                                </li>
                            </ul>
                        </div>
                        <div class="search hidden-sm hidden-xs">
                            <div class="input-cat form-search clearfix">
                                <div class="form-search-controls">
                                    <input type="text" name="search" id="txtsearch" onblur="if(this.value==&#39;&#39;)this.value=&#39;Tìm kiếm...&#39;" onfocus="if(this.value==&#39;Tìm kiếm...&#39;)this.value=&#39;&#39;" value="Tìm kiếm...">
                                    <div class="select-categories">
                                        <select name="lbgroup" id="lbgroup">
                                            <option value="0" selected="selected">Tất cả</option>
                                            <option class="option-1" value="3114">Thời trang nữ</option>
                                            <option class="option-1" value="3119">Thời trang nam</option>
                                            <option class="option-1" value="3125">Phụ kiện</option>
                                            <option class="option-1" value="3126">Thời trang trẻ em</option>
                                        </select>
                                    </div>
                                </div>
                                <button class="btn btn-search" title="Search" type="button" id="btnsearch" value="Search">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <div class="social-group">
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
                var group = $('#lbgroup').val();
                window.location = '/tim-kiem.html?group=' + group + '&key=' + key;
            }
        </script>

<section class="navigation-menu clearfix">
    <div class="container">
        <div class="menu-top">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar nav-menu">
                        <div class="navbar-header">
                            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#mobile-menu" aria-controls="mobile-menu" aria-expanded="false">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <nav id="mobile-menu" class="mobile-menu collapse navbar-collapse">
                            <ul class="menu nav navbar-nav"><li class="level0"><a class="" href="http://runecom22.runtime.vn/trang-chu.html"><span>Trang chủ</span></a></li>
<li class="level0"><a class="" href="http://runecom22.runtime.vn/gioi-thieu.html"><span>Giới thiệu</span></a></li>
<li class="level0"><a class="" href="http://runecom22.runtime.vn/san-pham.html"><span>Sản phẩm</span></a></li>
<li class="level0"><a class="" href="http://runecom22.runtime.vn/tin-tuc.html"><span>Tin tức</span></a></li>
<li class="level0"><a class="" href="http://runecom22.runtime.vn/lien-he.html"><span>Liên hệ</span></a></li>
</ul>
                        </nav>
                        <div class="cart pull-right">
                            <a href="http://runecom22.runtime.vn/gio-hang.html">
                                <i class="fa fa-shopping-cart"></i>Giỏ hàng <span>(0)</span>
                            </a>
                        </div>
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

        </div>


    

    

    
    <div class="main">
        <div class="container">
            <div class="row">
                    <div class="col-md-9">

<div class="breadcrumb clearfix">
    <ul>
                    <li itemtype="http://data-vocabulary.org/Breadcrumb" itemscope="" class="home">
                        <a title="Đến trang chủ" href="http://runecom22.runtime.vn/" itemprop="url"><span itemprop="title">Trang chủ</span></a>
                    </li>
                        <li itemtype="http://data-vocabulary.org/Breadcrumb" itemscope="" class="category17 icon-li">
                            <div class="link-site-more">
                                <a title="" href="http://runecom22.runtime.vn/san-pham/thoi-trang-nu-3114" itemprop="url">
                                    <span itemprop="title">Thời trang nữ</span>
                                        <img width="13" height="13" src=/storeManagerSystem/view/template_2/chiTiet_files/icon-link-more.jpg">
                                </a>
                                    <ul class="s-c-n" style="display: none;">
                                            <li class="sprites">
                                                <a title="Váy nữ" href="http://runecom22.runtime.vn/san-pham/vay-nu-3115">
                                                    Váy nữ
                                                </a>
                                            </li>
                                            <li class="sprites">
                                                <a title="Quần nữ" href="http://runecom22.runtime.vn/san-pham/quan-nu-3116">
                                                    Quần nữ
                                                </a>
                                            </li>
                                            <li class="sprites">
                                                <a title="Áo thun nữ" href="http://runecom22.runtime.vn/san-pham/ao-thun-nu-3117">
                                                    Áo thun nữ
                                                </a>
                                            </li>
                                            <li class="sprites">
                                                <a title="Áo sơ mi nữ" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-3118">
                                                    Áo sơ mi nữ
                                                </a>
                                            </li>
                                    </ul>
                            </div>
                        </li>
                        <li itemtype="http://data-vocabulary.org/Breadcrumb" itemscope="" class="category17 icon-li">
                            <div class="link-site-more">
                                <a title="" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-3118" itemprop="url">
                                    <span itemprop="title">Áo sơ mi nữ</span>
                                </a>
                            </div>
                        </li>
                    <li class="productname icon-li"><strong>Áo Sơ Mi Nữ Công Sở </strong> </li>
    </ul>
</div>
<script type="text/javascript">
    $(".link-site-more").hover(function () { $(this).find(".s-c-n").show(); }, function () { $(this).find(".s-c-n").hide(); });
</script>

<link href="/storeManagerSystem/view/template_2/chiTiet_files/smoothproducts.css" rel="stylesheet" type="text/css">
<script src=/storeManagerSystem/view/template_2/chiTiet_files/smoothproducts.js.tải xuống" type="text/javascript"></script>
<script src=/storeManagerSystem/view/template_2/chiTiet_files/productServices.js.tải xuống"></script>
<script src=/storeManagerSystem/view/template_2/chiTiet_files/productController.js.tải xuống"></script>
<div class="product-detail clearfix relative ng-scope" ng-controller="productController" ng-init="initController(2652)">
    <span us-spinner="{radius:5, width:3, length: 3}" class="ng-scope ng-hide"><div class="spinner" role="progressbar" style="position: absolute; width: 0px; z-index: 2000000000; left: 50%; top: 50%;"><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-0-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(0deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-1-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(30deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-2-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(60deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-3-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(90deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-4-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(120deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-5-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(150deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-6-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(180deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-7-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(210deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-8-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(240deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-9-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(270deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-10-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(300deg) translate(5px, 0px); border-radius: 1px;"></div></div><div style="position: absolute; top: -1px; opacity: 0.25; animation: opacity-100-25-11-12 1s linear infinite;"><div style="position: absolute; width: 6px; height: 3px; background: rgb(0, 0, 0); box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 1px; transform-origin: left center 0px; transform: rotate(330deg) translate(5px, 0px); border-radius: 1px;"></div></div></div></span>
        <!--Begin-->
        <div class="product-block clearfix">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12 product-image clearfix">
                    <div class="sp-loading" style="display: none;"><img src=/storeManagerSystem/view/template_2/chiTiet_files/sp-loading.gif" alt=""><br>LOADING IMAGES</div>
                    <div class="sp-wrap sp-non-touch" style="display: inline-block;">
                        <!-- ngRepeat: item in ProductImages --><!-- end ngRepeat: item in ProductImages -->
                    <div class="sp-large"><a href="/storeManagerSystem/view/template_2/chiTiet_files/126236_fashion.jpg" ng-repeat="item in ProductImages" class="ng-scope .sp-current-big"><img src=/storeManagerSystem/view/template_2/chiTiet_files/126236_fashion.jpg"></a><div class="sp-zoom" style="display: block; left: -1px; top: 0px; opacity: 0.0588544;"><img src=/storeManagerSystem/view/template_2/chiTiet_files/126236_fashion.jpg"></div></div></div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 clearfix">
                    <h2 class="ng-binding">Áo Sơ Mi Nữ Công Sở </h2>
                    <!-- ngIf: IsTrackingInventory==false||AllowPurchaseWhenSoldOut==true || (IsTrackingInventory&&AllowPurchaseWhenSoldOut==false&&Quantity>0) --><div class="price ng-scope" ng-if="IsTrackingInventory==false||AllowPurchaseWhenSoldOut==true || (IsTrackingInventory&amp;&amp;AllowPurchaseWhenSoldOut==false&amp;&amp;Quantity&gt;0)">
                        <!-- ngIf: IsPromotion==true --><div ng-if="IsPromotion==true" class="ng-scope">
                            <span class="price-new ng-binding">202,500đ</span>
                            <span class="price-old ng-binding">225,000đ</span>
                        </div><!-- end ngIf: IsPromotion==true -->
                        <!-- ngIf: IsPromotion==false -->
                        <span class="product-code ng-binding">Mã SP: </span>
                    </div><!-- end ngIf: IsTrackingInventory==false||AllowPurchaseWhenSoldOut==true || (IsTrackingInventory&&AllowPurchaseWhenSoldOut==false&&Quantity>0) -->
                    <!-- ngIf: IsTrackingInventory==true&&AllowPurchaseWhenSoldOut==false&&Quantity<=0 -->
                    <div class="des ng-binding" ng-bind-html="Summary|unsafe"><p>
	Áo Công Sở Tay Búp Sang Trọng – Kiểu Dáng Thời Trang, Chất Liệu Tơ Gân Mềm Mịn, Gam Màu Tươi Tắn – Mang Đến Vẻ Ngoài Trẻ Trung, Duyên Dáng Cho Bạn Gái. Giá 210.000 VNĐ, Còn 125.000 VNĐ, Giảm 40%.&nbsp;</p>
</div>
                    <div class="social">
                        <!-- AddThis Button BEGIN -->
                        <div class="addthis_toolbox addthis_default_style">
                            <a class="addthis_button_facebook_like at300b" fb:like:layout="button_count"><div class="fb-like fb_iframe_widget" data-layout="button_count" data-show_faces="false" data-share="true" data-action="like" data-width="90" data-height="25" data-font="arial" data-href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html" data-send="false" style="height: 25px;" fb-xfbml-state="rendered" fb-iframe-plugin-query="action=like&amp;app_id=227481454296289&amp;container_width=0&amp;font=arial&amp;height=25&amp;href=http%3A%2F%2Frunecom22.runtime.vn%2Fsan-pham%2Fao-so-mi-nu-cong-so.html&amp;layout=button_count&amp;locale=en_US&amp;sdk=joey&amp;send=false&amp;share=true&amp;show_faces=false&amp;width=90"><span style="vertical-align: bottom; width: 106px; height: 20px;"><iframe name="f15763d9488a8d" width="90px" height="25px" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" title="fb:like Facebook Social Plugin" src=/storeManagerSystem/view/template_2/chiTiet_files/like.html" style="border: none; visibility: visible; width: 106px; height: 20px;" class=""></iframe></span></div></a>
                            <a class="addthis_button_google_plusone at300b" g:plusone:size="medium"><div class="google_plusone_iframe_widget" style="width: 90px; height: 25px;"><span><div id="___plusone_0" style="text-indent: 0px; margin: 0px; padding: 0px; background: transparent; border-style: none; float: none; line-height: normal; font-size: 1px; vertical-align: baseline; display: inline-block; width: 32px; height: 20px;"><iframe ng-non-bindable="" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" style="position: static; top: 0px; width: 32px; margin: 0px; border-style: none; left: 0px; visibility: visible; height: 20px;" tabindex="0" vspace="0" width="100%" id="I1_1504436003365" name="I1_1504436003365" src=/storeManagerSystem/view/template_2/chiTiet_files/fastbutton.html" data-gapiattached="true" title="G+"></iframe></div></span></div></a>
                            <a class="addthis_counter addthis_pill_style addthis_nonzero addthis_nonzero" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#" style="display: inline-block;"><a class="atc_s addthis_button_compact">Chia sẻ<span></span></a><a class="addthis_button_expanded" target="_blank" title="Thêm..." href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#">1</a></a>
                        <div class="atclear"></div></div>
                        <script type="text/javascript" src=/storeManagerSystem/view/template_2/chiTiet_files/addthis_widget.js.tải xuống"></script>
                        <!-- AddThis Button END -->
                    </div>
                    <!-- ngRepeat: item in ProductOptions -->
                    <div class="quantity clearfix">
                        <label>Số lượng</label>
                        <div class="quantity-input">
                            <input type="number" value="1" class="text ng-pristine ng-untouched ng-valid" ng-model="InputQuantity" ng-init="InputQuantity=1">
                        </div>
                    </div>
                    <!-- ngIf: IsTrackingInventory==false||AllowPurchaseWhenSoldOut==true || (IsTrackingInventory&&AllowPurchaseWhenSoldOut==false&&Quantity>0) --><div class="button ng-scope" ng-if="IsTrackingInventory==false||AllowPurchaseWhenSoldOut==true || (IsTrackingInventory&amp;&amp;AllowPurchaseWhenSoldOut==false&amp;&amp;Quantity&gt;0)">
                        <a href="javascript:void(0)" ng-click="addToCard()" class="btn btn-default"><i class="glyphicon glyphicon-shopping-cart"></i>Thêm giỏ hàng</a>
                        <a href="javascript:void(0)" ng-click="addToCardBuy()" class="btn btn-primary"><i class="glyphicon glyphicon-ok"></i>Mua ngay</a>
                    </div><!-- end ngIf: IsTrackingInventory==false||AllowPurchaseWhenSoldOut==true || (IsTrackingInventory&&AllowPurchaseWhenSoldOut==false&&Quantity>0) -->
                    <!-- ngIf: IsTrackingInventory==true&&AllowPurchaseWhenSoldOut==false&&Quantity<=0 -->
                    <div class="call">
                        <p class="title">Để lại số điện thoại, chúng tôi sẽ tư vấn ngay sau từ 5 › 10 phút</p>
                        <div class="input">
                            <div class="input-group">
                                <input class="form-control ng-pristine ng-untouched ng-valid" ng-model="CustomerPhone" onblur="if(this.value==&#39;&#39;)this.value=&#39;Nhập số điện thoại...&#39;" onfocus="if(this.value==&#39;Nhập số điện thoại...&#39;)this.value=&#39;&#39;" value="Nhập số điện thoại..." type="text">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button" ng-click="callMe()"><i class="fa fa-phone"></i> Gọi lại cho tôi</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="product-tabs">
            <ul class="nav nav-tabs">
                <!-- ngRepeat: item in ProductTabs --><li role="presentation" ng-class="{&#39;active&#39;:$index==0}" ng-repeat="item in ProductTabs" class="ng-scope active">
                    <a data-toggle="tab" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#tab1" class="ng-binding">Chi tiết sản phẩm</a>
                </li><!-- end ngRepeat: item in ProductTabs -->
            </ul>
            <div class="tab-content">
                <!-- ngRepeat: item in ProductTabs --><div class="tab-pane fade in ng-scope active" ng-class="{&#39;active&#39;:$index==0}" id="tab1" ng-repeat="item in ProductTabs">
                    <div ng-bind-html="item.Content|unsafe" class="ng-binding"><div>
	Điểm nổi bật</div>
<div>
	- Áo công sở được thiết kế đơn giản, nhưng không kém phần tinh tế, với form áo vừa vặn, cổ bẻ, điểm nhấn ở phần tay búp sen được may cách điệu, đẹp mắt.</div>
<div>
	- Chất liệu tơ gân mềm mịn, thông thoáng và thấm hút mồ hôi tốt, nên tạo được cảm giác thoải mái cho người mặc</div>
<div>
	- Ba gam màu: hồng, xanh, trắng tươi tắn, trẻ trung, rất dễ để kết hợp với chân váy công sở, quần tây, jeans,… tạo vẻ ngoài chỉn chu khi đi làm.</div>
<div>
	- Trọng lượng gói hàng cả bao bì: 150 gram</div>
<div>
	&nbsp;</div>
<div>
	Điều kiện</div>
<div>
	- Hotdeal giao sản phẩm theo màu đến tận tay khách hàng.</div>
<div>
	+ Đối với khu vực TP.HCM: Miễn phí.</div>
<div>
	+ Đối với các tỉnh thành khác: Chuyển phát nhanh theo phí bưu điện.</div>
<div>
	- Áp dụng cho Áo công sở tay búp sang trọng</div>
<div>
	- Màu sắc: hồng, xanh, trắng</div>
<div>
	- Kích cỡ: Freesize &nbsp; &nbsp;</div>
<div>
	- Thời gian cuối giao sản phẩm đến hết 23/05/2015, không giao sản phẩm ngày chủ nhật.</div>
<div>
	- Khách hàng không bù thêm tiền khi nhận sản phẩm.</div>
<div>
	- Khách hàng vui lòng kiểm tra sản phẩm trước khi nhận hàng, Hotdeal không chịu trách nhiệm đổi trả sản phẩm sau khi giao hàng.</div>
</div>
                </div><!-- end ngRepeat: item in ProductTabs -->
            </div>
        </div>
        <!--End-->
    <div class="modal fade" id="modalMyCart" tabindex="-1" role="dialog" aria-labelledby="modalMyCartLabel" aria-hidden="true">
        <div class="modal-dialog  modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        ×
                    </button>
                    <h4 class="modal-title ng-binding" id="modalMyCartLabel">Bạn có  sản phẩm trong giỏ hàng.</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="width:100%;">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Tên sản phẩm</th>
                                <th>Số lượng</th>
                                <th>Giá tiền</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- ngRepeat: item in OrderDetails -->
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="total-price-modal">
                                Tổng cộng : <span class="item-total ng-binding">₫</span>
                            </div>
                        </div>
                    </div>
                    <div class="row margin-top-10">
                        <div class="col-lg-6">
                            <div class="comeback text-left">
                                <a href="http://runecom22.runtime.vn/san-pham.html">
                                    <i class="fa fa-chevron-circle-left "></i> Tiếp tục mua hàng
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-6 text-right">
                            <div class="buttons btn-modal-cart">
                                <a class="btn btn-default" href="http://runecom22.runtime.vn/thanh-toan.html">
                                    Đặt hàng
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalCallMe" tabindex="-1" role="dialog" aria-labelledby="modalCallMeLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <h2>Cám ơn Qúy Khách đã liên hệ đặt hàng</h2>
                    <p>Shop sẽ gọi lại để tư vấn cho Quý khách hàng trong thời gian sớm nhất</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">
                        OK
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="product-content clearfix">
    <h1 class="title clearfix"><span>Sản phẩm liên quan</span></h1>
    <div class="product-block product-grid clearfix">
            <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                <div class="product-item product-resize fixheight" style="height: 411px;">
                    <div class="image image-resize" style="height: 221px;">
                        <a href="http://runecom22.runtime.vn/san-pham/ao-cong-so-tay-bup-sang-trong.html" title="Áo Công Sở Tay Búp Sang Trọng">
                            <img src=/storeManagerSystem/view/template_2/chiTiet_files/131767_0_fashion_1.jpg" class="img-responsive">
                        </a>
                            <span class="promotion">-20%</span>
                    </div>
                    <div class="right-block">
                        <h2 class="name">
                            <a href="http://runecom22.runtime.vn/san-pham/ao-cong-so-tay-bup-sang-trong.html" title="Áo Công Sở Tay Búp Sang Trọng">Áo Công Sở Tay Búp Sang Trọng</a>
                        </h2>
                        <div class="ratings clearfix">
                            <div class="rating-box">
                                <div class="rating">
                                </div>
                            </div>
                        </div>
                        <div class="price">
                                <span class="price-new">168.000&nbsp;₫</span>
                                <span class="price-old">210.000&nbsp;₫</span>
                        </div>
                        <div class="addtocart-button clearfix">
                            <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2651,1)"><span></span></a>
                            <a class="add-wishlist" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#"><span></span></a>
                            <a class="add-compare" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#"><span></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                <div class="product-item product-resize fixheight" style="height: 411px;">
                    <div class="image image-resize" style="height: 221px;">
                        <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html" title="Áo Sơ Mi Nữ Công Sở ">
                            <img src=/storeManagerSystem/view/template_2/chiTiet_files/126236_fashion.jpg" class="img-responsive">
                        </a>
                            <span class="promotion">-10%</span>
                    </div>
                    <div class="right-block">
                        <h2 class="name">
                            <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html" title="Áo Sơ Mi Nữ Công Sở ">Áo Sơ Mi Nữ Công Sở </a>
                        </h2>
                        <div class="ratings clearfix">
                            <div class="rating-box">
                                <div class="rating">
                                </div>
                            </div>
                        </div>
                        <div class="price">
                                <span class="price-new">202.500&nbsp;₫</span>
                                <span class="price-old">225.000&nbsp;₫</span>
                        </div>
                        <div class="addtocart-button clearfix">
                            <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2652,1)"><span></span></a>
                            <a class="add-wishlist" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#"><span></span></a>
                            <a class="add-compare" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#"><span></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                <div class="product-item product-resize fixheight" style="height: 411px;">
                    <div class="image image-resize" style="height: 221px;">
                        <a href="http://runecom22.runtime.vn/san-pham/ao-voan-caro-canh-doi.html" title="Áo Voan Caro Cánh Dơi">
                            <img src=/storeManagerSystem/view/template_2/chiTiet_files/124743_0_fashion_1.jpg" class="img-responsive">
                        </a>
                            <span class="promotion">-10%</span>
                    </div>
                    <div class="right-block">
                        <h2 class="name">
                            <a href="http://runecom22.runtime.vn/san-pham/ao-voan-caro-canh-doi.html" title="Áo Voan Caro Cánh Dơi">Áo Voan Caro Cánh Dơi</a>
                        </h2>
                        <div class="ratings clearfix">
                            <div class="rating-box">
                                <div class="rating">
                                </div>
                            </div>
                        </div>
                        <div class="price">
                                <span class="price-new">216.000&nbsp;₫</span>
                                <span class="price-old">240.000&nbsp;₫</span>
                        </div>
                        <div class="addtocart-button clearfix">
                            <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2653,1)"><span></span></a>
                            <a class="add-wishlist" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#"><span></span></a>
                            <a class="add-compare" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#"><span></span></a>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</section>                    </div>
                    <div class="col-md-3">

<script src=/storeManagerSystem/view/template_2/chiTiet_files/moduleServices.js.tải xuống"></script>
<script src=/storeManagerSystem/view/template_2/chiTiet_files/moduleController.js.tải xuống"></script>
    <!--Begin-->
    <div class="box-sale-policy ng-scope" ng-controller="moduleController" ng-init="initSalePolicyController(&#39;Shop&#39;)">
        <h3><span>Chính sách bán hàng</span></h3>
        <div class="sale-policy-block">
            <ul>
                <li>Giao hàng TOÀN QUỐC</li>
                <li>Thanh toán khi nhận hàng</li>
                <li>Đổi trả trong <span>15 ngày</span></li>
                <li>Hoàn ngay tiền mặt</li>
                <li>Chất lượng đảm bảo</li>
                <li>Miễn phí vận chuyển:<span>Đơn hàng từ 3 món trở lên</span></li>
            </ul>
        </div>
        <div class="buy-guide">
            <h3>Hướng Dẫn Mua Hàng</h3>
            <ul>
                <li>
                    Mua hàng trực tiếp tại website
                    <b class="ng-binding"> http://www.runtime.vn</b>
                </li>
                <li>
                    Gọi điện thoại <strong class="ng-binding">
                        0908 77 00 95
                    </strong> để mua hàng
                </li>
                <li>
                    Mua tại Trung tâm CSKH:<br>
                    <strong class="ng-binding">5/12A Quang Trung, P.14, Q.Gò Vấp, Tp.HCM</strong>
                    <a href="http://runecom22.runtime.vn/ban-do.html" rel="nofollow" target="_blank">Xem Bản Đồ</a>
                </li>
                <li>
                    Mua sỉ/buôn xin gọi <strong class="ng-binding">
                        0908 77 00 95
                    </strong> để được
                    hỗ trợ.
                </li>
            </ul>
        </div>
    </div>
    <!--End-->
<script type="text/javascript">
    window.Shop = {"Name":"CÔNG TY TNHH PHÁT TRIỂN CÔNG NGHỆ RUNTIME","Email":"info@runtime.vn","Phone":"(08) 66 85 85 38","Logo":"/storeManagerSystem/view/template_2/chiTiet_files/logo.png","Fax":"(08) 66 85 85 38","Website":"http://www.runtime.vn","Hotline":"0908 77 00 95","Address":"5/12A Quang Trung, P.14, Q.Gò Vấp, Tp.HCM","Fanpage":"https://www.facebook.com/runtime.vn","Google":null,"Facebook":"https://www.facebook.com/runtime.vn","Youtube":null,"Twitter":null,"IsBanner":false,"IsFixed":false,"BannerImage":""};
</script>
<div class="box-product">
    <h3>
        <span>
            Sản phẩm Hot
        </span>
    </h3>
    <div class="box-product-block">
            <div class="item">
                <div class="image">
                    <a href="http://runecom22.runtime.vn/san-pham/ao-cong-so-tay-bup-sang-trong.html" title="Áo Công Sở Tay Búp Sang Trọng">
                        <img class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/131767_0_fashion_1.jpg" alt="Áo Công Sở Tay Búp Sang Trọng" title="Áo Công Sở Tay Búp Sang Trọng">
                    </a>
                </div>
                <div class="name">
                    <a href="http://runecom22.runtime.vn/san-pham/ao-cong-so-tay-bup-sang-trong.html" title="Áo Công Sở Tay Búp Sang Trọng">Áo Công Sở Tay Búp Sang Trọng</a>
                </div>
                <div class="ratings clearfix">
                    <div class="rating-box">
                        <div class="rating">
                        </div>
                    </div>
                </div>
                <div class="price">
                        <span class="price-new">168.000&nbsp;₫</span>
                        <span class="price-old">210.000&nbsp;₫</span>
                </div>
                <div class="addtocart-button clearfix">
                    <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2651,1)">Mua ngay</a>
                </div>
            </div>
            <div class="item">
                <div class="image">
                    <a href="http://runecom22.runtime.vn/san-pham/ao-voan-caro-canh-doi.html" title="Áo Voan Caro Cánh Dơi">
                        <img class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/124743_0_fashion_1.jpg" alt="Áo Voan Caro Cánh Dơi" title="Áo Voan Caro Cánh Dơi">
                    </a>
                </div>
                <div class="name">
                    <a href="http://runecom22.runtime.vn/san-pham/ao-voan-caro-canh-doi.html" title="Áo Voan Caro Cánh Dơi">Áo Voan Caro Cánh Dơi</a>
                </div>
                <div class="ratings clearfix">
                    <div class="rating-box">
                        <div class="rating">
                        </div>
                    </div>
                </div>
                <div class="price">
                        <span class="price-new">216.000&nbsp;₫</span>
                        <span class="price-old">240.000&nbsp;₫</span>
                </div>
                <div class="addtocart-button clearfix">
                    <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2653,1)">Mua ngay</a>
                </div>
            </div>
            <div class="item">
                <div class="image">
                    <a href="http://runecom22.runtime.vn/san-pham/bo-the-thao-co-gian-tot-summer-hot.html" title="Bộ Thể Thao Co Giãn Tốt Summer Hot">
                        <img class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/129725_0_fashion_1.jpg" alt="Bộ Thể Thao Co Giãn Tốt Summer Hot" title="Bộ Thể Thao Co Giãn Tốt Summer Hot">
                    </a>
                </div>
                <div class="name">
                    <a href="http://runecom22.runtime.vn/san-pham/bo-the-thao-co-gian-tot-summer-hot.html" title="Bộ Thể Thao Co Giãn Tốt Summer Hot">Bộ Thể Thao Co Giãn Tốt Summer Hot</a>
                </div>
                <div class="ratings clearfix">
                    <div class="rating-box">
                        <div class="rating">
                        </div>
                    </div>
                </div>
                <div class="price">
                        <span class="price-new">205.200&nbsp;₫</span>
                        <span class="price-old">228.000&nbsp;₫</span>
                </div>
                <div class="addtocart-button clearfix">
                    <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2655,1)">Mua ngay</a>
                </div>
            </div>
            <div class="item">
                <div class="image">
                    <a href="http://runecom22.runtime.vn/san-pham/combo-2-ao-thun-nu-sac-mau-he.html" title="Combo 2 Áo Thun Nữ Sắc Màu Hè">
                        <img class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/130155_fashion.jpg" alt="Combo 2 Áo Thun Nữ Sắc Màu Hè" title="Combo 2 Áo Thun Nữ Sắc Màu Hè">
                    </a>
                </div>
                <div class="name">
                    <a href="http://runecom22.runtime.vn/san-pham/combo-2-ao-thun-nu-sac-mau-he.html" title="Combo 2 Áo Thun Nữ Sắc Màu Hè">Combo 2 Áo Thun Nữ Sắc Màu Hè</a>
                </div>
                <div class="ratings clearfix">
                    <div class="rating-box">
                        <div class="rating">
                        </div>
                    </div>
                </div>
                <div class="price">
                        <span class="price-new">202.500&nbsp;₫</span>
                        <span class="price-old">225.000&nbsp;₫</span>
                </div>
                <div class="addtocart-button clearfix">
                    <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2656,1)">Mua ngay</a>
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

<link href="/storeManagerSystem/view/template_2/chiTiet_files/owl.carousel.css" rel="stylesheet">
<link href="/storeManagerSystem/view/template_2/chiTiet_files/owl.theme.css" rel="stylesheet">
<script src=/storeManagerSystem/view/template_2/chiTiet_files/owl.carousel.min.js.tải xuống"></script>
<script src=/storeManagerSystem/view/template_2/chiTiet_files/moduleServices.js.tải xuống"></script>
<script src=/storeManagerSystem/view/template_2/chiTiet_files/moduleController.js.tải xuống"></script>
    <!--Begin-->
    <div class="partner-content owl-carousel ng-scope" ng-controller="moduleController" ng-init="initPartnerController(&#39;Partners&#39;)">
        <div class="partner-block owl-carousel owl-theme" style="opacity: 1; display: block;">
            <!-- ngRepeat: item in Partners --><div class="owl-wrapper-outer"><div class="owl-wrapper" style="width: 1920px; left: 0px; display: block; transition: all 1000ms ease; transform: translate3d(0px, 0px, 0px);"><div class="owl-item" style="width: 192px;"><div class="partner-item ng-scope" ng-repeat="item in Partners">
                <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html" target="_blank" title="efef">
                    <img ng-src="/storeManagerSystem/view/template_2/chiTiet_files/burbery_2jrem8aiipohl_simg_603cef_226x114_maxb.png" alt="efef" class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/burbery_2jrem8aiipohl_simg_603cef_226x114_maxb.png">
                </a>
            </div></div><div class="owl-item" style="width: 192px;"><div class="partner-item ng-scope" ng-repeat="item in Partners">
                <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#" target="_blank" title="dsfdsf">
                    <img ng-src="/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1l1rsnb045m_simg_603cef_226x114_maxb.jpg" alt="dsfdsf" class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1l1rsnb045m_simg_603cef_226x114_maxb.jpg">
                </a>
            </div></div><div class="owl-item" style="width: 192px;"><div class="partner-item ng-scope" ng-repeat="item in Partners">
                <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#" target="_blank" title="fsdf">
                    <img ng-src="/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1l5tedglnk9_simg_603cef_226x114_maxb.jpg" alt="fsdf" class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1l5tedglnk9_simg_603cef_226x114_maxb.jpg">
                </a>
            </div></div><div class="owl-item" style="width: 192px;"><div class="partner-item ng-scope" ng-repeat="item in Partners">
                <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#" target="_blank" title="ddsf">
                    <img ng-src="/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1m8k9aglr85_simg_603cef_226x114_maxb.jpg" alt="ddsf" class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1m8k9aglr85_simg_603cef_226x114_maxb.jpg">
                </a>
            </div></div><div class="owl-item" style="width: 192px;"><div class="partner-item ng-scope" ng-repeat="item in Partners">
                <a href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#" target="_blank" title="sfddf">
                    <img ng-src="/storeManagerSystem/view/template_2/chiTiet_files/logo__2k2dp8si78411_simg_603cef_226x114_maxb.jpg" alt="sfddf" class="img-responsive" src=/storeManagerSystem/view/template_2/chiTiet_files/logo__2k2dp8si78411_simg_603cef_226x114_maxb.jpg">
                </a>
            </div></div></div></div><!-- end ngRepeat: item in Partners --><!-- end ngRepeat: item in Partners --><!-- end ngRepeat: item in Partners --><!-- end ngRepeat: item in Partners --><!-- end ngRepeat: item in Partners -->
        </div>
        <div class="controls boxprevnext">
            <a class="prev prevlogo"><i class="fa fa-angle-left"></i></a>
            <a class="next nextlogo"><i class="fa fa-angle-right"></i></a>
        </div>
    </div>
    <script type="text/javascript">
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
    </script>
    <!--End-->
<script type="text/javascript">
    window.Partners = [{"Id":171,"ShopId":139,"Name":"efef","Link":null,"Logo":"/storeManagerSystem/view/template_2/chiTiet_files/burbery_2jrem8aiipohl_simg_603cef_226x114_maxb.png","Index":1,"Inactive":false},{"Id":172,"ShopId":139,"Name":"dsfdsf","Link":"#","Logo":"/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1l1rsnb045m_simg_603cef_226x114_maxb.jpg","Index":2,"Inactive":false},{"Id":173,"ShopId":139,"Name":"fsdf","Link":"#","Logo":"/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1l5tedglnk9_simg_603cef_226x114_maxb.jpg","Index":3,"Inactive":false},{"Id":174,"ShopId":139,"Name":"ddsf","Link":"#","Logo":"/storeManagerSystem/view/template_2/chiTiet_files/logo__2k1m8k9aglr85_simg_603cef_226x114_maxb.jpg","Index":4,"Inactive":false},{"Id":175,"ShopId":139,"Name":"sfddf","Link":"#","Logo":"/storeManagerSystem/view/template_2/chiTiet_files/logo__2k2dp8si78411_simg_603cef_226x114_maxb.jpg","Index":5,"Inactive":false}];
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
                        Giới thiệu
                    </h3>
                </div>
                <ul>
                        <li>
                            <a href="http://runecom22.runtime.vn/gioi-thieu.html">
                                Về chúng tôi
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/gioi-thieu.html">
                                Lĩnh vực hoạt động
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/hoi-dap.html">
                                Hỏi đáp
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/quy-che-hoat-dong.html">
                                Quy chế hoạt động
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/tuyen-dung.html">
                                Tuyển dũng
                            </a>
                        </li>
                </ul>
            </div>
            <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Trợ giúp
                    </h3>
                </div>
                <ul>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/huong-dan-thanh-toan.html">
                                Hướng dẫn thanh toán
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/quy-dinh-doi-tra.html">
                                Quy định đổi trả
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/chinh-sach-ban-hang.html">
                                Chính sách bán hàng
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/chinh-sach-bao-mat.html">
                                Chính sách bảo mật
                            </a>
                        </li>
                        <li>
                            <a href="http://runecom22.runtime.vn/content/quy-dinh-thao-luan.html">
                                Quy định thảo luận
                            </a>
                        </li>
                </ul>
            </div>
                <div class="footer-box box-address col-md-3 col-sm-12 col-xs-12">
                    <div class="item">
                        <h3>
                            Thông tin công ty
                        </h3>
                        <div class="box-address-content">
                            <b>CÔNG TY TNHH PHÁT TRIỂN CÔNG NGHỆ RUNTIME</b>
                            <p><i class="fa fa-map-marker"></i> 5/12A Quang Trung, P.14, Q.Gò Vấp, Tp.HCM</p>
                            <p>
                                <i class="fa fa-envelope"></i>
                                <a href="mailto:info@runtime.vn">info@runtime.vn</a>
                            </p>
                            <p>
                                <i class="fa fa-phone"></i>
                                Phone: (08) 66 85 85 38
                            </p>
                        </div>
                    </div>
                </div>
                <div class="footer-box box-social col-md-3 col-sm-12 col-xs-12">
                    <div class="item">
                        <h3>
                            Facebook
                        </h3>
                        <div class="fb-like-box fb_iframe_widget" data-href="https://www.facebook.com/runtime.vn" data-width="289" data-height="190" data-colorscheme="dark" data-show-faces="true" data-header="false" data-stream="false" data-show-border="false" fb-xfbml-state="rendered" fb-iframe-plugin-query="app_id=227481454296289&amp;color_scheme=dark&amp;container_width=272&amp;header=false&amp;height=190&amp;href=https%3A%2F%2Fwww.facebook.com%2Fruntime.vn&amp;locale=en_US&amp;sdk=joey&amp;show_border=false&amp;show_faces=true&amp;stream=false&amp;width=289"><span style="vertical-align: bottom; width: 0px; height: 0px;"><iframe name="f7ccb7539e9c9c" width="289px" height="190px" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" title="fb:like_box Facebook Social Plugin" src=/storeManagerSystem/view/template_2/chiTiet_files/like_box.html" style="border: none; visibility: visible; width: 0px; height: 0px;" class=""></iframe></span></div>
                        <div class="social-icon">
                            <ul>
                                <li><a target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="https://www.facebook.com/runtime.vn" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a target="_blank"><i class="fa fa-youtube"></i></a></li>
                                <li><a target="_blank"><i class="fa fa-twitter "></i></a></li>
                            </ul>
                        </div>
                    </div>

                </div>
                <div class="footer-box box-letter col-md-3 col-sm-12 col-xs-12 hide">
                    <div class="item">
                        <h3>
                            Đăng ký nhận tin
                        </h3>
                        <div class="letter-title">
                            <span>Hộp thư</span><i class="icon-title"></i>
                        </div>
                        <div class="letter-content">
                            <div class="new-paper">
                                <div class="input-box">
                                    <input type="text" name="email" id="txtNewsletter" class="input-text form-control" value="" placeholder="Your Emain Address">
                                </div>
                                <div class="button text-center">
                                    <a class="btn btn-primary">Nhận tin</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    $(document).ready(function () {
        $("#btnNewsletter").click(function () {
            Newsletter();
        });
    });
    function Newsletter() {
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        var email = $('#txtNewsletter').val();
        if (email == "") {
            $('#txtNewsletter').focus();
            return;
        }
        if (!emailReg.test(email)) {
            alert("Email không hợp lệ.");
            $('#txtNewsletter').focus();
            return;
        }

        $.ajax({
            url: '/Module/Newsletter',
            type: 'POST',
            data: JSON.stringify({ 'email': email }),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                if (data.Result == "OK") {
                    $('#txtNewsletter').val('');
                    alert("Cảm ơn bạn đã đăng ký nhận thông tin khuyến mãi từ chúng tôi.");
                }
                else
                    alert(data.Message);
            },
            error: function (data, errorThrown) {
                alert("Error: " + errorThrown);
            },
            beforeSend: function () {
                $("#loading-mask").show();
            }, complete: function () {
                $("#loading-mask").hide();
            }
        });
    }
    </script>
<!--Template--
<div class="footer-content clearfix" ng-controller="moduleController" ng-init="initFooterController('Shop')">
    <div class="container">
        <div class="row">
            <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Giới thiệu
                    </h3>
                </div>
                <ul>
                    <li>
                        <a href="/gioi-thieu.html">
                            Về chúng tôi
                        </a>
                    </li>
                    <li>
                        <a href="/gioi-thieu.html">
                            Lĩnh vực hoạt động
                        </a>
                    </li>
                    <li>
                        <a href="/content/hoi-dap.html">
                            Hỏi đáp
                        </a>
                    </li>
                    <li>
                        <a href="/content/quy-che-hoat-dong.html">
                            Quy chế hoạt động
                        </a>
                    </li>
                    <li>
                        <a href="/content/tuyen-dung.html">
                            Tuyển dũng
                        </a>
                    </li>
                </ul>
            </div>
            <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Trợ giúp
                    </h3>
                </div>
                <ul>
                    <li>
                        <a href="/content/huong-dan-thanh-toan.html">
                            Hướng dẫn thanh toán
                        </a>
                    </li>
                    <li>
                        <a href="/content/quy-dinh-doi-tra.html">
                            Quy định đổi trả
                        </a>
                    </li>
                    <li>
                        <a href="/content/chinh-sach-ban-hang.html">
                            Chính sách bán hàng
                        </a>
                    </li>
                    <li>
                        <a href="/content/chinh-sach-bao-mat.html">
                            Chính sách bảo mật
                        </a>
                    </li>
                    <li>
                        <a href="/content/quy-dinh-thao-luan.html">
                            Quy định thảo luận
                        </a>
                    </li>
                </ul>
            </div>
            <div class="footer-box box-address col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Thông tin công ty
                    </h3>
                    <div class="box-address-content">
                        <b>{{shop.Name}}</b>
                        <p><i class="fa fa-map-marker"></i> {{shop.Address}}</p>
                        <p>
                            <i class="fa fa-envelope"></i>
                            <a href="mailto:{{shop.Email}}">{{shop.Email}}</a>
                        </p>
                        <p>
                            <i class="fa fa-phone"></i>
                            Phone: {{shop.Phone}}
                        </p>
                    </div>
                </div>
            </div>
            <div class="footer-box box-social col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Facebook
                    </h3>
                    <div data-show-border="false" data-stream="false" data-header="false" data-show-faces="true" data-colorscheme="dark" data-height="190" data-width="289" data-href="{{shop.Fanpage}}" class="fb-like-box">
                    </div>
                    <div class="social-icon">
                        <ul>
                            <li><a href="{{shop.Google}}"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="{{shop.Facebook}}"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="{{shop.Youtube}}"><i class="fa fa-youtube"></i></a></li>
                            <li><a href="{{shop.Twitter}}"><i class="fa fa-twitter "></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-bottom clearfix">
        <div class="container">
            <div class="row">
                &copy; 2015 RUNTIME Store. All Rights Reserved. Designed by <a target="_blank" href="http://www.runtime.vn">RUNTIME.VN</a>
            </div>
        </div>
    </div>
</div>
--End-->
        </div>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".menu-quick-select ul").hide();
            $(".menu-quick-select").hover(function () { $(".menu-quick-select ul").show(); }, function () { $(".menu-quick-select ul").hide(); });
        });
    </script>
</div><div id="_atssh" style="visibility: hidden; height: 1px; width: 1px; position: absolute; top: -9999px; z-index: 100000;"><iframe id="_atssh430" title="AddThis utility frame" style="height: 1px; width: 1px; position: absolute; top: 0px; z-index: 100000; border: 0px; left: 0px;" src=/storeManagerSystem/view/template_2/chiTiet_files/sh.92bb263c60d77a822f41d4b0.html"></iframe></div><style id="service-icons-0"></style>

    
    <div style="display: none;" id="loading-mask">
        <div id="loading_mask_loader" class="loader">
            <img alt="Loading..." src=/storeManagerSystem/view/template_2/chiTiet_files/ajax-loader-main.gif">
            <div>
                Please wait...
            </div>
        </div>
    </div>
    <a class="back-to-top" href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html#" style="display: none;">
        <i class="fa fa-angle-up">
        </i>
    </a>
    
    


<script type="text/javascript">
    $(".header-content").css({ "background": '' });
    $("html").addClass('');
    $(document).ready(function () {
        $("img.lazy-img").each(function () {
            //$(this).attr("data-original", $(this).attr("src"));
            //$(this).attr("src", "/Images/blank.gif");
        });
        $("img.lazy-img").lazyload({
            effect: "fadeIn",
            threshold: 200
        });
    });
</script>

<iframe name="oauth2relay286481152" id="oauth2relay286481152" src=/storeManagerSystem/view/template_2/chiTiet_files/postmessageRelay.html" tabindex="-1" aria-hidden="true" style="width: 1px; height: 1px; position: absolute; top: -100px;"></iframe></body></html>