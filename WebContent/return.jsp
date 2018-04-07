<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/return.css"%></style>
<title>Return</title>
</head>
<body>
	<%@ page import="java.sql.ResultSet"%>
	<%@ page import="java.sql.Statement"%>
	<%@ page import="java.sql.Connection"%>
	<%@ page import="java.sql.DriverManager"%>
	<%@ page import="java.sql.PreparedStatement"%>

	<form method="post" action="Table2">
		<table border="2">
			<thead>
				<td>ISBN</td>
				<td>NAME</td>
				<td>AUTHOR</td>
				<td>EDITION</td>
				<td>CATEGORY</td>
				<td>PUBLICATION</td>
			</thead>
			<%
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
							"12797ramy");
					PreparedStatement p = con.prepareStatement("select * from curr_user where id = 1");
					ResultSet rp = p.executeQuery();
					String x = "";
					while (rp.next()) {
						x = rp.getString(2);
					}
					PreparedStatement st = con.prepareStatement("select * from manage_books where status = 'ISSUE' and approval = 'YES' and user_id = ?");
					st.setString(1, x);
					ResultSet r = st.executeQuery();
					while(r.next())
					{
						String id = r.getString(2);
						PreparedStatement s = con.prepareStatement("select * from books where id = ?");
						s.setString(1,id);
						ResultSet rs = s.executeQuery();	
					System.out.println("rishi3");
					while (rs.next()) {
			%>
			<tr>
					<td><%=rs.getInt(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
					<td>
						<fieldset data-role="controlgroup">
							<input type="checkbox" name="check" id="id" class="custom" value="<%= rs.getInt(1) %>" />
						</fieldset>
					</td>
				</tr>
			<%
				}}
			%>
		</table>
		<%
			r.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
		<tr>
			<td></td>
			<td><input type="submit" value="Return" name="button"
										style="width: 150px; height: 35px; font-size: 16px; font-weight: bold; color: #fff; text-transform: uppercase; text-align: center; text-shadow: 1px 1px 0px #37a69b; background-color: #37a69b; background-image: linear-gradient(top, #3db0a6, #3111); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; box-shadow: inset 0px 1px 0px #2ab7ec, 0px 5px 0px 0px #497a78, 0px 10px 5px #999; margin: 20px 0 0 20px; padding-center: 30px;">
						
		</tr>
	</form>
</body>
</html>