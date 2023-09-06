package test;
import java.sql.*;
import java.util.*;

public class User {
	ArrayList<UserBean> al=new ArrayList<UserBean>();
	public ArrayList<UserBean> view(UserBean ub){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from user49 where uname=?");
			ps.setString(1, ub.getUname());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
			UserBean ub1=new UserBean();
			ub1.setUname(rs.getString(1));
			ub1.setPword(rs.getString(2));
			ub1.setFname(rs.getString(3));
			ub1.setLname(rs.getString(4));
			ub1.setPhno(rs.getLong(5));
			al.add(ub1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}

}
