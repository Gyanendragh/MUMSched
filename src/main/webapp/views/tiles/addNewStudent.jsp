<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
    font-size: 16px;
}
</style>
</head>
<jsp:include page='home.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<div align="center">
<h1>Add New Student</h1>
<form:form modelAttribute="newStudent" method="post">
	<table >
		<tr>
			<td>Student Name</td>
			<td><form:input path="fullName" type="text" /></td>
			<td><form:errors path="fullName" cssStyle="color:red;"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Student Id Number</td>
			<td><form:input path="studentIdNumber" type="text" /></td>
			<td><form:errors path="studentIdNumber" cssStyle="color:red;"></form:errors>
			</td>
		</tr>
		<tr>
				<td>Student Entry</td>
				<td><select name="studentEntry">
						<option value="">--Select Entries--</option>
						<option value="January">January</option>
						<option value="April">April</option>
						<option value="August">August</option>
						<option value="November">November</option>
					</select>
				</td>
				<td><form:errors path="studentEntry" cssStyle="color:red;"></form:errors></td>
		</tr>
		
		<tr>
			<td></td>
			<td>
				<button>Save</button>
			</td>
		</tr>
	
	</table>
</form:form>
</div>

<div align="left">
<h1>Student List </h1>
<table class="table table-hover">
 <thead>
	<tr>
		
		<td>Student Name</td>
		<td>Student Id Number</td>
		<td>Student Entry</td>
			<td>&nbsp;</td>

	</tr>
	</thead>
	<c:forEach var="student" items="${studentlist}">
	   <tbody>
		<tr>
			<td>${student.fullName}</td>
			<td>${student.studentIdNumber}</td>
			<td>${student.studentEntry}</td>

			<td><a href="<spring:url value="/student/edit/${student.studentId}"/>">Edit</a> | <a
				href="<spring:url value="/student/delete/${student.studentId}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>
