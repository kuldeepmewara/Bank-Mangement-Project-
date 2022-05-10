<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ page import ="java.util.List" %>
<%@ page import="com.Dao.Transaction" %>
<%@ include file="home.jsp"%>

 <div class="container col-7">
          
                <div class="card">
                
                   <caption>
                            <h2><center>Account Statement</center>
                            </h2>
                        </caption>
                        
                    <div class="card-body">
                        
                     
                     
                      <form action="statementOperation" ,method="post">
                       <fieldset class="form-group">
                       
                          <label>Account  ID</label>
                          <input type="Number"  class="form-control" required name="aid" >
                             </fieldset>
                              
                          <label>Last N transaction</label>
                          <select required name="trans" required class="form-control">
                          <% for(int i=1;i<10;i++) { %>
                            <option class="form-control"><%=i %></option>
                          <%} %>
                        
                          </select>  
                           
                          </br>
                           <button type="submit" class="btn btn-success">Submit</button>
                       
                        
                        </form>
                        </div>
                        </div>
                        <%  if(request.getAttribute("tlist") ==null){ %>
                            
                          <div></div>
                        <% }
                        
                        else
                        {  
                           List<Transaction>  tlist=(List<Transaction>)request.getAttribute("tlist");
                           %>
                          
                            <table class="table table-hover">
                            <thead>
                           		<tr>
	                             <th>Transaction ID</th>
	                             <th>Description</th>
	                             <th>Date</th>
	                             <th>Amount</th>
	                           </tr>
	                           
                            </thead>
                            <tbody>
                            <% for(Transaction t:tlist ) { %>
                              <tr>


								<td><%=t.getTransactionid() %></td>
								<td><%=t.getDescription() %></td>
								<td><%=t.getDate().toString().substring(0, 10)%></td>
								<td><%=t.getAmount()%></td>
			
							</tr>
                           
                           
                           <%
                                                                                 	}
                                                                                 %>
                           </tbody>
                           
                           </table>
                        
                        <%} %>
                 
            </div>
            

</body>
</html>