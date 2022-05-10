package com.Dao;

import java.util.*;  
import java.sql.*;  
  
public class CustomerDao {  
	
	

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
    
    public static int save(Customer c){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection(); 
            Customer c1=getCustomerById(c.getCustomerSSNID());
            if(c1.getCity()==null)
            {
            	
            	PreparedStatement ps=con.prepareStatement("insert into customer(customerSSnID,name,address,city,state,age,status,message,lastUpdated) values (?,?,?,?,?,?,?,?,?)");  
                ps.setInt(1, c.getCustomerSSNID());
                ps.setString(2, c.getName());
                ps.setString(3, c.getAddress());
                ps.setString(4, c.getCity());
                ps.setString(5, c.getState());
                ps.setInt(6, c.getAge());
                ps.setString(7,"active");
                ps.setString(8, "customer Created Successfully");
                ps.setTimestamp(9, c.getLastUpdated());
                
   
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
    }  
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from customer where customerid=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
            ps=con.prepareStatement("delete from account where customerid=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();  
               
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
    
    public static Customer getCustomerById(int id){  
        Customer c=new Customer();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer where customerSSNID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
               c.setCity(rs.getString("city"));
               c.setAddress(rs.getString("address"));
               c.setAge(rs.getInt("age"));
               c.setCustomerID(rs.getInt("customerID"));
               c.setCustomerSSNID(rs.getInt("customerSSNId"));
               c.setState(rs.getString("state"));
               c.setName(rs.getString("name"));
               c.setStatus(rs.getString("status"));
               c.setMessage(rs.getString("message"));
                
               c.setLastUpdated(rs.getTimestamp("lastUpdated"));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return c;  
    } 
    
    
    public static List<Customer> getAllCustomers(){  
        List<Customer> list=new ArrayList<Customer>();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Customer c=new Customer();  
               
            	c.setAddress(rs.getString("address"));
            	c.setCity(rs.getString("city"));
            	c.setState(rs.getString("state"));
            	c.setName(rs.getString("name"));
            	c.setAge(rs.getInt("age"));
            	c.setCustomerID(rs.getInt("customerID"));
            	c.setCustomerSSNID(rs.getInt("customerSSNID"));
            	c.setStatus(rs.getString("status"));
            	c.setMessage(rs.getString("Message"));
            	c.setLastUpdated(rs.getTimestamp("lastUpdated"));
            	list.add(c);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }

	 public static Customer getCustomerById2(int id){  
        Customer c=new Customer();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer where customerID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
               c.setCity(rs.getString("city"));
               c.setAddress(rs.getString("address"));
               c.setAge(rs.getInt("age"));
               c.setCustomerID(rs.getInt("customerID"));
               c.setCustomerSSNID(rs.getInt("customerSSNId"));
               c.setState(rs.getString("state"));
               c.setName(rs.getString("name"));
               c.setStatus(rs.getString("status"));
               c.setMessage(rs.getString("message"));
                
               c.setLastUpdated(rs.getTimestamp("lastUpdated"));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return c;  
    }
} 
