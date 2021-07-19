<%@ page import="com.web.rest.bookstore.BookDao"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <script>
            // 較新的瀏覽器中已經有提供btoa和atob兩個全域函式，可以用來做base64的encode和decode
            function updateBook(base64str) {
                console.log(base64str);
                console.log(atou(base64str));
                var jsonStr = atou(base64str);
                var book = JSON.parse(jsonStr);
                document.getElementById('uId').value = book.id;
                document.getElementById('uName').value = book.name;
                document.getElementById('uPrice').value = book.price;
            }
            
            function deleteBook(id) {
                document.getElementById('dId').value = id;
            }
            
            // 使用 utf-8 進行編碼 base64
            function utoa(str) {
                return window.btoa(unescape(encodeURIComponent(str)));
            }
            
            // 使用 utf-8 進行解析 base64
            function atou(str) {
                return decodeURIComponent(escape(window.atob(str)));
            }
        </script>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Rest Book List</legend>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>price</th>
                            <th>修改</th>
                            <th>刪除</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${ BookDao.getBooks() }">
                            <tr>
                                <td>${ book.id }</td>
                                <td>${ book.name }</td>
                                <td>${ book.price }</td>
                                <td>
                                    <button type="button" 
                                            onclick="updateBook('${ book }')"
                                            class="pure-button pure-button-primary">修改</button>
                                </td>
                                <td>
                                    <button type="button" 
                                            onclick="deleteBook(${ book.id })"
                                            class="pure-button pure-button-primary">刪除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>

        <table>
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaWeb0531/rest/book">
                    <fieldset>
                        <legend>Rest Book POST</legend>
                        <input name="id" type="text" placeholder="id"><p /> 
                        <input name="name" type="text" placeholder="名稱"><p /> 
                        <input name="price" type="text" placeholder="價格"><p />
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">新增</button>

                    </fieldset>
                </form>
            </td>
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaWeb0531/rest/book">
                    <fieldset>
                        <legend>Rest Book PUT</legend>
                        <input name="_method" type="hidden" value="PUT" />
                        <input id="uId" name="id" type="text" placeholder="id" readonly><p /> 
                        <input id="uName" name="name" type="text" placeholder="名稱"><p /> 
                        <input id="uPrice" name="price" type="text" placeholder="價格"><p />
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">修改</button>

                    </fieldset>
                </form>
            </td>
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaWeb0531/rest/book">
                    <fieldset>
                        <legend>Rest Book Delete</legend>
                        <input name="_method" type="hidden" value="DELETE" />
                        <input id="dId" name="id" type="text" placeholder="id" readonly><p /> 
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">刪除</button>

                    </fieldset>
                </form>    
            </td>
        </table>
    </body>
</html>
