<%@ page import="utils.IpUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    out.println("<br> ID " + session.getId()+"<br>");
    out.println("<br> SERVICE IP " +  IpUtils.getLocalIP()+"<br>");
%>
</body>


</html>
