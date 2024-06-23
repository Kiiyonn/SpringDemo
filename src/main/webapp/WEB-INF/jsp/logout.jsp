<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
</head>
<body>
    <h1>Logout</h1>
    <c:remove var="username" scope="session" />
    <p>You have been successfully logged out.</p>
    <p>Please <a href="login.jsp">click here</a> to login again.</p>
</body>
</html>
