define(function (require, exports) {
    var moduleName = "storehouseEditModule";
    require("../app.directives");
    require("./storeManagerRest");
    require("../tools/ng-file-upload");
    require("../document/documentInfoRest");
    var moduleApp = angular.module(moduleName, ["common", "StoreManager.REST", "DocumentInfo.REST", "ngFileUpload"]);
    moduleApp.controller("storehouseActionController", ["$scope", "$http", "$UrlUtils", "StoreManagerAPI", "DocumentInfoAPI", "Upload", function ($scope, $http, $UrlUtils, StoreManagerAPI, DocumentInfoAPI, Upload) {
        $scope.query = {};
        $scope.file = null;
        $scope.documentInfo = {};
        $scope.actionLog = {};
        $scope.documentInfo.url = null;
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        $scope.params = $UrlUtils.getParameters();
        $scope.actionLog = {
            parentId: $scope.params.id,
            actionType: "STORE_ACTION_TYPE"
        };
        $scope.actionName = $scope.params.action == "INNER_STORE" ? "入库" : "出库"
        $scope.storehouse = {};
        $scope.init = function () {
            if ($scope.params && $scope.params.id) {
                StoreManagerAPI.get({id: $scope.params.id}, function (result) {
                    $scope.storehouse = result;
                });
            } else {
                $scope.pageSetting.disabled = false;
            }
        }
        $scope.$watch('actionLog.amount', function (newVal, oldVal) {
            if (newVal != oldVal) {
                if (newVal && newVal != null) {
                    if ($scope.params.action == "INNER_STORE") {
                        $scope.actionLog.storeSumAmount = parseInt($scope.storehouse.amount) + parseInt($scope.actionLog.amount);
                    } else if ($scope.params.action == "OUT_STORE") {
                        $scope.actionLog.storeSumAmount = parseInt($scope.storehouse.amount) - parseInt($scope.actionLog.amount);
                    }
                } else {
                    $scope.actionLog.storeSumAmount = $scope.storehouse.amount;
                }
            }
        });
        $scope.save = function () {
            console.log($scope.actionLog);
            $scope.storehouse.documentInfoId = $scope.documentInfo.id;
            StoreManagerAPI.innerOrOutStore($scope.actionLog, function () {
                callback();
                window.close();
            }).$promise.finally(function () {
                $scope.pageSetting.loading = false;
            });
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
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
})