<%-- 
    Document   : home-page
    Created on : Jun 17, 2021, 9:33:47 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <div class="menu flex-content">
                        <%@include  file="../component/menu-bar.jsp" %>
                    </div>

                    <div class = "main-content">
                        <c:choose> 
                            <c:when test="${sessionScope.Account == null}"> 
                                <div class="main-content-text">
                                    Login Form
                                </div>
                                <form class="act" action="/onlinequiz/login" method="POST">
                                    <table>
                                        <tr>
                                            <td>Username:</td>
                                            <td><input class="bgr-yellow-sand" name="username" type="text"/></td>
                                        </tr>
                                        <tr>
                                            <td>Password:</td>
                                            <td><input class="bgr-yellow-sand" name="password" type="password"/></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td colspan="2">
                                                <input class="btn-black-text" type="submit" value="Sign in" /> 
                                                <a href="view/register-account.jsp"> Register </a>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                                <div class="error-msg">
                                    ${err}
                                </div>
                            </c:when> 
                            <c:otherwise> 
                                <div class="main-content-text">
                                    Hello ${Account.username}
                                </div>
                            </c:otherwise> 
                        </c:choose> 
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
