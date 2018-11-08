<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="personalReservationController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel form-element-padding">
                <div style="padding-bottom:20px;">
                    <div class="form-group">
                        <label class="col-sm-1 control-label text-right">区域</label>
                        <div class="col-sm-2">
                            <select class="form-control" ng-model="query.area" name="area">
                                <option>option one</option>
                                <option>option two</option>
                                <option>option three</option>
                                <option>option four</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label text-right" name ="dinnerTimeCode" ng-model="query.dinnerTimeCode">用餐时间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control">
                        </div>
                        <label class="col-sm-1 control-label text-right" name ="contactUser" ng-model="query.contactUser">用户</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control">
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

                    <btn-download download-params="query" download-href="/mzhotel/personalreservation/export" btn-text="导出"></btn-download>
                    <%--<input class="btn btn-info" type="button" ng-click="export()" value="导出">--%>
                    <input class="btn btn-info" type="button" ng-click="statusIn(choiceItem)" value="已入住">
                    <input class="btn btn-info" type="button" ng-click="statusCancel(choiceItem)" value="已取消">
                   
                </div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;border:0px;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>区域</td>
                                            <td>房间</td>
                                            <td>用户</td>
                                            <td>用餐时间</td>
                                            <td>联系方式</td>
                                            <td>订台人</td>
                                            <td>操作人</td>
                                            <td>状态</td>
                                            <td>创建人</td>
                                            <td>创建时间</td>
                                        </tr>
                                        <tr align="center" ng-show="personalReservationManagerList"
                                            ng-repeat="list in personalReservationManagerList"
                                            ng-class="{'current-tr':choiceItem.id == list.id}"
                                            ng-click="choiceViewItem(list)"
                                            ng-dblclick="view(list)"
                                            data-ng-dbclick="choiceViewItem(list)">
                                            <td ng-bind="$index+1"></td>
                                            <td ng-bind="list.area"></td>
                                            <td ng-bind="list.roomCode"></td>
                                            <td ng-bind="list.contactUser"></td>
                                            <td ng-bind="list.dinnerTimeCode"></td>
                                            <td ng-bind="list.tel"></td>
                                            <td ng-bind="list.manager"></td>
                                            <td ng-bind="list.tablenum"></td>
                                            <td ng-bind="list.status"></td>
                                            <td ng-bind="list.createdName"></td>
                                            <td ng-bind="list.createdDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
                                        </tr>
                                    </table>
                                    <div ng-show="!personalReservationManagerList || personalReservationManagerList.length == 0">未查询到相关数据</div>
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
    seajs.use('../../../sm/js/personalManager/personalManagerList');
</script>
