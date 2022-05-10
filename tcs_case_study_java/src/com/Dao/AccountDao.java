package com.Dao;

import java.util.*;  
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  
  
public class AccountDao {  
	
	

    public static Connection getConnection(){  
        Connection con=null;  
        String JdbcURL = "jdbc:mysql://localhost:3306/tcs?" + "autoReconnect=true&useSSL=false";
    	final String USER = "root";
    	final String PASS = "root";
    	
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection(JdbcURL,USER,PASS);  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static int save(Account a){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection(); 
            Customer c1=CustomerDao.getCustomerById2(a.getCustomerId());
            if(c1.getCity()!=null)
            {
            	
            	PreparedStatement ps=con.prepareStatement("insert into account(customerID,amount,accountType,status,message,lastUpdated) values (?,?,?,?,?,?)");  
                ps.setInt(1, a.getCustomerId());
                ps.setInt(2, a.getAmount());
                ps.setString(3, a.getActType());
                ps.setString(4, "active");
                ps.setString(5, "account creation complete");
                ps.setTimestamp(6, a.getLastUpdated());
   
                status=ps.executeUpdate();
            }
            else
            {
            	status=0;
            }
              
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    /*
    public static int update(Customer c){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
           	
            Calendar calendar = Calendar.getInstance();
	        java.util.Date currentTime = calendar.getTime();
	        
	        long time = currentTime.getTime();
            PreparedStatement ps=con.prepareStatement(  
                         "update customer set name=?,address=?,age=?,message=?,lastUpdated=? where customerSSNID=?");  
            ps.setString(1,c.getName());  
            ps.setString(2,c.getAddress());  
            ps.setInt(3,c.getAge());  
            ps.setString(4,"customer update complete");
            ps.setTimestamp(5,new Timestamp(time)); 
            ps.setInt(6, c.getCustomerSSNID());
         
            status=ps.executeUpdate();
           
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  */
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from account where accountID=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
    
    public static List<CustomerAccount> getAccountById(int id,int flag){  
    	 List<CustomerAccount> list=new ArrayList<CustomerAccount>();  
        try{  
            Connection con=AccountDao.getConnection(); 
            PreparedStatement ps;
			if(flag==1)
              ps =con.prepareStatement("select * from account a,customer c  where a.customerID=c.customerID and a.accountID=?");  
            else
              ps=con.prepareStatement("select * from account a,customer c  where a.customerID=c.customerID and c.customerID=?");  
             	
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery(); 
            
            while(rs.next()){  
            	
            	CustomerAccount ca=new CustomerAccount();
            	
            	ca.setAccountID(rs.getInt("accountId"));
            	ca.setAmount(rs.getInt("amount"));
            	ca.setActType(rs.getString("accountType"));
            	ca.setCustomerID(rs.getInt("customerID"));
            	ca.setStatus(rs.getString("status"));
            	ca.setMessage(rs.getString("Message"));
            	ca.setLastUpdated(rs.getTimestamp("lastUpdated"));
            	ca.setName(rs.getString("name"));
            	list.add(ca);  
            }  
            
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return list;  
    } 
    
    
    public static Account getAccount(int id,int cid){  
     Account a=new Account();
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from account where accountID=? and customerId=?");  
            ps.setInt(1, id);
            ps.setInt(2, cid);
            
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
               
            	a.setAccountID(rs.getInt("accountId"));
            	a.setAmount(rs.getInt("amount"));
            	a.setActType(rs.getString("accountType"));
            	a.setCustomerId(rs.getInt("customerID"));
              
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return a;  
    }

    
    public static List<Account> getAllAccounts(){  
        List<Account> list=new ArrayList<Account>();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from account");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Account a=new Account();  
               
            	a.setAccountID(rs.getInt("accountId"));
            	a.setAmount(rs.getInt("amount"));
            	a.setActType(rs.getString("accountType"));
            	a.setCustomerId(rs.getInt("customerID"));
            	a.setStatus(rs.getString("status"));
            	a.setMessage(rs.getString("Message"));
            	a.setLastUpdated(rs.getTimestamp("lastUpdated"));
            	list.add(a);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }

	public static int deposit(int aid,int cid ,int deposit) {
		
		int status=0;
		  try{  
	            Connection con=CustomerDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("update account set amount= amount + ? where accountID=? and customerID=?");  

	            ps.setInt(1, deposit);
	            ps.setInt(2, aid);
	            ps.setInt(3, cid);
	           
	            
	            status=ps.executeUpdate();  
	            
	            Calendar calendar = Calendar.getInstance();
		        java.util.Date currentTime = calendar.getTime();
		        
		        long time = currentTime.getTime(); 
		        System.out.print("\nstatus"+status);
		        if(status>0)
	            {
		        	ps=con.prepareStatement("insert into transaction(description,date,amount,saccountID,daccountID) values(?,?,?,?,?)");
		            ps.setString(1,"Deposit");
		            ps.setTimestamp(2,new Timestamp(time) );
		            ps.setInt(3, deposit);
		            ps.setInt(4, aid);
		            ps.setInt(5, aid);
		            ps.executeUpdate();
	            }
	          
   	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
		  return status;
				
	}

	public static int withdraw(int aid, int cid, int amount) {
		int status=0;
		  try{  
	            Connection con=CustomerDao.getConnection();
	            ResultSet rs;
	            PreparedStatement ps=con.prepareStatement("select amount from account where accountID=? and customerID=?");  
	            ps.setInt(1, aid);
	            ps.setInt(2, cid);
	            rs=ps.executeQuery();
	            int am=0;
	            if(rs.next())
	            {
	            	am=rs.getInt("amount");
		            	
	            }
	            if(am>=amount)
	            {
	            	ps=con.prepareStatement("update account set amount= amount - ? where accountID=? and customerID=?");  
		            ps.setInt(1, amount);
		            ps.setInt(2, aid);
		            ps.setInt(3, cid);
		            status=ps.executeUpdate();  
		            
		            Calendar calendar = Calendar.getInstance();
			        java.util.Date currentTime = calendar.getTime();
			        
			        long time = currentTime.getTime(); 
			        if(status>0)
		            {
			        	ps=con.prepareStatement("insert into transaction(description,date,amount,saccountID,daccountID) values(?,?,?,?,?)");
			            ps.setString(1,"Withdraw");
			            ps.setTimestamp(2,new Timestamp(time) );
			            ps.setInt(3, amount);
			            ps.setInt(4, aid);
			            ps.setInt(5, aid);
			            ps.executeUpdate();
			        }
		            
	            }
	            else
	            {
	            	status=-2;
	            }

	          con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
		  return status;
	}

	public static int transfer(int c, int sid, int did, int amount) {
		
		 int status=0;
		try{  
	            Connection con=CustomerDao.getConnection();  
	            ResultSet rs = null;
	            PreparedStatement ps;
	            int am=0;
	            ps=con.prepareStatement("select amount from account where accountID=?");  
	            ps.setInt(1, sid);
	            rs=ps.executeQuery();
	            if(rs.next())
	            {
	            	am=rs.getInt("amount");
	            }
	            if(am<amount)
	            {
	            	return -1	;
	            }
	            else
	            {
	            	int s1=AccountDao.withdraw(sid,c,amount);
                    
	            	int s2=AccountDao.deposit(did,c,amount);
	            	
	            	 Calendar calendar = Calendar.getInstance();
				     java.util.Date currentTime = calendar.getTime();
				        
				     long time = currentTime.getTime(); 
				     if(s1>0&&s2>0)
			         {
				        	ps=con.prepareStatement("insert into transaction(description,date,amount,saccountID,daccountID) values(?,?,?,?,?)");
				            ps.setString(1,"transfer");
				            ps.setTimestamp(2,new Timestamp(time) );
				            ps.setInt(3, amount);
				            ps.setInt(4, sid);
				            ps.setInt(5, did);
				            status=ps.executeUpdate();
				     }
			    }
	            
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
		return status;
	          
	}

	public static List<Transaction> getTransaction(int aid,int n) {
		
		List<Transaction> tlist=new ArrayList<Transaction>();  
		List<CustomerAccount> list=getAccountById(aid,1);
		if(list.size()==0)
		{
			return tlist;
		}
		else
	   {    
	        
	        try {
	        	Connection con=CustomerDao.getConnection();  
		        ResultSet rs = null;
		        PreparedStatement ps;
				ps=con.prepareStatement("select * from transaction where saccountID=? limit ?");
				ps.setInt(1, aid);
				ps.setInt(2, n);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					Transaction t=new Transaction();
					System.out.print("55555555555555555555555"+rs.getString("transactionID"));
					t.setTransactionid(rs.getString("transactionID"));
					t.setDate(rs.getTimestamp("date"));
					t.setAmount(rs.getString("amount"));
					t.setDescription(rs.getString("description"));
					
					tlist.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	       
			
		}
		return tlist;
	}



	

	
} 
