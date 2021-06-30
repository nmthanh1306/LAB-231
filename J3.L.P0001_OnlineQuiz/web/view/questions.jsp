<%-- 
    Document   : questions
    Created on : Jun 23, 2021, 3:59:49 PM
    Author     : Minh Thanh
--%>

<%@page import="java.util.List"%>
<%@page import="model.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/script.js" type="text/javascript"></script>
    </head>
    <%
        List<Quiz> list = (List<Quiz>) request.getAttribute("QuestionsGenerated");
        session.setAttribute("QuestionsGenerated", list);
        int minute = list.size() * 60;
    %>
    <body onload="startTimer( <%=minute%> )">
        <div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <%@include  file="../component/menu-bar.jsp" %>
                    <div class = "main-content">
                        <div class="main-content-text welcome">
                            Welcome <a class="blue-text"> ${sessionScope.Account.username}</a>  
                        </div>
                        <div class="timing to-right">
                            Time remaining <b id="countDown" class="red-text"></b>
                        </div>
                        <form class="act" action="/onlinequiz/result" method="POST">
                            <!--variable 'index' start value is 0 to join at the
                            end of name of each <input/> to easily distinguish them, 
                            also to send back servlet know the number of question-->
                            <c:forEach items="${QuestionsGenerated}" var="i">
                                <div class="mySlides"> 
                                    <b>${i.question}</b> <br>
                                    <input type="hidden" name="Q${i.id}">
                                    <input name="Ans${i.id}" type="checkbox" value="a"/> ${i.option1} <br>
                                    <input name="Ans${i.id}" type="checkbox" value="b"/> ${i.option2} <br>
                                    <input name="Ans${i.id}" type="checkbox" value="c"/> ${i.option3} <br>
                                    <input name="Ans${i.id}" type="checkbox" value="d"/> ${i.option4} <br>
                                </div>
                            </c:forEach>
                            <div class="to-left">
                                <input id="btn-prev" class="btn-black-text btn-prev" 
                                       onclick="plusSlides(-1)" type="button" value="Previous"/>
                            </div>
                            <div class="to-right">
                                <input id="btn-next" class="btn-black-text btn-next" 
                                       onclick="plusSlides(1)" type="button" value="Next"/>
                            </div>
                            <div class="to-right">
                                <input id="btn-submit" class="btn-black-text btn-submit" type="submit" value="Submit"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


