package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
@WebServlet("/viewbyuser")
@SuppressWarnings("serial")
public class ViewByUser extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		UserBean ub=new UserBean();
		ub.setUname(req.getParameter("uname"));
		ArrayList<UserBean> al=new User().view(ub);
		
		if(al.size()==0) {
			pw.println("Records not available...<br>");
			pw.println("Please add user...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Register.html");
			rd.include(req, res);
		}
		else {
			Iterator<UserBean> it=al.iterator();
			{
				while(it.hasNext()) {
					UserBean ub1=(UserBean)it.next();
					pw.println(ub1.getUname() +"&nbsp"+ub1.getPword()+"&nbsp"+ub1.getFname()
					+"&nbsp"+ub1.getLname()+"&nbsp"+ub1.getPhno()+"<br>");
				}
			}
			RequestDispatcher rd=req.getRequestDispatcher("AdminLink.html");
			rd.include(req, res);
		}
	}

}
