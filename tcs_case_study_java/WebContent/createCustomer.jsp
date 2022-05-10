<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="home.jsp" %>

<div class="container col-7">
			<div class="card">
				<div class="card-body">

					<caption>
					<h1>Create Customer</h1>

					</caption>

					<form action=createCustomer method="post">


						<fieldset>

							<label>Customer SSN ID</label> 
							<input type="Number" name="ssnid" class="form-control" minlength="9" maxlength="9"  required/> 
								
							<label>Name</label> 
							<input type="text" name="name" class="form-control" required>
								
								
							<label>Age</label> 
							<input type="Number" name="age" min=18 maxlength="3" class="form-control" required> 
								
							<label>Address</label> 
							<input type="text" name="address" class="form-control" required>
							
							
							<label>State</label> 
							<select name="state" class="form-control">
								<option>state 1</option>
								<option>state 2</option>
								<option>state 3</option>
			    			</Select>
								
							<label>City</label> 
							<Select name="city" class="form-control">
								<option>city 1</option>
								<option>city 2</option>
								<option>city 3</option>
					    	</Select>
									
							</br>		
						   <input type="submit" class="btn btn-success" name="submit"/>
						
								<input type="reset" class="btn btn-info" name="reset"/>
										
						   

						</fieldset>
						
						
					</form>


</body>
</html>