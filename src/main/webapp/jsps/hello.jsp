<%-- 
    Document   : hello
    Created on : 2021/6/25, 下午 07:29:44
    Author     : vincenttuan
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.web.job.Lotto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            
    Lotto lotto = new Lotto();
    List list = new ArrayList(lotto.get539());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <h1>
            <%
                out.print(list);
            %>
        </h1>
        
        <%@include file="hello2.jsp"  %>
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>1</th><th>2</th><th>3</th><th>4</th><th>5</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=list.get(0) %></td>
                    <td><%=list.get(1) %></td>
                    <td><%=list.get(2) %></td>
                    <td><%=list.get(3) %></td>
                    <td><%=list.get(4) %></td>
                </tr>
            </tbody>

        </table>

        <%
            out.print(sdf.format(now));
        %>
    </body>
</html>
