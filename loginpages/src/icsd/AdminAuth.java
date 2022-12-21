package icsd;


//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAuth
 */
@WebServlet("/AdminAuth")
public class AdminAuth extends HttpServlet {

	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strUnm,strPwd;
		strUnm=request.getParameter("txtUnm");
		strPwd=request.getParameter("txtPwd");
		 System.out.print(strUnm);
		DBHandle objDH=new DBHandle();
		boolean res=objDH.isValidAdmin(strUnm,strPwd);
		if(res==true)
		{
			//valid admin
			response.sendRedirect(request.getContextPath()+"/Admin/AdminHome.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/Admin/AdminErrorPage.jsp");
			//invaild admin
		}
		
	}

}
