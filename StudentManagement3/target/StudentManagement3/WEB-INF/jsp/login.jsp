<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
    <style>
    #container{width:600px; height:600px;background:#ffffff}
#loginBox{width:60%; background:#000000;color:#ffffff;padding:40px;margin:50px 50px 40px 500px}
#lbl{width:100px;height:40px;}
.txt{width:100px;float:right}
#box{width:200px ;height:50px}
#errormsg{color:#ff0000}
.hidden{display:none}
    </style>
    
	<div id="container">

		Language : <a href="?locale=en">English</a>|<a href="?locale=zh_CN">Chinese</a>


		<spring:message code="login.button" var="inputButton" />
		<spring:message code="Username.text" var="username" />
		<spring:message code="Password.text" var="password" />
		<spring:message code="login.header" var="login" />


		<form action="/StudentManagement3/j_spring_security_check"
			method="post" id="loginForm">
			<div id="loginBox">
	<div id ="errormsg">
<ul>
<li id="userError" class="hidden">UserName should contain 4 upper case character followed by 4 digits.</li>
<li  id="passwordError" class="hidden">UserName should contain 4 upper case character followed by 4 digits.</li>  
<c:if test="${not empty error}">
	<li id="invalidCridentialError">Invalid Username or Password</li>
</c:if>
</ul>
</div>

			<h2>Please Login</h2>

			<div id="box">
				<label id="lbl">${username} :</label>
				<input  id="username" class="txt" type="text" name="j_username" autofocus=""
					placeholder="${username}" />
			</div>
			<div id="box">
				<label id="lbl">${password} :</label>
				<input  id="password" class="txt" type="password" name="j_password" placeholder="${password}" />
			</div>
			<div>
				<input id="login" type="button" value="${inputButton}"/>
			</div>
</div>
		</form>
	</div><body>
	<script src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
<script type="text/javascript">
function Login(name, password) {

    this.name=name;
    this.password=password;
    this.userPassRegex=/^[A-Z]{5}[0-9]{4}$/;
    this.userErrorId='userError';
    this.passwordErrorId='passwordError';
    this.errorOccurred=false;

    this.validate = function() {
    this.validateAndShowError(this.name, this.userPassRegex, this.userErrorId);
    this.validateAndShowError(this.password, this.userPassRegex, this.passwordErrorId);
    if (this.errorOccurred) {
        $('#invalidCridentialError').addClass('hidden');
    }
    }

    this.validateAndShowError = function(textval, regexToMatch, errorFieldId) {
    	if (regexToMatch.test(textval)) {
    		$('#'+errorFieldId).addClass('hidden');
    	} else {
    	    this.errorOccurred=true;
    		$('#'+errorFieldId).removeClass('hidden');
    	}
    }

    }


$('#login').click(function(){
    var username = $('#username').val();
    var password = $('#password').val();

    var login = new Login(username,password);
    login.validate();
    if (!login.errorOccurred) {
        document.getElementById("loginForm").submit();
    }

});

</script>
<html>