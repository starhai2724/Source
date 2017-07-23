<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <title>Thời trang cao cấp</title>
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
<!--     <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/app/directives/paging.js"></script> -->
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
        height:40px;
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
        display:block;
    }
    #menu li:hover #sub{
        visibility:visible;
        }
    #menu li:hover a {
        background-color:rgba(51,0,0,0.5);
    }
    #menu li:hover #sub li a{
        background-color:#42a8bf;
    }
    #menu li #sub li:hover a{
        background-color:#1a525e;
                height:40px;
    }
</style>
</head>
<body  style="" ng-app="LayoutForm" ng-controller="ctrl">
<form:form id="LayoutForm" modelAttribute="LayoutForm" role="form" method="GET" >
<input type="hidden" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" >
        <div id="fb-root"></div>
<div class="wrapper page-home">
        <div class="header">
    <section class="top-link clearfix">
        <div class="container" style="width: 1370px">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav navbar-nav topmenu-contact">
                        <li><i class="fa fa-phone"></i>Hotline: ${LayoutForm.soDienThoai}</li>
                    </ul>
                        <ul class="nav navbar-nav navbar-right topmenu  hidden-xs hidden-sm">
                            <li class="hotline"><a href="#"><i class="fa fa-phone"></i>Hotline: ${LayoutForm.soDienThoai}</a></li>
                            <li class="order-cart"><a href="gio-hang.html"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                            <li class="account-login"><a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangNhap"></i>Đăng nhập </a></li>
                            <li class="account-register"><a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangkitaikhoan"><i class="fa fa-key"></i>Đăng ký </a></li>
                        </ul>
                    <div class="show-mobile hidden-lg hidden-md">
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
                                        <a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangNhap"><i class="fa fa-key"></i> Đăng nhập</a>
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
                                    <li><a href="javascript:void(0)" ng-click="btnCart();" class="shoppingcart"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                                    <span style="color: red" class="simpleCart_empty">${LayoutForm.tenKhachHang}> </span>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
        <section class="header-content clearfix">
            <div class="container" style="width: 1370px">
                <div class="row">
                    <div class="col-md-3 col-xs-12 col-sm-12 header-left text-center">
                        <div class="logo">
                            <a href="/storeManagerSystem/${LayoutForm.pathJSP }" title="">
                                <img alt="" src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Uploads/shop139/images/Product/logo.png" class="img-responsive" />
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
                                    <input type="text" path="timKiem_TenSP"  name="timKiem_TenSP" ng-model = "timKiem_TenSP"  ng-init ="timKiem_TenSP = '${LayoutForm.timKiem_TenSP}'" onblur="if(this.value=='')this.value='Tìm kiếm...'"
                                           onfocus="if(this.value=='Tìm kiếm...')this.value=''" value="T&#236;m kiếm..." />
                                    <!-- <div class="select-categories">
                                        <select name="lbgroup" id="lbgroup">
                                            <option value="0" selected="selected">Tất cả</option>
                                            <option class="option-1" value="3114">Thời trang nữ</option>
                                            <option class="option-1" value="3119">Thời trang nam</option>
                                            <option class="option-1" value="3125">Phụ kiện</option>
                                            <option class="option-1" value="3126">Thời trang trẻ em</option>
                                        </select>
                                    </div> -->
                                </div>
                                <button class="btn btn-search" title="Search" type="button" ng-click ="btnTimKiem()" value="Tìm kiếm">
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
                window.location = 'tim-kiem7c8e.html?group=' + group + '&key=' + key;
            }
        </script>
