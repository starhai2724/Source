appMain.controller('domainController', function ($scope, $rootScope, $location, $window, domainService, alertsService) {
    $scope.initController = function () {
        $scope.initObject();
        domainService.getDomains($scope.getDomainsCompleted, $scope.getError);
    }
    $scope.getDomainsCompleted = function (response) {
        $scope.Domains = response.Records;
    }
    $scope.initObject = function () {
    }
    $scope.createObject = function () {
    }
    $scope.checkDomain = function () {
        $scope.ShowResult = false;
        if ($scope.Domain) {
            var str = $scope.Domain.replace(/(?:\r\n|\r|\n|\,)/g, ";");
            var domainSplit = str.split(';');
            var domains = new Array();
            domainSplit.forEach(function (item, index) {
                var idx = domains.indexOf(item);
                if (item.length > 0 && idx < 0) {
                    domains.push(item);
                }
            });
            var flag = false;
            domains.forEach(function (item, index) {
                if (item.length < 3) {
                    flag = true;
                    return;
                }
            });
            if (flag) {
                alert("Tên miền phải chứa từ 3 ký tự trở lên");
                return;
            }
            if (domains.length > 5) {
                alert("Số lượng tên miền để check không quá 5.");
                return false;
            }

            var exts = new Array();
            $scope.Domains.forEach(function (item) {
                if (item.IsSelected) {
                    exts.push(item.Name);
                }
            });
            var results = new Array();
            domains.forEach(function (item) {
                if (item.indexOf(".") != -1) {
                    var obj = { Name: item, CostInit: 0, CostMaintain: 0, StateCode: -2, StateImage: "", StateName: "", Link: "" }
                    results.push(obj);
                }
                else
                    exts.forEach(function (it) {
                        if (it.length > 0) {
                            var obj = { Name: item + it, CostInit: 0, CostMaintain: 0, StateCode: -2, StateImage: "", StateName: "", Link: "" }
                            results.push(obj);
                        }
                    });
            });
            $scope.PackageDomains = results;
            $scope.ShowResult = true;
            results.forEach(function (item, index) {
                $scope.Index = index;
                domainService.checkDomain(item, $scope.checkDomainCompleted, $scope.checkDomainError);
            });
        }
    }
    $scope.checkDomainCompleted = function (response) {
        var it = response.Data;
        $scope.PackageDomains.forEach(function (item, index) {
            if (item.Name == it.Name)
                $scope.PackageDomains[index] = it;
        });
    }
    $scope.checkDomainError = function (response) {
        $scope.Message = response.Message;
    }
    $scope.getError = function (response) {
        $scope.Message = response.Message;
    }
});
