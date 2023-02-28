
package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		switch(path)
		{
		case "/sign-in": customerSignIn(request,response);
		break;
		case "/sign-up": customerSignUp(request,response);
		break;
		case "/reg": customerRegister(request,response);
		break;
		case "/log": customerLogin(request,response);
		break;
		default:
			 customerManagement(request,response);
		 break;
		}
    }

		private void customerLogin(HttpServletRequest request, HttpServletResponse response) 
		{
			  String email = request.getParameter("tbemailLog");
			  String password = request.getParameter("tbpasswordLog");

	        boolean res =  DataAccess.validate(email,password);
	          
	         if(res)
	          {
	  	       

	  	      try
				{
		          RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
               //storte the success page class data inside rd object
		          SuccessPage sp=new SuccessPage();
		       //1st input is variable name and 2nd is data 
		          request.setAttribute("successDetails", sp);

					rd.forward(request, response);
				}
				 catch (ServletException | IOException e) 
		 	    {
		 			e.printStackTrace();
		 		}
			}
	         else
	          {
		  	        RequestDispatcher rd=request.getRequestDispatcher("cl.jsp");
	          try
				{
					rd.forward(request, response);
				}
				 catch (ServletException | IOException e) 
		 	    {
		 			e.printStackTrace();
		 		}
	          }
	      }
	         
		private void customerRegister(HttpServletRequest request, HttpServletResponse response)
		{
			  String name =request.getParameter("tbname");
              String email = request.getParameter("tbemail");
              long mobile = Long.parseLong(request.getParameter("tbmobile"));
			  String password =request.getParameter("tbpassword");
			  String state =request.getParameter("ddlState");
			  Customer customer=new Customer(name,email,mobile,password,state);
	          DataAccess.inserting(customer);
			try
			{
		        RequestDispatcher rd=request.getRequestDispatcher("cl.jsp")	;
                 rd.forward(request, response);
			}
			 catch (ServletException | IOException e) 
	 	    {
	 			e.printStackTrace();
	 		}
			
         }

		public void customerSignIn(HttpServletRequest request,HttpServletResponse response)
		{
			
	        RequestDispatcher rd=request.getRequestDispatcher("cl.jsp")	;


			try
			{
				rd.forward(request, response);
			}
			 catch (ServletException | IOException e) 
	 	    {
	 			e.printStackTrace();
	 		}
			
		}
		public void customerSignUp(HttpServletRequest request,HttpServletResponse response)
		{
			
	        RequestDispatcher rd=request.getRequestDispatcher("cr.jsp");
			try
			{
			rd.forward(request, response);

			}
			 catch (ServletException | IOException e) 
	 	    {
	 			e.printStackTrace();
	 		}
		}
		
		public void customerManagement(HttpServletRequest request, HttpServletResponse response)
		{
	        RequestDispatcher rd=request.getRequestDispatcher("cm.jsp");

			try 
			{
				rd.forward(request, response);

		    }
			 catch (ServletException | IOException e) 
	 	    {
	 			e.printStackTrace();
	 		}
			
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		
	}

}
      