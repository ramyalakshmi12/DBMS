
import java.awt.List;


import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");
			String[] getvalues = request.getParameterValues("check");
			String x = "";			

			for (int i = 0; i < getvalues.length; i++) {		
				PreparedStatement prep = con.prepareStatement("update books set exist =? where id = ?");
				prep.setString(1, "N0");
				prep.setString(2, getvalues[i]);
				prep.executeUpdate();			

				PreparedStatement p = con.prepareStatement("select * from curr_user where id = 1");
				ResultSet rp = p.executeQuery();			

				while (rp.next()) {
					x = rp.getString(2);
				}
								
				PreparedStatement pre = con.prepareStatement("insert into manage_books values(?,?,?,?)");
				pre.setString(1, x);
				pre.setString(2, getvalues[i]);
				pre.setString(3, "ISSUE");
				pre.setString(4, "NO");
				pre.executeQuery();
				
				
				response.sendRedirect("issue.jsp");		

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
