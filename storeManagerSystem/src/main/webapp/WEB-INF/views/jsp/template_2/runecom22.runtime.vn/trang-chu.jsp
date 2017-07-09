
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ page contentType="text/html; charset=UTF-8"%>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta charset="UTF-8" />
    <title>RUNECOM22</title>
    <meta content="RUNECOM22" name="description" />
    <meta content="" name="keywords" />
    <link rel="shortcut icon" type="image/x-icon" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta property="fb:app_id" content="227481454296289" />

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

    <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/angularJS/angular.min.js"></script>
    
<!--     <script src="/storeManagerSystem/view/template_2/runecom22.runtime.vn/app/directives/paging.js"></script> -->
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/../static.runtime.vn/App_Themes/RUN022/style.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/../static.runtime.vn/App_Themes/RUN022/responsive.css" rel="stylesheet" type="text/css" />

</head>
<body  style="">
        <div id="fb-root"></div>
<div class="wrapper page-home">
        <div class="header">
    <section class="top-link clearfix">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <ul class="nav navbar-nav topmenu-contact">
                        <li><i class="fa fa-phone"></i>Hotline:0908 77 00 95</li>
                    </ul>
                        <ul class="nav navbar-nav navbar-right topmenu  hidden-xs hidden-sm">
                            <li class="hotline"><a href="#"><i class="fa fa-phone"></i>Hotline:0908 77 00 95</a></li>
                            <li class="order-check"><a href="kiem-tra-don-hang.html"><i class="fa fa-pencil-square-o"></i>Kiểm tra đơn hàng</a></li>
                            <li class="order-cart"><a href="gio-hang.html"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                            <li class="account-login"><a href="dang-nhap.html"><i class="fa fa-sign-in"></i>Đăng nhập </a></li>
                            <li class="account-register"><a href="dang-ky.html"><i class="fa fa-key"></i>Đăng ký </a></li>
                        </ul>
                    <div class="show-mobile hidden-lg hidden-md">
                        <div class="quick-user">
                            <div class="quickaccess-toggle">
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="inner-toggle">
                                <ul class="login links">
                                    <li>
                                        <a href="dang-ky.html"><i class="fa fa-sign-in"></i> Đăng ký</a>
                                    </li>
                                    <li>
                                        <a href="dang-nhap.html"><i class="fa fa-key"></i>Đăng nhập</a>
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
                                    <li><a id="mobile-wishlist-total" href="kiem-tra-don-hang.html" class="wishlist"><i class="fa fa-pencil-square-o"></i>Kiểm tra đơn hàng</a></li>
                                    <li><a href="gio-hang.html" class="shoppingcart"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
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
                            <a href="index.html" title="">
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
                                    <input type="text" name="search" id="txtsearch" onblur="if(this.value=='')this.value='Tìm kiếm...'"
                                           onfocus="if(this.value=='Tìm kiếm...')this.value=''" value="T&#236;m kiếm..." />
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
                window.location = 'tim-kiem7c8e.html?group=' + group + '&key=' + key;
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
                            <ul class='menu nav navbar-nav'><li class="level0"><a class='' href='trang-chu.html'><span>Trang chủ</span></a></li>
								<li class="level0"><a class='' href='gioi-thieu.html'><span>Giới thiệu</span></a></li>
								<li class="level0"><a class='' href='san-pham.html'><span>Sản phẩm</span></a></li>
								<li class="level0"><a class='' href='tin-tuc.html'><span>Tin tức</span></a></li>
								<li class="level0"><a class='' href='lien-he.html'><span>Liên hệ</span></a></li>
							</ul class='menu nav navbar-nav'>
                        </nav>
                        <div class="cart pull-right">
                            <a href="gio-hang.html">
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
        <div class="slideshow">
                <div class="col-md-12">
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/Scripts/flexSlider/flexslider.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
//         $(document).ready(function () {
//             $('#bannerheaderhome').flexslider({
//                 directionNav: true,
//                 controlNav: false,
//                 animation: "slide",
//                 itemHeigh: 270,
//                 itemMargin: 0,
//                 animationSpeed: 700,
//                 slideshowSpeed: 3000
//             });
//         });
    </script>
