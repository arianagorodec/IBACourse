<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Create your Account</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css2/opensans-font.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts2/material-design-iconic-font/css/material-design-iconic-font.min.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="${contextPath}/resources/css2/style.css"/>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
	<div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
<%--		        <form class="form-register" action="#" method="post">--%>
	<form:form method="POST" modelAttribute="userForm" class="form-register" action="#">
		        	<div id="form-total">
		        		<!-- SECTION 1 -->
			            <h2>
			            	<span class="step-text">Личная информация о пользователе</span>
			            </h2>
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading"></h3>
								</div>

								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Ваш Email</legend>
											<div>
<%--												pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}"--%>
												<form:input type="text" name="your_email" id="your_email" class="form-control"  path="username" placeholder="example@email.com"
															autofocus="true"></form:input>
												<form:errors path="username"></form:errors>
													${usernameError}
											</div>
<%--											<input type="text" name="your_email" id="your_email" class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="example@email.com" required>--%>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-1">
										<div class="wrap-input100 validate-input" data-validate = "Password is required">
											<div class="password">
												<form:input type="password" id="password-input" path="password"  placeholder="Введите пароль" name="password"></form:input>
													<%--												<input type="password" id="password-input" placeholder="Введите пароль" name="password">--%>
												<a href="#" class="password-control" onclick="return show_hide_password(this);"></a>
											</div>
											<span class="focus-input100"></span>
											<span class="symbol-input100">
												<i class="fa fa-lock" aria-hidden="true"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-1">
										<div class="wrap-input100 validate-input" data-validate = "Password is required">
											<div class="password2">
												<form:input type="password" path="passwordConfirm"
															id="password-input2" placeholder="Введите пароль повторно" name="password2"></form:input>
												<a href="#" class="password-control2" onclick="return show_hide_password2(this);"></a>
												<form:errors path="password"></form:errors>
													${passwordError}
													<%--												<input type="password" id="password-input2" placeholder="Введите пароль повторно" name="password2">--%>
													<%--												<a href="#" class="password-control2" onclick="return show_hide_password2(this);"></a>--%>
											</div>
											<span class="focus-input100"></span>
											<span class="symbol-input100">
												<i class="fa fa-lock" aria-hidden="true"></i>
											</span>
										</div>
									</div>
								</div>

								<div >
									<a class="txt2" href="/">
										Выход
									</a>
									<button type="submit" ><a href="/">Зарегистрироваться</a></button>
								</div>
							</div>
						</section>
					</div>
			            <!-- <div class="form-row">
									<div class="form-holder form-holder-2">
										<input type="text" class="form-control input-border" id="id" name="id" placeholder="ID" required>
									</div>
								</div> -->
			</form:form>
<%--		        </form>--%>
			</div>
		</div>
	</div>
	</div>
		</div>
	</div>
	<script src="${contextPath}/resources/js2/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/resources/js2/jquery.steps.js"></script>
	<script src="${contextPath}/resources/js2/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>