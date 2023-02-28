<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>

</head>
<body>
    <center><h1>Registration Page</h1>

   <form action="reg" method="post">
   
         <label> Name:</label>
    <input type="text" name="tbname" id="tbname"/><br>
         
      <label>  Email:</label>
 <input type="email" name="tbemail" id="tbemail"/><br>
 
       <label> mobile:</label>
  <input type="number" name="tbmobile" id="tbmobile"/><br>
 
      <label> Password:</label>
  <input type="password" name="tbpassword" id="tbpassword"/><br>
  
        <label> States:</label>
        <select name="ddlState">
        <option value="">---------Select---------</option>
        <option value="karnataka">KA</option>
        <option value="Tamilnadu">TN</option>
        <option value="Andrapradesh">AP</option>
        </select><br>
        
  
  
        <button>Register</button>
</form>
</center>

</body>
</html>