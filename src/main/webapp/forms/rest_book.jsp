<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        
        
        
        <form class="pure-form"
              method="post" action="/JavaWeb0531/rest/hello/book">
            <fieldset>
                <legend>Rest Book POST</legend>
                <input name="name" type="text" placeholder="名稱" value="Java爪哇"><p /> 
                <input name="price" type="text" placeholder="價格" value="60"><p />
                <p />
                <button type="submit" 
                        class="pure-button pure-button-primary">傳送</button>
                     
            </fieldset>
        </form>
        
        <form class="pure-form"
              method="post" action="/JavaWeb0531/rest/hello/book/2">
            <fieldset>
                <legend>Rest Book PUT</legend>
                <input type="hidden" name="_method" value="put" />
                <input name="name" type="text" placeholder="名稱" value="Java"><p /> 
                <input name="price" type="text" placeholder="價格" value="60"><p />
                <p />
                <button type="submit" 
                        class="pure-button pure-button-primary">傳送</button>
                     
            </fieldset>
        </form>
        
        <form class="pure-form"
              method="post" action="/JavaWeb0531/rest/hello/book/2">
            <fieldset>
                <legend>Rest Book Delete</legend>
                <input type="hidden" name="_method" value="delete" />
                <input name="name" type="text" placeholder="名稱" value="Java"><p /> 
                <input name="price" type="text" placeholder="價格" value="60"><p />
                <p />
                <button type="submit" 
                        class="pure-button pure-button-primary">傳送</button>
                     
            </fieldset>
        </form>
        
    </body>
</html>
