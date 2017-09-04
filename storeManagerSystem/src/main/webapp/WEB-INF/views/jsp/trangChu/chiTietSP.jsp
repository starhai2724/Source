<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <title>Red Shop</title>
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
<div ng-app="LayoutForm" ng-controller="ctrl">
<form:form id="LayoutForm" modelAttribute="LayoutForm" role="form" method="GET" >
		<form:input type="hidden" path="pathJSP" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" />
        <div id="fb-root"></div>
        <script>
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = "../../connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6&appId=227481454296289";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
    

<div class="wrapper">
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
                            <li class="order-cart"><a href="javascript:void(0)" ng-click="btnCart();"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
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
                            <a href="/storeManagerSystem/trangChu" title="">
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
                                	<input style="width: 400px" type="text" placeholder="Nhập sản phẩm muốn tìm kiếm" path="timKiem_TenSP"  name="timKiem_TenSP" ng-model = "timKiem_TenSP"  ng-init ="timKiem_TenSP = '${LayoutForm.timKiem_TenSP}'" />
									<input style="width: 150px;background-color: #42a8bf;font-weight: bold;" type="submit" value="Tìm Kiếm" ng-click ="btnTimKiem()"/>
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
                window.location = '../tim-kiem7c8e.html?group=' + group + '&key=' + key;
            }
        </script>

