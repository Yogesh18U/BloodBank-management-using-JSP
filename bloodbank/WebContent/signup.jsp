<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="signup" method="get">
Name      :<input type="text" name="name"><br></br>
Age       :<input type ="text" name="age"><br></br>
Email     :<input type="email" name="mail"><br></br>
Password  :<input type="password" name="pass"><br></br>
BloodGroup:<select name="selectblood"><br></br>
<option value="blood"></option>
<option value="O+">+O</option>
<option value ="O-">-O</option>
<option value="A+">A+</option>
<option value="A-">A-</option>
<option value="B+">B+</option>
<option value="OB">OB+</option>
<option value="OB-">OB-</option>
</select> <br></br>
Location  :<select name="Donerlocation"><br></br>
<option value="Location"></option>
<option value ="place">Ramnad</option>
<option value="mdu">Madurai</option>
<option value="CBE">Coimbatore</option>
<option value="chn">Chennai</option>
<option value="Pmk">Paramakudi</option>
</select><br></br>
Phone     :<input type="text" name="phone"><br></br>
<input type="submit" name="submit">
</form>
</body>
</html>