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
<h1>Add New Course</h1>
<form:form modelAttribute="newCourse" method="post">
	
	<table >
	
		<tr>
			<td>Course Name</td>
			<td><form:input path="cname" type="text" /></td>
			<td><form:errors path="cname" cssStyle="color:red;"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Course Number </td>
			<td><form:input path="cnumber" type="text" /></td>
			<td><form:errors path="cnumber" cssStyle="color:red;"></form:errors>
			</td>			
		</tr>
		<tr>
			<td>Course Prerequisites</td>
			<td><select name="prerequisites">
					<option value="mpp">Modern Application Programming</option>
					<option value="wap">Wave Application Programming</option>
					<option value="dbms">Database Management system</option>
					<option value="swe">Software Engineer</option>
			</select></td>			
		</tr>
		 <tr>
                <td>Faculties</td>
               <td><input type="checkbox" name="faculty" value="Nolle" />Pro Nolle
               		<input type="checkbox" name="faculty" value="Arrocha" />Pro Arrocha
               		<input type="checkbox" name="faculty" value="Lerman" />Pro Lerman
               		<input type="checkbox" name="faculty" value="Saad" />Pro Saad
               		<input type="checkbox" name="faculty" value="Bruen" />Pro Bruen
               		<input type="checkbox" name="faculty" value="Ruby" />Pro Ruby
               		<input type="checkbox" name="faculty" value="Renuka" />Pro Renuka
               		
               	</td>
                <td><form:errors path="faculty" cssClass="error"></form:errors></td>
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
<h1>Course List </h1>
<table class="table table-hover">
 <thead>
	<tr>
		<td>Course Name</td>
		<td>Course Number</td>
		<td>Prerequisites</td>
		<td>Faculties</td>
		<td>&nbsp;</td>

	</tr>
	</thead>
	<c:forEach var="course" items="${courselist}">
	   <tbody>
		<tr>
			
			<td>${course.cname}</td>

			<td>${course.cnumber}</td>

			<td>${course.prerequisites}</td>

			<td>${course.faculty}</td>
			


			<td><a href="<spring:url value="/course/edit/${course.courseId}"/>">Edit</a> | <a
				href="<spring:url value="/course/delete/${course.courseId}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>
