<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
 <center><h1>Login Page</h1></center>
 <center>
 
  <form action="log" method="post">
           <label>Email:</label> 
           
     <input type="email" name="tbemailLog" id="tbemail" value="<%=request.getParameter("tbemail")%>"/><br>
  
           <label>Password:</label> 
  
     <input type="password" name="tbpasswordLog" id="tbpassword" value="<%=request.getParameter("tbpassword")%>"/><br>
        
          <button>login</button>
</form>
</center>

</body>
</html>