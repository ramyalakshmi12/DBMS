<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/approveinsert.css"%></style>
<title>Admin</title>
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	<font size="5"> <font color="white">welcome ${username}
	<form action="Logout">
		<div style="text-align: right">
			<br /> <input type="submit" value="Logout" name="button"
				style="color: white; position: fixed; right: 10px; top: 5px; width: 150px; height: 35px; font-size: 16px; font-weight: bold; color: #fff; text-transform: uppercase; text-align: center; text-shadow: 1px 1px 0px #37a69b; background-color: #37a69b; background-image: linear-gradient(top, #3db0a6, #3111); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999;">
		</div>
	</form>
	<form method="post" action="member.jsp">
		<tr>
			<td></td>
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<div style="text-align: center">
				<td><input type="submit" value="Insert" name="button"
					class="hover"
					style="width: 240px; height: 35px; font-size: 16px; font-weight: bold; color: #fff; text-transform: uppercase; text-align: center; text-shadow: 1px 1px 0px #37a69b; background-color: #37a69b; background-image: linear-gradient(top, #3db0a6, #3111); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999; margin: 140px 0 0 30px; padding-center: 30px;">
				</td>
			</div>
		</tr>
	</form>

	<form method="post" action="approval.jsp">
		<tr>
			<br />
			<br />
			<td></td>
			<div style="text-align: center">
				<td><input type="submit" value="Approval" name="button"
					class="hover"
					style="width: 240px; height: 35px; font-size: 16px; font-weight: bold; color: #fff; text-transform: uppercase; text-align: center; text-shadow: 1px 1px 0px #37a69b; background-color: #37a69b; background-image: linear-gradient(top, #3db0a6, #3111); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999; margin: 40px 0 0 30px; padding-center: 30px;">
				</td>
			</div>
		</tr>
	</form>


</body>
</html>