package icsd;

import java.io.IOException;
import java.io.PrintWriter;

//import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClsMovie;
import util.Utility;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		txtMid: 1
//		txtMovieName: bahubali
//		ddlStars: 5
//		startDate: 2020-11-20
//		endDate: 2020-11-28
//		slot912: slot912
//		slot1215: slot1215
//		slot1518: slot1518
//		txtGoldPrice: 500
//		txtSilverPrice: 250
//		txtLanguage: Hindi
//		txtImageName: b1.jpg
		
		PrintWriter out=response.getWriter();
		int intMovieId=Integer.parseInt(request.getParameter("txtMid"));
		String strMovieName=request.getParameter("txtMovieName"),
				strStars=request.getParameter("ddlStars"),
				strStartDate=request.getParameter("startDate"),
				strEndDate=request.getParameter("endDate"),
			strSlot912="false",strSlot1215="false",strSlot1518="false",strSlot1821="false";
		double dblGoldPrice=Double.parseDouble(request.getParameter("txtGoldPrice"));
		double dblSilverPrice=Double.parseDouble(request.getParameter("txtSilverPrice"));;
		String strImgName=request.getParameter("txtImageName");
		String strLanguage=request.getParameter("txtLanguage");
		String slots[]=request.getParameterValues("slot");
		for (String strSlot : slots) 
		{
			System.out.println(strSlot);
			if(strSlot.equals("slot912"))
			{
				strSlot912="true";			
			}
			
			if(strSlot.equals("slot1215"))
			{
				strSlot1215="true";
			}
			
			if(strSlot.equals("slot1518"))
			{
				strSlot1518="true";
			}
			
			if(strSlot.equals("slot1821"))
			{
				strSlot1821="true";
			}
		
			System.out.println();
		}
		
		
		Utility objUtil=new Utility();
		System.out.println("input date from calender is startdate : "+ strStartDate);
		
	//	String strStartDateDDMMYY=objUtil.dateInDDMMYYFromDDMMYYYY(strStartDate);
		//String strEndDateDDMMYY=objUtil.dateInDDMMYYFromDDMMYYYY(strEndDate);
	//	ClsMovie objClsMovie=new ClsMovie(intMovieId, strMovieName, strStars, strStartDateDDMMYY, strEndDateDDMMYY, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
		ClsMovie objClsMovie=new ClsMovie(intMovieId, strMovieName, strStars, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
		DBHandle objDH=new DBHandle();
//		objDH.uploadMovie(intMovieId, strMovieName, strStars, strStartDateDDMMYY, strEndDateDDMMYY, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strLanguage, strImgName);
	     int res=objDH.addMovie(objClsMovie);
	     int daysShowWillGo=objDH.getDaysShowWillGoByMovieId(String.valueOf(intMovieId));
	     
	     System.out.println("daysShowWillGo:  "+daysShowWillGo);
	     String strDateOfShow=strStartDate;
	     for(int i=1;i<=daysShowWillGo;i++)//i=1 2 3 4 
	     {
	    	if(strSlot912.equals("true")) 
	    	{
	    		objDH.insertintotblseatbooked(String.valueOf(intMovieId), "50", "50", "", "", strDateOfShow	, "50", "50", "slot912");
	    	}
	    	if(strSlot1215.equals("true")) 
	    	{
	    		objDH.insertintotblseatbooked(String.valueOf(intMovieId), "50", "50", "", "", strDateOfShow	, "50", "50", "slot1215");
	    	}
	    	if(strSlot1518.equals("true")) 
	    	{
	    		objDH.insertintotblseatbooked(String.valueOf(intMovieId), "50", "50", "", "", strDateOfShow	, "50", "50", "slot1518");
	    	}
	    	if(strSlot1821.equals("true")) 
	    	{
	    		objDH.insertintotblseatbooked(String.valueOf(intMovieId), "50", "50", "", "", strDateOfShow	, "50", "50", "slot1821");
	    	}
	    	strDateOfShow=Utility.addOneDayToDate(strDateOfShow);
	    	
	    	
	     }
//		if(res!=0)
//		{
//			response.sendRedirect(request.getContextPath()+"/Admin/AddMovie.jsp");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
