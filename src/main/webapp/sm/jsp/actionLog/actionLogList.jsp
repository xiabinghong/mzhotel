<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="actionLogController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel">
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;border:0px;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>操作类型</td>
                                            <td>数量</td>
                                            <td>时间</td>
                                            <td>操作人</td>
                                        </tr>
                                        <tr align="center" ng-show="actionLogList"
                                            ng-repeat="list in actionLogList"
                                            ng-class="{'current-tr':choiceItem.id == list.id}">
                                            <td ng-bind="$index+1"></td>
                                            <td ng-bind="list.actionTypeDesc"></td>
                                            <td ng-bind="list.amount"></td>
                                            <td ng-bind="list.actionDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
                                            <td ng-bind="list.actionUserName"></td>
                                        </tr>
                                    </table>
                                    <div ng-show="!actionLogList || actionLogList.length == 0">未查询到相关数据</div>
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
    seajs.use('../../../sm/js/actionLog/actionLogList');
</script>