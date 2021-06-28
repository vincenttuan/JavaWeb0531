<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <% String message = "看到 message 了";%>
            <%@include file="title.jsp" %>
        </h1>
        <h1>
            <jsp:include page="salary.jsp?x=100" />
        </h1>
    </body>
</html>
