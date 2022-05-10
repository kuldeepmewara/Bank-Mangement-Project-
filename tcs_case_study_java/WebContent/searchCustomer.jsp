<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="home.jsp"%>

 <div class="container col-7">
          
                <div class="card">
                
                   <caption>
                            <h2><center>Search Customer</center>
                            </h2>
                        </caption>
                        
                    <div class="card-body">
                        
                     
                     
                      <form action="searchCustomer" ,method="post">
                       <fieldset class="form-group">
                       
                          <label><h3>Customer SSN ID</h3></label>
                          <input type="Number"  class="form-control" name="ssnid" >
                             </fieldset>
                             <center><fieldset><label><strong>OR</strong></label></fieldset></center>
                           <label><h3>Customer  ID</h3></label>
                          <input type="Number"  class="form-control" name="id">
                             </fieldset>
                           </br>
                           <button type="submit" class="btn btn-success">Submit</button>
                       
                        
                        </form>
                    </div>
                </div>
            </div>
            

</body>
</html>