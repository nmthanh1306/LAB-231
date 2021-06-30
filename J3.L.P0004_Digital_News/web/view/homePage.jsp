<%-- 
    Document   : homepage
    Created on : May 14, 2021, 9:18:25 AM
    Author     : Minh Thanh
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital News</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="/view/header.jsp" %>
            <div class="bg">
                <div class="main-left">
                    <div class="news-title bold-text green-text title-parts">
                        ${currentArticle.title}
                    </div>
                    <div class="i1">
                        <img  src="${currentArticle.image}"/>
                    </div>

                    <div class="news-content">
                        ${currentArticle.content}
                    </div>
                    <div class="author-infor-time">
                        <img src="resource/images/comment.gif" alt=""/>
                        <img src="resource/images/timeicon.gif" alt=""/>
                        ${currentArticle.author} | ${currentArticle.getDateTimeFormated()}
                    </div>
                </div>
                <div class="main-right">
                    <%@include file="/view/right.jsp" %>
                </div>
            </div>
            <div class="footer">

            </div>
        </div>
    </body>
</html>
