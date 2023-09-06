package test;
import java.sql.*;

public class UpdateDAO {
	public int k=0;
	public int update(UserBean ub) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("select * from user49");
			PreparedStatement ps2=con.prepareStatement
		("update user49 set uname=?,pword=?,fname=?,lname=?,phno=? where uname=?");
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				String uname=rs.getString(1);
				
			ps2.setString(1, ub.getUname());
			ps2.setString(2, ub.getPword());
			ps2.setString(3, ub.getFname());
			ps2.setString(4, ub.getLname());
			ps2.setLong(5, ub.getPhno());
			ps2.setString(6, uname);
			
			k=ps2.executeUpdate();
			}
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
