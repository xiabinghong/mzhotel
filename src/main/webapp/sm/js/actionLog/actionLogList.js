define(function (require, exports) {
    var moduleName = "storeManagerModule";
    require("../app.directives");
    require("./actionLogRest");
    var moduleApp = angular.module(moduleName, ["common", "ActionLog.REST"]);
    moduleApp.controller("actionLogController", ["$scope", "$http", "$dialog", "ActionLogAPI", "$UrlUtils", function ($scope, $http, $dialog, ActionLogAPI, $UrlUtils) {
        $scope.query = {};
        $scope.actionLogList = {};
        $scope.params = $UrlUtils.getParameters();
        $scope.getActionLogList = function () {
            $scope.actionLogList = {};
            $scope.queryBtnLoading = true;
            ActionLogAPI.queryActionLog({
                actionType: $scope.params.actionType,
                parentId: $scope.params.parentId
            }, function (result) {
                $scope.actionLogList = angular.copy(result);
                $scope.pageSetting.loadData = $scope.getActionLogList;
            }).$promise.finally(function () {
                $scope.queryBtnLoading = false;
            });
        }
        $scope.init = function () {
            $scope.getActionLogList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
});