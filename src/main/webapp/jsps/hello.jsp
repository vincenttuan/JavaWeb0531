<%-- 
    Document   : hello
    Created on : 2021/6/25, 下午 07:29:44
    Author     : vincenttuan
--%>

<%@page import="com.web.job.Lotto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                Lotto lotto = new Lotto();
                out.print(lotto.get539());
            %>
        </h1>
        <%
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            out.print(sdf.format(now));
            
        %>
    </body>
</html>
