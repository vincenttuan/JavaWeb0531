<%@page import="java.util.Random" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--

<% %> scriptlet 配置在 _jspService()內 

<%= %> expression 配置在 _jspService()內 ex: out.print(1+1);

<%! %> declare 物件變數, 方法 配置在 _jspService()外

--%>
<% int x = 100;%>
<%! int x = 200;%>

<%=x %>
<%=this.x %>
<% out.println(getLotto()); %>

<%!
    int getLotto() {
        return new Random().nextInt(100);
    }
%>