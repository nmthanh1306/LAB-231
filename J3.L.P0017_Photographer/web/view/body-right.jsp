<%-- 
    Document   : body-right
    Created on : May 28, 2021, 10:25:27 AM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="right">
            <div class="share-box">
                <div class="header-word">
                    <h4 class="font-title heading">Share this page</h4>
                </div>
                <div class="content">
                    <ul class="social">
                        <c:forEach var="s" items="${ShareList}" >
                            <li>
                                <img class="social-icon" src="${s.icon}"/> 
                                <a target="_blank" href="${s.url}">Share on ${s.socialNetwork}</a> 
                            </li> <br>
                        </c:forEach> 
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
