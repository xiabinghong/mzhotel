<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="storeManagerController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel form-element-padding">
                <div style="padding-bottom:20px;">
                    <div class="form-group">
                        <label class="col-sm-1 control-label text-right">所属区域</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name ="area" ng-model="query.area">
                        </div>
                        <label class="col-sm-1 control-label text-right">所属房间</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name ="room" ng-model="query.room">
                        </div>
                        <label class="col-sm-1 control-label text-right">物品名称</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name ="goodsName" ng-model="query.goodsName">
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
                    <btn-download download-params="query" download-href="/mzhotel/storehouse/export" btn-text="导出"></btn-download>
                    <input class="btn btn-info" type="button" ng-click="innerStore(choiceItem)" value="入库">
                    <input class="btn btn-info" type="button" ng-click="outStore(choiceItem)" value="出库">
                    <input class="btn btn-info" type="button" ng-click="storeLog(choiceItem)" value="出入库记录">
                </div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;border:0px;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>所属区域</td>
                                            <td>所属房间</td>
                                            <td>物品类型</td>
                                            <td>物品名称</td>
                                            <td>图片</td>
                                            <td>数量</td>
                                            <td>单位</td>
                                            <td>创建人</td>
                                            <td>创建时间</td>
                                            <td>修改人</td>
                                            <td>修改时间</td>
                                        </tr>
                                        <tr align="center" ng-show="storehouseManagerList"
                                            ng-repeat="list in storehouseManagerList"
                                            ng-class="{'current-tr':choiceItem.id == list.id}"
                                            ng-click="choiceViewItem(list)"
                                            ng-dblclick="view(list)"
                                            data-ng-dbclick="choiceViewItem(list)">
                                            <td ng-bind="$index+1"></td>
                                            <td ng-bind="list.area"></td>
                                            <td ng-bind="list.room"></td>
                                            <td ng-bind="list.goodsType"></td>
                                            <td ng-bind="list.goodsName"></td>
                                            <td><img ng-if="list.saveName && list.saveName != null" width="40px" height="20px" src="<%=request.getContextPath()%>\sm\upload\image\{{list.saveName}}" /></td>
                                            <td ng-bind="list.amount"></td>
                                            <td ng-bind="list.unit"></td>
                                            <td ng-bind="list.createdName"></td>
                                            <td ng-bind="list.createdDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
                                            <td ng-bind="list.updatedName"></td>
                                            <td ng-bind="list.updatedDate | date:'yyyy-MM-dd HH:mm:ss'"></td>
                                        </tr>
                                    </table>
                                    <div ng-show="!storehouseManagerList || storehouseManagerList.length == 0">未查询到相关数据</div>
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
    seajs.use('../../../sm/js/storeManager/storeManagerList');
</script>
