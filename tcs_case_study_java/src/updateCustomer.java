

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Customer;
import com.Dao.CustomerDao;

/**
 * Servlet implementation class updateCustomer
 */
@WebServlet("/updateCustomer")
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		Customer c=(Customer) session.getAttribute("customer");
	    
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String age=request.getParameter("age");
		
		int status=0;
		if(!name.isEmpty())
			c.setName(name);
        if(!address.isEmpty())
        	c.setAddress(address);
        if(!age.isEmpty())
        	c.setAge(Integer.parseInt(age));


        status=CustomerDao.update(c);
        if(status>0){  
            out.print("<p>Customer update initiated successfully</p>");  
            request.getRequestDispatcher("home.jsp").include(request, response);  
        }else{  
        	out.print("<p>Sorry already 1created</p>");  
	        RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
	        rd.include(request,response);  
        } 
        out.close();
			
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		int ssnid=Integer.parseInt(request.getParameter("ssnid"));
		
		 Customer c=new Customer();  
	        
         c.setCustomerSSNID(ssnid);
         
		Customer c1=CustomerDao.getCustomerById(c.getCustomerSSNID()); 
		if(c1.getCity()!=null)
		{
			request.setAttribute("customer", c1);
			request.getRequestDispatcher("updateCustomer2.jsp").include(request, response);  
		}
        else{  
        	RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
        	out.print("<div class='alert alert-danger' style='color:red;'>no customer with this ssnid found </div>");  
	        
	        rd.include(request,response);  
        } 
		
		
	}

}
