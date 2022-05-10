<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Dao.Customer" %>

<%@ include file="home.jsp" %>

            <div class="container col-7">
            <% Customer user= (Customer)request.getAttribute("user"); %>
                <div class="card">
                    <div class="card-body">
                        
                        <caption>
                            <h2>
                             <%=user.getName() %> Profile Screen
                            </h2>
                        </caption>
                        
                       <fieldset class="form-group">
                       
                            <label>Customer SSN ID</label> <input type="text" readonly value="<%= user.getCustomerSSNID()%>" class="form-control" name="ssnid">
                            <label>Customer ID</label> <input type="text" readonly value="<%= user.getCustomerID()%>" class="form-control" name="id">
                            
                            <label>Name</label> <input type="text" readonly value="<%= user.getName()%>" class="form-control" name="name">
                            <label>Age</label> <input type="text" readonly value="<%= user.getAge()%>" class="form-control" name="age">
                            
                            <label>State</label> <input type="text" readonly value="<%= user.getState()%>" class="form-control" name="state">
                            <label>City</label> <input type="text" readonly value="<%= user.getCity()%>" class="form-control" name="city">
                            
                            
                            <label>Address</label> <input type="text" readonly value="<%= user.getAddress()%>" class="form-control" name="address">
                            <label>Status</label> <input type="text" readonly value="<%= user.getStatus()%>" class="form-control" name="status">
                            
                            <label>Message</label> <input type="text" readonly value="<%= user.getMessage()%>" class="form-control" name="message">
                            <label>Last Updated on</label> <input type="text" readonly value="<%= user.getLastUpdated()%>" class="form-control" name="updated">
                      
                        </fieldset>

                       
                        <form action="statusCustomer">
                           <button type="submit" class="btn btn-success">Ok</button>
                        </form>
                    </div>
                </div>
            </div>
       </body>
       </html>