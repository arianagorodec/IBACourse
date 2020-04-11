<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${contextPath}/resources/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<!--<link rel="stylesheet" type="text/css" href="css/util.css">-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/main.css">
<!--===============================================================================================-->
</head>
<body>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--	<% response.sendRedirect("/news"); %>--%>
<%--</sec:authorize>--%>
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="${contextPath}/resources/images/2.jpg" alt="IMG">
				</div>

<%--				<form class="login100-form validate-form"  method="POST" action="/">--%>
				<form:form method="POST" modelAttribute="userForm" class="login100-form validate-form" action="#">
					<span class="login100-form-title">
						Registration
					</span>

<%--					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">--%>
<%--						<input class="input100" type="text" name="username" placeholder="Email">--%>
<%--						<span class="focus-input100"></span>--%>
<%--						<span class="symbol-input100">--%>
<%--							<i class="fa fa-envelope" aria-hidden="true"></i>--%>
<%--						</span>--%>
<%--					</div>--%>

<%--					<legend>Ваш Email</legend>--%>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<form:input type="text" name="your_email" id="your_email" class="input100"  path="username" placeholder="example@email.com"
									autofocus="true"></form:input>
						<form:errors path="username"></form:errors>
							${usernameError}
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

<%--					<div class="wrap-input100 validate-input" data-validate = "Password is required">--%>
<%--						<input class="input100" type="password" name="password" placeholder="Password">--%>
<%--						<span class="focus-input100"></span>--%>
<%--						<span class="symbol-input100">--%>
<%--							<i class="fa fa-lock" aria-hidden="true"></i>--%>
<%--						</span>--%>
<%--					</div>--%>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<div class="password">
							<form:input type="password" id="password-input" class="input100" path="password"  placeholder="Password" name="password"></form:input>
									<a href="#" class="password-control" onclick="return show_hide_password(this);"></a>
						</div>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<div class="password">
							<form:input type="password" path="passwordConfirm"
										id="password-input2"  class="input100" placeholder="Repeat password" name="password2"></form:input>
							<a href="#" class="password-control2" onclick="return show_hide_password2(this);"></a>
							<form:errors path="password"></form:errors>
								${passwordError}
						</div>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
<%--						<sec:authorize access="!isAuthenticated()">--%>
						<button class="login100-form-btn" type="submit">
								Registration
						</button>
<%--						</sec:authorize>--%>
					</div>
				</form:form>
<%--				</form>--%>
			</div>
		</div>
	

	
<!--===============================================================================================-->	
	<script src="${contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${contextPath}/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${contextPath}/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${contextPath}/resources/vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>