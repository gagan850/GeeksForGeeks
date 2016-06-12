<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>    
<head> 
<spring:url value="/resources/style.css" var="CSS" /> 
  <link rel="stylesheet" type="text/css" href="${CSS}">
</head>

<body>

	<spring:message code="add.button" var="addButton" />
	<spring:message code="modify.button" var="modifyButton" />
	<spring:message code="delete.button" var="deleteButton" />
	<spring:message code="save.button" var="saveButton" />
	<spring:message code="actions.text" var="actions" />
	<spring:message code="rollnumber.text" var="rollNumber" />
	<spring:message code="name.text" var="name" />
	<spring:message code="age.text" var="age" />
	<spring:message code="address.text" var="address" />
	



	<c:choose>
    <c:when test="${StudentForm.action=='update'}">
    <c:url var="actionUrl" value="/students/save/${StudentForm.modifyStudent.rollNumber}"/>
    </c:when>
    <c:otherwise>
        <c:url var="actionUrl" value="/students/add"/>    
      </c:otherwise>
      </c:choose>

<form:form action="${actionUrl}" modelAttribute="StudentForm"  method="get">
      			
      			
    
  		<c:if test="${StudentForm.status=='error'}">
 <div class="errormsg">
  
    <spring:hasBindErrors name="StudentForm">
      <c:forEach var="error" items="${errors.allErrors}">        
         <ul>
         ${error.defaultMessage}
          </ul>
      </c:forEach>
</spring:hasBindErrors>
<ul>${StudentForm.message}</ul>
  

</div>
    </c:if>    	
	<c:if test="${StudentForm.status=='success'}">
<div><c:out value="${StudentForm.message}"/></div>
    </c:if> 
Language : <a href="?locale=en">English</a>|<a href="?locale=zh_CN">Chinese</a>

<div class="alert alert-danger">Hi ${StudentForm.userName} |<a href="/StudentManagement3/logout">Log Out</a></div>

<table class="table table-striped table-bordered">
        
        <thead><tr><th>${rollNumber}</th><th>${name}</th><th>${age}</th><th>${address}</th>        
        <th>${actions}</th>
        
        </tr></thead>
        <tbody>
    <c:forEach var="student1" items="${StudentForm.studentList}">
   
    <c:choose>
    <c:when test="${StudentForm.action=='update' && StudentForm.modifyStudent.rollNumber==student1.rollNumber}">
      <tr><td>${student1.rollNumber}</td><td><form:input type="text" path="modifyStudent.name" value="${student1.name}"/></td><td><form:input type="text" path="modifyStudent.age" value="${student1.age}"/></td><td><form:input type="text" path="modifyStudent.address" value="${student1.address}"/></td><td><input type="submit" value="${saveButton}"/></td></tr>  
    </c:when>
    <c:otherwise>
      <tr><td>${student1.rollNumber}</td><td>${student1.name}</td><td>${student1.age}</td><td>${student1.address}</td>
      <td>
      <a href="/StudentManagement3/students/update/${student1.rollNumber}"> ${modifyButton}</a>
      <a href="/StudentManagement3/students/remove/${student1.rollNumber}"> ${deleteButton}</a>
      </td>
              
      </tr>  
      </c:otherwise>
      				</c:choose>
    </c:forEach>
   
    <tr id="addStudent" class="hidden"><td><form:input type="text" path="addStudent.rollNumber"></form:input></td><td><form:input type="text" path="addStudent.name"/></td><td><form:input type="text" path="addStudent.age"/></td><td><form:input type="text" path="addStudent.address"/></td><td><input type="submit" class="btn btn-info btn-sm" value="save"/></td></tr>  
    </tbody>
  </table>    
	<c:if test="${StudentForm.action!='update'}">
		<input type="button" value="${addButton}" class="btn btn-info btn-lg" id="addStudentButton" onclick="addStudent()"/>
    </c:if>    
  </form:form>
</body>

<script src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
<script type="text/javascript">
function addStudent() {
    $("#addStudent").removeClass("hidden");
    $("#addStudentButton").addClass("hidden");
    }

</script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</html>