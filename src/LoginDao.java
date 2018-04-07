import java.sql.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginDao {
	static int curr = 0;
	static String st = "";

	public static int validate(String uname, String password) {

		try {
			int count = 0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMY12797",
					"12797ramy");
			PreparedStatement ps = con.prepareStatement("select * from users where name=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count++;
			}
			
			if (count == 1) {

				PreparedStatement ps2 = con.prepareStatement("select * from users where name=? and password=?");
				ps2.setString(1, uname);
				ps2.setString(2, password);
				ResultSet rp = ps2.executeQuery();
				while (rp.next()) {
					st=rp.getString(4);
					PreparedStatement currPrepared = con.prepareStatement("update curr_user set us =? WHERE id = 1");
					currPrepared.setString(1, rp.getString(1));
					currPrepared.executeUpdate();
					if (st.equals("YES")){
						return 1;
					}

					else
						return 2;
				}
			} 

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	private static ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}
}