<section class="navigation-menu clearfix">
    <div class="container" style="width: 1370px">
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
                        <div id="wrap">
                            <ul id="menu">
                            	<li><a style="padding-top: 18px" href="/storeManagerSystem/${LayoutForm.pathJSP }"><span style="font-size: 14px">Trang chủ</span></a></li>
								<li><a style="padding-top: 18px" href='gioi-thieu.html'><span style="font-size: 14px">Giới thiệu</span></a></li>
								<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
							        <li>
							            <a style="padding-top: 18px" href="#" data-toggle="dropdown"><span style="font-size: 14px">${items.nameProductCategory }</span> <b class="caret"></b></a>
							            <c:if test="${!empty items.menuRowForms }">
								            <ul id="sub">
											            <c:forEach var="menus" items="${items.menuRowForms }">
											            			<li><a style="font-size: 14px" href="#"><span style="font-size: 14px">${menus.tenLoaiSp }</span></a></li>
											            </c:forEach>
								            </ul>
							            </c:if>
							        </li>
						        </c:forEach>
								<li> <a style="padding-top: 18px" href='tin-tuc.html'><span style="font-size: 14px">Tin tức</span></a></li>
								<li><a style="padding-top: 18px" href='lien-he.html'><span style="font-size: 14px">Liên hệ</span></a></li>
							</ul>
						</div>
                        </nav>
                        <div class="cart pull-right">
                            <a href="javascript:void(0);">
                                <i ng-click="btnCart();" class="fa fa-shopping-cart"></i>Giỏ hàng <span ng-model = "cartPrice">{{cartPrice | number}} VNĐ(<span ng-model = "cartQuantity"  >{{cartQuantity}}</span>)</span>
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
        <div class="slideshow">
                <div class="col-md-12">
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/flexSlider/flexslider.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript">
    window.Slideshows = [{"Id":628,"ShopId":139,"Name":"ffdgf","Image":"/Uploads/shop139/images/slide/slide1.jpg","Link":"#","Index":1,"Inactive":false,"Timestamp":"AAAAAAASFgg="},{"Id":629,"ShopId":139,"Name":"dfg","Image":"/Uploads/shop139/images/slide/slide2.jpg","Link":"#","Index":2,"Inactive":false,"Timestamp":"AAAAAAASFuI="},{"Id":630,"ShopId":139,"Name":"fgh","Image":"/Uploads/shop139/images/slide/slide3.jpg","Link":"#","Index":3,"Inactive":false,"Timestamp":"AAAAAAASFuM="},{"Id":631,"ShopId":139,"Name":"Zaa","Image":"/Uploads/shop139/images/slide/slide5.jpg","Link":"#","Index":4,"Inactive":false,"Timestamp":"AAAAAAASFuQ="}];
</script>  -->      </div>
        </div>
            <div class="adv">
                <div class="container" style="width: 1370px">
                    <div class="row">
                        <div class="col-md-12">
    <!--Begin-->
    <script type="text/javascript">
    </script>
    <!--End-->
<!-- <script type="text/javascript">
    window.AdvSlides = [{"Id":295,"ShopId":139,"AdvType":2,"AdvTypeName":"Chạy ngang","Name":"fdfdsf","Image":"/Uploads/shop139/images/Product/banner1.png","ImageThumbnai":"/Uploads/shop139/_thumbs/images/Product/banner1.png","Link":"#","IsVideo":false,"Index":1,"Inactive":false,"Timestamp":"AAAAAAASFgk="},{"Id":296,"ShopId":139,"AdvType":2,"AdvTypeName":"Chạy ngang","Name":"fgfg","Image":"/Uploads/shop139/images/Product/banner2.png","ImageThumbnai":"/Uploads/shop139/_thumbs/images/Product/banner2.png","Link":"#","IsVideo":false,"Index":2,"Inactive":false,"Timestamp":"AAAAAAASFgo="},{"Id":297,"ShopId":139,"AdvType":2,"AdvTypeName":"Chạy ngang","Name":"fbhfgh","Image":"/Uploads/shop139/images/Product/EOS-5D-MarkIII.jpg","ImageThumbnai":"/Uploads/shop139/_thumbs/images/Product/EOS-5D-MarkIII.jpg","Link":"#","IsVideo":false,"Index":3,"Inactive":false,"Timestamp":"AAAAAAASFgs="}];
