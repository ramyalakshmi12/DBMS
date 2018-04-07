
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
 * Servlet implementation class Usermanage
 */
@WebServlet("/Usermanage")
public class Usermanage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Usermanage() {
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
		// TODO Auto-generated method stub

		String button_param = request.getParameter("button");
		RequestDispatcher rd = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");

			if (button_param.equals("Insert")) {
				PreparedStatement ps;
				String st = "";

				String Regno = request.getParameter("Regno");
				String Name = request.getParameter("Name");
				String Gender = request.getParameter("Gender");
				String Branch = request.getParameter("Branch");
				String check = request.getParameter("check");
				String Username = request.getParameter("Username");
				String Password = request.getParameter("Password");
				int count = 0;

				PreparedStatement ps1 = con.prepareStatement("select * from stud where regno=?");
				ps1.setString(1, Regno);
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					count++;
				}

				if (count == 0) {

					if ("Student".equals(check))
						st = "YES";
					else
						st = "NO";

					String sql = "insert into stud values(?,?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, Regno);
					ps.setString(2, Name);
					ps.setString(3, Gender);
					ps.setString(4, Branch);
					ps.setString(5, st);
					ps.executeUpdate();
					ps.close();

					PreparedStatement p = con.prepareStatement(" insert into users values (?,?,?,?) ");
					p.setString(1, Regno);
					p.setString(2, Username);
					p.setString(3, Password);
					p.setString(4, "NO");
					p.executeUpdate();
					p.close();

					request.getSession().setAttribute("k", "2");
					getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
				} else {
					request.getSession().setAttribute("k", "1");
					getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);

				}
				ps1.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
