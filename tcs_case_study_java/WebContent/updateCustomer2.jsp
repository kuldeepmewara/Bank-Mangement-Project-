<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Dao.Customer"%>


		<%@ include file="home.jsp"%>
		
		<%
			Customer c = (Customer) request.getAttribute("customer");
		%>
		<%
			session.setAttribute("customer", c);
		%>

		<div class="container col-7">
			<div class="card">
				<div class="card-body">

					<caption>
					<h1>Update Customer</h1>

					</caption>

					<form action="updateCustomer" method="post">

						<fieldset>

							<label>Customer SSN ID</label> 
							<input type="text" readonly
								value="<%=c.getCustomerSSNID()%>" class="form-control"> 
								
							<label>Customer ID</label> 
							<input type="text" readonly value="<%=c.getCustomerID()%>"
								class="form-control">
								
								
							<label>Old Customer name</label> 
							<input type="text" readonly
								value="<%=c.getName()%>" class="form-control"> 
								
							<label>New Customer Name</label> 
							<input type="text" class="form-control" name="name">
							
							
							<label>Old Customer Address</label> 
							<input type="text" readonly
								value="<%=c.getAddress()%>" class="form-control"> 
								
							<label>New Customer Address</label> 
							<input type="text" class="form-control" name="address">
							
							
							<label>Old Customer Age</label> 
							<input type="text" readonly
								value="<%=c.getAge()%>" class="form-control"
								name="ssnid"> 
								
							<label>New Customer Age</label> 
							<input type="Number" min=18 class="form-control" name="age">
							
							</br>
							<button type="submit" class="btn btn-success">Update</button>

						</fieldset>
						
						
					</form>
	</center>

</body>
</html>