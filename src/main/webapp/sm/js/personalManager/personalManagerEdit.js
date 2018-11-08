define(function (require, exports) {
    var moduleName = "personalReservationEditModule";
    require("../app.directives");
    require("./personalManagerRest");
    var moduleApp = angular.module(moduleName, ["common", "PersonalManager.REST"]);
    moduleApp.controller("personalManagerEditController", ["$scope", "$UrlUtils", "PersonalManagerAPI", function ($scope, $UrlUtils, PersonalManagerAPI) {
        $scope.query = {};
        $scope.file = null;
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
        $scope.save = function () {
            if (params.id) {
                PersonalManagerAPI.update({id: params.id}, $scope.personalReservation, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("更新成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
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
        };
        $scope.close = function () {
            window.close();
        };
        $scope.edit = function () {
            $scope.pageSetting.disabled = false;
        };
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
});



