<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/users.css"%></style>
<title>Register</title>
</head>
<body>
	
	<form method="post" action="Usermanage">
		<table>
		<%
							String userOffice = (String) session.getAttribute("k");
							if (userOffice != null) {
								if (userOffice.equals("1")) {
									out.print("<h1 style=color:white> Invalid !!</h1>");
								}
								else if(userOffice.equals("2"))
								{
									out.print("<h1 style=color:white> Inserted !!</h1>");
								}
							}
						%>
			<tr>
				<br />
				<br />
				<br />
				<br />
				<td><font size="5"> <font color="white">Reg No</td>
				<td><input type="text" name="Regno">
			</tr>
			<tr>
				<td><font size="5"> <font color="white">Name</td>
				<td><input type="text" name="Name">
			</tr>
			<tr>
				<td><font size="5"> <font color="white">Gender</td>
				<td><input type="text" name="Gender">
			</tr>
			<tr>
				<td><font size="5"> <font color="white">Branch</font></td>
				<td><input type="text" name="Branch">
			</tr>
			<tr>
				<td><font size="5"> <font color="white">Username</td>
				<td><input type="text" name="Username">
			</tr>
			<tr>
				<td><font size="5"> <font color="white">Password</td>
				<td><input type="password" name="Password">
			</tr>
			<tr>

				<td><input type="radio" name="check" value="Student" CHECKED
					style="margin: 30px 0 0 80px;">
				<td><font size="5"> <font color="white">Student <input
							type="radio" name="check" value="Staff"
							/ style="margin: 40px 0 0 100px;"> <font size="5">
								<font color="white">Staff 
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert" name="button"
					style="width: 150px; height: 35px; font-size: 16px; font-weight: bold; color: #fff; text-transform: uppercase; text-align: center; text-shadow: 1px 1px 0px #37a69b; background-color: #37a69b; background-image: linear-gradient(top, #3db0a6, #3111); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999; margin: 20px 0 0 20px; padding-center: 30px;">
			</tr>

		</table>
	</form>

</body>
</html>