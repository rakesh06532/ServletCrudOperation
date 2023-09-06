package test;
import java.sql.*;

public class RegisterDAO {
	public int k=0;
	public int insert(UserBean ub) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into user49 values(?,?,?,?,?)");
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPword());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setLong(5, ub.getPhno());
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