<section class="navigation-menu clearfix">
    <div class="container" style="width: 1570px;font-size: 18px">
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
                            	<li><a style="padding-top: 18px" href="/storeManagerSystem/trangChu"><span style="font-size: 16px">Trang chủ</span></a></li>
								<li><a style="padding-top: 18px" ng-click="btnGioiThieu()"><span style="font-size: 16px">Giới thiệu</span></a></li>
								<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
							        <li>
							            <a style="padding-top: 18px" href="/storeManagerSystem/trangChu/timKiemSanPham/${items.idProductCategory }" ><span style="font-size: 16px">${items.nameProductCategory }</span> </a>
							        </li>
						        </c:forEach>
								<!-- <li> <a style="padding-top: 18px" ng-click="btnTinTuc()"><span style="font-size: 16px">Tin tức</span></a></li>
								<li><a style="padding-top: 18px" ng-click="btnLienHe()"><span style="font-size: 16px">Liên hệ</span></a></li> -->
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
<div class="main">
  <div class="container">
       <div class="row">
          <div class="col-md-9">
				<!-- <link href="/storeManagerSystem/view/template_2/Scripts/smoothproducts/smoothproducts.css" rel="stylesheet" type="text/css" /> -->
				<c:forEach var="items" items="${LayoutForm.products }">
				<div class="product-detail clearfix relative " >
				    <span></span>
				        <!--Begin-->
				        <div class="product-block clearfix">
				            <div class="row">
				                <div class="col-md-6 col-sm-6 col-xs-12 product-image clearfix">
				                    <div class="sp-loading"><img style="width: 300px;" src="/storeManagerSystem/myImage/trangChu/imageDisplay/${items.SEQ}" alt=""><br></div>
				                    <div class="sp-wrap">
				                    </div>
				                </div>
				                <div class="col-md-6 col-sm-6 col-xs-12 clearfix">
				                    <h2>${items.tenSP }</h2>
				                    <div class="price">
				                        <div ng-if="IsPromotion==true">
											<c:if test="${!empty items.giaBanKM }">
												<strike class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
											</c:if>
											<c:if test="${empty items.giaBanKM }">
												<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
											</c:if>
											<c:if test="${!empty items.giaBanKM }">
												<span class="price-new"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
											</c:if>
				                        </div>
				                    </div>
				                    <div class="des">${items.moTa }
				                    </div>
				                    <div class="social">
				                        <!-- AddThis Button BEGIN -->
				                        <div class="addthis_toolbox addthis_default_style">
				                            <a class="addthis_button_facebook_like" fb:like:layout="button_count">
				                            <div class="fb-like fb_iframe_widget" data-layout="button_count" data-show_faces="false" data-share="true" data-action="like" data-width="90" data-height="25" data-font="arial" data-href="http://runecom22.runtime.vn/san-pham/ao-so-mi-nu-cong-so.html" data-send="false" style="height: 25px;" fb-xfbml-state="rendered" fb-iframe-plugin-query="action=like&amp;app_id=227481454296289&amp;container_width=0&amp;font=arial&amp;height=25&amp;href=http%3A%2F%2Frunecom22.runtime.vn%2Fsan-pham%2Fao-so-mi-nu-cong-so.html&amp;layout=button_count&amp;locale=en_US&amp;sdk=joey&amp;send=false&amp;share=true&amp;show_faces=false&amp;width=90">
				                            <span style="vertical-align: bottom; width: 106px; height: 20px;">
				                            	<iframe name="f1c17dd0b7140cc" width="90px" height="25px" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" title="fb:like Facebook Social Plugin" src="https://www.facebook.com/v2.6/plugins/like.php?action=like&amp;app_id=227481454296289&amp;channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FXBwzv5Yrm_1.js%3Fversion%3D42%23cb%3Df3c16148f5b539%26domain%3Drunecom22.runtime.vn%26origin%3Dhttp%253A%252F%252Frunecom22.runtime.vn%252Ff2619a94f8a14%26relation%3Dparent.parent&amp;container_width=0&amp;font=arial&amp;height=25&amp;href=http%3A%2F%2Frunecom22.runtime.vn%2Fsan-pham%2Fao-so-mi-nu-cong-so.html&amp;layout=button_count&amp;locale=en_US&amp;sdk=joey&amp;send=false&amp;share=true&amp;show_faces=false&amp;width=90" style="border: none; visibility: visible; width: 106px; height: 20px;" class="">
				                           		 </iframe>
				                           	</span>
				                           	</div>
				                            </a>
				                            <a class="addthis_button_google_plusone" g:plusone:size="medium"></a>
				                            <a class="addthis_counter addthis_pill_style addthis_nonzero"></a>
				                        </div>
				                        <!-- <script type="text/javascript" src="/storeManagerSystem/view/template_2/scripts/addthis/addthis_widget.js#pubid=ra-5334d6387b03b532"></script> -->
				                        <!-- AddThis Button END -->
				                    </div>
				                    <div class="quantity clearfix">
				                        <label>Số lượng</label>
				                        <div class="quantity-input">
				                            <input type="number" value="1" class="text" ng-model="InputQuantity" ng-init="InputQuantity=1" />
				                        </div>
				                    </div>
				                    <div class="button" >
				                        <a  class="btn btn-primary" href="javascript:void(0)" ng-click="btnPurchase('${items.giaBan}','${items.giaBanKM }' ,'${items.SEQ} ')"><i class="glyphicon glyphicon-shopping-cart"></i>Thêm giỏ hàng</a>
				                    </div>
				                </div>
				            </div>
				        </div>
				        <!--End-->
				    <div class="modal fade" id="modalMyCart" tabindex="-1" role="dialog" >
				        <div class="modal-dialog  modal-lg">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
				                        &times;
				                    </button>
				                    <h4 class="modal-title">Bạn có {{OrderDetails.length}} sản phẩm trong giỏ hàng.</h4>
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
				                            <tr class="line-item" ng-repeat="item in OrderDetails">
				                                <td class="item-image">
				                                    <img  class="img-responsive" style="max-height:60px;" />
				                                </td>
				                                <td class="item-title">
				                                    <a href="%7b%7bitem.ProductCode%7d%7d.html">
				                                        {{item.ProductName}}<br>
				                                        <span >{{item.VariantName}}</span>
				                                    </a>
				                                </td>
				                                <td class="item-quantity">
				                                    <input type="number" class="text"  />
				                                </td>
				                                <td class="item-price">{{item.Amount|number:0}}₫</td>
				                                <td class="item-delete"><a >Xóa</a></td>
				                            </tr>
				                        </tbody>
				                    </table>
				                </div>
				                <div class="modal-footer">
				                    <div class="row">
				                        <div class="col-sm-12">
				                            <div class="total-price-modal">
				                                Tổng cộng : <span class="item-total">{{ Amount| number:0 }}₫</span>
				                            </div>
				                        </div>
				                    </div>
				                    <div class="row margin-top-10">
				                        <div class="col-lg-6">
				                            <div class="comeback text-left">
				                                <a href="../san-pham.html">
				                                    <i class="fa fa-chevron-circle-left "></i> Tiếp tục mua hàng
				                                </a>
				                            </div>
				                        </div>
				                        <div class="col-lg-6 text-right">
				                            <div class="buttons btn-modal-cart">
				                                <a class="btn btn-default" href="../thanh-toan.html">
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
				</c:forEach>

          </div>
          <div class="col-md-3">
			
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
                            <a ng-click="btnGioiThieu()">
                                Về ch&#250;ng t&#244;i
                            </a>
                        </li>
                        <li>
                            <a ng-click="btnLienHe()">
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
<li><a ng-click="btnHuongDan()">Hướng dẫn thanh toán</a></li>
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
                        <div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="true"></div>
                        <div class="fb-like-box" data-href="https://www.facebook.com/C%E1%BB%ADa-h%C3%A0ng-th%E1%BB%9Di-trang-255302581636729/" data-width="289"
                             data-height="190" data-colorscheme="dark" data-show-faces="true" data-header="false"
                             data-stream="false" data-show-border="false">
                        </div>
                        <div class="social-icon">
                            <ul>
                                <li><a target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="https://www.facebook.com/C%E1%BB%ADa-h%C3%A0ng-th%E1%BB%9Di-trang-255302581636729/" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a target="_blank"><i class="fa fa-youtube"></i></a></li>
                                <li><a target="_blank"><i class="fa fa-twitter "></i></a></li>
                                
                                <div id="fb-root"></div>

                            </ul>
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
</form:form> 
</div>   
</body>
<script src="/storeManagerSystem/view/js/shoppingCartTrangChu.js"></script>
</html>

