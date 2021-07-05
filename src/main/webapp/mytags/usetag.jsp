<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.scwcd" prefix="my"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:required /></h1>
        <h1><my:greet /></h1>
        <h1><my:greet user="vincent" /></h1>
        <h1><my:greet user="vincent ${ 1+2 }" /></h1>
        <h1>
            <my:if condition="<%=new Date().getTime() % 2 == 0%>">
                現在時間：<%=new Date()%>
            </my:if>
        </h1>
        <h1>
            <my:loop count="3">
                Java
            </my:loop>
        </h1>
        <hr />
        <my:mark search="s">
            she sell sea shore on the sea shore
        </my:mark>
        <hr />
        <h1>
            <my:implicit attributeName="authCode" scopeName="session" />
        </h1>
        
    </body>
</html>
