define(function (require, exports) {
    var moduleName = "userEditModule";
    require("../app.directives");
    require("./userRest");
    require("../tools/ng-file-upload");
    var moduleApp = angular.module(moduleName, ["common", "StoreManager.REST"]);
    moduleApp.controller("userEditController", ["$scope", "$http", "$UrlUtils", "UserAPI","Upload", function ($scope, $http, $UrlUtils,UserAPI,Upload) {
        $scope.query = {};
        $scope.file = null;
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        var params = $UrlUtils.getParameters();
        $scope.user = {};
        $scope.init = function () {
            if (params && params.id) {
                UserAPI.get({id: params.id}, function (result) {
                    $scope.user = result;
                });
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.save = function () {
            if (params.id) {
                UserAPI.update({id: params.id}, $scope.user, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("更新成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
                UserAPI.save($scope.user, function (result) {
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