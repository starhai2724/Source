<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="theme-list create-web" ng-app="QuenMatKhauForm" ng-controller="ctrl" >
    <div class="container">
        <form:form  class="step-block-box clearfix" id="QuenMatKhauForm"  modelAttribute="QuenMatKhauForm"  method="get"> 
            <div class="col-sm-8 col-xs-13 col-sm-offset-2 step-block1 ">
                <h2>Đổi mật khẩu</h2>
                <p style="color: red; font-weight: bold;">${QuenMatKhauForm.messageErr }</p>
                <p style="color: blue; font-weight: bold;">${QuenMatKhauForm.message }</p>
                <div class="form-group has-feedback">
                    <form:input type="text" class="form-control" placeholder="Tên đăng nhập" path="email"  ng-model="email" ng-init="email='${QuenMatKhauForm.email}'" pattern="^[a-zA-Z0-9_-]{3,60}$" ng-minlength="3" ng-maxlength="50"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{email_err}}</p>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" placeholder="Mật khẩu cũ" ng-model="passwordOld" autocomplete="off"  maxlength="50">
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{passwordOld_err}}</p>
                 </div>
                <div class="form-group has-feedback">
                    <form:input type="password" class="form-control" placeholder="Mật khẩu mới" path="password" ng-model="password" autocomplete="off" ng-init="password='${QuenMatKhauForm.password}'" maxlength="50"/>
                    <span class="form-control-feedback color7" aria-hidden="true">*</span>
                    <p style="color: red;">{{password_err}}</p>
                </div>
                <div class="form-group button-group">
                    <div class="button">
                        <input class="btn btn-default" type="button" ng-click="btnDoiMK();" value="Submit" />
                    </div>
                </div>
            </div>
       </form:form> 
    </div>
</section>   
    <script src="/storeManagerSystem/view/js/quenMK.js"></script>