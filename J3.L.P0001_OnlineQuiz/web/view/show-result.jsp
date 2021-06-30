<%-- 
    Document   : show-result
    Created on : Jun 24, 2021, 5:51:42 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <%@include  file="../component/menu-bar.jsp" %>
                    <div class = "main-content">
                        <div class="header-text">
                            Your score 
                            <b class="blue-text"> 
                                ${marks} (${percent}%) - ${state}
                            </b>  
                        </div>
                        <div class="button-start">
                            Take another test
                            <button onclick="window.location.href = 'view/take-quiz.jsp'" class="btn-black-text " >Start</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
