appMain.service('templateService', ['ajaxService', function (ajaxService) {
    this.getTemplates = function (data, successFunction, errorFunction) {
        ajaxService.AjaxGetWithData(data, "/api/template/gettemplates", successFunction, errorFunction);
    };
    this.getTemplate = function (data, successFunction, errorFunction) {
        ajaxService.AjaxGetWithData(data, "/api/template/gettemplate", successFunction, errorFunction);
    };
    this.getFieldParents = function (successFunction, errorFunction) {
        ajaxService.AjaxGet("/api/template/getfieldparents", successFunction, errorFunction);
    };
    this.getFieldChilds = function (data, successFunction, errorFunction) {
        ajaxService.AjaxGetWithData(data, "/api/template/getfieldchilds", successFunction, errorFunction);
    };
}]);

















