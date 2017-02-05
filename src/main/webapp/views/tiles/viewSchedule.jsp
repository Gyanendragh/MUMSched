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
	<jsp:include page='home.jsp'>
		<jsp:param name="articleId" value="" />
	</jsp:include>

	<div class="panel panel-info">
		<div class="panel-heading">${schedule.name}</div>
		<div class="panel-body">
			<table class="table">
				<c:forEach var="block" items="${schedule.blockList}">
					<tr>
						<td>${block.blockName}
							<ul class="list-group">
							<c:forEach var="section" items="${block.sectionList}">
								<li class="list-group-item">"${section.sectionName}"</li>
							</c:forEach>
							</ul>
						</td>

					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>