<script type="text/javascript">
    window.Slideshows = [{"Id":628,"ShopId":139,"Name":"ffdgf","Image":"/Uploads/shop139/images/slide/slide1.jpg","Link":"#","Index":1,"Inactive":false,"Timestamp":"AAAAAAASFgg="},{"Id":629,"ShopId":139,"Name":"dfg","Image":"/Uploads/shop139/images/slide/slide2.jpg","Link":"#","Index":2,"Inactive":false,"Timestamp":"AAAAAAASFuI="},{"Id":630,"ShopId":139,"Name":"fgh","Image":"/Uploads/shop139/images/slide/slide3.jpg","Link":"#","Index":3,"Inactive":false,"Timestamp":"AAAAAAASFuM="},{"Id":631,"ShopId":139,"Name":"Zaa","Image":"/Uploads/shop139/images/slide/slide5.jpg","Link":"#","Index":4,"Inactive":false,"Timestamp":"AAAAAAASFuQ="}];
</script>                </div>
        </div>

    
            <div class="adv">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">

    <!--Begin-->
    <script type="text/javascript">
//         $(document).ready(function () {
//             var owladv = $(".adv-content ul");
//             owladv.owlCarousel({
//                 autoPlay: true,
//                 autoPlay: 5000,
//                 items: 3,
//                 slideSpeed: 1000,
//                 pagination: false,
//                 itemsDesktop: [1200, 3],
//                 itemsDesktopSmall: [980, 3],
//                 itemsTablet: [767, 1],
//                 itemsMobile: [480, 1]
//             });
//         });
    </script>
    <!--End-->
<script type="text/javascript">
    window.AdvSlides = [{"Id":295,"ShopId":139,"AdvType":2,"AdvTypeName":"Chạy ngang","Name":"fdfdsf","Image":"/Uploads/shop139/images/Product/banner1.png","ImageThumbnai":"/Uploads/shop139/_thumbs/images/Product/banner1.png","Link":"#","IsVideo":false,"Index":1,"Inactive":false,"Timestamp":"AAAAAAASFgk="},{"Id":296,"ShopId":139,"AdvType":2,"AdvTypeName":"Chạy ngang","Name":"fgfg","Image":"/Uploads/shop139/images/Product/banner2.png","ImageThumbnai":"/Uploads/shop139/_thumbs/images/Product/banner2.png","Link":"#","IsVideo":false,"Index":2,"Inactive":false,"Timestamp":"AAAAAAASFgo="},{"Id":297,"ShopId":139,"AdvType":2,"AdvTypeName":"Chạy ngang","Name":"fbhfgh","Image":"/Uploads/shop139/images/Product/EOS-5D-MarkIII.jpg","ImageThumbnai":"/Uploads/shop139/_thumbs/images/Product/EOS-5D-MarkIII.jpg","Link":"#","IsVideo":false,"Index":3,"Inactive":false,"Timestamp":"AAAAAAASFgs="}];
