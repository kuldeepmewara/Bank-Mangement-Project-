
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Dao.CustomerAccount"%>

<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%@ include file="home.jsp"%>

		<%
			List<CustomerAccount> clist = (List<CustomerAccount>) request.getAttribute("cusAct");
		%>


		<table class="table table-hover">
			<h2>Customer Account</h2>
			<thead>
				<tr>
					<th>Customer ID</th>

					<th>Name</th>

					<th>Account ID</th>



					<th>Message</th>



					<th>Last Updated</th>
					<th>Account Type</th>
					<th>Amount</th>

					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (CustomerAccount ca : clist) {
				%>
				<tr>
					<td><%=ca.getCustomerID()%></td>
					<td><%=ca.getName()%></td>
					<td><%=ca.getAccountID()%></td>
					<td><%=ca.getMessage()%></td>
					<td><%=ca.getLastUpdated()%></td>

					<td><%=ca.getActType()%></td>
					<td><%=ca.getAmount()%></td>
					<td><%=ca.getStatus()%></td>

				</tr>

				<%
					}
				%>
			</tbody>


		</table>

	</center>

</body>
</html>