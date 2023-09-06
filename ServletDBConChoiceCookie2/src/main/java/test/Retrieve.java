package test;
import java.sql.*;
import java.util.*;

public class Retrieve {
	ArrayList<UserBean> al=new ArrayList<UserBean>();
	public ArrayList<UserBean> retrieve(){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from user49");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserBean ub=new UserBean();
				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setPhno(rs.getLong(5));
				al.add(ub);
			}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}

}
