<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%request.setCharacterEncoding("UTF-8");%>
            <% String message = "I_Love_Java中文";%>
            <%@include file="title.jsp" %>
        </h1>
        <h1>
            ${header["User-Agent"]}
        </h1>
        <h1>
            
            <jsp:include page="salary.jsp?salary=10&salary=20">
                <jsp:param name="message" value="<%=message %>" />
                <jsp:param name="salary" value="40000" />
                <jsp:param name="salary" value="50000" />
            </jsp:include>
            
        </h1>
    </body>
</html>
