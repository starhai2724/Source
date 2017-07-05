<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="theme-list create-web" ng-app="DangKiWebForm" ng-controller="ctrl" >
    <div class="container">
        <h1 class="text-uppercase clearfix title">đăng ký tạo mẫu Website</h1>
        <div class="steps clearfix">
            <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 ">
                <ul class="clearfix">
                    <li ng-class="{ 'active' : Step==1 }">
                        <a> <span class="step" >1</span> <span class="title" style=" color: #2990ea;">Thông tin website</span> </a>
                    </li>
                    <li ng-class="{ 'active' : Step==2 }">
                        <a> <span class="step" style="background-color: #2990ea;border-color: #2990ea;">2</span> <span class="title">Chọn giao diện</span> </a>
                    </li>
                    <li ng-class="{ 'active' : Step==3 }">
                        <a> <span class="step">3</span> <span class="title">Xác nhận</span> </a>
                    </li>
                </ul>
            </div>
        </div>
        <form:form  id="DangKiWebForm" class="step-block-box clearfix" modelAttribute="DangKiWebForm"  method="get" > 
        <div class="step-block-box clearfix" >
            <div class="step-block2 clearfix">
                <h2>Bước 2: Chọn giao diện</h2>
                <div class="product-template clearfix">
                <c:forEach var="items" items="${DangKiWebForm.lstLoaiKinhDoanh }">
                    <div class="col-md-4 col-sm-4 col-sm-12" ng-click="btnOpenStep3('${items.idTemplate}');">
                        <div class=" product-item wow">
                            <div class="product-img"><a><img ng-src="/storeManagerSystem/myImage/imageTemplateDisplay/${items.idTemplate}" class="img-responsive" alt="${items.templateName}"></a></div>
                            <span class="circle-new">Mới</span>
                            <div class="product-info">
                                <h2 class="name"><a href="#">${item.templateName}</a></h2>
                                <div class="price">${item.gia} đ</div>
                            </div>
                            <div class="overlay">
                                <div class="color-group">
                                    <ul class="color">
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                 </c:forEach>   
                </div>
                <div class="form-group button-group">
                    <div class="button pull-right">
                        <a class="btn btn-warning" href="javascript:void(0)" ng-click="backStep1()"><i class="fa fa-mail-reply"></i> Quay lại</a>
                    </div>
                </div>
            </div>
        </div>
        </form:form>
    </div>
</section>
    <script src="/storeManagerSystem/view/js/dangKiWeb.js"></script>