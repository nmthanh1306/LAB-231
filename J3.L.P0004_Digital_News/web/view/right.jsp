<%-- 
    Document   : right
    Created on : May 18, 2021, 9:07:52 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="title-short-description bold-text green-text title-parts">
            Digital News
        </div>
        <div class="short-description">
            ${currentArticle.description}
        </div>
        <div class="search bold-text green-text title-parts">
            Search
        </div>
        <form action="search" method="POST">
            <input class="search-box" type="text" name="txtSearch"/>
            <input class="btn-submit bold-text" type="submit" value="Go" />
        </form>
        <div class="last-articles bold-text green-text title-parts">
            Last Articles
        </div>
        <div class="most-5-recent-news">
            <c:forEach items="${top5Articles}" var="a">
                <div class="list">
                    <a href="view-article?id=${a.id}"> ${a.title} </a>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
