<%-- 
    Document   : header
    Created on : May 25, 2021, 5:16:27 PM
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
        <div class="header-menu">
            <div class="flex-content space-left">
                <div class="menu">
                    <a href="home">My front page</a>
                </div>
                <c:forEach items="${listGallery}" var="g">
                    <div class="menu">
                        <a href="gallery?id=${g.id}">${g.gallery_title}</a>
                    </div>
                </c:forEach>
                <div class="menu">
                    <a href="contact">Contact</a>
                </div>
            </div>
        </div>
        <div class="title-page">
            <div class="wrapper-content flex-content">
                <div class="logo space-left">
                    <a href="#"><img src="../images/logo.png" alt=""/></a>
                </div>
                <div>
                    <div>
                        <a href="home" class="title font-title">PHOTOGRAPHER</a>
                    </div>
                    <div class="sub-title font-title">
                        Welcome to this website
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
