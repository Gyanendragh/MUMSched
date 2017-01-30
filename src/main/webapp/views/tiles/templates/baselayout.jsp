<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>
<tiles:insertAttribute name="css"/>
<tiles:insertAttribute name="js"/>
</head>
<style>
	#maincanvass{
		margin-top:50px;
		margin-left:50px;
		margin-right:50px;
	}
</style>
<body>
	<div id="maincanvass">
		<tiles:insertAttribute name="navigation" />
		<tiles:insertAttribute name="heading" />
		<tiles:insertAttribute name="tagline" />
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
	
</body>
</html>
