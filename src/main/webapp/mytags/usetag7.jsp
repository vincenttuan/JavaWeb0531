<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/tlds/mytld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>
            <my:lotto count="5">
                <%=new Random().nextInt(100)+1  %>
            </my:lotto>
        </h1>
        
    </body>
</html>
