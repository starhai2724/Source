appMain.controller('templateController', function ($scope, $rootScope, $location, $window, templateService, alertsService) {
    $scope.initController = function () {
        $scope.initObject();
        templateService.getFieldParents($scope.getFieldParentsCompleted, $scope.getError);
    }
    $scope.initRegisterController = function () {
        $scope.initRegisterObject();
        templateService.getFieldParents($scope.getFieldParentsCompleted, $scope.getError);
    }
    $scope.initDetailsController = function (templateId) {
        $scope.initObject();
        var obj = {templateId:templateId};
        templateService.getTemplate(obj, $scope.getTemplateCompleted, $scope.getError);
    }
    $scope.getTemplateCompleted = function (response) {
        var obj = new Object();
        obj.Id = response.Data.Id;
        obj.Name = response.Data.Name;
        obj.Code = response.Data.Code;
        obj.Image = response.Data.Image;
        obj.IsFree = response.Data.IsFree;
        obj.IsNew = response.Data.IsNew;
        obj.Price = response.Data.Price;
        obj.Summary = response.Data.Summary;
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
        templateService.getTemplates(obj, $scope.getTemplatesCompleted, $scope.getError);
    };
    $scope.initObject = function () {
        $scope.currentPage = 1;
        $scope.FieldParentId = 0;
        $scope.FieldChildId = 0;
        $scope.pageSize = 12;
        $scope.total = 12;
        $scope.adjacent = 2;
        $scope.dots = "...";
        $scope.scrollTop = false;
        $scope.hideIfEmpty = false;
        $scope.ulClass = "pagination";
        $scope.activeClass = "active";
        $scope.disabledClass = "disabled";
        $scope.showPrevNext = true;
    }
    $scope.initRegisterObject = function () {
        $scope.currentPage = 1;
        $scope.FieldParentId = 0;
        $scope.FieldChildId = 0;
        $scope.pageSize = 8;
        $scope.total = 8;
        $scope.adjacent = 2;
        $scope.dots = "...";
        $scope.scrollTop = false;
        $scope.hideIfEmpty = false;
        $scope.ulClass = "pagination";
        $scope.activeClass = "active";
        $scope.disabledClass = "disabled";
        $scope.showPrevNext = true;
    }
    $scope.changeParents =function(parentId)
    {
        $scope.FieldParentId = parentId;
        $scope.FieldChildId = 0;
        $scope.getFieldChilds();
        $scope.getTemplates();
    }
    $scope.changeChilds = function (childId) {
        $scope.FieldChildId = childId;
        $scope.getTemplates();
    }
    $scope.createObject = function () {
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
        templateService.getTemplates(obj, $scope.getTemplatesCompleted, $scope.getError);
    }
    $scope.getFieldChilds = function () {
        var obj = { parentId: $scope.FieldParentId };
        templateService.getFieldChilds(obj, $scope.getFieldChildsCompleted, $scope.getError);
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

    $scope.getError = function (response) {
        $scope.Message = response.Message;
    }
    
});
