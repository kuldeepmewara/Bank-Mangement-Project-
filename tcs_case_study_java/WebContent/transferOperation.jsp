<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.Dao.CustomerAccount" %>
  <%@ page import ="java.util.List" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<CustomerAccount> l=(List<CustomerAccount>)request.getAttribute("tlist"); 

%>
<%@ include file="home.jsp"%>

 <div class="container col-7">
          
                <div class="card">
                
                   <caption>
                            <h2><center>Transfer Money</center>
                            </h2>
                        </caption>
                        
                    <div class="card-body">
                        
                     <form action="transfer" ,method="post">
                       <fieldset class="form-group">
                       
                          <label>Customer  ID</label>
                          <input type="Number"  class="form-control" readonly value="<%= l.get(0).getCustomerID() %>" name="cid" >
                       </fieldset>
                          
                       <fieldset class="form-group">
                          <label>Source Account</label>
	                          <select  required name="sacct" class="form-control">
	                          <% for(CustomerAccount ca :l) { %>
	                            <option><%=ca.getAccountID() %></option>
	                          <%} %>
	                     
	                          </select>
	                        </fieldset>
                          
                       <fieldset class="form-group">
                       
                          <label>Destination Account</label>
                          <select required name="dacct"class="form-control">
                          <% for(CustomerAccount ca :l) { %>
                            <option class="form-control"><%=ca.getAccountID() %></option>
                          <%} %>
                        
                          </select>
                       </fieldset>   
                       	   
                       <fieldset>
                          <label>Amount</label>
                           <input type="Number"  class="form-control" name="amount" required min="100" >
                       
                       </fieldset>
                       </br>
                         
                           <button type="submit" class="btn btn-success">Submit</button>
                       
                        
                        </form>
                    </div>
                </div>
            </div>
            

</body>
</html>