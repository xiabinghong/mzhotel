define(function (require, exports) {
    var moduleName = "resourceModule";
    require("../app.directives");
    require("./resourceRest");
    var moduleApp = angular.module(moduleName, ["common","Resource.REST"]);
    moduleApp.controller("resourceEditController", ["$scope","ResourceAPI","$UrlUtils", function ($scope,ResourceAPI,$UrlUtils) {
        $scope.query = {};
        $scope.resource = {};
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        var params = $UrlUtils.getParameters();
        $scope.init = function () {
            if (params && params.id) {
                ResourceAPI.get({id:params.id},function(result){
                    $scope.resource = result;
                });
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.save = function () {
            if (params.id) {
                ResourceAPI.update({id: params.id}, $scope.resource, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("更新成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
                ResourceAPI.save($scope.resource, function (result) {
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
