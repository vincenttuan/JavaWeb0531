<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="symbol" required="true" rtexprvalue="true"%>
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
            <td>Honda</td>
            <td>Accord</td>
            <td>2009</td>
        </tr>
    </tbody>
</table>