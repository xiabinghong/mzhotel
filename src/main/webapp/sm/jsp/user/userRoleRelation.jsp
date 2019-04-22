<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="userRoleRelationController" style="align-content: center;">
    <div class="form-element">
        <div class="col-md-12 padding-0">
            <form>
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>分配角色</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <table width="100%">
                                <tr>
                                    <td valign="top" style="width:45%;">
                                        <div class="widget-box">
                                            <h5>可分配角色</h5>
                                        </div>
                                        <div class="widget-content">
                                            <table>
                                                <tr>
                                                    <td>名称</td>
                                                    <td><input type="text" ng-model="query.notHasRoleName"></td>
                                                    <td><input class="btn btn-info" type="button" ng-click="findUserNotHasRole();" value="搜索"></td>
                                                </tr>
                                            </table>
                                            <table class="table table-bordered">
                                                <tr class="grid-header">
                                                    <td>角色编号</td>
                                                    <td>角色名称</td>
                                                </tr>
                                                <tr ng-repeat="notHasRole in userNotHasRoleRelation"
                                                    ng-class="{'current-tr':notHasRoleItem.id == notHasRole.id}"
                                                    ng-click="choiceNotHasRoleItem(notHasRole)">
                                                    <td ng-bind="notHasRole.roleCode"></td>
                                                    <td ng-bind="notHasRole.roleName"></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </td>
                                    <td style="text-align:center;" valign="top">
                                        <br/><br/>
                                        <input type="button" class="btn allotShow" ng-click="subRolesInfo(1);" value="分配"/><br/><br/>
                                        <input type="button" class="btn allotShow" ng-click="subRolesInfo(2);" value="取消分配"/>
                                        <br/><br/>
                                    </td>
                                    <td valign="top" style="width:45%;">
                                        <div class="widget-box">
                                            <div class="widget-title">
                                                <h5>已分配角色</h5>
                                            </div>
                                            <div class="widget-content">
                                                <table>
                                                    <tr>
                                                        <td>名称</td>
                                                        <td><input type="text" ng-model="query.hasRoleName"></td>
                                                        <td><input class="btn btn-info" type="button" ng-click="findUserHasRole();" value="搜索"></td>
                                                    </tr>
                                                </table>
                                                <table class="table table-bordered">
                                                    <tr class="grid-header">
                                                        <td>角色编号</td>
                                                        <td>角色名称</td>
                                                    </tr>
                                                    <tr ng-repeat="hasRole in userHasRoleRelation"
                                                        ng-class="{'current-tr':hasRoleItem.id == hasRole.id}"
                                                        ng-click="choiceHasRoleItem(hasRole)">
                                                        <td ng-bind="hasRole.roleCode"></td>
                                                        <td ng-bind="hasRole.roleName"></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../common/common.jsp"%>
<script type = "text/javascript">
    seajs.use('../../../sm/js/user/userRoleRelation');
</script>
