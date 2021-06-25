<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                int n = new Random().nextInt(100);
                if (n % 2 == 0) {
                    out.print(n);
                } else {
                    throw new Exception(n + "不是偶數");
                }
            %>
        </h1>
    </body>
</html>
