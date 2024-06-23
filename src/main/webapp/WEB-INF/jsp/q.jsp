<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Questions</title>
</head>
<body>
    <h1>Answer the Questions</h1>
      <form action="q" method="post">
           <c:forEach var="question" items="${questions}" varStatus="loopStatus">
               <div>
                   <p>${question.questionContent}</p>
                   <c:forEach var="option" items="${question.choices}" varStatus="status">
                       <input type="radio" name="question_${loopStatus.index}" value="${status.index}" /> ${option}<br>
                   </c:forEach>
               </div>
           </c:forEach>
        <br>
        <input type="hidden" name="answers" value="<c:out value='${randomizedAnswers}' />">
        <input type="reset" value="Reset">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
