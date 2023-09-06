package test;
import java.sql.*;

public class DeleteDAO {
	public int k=0;
	public int delete(UserBean ub) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("delete from user49 where uname=?");
			ps.setString(1, ub.getUname());
			k=ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
