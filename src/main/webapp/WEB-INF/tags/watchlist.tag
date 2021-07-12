<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="symbols" required="true" rtexprvalue="true"%>
<table class="pure-table">
    <thead>
        <tr>
            <th>Symbol</th>
            <th>Name</th>
            <th>Price</th>
            <th>Change</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="symbol" items="${fn:split(symbols, ',')}">
            <jsp:useBean class="com.web.tag.utils.MyStock" id="myStock" />
            <jsp:setProperty name="myStock" property="symbol" value="${ symbol }" />

            <tr>
                <td>${ symbol }</td>
                <td>${ myStock.name }</td>
                <td style="color: ${ myStock.color }">${ myStock.price }</td>
                <td style="color: ${ myStock.color }">${ myStock.change }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>