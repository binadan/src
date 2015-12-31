package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>智能安防管理系统</title>\r\n");
      out.write("<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(root);
      out.write("/js/jquery-1.3.2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: #1D3647;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t//登陆\r\n");
      out.write("\t\tfunction login(){\r\n");
      out.write("\t\t\tif($.trim($(\"#username\").val())==''){\r\n");
      out.write("\t\t\t\talert(\"请输入账号\");\r\n");
      out.write("\t\t\t\t$(\"#username\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($.trim($(\"#password\").val())==''){\r\n");
      out.write("\t\t\t\talert(\"请输入密码\");\r\n");
      out.write("\t\t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar data= $(\"#loginForm\").serialize();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.post(\"");
      out.print(root);
      out.write("/login\",data,function(resultData){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t  \t\tvar result = eval(eval(\"(\"+resultData+\")\"));\r\n");
      out.write("\t\t  \t\tif(result==1){\r\n");
      out.write("\t\t  \t\t\twindow.location.href=\"");
      out.print(root);
      out.write("/index.jsp\";\r\n");
      out.write("\t\t  \t\t}else if(result==2){\r\n");
      out.write("\t\t  \t\t\talert(\"账号错误，请重新输入！\");\r\n");
      out.write("\t\t  \t\t\t$(\"#username\").focus();\r\n");
      out.write("\t\t  \t\t\t//$(\"#username\").select();\r\n");
      out.write("\t\t  \t\t}else if(result==3){\r\n");
      out.write("\t\t  \t\t\talert(\"账号错误\");\r\n");
      out.write("\t\t  \t\t\t$(\"#username\").focus();\r\n");
      out.write("\t\t  \t\t\t//$(\"#username\").select();\r\n");
      out.write("\t\t  \t\t}else if(result==4){\r\n");
      out.write("\t\t  \t\t\talert(\"密码错误\");\r\n");
      out.write("\t\t  \t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t  \t\t\t//$(\"#password\").select();\r\n");
      out.write("\t\t  \t\t}else if(result==5){\r\n");
      out.write("\t\t  \t\t\talert(\"用户帐号已失效\");\r\n");
      out.write("\t\t  \t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t  \t\t\t//$(\"#password\").select();\r\n");
      out.write("\t\t  \t\t}\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//页面回车事件\r\n");
      out.write("\t\tdocument.onkeydown=function(event){            \r\n");
      out.write("\t\t\tvar e = event || window.event || arguments.callee.caller.arguments[0];            \r\n");
      out.write("  \t\t  \tif(e && e.keyCode==27){ \r\n");
      out.write("  \t\t\t  // 按 Esc                 //要做的事情              \r\n");
      out.write("  \t\t  \t}            \r\n");
      out.write("  \t\t  \tif(e && e.keyCode==113){ \r\n");
      out.write("  \t\t\t  // 按 F2                  //要做的事情               \r\n");
      out.write("  \t\t  \t}                         \r\n");
      out.write("  \t\t  \tif(e && e.keyCode==13){ \r\n");
      out.write("  \t\t\t  // enter 键                 //要做的事情      \r\n");
      out.write("  \t\t\t\tlogin();\r\n");
      out.write("\t\t\t}        \r\n");
      out.write("  \t\t}; \r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" height=\"166\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"42\" valign=\"top\"><table width=\"100%\" height=\"42\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_top_bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"1%\" height=\"21\">&nbsp;</td>\r\n");
      out.write("        <td height=\"42\">&nbsp;</td>\r\n");
      out.write("        <td width=\"17%\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\"><table width=\"100%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"49%\" align=\"right\"><table width=\"91%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg2\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"138\" valign=\"top\"><table width=\"89%\" height=\"427\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"149\">&nbsp;</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"80\" align=\"right\" valign=\"top\"><img src=\"images/logo/logo.png\" width=\"279\" height=\"68\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"198\" align=\"right\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                   \r\n");
      out.write("                  </table></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
      out.write("        </table></td>\r\n");
      out.write("        <td width=\"1%\" >&nbsp;</td>\r\n");
      out.write("        <td width=\"50%\" valign=\"bottom\"><table width=\"100%\" height=\"59\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"4%\">&nbsp;</td>\r\n");
      out.write("              <td width=\"96%\" height=\"38\"><span class=\"login_txt_bt\">智能安防管理系统</span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td height=\"21\"><table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" id=\"table211\" height=\"328\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td height=\"164\" colspan=\"2\" align=\"middle\">\r\n");
      out.write("                    \t<form name=\"myform\" action=\"\" method=\"post\" id=\"loginForm\">\r\n");
      out.write("                        <table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" height=\"143\" id=\"table212\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"38\" class=\"top_hui_text\"><span class=\"login_txt\">帐 号：&nbsp;&nbsp; </span></td>\r\n");
      out.write("                            <td height=\"38\" colspan=\"2\" class=\"top_hui_text\">\r\n");
      out.write("                            \t<input id=\"username\" name=\"username\" class=\"editbox4\" value=\"\" size=\"20\">      \r\n");
      out.write("                            </td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"35\" class=\"top_hui_text\"><span class=\"login_txt\"> 密 码： &nbsp;&nbsp; </span></td>\r\n");
      out.write("                            <td height=\"35\" colspan=\"2\" class=\"top_hui_text\">\r\n");
      out.write("                            \t<input id=\"password\" class=\"editbox4\" type=\"password\" size=\"20\" name=\"password\" value=\"\">\r\n");
      out.write("<!--                              \t<img src=\"images/luck.gif\" width=\"19\" height=\"18\">  -->\r\n");
      out.write("                            </td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                         \r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td height=\"35\" >&nbsp;</td>\r\n");
      out.write("                            <td width=\"20%\" height=\"35\" >\r\n");
      out.write("                            \t<input name=\"Submit\" type=\"button\" class=\"button\" id=\"Submit\" value=\"登 陆\" onclick=\"login()\"> \r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td width=\"67%\" class=\"top_hui_text\"><input name=\"cs\" type=\"reset\" class=\"button\" id=\"cs\" value=\"取 消\" ></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                        <br>\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"433\" height=\"164\" align=\"right\" valign=\"bottom\"><img src=\"images/login-wel.gif\" width=\"242\" height=\"138\"></td>\r\n");
      out.write("                    <td width=\"57\" align=\"right\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"20\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"login-buttom-bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"center\"><span class=\"login-buttom-txt\"></span></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
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
