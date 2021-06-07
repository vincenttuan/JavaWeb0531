<%-- 
    Document   : calcAreaResult
    Created on : 2021/6/7, 下午 08:25:27
    Author     : vincenttuan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>計算<%=request.getAttribute("typeName") %>結果</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend style="color: #005100">計算<%=request.getAttribute("typeName") %>結果</legend>
                半徑：<font color="#0000ff"><%=request.getAttribute("r") %></font><br />
                結果：<font color="#ff0000"><%=request.getAttribute("result") %></font><p />
                <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
            </fieldset>
        </form>
    </body>
</html>
