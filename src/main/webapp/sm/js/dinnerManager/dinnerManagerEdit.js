define(function (require, exports) {
    var moduleName = "dinnerPartyEditModule";
    require("../app.directives");
    require("./dinnerManagerRest");
    var moduleApp = angular.module(moduleName, ["common", "DinnerManager.REST"]);
    moduleApp.controller("dinnerPartyEditController", ["$scope", "$UrlUtils", "DinnerManagerAPI", function ($scope, $UrlUtils, DinnerManagerAPI) {
        $scope.query = {};
        $scope.file = null;
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        var params = $UrlUtils.getParameters();
        $scope.dinnerParty = {};
        $scope.init = function () {
            if (params && params.id) {
                DinnerManagerAPI.get({id: params.id}, function (result) {
                    $scope.dinnerParty = result;
                });
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.save = function () {
            if (params.id) {
                DinnerManagerAPI.update({id: params.id}, $scope.dinnerParty, function (result) {
                    params.id = result.id;
                    $scope.pageSetting.disabled = true;
                    alert("更新成功");
                    callback();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
                DinnerManagerAPI.save($scope.dinnerParty, function (result) {
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



