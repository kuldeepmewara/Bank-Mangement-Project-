<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</style>
</head>
<body>

	<%@ include file="home.jsp"%>

	<div class="container col-7">
		<div class="card">
			<div class="card-body">

				<caption>
					<h1>Create Account</h1>

				</caption>

				<form action=createAccount method="post">


					<fieldset class="form-group">

						<label>Customer ID</label>
						<input type="Number" name="id" pattern="\d{9}"
							class="form-control" required maxlength="9"/> 
					</fieldset>
					
					<fieldset class="form-group">
						<label>Account Type</label>
						<select name="type" class="form-control">
							<option>Saving</option>
							<option>Current</option>
						</Select> 
					</fieldset>
						
					<fieldset class="form-group">
						
						<label>Deposit Amount</label>
						<input type="Number" name="amount" pattern="[0-9]"
							class="form-control" required min=100 /> 
						
					</fieldset>
						
					<fieldset class="form-group">
					
						<input type="submit" class="btn btn-success" name="submit" /> 
					</fieldset>


				</form>
</body>
</html>