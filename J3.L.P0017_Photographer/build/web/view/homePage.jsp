<%-- 
    Document   : homePage
    Created on : May 24, 2021, 10:22:48 AM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/fancybox.css" rel="stylesheet" type="text/css"/>
        <title>My front page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="/view/header.jsp" %>
            <div class="body-content">
                <%@include file="/view/body-left.jsp" %>
                <%@include file="/view/body-right.jsp" %>
            </div>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>
