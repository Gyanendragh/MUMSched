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
<h1>Edit Selected Block</h1>
<form:form modelAttribute="editBlock" method="post">
	<table >
	
		<tr>
			<td>Block Name</td>
			<td><form:input path="blockName" type="text" /></td>
			<td><form:errors path="blockName" cssStyle="color:red;"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Block Number </td>
			<td><form:input path="blockId" type="text" /></td>
			<td><form:errors path="blockId" cssStyle="color:red;"></form:errors>
			</td>			
		</tr>
		<tr>
			<td>Block Start Date</td>
				<td><form:input path="blockStartDate" type="text" /></td>
			<td><form:errors path="blockStartDate" cssStyle="color:red;"></form:errors>
			</td>			
		</tr>
			<tr>
			<td>Block End Date</td>
				<td><form:input path="blockEndDate" type="text" /></td>
			<td><form:errors path="blockEndDate" cssStyle="color:red;"></form:errors>
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
<h1>Block List </h1>
<table class="table table-hover">
 <thead>
	<tr>
		<td>Block Name</td>
		<td>Block Number</td>
		<td>blockStartDate</td>
		<td>blockEndDate</td>
		<td>&nbsp;</td>

	</tr>
	</thead>
	<c:forEach var="block" items="${blocklist}">
	   <tbody>
		<tr>
			
			<td>${block.blockName}</td>

			<td>${block.blockId}</td>

			<td>${block.blockStartDate}</td>

			<td>${block.blockEndDate}</td>
			


			<td><a href="<spring:url value="/block/edit/${block.id}"/>">Edit</a> | <a
				href="<spring:url value="/block/delete/${block.id}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>
