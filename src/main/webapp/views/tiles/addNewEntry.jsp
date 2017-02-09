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
	<h1>Add New Entry</h1>
	<form:form modelAttribute="newEntry" method="post">
		<table>

			<tr>
				<td>Entry Name</td>
				<td><select name="entryName">
						<option value="">--Select Entries--</option>
						<option value="January">January</option>
						<option value="April">April</option>
						<option value="August">August</option>
						<option value="November">November</option>
				</select></td>
				<td><form:errors path="entryName" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Entry Year</td>
				<td><form:input path="entryYear" type="text" /></td>
				<td><form:errors path="entryYear" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Number of FPP Students</td>
				<td><form:input path="noOfFppStudents" type="text" /></td>
				<td><form:errors path="noOfFppStudents" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Number of MPP Students</td>
				<td><form:input path="noOfMppStudents" type="text" /></td>
				<td><form:errors path="noOfMppStudents" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Number of US Resident</td>
				<td><form:input path="noOfUsResident" type="text" /></td>
				<td><form:errors path="noOfUsResident" cssStyle="color:red;"></form:errors>
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
	<h1>Entry List</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>Entry Name</td>
				<td>Entry Year</td>
				<td>Number of FPP Students</td>
				<td>Number of MPP Students</td>
				<td>Number of US Resident</td>
				<td>&nbsp;</td>

			</tr>
		</thead>
		<c:forEach var="entry" items="${entrylist}">
			<tbody>
				<tr>

					<td>${entry.entryName}</td>

					<td>${entry.entryYear}</td>

					<td>${entry.noOfFppStudents}</td>

					<td>${entry.noOfMppStudents}</td>

					<td>${entry.noOfUsResident}</td>


					<td><a
						href="<spring:url value="/entry/edit/${entry.entryId}"/>">Edit</a>
						| <a href="<spring:url value="/entry/delete/${entry.entryId}"/>">Delete</a></td>

				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
</html>
