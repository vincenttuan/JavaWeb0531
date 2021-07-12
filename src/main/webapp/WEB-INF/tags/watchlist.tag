<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="symbol" required="true" rtexprvalue="true"%>
<jsp:useBean class="com.web.tag.utils.MyStock" id="myStock" />
<jsp:setProperty name="myStock" property="symbol" value="${ symbol }" />
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
        <tr>
            <td>${ symbol }</td>
            <td>${ myStock.name }</td>
            <td style="color: ${ myStock.color }">${ myStock.price }</td>
            <td style="color: ${ myStock.color }">${ myStock.change }</td>
        </tr>
    </tbody>
</table>