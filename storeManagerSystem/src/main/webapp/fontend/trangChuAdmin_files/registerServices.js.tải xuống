appMain.service('registerService', ['ajaxService', function (ajaxService) {
    this.createShop = function (data, successFunction, errorFunction) {
        ajaxService.AjaxPost(data, "/api/shop/createshop", successFunction, errorFunction);
    };
    this.checkShop = function (data, successFunction, errorFunction) {
        ajaxService.AjaxPost(data, "/api/shop/checkshop", successFunction, errorFunction);
    };
    this.getCacheData = function (successFunction, errorFunction) {
        ajaxService.AjaxGet("/api/shop/getcachedata", successFunction, errorFunction);
    };
    this.getTemplates = function (data, successFunction, errorFunction) {
        ajaxService.AjaxGetWithData(data, "/api/template/gettemplates", successFunction, errorFunction);
    };
    this.getFieldParents = function (successFunction, errorFunction) {
        ajaxService.AjaxGet("/api/template/getfieldparents", successFunction, errorFunction);
    };
    this.getFieldChilds = function (data, successFunction, errorFunction) {
        ajaxService.AjaxGetWithData(data, "/api/template/getfieldchilds", successFunction, errorFunction);
    };
    this.getFields = function (successFunction, errorFunction) {
        ajaxService.AjaxGet("/api/template/getfields", successFunction, errorFunction);
    };
    this.registerNewsLetter = function (data, successFunction, errorFunction) {
        ajaxService.AjaxPost(data, "/api/module/registernewsletter", successFunction, errorFunction);
    };
}]);

















