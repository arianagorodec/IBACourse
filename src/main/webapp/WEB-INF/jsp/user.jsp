<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <h1>Table for use</h1>
    <table>
        <tr>
            <td>product</td>
            <td>organization_structure</td>
        </tr>
    </table>

    <form  action="${pageContext.request.contextPath}/user" method="post">
        <input type="text" name="sqlreq" placeholder="Enter sql request">
        <button type="submit">
            Send
        </button>
        <a>${answer}</a>
    </form>

    <a href="/logout">Выйти</a>
</div>
</body>
</html>