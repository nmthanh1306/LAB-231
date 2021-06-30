<%-- 
    Document   : error
    Created on : Jun 3, 2021, 9:30:40 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/view/header.jsp" %>
        <div class="body-content">
            <!--throws the error message-->
            <h1 style="color: red">${sessionScope.err}</h1>
        </div>
    </body>
</html>
