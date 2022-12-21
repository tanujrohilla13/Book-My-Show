<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron bg-warning">
	<h1> <p class="text-center">Admin Login Page</p></h1>
	</div>
        <div class="container">
	<form action="../AdminAuth" method="post">
	<div class="row ">
		<div class="col-md-6 ">
		<div class="d-flex justify-content-around">
		username:
		</div>
			 
	
		</div>
		<div class="col-md-6">
		<input type="text" name="txtUnm" class="form-control"/>
		</div>
	</div>
	<div class="row mt-3 ">
		<div class="col-md-6 ">
		<div class="d-flex justify-content-around">
		password:
		</div>
	
		</div>
		<div class="col-md-6">
		<input type="password" name="txtPwd" class="form-control"/>
		</div>
	</div>
	
	<div class="row ">
		<div class="col-md-12 mt-5">
		<div class="d-flex justify-content-around">
			<input type="submit" value="login1" class="btn btn-info"/>
			<a href='#' class="btn btn-warning"> newuser ...?</a>
			
		</div>
			 
	
		</div>
		
	</div>
	</form>
</div>

</body>
</html>