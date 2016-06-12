<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head> 

</head>
<spring:url value="/resources/style.css" var="CSS" /> 
  <link rel="stylesheet" type="text/css" href="${CSS}">
<body>
	<div>
		<h2>
			<spring:message code="login.form.header" />
		</h2>
		Language : <a href="?locale=en">English</a>|<a href="?locale=zh_CN">Chinese</a>

		<c:if test="${not empty error}">
			<div class="errorblock">Your login attempt was not successful,
				try again. Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
		</c:if>

		<spring:message code="login.button" var="inputButton" />
		<spring:message code="Username.text" var="username" />
		<spring:message code="Password.text" var="password" />
		<spring:message code="login.header" var="login" />


		<form action="/StudentManagement3/j_spring_security_check"
			method="post">
			<h2>Please Login</h2>

			<div>
				<input type="text" name="j_username" autofocus=""
					placeholder="${username}" />
			</div>
			<div>
				<input type="password" name="j_password" placeholder="${password}" />
			</div>
			<div>
				<input type="submit" value="${inputButton}" />
			</div>

		</form>
	</div><body>
<html>