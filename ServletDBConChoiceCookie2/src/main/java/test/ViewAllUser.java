package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllUser extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ArrayList<UserBean> al=new Retrieve().retrieve();
		if(al.size()==0) {
			pw.println("User Not availabe...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("UserLink.html");
			rd.include(req, res);
		}
		else {
			Iterator<UserBean> it=al.iterator();
			while(it.hasNext()) {
				UserBean ub=(UserBean)it.next();
				pw.println(ub.getUname() +"&nbsp"+ub.getPword()+"&nbsp"+ub.getFname()
				+"&nbsp"+ub.getLname()+"&nbsp"+ub.getPhno()+"<br>");
			}
		}
		RequestDispatcher rd=req.getRequestDispatcher("UserLink.html");
		rd.include(req, res);
	}

}
