var app = angular.module('ProductForm', []);

app.controller('ctrl', function($scope) {
  $scope.name = 'World';
        $scope.exportAction = function (option) {
          switch (option) {
              case 'pdf': $scope.$broadcast('export-pdf', {}); 
                  break; 
              case 'excel': $scope.$broadcast('export-excel', {});
                  break; 
              case 'doc': $scope.$broadcast('export-doc', {});
                  break;
              case 'csv': $scope.$broadcast('export-csv', {});
                  break;
              default: console.log('no event caught'); 
          }
      }
});

app.directive('dataTables-example', function(){
          var link = function ($scope, elm, attr) {
            $scope.$on('export-pdf', function (e, d) {
                elm.tableExport({ type: 'pdf', escape: false });
            });
            $scope.$on('export-excel', function (e, d) {
                elm.tableExport({ type: 'excel', escape: false });
            });
            $scope.$on('export-doc', function (e, d) {
                elm.tableExport({ type: 'doc', escape: false });
            });
            $scope.$on('export-csv', function (e, d) {
                elm.tableExport({ type: 'csv', escape: false });
            });
        }
        return {
            restrict: 'C',
            link: link
        }
});
