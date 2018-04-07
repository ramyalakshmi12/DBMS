
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/Operation")
public class Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");

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
		String button_param = request.getParameter("button");
		RequestDispatcher rd = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");
			PreparedStatement ps;
			int count = 0;
			if (button_param.equals("Insert")) {
				String ISBN = request.getParameter("ISBN");
				String Bookname = request.getParameter("Bookname");
				String Authorname = request.getParameter("Authorname");
				String Publication = request.getParameter("Publication");
				String Edition = request.getParameter("Edition");
				String Category = request.getParameter("Category");
				String exist = "YES";

				PreparedStatement ps1 = con.prepareStatement("select * from books where id=?");
				ps1.setString(1, ISBN);
				ResultSet rs = ps1.executeQuery();
				while (rs.next()) {
					count++;
				}

				if (count == 0) {

					String sql = "insert into books values(?,?,?,?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, ISBN);
					ps.setString(2, Bookname);
					ps.setString(3, Authorname);
					ps.setString(4, Publication);
					ps.setString(5, Edition);
					ps.setString(6, Category);
					ps.setString(7, exist);
					int i = ps.executeUpdate();
					ps.close();
					request.getSession().setAttribute("k", "2");
					getServletContext().getRequestDispatcher("/member.jsp").forward(request, response);
				}
				else
				{
					request.getSession().setAttribute("k", "1");
					getServletContext().getRequestDispatcher("/member.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
