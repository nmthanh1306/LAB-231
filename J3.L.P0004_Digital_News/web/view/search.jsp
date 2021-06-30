<%-- 
    Document   : search
    Created on : May 19, 2021, 11:05:28 AM
    Author     : Minh Thanh
--%>

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
                    <c:forEach items="${listFound}" var="a">
                        <div>
                            <a href="view-article?id=${a.id}"
                               class="news-title bold-text green-text title-parts">
                                ${a.title}
                            </a>
                        </div>
                        <div class="i1">
                            <img  src="${a.image}"/>
                        </div>
                        <div class="short-description-found">
                            ${a.description}
                        </div>
                        <br>
                    </c:forEach>
                    <div class="paging">
                        <c:if test="${maxPage < 1}">
                            <h3>Not Found</h3>
                        </c:if>
                        <c:if test="${maxPage > 1}">
                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==index?"active":""}" href="search?index=${i}&txtSearch=${txtSearch}">${i}</a>
                            </c:forEach>
                        </c:if>
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

