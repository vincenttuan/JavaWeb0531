<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        
        <form class="pure-form"
              method="post" action="/JavaWeb0531/controller/bmi_session">
            <fieldset>
                <legend>BMI (Session 版) 使用人數：${ applicationScope.count } 人</legend>
                <input name="cname" type="text" placeholder="姓名" value="Helen"><p /> 
                <input name="height" type="text" placeholder="身高" value="170"><p /> 
                <input name="weight" type="text" placeholder="體重" value="60"><p />
                <input name="code" type="text" placeholder="請輸入授權碼">
                <img src="/JavaWeb0531/controller/authcode" valign="middle" /><p />
                <p />
                <button type="submit" 
                        class="pure-button pure-button-primary">傳送</button>
                <button type="button" 
                        onclick="location.href='/JavaWeb0531/controller/bmi_session'"
                        class="pure-button pure-button-primary">檢視</button>
                <button type="button" 
                        onclick="location.href='/JavaWeb0531/controller/bmi_session_invalid'"
                        class="pure-button pure-button-primary">刪除 Session</button>        
            </fieldset>
        </form>
        
    </body>
</html>
