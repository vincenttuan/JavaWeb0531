<%@page import="java.util.Random"%>
<%@page isThreadSafe="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    int n = -1;
    public void jspInit() {
        n = new Random().nextInt(100);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=n %></h1>
        <% Thread.sleep(3000); %>
    </body>
</html>
