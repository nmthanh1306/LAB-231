<%-- 
    Document   : accessDinied
    Created on : Jun 23, 2021, 12:05:24 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                <div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <div class="menu flex-content">
                        <%@include  file="../component/menu-bar.jsp" %>
                    </div>
                    <div class = "main-content">
                        <div class="error-msg">
                            <h1>Access Dinied!</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
