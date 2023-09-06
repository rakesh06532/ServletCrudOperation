package test;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/Logout")
public class UserLogout extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws IOException,ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie ck[]=req.getCookies();
		if(ck==null) {
			pw.println("Session expired Please Login again...<br>");
			
		}
		else {
			pw.println("User: "+ck[0].getValue()+"<br>");
			ck[0].setMaxAge(0);
			pw.println("User Logged out successfully...<br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
		rd.include(req, res);
	}

}
