/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-07 08:57:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.test.test2.dao.MemberDAO;

public final class saveMemberForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/nav.jsp", Long.valueOf(1691396840804L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1691365953801L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.test.test2.dao.MemberDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        * {\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("        }\r\n");
      out.write("        #contents {\r\n");
      out.write("            background-color: burlywood;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");

	MemberDAO memberDAO = new MemberDAO();
	int custno = memberDAO.getCustNo();

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        #header {\r\n");
      out.write("            background-color: dodgerblue;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("    <h1 id=\"title\">쇼핑몰 회원관리</h1>\r\n");
      out.write("</div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        #nav {\r\n");
      out.write("            /*margin-left: 30px;*/\r\n");
      out.write("            background-color: mediumpurple;\r\n");
      out.write("            padding-top: 5px;\r\n");
      out.write("            padding-bottom: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        #nav a {\r\n");
      out.write("            margin-left: 20px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <div id=\"nav\">\r\n");
      out.write("        <a href=\"saveMemberForm.jsp\">회원등록</a>\r\n");
      out.write("        <a href=\"memberList.jsp\">회원목록조회/수정</a>\r\n");
      out.write("        <a href=\"saleList.jsp\">매출조회</a>\r\n");
      out.write("        <a href=\"index.jsp\">홈으로</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1>홈쇼핑 회원 등록</h1>\r\n");
      out.write("\r\n");
      out.write("<form id=\"saveForm\" action=\"saveMember.jsp\" method=\"post\">\r\n");
      out.write("<table>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"custno\">회원번호(자동발생)</label></th>\r\n");
      out.write("		<td>");
      out.print(custno );
      out.write("\r\n");
      out.write("		<input id=\"custno\" type=\"hidden\" name=\"custno\" value=");
      out.print(custno );
      out.write("></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"custname\">회원성명</label></th>\r\n");
      out.write("		<td><input id=\"custname\" type=\"text\" name=\"custname\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"phone\">회원전화</label></th>\r\n");
      out.write("		<td><input id=\"phone\" type=\"text\" name=\"phone\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"address\">회원주소</label></th>\r\n");
      out.write("		<td><input id=\"address\" type=\"text\" name=\"address\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"joindate\">가입일자</label></th>\r\n");
      out.write("		<td><input id=\"joindate\" type=\"date\" name=\"joindate\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"grade\">고객등급(A:VIP, B:일반, C:직원)</label></th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<select id=\"grade\" name=\"grade\">\r\n");
      out.write("				<option value=\"A\">A</option>\r\n");
      out.write("				<option value=\"B\">B</option>\r\n");
      out.write("				<option value=\"C\">C</option>\r\n");
      out.write("			</select>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th><label for=\"city\">도시코드</label> </th>\r\n");
      out.write("		<td><input id=\"city\" type=\"text\" name=\"city\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td><input onclick=\"memberSave()\" type=\"button\" value=\"등록\"><input type=\"button\" value=\"조회\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("	const memberSave = () => {\r\n");
      out.write("		const saveForm = document.querySelector(\"#saveForm\");\r\n");
      out.write("		const custname = document.querySelector(\"#custname\");\r\n");
      out.write("		const phone = document.querySelector(\"#phone\");\r\n");
      out.write("		const address = document.querySelector(\"#address\");\r\n");
      out.write("		const joindate = document.querySelector(\"#joindate\");\r\n");
      out.write("		const grade = document.querySelector(\"#grade\");\r\n");
      out.write("		const city = document.querySelector(\"#city\");\r\n");
      out.write("		if(custname.value == \"\") {\r\n");
      out.write("			alert(\"이름을 입력해주세요\");\r\n");
      out.write("			custname.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else if(phone.value == \"\"){\r\n");
      out.write("			alert(\"번호를 입력해주세요\");\r\n");
      out.write("			phone.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else if(address.value == \"\"){\r\n");
      out.write("			alert(\"주소를 입력해주세요\");\r\n");
      out.write("			address.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else if(joindate.value == \"\"){\r\n");
      out.write("			alert(\"날짜를 입력해주세요\");\r\n");
      out.write("			joindate.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else if(grade.value == \"\"){\r\n");
      out.write("			alert(\"고객등급을 선택해주세요\");\r\n");
      out.write("			grade.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else if(city.value == \"\"){\r\n");
      out.write("			alert(\"도시코드를 입력해주세요\");\r\n");
      out.write("			city.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		} else {\r\n");
      out.write("			alert(\"회원등록이 완료되었습니다.\");\r\n");
      out.write("			saveForm.submit();\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
