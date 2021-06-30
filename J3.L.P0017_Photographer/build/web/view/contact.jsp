<%-- 
    Document   : contact
    Created on : May 30, 2021, 1:10:16 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
        <title>Contact</title>
    </head>
    <body>
        <%@include file="/view/header.jsp" %>
        <div class="body-content">
            <div class="left wrapper-body">
                <div class="contact">
                    <h1 class="font-title">Contact</h1>
                </div>
                <div class="photographer-infor">
                    <div class="title">
                        <h4>${photographer.name}</h4>
                    </div>
                    <table>
                        <tr>
                            <td>Address:</td>
                            <td>${photographer.address}</td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td>${photographer.city}</td>
                        </tr>
                        <tr class="space-bottom">
                            <td>Country:</td>
                            <td>${photographer.country}</td>
                        </tr>
                        <tr class="space-bottom">
                            <td>Tel:</td>
                            <td><a href="#">(+84) ${photographer.tel}</a></td>
                        </tr>
                        <tr class="space-bottom">
                            <td>Email:</td>
                            <td><a href="#">${photographer.email}</a></td>
                        </tr>
                    </table>
                </div>
                <div class="map">
                    <iframe  src="${photographer.map}"
                            width="700" height="500" style="border:0;" 
                            allowfullscreen="" loading="lazy">
                    </iframe>
                </div>
            </div>
            <%@include file="/view/body-right.jsp"%>
        </div>
        <%@include file="/view/footer.jsp" %>
    </body>
</html>
