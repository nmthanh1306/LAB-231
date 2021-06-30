package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class body_002dleft_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"left wrapper-body\">\n");
      out.write("            <div class=\"main-image\">\n");
      out.write("                <a id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${photographer.feature_Image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" onclick=\"show()\" >\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${photographer.feature_Image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\">\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"image-caption\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${photographer.title_Feature_Image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <div class=\"list-gallery\">\n");
      out.write("                    <ul class=\"column-gallery\">\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"about-me\">\n");
      out.write("                <div class=\"title\">\n");
      out.write("                    <h3 class=\"font-title\">\n");
      out.write("                        About Me\n");
      out.write("                    </h3>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <p>\n");
      out.write("                        <span>\n");
      out.write("                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit, \n");
      out.write("                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore \n");
      out.write("                            magna aliquam erat volutpat. Ut wisi enim ad minim veniam,\n");
      out.write("                            quis nostrud exerci tation ullamcorper suscipit lobortis \n");
      out.write("                            nisl ut aliquip ex ea commodo consequat. Duis autem vel eum \n");
      out.write("                            iriure dolor in hendrerit in vulputate velit esse molestie consequat,\n");
      out.write("                            vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan \n");
      out.write("                            et iusto odio dignissim qui blandit praesent luptatum zzril delenit\n");
      out.write("                            augue duis dolore te feugait nulla facilisi. Nam liber tempor cum \n");
      out.write("                            soluta nobis eleifend option congue nihil imperdiet doming id quod mazim    \n");
      out.write("                        </span>\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"fancybox\" class=\"fancybox-overlay fancybox-overlay-fixed\" style=\"width: auto; height: auto; display: none\">\n");
      out.write("            <div class=\"fancybox-wrap fancybox-desktop fancybox-type-image fancybox-opened\" tabindex=\"-1\" \n");
      out.write("                 style=\"width: auto; height: auto; position: absolute; top: 100px; left: 350px; opacity: 1; overflow: visible; display: block;\">\n");
      out.write("                <div class=\"fancybox-skin\" style=\"padding: 15px; width: auto; height: auto;\">\n");
      out.write("                    <div class=\"fancybox-outer\">\n");
      out.write("                        <div class=\"fancybox-inner\" style=\"overflow: visible; width: 650px; height: 450px;\">\n");
      out.write("                            <img class=\"fancybox-image\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${photographer.feature_Image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"fancybox-title fancybox-title-inside-wrap\">\n");
      out.write("                        Transparence (delphine.cury)\n");
      out.write("                    </div>\n");
      out.write("                    <a onclick=\"show()\" title=\"Close\" class=\"fancybox-item fancybox-close\" href=\"javascript:;\">\n");
      out.write("                        X\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function show() {\n");
      out.write("        var isShow = document.getElementById('fancybox');\n");
      out.write("        if (isShow.style.display === \"block\") {\n");
      out.write("            isShow.style.display = \"none\";\n");
      out.write("        } else {\n");
      out.write("            isShow.style.display = \"block\";\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function close() {\n");
      out.write("        document.getElementById('fancybox').style.display = \"block\";\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    //Image transfer function\n");
      out.write("    function imageOnClick(image) {\n");
      out.write("        document.getElementById(\"feature-image\").src = image;\n");
      out.write("    }\n");
      out.write("</script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listGallery}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("g");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <li class=\"span4\">\n");
          out.write("                                <div class=\"zoom\">\n");
          out.write("                                    <a onclick=\"show()\">\n");
          out.write("                                        <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${g.main_image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\n");
          out.write("                                    </a>\n");
          out.write("                                </div>\n");
          out.write("                                <h4>\n");
          out.write("                                    <a href=\"gallery?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${g.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"font-title\"> View ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${g.gallery_title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a> \n");
          out.write("                                </h4>\n");
          out.write("                                <p>\n");
          out.write("                                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${g.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                </p>\n");
          out.write("                            </li>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
