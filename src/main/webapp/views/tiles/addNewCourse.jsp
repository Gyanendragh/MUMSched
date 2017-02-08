<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
	font-size: 16px;
}
</style>
</head>
<jsp:include page='home.jsp'>
	<jsp:param name="articleId" value="" />
</jsp:include>
<div align="center">
	<h1>Add New Course</h1>
	<form:form modelAttribute="newCourse" method="post">

		<table>

			<tr>
				<td>Course Name</td>
				<td><form:input path="courseName" type="text" /></td>
				<td><form:errors path="courseName" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Course Number</td>
				<td><form:input path="courseNumber" type="text" /></td>
				<td><form:errors path="courseNumber" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Course Level</td>
				<td><form:input path="courseLevel" type="text" /></td>
				<td><form:errors path="courseLevel" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Prerequisite</td>
				<td><form:select path="prerequisite">
						<form:option value="" label="--- Select Course ---" />
						<c:forEach var="course" items="${courseLists}">
							<form:option value="${course.courseId}"
								label="${course.courseName}" />
						</c:forEach>
					</form:select></td>
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
	<h1>Course List</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>Course Name</td>
				<td>Course Number</td>
				<td>Course Level</td>
				<td>Prerequisites</td>
				<td>&nbsp;</td>

			</tr>
		</thead>
		<c:forEach var="course" items="${courselist}">
			<tbody>
				<tr>

					<td>${course.courseName}</td>

					<td>${course.courseNumber}</td>

					<td>${course.courseLevel}</td>
					<td>
					<c:choose>
						<c:when test="${course.prerequisite ==3 }">
							SWE
						</c:when>
						<c:when test="${course.prerequisite ==15}">
							DBMS
						</c:when>
						<c:when test="${course.prerequisite ==1 }">
							FPP
						</c:when>
						<c:when test="${course.prerequisite ==2 }">
							MPP
						</c:when>
						<c:when test="${course.prerequisite ==5}">
							WAP
						</c:when>
					</c:choose>
					</td>
					<td><a href="<spring:url value="/course/edit/${course.courseId}"/>">Edit</a> | 
					<a href="<spring:url value="/course/delete/${course.courseId}"/>">Delete</a>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
</html>
