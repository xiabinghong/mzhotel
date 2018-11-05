<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<div ng-controller="storehouseActionController" style="align-content: left;">
    <div class="form-element">
        <div class="col-md-12 padding-0">
            <form>
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>仓库管理{{actionName}}</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">区域</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="true" ng-model="storehouse.area">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">房间</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="true" ng-model="storehouse.room">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">物品类型</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="true" ng-model="storehouse.goodsType">
                                    </div>
                                    <%--<div class="col-sm-4">
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">物品类型</button>
                                    </div>--%>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">物品名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="true" ng-model="storehouse.goodsName">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">现有数量</label>
                                    <div class="col-sm-3">
                                        <input type="number" ng-required="true" class="form-control" ng-model="storehouse.amount">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">操作数量</label>
                                    <div class="col-sm-3">
                                        <input ng-if="params.action == 'INNER_STORE'" type="number" min="0" ng-required="true" class="form-control" ng-model="actionLog.amount">
                                        <input ng-if="params.action == 'OUT_STORE'" type="number" min="0" max="{{storehouse.amount}}" ng-required="true" class="form-control" ng-model="actionLog.amount">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">仓库数量</label>
                                    <div class="col-sm-3">
                                        <input ng-if="params.action == 'INNER_STORE'" type="number" ng-required="true" class="form-control" ng-disabled="true" ng-model="actionLog.storeSumAmount">
                                        <input ng-if="params.action == 'OUT_STORE'" type="number" ng-required="true" class="form-control" ng-disabled="true" ng-model="actionLog.storeSumAmount">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center" style="margin:20px;">
                        <input ng-click="save();" class="btn btn-success" type="button" value="保存">
                        <input ng-click="cancel();" class="btn btn-danger" type="button" value="取消">
                        <input ng-click="close();" class="btn btn-warning" type="button" value="关闭">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- end: content -->

<!--弹出复选-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog form-element">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">选择商品类型</h4>
            </div>
            <div class="modal-body form-element-padding">
                <div class="form-group">
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件二 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件二 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件二 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                    <div class="col-sm-3 padding-0">
                        <input type="checkbox" name="option">
                        条件一 </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<%@include file="../common/common.jsp"%>
<script type = "text/javascript">
    seajs.use('../../../sm/js/storeManager/storehouseAction');
</script>
