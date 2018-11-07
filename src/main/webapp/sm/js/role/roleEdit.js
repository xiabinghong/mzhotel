define(function (require, exports) {
    var moduleName = "roleModule";
    var moduleApp = angular.module(moduleName, []);
    moduleApp.controller("roleEditController", ["$scope", "$http", function ($scope, $http) {
        $scope.query = {};
        $scope.pageSetting = {
            disabled: true
        };
        var params = {
            id: null
        };
        $scope.role = {};
        $scope.init = function () {
            if (params.id) {
                $http({
                    method: "GET",
                    url: "/mzhotel/role/selectByPrimaryKey",
                    data: params.id
                }).then(function successCallback(result) {
                    $scope.role = result;
                }, function errorCallback() {

                })
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.save = function () {
            if (params.id) {
                $http({
                    method: "POST",
                    url: "/mzhotel/role/update",
                    data: $scope.role
                }).then(function successCallback(result) {
                    params.id = result.data.id;
                    $scope.pageSetting.disabled = true;
                    $scope.role = result.data;
                    alert("更新成功");
                }, function errorCallback() {
                    alert("更新失败");
                })
            } else {
                $http({
                    method: "POST",
                    url: "/mzhotel/role/insert",
                    data: $scope.role
                }).then(function successCallback(result) {
                    params.id = result.data.id;
                    $scope.pageSetting.disabled = true;
                    $scope.role = result.data;
                    alert("新增成功");
                }, function errorCallback() {
                    alert("新增失败");
                })
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
})
