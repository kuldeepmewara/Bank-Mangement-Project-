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
                            <h2><center>Enter Customer ID</center>
                            </h2>
                        </caption>
                        
                    <div class="card-body">
                        
                     
                     
                      <form action="transferOperation" ,method="post">
                       <fieldset class="form-group">
                       
                          <label><h3>Customer  ID</h3></label>
                          <input type="Number"  class="form-control" name="cid" >
                             </fieldset>
                          </br>
                           <button type="submit" class="btn btn-success">Submit</button>
                       
                        
                        </form>
                    </div>
                </div>
            </div>
            

</body>
</html>