<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>



<body>

	<form action=loginController1 method="post" name="form1">
		<div class="container col-7">

			<div class="card">
				<div class="card-body">

					<caption>
						<h2>Login Screen</h2>
					</caption>

					<fieldset class="form-group">

						<label>Login</label> <input type="text" name="login" minlength="8" required
							class="form-control"> 
							
						<label>Password</label> <input
							type="password" name="password"  minlength="10" maxlength="10" required class="form-control">
							
							
							</br><button  type="submit" value="submit" class="btn btn-success">Submit</button></td>

					</fieldset>
					
					
	</form>
</body>
</html>