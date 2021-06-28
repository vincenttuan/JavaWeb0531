<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>招聘</title>
        <meta charset="UTF-8">
        <!-- 線上 icon 製作 -->
        <!-- http://tw.faviconico.org/ -->
        <link rel="icon" href="../icons/favicon.ico" type="image/x-icon" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/JavaWeb0531/controller/recruit">
            <fieldset>
                <legend>招聘</legend>
                <img width="40" src="../images/person.png" valign="middle" />
                <input type="number" placeholder="請輸入人數" name="amount" />
                <button type="submit" class="pure-button pure-button-primary">Submit</button>
            </fieldset>
        </form>
    </body>
</html>

