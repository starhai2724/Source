﻿appMain.controller('registerController', function ($scope, $rootScope, $location, $window, $interval, registerService, alertsService) {

    $scope.initRegisterController = function () {
        $scope.initRegisterObject();
        registerService.getCacheData($scope.getCacheDataCompleted, $scope.getError);
        registerService.getFieldParents($scope.getFieldParentsCompleted, $scope.getError);
    }

    $scope.getTemplateCompleted = function (response) {
        var obj = new Object();
        obj.Id = response.Data.Id;
        obj.Name = response.Data.Name;
        obj.Code = response.Data.Code;
        obj.Image = response.Data.Image;
        obj.TemplateColors = response.Data.ModelTpl_TemplateColor;
        $scope.template = obj;

        $scope.FieldParentId = response.Data.FieldId;
        $scope.getTemplates();
    }
    $scope.changeTemplateColor = function (idx) {
        var item = $scope.template.TemplateColors[idx];
        $scope.template.Image = item.Image;
    };

    $scope.DoCtrlPagingAct = function (text, page, pageSize, total) {
        var obj = $scope.createObject();
        obj.jtStartIndex = (page - 1) * pageSize;
        registerService.getTemplates(obj, $scope.getTemplatesCompleted, $scope.getError);
    };

    $scope.initRegisterObject = function () {
        $scope.currentPage = 1;
        $scope.FieldParentId = 0;
        $scope.FieldChildId = 0;
        $scope.pageSize = 6;
        $scope.total = 6;
        $scope.adjacent = 2;
        $scope.dots = "...";
        $scope.scrollTop = false;
        $scope.hideIfEmpty = false;
        $scope.ulClass = "pagination";
        $scope.activeClass = "active";
        $scope.disabledClass = "disabled";
        $scope.showPrevNext = true;

        $scope.Step = 1;
        $scope.TemplateId = 0;
        $scope.TemplateColorId = 0;
        $scope.IsAcceptRule = true;
        $scope.RegexEmail = '^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$';
        $scope.CountDown = 15;
    }
    $scope.changeColor = function (templateColorId, templateId) {
        $scope.TemplateColorId = templateColorId;
        $scope.TemplateId = templateId;
        $scope.Step = 3;
    }
    $scope.backStep1 = function () {
        $scope.Step = 1;
    }
    $scope.backStep2 = function () {
        $scope.Step = 2;
    }
    $scope.step2 = function () {
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        var filterCode = /^[a-zA-Z0-9_-]{3,60}$/;
        if (!filter.test($scope.Email)) {
            $scope.IsError = true;
            $scope.Message = "Địa chỉ email không hợp lệ.";
            return;
        }
        if (!filterCode.test($scope.Code)) {
            $scope.IsError = true;
            $scope.Message = "Tên miền truy cập ít nhất 3 ký tự, chỉ chứa ký tự a->z, 1->9 không phân biệt chữ hoa chữ thường\n Không bao gồm phần mở rộng";
            return;
        }
        if ($scope.Password != $scope.RePassword) {
            $scope.IsError = true;
            $scope.Message = "Mật khẩu không khớp nhau.";
            return;
        }
        if ($scope.Password.length<6) {
            $scope.IsError = true;
            $scope.Message = "Mật khẩu phải có ít nhất 6 ký tự.";
            return;
        }
        if (!$scope.IsAcceptRule) {
            $scope.IsError = true;
            $scope.Message = "Bạn chưa đồng ý với điều khoản và chính sách của Runtime.";
            return;
        }
        
        var obj = {
            Code: $scope.Code,
            Name: $scope.Name,
            Address: $scope.Address,
            Email: $scope.Email,
            Phone: $scope.Phone,
            Captcha: $scope.Captcha,
            TemplateId: $scope.TemplateId,
            TemplateColorId: $scope.TemplateColorId,
            AccountInfo: {
                Email: $scope.Email,
                Password: $scope.Password,
                RePassword: $scope.RePassword,
            }
        };
        registerService.checkShop(obj, $scope.checkShopCompleted, $scope.checkShopError);
    }
    $scope.checkShopCompleted = function (response) {
        $scope.Step = 2;
        $scope.IsError = response.IsError;
        $scope.InValid = response.InValid;
    }
    $scope.checkShopError = function (response) {
        $scope.IsError = response.IsError;
        $scope.InValid = response.InValid;
        $scope.Message = alertsService.FormatMessage(response.ReturnMessage);
    }
    $scope.step3 = function () {
        if ($scope.TemplateId <= 0) {
            alert("Vui lòng chọn 1 mẫu template.");
            return;
        }
        $scope.Step = 3;
    }
    $scope.changeParents = function (parentId) {
        $scope.FieldParentId = parentId;
        $scope.FieldChildId = 0;
        $scope.getFieldChilds();
        $scope.getTemplates();
    }
    $scope.changeChilds = function (childId) {
        $scope.FieldChildId = childId;
        $scope.getTemplates();
    }
    $scope.createObject = function (page) {
        var item = {
            jtStartIndex: 0,
            jtPageSize: $scope.pageSize,
        };
        if ($scope.FieldChildId <= 0)
            item.FieldId = $scope.FieldParentId;
        else
            item.FieldId = $scope.FieldChildId;
        return item;
    }

    $scope.getTemplates = function () {
        var obj = $scope.createObject();
        registerService.getTemplates(obj, $scope.getTemplatesCompleted, $scope.getError);
    }
    $scope.getFieldChilds = function () {
        var obj = { parentId: $scope.FieldParentId };
        registerService.getFieldChilds(obj, $scope.getFieldChildsCompleted, $scope.getError);
    }

    $scope.getFieldParentsCompleted = function (response) {
        if (response.Records.length > 0) {
            $scope.FieldParentId = response.Records[0].Id;
            $scope.getFieldChilds(response.Records[0].Id);
            $scope.getTemplates();
        }
        $scope.FieldParents = response.Records;
    }
    $scope.getFieldChildsCompleted = function (response) {
        $scope.FieldChilds = response.Records;
    }
    $scope.getTemplatesCompleted = function (response) {
        $scope.Templates = response.Records;
        $scope.total = response.TotalRecordCount;
    }

    $scope.createShop = function () {
        $scope.Step = 4;
        var obj = {
            Code: $scope.Code,
            Name: $scope.Name,
            Address: $scope.Address,
            Email: $scope.Email,
            Phone: $scope.Phone,
            Captcha: $scope.Captcha,
            TemplateId: $scope.TemplateId,
            TemplateColorId: $scope.TemplateColorId,
            AccountInfo: {
                Email: $scope.Email,
                Password: $scope.Password,
                RePassword: $scope.RePassword,
            }
        };
        registerService.createShop(obj, $scope.createShopCompleted, $scope.createShopError);
    }
    $scope.createShopCompleted = function (response) {
        $scope.Step = 5;
        $scope.Domain = response.Domain;
        $scope.IsSuccess = response.IsSuccess;
        $scope.IsError = response.IsError;
        $scope.InValid = response.InValid;

        var timer= $interval(function () {
            $scope.CountDown--;
            if ($scope.CountDown == 0) {
                $window.location.href = "http://" + $scope.Code + "." + $scope.Domain + "/admin";
                if (angular.isDefined(timer)) {
                    $interval.cancel(timer);
                    timer = undefined;
                }
            }
        }, 1000, 0);
    }
    $scope.createShopError = function (response) {
        $scope.Step = 3;
        $scope.IsSuccess = response.IsSuccess;
        $scope.IsError = response.IsError;
        $scope.InValid = response.InValid;
        $scope.Message = alertsService.FormatMessage(response.ReturnMessage);
    }
    $scope.getError = function (response) {
    }
    $scope.getCacheDataCompleted = function (response) {
        $scope.Code = response.Data.Code;
        $scope.Email = response.Data.Email;
        $scope.Password = response.Data.AccountInfo.Password;
        $scope.RePassword = response.Data.AccountInfo.RePassword;
        $scope.Name = response.Data.Name;
        $scope.Address = response.Data.Address;
        $scope.Phone = response.Data.Phone;
        $scope.TemplateId = response.Data.TemplateId;
        $scope.TemplateColorId = response.Data.TemplateColorId;
        $scope.TemplateColorId = response.Data.TemplateColorId;
        //$scope.Captcha = response.Data.Captcha;
    }
});
appMain.controller('startRegisterController', function ($scope, $rootScope, $location, $window, registerService, alertsService) {
    $scope.initController = function () {
        $scope.initObject();
        registerService.getFields($scope.getFieldsCompleted, $scope.getError);
    }
    $scope.initObject = function () {
        $scope.FieldId = 0;
    }
    $scope.getFieldsCompleted = function (response) {
        $scope.Fields = response.Records;
    }
    $scope.startRegister = function () {
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (filter.test($scope.Email)) {
            //lay linh vuc kinh doanh
            var fieldName = "";
            $scope.Fields.forEach(function (item) {
                if (item.Id == $scope.FieldId) {
                    fieldName = item.Name;
                    return
                }
            });
            var obj = { Email: $scope.Email, Phone: $scope.Phone, Note: "Đăng ký khởi tạo web: " + fieldName }
            registerService.registerNewsLetter(obj, $scope.registerNewsLetterCompleted, $scope.registerNewsLetterError);
        }
        if ($scope.Email && $scope.Phone)
            $window.location.href = "dang-ky308d.html?email=" + $scope.Email + "&phone=" + $scope.Phone;
        else if ($scope.Email)
            $window.location.href = "dang-ky308d.html?email=" + $scope.Email;
        else if ($scope.Phone)
            $window.location.href = "dang-kyd9bf.html?phone=" + $scope.Phone;
        else
            $window.location.href = "dang-ky.html";
    }
    $scope.registerNewsLetterCompleted = function (response) {
    }
    $scope.registerNewsLetterError = function (response) {
    }
    $scope.getError = function (response) {
    }
});
appMain.controller('beginRegisterController', function ($scope, $rootScope, $location, $window, registerService, alertsService) {
    $scope.initController = function () {
        $scope.initObject();
    }
    $scope.initObject = function () {
    }
    $scope.beginRegister = function () {
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (filter.test($scope.Email)) {
            var obj = { Email: $scope.Email, Phone: $scope.Phone, Note: "Đăng ký khởi tạo web" }
            registerService.registerNewsLetter(obj, $scope.registerNewsLetterCompleted, $scope.registerNewsLetterError);
        }
        if ($scope.Email && $scope.Phone)
            $window.location.href = "dang-ky308d.html?email=" + $scope.Email + "&phone=" + $scope.Phone;
        else if ($scope.Email)
            $window.location.href = "dang-ky308d.html?email=" + $scope.Email;
        else if ($scope.Phone)
            $window.location.href = "dang-kyd9bf.html?phone=" + $scope.Phone;
        else
            $window.location.href = "dang-ky.html";
    }
    $scope.registerNewsLetterCompleted = function (response) {
    }
    $scope.registerNewsLetterError = function (response) {
    }
    $scope.getError = function (response) {
    }
});
