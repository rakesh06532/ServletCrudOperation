package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/log2")
public class UserLogin extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws IOException,ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fname=new UserInsertDAO().login(req);
		if(fname==null) {
			pw.println("Invalid Login Details...");
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
		}
		else {
			pw.println("Welcome User: "+fname+"<br>");
			Cookie ck=new Cookie("fname",fname);
			res.addCookie(ck);
			RequestDispatcher rd=req.getRequestDispatcher("UserLink.html");
			rd.include(req, res);
		}
	}

}
