package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class right_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write('\r');
      out.write('\n');
String root=request.getContextPath();
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=uft-8\" /><style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: #EEF2FB;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<SCRIPT language=javascript>\r\n");
      out.write("\tfunction secBoard(n)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tfor(i=0;i<secTable.cells.length;i++)\r\n");
      out.write("\t\t\t\tsecTable.cells[i].className=\"sec1\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tsecTable.cells[n].className=\"sec2\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfor(i=0;i<mainTable.tBodies.length;i++)\r\n");
      out.write("\t\t\t\tmainTable.tBodies[i].style.display=\"none\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tmainTable.tBodies[n].style.display=\"block\";\r\n");
      out.write("\t\t}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("          \t\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"17\" valign=\"top\" background=\"images/mail_leftbg.gif\">\r\n");
      out.write("    \t<img src=\"images/left-top-right.gif\" width=\"17\" height=\"29\" />\r\n");
      out.write("    </td>\r\n");
      out.write("    <td valign=\"top\" background=\"images/content-bg.gif\">\r\n");
      out.write("    \t<table width=\"100%\" height=\"31\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left_topbg\" id=\"table2\">\r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("        \t\t<td height=\"31\" ><div class=\"titlebt\">欢迎界面</div></td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td width=\"16\" valign=\"top\" background=\"images/mail_rightbg.gif\">\r\n");
      out.write("    \t<img src=\"images/nav-right-bg.gif\" width=\"16\" height=\"29\" />\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"middle\" background=\"images/mail_leftbg.gif\">&nbsp;</td>\r\n");
      out.write("    <td valign=\"top\" bgcolor=\"#F7F8F9\" style=\"min-height: 400px;\">\r\n");
      out.write("   \t\t<iframe style=\"margin-top:10px; border:solid 1px #6495ED; width: 98%\" name=\"weather_inc\" src=\"http://cache.xixik.com.cn/2/xian/\" height=\"100\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\"></iframe>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div style=\"border:solid 1px #7ec8ea;width: 98%; margin-top: 10px;height: 280px;padding-top: 10px; \">\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t</div>\r\n");
      out.write("\t\r\n");
      out.write("    </td>\r\n");
      out.write("    <td background=\"images/mail_rightbg.gif\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"bottom\" background=\"images/mail_leftbg.gif\"><img src=\"images/buttom_left2.gif\" width=\"17\" height=\"17\" /></td>\r\n");
      out.write("    <td background=\"images/buttom_bgs.gif\"><img src=\"images/buttom_bgs.gif\" width=\"17\" height=\"17\"></td>\r\n");
      out.write("    <td valign=\"bottom\" background=\"images/mail_rightbg.gif\"><img src=\"images/buttom_right2.gif\" width=\"16\" height=\"17\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            \t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
