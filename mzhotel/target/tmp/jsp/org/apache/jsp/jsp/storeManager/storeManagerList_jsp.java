package org.apache.jsp.jsp.storeManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class storeManagerList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>XXXXXX</title>\r\n");
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
      out.write("<div ng-app=\"storeManagerApp\" ng-controller=\"storeManagerController\">\r\n");
      out.write("    <div class=\"col-md-12 padding-0 form-element\">\r\n");
      out.write("        <div class=\"col-md-12\">\r\n");
      out.write("            <div class=\"panel form-element-padding\">\r\n");
      out.write("                <div style=\"padding-bottom:20px;\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label class=\"col-sm-1 control-label text-right\">物品类别</label>\r\n");
      out.write("                        <div class=\"col-sm-2\">\r\n");
      out.write("                            <select class=\"form-control\" ng-model=\"query.goodsType\">\r\n");
      out.write("                                <option>option one</option>\r\n");
      out.write("                                <option>option two</option>\r\n");
      out.write("                                <option>option three</option>\r\n");
      out.write("                                <option>option four</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <label class=\"col-sm-1 control-label text-right\" ng-model=\"query.goodsName\">物品名称</label>\r\n");
      out.write("                        <div class=\"col-sm-2\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-sm-2\">\r\n");
      out.write("                            <input class=\"btn btn-info\" type=\"button\" ng-click=\"init();\" value=\"搜索\">\r\n");
      out.write("                            <input class=\"btn btn-danger\" type=\"button\" ng-click=\"reset()\" value=\"重置\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"panel\">\r\n");
      out.write("                <div align=\"right\" style=\"padding-top: 10px;\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"add();\" value=\"新增\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"view();\" value=\"查看\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"delete()\" value=\"删除\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"export()\" value=\"导出\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"innerStore()\" value=\"入库\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"outStore()\" value=\"出库\">\r\n");
      out.write("                    <input class=\"btn btn-info\" type=\"button\" ng-click=\"storeLog()\" value=\"出入库记录\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel-body\">\r\n");
      out.write("                    <div class=\"responsive-table\">\r\n");
      out.write("                        <div id=\"datatables-example_wrapper\" class=\"dataTables_wrapper form-inline dt-bootstrap no-footer\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <div class=\"col-sm-12\">\r\n");
      out.write("                                    <table cellspacing=\"0\" style=\"width: 100%;\">\r\n");
      out.write("                                        <tr align=\"center\">\r\n");
      out.write("                                            <td>序号</td>\r\n");
      out.write("                                            <td>所属区域</td>\r\n");
      out.write("                                            <td>所属房间</td>\r\n");
      out.write("                                            <td>物品类型</td>\r\n");
      out.write("                                            <td>物品名称</td>\r\n");
      out.write("                                            <td>图片</td>\r\n");
      out.write("                                            <td>数量</td>\r\n");
      out.write("                                            <td>创建人</td>\r\n");
      out.write("                                            <td>创建时间</td>\r\n");
      out.write("                                            <td>修改人</td>\r\n");
      out.write("                                            <td>修改时间</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr align=\"center\" ng-show=\"storehouseList\" ng-repeat=\"list in storehouseManagerList\">\r\n");
      out.write("                                            <td ng-bind=\"#index\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.area\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.room\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.goodsType\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.goodsName\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.img\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.amount\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.createdByName\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.createdDate\"><td>\r\n");
      out.write("                                            <td ng-bind=\"list.updatedByName\"></td>\r\n");
      out.write("                                            <td ng-bind=\"list.updateByDate\"></td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/html5shiv.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/respond.min.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
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
      out.write("/js/storeManager/storeManagerList.js\"></script>\r\n");
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
