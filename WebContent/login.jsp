<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/loginstyle.css"%></style>
<title>Library management system</title>
</head>
<header> <font size="9"> <font color="white">
		Library Management</font>
</font> </header>
<body>
				<form method="post" action="LoginCheck">
					<tr>
						<%
							String userOffice = (String) session.getAttribute("k");
							if (userOffice != null) {
								if (userOffice.equals("1")) {
									out.print("<h1> Invalid !!</h1>");
								}
							}
						%> 
					</tr>
					<br/><br/>
					<br/>
					<center><div  style="width:350px; height:257px; margin:70px auto 0; border:1px solid #42464b; border-radius:6px; background:#eceeee; "><center>
					<tr>
						<td></td>
						
						<center><td><input type="text" name="uname" placeholder="Username"
							></td></center>
					</tr>

					<tr>
						<td></td>
						
						<center><td><input type="password" name="password"
							placeholder="Password"></td></center>
					</tr>
					<tr>
						<td></td>
						
						<center><td><input type="submit" value="Login"></td></center>
					</tr>
				</form>
			

				<form method="post" action="users.jsp">
					<tr>
						<td></td>
<br/><br/><br/><br/>
						<center><td><input type="submit" value="Create Account"></td></center>
					</tr>
				</form>
				<br/><br/><br/>
					</div>
			</body>
</html>