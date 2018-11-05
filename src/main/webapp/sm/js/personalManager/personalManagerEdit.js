define(function (require, exports) {
    var moduleName = "personalReservationEditModule";
    require("../app.directives");
    require("./personalManagerRest");
    require("../tools/ng-file-upload");
    require("../document/documentInfoRest");
    var moduleApp = angular.module(moduleName, ["common", "PersonalManager.REST","DocumentInfo.REST","ngFileUpload"]);
    moduleApp.controller("personalReservationEditController", ["$scope", "$http", "$UrlUtils", "PersonalManagerAPI","DocumentInfoAPI","Upload", function ($scope, $http, $UrlUtils, PersonalManagerAPI,DocumentInfoAPI,Upload) {
        $scope.query = {};
        $scope.file = null;
        $scope.documentInfo = {};
        $scope.documentInfo.url=null;
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        var params = $UrlUtils.getParameters();
        $scope.personalReservation = {};
        $scope.init = function () {
            if (params && params.id) {
                PersonalManagerAPI.get({id: params.id}, function (result) {
                    $scope.personalReservation = result;
                });
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.uploadFile = function(){
            console.log($scope.file);
            Upload.upload({
                method:"POST",
                url:appname+"/documentInfo/upload",
                file:$scope.file
            }).success(function(result){
                $scope.documentInfo = result;

            })
        }
        $scope.save = function () {
            if (params.id) {
                $scope.personalReservation.documentInfoId = $scope.documentInfo.id;
                PersonalManagerAPI.update({id: params.id}, $scope.personalReservation, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("更新成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
                $scope.personalReservation.documentInfoId = $scope.documentInfo.id;
                PersonalManagerAPI.save($scope.personalReservation, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("新增成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            }
        };

        function callback() {
            if (self.opener && self.opener.doCallback) {
                self.opener.doCallback();
            }
        }

        $scope.cancel = function () {
            $scope.pageSetting.disabled = true;
            $scope.init();
        }
        $scope.close = function () {
            window.close();
        }
        $scope.edit = function () {
            $scope.pageSetting.disabled = false;
        }
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
});



