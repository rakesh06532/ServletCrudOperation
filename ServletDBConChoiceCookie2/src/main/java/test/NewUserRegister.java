package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/newuser")
public class NewUserRegister extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException, IOException {
		UserBean ub=new UserBean();
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ub.setUname(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("fname"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k=new RegisterDAO().insert(ub);
		if(k>0) {
			pw.println("User Inserted Successfully...<br>");
			RequestDispatcher rd1=req.getRequestDispatcher("Register.html");
			rd1.include(req, res);
			RequestDispatcher rd2=req.getRequestDispatcher("AdminLink.html");
			rd2.include(req, res);
		}
	}

}
