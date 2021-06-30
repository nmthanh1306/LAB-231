<%-- 
    Document   : footer
    Created on : May 29, 2021, 9:27:54 PM
    Author     : Minh Thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="footer">
            <div class="footer-content">
                <a class="link-footer" href="#">Created with SimpleSite</a>               
                <div class="footer-page-counter">
                    <c:forEach items="${sessionScope.views}" var="v">
                        <span class="footer-page-counter-item">${v}</span>
                    </c:forEach>
                </div>   
            </div>
        </div>
    </body>
</html>
