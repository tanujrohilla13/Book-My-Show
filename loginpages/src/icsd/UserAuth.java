package icsd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAuth
 */
@WebServlet("/UserAuth")
public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strUnm,strPwd;
		strUnm=request.getParameter("txtUnm");
		PrintWriter out=response.getWriter();	
		out.println(strUnm);
		strPwd=request.getParameter("txtPwd");
		DBHandle objDH=new DBHandle();
		boolean res=objDH.isValidUser1(strUnm,strPwd);
		out.println(res);
		if(res==true)
		{
			//valid user
			response.sendRedirect(request.getContextPath()+"/User/UserHome.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/User/ErrorPage.jsp");
			//invaild admin
		}
//	    if(strUnm.equals("a") && strPwd.equals("a"))
//		 {
//		 response.sendRedirect(request.getContextPath()+"/User/UserHome.jsp");
//		 }
//		else
//		{
//		response.sendRedirect(request.getContextPath()+"/UserError.jsp");
//		}
		}
}
