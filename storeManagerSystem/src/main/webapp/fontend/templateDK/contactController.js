appMain.controller('contactController', function ($scope, $rootScope, $location, $window, contactService, alertsService) {
    $scope.initController = function () {
        $scope.initObject();
    }
    $scope.initObject = function () {
    }
    $scope.sendContact = function (response) {
        var obj = {
            Name: $scope.Name,
            Address: $scope.Address,
            Phone: $scope.Phone,
            Email: $scope.Email,
            Title: $scope.Title,
            Content: $scope.Content
        };

        contactService.sendContact(obj, $scope.sendContactCompleted, $scope.sendContactError);
    }
    $scope.sendContactCompleted = function (response) {
        alert("Cảm ơn bạn đã gửi liên hệ đến chúng tôi.");
        $window.location.href = "trang-chu.html";
    }
    $scope.sendContactError = function (response) {
        alert(response.Message);
    }
});