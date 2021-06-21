<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <link rel="icon" href="../icons/favicon.ico" type="image/x-icon" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form" 
              method="post">
            <fieldset>
                <legend>Login Form</legend>
                <input name="username" type="text" placeholder="請輸入帳號" value=""><p /> 
                <input name="password" type="password" placeholder="請輸入密碼" value=""><p /> 
                <p />
                <font color='RED'>${ errorMsg }</font>
                <p />
                <button type="submit" class="pure-button pure-button-primary">登入</button>
                <button type="reset" class="pure-button pure-button-primary">重置</button>
            </fieldset>
        </form>
    </body>
</html>

