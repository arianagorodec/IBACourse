<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie ie6 ie-lt10 ie-lt9 ie-lt8 ie-lt7 no-js" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7 ie-lt10 ie-lt9 ie-lt8 no-js" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8 ie-lt10 ie-lt9 no-js" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9 ie-lt10 no-js" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="favicon.ico" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssP/table.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssP/style.css">
    <link rel="stylesheet" href="${contextPath}/resources/cssP/left-nav-style.css">
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>

    <input type="checkbox" id="nav-toggle" hidden>
<nav class="nav">
    <label for="nav-toggle" class="nav-toggle" onclick></label>
    <h2>
        <a>Tables</a>
    </h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/log">History</a></li>
        <c:forEach items="${allTables}" var="table">
            <li><a><img src="${contextPath}/resources/images2/form-v1-icon.png">${table.name}</a>
                <ul>
                    <c:forEach items="${table.fields}" var="field">
                        <li><a>${field}</a></li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
    </ul>
</nav>
<div class="container-login100"><div class="wrap-login100">
    <div class="wrap-input100 validate-input" >
        <main role="main">
            <article>
                <header>
                    <img class="img-cloud" src="${contextPath}/resources/images/cloud.png" width="500" height="250">
                    <%--                <h1 class="diz">Working Space</h1>--%>
                    <!--                <h2></h2> -->
                </header>
                <section>
                    <p style="text-align: center;">
                    <form  action="${pageContext.request.contextPath}/admin" method="post">
                        <textarea class="input101 text-area-st"  maxlength="255" name="sqlreq" placeholder="Enter sql request"></textarea>
                        <span class="focus-input100"></span>
                        <span class="symbol-input100"><i class="fa fa-envelope" aria-hidden="true"></i></span>
                        <a>${answer}</a>
                        <section>
                            <div class="text-align-center">
                                <button type="submit" class="btn btn-secondary" >
                                    Send
                                </button>
                            </div>
                        </section>
                    </form>
                </section>
                <section>
                    <table class="simple-little-table" cellspacing='0'>
                        <c:forEach items="${allQuery}" var="Query">
                            <tr>
                                <c:forEach items="${Query}" var="value">
                                    <td>${value}</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
                <section>
                    <table class="simple-little-table" cellspacing='0'>
                        <c:forEach items="${allString}" var="String">
                            <tr>
                                <c:forEach items="${String}" var="value">
                                    <td>${value}</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
                <hr>
                <footer>
                    <p><a href="/logout">← Exit</a>
                    <p>made with love - <a href="https://www.instagram.com/imagine__me/">@arianagorodec</a>
                </footer>
            </article>
        </main>
    </div>
</div>
</div>
</body>

</html>