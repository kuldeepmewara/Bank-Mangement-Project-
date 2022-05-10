	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.Dao.Account" %>
    
    <%@ page import ="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>  
   <%@ include file="home.jsp" %>
 	  
   <% List<Account> alist=(List<Account>)request.getAttribute("all"); %>
  
   
   <table class="table table-hover">
    <h2> Account Status</h2>
   <thead>
   		<tr>
	       <th>Customer ID</th>
	       
	       <th>Account ID</th>
	       
	        <th>Account Type</th>
	       
	       
	       <th>Amount</th>
	       
	       <th>Status</th>
	       
	       <th>Message</th>
	       
	        <th>Last Updated</th>
	       
	       <th>Operation</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%  for(Account a: alist){%>
	      <tr >
	       		<td ><%=a.getCustomerId() %></td>
	       		<td><%=a.getAccountID() %></td>
	       		<td><%=a.getActType() %></td>
	       		<td><%=a.getAmount() %></td>
	       		<td><%=a.getStatus() %></td>
	       		<td><%=a.getMessage() %></td>
	       		<td><%=a.getLastUpdated() %></td>
	       		<td><a href="deleteAccnt?id=<%=a.getAccountID()%>"><button class="btn btn-danger">Delete</button></a></td>
	       		
	       </tr>
	    
	    <% } %>
	 </tbody>
	  
	   
   </table>
   
   <a href="statusAccount"><button class="btn btn-warning">Refresh The List</button></a>

</center>

</body>
</html>