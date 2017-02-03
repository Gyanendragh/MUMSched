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
<h1>Edit Selected Faculty</h1>
<form:form modelAttribute="editFaculty" method="post">
	<table >
	<tr>
			<td>Faculty Id </td>
			<td><form:input path="facultyId" type="text" value="${editFaculty.facultyId }" /></td>
			<td><form:errors path="facultyId" cssStyle="color:red;"></form:errors>
			</td>			
		</tr>
		<tr>
			<td>Faculty Name</td>
			<td><form:input path="fullName" type="text" value="${editFaculty.fullName }"/></td>
			<td><form:errors path="fullName" cssStyle="color:red;"></form:errors>
			</td>
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
<h1>Faculty List </h1>
<table class="table table-hover">
 <thead>
	<tr>
	<td>Faculty Id</td>
		<td>Faculty Name</td>
		
			<td>&nbsp;</td>

	</tr>
	</thead>
	<c:forEach var="faculty" items="${facultylist}">
	   <tbody>
		<tr>
			<td>${faculty.facultyId}</td>
			<td>${faculty.fullName}</td>

			<td><a href="<spring:url value="/faculty/edit/${faculty.id}"/>">Edit</a> | <a
				href="<spring:url value="/faculty/delete/${faculty.id}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>
