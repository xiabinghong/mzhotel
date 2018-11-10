define(function (require, exports) {
    var moduleName = "resourceListModule";
    require("../app.directives");
    require("./resourceRest");
    var moduleApp = angular.module(moduleName, ["common", "Resource.REST"]);
    moduleApp.controller("resourceListController", ["$scope", "ResourceAPI", "$dialog", function ($scope, ResourceAPI, $dialog) {
        $scope.query = {};
        $scope.resourceList = {};
        $scope.choiceItem = null;
        $scope.pageSetting = {
            pageSize: 10,
            pageNum: 1
        };
        $scope.getResourceList = function () {
            $scope.resourceList = {};
            $scope.queryBtnLoading = true;
            $scope.choiceItem = null;
            ResourceAPI.query({
                resourceName: $scope.query.resourceName,
                resourceType: $scope.query.resourceType,
                pageNum: $scope.pageSetting.pageNum,
                pageSize: $scope.pageSetting.pageSize
            }, function (result) {
                $scope.resourceList = angular.copy(result.data);
                $scope.pageSetting = result.pageBean;
                $scope.pageSetting.loadData = $scope.getResourceList;
            }).$promise.finally(function () {
                $scope.queryBtnLoading = false;
            });
        };
        $scope.init = function () {
            $scope.getResourceList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.add = function () {
            $dialog.modal({
                url: "../resource/resourceEdit.jsp",
            });
        };
        $scope.view = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../resource/resourceEdit.jsp",
                    params: {
                        id: item.id
                    }
                });
            } else {
                alert("请选择单据！");
            }
        };
        $scope.choiceViewItem = function (item) {
            $scope.choiceItem = item;
        };
        $scope.delete = function (item) {
            if (item && item.id) {
                ResourceAPI.remove({
                    id: item.id
                }, function () {
                    $scope.init();
                    alert("单据删除成功");
                })
            } else {
                alert("请选择单据");
            }
        };
        $scope.init();
        window.doCallback = function () {
            $scope.init();
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});