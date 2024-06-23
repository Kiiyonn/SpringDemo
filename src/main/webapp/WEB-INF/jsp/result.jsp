<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
    <h1>Result</h1>
    <p>Your score: <c:out value="${score}" /> out of <c:out value="${totalQuestions}" /></p>
    <p>Your percentage: <c:out value="${percentage}" />%</p>

    <form action="q" method="get">
        <input type="submit" value="Take Again">
    </form>

    <form action="grade" method="get">
        <input type="submit" value="View Grade">
    </form>
</body>
</html>