</script>                        </div>
                    </div>
                </div>
            </div>

    
    <div class="main">
        <div class="container">
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
                <select id="lblimit" name="lblimit" class="nb_item" onchange="window.location.href = this.options[this.selectedIndex].value">
                            <option value="?limit=10">10</option>
                            <option selected="selected" value="?limit=12">12</option>
                            <option value="?limit=20">20</option>
                            <option value="?limit=50">50</option>
                            <option value="?limit=100">100</option>
                            <option value="?limit=250">250</option>
                            <option value="?limit=500">500</option>
                </select>
            </div>
            <div class="sort">
                <span>Sắp xếp</span>
                <select class="selectProductSort" id="lbsort" onchange="window.location.href = this.options[this.selectedIndex].value">
                            <option selected="selected" value="?sort=index&amp;order=asc">Mặc định</option>
                            <option value="?sort=price&amp;order=asc">Gi&#225; tăng dần</option>
                            <option value="?sort=price&amp;order=desc">Gi&#225; giảm dần</option>
                            <option value="?sort=name&amp;order=asc">T&#234;n sản phẩm: A to Z</option>
                            <option value="?sort=name&amp;order=desc">T&#234;n sản phẩm: Z to A</option>
                </select>
            </div>
        </nav>
        <div class="product-block product-grid clearfix row">
                <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                    <div class="product-item product-resize">
                        <div class="image image-resize">
                            <a href="san-pham/ao-cong-so-tay-bup-sang-trong.html" title="&#193;o C&#244;ng Sở Tay B&#250;p Sang Trọng">
                                <img src="Uploads/shop139/images/Product/131767_0_fashion_1.jpg" class="img-responsive" />
                            </a>
                                <span class="promotion">-20%</span>
                        </div>
                        <div class="right-block">
                            <h2 class="name">
                                <a href="san-pham/ao-cong-so-tay-bup-sang-trong.html" title="&#193;o C&#244;ng Sở Tay B&#250;p Sang Trọng">&#193;o C&#244;ng Sở Tay B&#250;p Sang Trọng</a>
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
                                <a class="add-wishlist" href="#"><span></span></a>
                                <a class="add-compare" href="#"><span></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                    <div class="product-item product-resize">
                        <div class="image image-resize">
                            <a href="san-pham/ao-so-mi-nu-cong-so.html" title="&#193;o Sơ Mi Nữ C&#244;ng Sở ">
                                <img src="Uploads/shop139/images/Product/126236_fashion.jpg" class="img-responsive" />
                            </a>
                                <span class="promotion">-10%</span>
                        </div>
                        <div class="right-block">
                            <h2 class="name">
                                <a href="san-pham/ao-so-mi-nu-cong-so.html" title="&#193;o Sơ Mi Nữ C&#244;ng Sở ">&#193;o Sơ Mi Nữ C&#244;ng Sở </a>
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
                                <a class="add-wishlist" href="#"><span></span></a>
                                <a class="add-compare" href="#"><span></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                    <div class="product-item product-resize">
                        <div class="image image-resize">
                            <a href="san-pham/ao-voan-caro-canh-doi.html" title="&#193;o Voan Caro C&#225;nh Dơi">
                                <img src="Uploads/shop139/images/Product/124743_0_fashion_1.jpg" class="img-responsive" />
                            </a>
                                <span class="promotion">-10%</span>
                        </div>
                        <div class="right-block">
                            <h2 class="name">
                                <a href="san-pham/ao-voan-caro-canh-doi.html" title="&#193;o Voan Caro C&#225;nh Dơi">&#193;o Voan Caro C&#225;nh Dơi</a>
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
                                <a class="add-wishlist" href="#"><span></span></a>
                                <a class="add-compare" href="#"><span></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-12 product-item-box">
                    <div class="product-item product-resize">
                        <div class="image image-resize">
                            <a href="san-pham/combo-2-ao-thun-nu-sac-mau-he.html" title="Combo 2;">
                                <img src="Uploads/shop139/images/Product/130155_fashion.jpg" class="img-responsive" />
                            </a>
                                <span class="promotion">-10%</span>
                        </div>
                        <div class="right-block">
                            <h2 class="name">
                                <a href="san-pham/combo-2-ao-thun-nu-sac-mau-he.html" title="Combo 2 &#193;">Combo 2 &#193;o Thun Ná»¯ Sáº¯c M&#224;u H&#232;</a>
                            </h2>
                            <div class="ratings clearfix">
                                <div class="rating-box">
                                    <div class="rating">
                                    </div>
                                </div>
                            </div>
                            <div class="price">
                                    <span class="price-new">202.500&nbsp;đ</span>
                                    <span class="price-old">225.000&nbsp;đ</span>
                            </div>
                            <div class="addtocart-button clearfix">
                                <a class="add-to-cart" href="javascript:void(0)" onclick="AddToCard(2656,1)"><span></span></a>
                                <a class="add-wishlist" href="#"><span></span></a>
                                <a class="add-compare" href="#"><span></span></a>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
            <div class="navigation">
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
            </div>
    </section>
                    </div>
            </div>
        </div>
    </div>
            <div class="partner">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
    <!--Begin-->
    <script type="text/javascript">
//         $(document).ready(function () {
//             var owl = $(".partner-block");
//             owl.owlCarousel({
//                 autoPlay: true,
//                 autoPlay: 5000,
//                 items: 6,
//                 slideSpeed: 1000,
//                 pagination: false,
//                 itemsDesktop: [1200, 6],
//                 itemsDesktopSmall: [980, 5],
//                 itemsTablet: [767, 4],
//                 itemsMobile: [480, 2]
//             });
//         });
    </script>
    <!--End-->
