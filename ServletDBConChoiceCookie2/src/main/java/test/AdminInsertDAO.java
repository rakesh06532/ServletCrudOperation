package test;
import javax.servlet.http.*;
import java.sql.*;

public class AdminInsertDAO {
	public String fname=null;
	public String login(HttpServletRequest req) {
		try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement
				("select * from admin49 where uname=? and pword=?");
		ps.setString(1, req.getParameter("uname"));
		ps.setString(2, req.getParameter("pword"));
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			fname=rs.getString(3);
		}
		}catch(Exception e) {e.printStackTrace();}
		return fname;
	}

}
