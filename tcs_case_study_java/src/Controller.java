
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Account;
import com.Dao.AccountDao;
import com.Dao.Customer;
import com.Dao.CustomerAccount;
import com.Dao.CustomerDao;
import com.Dao.LoginDao;
import com.Dao.Transaction;

/**
 * Servlet implementation class statusCustomer
 */

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		System.out.print(action);
		switch (action) 
		{

		case "/loginController1": {
			login(request, response);
			break;
		}
		case "/statusCustomer": {
			listCustomer(request, response);
			break;
		}
		case "/delete": {
			deleteCustomer(request, response);
			break;
		}

		case "/searchCustomer": {
			searchCustomer(request, response);
			break;
		}

		case "/profile": {
			profile(request, response);
			break;
		}
		case "/logout": {
		
			  HttpSession session=request.getSession();  
	            session.invalidate();  
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "/createAccount": {
			
			createAccount(request,response);
			break;
		}
		
		
		case "/deposit": {
			HttpSession s=request.getSession();
			
			s.setAttribute("op", "deposit");
			operationDetails(request,response);
			break;
		}
		
		case "/withdraw": {
			HttpSession s=request.getSession();
			
			s.setAttribute("op", "withdraw");
			operationDetails(request,response);
			break;
		}
		
		case "/transfer": {
			transfer(request,response);
			break;
		}
		
		
		case "/operation": {
			
			operation(request,response);
			break;
		}
		
		case "/statusAccount": {
			
			listAccount(request,response);
			break;
		}
		case "/deleteAccnt": {
			deleteAccount(request, response);
			break;
		}
		case "/searchAccount": {
			
			searchAccount(request,response);
			break;
		}
		
		case "/DepositOperation": {
			
			depositOperation(request,response);
			break;
		}
		
		case "/WithdrawOperation": {
			
			withdrawOperation(request,response);
			break;
		}
		
		
		case "/transferOperation": {
			
			transferOperation(request,response);
			break;
		}
		
		case "/statementOperation": {
			
			statementOperation(request,response);
			break;
		}
		

		}
	}
	
	private void statementOperation(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n=Integer.parseInt(request.getParameter("trans"));

		int aid=Integer.parseInt(request.getParameter("aid"));
		
		List<CustomerAccount> l=AccountDao.getAccountById(aid, 1);
		if(l.size()==0)
		{
			out.print("<div class='alert alert-danger'>No account exists</div>");
			try {
				request.getRequestDispatcher("home.jsp").include(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			List<Transaction> t=AccountDao.getTransaction(aid,n);
			request.setAttribute("tlist", t);
			try {
				request.getRequestDispatcher("statement.jsp").include(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
				
		}
		
	}

	private void operationDetails(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("operation.jsp");
		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void transfer(HttpServletRequest request, HttpServletResponse response) {
	
		int sid,did;
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		sid=Integer.parseInt(request.getParameter("sacct"));
		did=Integer.parseInt(request.getParameter("dacct"));
		if(sid==did)
		{
			out.print("<div class='alert alert-warning'>Sourse and Destination account must be different</div>");
			try {
				request.getRequestDispatcher("home.jsp").include(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
				
		}
		else {
			int c=Integer.parseInt(request.getParameter("cid"));
			int amount=Integer.parseInt(request.getParameter("amount"));
			int status=AccountDao.transfer(c,sid,did,amount);
			if(status==-1)
			{
				out.print("<div class='alert alert-warning'>Insufficient Balance</div>");
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				try {
					rd.include(request, response);
				} catch (ServletException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				out.print("<div class='alert alert-success'>Successfully Transfered</div>");
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				try {
					rd.include(request, response);
				} catch (ServletException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	private void transferOperation(HttpServletRequest request, HttpServletResponse response) {
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<CustomerAccount> list=AccountDao.getAccountById(cid, 2);
		if(list.size()==0)
		{
			out.print("<div class='alert alert-warning'>No account registered</div>");
			RequestDispatcher rd=request.getRequestDispatcher("transfer.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("tlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("transferOperation.jsp");
		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void depositOperation(HttpServletRequest request, HttpServletResponse response) {

		 HttpSession s=request.getSession();
		
		  s.setAttribute("op", null);
		  
	PrintWriter out = null;
	try {
		out = response.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	  int amount=Integer.parseInt(request.getParameter("amount")); 
	  int cid=Integer.parseInt(request.getParameter("cid"));
	  int aid=Integer.parseInt(request.getParameter("aid"));
	  int status=0;
	 
      status=AccountDao.deposit(aid,cid,amount);
       
      if(status>0)
      {
    	  out.print("<div class='alert alert-success'>Amount Depositted</div>");
    	  RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
    	  try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
		
	}

	private void withdrawOperation(HttpServletRequest request, HttpServletResponse response) {

	HttpSession s=request.getSession();
		
	s.setAttribute("op", null);
		  
	PrintWriter out = null;
	try {
		out = response.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	  int amount=Integer.parseInt(request.getParameter("amount")); 
	  int cid=Integer.parseInt(request.getParameter("cid"));
	  int aid=Integer.parseInt(request.getParameter("aid"));
	  int status=0;
	 
     status=AccountDao.withdraw(aid,cid,amount);
     RequestDispatcher rd;
     if(status>0)
     {
   	  out.print("<div class='alert alert-success'>Amount Withdrawn</div>");
   	  rd=request.getRequestDispatcher("home.jsp");
   	  try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     if(status==-2)
     {
   	  out.print("<div class='alert alert-danger'>Insufficient Amount</div>");
   	  rd=request.getRequestDispatcher("home.jsp");
   	  try {
		rd.include(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
     }
		
	}
	
	private void operation(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session= request.getSession();
		int aid=Integer.parseInt(request.getParameter("aid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Account a=AccountDao.getAccount(aid,cid);
		if(a.getActType()!=null)
		{
			request.setAttribute("account", a);
			RequestDispatcher rd;
			System.out.print(request.getAttribute("op"));
			if(session.getAttribute("op").equals("deposit"))
			{
				 rd=request.getRequestDispatcher("DepositOperation.jsp");
				 try {
					rd.include(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			if(session.getAttribute("op").equals("withdraw"))
			{
				 rd=request.getRequestDispatcher("withdrawOperation.jsp");
				 try {
					rd.include(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			    
		}
		else
		{
			out.print("<div class='alert alert-danger'>Invalid details</div>");
			RequestDispatcher rd=request.getRequestDispatcher("operation.jsp");
			 
			try {
					rd.include(request,response);
				} 
		    catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

	private void searchAccount(HttpServletRequest request, HttpServletResponse response) {
		
		String aid=request.getParameter("aid");
		String cid=request.getParameter("cid");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aid.isEmpty() &&cid.isEmpty())
		{
			out.print("<div class='alert alert-danger'>Either one of the details should be entered </div>");
			RequestDispatcher rd=request.getRequestDispatcher("searchAccount.jsp");
			 
			try {
					rd.include(request,response);
				} 
		    catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		int flag=1;
		if(!aid.isEmpty())
		{
			int aid1=Integer.parseInt(aid);
			List<CustomerAccount> list=AccountDao.getAccountById(aid1,1);
			for(CustomerAccount ca:list)
			System.out.print(ca);
			if(!list.isEmpty()&& list.get(0).getActType()!=null)
			{
				request.setAttribute("cusAct", list);
				RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
				try {
					rd.include(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				 flag= 0;
			}
			
		}
		if(!cid.isEmpty())
		{
			int cid1=Integer.parseInt(cid);
			List<CustomerAccount> list=AccountDao.getAccountById(cid1,2);
			if(!list.isEmpty()&&list.get(0).getActType()!=null)
			{
				request.setAttribute("cusAct", list);
				RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
				try {
					rd.include(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				 flag= 0;
			}
		}
		if(flag==0)
		{
			out.print("<div class='alert alert-danger'>No Account registered with this details </div>");
			RequestDispatcher rd=request.getRequestDispatcher("searchAccount.jsp");
			 
			try {
					rd.include(request,response);
				} 
		    catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
	}

	private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		String ssnid=request.getParameter("ssnid");
		String id=request.getParameter("id");
		int id1,ssnid1;
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ssnid.isEmpty() &&id.isEmpty())
		{
			out.print("<div class='alert alert-danger'>Either one of the details should be entered </div>");
			RequestDispatcher rd=request.getRequestDispatcher("searchCustomer.jsp");
			 
			try {
					rd.include(request,response);
				} 
		    catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		int flag=1;
		if(!ssnid.isEmpty())
		{
			ssnid1=Integer.parseInt(ssnid);
			Customer c=CustomerDao.getCustomerById(ssnid1);
			if(c.getCity()!=null)
			{
				request.setAttribute("user", c);
				//RequestDispatcher rd=request.getRequestDispatcher("/profile?id="+ssnid1);
				RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
				
				try {
					rd.forward(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				 flag= 0;
			}
			
		}
		if(!id.isEmpty())
		{
			id1=Integer.parseInt(id);
			Customer c=CustomerDao.getCustomerById2(id1);
			if(c.getCity()!=null)
			{
				request.setAttribute("user", c);
				RequestDispatcher rd=request.getRequestDispatcher("profile.jspx");
				try {
					rd.forward(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				flag=0;
			}
		}
		if(flag==0)
		{
			out.print("<div class='alert alert-danger'>No Customer registered with this details </div>");
			RequestDispatcher rd=request.getRequestDispatcher("searchCustomer.jsp");
			 
			try {
					rd.include(request,response);
				} 
		    catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			
	}

	
	private void createAccount(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		String actType=request.getParameter("type");
		
		Calendar calendar = Calendar.getInstance();
	    java.util.Date currentTime = calendar.getTime();
	        
	    long time = currentTime.getTime();
		
	    Account act= new Account();
		act.setAccountID(id);
		act.setActType(actType);
		act.setAmount(amount);
		act.setLastUpdated(new Timestamp(time));
		act.setCustomerId(id);
		
		System.out.print(act);
		
		int status=AccountDao.save(act);  
	    if(status>0)
	    {  
	            out.print("<p class='alert alert-success'>Acount create successfully!</p>");  
	            try {
					request.getRequestDispatcher("home.jsp").include(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	    }else
	    {  
	        	out.print("<p class='alert alert-info'>No Customer found </p>");  
		        RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
		        try {
					rd.include(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	    } 
	        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);

	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String n = request.getParameter("login");
		String p = request.getParameter("password");
		  HttpSession session=request.getSession();  
	        session.setAttribute("name",n);  
		if (n.length() > 20 || p.length() > 10) {
			out.print("Login and password can be of max 20 length ");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.close();
			return;
		}

		if (LoginDao.validate(n, p)) {
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		out.close();
	}

	private void profile(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer c = CustomerDao.getCustomerById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		request.setAttribute("user", c);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
		List<Customer> clist = CustomerDao.getAllCustomers();
		for (Customer c : clist) {
			System.out.println(c.toString());
		}
		request.setAttribute("all", clist);
		try {
			request.getRequestDispatcher("statusCustomer.jsp").include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void listAccount(HttpServletRequest request, HttpServletResponse response) {
		List<Account> alist = AccountDao.getAllAccounts();
		for (Account a : alist) {
			System.out.println(a.toString());
		}
		request.setAttribute("all", alist);
		try {
			request.getRequestDispatcher("statusAccount.jsp").include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		int x = CustomerDao.delete(id);
		try {
			response.sendRedirect("statusCustomer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		int x = AccountDao.delete(id);
		try {
			response.sendRedirect("statusAccount");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
