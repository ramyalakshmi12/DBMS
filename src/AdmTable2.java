
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdmTable2
 */
@WebServlet("/AdmTable2")
public class AdmTable2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdmTable2() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");
			String[] getvalues = request.getParameterValues("check1");
			String x = "";

			for (int i = 0; i < getvalues.length; i++) {
			    
				PreparedStatement p = con.prepareStatement("update books set exist = 'YES' where id = ?");
				p.setString(1, getvalues[i]);
				p.executeUpdate();
				
				PreparedStatement pr = con.prepareStatement("delete from manage_books where book_id = ?");
				pr.setString(1, getvalues[i]);
				int j = pr.executeUpdate();

		        if(j > 0) {
		            out.println("Returned");
		            response.sendRedirect("approval.jsp");
		        }

			}

		} catch (Exception e) {

		}
	}

}
