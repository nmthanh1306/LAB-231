<%-- 
    Document   : register-account
    Created on : Jun 19, 2021, 10:12:18 PM
    Author     : Minh Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <%@include  file="../component/menu-bar.jsp" %>
                    <div class = "main-content">
                        <div class="main-content-text">
                            Registration Form
                        </div>
                        <form class="act" action="/onlinequiz/register" method="POST">
                            <table>
                                <tr>
                                    <td>User Name:</td>
                                    <td><input class="bgr-yellow-sand" name="username" type="text" required=""/></td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td><input class="bgr-yellow-sand" name="password" type="password" required=""/></td>
                                </tr>
                                <tr>
                                    <td>User type:</td>
                                    <td colspan="2">
                                        <select name="role" class="btn-black-text">
                                            <option value="teacher">Teacher</option>
                                            <option value="student">Student</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Email:</td>
                                    <td><input name="email" type="email" required=""/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2">
                                        <input class="btn-black-text" type="submit" value="Register" /> 
                                    </td>
                                </tr>
                            </table>
                        </form>
                        <div class="error-msg">
                            ${err}
                        </div>
                        <div class="success-msg">
                            ${msg}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
