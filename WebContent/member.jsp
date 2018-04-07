<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/member.css"%></style>
<title>Books</title>
</head>
<body>



	<form method="post" action="Operation">
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
				<td><font size="6"> <font color="white">ISBN</td>
				<td><input type="text" name="ISBN">
			</tr>
			<tr>
				<td><font size="6"> <font color="white">Book</td>
				<td><input type="text" name="Bookname">
			</tr>
			<tr>
				<td><font size="6"> <font color="white">Author</td>
				<td><input type="text" name="Authorname">
			</tr>
			<tr>
				<td><font size="6"> <font color="white">Publication</td>
				<td><input type="text" name="Publication">
			</tr>
			<tr>
				<td><font size="6"> <font color="white">Edition</td>
				<td><input type="text" name="Edition">
			</tr>
			<tr>
				<td><font size="6"> <font color="white">Category</td>
				<td><input type="text" name="Category">
			</tr>
			<tr>
				<td></td>
				<center>
					<td><input type="submit" value="Insert" name="button"
						style="width: 150px; height: 35px; font-size: 16px; font-weight: bold; color: #fff; text-transform: uppercase; text-align: center; text-shadow: 1px 1px 0px #37a69b; background-color: #37a69b; background-image: linear-gradient(top, #3db0a6, #3111); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999; margin: 80px 0 0 85px; padding-center: 30px;">

					</td>
				</center>
			</tr>
		</table>
	</form>

</body>
</html>