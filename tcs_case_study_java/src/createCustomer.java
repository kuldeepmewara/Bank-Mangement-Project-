

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Customer;
import com.Dao.CustomerDao;

/**
 * Servlet implementation class createCustomer
 */
@WebServlet("/createCustomer")
public class createCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    PrintWriter out=response.getWriter();  
		    
		    int ssnId=Integer.parseInt(request.getParameter("ssnid"));
		    String name=request.getParameter("name");  
	        int age=Integer.parseInt(request.getParameter("age"));  
	        String city=request.getParameter("city");  
	        String state=request.getParameter("state"); 
	        String address=request.getParameter("address"); 
	        
	        
	          
	       // int ssnid=1;
	        System.out.print(ssnId);
	        System.out.print(name);
	        System.out.print(city);
	        System.out.print(state);
	        System.out.print(address);
	        System.out.print(age);
	        
	        Calendar calendar = Calendar.getInstance();
	        java.util.Date currentTime = calendar.getTime();
	        
	        long time = currentTime.getTime();
	      
	        Customer c=new Customer();  
	        c.setName(name);  
	        c.setAddress(address);
	        c.setAge(age);
            c.setCity(city);
            c.setState(state);
            c.setCustomerSSNID(ssnId);
            c.setLastUpdated(new Timestamp(time));
            
	        
	        
	        int status=CustomerDao.save(c);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("home.jsp").include(request, response);  
	        }else{  
	        	out.print("<p>Sorry already 1created</p>");  
		        RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
		        rd.include(request,response);  
	        } 
	        out.close();
	}

}
