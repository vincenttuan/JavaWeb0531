<%@page import="com.web.job.Calc"%>
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    
<%
    Calc calc = new Calc();
    calc.setX(10);
    calc.setY(20);
    out.print(calc.getResult());
%>

<jsp:useBean id="calc2" class="com.web.job.Calc" />
<jsp:setProperty name="calc2" property="x" value="20" />
<jsp:setProperty name="calc2" property="y" value="30" />
<jsp:getProperty name="calc2" property="result" />

</html>
