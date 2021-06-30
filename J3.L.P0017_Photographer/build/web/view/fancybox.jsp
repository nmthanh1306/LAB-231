<%-- 
    Document   : fancybox
    Created on : Jun 7, 2021, 10:32:01 AM
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
        <div id="fancybox" class="fancybox-overlay fancybox-overlay-fixed" style="width: auto; height: auto; display: none">
            <div class="fancybox-wrap fancybox-desktop fancybox-type-image fancybox-opened" tabindex="-1" 
                 style="width: auto; height: auto; position: absolute; top: 100px; left: 350px; opacity: 1; overflow: visible; display: block;">
                <div class="fancybox-skin" style="padding: 15px; width: auto; height: auto;">
                    <div class="fancybox-outer">
                        <div class="fancybox-inner" style="overflow: visible; width: 650px; height: 450px;">
                            <img id="showImage" class="fancybox-image" src="${photographer.feature_Image}" alt="">
                        </div>
                    </div>
                    <!--                    <div class="fancybox-title fancybox-title-inside-wrap">
                                            Transparence (delphine.cury)
                                        </div>-->
                    <a onclick="show(this.id)" id="close" title="Close" class="fancybox-item fancybox-close" href="javascript:;">
                        X
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
