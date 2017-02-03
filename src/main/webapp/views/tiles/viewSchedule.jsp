<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-info">
		<div class="panel-heading">Schedule</div>
		<div class="panel-body"></div>
		<table class="table">
			<tr>
				<td colspan="2">${schedule.name} for ${schedule.entry.ename}
				</td>
				<c:forEach var="block" items="${blockList}">
					<tr>
						<td>${block.name }</td>
					</tr>
				</c:forEach>

			</tr>
		</table>
	</div>
</body>
</html>