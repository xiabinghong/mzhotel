define(function (require, exports) {
    var moduleName = "storeManagerModule";
    require("../app.directives");
    require("./storeManagerRest");
    require("../actionLog/actionLogRest");
    var moduleApp = angular.module(moduleName, ["common", "StoreManager.REST", "ActionLog.REST"]);
    moduleApp.controller("storeManagerController", ["$scope", "$http", "$dialog", "StoreManagerAPI", "ActionLogAPI", function ($scope, $http, $dialog, StoreManagerAPI, ActionLogAPI) {
        $scope.query = {};
        $scope.storehouseManagerList = {};
        $scope.choiceItem = null;
        $scope.actionlog = {};
        $scope.actionLogList = {};
        $scope.pageSetting = {
            pageSize: 10,
            pageNum: 1
        };
        $scope.getStorehouseList = function () {
            $scope.storehouseManagerList = {};
            $scope.queryBtnLoading = true;
            $scope.choiceItem = null;
            StoreManagerAPI.query({
                goodsType: $scope.query.goodsType,
                goodsName: $scope.query.goodsName,
                pageNum: $scope.pageSetting.pageNum,
                pageSize: $scope.pageSetting.pageSize
            }, function (result) {
                $scope.storehouseManagerList = angular.copy(result.data);
                $scope.pageSetting = result.pageBean;
                $scope.pageSetting.loadData = $scope.getStorehouseList;
            }).$promise.finally(function () {
                $scope.queryBtnLoading = false;
            });
        };
        $scope.init = function () {
            $scope.getStorehouseList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.add = function () {
            $dialog.modal({
                url: "../storeManager/storeManagerEdit.jsp",
            });
        };
        $scope.view = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../storeManager/storeManagerEdit.jsp",
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
                StoreManagerAPI.remove({
                    id: item.id
                }, function () {
                    alert("单据删除成功");
                    $scope.init();
                });
            } else {
                alert("请选择单据");
            }
        };
        $scope.innerStore = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../storeManager/storehouseAction.jsp",
                    params: {
                        id: item.id,
                        action: "INNER_STORE"
                    }
                });
            } else {
                alert("请选择单据！");
            }
        };
        $scope.outStore = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../storeManager/storehouseAction.jsp",
                    params: {
                        id: item.id,
                        action: "OUT_STORE"
                    }
                });
            } else {
                alert("请选择单据！");
            }
        };
        $scope.storeLog = function (item) {
            $scope.id = item.id;
            if ($scope.id) {
                $dialog.modal({
                    url: "../actionLog/actionLogList.jsp",
                    params: {
                        actionType: "STORE_ACTION_TYPE",
                        parentId: $scope.id
                    }
                });
            } else {
                alert("请选择单据！");
            }
        };
        $scope.init();
        window.doCallback = function () {
            $scope.init();
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});