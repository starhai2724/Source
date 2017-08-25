var appMain = angular.module("appMain", ["summernote", "bw.paging", "ngSanitize"]);
appMain.directive('lazy', function ($timeout) {
    return {
        restrict: 'C',
        link: function (scope, elm) {
            $timeout(function() {
                $(elm).lazyload({
                    effect: 'fadeIn',
                    effectspeed: 500,
                    'skip_invisible': false
                });
            }, 0);
        }
    };
});
