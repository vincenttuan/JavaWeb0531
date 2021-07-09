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
            <my:bmi h="170" w="60" />
        </h1>
        <h1>
            <my:bmi h="170.0" w="60.0" result="true" />
        </h1>
        <h1>
            <my:bmi h="170.0" w="60.0" result="false" />
        </h1>
    </body>
</html>
