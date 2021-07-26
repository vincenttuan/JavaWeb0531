<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat client</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <script>
            // char server 路徑
            var chaturl = 'ws://localhost:8080/JavaWeb0531/websocket/chat';
            // 建立 websocket 物件
            var ws = null;
            
            function onOpen() { 
                ws = new WebSocket(chaturl); // 發送連線
                ws.onopen = function(evt) { // Server 回應
                    console.log('server onopen:' + evt.data);
                    result.insertAdjacentHTML("befordend", '連到 server <br>');
                };
                ws.onmessage = function(evt) { // Server 回應
                    console.log('server onmessage:' + evt.data);
                    result.insertAdjacentHTML("befordend", evt.data + '<br>');
                };
                ws.onclose = function(evt) { // Server 回應
                    console.log('server onclose:' + evt);
                    result.insertAdjacentHTML("befordend", '關閉連線 <br>');
                    ws = null;
                };
            }
            
            function send() {
                ws.send(message.value);
            }
            
            function onClose() {
                if(ws != null) {
                    ws.close();
                } else {
                    alert('請先按下 Open 鍵')
                }
            }
            
        </script>
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
        <div id="result"></div>
    </body>
</html>
