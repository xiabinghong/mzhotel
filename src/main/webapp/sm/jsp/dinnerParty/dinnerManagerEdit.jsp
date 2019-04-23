<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header_inner.jsp"%>
<body>
    <div ng-controller="dinnerPartyEditController" style="align-content: center;">
        <div class="form-element">
            <div class="col-md-12 padding-0">
                <form>
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>宴会详情</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">类别</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.dinnerType">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">用户</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.linkUser">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">联系方式</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.tel">
                                    </div>
                                    <%--<div class="col-sm-4">
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">物品类型</button>
                                    </div>--%>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">消费项目</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.dinnerProject">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">备注</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.remark">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center" style="margin:20px;">
                        <shiro:hasPermission name="PARTY_INFO_OPERATE:BUTTON:EDIT">
                            <input ng-show="pageSetting.disabled" ng-click="edit();" class="btn btn-success"
                                   type="button" value="修改">
                        </shiro:hasPermission>
                        <input ng-show="!pageSetting.disabled" ng-click="save();" class="btn btn-success" type="button"
                               value="保存">
                        <input ng-show="!pageSetting.disabled" ng-click="cancel();" class="btn btn-danger" type="button"
                               value="取消">
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
</body>
<%@include file="../common/common.jsp"%>
<script type = "text/javascript">
    seajs.use('../../../sm/js/dinnerManager/dinnerManagerEdit');
</script>