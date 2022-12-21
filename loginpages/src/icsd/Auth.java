package icsd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {

	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
    public Auth() {

    }
    public Connection getDBCon()
    {
    	Connection con=null;
    	try {
			OracleDataSource ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con=ods.getConnection("kartik","icsd");
			System.out.println("connection established with oracle successfully ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return con;
    }
    public void init(ServletConfig config) throws ServletException    
    {
    	//we initialise resoruces inside init method
    	con=getDBCon();
    	try {
			stmt=con.prepareStatement("select * from tbluser where unm=? and pwd=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	  public void destroy()
	    {
	    	try
	    	{
		    	if(con!=null)
		    	{
		    		con.close();
		    	}
		    	if(stmt!=null)
		    	{
		    		stmt.close();
		    	}
		    	if(rset!=null)
		    	{
		    		rset.close();
		    	}
	    	}
	    	catch(SQLException se)
	    	{
	    		
	    	}
	    	System.out.println("destroy fired ");
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String strUnm,strPwd;
		strUnm=request.getParameter("txtUnm");
		strPwd=request.getParameter("txtPwd");
		try {
			stmt.setString(1, strUnm);
			stmt.setString(2, strPwd);
			rset=stmt.executeQuery();
			if(rset.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("unm", strUnm);
				
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
				
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/ErrorPage");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
