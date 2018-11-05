define(function (require, exports) {
    var moduleName = "userModule";
    var moduleApp = angular.module(moduleName,[]);
    moduleApp.controller("userEditController", ["$scope", "$http", function ($scope, $http) {
        $scope.query = {};
        $scope.pageSetting = {
            disabled: true
        };
        var params = {
            id:null
        };
        $scope.user = {};
        $scope.init = function () {
            if (params.id) {
                $http({
                    method: "GET",
                    url: "/mzhotel/user/selectByPrimaryKey",
                    data: params.id
                }).then(function successCallback(result) {
                    $scope.user = result;
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
                    url: "/mzhotel/user/update",
                    data: $scope.user
                }).then(function successCallback(result) {
                    params.id = result.data.id;
                    $scope.pageSetting.disabled = true;
                    $scope.user = result.data;
                    alert("更新成功");
                }, function errorCallback() {
                    alert("更新失败");
                })
            } else {
                $http({
                    method: "POST",
                    url: "/mzhotel/user/insert",
                    data: $scope.user
                }).then(function successCallback(result) {
                    params.id = result.data.id;
                    $scope.pageSetting.disabled = true;
                    $scope.user = result.data;
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
