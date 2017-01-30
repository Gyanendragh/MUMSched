<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Login Form</h1>
<p><font color="red">${errorMessage}</font> </p>
<form action="<spring:url value="/postLogin"/>" method="post">
	<div class="input-group">
			<div><input type="text" name="username" id="email" class="form-control" name="userName" required="required" placeholder="userName"/></div>
			
	</div>
	<div class="input-group">
			<div><input type="password" name="password" id="password"  class="form-control" name="password" required="required" placeholder="Password"/></div>
	</div>
	<br>
	<input type="submit" value="LogIn" class="btn btn-default"/><br>
	
</form>
</div>
</body>
</html>
