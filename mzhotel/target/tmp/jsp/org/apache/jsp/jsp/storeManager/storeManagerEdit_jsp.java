package org.apache.jsp.jsp.storeManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class storeManagerEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"description\" content=\"12\">\r\n");
      out.write("    <meta name=\"author\" content=\"12\">\r\n");
      out.write("    <meta name=\"keyword\" content=\"12\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>明珠酒店仓库管理</title>\r\n");
      out.write("    <!-- start: Css -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- plugins -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/font-awesome.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/simple-line-icons.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/animate.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/fullcalendar.min.css\"/>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- end: Css -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div ng-app=\"storehouseEditApp\" ng-controller=\"storehouseEditController\" style=\"align-content: left;\">\r\n");
      out.write("        <div class=\"form-element\">\r\n");
      out.write("            <div class=\"col-md-12 padding-0\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"panel form-element-padding\">\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                            <h4>基本表单</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"panel-body\" style=\"padding-bottom:10px;\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label text-right\">区域</label>\r\n");
      out.write("                                    <div class=\"col-sm-3\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" ng-disabled=\"pageSetting.ng-disabled\" ng-model=\"storehouse.area\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label text-right\">房间</label>\r\n");
      out.write("                                    <div class=\"col-sm-3\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" ng-disabled=\"pageSetting.ng-disabled\" ng-model=\"storehouse.room\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label text-right\">物品类型</label>\r\n");
      out.write("                                    <div class=\"col-sm-3\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" ng-disabled=\"pageSetting.ng-disabled\" ng-model=\"storehouse.goodsType\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label text-right\">物品名称</label>\r\n");
      out.write("                                    <div class=\"col-sm-3\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" ng-ng-disabled=\"pageSetting.ng-disabled\" ng-model=\"storehouse.goodsName\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label text-right\">数量</label>\r\n");
      out.write("                                    <div class=\"col-sm-3\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" ng-disabled=\"pageSetting.ng-disabled\" ng-model=\"storehouse.amount\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label text-right\">描述</label>\r\n");
      out.write("                                    <div class=\"col-sm-11\">\r\n");
      out.write("                                        <input type=\"text\" maxlength=\"300\" class=\"form-control\" ng-disabled=\"pageSetting.ng-disabled\" ng-model=\"storehouse.remark\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                ");
      out.write("\r\n");
      out.write("                                ");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-12 text-center\" style=\"margin:20px;\">\r\n");
      out.write("                        <input ng-click=\"save();\" class=\"btn btn-success\" type=\"button\" value=\"保存\">\r\n");
      out.write("                        <input ng-click=\"cancel();\" class=\"btn btn-danger\" type=\"button\" value=\"取消\">\r\n");
      out.write("                        <input ng-click=\"close();\" class=\"btn btn-warning\" type=\"button\" value=\"关闭\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- end: content -->\r\n");
      out.write("\r\n");
      out.write("    <!--弹出复选-->\r\n");
      out.write("    <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog form-element\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                    <h4 class=\"modal-title\" id=\"myModalLabel\">选择商品类型</h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body form-element-padding\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件二 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件二 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件二 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                        <div class=\"col-sm-3 padding-0\">\r\n");
      out.write("                            <input type=\"checkbox\" name=\"option\">\r\n");
      out.write("                            条件一 </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\">提交更改</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.modal-content -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.modal -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/html5shiv.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("<!-- start: Javascript -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.ui.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- plugins -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/plugins/jquery.nicescroll.js\"></script>\r\n");
      out.write("<!-- custom -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/main.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/tools/angularjs4.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/storeManager/storeManagerEdit.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
