<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Dao.Account" %>

<%@ include file="home.jsp" %>

            <div class="container col-7">
            <% Account user= (Account)request.getAttribute("account"); %>
                <div class="card">
                    <div class="card-body">
                        
                        <caption>
                         <h2>Deposit Screen</h2>
                        </caption>
                         <form action="DepositOperation" method="post">
                       <fieldset class="form-group">
                       
                            <label>Customer  ID</label> <input type="text" readonly value="<%= user.getCustomerId()%>" class="form-control" name="cid">
                            <label>Account ID</label> <input type="text" readonly value="<%= user.getAccountID()%>" class="form-control" name="aid">
                            
                            <label>AccountType</label> <input type="text" readonly value="<%= user.getActType()%>" class="form-control" name="type">
                            <label>Balance</label> <input type="text" readonly value="<%= user.getAmount()%>" class="form-control" name="balance">
                            
                            <label>Deposit</label> <input type="text"   class="form-control" name=amount>
                           
                        </fieldset>

                       
                       
                           <button type="submit" class="btn btn-success">Ok</button>
                        </form>
                    </div>
                </div>
            </div>
       </body>
       </html>