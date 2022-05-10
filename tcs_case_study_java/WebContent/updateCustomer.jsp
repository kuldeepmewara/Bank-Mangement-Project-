<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<%@ include file="home.jsp"%>

 <div class="container col-7">
          
                <div class="card">
                    <div class="card-body">
                        
                        <caption>
                            <h2>Enter Customer SSN ID
                            </h2>
                        </caption>
                        
                        </br>
                        </br>
                        </br>
                        
                        
                      <form action="updateCustomer",method="get">
                       <fieldset class="form-group">
                       
                          <label><h3>Customer SSN ID</h3></label>
                          <input type="Number"  class="form-control" name="ssnid" required>
                             </fieldset>

                           <button type="submit" class="btn btn-success">Submit</button>
                       
                        
                        </form>
                    </div>
                </div>
            </div>
            
</center>

</body>
</html>