<!DOCTYPE html>
<html>
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
                            	<li><a style="padding-top: 18px" href="/storeManagerSystem/${LayoutForm.pathJSP }"><span style="font-size: 16px">Trang chủ</span></a></li>
								<li><a style="padding-top: 18px" ng-click="btnGioiThieu()"><span style="font-size: 16px">Giới thiệu</span></a></li>
								<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
							        <li>
							            <a style="padding-top: 18px" href="#" data-toggle="dropdown"><span style="font-size: 16px">${items.nameProductCategory }</span> <b class="caret"></b></a>
							            <c:if test="${!empty items.menuRowForms }">
								            <ul id="sub">
											            <c:forEach var="menus" items="${items.menuRowForms }">
											            			<li><a style="font-size: 14px" href="/storeManagerSystem/${LayoutForm.pathJSP }/searchByMenu/${menus.idLoaiSp}/${items.nameProductCategory}" ><span style="font-size: 16px">${menus.tenLoaiSp }</span></a></li>
											            			<%-- <li><a style="font-size: 14px" ng-click="btnTimKiemMenu('${menus.idLoaiSp }')" href="javascript:void(0)"><span style="font-size: 16px" >${menus.tenLoaiSp }</span></a></li> --%>
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
  <div class="container" style="width: 1270px">
    <div class="row">
      <div class="col-md-12">
			<div class="about-detail">
			    <div class="about-block">
			        <h1>Về chúng tôi</h1>
			        <div class="content">
			            <div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Dưới đây là nội dung mẫu của chúng tôi. Nội dung này chỉ mang tính chất minh họa:</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Royal Hotel - Khách sạn Hoàng Gia nằm giữa tuyến đường chính của khu du lịch, bên bờ vịnh Cát Bà xinh đẹp, có vị trí thuận tiện về giao thông, chỉ cách bến tàu cao tốc 50 m cách bến xe ô tô 20 m.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Khách sạn có 698 phòng nghỉ được thiết kế hài hòa trang nhã,trang thiết bị sang trọng, hiện đại đạt tiêu chuẩn Quốc tế 5 sao. Trong đó có 150 phòng đặc biệt, 200 phòng cao cấp 100 phòng hạng sang, 150 phòng tiêu chuẩn.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Hệ thống nhà hàng sang trọng, không gian thoáng đãng, tươi mới, hiện đại phục vụ được trên 10.000 thực khách. Nhà hàng nằm trên tầng 21 của khách sạn là nơi có tầm nhìn lý tưởng bao quát khu du lịch, chuyên phục các món ăn Âu, Trung Quốc và Việt nam và trên toàn thế giới với các món ăn ngon được chế biến từ các đầu bếp chuyên nghiệp cùng với phong cảnh thiên nhiên kỳ vĩ mà thiên nhiên ban tặng chắc chắn sẽ làm quý khách hài lòng. Vườn Thượng uyển trên tầng 13 là nơi tổ chức các bữa tiệc ngoài trời, các chương trình Ga la, hát karaoke theo yêu cầu của quý khách.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Khách sạn Royal Hotel có một phòng hội nghị lớn diện tích gần 200m2 ở tầng 6 với số lượng lên đến 10000 người và 98 phòng họp khác có sức chứa từ 5000 đến 8000 người có thể được bố trí và sắp xếp thành các phòng đa chức năng tuỳ theo yêu cầu của quý khách. Ngoài ra, khách sạn Royal Hotel có hội trường tầng 10 với sức chứa từ 70-100 khách. Được bố trí theo hình lớp học hoặc chữ U theo yêu cầu của quý khách, được thiết kế trang trọng với hệ thống âm thanh ánh sáng hiện đại sẽ đáp ứng hoàn hảo cho các cuộc họp ,hội nghị, tiệc hoặc sự kiện đặc biệt của quý khách.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Câu lạc bộ sức khỏe nằm trên tầng 30 của khách sạn với hệ thống các phòng massage VIP, SPA, Foot massage,... làm cho quý khách được thư giãn sau một ngày mệt mỏi. Dịch vụ giải trí và thư giãn đa dạng và phong phú đáp ứng mọi nhu cầu của mọi đối tượng khách hàng.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Với đội ngũ nhân viên nhiệt tình và hiếu khách, phong cách phục vụ chuyên nghiệp chắc chắn sẽ đem lại cho quý khách một ấn tượng tuyệt vời!</div>
			
			        </div>
			        <div class="social-group">
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
</div>
    <a class="back-to-top" href="#" style="display: inline;">
        <i class="fa fa-angle-up">
        </i>
    </a>
</form:form>    
</body>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</html>

