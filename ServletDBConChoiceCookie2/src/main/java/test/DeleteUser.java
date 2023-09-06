package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws IOException,ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		UserBean ub=new UserBean();
		ub.setUname(req.getParameter("uname"));
		int k=new DeleteDAO().delete(ub);
		if(k>0) {
			pw.println("Record Deleted Successfully...<br>");
			pw.println("Delete next User...<br>");	
		}
		else {
			pw.println("Invalid User Name...<br>Please Enter Valid User Name...<br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("Delete.html");
		rd.include(req, res);
	}

}
