<%-- 
    Document   : calcAreaResult
    Created on : 2021/6/7, 下午 08:25:27
    Author     : vincenttuan
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String sno  = request.getAttribute("sno").toString();
    String eno  = request.getAttribute("eno").toString();
    String time = request.getAttribute("time").toString();
    String payString  = request.getAttribute("pay").toString();
    Boolean pay = Boolean.parseBoolean(payString);
    String memo = request.getAttribute("memo").toString();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>註冊結果</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend style="color: #005100">註冊結果</legend>
                學員編號：<%=sno %><p />
                認證代號：<%=eno %><p />
                考試時段：<%=time %><p />
                繳費狀況：<%=(pay)?"已繳":"未繳" %><p />
                備註資料：<%=memo %><p />
                <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
            </fieldset>
        </form>

    </body>
</html>
