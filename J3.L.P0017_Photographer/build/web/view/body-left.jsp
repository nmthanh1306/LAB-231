<%-- 
    Document   : body
    Created on : May 26, 2021, 9:28:10 AM
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
        <div class="left wrapper-body">
            <div class="main-image">
                <a id="${photographer.feature_Image}" onclick="show(this.id)" >
                    <img src="${photographer.feature_Image}" alt="">
                </a>
            </div>
            <div class="image-caption">
                ${photographer.title_Feature_Image}
            </div>
            <div>
                <div class="list-gallery">
                    <ul class="column-gallery">
                        <c:forEach items="${listGalleryPaging}" var="g">
                            <li class="span4">
                                <div class="zoom">
                                    <a id="${g.main_image}" onclick="show(this.id)">
                                        <img src="${g.main_image}" />
                                    </a>
                                </div>
                                <h4>
                                    <a href="gallery?id=${g.id}" class="font-title"> View ${g.gallery_title}</a> 
                                </h4>
                                <p>
                                    ${g.content}
                                </p>
                            </li>
                        </c:forEach> 
                    </ul>
                    <div class="paging">
                        <c:if test="${maxPage > 1}">
                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==index?"active":""}" href="home?index=${i}">${i}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="about-me">
                <div class="title">
                    <h3 class="font-title">
                        About Me
                    </h3>
                </div>
                <div>
                    <p>
                        <span>
                            ${photographer.aboutMe}
                        </span>
                    </p>
                </div>
            </div>
        </div>
        <%@include file="/view/fancybox.jsp" %>                
    </body>
</html>
<script src="js/fancybox.js" type="text/javascript"></script>
