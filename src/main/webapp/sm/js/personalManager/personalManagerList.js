define(function (require, exports) {
    var moduleName = "personalManagerModule";
    require("../app.directives");
    require("./personalManagerRest");
    var moduleApp = angular.module(moduleName, ["common", "PersonalManager.REST"]);
    moduleApp.controller("personalManagerController", ["$scope", "$http", "$dialog", "PersonalManagerAPI", function ($scope, $http, $dialog, PersonalManagerAPI) {
        $scope.query = {};
        $scope.personalReservationManagerList = {};
        $scope.choiceItem = null;
        $scope.pageSetting = {
            pageSize: 10,
            pageNum: 1
        };
        $scope.getPersonalReservationList = function () {
            $scope.personalReservationManagerList = {};
            $scope.queryBtnLoading = true;
            $scope.choiceItem = null;
            PersonalManagerAPI.query({
                area: $scope.query.area,
                roomCode: $scope.query.roomCode,
                dinnerTimeCode: $scope.query.dinnerTimeCode,
                contactUser: $scope.query.contactUser,
                pageNum: $scope.pageSetting.pageNum,
                pageSize: $scope.pageSetting.pageSize
            }, function (result) {
                $scope.personalReservationManagerList = angular.copy(result.data);
                $scope.pageSetting = result.pageBean;
                $scope.pageSetting.loadData = $scope.getPersonalReservationList;
            }).$promise.finally(function () {
                $scope.queryBtnLoading = false;
            });
        }
        $scope.init = function () {
            $scope.getPersonalReservationList();
        };
        $scope.reset = function () {
            $scope.query = {};
        };
        $scope.add = function () {
            $dialog.modal({
                url: "../personalManager/personalManagerEdit.jsp",
            });
        };
        $scope.view = function (item) {
            if (item && item.id) {
                $dialog.modal({
                    url: "../personalManager/personalManagerEdit.jsp",
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
                PersonalManagerAPI.remove({
                    id: item.id
                }, function () {
                    alert("单据删除成功");
                    $scope.init();
                });
            } else {
                alert("请选择单据");
            }
        };
        $scope.statusIn = function () {

        };
        $scope.statusCancel = function () {

        };
        $scope.storeLog = function () {

        };
        $scope.init();
        window.doCallback = function () {
            $scope.init();
        }
    }]);
    window.angular.bootstrap(document, [moduleName]);
});


