define(function (require, exports) {
    var moduleName = "roleResourceRelationModule";
    require("../app.directives");
    require("./roleRest");
    var moduleApp = angular.module(moduleName, ["common", "Role.REST"]);
    moduleApp.controller("roleResourceRelationController", ["$scope", "$UrlUtils", "RoleAPI", function ($scope, $UrlUtils, RoleAPI) {
        $scope.query = {};
        $scope.file = null;
        $scope.pageSetting = {
            disabled: true,
            loading: false
        };
        var params = $UrlUtils.getParameters();
        $scope.roleResourceRelation = null;
        $scope.roleHasResource = null;
        $scope.roleNotHasResource = null;
        $scope.hasResourceItem = null;
        $scope.notHasResourceItem = null;
        $scope.init = function () {
            RoleAPI.roleResourceRelation({
                roleCode:params.roleCode,
                queryType: "ALL"
            }, function (result) {
                $scope.roleResourceRelation = result;
                $scope.roleHasResource = $scope.roleResourceRelation.hasResourceList;
                $scope.roleNotHasResource = $scope.roleResourceRelation.notHasResourceList;
            });
        };

        $scope.findRoleHasResource = function () {
            RoleAPI.roleResourceRelation({
                roleCode:params.roleCode,
                resourceName: $scope.query.hasResourceName,
                queryType: "ROLE_HAS_RESOURCE"
            }, function (result) {
                $scope.roleHasResource = result.hasResourceList;
            });
        };

        $scope.findRoleNotHasResource = function () {
            RoleAPI.roleResourceRelation({
                roleCode:params.roleCode,
                resourceName: $scope.query.notHasResourceName,
                queryType: "ROLE_NOT_HAS_RESOURCE"
            }, function (result) {
                $scope.roleNotHasResource = result.notHasResourceList;
            });
        };

        $scope.choiceHasResourceItem = function (item) {
            $scope.hasResourceItem = item;
        };

        $scope.choiceNotHasResourceItem = function (item) {
            $scope.notHasResourceItem = item;
        };

        $scope.permission = function (item, entry) {
            if(entry.isActioned == true){
                RoleAPI.addRoleResource({
                    roleCode: params.roleCode,
                    resourceCode: item.resourceCode,
                    action: entry.action
                }, function (result) {
                    $scope.init();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else {
                RoleAPI.removeRoleResource({
                    roleCode:params.roleCode,
                    resourceCode: item.resourceCode,
                    action: entry.action
                }, function (result) {
                    $scope.init();
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            }
        };

        $scope.subRolesInfo = function (type) {
            if (type == 1) {
                if (!$scope.notHasResourceItem) {
                    alert("请选择资源");
                    return;
                }
                RoleAPI.addRoleResource({
                    roleCode:params.roleCode,
                    resourceCode: $scope.notHasResourceItem.resourceCode,
                    action:"VIEW"
                }, function (result) {
                    $scope.init();
                    alert("操作成功");
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            } else if (type == 2) {
                if (!$scope.hasResourceItem) {
                    alert("请选择资源");
                    return;
                }
                RoleAPI.removeRoleResource({
                    roleCode:params.roleCode,
                    resourceCode: $scope.hasResourceItem.resourceCode
                }, function (result) {
                    $scope.init();
                    alert("操作成功");
                }).$promise.finally(function () {
                    $scope.pageSetting.loading = false;
                });
            }
        };
        $scope.close = function () {
            window.close();
        };
        $scope.init();
    }]);
    window.angular.bootstrap(document, [moduleName]);
});