<script type="text/javascript">
    window.Partners = [{"Id":171,"ShopId":139,"Name":"efef","Link":null,"Logo":"/Uploads/shop139/images/Product/burbery_2jrem8aiipohl_simg_603cef_226x114_maxb.png","Index":1,"Inactive":false},{"Id":172,"ShopId":139,"Name":"dsfdsf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k1l1rsnb045m_simg_603cef_226x114_maxb.jpg","Index":2,"Inactive":false},{"Id":173,"ShopId":139,"Name":"fsdf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k1l5tedglnk9_simg_603cef_226x114_maxb.jpg","Index":3,"Inactive":false},{"Id":174,"ShopId":139,"Name":"ddsf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k1m8k9aglr85_simg_603cef_226x114_maxb.jpg","Index":4,"Inactive":false},{"Id":175,"ShopId":139,"Name":"sfddf","Link":"#","Logo":"/Uploads/shop139/images/Product/logo__2k2dp8si78411_simg_603cef_226x114_maxb.jpg","Index":5,"Inactive":false}];
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
                            <a href="gioi-thieu.html">
                                Về ch&#250;ng t&#244;i
                            </a>
                        </li>
                        <li>
                            <a href="gioi-thieu.html">
                                Lĩnh vực hoạt động
                            </a>
                        </li>
                        <li>
                            <a href="content/hoi-dap.html">
                                Hỏi đ&#225;p
                            </a>
                        </li>
                        <li>
                            <a href="content/quy-che-hoat-dong.html">
                                Quy chế hoạt động
                            </a>
                        </li>
                        <li>
                            <a href="content/tuyen-dung.html">
                                Tuyển dũng
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
                            <a href="content/quy-dinh-doi-tra.html">
                                Quy định đổi trả
                            </a>
                        </li>
                        <li>
                            <a href="content/chinh-sach-ban-hang.html">
                                Ch&#237;nh s&#225;ch b&#225;n h&#224;ng
                            </a>
                        </li>
                        <li>
                            <a href="content/chinh-sach-bao-mat.html">
                                Ch&#237;nh s&#225;ch bảo mật
                            </a>
                        </li>
                        <li>
                            <a href="content/quy-dinh-thao-luan.html">
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
                            <b>C&#212;NG TY TNHH PH&#193;T TRIỂN C&#212;NG NGHỆ RUNTIME</b>
                            <p><i class="fa fa-map-marker"></i> 5/12A Quang Trung, P.14, Q.G&#242; Vấp, Tp.HCM</p>
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
    <script type="text/javascript">
//     $(document).ready(function () {
//         $("#btnNewsletter").click(function () {
//             Newsletter();
//         });
//     });
//     function Newsletter() {
//         var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
//         var email = $('#txtNewsletter').val();
//         if (email == "") {
//             $('#txtNewsletter').focus();
//             return;
//         }
//         if (!emailReg.test(email)) {
//             alert("Email không hợp lệ.");
//             $('#txtNewsletter').focus();
//             return;
//         }

//         $.ajax({
//             url: '/Module/Newsletter',
//             type: 'POST',
//             data: JSON.stringify({ 'email': email }),
//             dataType: 'json',
//             contentType: 'application/json; charset=utf-8',
//             success: function (data) {
//                 if (data.Result == "OK") {
//                     $('#txtNewsletter').val('');
//                     alert("Cảm ơn bạn đã đăng ký nhận thông tin khuyến mãi từ chúng tôi.");
//                 }
//                 else
//                     alert(data.Message);
//             },
//             error: function (data, errorThrown) {
//                 alert("Error: " + errorThrown);
//             },
//             beforeSend: function () {
//                 $("#loading-mask").show();
//             }, complete: function () {
//                 $("#loading-mask").hide();
//             }
//         });
//     }
    </script>
        </div>

</div>


    
    <div style="display: none;" id="loading-mask">
        <div id="loading_mask_loader" class="loader">
            <img alt="Loading..." src="Images/ajax-loader-main.gif" />
            <div>
                Please wait...
            </div>
        </div>
    </div>
    <a class="back-to-top" href="#" style="display: inline;">
        <i class="fa fa-angle-up">
        </i>
    </a>
    
    
</body>

</html>
<script type="text/javascript">
    $(".header-content").css({ "background": '' });
    $("html").addClass('');
//     $(document).ready(function () {
//         $("img.lazy-img").each(function () {
//         });
//         $("img.lazy-img").lazyload({
//             effect: "fadeIn",
//             threshold: 200
//         });
//     });
</script>

