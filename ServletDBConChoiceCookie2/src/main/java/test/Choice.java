package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/choice")
public class Choice extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		
		String st=req.getParameter("s1");
		if(st.equals("AdminLogin")) {
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.forward(req, res);
		}
	}

}
