<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>招聘結果</title>
        <meta charset="UTF-8">
        <!-- 線上 icon 製作 -->
        <!-- http://tw.faviconico.org/ -->
        <link rel="icon" href="../icons/favicon.ico" type="image/x-icon" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>招聘結果</legend>
                總人數：${ fn:length(list) }
                <p />
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Sex</th>
                            <th>Score</th>
                            <th>Pass</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="person" items="${ list }" varStatus="item" >
                        <tr>
                            <td>${ item.index + 1 }</td>
                            <td>${ person.name }</td>
                            <td>${ person.sex }</td>
                            <td>${ person.score }</td>
                            <td>
                                <c:if test="${ person.score >= 60 }">
                                    <c:out value="Pass" />
                                </c:if>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p />
                錄取人數：
                <p />
                <button type="button" onclick="window.history.back()" class="pure-button pure-button-primary">回上一頁</button>
            </fieldset>
        </form>
    </body>
</html>

