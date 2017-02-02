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
<body>
	<jsp:include page='home.jsp'>
		<jsp:param name="articleId" value="" />
	</jsp:include>

	<div class="panel panel-success">
		<div class="panel-heading">Add New Schedule</div>
		<div class="panel-body"></div>
		<form:form modelAttribute="newSchedule" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:select path="name">
							<form:option value="NONE" label="--- Select Entry ---" />
							<c:forEach var="entry" items="${entryList}">
								<form:option value="${entry.id}" label="${entry.ename}" />
							</c:forEach>
						</form:select></td>
					<td>
						<button>Create Schedule</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>

	<div class="panel panel-info">
		<div class="panel-heading">Schedule List</div>
		<div class="panel-body"></div>
		<table class="table table-hover">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>ACTION</td>
			</tr>
			<c:forEach var="schedule" items="${scheduleList}">
				<tbody>
					<tr>
						<td>${schedule.id}</td>
						<td>${schedule.name}</td>
						<td><a
							href="<spring:url value="/schedule/view/${schedule.id}"/>">View</a>
							| <a href="<spring:url value="/schedule/edit/${schedule.id}"/>">Edit</a>
							| <a href="<spring:url value="/schedule/delete/${schedule.id}"/>">Delete</a>

						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>