</script> -->               </div>
                    </div>
                </div>
            </div>
    <div class="main">
        <div class="container" style="width: 1370px">
            <div class="row">
                    <div class="col-md-12">
    <section class="product-content clearfix">
        <h1 class="title clearfix"><span>Sản phẩm</span></h1>
        <nav class="navbar navbar-default product-filter">
            <ul class="display">
                <li id="grid" class="active grid"><a href="#" title="Grid"><i class="fa fa-th-large"></i></a></li>
                <li id="list" class="list"><a href="#" title="List"><i class="fa fa-th-list"></i></a></li>
            </ul>
            <div class="limit">
                <span>Sản phẩm/trang</span>
               <!--  <select id="lblimit" name="lblimit" class="nb_item" onchange="window.location.href = this.options[this.selectedIndex].value">
                            <option value="?limit=10">10</option>
                            <option selected="selected" value="?limit=12">12</option>
                            <option value="?limit=20">20</option>
                            <option value="?limit=50">50</option>
                            <option value="?limit=100">100</option>
                            <option value="?limit=250">250</option>
                            <option value="?limit=500">500</option>
                </select> -->
            </div>
            <div class="sort">
                <span>Sắp xếp</span>
                <!-- <select class="selectProductSort" id="lbsort" onchange="window.location.href = this.options[this.selectedIndex].value">
                            <option selected="selected" value="?sort=index&amp;order=asc">Mặc định</option>
                            <option value="?sort=price&amp;order=asc">Gi&#225; tăng dần</option>
                            <option value="?sort=price&amp;order=desc">Gi&#225; giảm dần</option>
                            <option value="?sort=name&amp;order=asc">T&#234;n sản phẩm: A to Z</option>
                            <option value="?sort=name&amp;order=desc">T&#234;n sản phẩm: Z to A</option>
                </select> -->
            </div>
        </nav>
        <!-- San pham (S)  -->
        <div class="product-block product-grid clearfix row">
        <c:forEach var="items" items="${LayoutForm.products }">
                <div class="col-md-3 col-sm-3 col-xs-14 product-item-box">
                    <div class="product-item product-resize fixheight" style="height: 400px;">
                        <div class="image image-resize" style="height: 300px;">
                            <a href="javascript:void(0);" title="${items.tenSP}">
                                <img style="width: 300px" class="img-responsive" src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}" class="img-responsive" />
                            </a>
                                <!-- <span class="promotion">-20%</span> -->
                        </div>
                        <div class="right-block">
                            <h2 class="name">
                                <a href="javascript:void(0);" title="${items.tenSP}">${items.tenSP}</a>
                            </h2>
                            <div class="ratings clearfix">
                                <div class="rating-box">
                                    <div class="rating">
                                    </div>
                                </div>
                            </div>
                            <div class="price">
                                    <!-- <span class="price-new">168.000&nbsp;₫</span>
                                    <span class="price-old">210.000&nbsp;₫</span> -->
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
                                <a class="add-to-cart" href="javascript:void(0);" ng-click="btnPurchase('${items.giaBan}','${items.giaBanKM }' ,'${items.SEQ} ')"><span></span></a>
                                <!-- <a class="add-wishlist" href="#"><span></span></a>
                                <a class="add-compare" href="#"><span></span></a> -->
                            </div>
                        </div>
                    </div>
                </div>
        </c:forEach> 
                <!-- San pham (E)  -->        
        </div>
           <!--  <div class="navigation">
                <ul class="pagination">
                    <li>
                        <a href="trang-chu2679.html?page=1" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                            <li class="active"><a href="trang-chu2679.html?page=1">1</a></li>
                            <li><a href="trang-chu4658.html?page=2">2</a></li>
                            <li><a href="trang-chu9ba9.html?page=3">3</a></li>
                    <li>
                        <a href="trang-chu9ba9.html?page=3" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </div> -->
    </section>
                    </div>
            </div>
        </div>
    </div>
            <div class="partner">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
<!-- <script type="text/javascript">
    window.Partners = [{"Id":171,"ShopId":139,"Name":"efef","Link":null,"Logo":"/Uploads/shop139/images/Product/burbery_2jrem8aiipohl_simg_603cef_226x114_maxb.png","Index":1,"Inactive":false},{"Id":172,"ShopId":139,"Name":"dsfdsf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k1l1rsnb045m_simg_603cef_226x114_maxb.jpg","Index":2,"Inactive":false},{"Id":173,"ShopId":139,"Name":"fsdf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k1l5tedglnk9_simg_603cef_226x114_maxb.jpg","Index":3,"Inactive":false},{"Id":174,"ShopId":139,"Name":"ddsf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k1m8k9aglr85_simg_603cef_226x114_maxb.jpg","Index":4,"Inactive":false},{"Id":175,"ShopId":139,"Name":"sfddf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k2dp8si78411_simg_603cef_226x114_maxb.jpg","Index":5,"Inactive":false}];
</script> -->                        
						</div>
                    </div>
                </div>
            </div>
        <div class="footer">
    <div class="footer-content clearfix">
        <div class="container" >
            <div class="row">
            <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Giới thiệu
                    </h3>
                </div>
                <ul>
                        <li>
                            <a href="gioi-thieu.html">
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
            <div class="footer-box col-md-3 col-sm-12 col-xs-12">
                <div class="item">
                    <h3>
                        Trợ gi&#250;p
                    </h3>
                </div>
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
                <div class="footer-box box-address col-md-3 col-sm-12 col-xs-12">
                    <div class="item">
                        <h3>
                            Thông tin cửa hàng
                        </h3>
                        <div class="box-address-content">
                            <b>${LayoutForm.tenCuaHang}</b>
                            <p><i class="fa fa-map-marker"></i> ${LayoutForm.diaChi}</p>
                            <p>
                                <i class="fa fa-phone"></i>
                                Số điện thoại: ${LayoutForm.soDienThoai}
                            </p>
                        </div>
                    </div>
                </div>
                <div class="footer-box box-social col-md-3 col-sm-12 col-xs-12">
                    <div class="item">
                        <h3>
                            Facebook
                        </h3>
                        <div class="fb-like-box" data-href="https://www.facebook.com/runtime.vn" data-width="289"
                             data-height="190" data-colorscheme="dark" data-show-faces="true" data-header="false"
                             data-stream="false" data-show-border="false">
                        </div>
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
                                    <input type="text" name="email" id="txtNewsletter" class="input-text form-control" value="" placeholder="Your Emain Address" />
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
        </div>
</div>
    <a class="back-to-top" href="#" style="display: inline;">
        <i class="fa fa-angle-up">
        </i>
    </a>
</form:form>    
</body>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</html>

