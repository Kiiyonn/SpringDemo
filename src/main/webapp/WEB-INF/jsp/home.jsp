<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

    <c:set var="quizTaken" value="${not empty sessionScope.quizTaken}" />

    <h1>Welcome <c:out value="${username}" /></h1>

    <!-- Display dynamic link label for take/retake quiz -->
    <c:set var="quizLinkLabel" value="${quizTaken ? 'Retake Quiz' : 'Take Quiz'}" />
    <a href="q"><c:out value="${quizLinkLabel}" /></a><br>

    <!-- Link to view grades -->
    <a href="grade">View Grades</a><br>

    <!-- Link to logout -->
    <a href="logout">Logout</a>
</body>
</html>
