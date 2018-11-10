<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="resourceListController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel form-element-padding">
                <div style="padding-bottom:20px;">
                    <div class="form-group">
                        <label class="col-sm-1 control-label text-right">资源类型</label>
                        <div class="col-sm-2">
                            <select class="form-control" ng-model="query.resourceType" name="resourceType">
                                <option  align="center" ng-show="resourceList"
                                         ng-repeat="list in resourceList"
                                         ng-class="{'current-tr':choiceItem.id == list.id}"
                                         ng-click="choiceViewItem(list)"
                                         ng-dblclick="view(list)"
                                         data-ng-dbclick="choiceViewItem(list)" ng-bind="list.resourceType"> </option>

                            </select>
                        </div>
                        <label class="col-sm-1 control-label text-right">资源名称</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name ="resourceName" ng-model="query.resourceName">
                        </div>
                        <div class="col-sm-2">
                            <input class="btn btn-info" btn-loading="queryBtnLoading" type="button" ng-click="init();" value="搜索">
                            <input class="btn btn-danger" type="button" ng-click="reset();" value="重置">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel">
                <div align="right" style="padding-top: 10px;">
                    <input class="btn btn-info" type="button" ng-click="add();" value="新增">
                    <input class="btn btn-info" type="button" ng-click="view(choiceItem);" value="查看">
                    <input class="btn btn-info" type="button" ng-click="delete(choiceItem)" value="删除">
                </div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;border:0px;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>资源名称</td>
                                            <td>资源编号</td>
                                            <td>资源类型</td>
                                            <td>创建人</td>
                                            <td>创建时间</td>
                                        </tr>
                                        <tr align="center" ng-show="resourceList"
                                            ng-repeat="list in resourceList"
                                            ng-class="{'current-tr':choiceItem.id == list.id}"
                                            ng-click="choiceViewItem(list)"
                                            ng-dblclick="view(list)"
                                            data-ng-dbclick="choiceViewItem(list)">
                                            <td ng-bind="$index+1"></td>
                                            <td ng-bind="list.resourceName"></td>
                                            <td ng-bind="list.resourceCode"></td>
                                            <td ng-bind="list.resourceType"></td>
                                            <td ng-bind="list.createdBy"></td>
                                            <td ng-bind="list.createdDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
                                        </tr>
                                    </table>
                                    <div ng-show="!resourceList || resourceList.length == 0">未查询到相关数据</div>
                                    <div class="widget-toolbar">
                                        <ug-pagination page-info="pageSetting" load-parameter="query"></ug-pagination>
                                    </div>
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
    seajs.use('../../../sm/js/resource/resourceList');
</script>
