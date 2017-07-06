<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="theme-list create-web" ng-app="DangKiWebForm" ng-controller="ctrl" >
    <div class="container">
        <h1 class="text-uppercase clearfix title">đăng ký tạo mẫu Website</h1>
        <form:form  class="step-block-box clearfix" id="DangKiWebForm"  modelAttribute="DangKiWebForm"  method="get"> 
            <div class="col-sm-6 col-xs-12 col-sm-offset-3 step-block1 ">
                <h2>Bước 1: Điền thông tin website</h2>
                <div class="form-group has-feedback">
                    <form:input type="text" class="form-control" placeholder="Tên Website" path="tenWebSite"  ng-model="tenWebSite" name="tenWebSite" ng-init="tenWebSite='${DangKiWebForm.tenWebSite}'" pattern="^[a-zA-Z0-9_-]{3,60}$" ng-minlength="3" ng-maxlength="50"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{tenWebSite_err}}</p>
                </div>
                <div class="form-group has-feedback">
                    <form:input type="email" class="form-control" placeholder="Email đăng ký"  path="email"  ng-model="email"  name="email" ng-init="email='${DangKiWebForm.email}'" maxlength="50" pattern="^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$" />
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{email_err}}</p>
                </div>
                <div class="form-group has-feedback">
                    <form:input type="password" class="form-control" placeholder="Mật khẩu" path="matKhau" ng-model="matKhau" autocomplete="off" ng-init="matKhau='${DangKiWebForm.matKhau}'" maxlength="50"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{matKhau_err}}</p>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" placeholder="Nhập lại mật khẩu" ng-model="nhapMatKhau" autocomplete="off"  maxlength="50">
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{nhapMatKhau_err}}</p>
                </div>
                <!-- <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" checked="checked" ng-model="IsAcceptRule">Tôi đồng ý với <a href="dieu-khoan-su-dung.html">quy định sử dụng</a> & <a href="chinh-sach-bao-mat.html">chính sách bảo mật</a> của Runtime
                        </label>
                    </div>
                </div> -->
                <div class="form-group button-group">
                    <div class="button">
                        <input class="btn btn-default" type="button" ng-click="btnOpenStep2();" value="Tiếp tục" />
                    </div>
                </div>
            </div>
       </form:form> 
    </div>
</section>   
    <script src="/storeManagerSystem/view/js/dangKiWeb.js"></script>