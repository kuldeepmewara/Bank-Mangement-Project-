<html>

<head>
<title>Bank Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="main.css" rel="stylesheet">

<style>
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
	margin-left: 10px;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>

</head>

<body>
<%
	HttpSession s = request.getSession(false);
if (session == null) {
	
	out.print("Please login first");
	request.getRequestDispatcher("index.jsp").include(request, response);
}
%>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="home.jsp" class="navbar-brand">Online Bank Management
					App</a>
			</div>



			<ul class="navbar-nav" style="color: white">
				<span class="dropdown"> <a href="home.jsp"><button
							class="dropbtn">Home</button></a>
				</span>

				<span class="dropdown">
					<button class="dropbtn">Customer Management</button>
					<div class="dropdown-content">
						<li><a href="createCustomer.jsp">CreateCustomer</a>
						<li><a href="updateCustomer.jsp">Update Customer</a>
						<li><a href="statusCustomer">Status Customer</a>
						<li><a href="searchCustomer.jsp">Search Customer</a>
					</div>
				</span>


				<span class="dropdown">
					<button class="dropbtn">Account Management</button>
					<div class="dropdown-content">
						<li><a href="createAccount.jsp">Create Account</a>
						<li><a href="statusAccount">Status Account</a>
						<li><a href="searchAccount.jsp">Search Account</a>
					</div>
				</span>

				<span class="dropdown">
					<button class="dropbtn">Account Operations</button>
					<div class="dropdown-content">
						<li><a href="deposit">Deposit</a>
						<li><a href="withdraw">Withdraw</a>
						<li><a href="transfer.jsp">Transfer</a>
						<li><a href="statement.jsp">Statement</a>
					</div>
				</span>


				<span class="dropdown"> <a href="logout"><button
							class="dropbtn">Logout</button></a>
				</span>


			</ul>

		</nav>
	</header>
	<br>