package com.techpalle.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.techpalle.model.Customer;


  public class DataAccess 
   {
	static Connection con=null;
    static PreparedStatement ps=null;
    static Statement s=null;
    static ResultSet rs=null;


     
	public static void inserting(Customer c)
	{
		 try
  	   {
  		 Class.forName("com.mysql.cj.jdbc.Driver");
  		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","admin");
  		 ps=con.prepareStatement("insert into customer(name,email,mobile,password,state) values(?,?,?,?,?)");
  		 ps.setString(1, c.getName());
  		 ps.setString(2, c.getEmail());
  		 ps.setLong(3, c.getMobile());
  		 ps.setString(4, c.getPassword());
  		 ps.setString(5, c.getState());
  		 
         ps.executeUpdate();
         
  }
  			 catch (ClassNotFoundException e)
  			 {
  				
  				 e.printStackTrace();
  			}
  			 catch (SQLException e) 
  			 {
  				e.printStackTrace();
  			}
		 finally
		 {
			 try
			 {
				 if(ps!=null)
					 ps.close();
				 if(con!=null)
					 con.close();
			 }
			 catch(SQLException e)
			 {
	  		  e.printStackTrace();

			 }
		 }
		
  		  }
	
	//public static HashMap<String,String> m=new HashMap<String,String>();
     public static boolean validate(String mail,String password)
	{
       boolean b=false;
		 try
	  	   {
	  		 Class.forName("com.mysql.cj.jdbc.Driver");
	  		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","admin");
	  		 ps=con.prepareStatement("select email,password from customer where email=? and password=?");
	  		 ps.setString(1,mail);
	  		 ps.setString(2,password);

	  		 rs=ps.executeQuery();
	  		/* if(rs!=null)
	  		 {
	  		    rs.next();
	  			String e= rs.getString("email");
	  			String p= rs.getString("password");
	  		//	m.put(e,p);
	  			if(e.equals(mail)&&p.equals(password))
	  			{
	  				b=true;
	  			}
	  		 }*/
	  		 b=rs.next();
	  	   }
	  			 catch (ClassNotFoundException e)
	  			 {
	  				
	  				 e.printStackTrace();
	  			}
	  			 catch (SQLException e) 
	  			 {
	  				e.printStackTrace();
	  			}
			 finally
			 {
				 try
				 {
					 if(rs!=null)
						 rs.close();
					 if(ps!=null)
						 ps.close();
					 if(con!=null)
						 con.close();
				 }
				 catch(SQLException e)
				 {
		  		  e.printStackTrace();

				 }
			 }
		return b;
	  }
  }
