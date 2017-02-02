<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<form:form modelAttribute="editCourse" method="post">
	<table >
	
		<tr>
			<td>Course Name</td>
			<td><form:input path="cname" type="text" value="${editCourse.cname}"/></td>
			<td><form:errors path="cname" cssStyle="color:red;"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Course Number </td>
			<td><form:input path="cnumber" type="text" value="${editCourse.cnumber}"/></td>
			<td><form:errors path="cnumber" cssStyle="color:red;"></form:errors>
			</td>			
		</tr>
			<tr>
			<td>Course Prerequisites</td>
			<td><select name="prerequisites">
					<option value="mpp"  <c:if test="${editCourse.prerequisites=='mpp'}">selected</c:if>>Modern Application Programming</option>
					<option value="wap" <c:if test="${editCourse.prerequisites=='wap'}">selected</c:if>>Wave Application Programming</option>
					<option value="dbms" <c:if test="${editCourse.prerequisites=='dbms'}">selected</c:if>>Database Management system</option>
					<option value="swe" <c:if test="${editCourse.prerequisites=='swe'}">selected</c:if>>Software Engineer</option>
			</select></td>			
		</tr>
			<tr>
			<td>Faculty</td>
			<td><select name="faculty">
					<option value="nolle" <c:if test="${editCourse.faculty=='nolle'}">selected</c:if>>Prof. Nolle</option>
					<option value="lerman" <c:if test="${editCourse.faculty=='lerman'}">selected</c:if>>Prof. Lerman</option>
					<option value="saad" <c:if test="${editCourse.faculty=='saad'}">selected</c:if>>Prof Saad</option>
					<option value="arrocha" <c:if test="${editCourse.faculty=='arrocha'}">selected</c:if>>Prof. Arrocha</option>
					<option value="bruen" <c:if test="${editCourse.faculty=='bruen'}">selected</c:if>>Prof. Bruen</option>
			</select></td>			
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
<h1>Course Details </h1>
<table class="table table-hover">
 <thead>
	<tr>
		<td>Course Name</td>
		<td>Course Number</td>
		<td>Prerequisites</td>
		<td>Faculty</td>
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