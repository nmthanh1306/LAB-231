<%-- 
    Document   : menu-bar
    Created on : Jun 18, 2021, 9:11:51 PM
    Author     : Minh Thanh
--%>

<%@page import="model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%
            Account account = (Account) session.getAttribute("Account");
            boolean isTeacher = false;
            // check user is teacher or not
            if (account != null) {
                if (account.getRole() == 1) {
                    isTeacher = true;
                }
            }
        %>

        <div class="menu flex-content">
            <div class="space-left">
                <a class="menu-text" href="/onlinequiz">
                    Home
                </a>
            </div>
            <!-- if user had logined: can take quiz, else: go to login page -->
            <div class="space-left">
               <a class="menu-text" href="<%= account != null ? "/onlinequiz/view/take-quiz.jsp"
                        : "/onlinequiz/component/accessDinied.jsp"%>">
                    Take Quiz
                </a>
            </div>
            <!-- if user is teacher: can make new quiz, else:: msg Access Dinied -->
            <div class="space-left">
               <a class="menu-text" href="<%= isTeacher ? "/onlinequiz/view/make-quiz.jsp"
                       : "/onlinequiz/component/accessDinied.jsp"%>">
                    Make Quiz
                </a>
            </div>
            <!-- if user is teacher: go to manageQuiz servlet, else:: msg Access Dinied -->
            <div class="space-left">
                <a class="menu-text" href="<%= isTeacher ? "/onlinequiz/manageQuiz"
                        : "/onlinequiz/component/accessDinied.jsp"%>">
                    Manage Quiz
                </a>
            </div>
            <!-- if user had logined: display logout link -->
            <div class="space-left <%= account == null ? " disable-logout" : ""%> ">
                <a class="menu-text" href="/onlinequiz/logout">
                    Logout
                </a>
            </div>
        </div>
    </body>
</html>
