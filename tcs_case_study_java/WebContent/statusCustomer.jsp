	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.Dao.Customer" %>
    
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
 	  
   <% List<Customer> clist=(List<Customer>)request.getAttribute("all"); %>
  
   
   <table class="table table-hover">
    <h2> Customer Status</h2>
   <thead>
   		<tr>
	       <th>Customer ID</th>
	       
	       <th>Customer SSN ID</th>
	       
	       <th>Status</th>
	       
	       <th>Message</th>
	       
	       <th>Last Updated</th>
	       
	       <th>View Profile</th>
	       
	       <th>Operation</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%  for(Customer c: clist){%>
	      <tr >
	       		<td ><%=c.getCustomerID() %></td>
	       		<td><%=c.getCustomerSSNID() %></td>
	       		<td><%=c.getStatus() %></td>
	       		<td><%=c.getMessage() %></td>
	       		<td><%=c.getLastUpdated() %></td>
	       		<td><a href="profile?id=<%=c.getCustomerSSNID()%>"><button class="btn btn-success">View Profile</button></a></td>
	       		<td><a href="delete?id=<%=c.getCustomerID()%>"><button class="btn btn-danger">Delete</button></a></td>
	       		
	       </tr>
	    
	    <% } %>
	 </tbody>
	  
	   
   </table>

</center>

</body>
</html>