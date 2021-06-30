<%-- 
    Document   : make-quiz
    Created on : Jun 19, 2021, 4:15:07 PM
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
                        <form  action="/onlinequiz/makeQuiz" method="POST">
                            <table>
                                <tr>
                                    <td>
                                        Question:
                                    </td>
                                    <td>
                                        <textarea class="content-text" name="question" rows="6" cols="50" required="">${question}</textarea> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Option1:
                                    </td>
                                    <td>
                                        <textarea class="content-text" name="opt1" rows="3" cols="50" required="">${opt1}</textarea> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Option2:
                                    </td>
                                    <td>
                                        <textarea class="content-text" name="opt2" rows="3" cols="50" required="">${opt2}</textarea> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Option3:
                                    </td>
                                    <td>
                                        <textarea class="content-text" name="opt3" rows="3" cols="50" required="" >${opt3}</textarea> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Option4:
                                    </td>
                                    <td>
                                        <textarea class="content-text" name="opt4" rows="3" cols="50" required="">${opt4}</textarea> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Answer(s):
                                    </td>
                                    <td>
                                        <div class="checkbox-group required">
                                            <input name="answer" type="checkbox" value="a" /> Option 1
                                            <input name="answer" type="checkbox" value="b" /> Option 2
                                            <input name="answer" type="checkbox" value="c" /> Option 3
                                            <input name="answer" type="checkbox" value="d" /> Option 4
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <input class="btn-black-text btn-save" type="submit" value="Save"/> 

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


