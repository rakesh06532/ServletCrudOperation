package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/upd")
public class UserUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	   throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		UserBean ub=new UserBean();
		ub.setUname(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		int k=new UpdateDAO().update(ub);
		if(k>0) {
			pw.println("Updated successfully...<br>");
		}
		else {
			pw.println("Not updated...");
		}
	}

}
