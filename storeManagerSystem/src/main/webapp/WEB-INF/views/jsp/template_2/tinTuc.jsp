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
<body  style="" ng-app="LayoutForm" ng-controller="ctrl">
<form:form id="LayoutForm" modelAttribute="LayoutForm" role="form" method="GET" >
<input type="hidden" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" >
        <div id="fb-root"></div>
<div class="wrapper page-home">
        <div class="header">
    <section class="top-link clearfix">
        <div class="container" style="width: 1370px">
            <div class="row" >
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
                        <div class="social-group">
                        </div>
                    </div>
                    <div class="col-md-9 col-xs-12 col-sm-12 header-right" style="margin-left: -120px">
                	 	<div class="search hidden-sm hidden-xs" s>
                            <div class="input-cat form-search clearfix">
                                <div class="form-search-controls">
                                    <input  type="text" path="timKiem_TenSP"  name="timKiem_TenSP" ng-model = "timKiem_TenSP"  ng-init ="timKiem_TenSP = '${LayoutForm.timKiem_TenSP}'" onblur="if(this.value=='')this.value='Tìm kiếm...'"
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
    <div class="container" style="width: 1370px;font-size: 18px">
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
                            	<li><a style="padding-top: 18px" href="/storeManagerSystem/${LayoutForm.pathJSP }"><span style="font-size: 16px">Trang chủ</span></a></li>
								<li><a style="padding-top: 18px" ng-click="btnGioiThieu()"><span style="font-size: 16px">Giới thiệu</span></a></li>
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
								<li> <a style="padding-top: 18px" ng-click="btnTinTuc()"><span style="font-size: 16px">Tin tức</span></a></li>
								<li><a style="padding-top: 18px" ng-click="btnLienHe()"><span style="font-size: 16px">Liên hệ</span></a></li>
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
<div class="main">
  <div class="container" style="width: 1370px">
     <div class="row">
         <div class="col-md-3">
				<div class="menu-news">
				    <h3>
				        <span>
				            Tin tức
				        </span>
				    </h3>
				    <ul class="level0"><li><a href="http://runecom22.runtime.vn/tin-tuc/tin-trong-nuoc"><i class="fa fa-arrow-circle-o-right"></i>Tin trong nước</a></li>
					<li><a href="http://runecom22.runtime.vn/tin-tuc/tin-quoc-te"><i class="fa fa-arrow-circle-o-right"></i>Tin quốc tế</a></li>
					</ul>
				</div>
				<div class="box-news">
				    <h3>
				        <span>
				            Tin tức nổi bật
				        </span>
				    </h3>
				    <div class="news-content">
				        <div class=" news-block clearfix">
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/nhung-phong-cach-dinh-chat-vao-sao-viet-1427861847_180x108.jpg" alt="Những phong cách &#39;đóng khung&#39; của sao Việt" title="Những phong cách &#39;đóng khung&#39; của sao Việt"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html">Những phong cách 'đóng khung' của sao Việt</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/3-cach-mac-vay-duoc-lang-xe-manh-he-2015-1427882991_180x108.jpg" alt="3 cách mặc váy được lăng xê mạnh hè 2015" title="3 cách mặc váy được lăng xê mạnh hè 2015"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html">3 cách mặc váy được lăng xê mạnh hè 2015</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/minh-hang-khoe-vong-mot-goiwjc-am-1427944534_180x108.jpg" alt="Minh Hằng gợi cảm trong váy khoét ngực" title="Minh Hằng gợi cảm trong váy khoét ngực"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html">Minh Hằng gợi cảm trong váy khoét ngực</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/MG-2204-1427902264_180x108.jpg" alt="Diễm My 9X gợi ý váy áo cho mùa hè" title="Diễm My 9X gợi ý váy áo cho mùa hè"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html">Diễm My 9X gợi ý váy áo cho mùa hè</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/t-1428032524_490x294.jpg" alt="Những góc khuất của nghề stylist cho sao Hollywood " title="Những góc khuất của nghề stylist cho sao Hollywood "></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html">Những góc khuất của nghề stylist cho sao Hollywood </a></h2>
				                        
				                    </div>
				                </div>
				        </div>
				    </div>
				</div>
        </div>
      <div class="col-md-9">
				<script type="text/javascript">
				    $(".link-site-more").hover(function () { $(this).find(".s-c-n").show(); }, function () { $(this).find(".s-c-n").hide(); });
				</script>
				<div class="news-content">
					    <div class="news-block clearfix">
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html">
					                	<img src="/storeManagerSystem/view/template_2/image/nhung-phong-cach-dinh-chat-vao-sao-viet-1427861847_180x108.jpg" class="img-responsive" alt="Những phong cách &#39;đóng khung&#39; của sao Việt"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html">Những phong cách 'đóng khung' của sao Việt</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Lý Nhã Kỳ, Ngọc Trinh, Sơn Tùng M-TP, Mai Phương Thúy... thường xuyên xuất hiện với một kiểu phong cách quen thuộc.</span></p>
										</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html">
					                	<img src="/storeManagerSystem/view/template_2/image/3-cach-mac-vay-duoc-lang-xe-manh-he-2015-1427882991_180x108.jpg" class="img-responsive" alt="3 cách mặc váy được lăng xê mạnh hè 2015"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html">3 cách mặc váy được lăng xê mạnh hè 2015</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
										<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Cách diện váy trơn, giản dị sẽ ít xuất hiện trong mùa hè năm nay, thay vào đó là cách phối nhiều lớp độc lạ và cá tính.</span></p>
									</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html">
					                	<img src="/storeManagerSystem/view/template_2/image/minh-hang-khoe-vong-mot-goiwjc-am-1427944534_180x108.jpg" class="img-responsive" alt="Minh Hằng gợi cảm trong váy khoét ngực"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html">Minh Hằng gợi cảm trong váy khoét ngực</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Nữ diễn viên diện ba bộ váy đen trong bộ hình mới nhất do nhiếp ảnh gia Lê Thiện Viễn thực hiện.</span></p>
										</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html">
					                	<img src="/storeManagerSystem/view/template_2/image/MG-2204-1427902264_180x108.jpg" class="img-responsive" alt="Diễm My 9X gợi ý váy áo cho mùa hè"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html">Diễm My 9X gợi ý váy áo cho mùa hè</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Người đẹp chọn những bộ váy có gam màu trắng, với chất liệu mềm, thoáng mát.</span></p>
										</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html">
					                	<img src="/storeManagerSystem/view/template_2/image/t-1428032524_490x294.jpg" class="img-responsive" alt="Những góc khuất của nghề stylist cho sao Hollywood "></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html">Những góc khuất của nghề stylist cho sao Hollywood </a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Stylist của Cate Blanchett, Julia Roberts, Sandra Bullock... cho biết, nghề này không dễ làm và chẳng hề có cuộc sống xa hoa như mọi người vẫn tưởng.</span></p>
										</div>
					                </div>
					            </div>
					    </div>
					</div>
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

