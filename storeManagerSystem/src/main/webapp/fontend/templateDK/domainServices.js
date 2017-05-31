appMain.service('domainService', ['ajaxService', function (ajaxService) {
    this.getDomains = function (successFunction, errorFunction) {
        ajaxService.AjaxGet("/api/domain/getdomains", successFunction, errorFunction);
    };
    this.checkDomain = function (data, successFunction, errorFunction) {
        ajaxService.AjaxPost(data, "/api/domain/checkdomain", successFunction, errorFunction);
    };
}]);

















