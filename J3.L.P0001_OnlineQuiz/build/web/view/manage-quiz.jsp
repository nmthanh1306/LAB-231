<%-- 
    Document   : manage-quiz
    Created on : Jun 19, 2021, 9:42:44 PM
    Author     : Minh Thanh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body><div class="wrapper-all">
            <div class="wrapper-box">
                <div class="form">
                    <%@include  file="../component/menu-bar.jsp" %>
                    <div class = "main-content">
                        <div class="header-text">
                            Number of questions: <b class="blue-text"> ${size}</b>  
                        </div>
                        <table class="manage-question">
                            <tr>
                                <td class="blue-text">
                                    Question
                                </td>
                                <td class="blue-text">
                                    DateCreated
                                </td>
                            </tr>
                            <c:forEach items="${listQuiz}" var="i">
                                <tr>
                                    <td>
                                        ${i.question}
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${i.dateCreated}" pattern="dd-MMM-YYYY" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
