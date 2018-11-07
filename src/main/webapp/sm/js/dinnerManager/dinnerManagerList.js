define(function (require, exports) {
    var moduleName = "dinnerManagerModule";
    require("../app.directives");
    require("./dinnerManagerRest");
    var moduleApp = angular.module(moduleName, ["common", "DinnerManager.REST"]);
    moduleApp.controller("dinnerManagerController", ["$scope", "$dialog", "DinnerManagerAPI", function ($scope, $dialog, DinnerManagerAPI) {
        $scope.query = {};
        $scope.dinnerPartyManagerList = {};
        $scope.choiceItem = null;
        $scope.pageSetting = {
            pageSize: 10,
            pageNum: 1
        };
        $scope.getDinnerPartyList = function () {
            $scope.dinnerPartyManagerList = {};
            $scope.queryBtnLoading = true;
            $scope.choiceItem = null;
            DinnerManagerAPI.query({
                dinnerPartyType: $scope.query.dinnerPartyType,
                dinnerPartyUser: $scope.query.dinnerPartyUser,
                tel: $scope.query.tel,
                consumptionItem: $scope.query.consumptionItem,
                pageNum: $scope.pageSetting.pageNum,
                pageSize: $scope.pageSetting.pageSize
            }, function (result) {
                $scope.dinnerPartyManagerList = angular.copy(result.data);
                $scope.pageSetting = result.pageBean;
                $scope.pageSetting.loadData = $scope.getDinnerPartyList;
            }).$promise.finally(function () {
                $scope.queryBtnLoading = false;
            });
        }
        $scope.init = function () {
            $scope.getDinnerPartyList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.add = function () {
            $dialog.modal({
                url: "../dinnerParty/dinnerManagerEdit.jsp",
            });
        };
        $scope.view = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../dinnerParty/dinnerManagerEdit.jsp",
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
                DinnerManagerAPI.remove({
                    id: item.id
                }, function () {
                    alert("单据删除成功");
                    $scope.init();
                });
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


