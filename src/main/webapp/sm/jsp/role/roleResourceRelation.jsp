<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="roleResourceRelationController" style="align-content: center;">
    <div class="form-element">
        <div class="col-md-12 padding-0">
            <form>
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>分配资源</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <table width="100%">
                                <tr>
                                    <td valign="top" style="width:35%;">
                                        <div class="widget-box">
                                            <h5>可分配资源</h5>
                                        </div>
                                        <div class="widget-content">
                                            <table>
                                                <tr>
                                                    <td>名称</td>
                                                    <td><input type="text" ng-model="query.notHasResourceName"></td>
                                                    <td><input class="btn btn-info" type="button" ng-click="findRoleNotHasResource();" value="搜索"></td>
                                                </tr>
                                            </table>
                                            <table class="table table-bordered">
                                                <tr class="grid-header">
                                                    <td>资源编号</td>
                                                    <td>资源名称</td>
                                                    <td>资源类型</td>
                                                </tr>
                                                <tr ng-repeat="notHasResource in roleNotHasResource"
                                                    ng-class="{'current-tr':notHasResourceItem.resourceCode == notHasResource.resourceCode}"
                                                    ng-click="choiceNotHasResourceItem(notHasResource)">
                                                    <td ng-bind="notHasResource.resourceCode"></td>
                                                    <td ng-bind="notHasResource.resourceName"></td>
                                                    <td ng-bind="notHasResource.resourceTypeName"></td>
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
                                    <td valign="top" style="width:55%;">
                                        <div class="widget-box">
                                            <div class="widget-title">
                                                <h5>已分配资源</h5>
                                            </div>
                                            <div class="widget-content">
                                                <table>
                                                    <tr>
                                                        <td>名称</td>
                                                        <td><input type="text" ng-model="query.hasResourceName"></td>
                                                        <td><input class="btn btn-info" type="button" ng-click="findRoleHasResource();" value="搜索"></td>
                                                    </tr>
                                                </table>
                                                <table class="table table-bordered">
                                                    <tr class="grid-header">
                                                        <td>资源编号</td>
                                                        <td>资源名称</td>
                                                        <td>资源类型</td>
                                                        <td>操作</td>
                                                    </tr>
                                                    <tr ng-repeat="hasResource in roleHasResource"
                                                        ng-class="{'current-tr':hasResourceItem.resourceCode == hasResource.resourceCode}"
                                                        ng-click="choiceHasResourceItem(hasResource)">
                                                        <td ng-bind="hasResource.resourceCode"></td>
                                                        <td ng-bind="hasResource.resourceName"></td>
                                                        <td ng-bind="hasResource.resourceTypeName"></td>
                                                        <td>
                                                            <span ng-repeat="action in hasResource.actionEntity">
                                                                <input id="{{hasResource.resourceCode+$index}}" type="checkbox" name="hasResource.resourceCode" ng-checked="action.isActioned==true" ng-model="action.isActioned" ng-change="permission(hasResource,action)" ng-disabled="action.action=='VIEW' || hasResource.resourceType=='ENUM'"/>
                                                                <label for="{{hasResource.resourceCode+$index}}" ng-bind="action.label"></label>
                                                            </span>
                                                        </td>
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
    seajs.use('../../../sm/js/role/roleResourceRelation');
</script>
