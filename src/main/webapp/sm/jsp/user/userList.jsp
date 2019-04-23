<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="userListController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel form-element-padding">
                <div style="padding-bottom:20px;">
                    <div class="form-group">
                        <label class="col-sm-1 control-label text-right">用户名称</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name ="username" ng-model="query.username">
                        </div>
                        <div class="col-sm-2">
                            <input class="btn btn-info" type="button" ng-click="init();" value="搜索">
                            <input class="btn btn-danger" type="button" ng-click="reset();" value="重置">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel">
                <div align="right" style="padding-top: 10px;">
                    <shiro:hasPermission name="USER_OPERATE:BUTTON:NEW">
                        <input class="btn btn-info" type="button" ng-click="add();" value="新增">
                    </shiro:hasPermission>
                    <input class="btn btn-info" type="button" ng-click="view(choiceItem);" value="查看">
                    <input class="btn btn-info" type="button" ng-click="assigneRole(choiceItem);" value="分配角色">
                    <shiro:hasPermission name="USER_OPERATE:BUTTON:DELETE">
                        <input class="btn btn-info" type="button" ng-click="delete(choiceItem)" value="删除">
                    </shiro:hasPermission>
                </div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>账号</td>
                                            <td>用户名称</td>
                                            <td>联系方式</td>
                                            <td>地址</td>
                                            <td>状态</td>
                                            <td>创建人</td>
                                            <td>创建时间</td>
                                        </tr>
                                        <tr align="center" ng-show="userList"
                                            ng-repeat="list in userList"
                                            ng-class="{'current-tr':choiceItem.id == list.id}"
                                            ng-click="choiceViewItem(list)"
                                            ng-dblclick="view(list)"
                                            data-ng-dbclick="choiceViewItem(list)">
                                            <td ng-bind="$index+1"></td>
                                            <td ng-bind="list.userId"></td>
                                            <td ng-bind="list.username"></td>
                                            <td ng-bind="list.tel"></td>
                                            <td ng-bind="list.address"></td>
                                            <td ng-bind="list.state"></td>
                                            <td ng-bind="list.createdBy"></td>
                                            <td ng-bind="list.createdDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/common.jsp"%>
<script type = "text/javascript">
    seajs.use('../../../sm/js/user/userList');
</script>
