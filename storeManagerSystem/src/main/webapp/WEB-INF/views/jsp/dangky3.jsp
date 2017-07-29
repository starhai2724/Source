<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="theme-list create-web" ng-app="DangKiWebForm" ng-controller="ctrl"  >
    <div class="container">
        <h1 class="text-uppercase clearfix title" style="margin-left: -70px">đăng ký tạo mẫu Website</h1>
        <div class="steps clearfix">
		            <div class="col-md-9 col-md-offset-1 col-sm-5 col-sm-offset-1 ">
		                <ul class="clearfix">
		                    <li ng-class="{ 'active' : Step==1 }" >
		                        <a > <span class="step" >1</span> <span class="title" style=" color: #2990ea;">Thông tin website</span> </a>
		                    </li>
		                    <li ng-class="{ 'active' : Step==2 }" >
		                        <a> <span class="step" >2</span> <span class="title">Chọn giao diện</span> </a>
		                    </li>
		                    <li ng-class="{ 'active' : Step==3 }" class="active">
		                        <a> <span class="step" style="background-color: #2990ea;border-color: #2990ea;">3</span> <span class="title">Xác nhận</span> </a>
		                    </li>
		                </ul>
		            </div>
		        </div>
        </div>
          <form:form class="step-block-box clearfix"  id="DangKiWebForm"  modelAttribute="DangKiWebForm"  method="get">
            <div class="col-sm-5 col-xs-12 col-sm-offset-3  step-block3 ">
                <h2>Bước 3: Điền thông tin cá nhân</h2>
                <p style="color: blue; font-weight: bold;">${DangKiWebForm.message }</p>
				<p style="color: red; font-weight: bold;">${DangKiWebForm.messageErr }</p>
                <div class="form-group has-feedback">
                    <form:input type="text" class="form-control" placeholder="Domain" path="pathJSP"  ng-model="pathJSP" ng-init="pathJSP='${DangKiWebForm.pathJSP}'" pattern="^[a-zA-Z0-9_-]{3,60}$" ng-minlength="3" ng-maxlength="50"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{pathJSP_err}}</p>
                </div>
                <div class="form-group has-feedback">
                <form:input type="text" class="form-control" placeholder="Địa chỉ doanh nghiệp/cửa hàng" path="diaChi"  ng-model="diaChi" ng-init="diaChi='${DangKiWebForm.diaChi}'" ng-minlength="3" ng-maxlength="50"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{diaChi_err}}</p>
                </div>
                <div class="form-group has-feedback">
                <form:input type="text" class="form-control" placeholder="Số điện thoại" path="sdt"  ng-model="sdt" ng-init="sdt='${DangKiWebForm.sdt}'" ng-minlength="10" ng-maxlength="12"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{sdt_err}}</p>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 capcha-group">
                        <form:input type="text" class="form-control" placeholder="Nhập mã xác nhận" path="maXacNhan"  ng-model="maXacNhan" ng-init="maXacNhan='${DangKiWebForm.maXacNhan}'"/>
                            <span class="form-control-feedback color7" aria-hidden="true">*</span>
                            <p style="color: red;">{{maXacNhan_err}}</p>
                        </div>
                        <div class="col-sm-6 image-capcha">
                            <img class="img-captcha" id="imgCaptcha" alt="captcha" src="/storeManagerSystem/view/image/Capture.PNG" style="width:100px;" />
                            <a class="refresh-captcha" id="btnRefreshCapcha" href="javascript:void(0);">
                                <i class="fa fa-refresh"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="form-group button-group">
                    <div class="button">
                        <a  href="javascript:void(0);" class="btn btn-warning" ng-click="btnBackStep2()"><i class="fa fa-mail-reply"></i> Quay lại</a>
                        <input class="btn btn-default" type="button" ng-click="btnTaoWeb();" value="Tạo Web" />
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</section>  
<script src="/storeManagerSystem/view/js/dangKiWeb.js"></script> 