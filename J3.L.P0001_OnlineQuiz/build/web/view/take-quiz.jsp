<%-- 
    Document   : take-quiz
    Created on : Jun 18, 2021, 9:34:22 PM
    Author     : Minh Thanh
--%>

<%@page import="model.Quiz"%>
<%@page import="java.util.List"%>
<%@page import="dal.QuizDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        QuizDAO dao = new QuizDAO();
        List<Quiz> list = dao.getAllQuiz();
    %>
    <body>
        <div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <%@include  file="../component/menu-bar.jsp" %>
                    <div class = "main-content">
                        <div class="main-content-text welcome">
                            Welcome <b class="blue-text"> ${sessionScope.Account.username}</b>  
                        </div>
                        <form action="/onlinequiz/takequiz">
                            <div class="act">
                                Enter number of questions: <br> 
                                <input class="input-number" name="numberOfQuestion" 
                                       type="number" min="2" max="<%= list.size()%>" required=""/>
                            </div>
                            <div class="btn-start">
                                <input type="submit" class="btn-black-text" value="Start">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
