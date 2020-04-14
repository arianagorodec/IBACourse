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

<%--  <table>--%>
<%--    <thead>--%>
<%--    <th>ID</th>--%>
<%--    <th>UserName</th>--%>
<%--    <th>Password</th>--%>
<%--    <th>Roles</th>--%>
<%--    </thead>--%>
<%--    <c:forEach items="${allUsers}" var="user">--%>
<%--      <tr>--%>
<%--        <td>${user.id}</td>--%>
<%--        <td>${user.username}</td>--%>
<%--        <td>${user.password}</td>--%>
<%--        <td>--%>
<%--            ${user.role}--%>
<%--&lt;%&ndash;          <c:forEach items="${user.role}" var="role">${role.name}; </c:forEach>&ndash;%&gt;--%>
<%--        </td>--%>
<%--        <td>--%>
<%--          <form action="${pageContext.request.contextPath}/admin/delete" method="post">--%>
<%--            <input type="hidden" name="userId" value="${user.id}"/>--%>
<%--            <input type="hidden" name="action" value="delete"/>--%>
<%--            <button type="submit">Delete</button>--%>
<%--          </form>--%>

<%--        </td>--%>

<%--      </tr>--%>
<%--    </c:forEach>--%>
<%--  </table>--%>

  <h1>Table for use</h1>
  <table>
    <tr>
      <td>product</td>
      <td>organization_structure</td>
    </tr>
  </table>

<%--  <a>DELETE FROM `dd`.`product` WHERE (`id_product` = '1');</a>--%>
<%--  insert--%>
<%--  select--%>

  <form  action="${pageContext.request.contextPath}/admin" method="post">
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