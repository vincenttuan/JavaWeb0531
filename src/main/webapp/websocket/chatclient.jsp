<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat client</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Chat client</legend>
                <input type="text" id="message" placeholder="請輸入字串" />
                <button type="button" 
                        class="pure-button pure-button-primary"
                        onclick="onOpen()">Open</button>
                <button type="button" 
                        class="pure-button pure-button-primary"
                        onclick="send()">Send</button>
                <button type="button" 
                        class="pure-button pure-button-primary"
                        onclick="onClose()">Close</button>
            </fieldset>
        </form>
    </body>
</html>
