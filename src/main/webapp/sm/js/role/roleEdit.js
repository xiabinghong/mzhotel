define(function (require, exports) {
    var moduleName = "roleModule";
    require("../app.directives");
    require("./roleRest");
    var moduleApp = angular.module(moduleName, ["common","Role.REST"]);
    moduleApp.controller("roleEditController", ["$scope", "RoleAPI","$UrlUtils", function ($scope, RoleAPI,$UrlUtils) {
        $scope.query = {};
        $scope.pageSetting = {
            disabled: true
        };
        var params = $UrlUtils.getParameters();
        $scope.role = {};
        $scope.init = function () {
            if (params && params.id) {
                RoleAPI.get({id:params.id},function (result) {
                    $scope.role = result;
                });
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.save = function () {
            if (params.id) {
                RoleAPI.update({id: params.id}, $scope.role, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("更新成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
                RoleAPI.save($scope.role, function (result) {
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
