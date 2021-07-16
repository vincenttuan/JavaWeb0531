<%@page import="com.web.rest.bookstore.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Rest Book List</legend>
                <%=BookDao.books %>
            </fieldset>
        </form>
            
        <form class="pure-form"
              method="post" action="/JavaWeb0531/rest/book">
            <fieldset>
                <legend>Rest Book POST</legend>
                <input name="id" type="text" placeholder="id"><p /> 
                <input name="name" type="text" placeholder="名稱"><p /> 
                <input name="price" type="text" placeholder="價格"><p />
                <p />
                <button type="submit" 
                        class="pure-button pure-button-primary">傳送</button>
                     
            </fieldset>
        </form>
        
        
    </body>
</html>
