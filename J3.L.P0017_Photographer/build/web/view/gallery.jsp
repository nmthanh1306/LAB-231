<%--
    Document   : gallery
    Created on : May 29, 2021, 9:26:52 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/gallery.css" rel="stylesheet" type="text/css"/>
        <link href="css/slideshow.css" rel="stylesheet" type="text/css"/>
        <link href="css/fancybox.css" rel="stylesheet" type="text/css"/>
        <title>${gallery.gallery_title}</title>
    </head>
    <body>
        <%@include file="/view/header.jsp" %>
        <div class="body-content">
            <div class="left wrapper-body">
                <div class="title">
                    <h1 class="font-title">${gallery.gallery_title}</h1>
                </div>
                <div class="slideshow-container">
                    <c:forEach items="${listImage}" var="i">
                        <div class="main-image main-image-gallery mySlides fade">
                            <img src="${i.image_Path}"/>
                        </div>
                    </c:forEach>
                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                </div>
                <div class="photo-album">
                    <ul class="thumbnails">
                        <c:forEach items="${listImage}" var="i">
                            <li class="span4">
                                <div class="image">
                                    <a id="${i.image_Path}" onclick="show(this.id)">
                                        <img src="${i.image_Path}"/>
                                    </a>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="paging">
                        <c:if test="${maxPage > 1}">
                            <c:forEach begin="1" end="${maxPage}" var="o">
                                <a class="${o==index?"active":""}" href="gallery?index=${o}&id=${gallery.id}">${o}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
            <%@include file="/view/body-right.jsp"%>
        </div>
        <%@include file="/view/footer.jsp" %>
        <%@include file="/view/fancybox.jsp" %>
    </body>
</html>
<script src="js/slideshow.js" type="text/javascript"></script>
<script src="js/fancybox.js" type="text/javascript"></script>
