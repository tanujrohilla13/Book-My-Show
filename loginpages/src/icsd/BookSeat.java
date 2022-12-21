package icsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClsMovie;
import model.ClsSeatsBooked;

/**
 * Servlet implementation class BookSeat
 */
@WebServlet("/User/BookSeat")
public class BookSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSeat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//http://localhost:8089/v9ProjJSPServlet/User/BookSeat?
		//SilverSeatCheckBox=19&SilverSeatCheckBox=20&GoldSeatCheckBox=19&
		//GoldSeatCheckBox=20&intGoldPrice=500.0&
		//intSilverPrice=250.0&selectedSlot=slot912&
		//selctedDate=29-NOV-2020		
			PrintWriter out=response.getWriter();
			DBHandle objDHA=new DBHandle();
			String SilverSeatCheckBox[]=request.getParameterValues("SilverSeatCheckBox")  ;//3 4 9
			String GoldSeatCheckBox[]=request.getParameterValues("GoldSeatCheckBox")  ;//21 22
		   //  String strMid="12";
			HttpSession session=request.getSession(false);
			 String strMid= session.getAttribute("ssnmid").toString();//12
		     int mid=Integer.parseInt(strMid);//mid=12
			/////String strSlotChoosen="912",strDateOfShow="21-APR-2020";
		     String strSlotChoosen=request.getParameter("selectedSlot"),
		    		 strDateOfShow=request.getParameter("selctedDate");
			   SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		       java.util.Date date = null;
			try {
				date = sdf1.parse(strDateOfShow);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       java.sql.Date dt = new java.sql.Date(date.getTime());
		     
		       String strNewSilverSeatsBooked="";
		       int cnt=SilverSeatCheckBox.length;
		       double dblTtlSilverSeatsPrice=0.0,dblTtlGoldSeatsPrice=0.0;
		       ClsMovie  objClsMovie=objDHA.getmoviedetailbymovieid(strMid);
		       double dblSilverSeatPrice=objClsMovie.getDblSilverPrice();//250
		       double dblGoldSeatPrice=objClsMovie.getDblGoldPrice();//500
		       //SilverSeatCheckBox array - 3 4 9----> String - 3 ,4,9,
			for (String strSilverSeatBooked : SilverSeatCheckBox)//3 ,4 ,9//19,20----"19,20"			
			{
				if((SilverSeatCheckBox.length-1)==cnt)
				{
					strNewSilverSeatsBooked=strNewSilverSeatsBooked+strSilverSeatBooked;//"3,4,9"	
				}
				else
				{
					strNewSilverSeatsBooked=strNewSilverSeatsBooked+strSilverSeatBooked+",";//"3,4,9,"
				}
				cnt++;
				dblTtlSilverSeatsPrice=dblTtlSilverSeatsPrice+dblSilverSeatPrice;//250+250+250= 750
				out.println("SilverSeatBooked "+ strSilverSeatBooked);
			}
			out.println("new seats silver seats booked = "+strNewSilverSeatsBooked);
			
			
			
			ClsSeatsBooked  objClsTblSeatBooked= objDHA.getseatsbookedbyidandtimeandDateOfShowSql(strMid,strSlotChoosen,dt);
			//mid, strslotchoosen,dateofshow
			//oldseatsbooked - 1,2
			//new seat booked = 3,4,9
			//latest seats - 1,2,3,4,9-- and i need to update this values in tblseatbooked inside database.
			
			
			String strOldSilverSeatsBooked=objClsTblSeatBooked.getStrSilverSeatsBooked();
			
			String strLatestSilverSeatsBooked=strOldSilverSeatsBooked+strNewSilverSeatsBooked;
			objDHA.updatesilverseatsbooked(strLatestSilverSeatsBooked, strMid, strSlotChoosen, dt);
			
			
			
			//========================================================================================
			
			   String strNewGoldSeatsBooked="";
		       int cntG=GoldSeatCheckBox.length;
			for (String strGoldSeatBooked : GoldSeatCheckBox)			
			{
				if((GoldSeatCheckBox.length-1)==cntG)
				{
					strNewGoldSeatsBooked=strNewGoldSeatsBooked+strGoldSeatBooked;	
				}
				else
				{
					strNewGoldSeatsBooked=strNewGoldSeatsBooked+strGoldSeatBooked+",";
				}
				cnt++;
				dblTtlGoldSeatsPrice=dblTtlGoldSeatsPrice+dblGoldSeatPrice;
				out.println("SilverSeatBooked "+ strGoldSeatBooked);
			}
			out.println("new seats Gold seats booked = "+strNewGoldSeatsBooked);
			
			
			
			
			
			String strOldGoldSeatsBooked=objClsTblSeatBooked.getStrGoldSeatsbooked();
			
			String strLatestGoldSeatsBooked=strOldGoldSeatsBooked+strNewGoldSeatsBooked;
			objDHA.updateGoldseatsbooked(strLatestGoldSeatsBooked, strMid, strSlotChoosen, dt);
			
			
			
			
			//========================Ticket generation============================
//			desc tblticket
//			Name              Null     Type          
//			----------------- -------- ------------- 
//			ID                NOT NULL NUMBER(8)     
//			MOVIEID                    NUMBER(8)     
//			TICKETID                   NUMBER(4)     
//			UNM                        VARCHAR2(30)  
//			MOB                        VARCHAR2(30)  
//			EMAILID                    VARCHAR2(30)  
//			GOLDSEATSBOOKED            VARCHAR2(300) 
//			SILVERSEATSBOOKED          VARCHAR2(300) 
//			DATEOFSHOW                 DATE          
//			SLOT                       VARCHAR2(30)  
//			TOTALPRICE                 NUMBER(5)   
			
			String strUNM="deepak",strMob="123456",strEid="d@d.com",strGoldSeatsBooked=strNewGoldSeatsBooked,
					strSilverSeatsBooked=strNewSilverSeatsBooked,strSlot=strSlotChoosen;
			Date dtOfShow=dt;
			double dblTtlPrice=dblTtlGoldSeatsPrice+dblTtlSilverSeatsPrice;
			int intTicketId=objDHA.getMaxId("tblTicket", "id");
			intTicketId+=1;
			objDHA.insertintotblticket(intTicketId, strMid, strMid, strUNM, strMob, strEid, strGoldSeatsBooked, strSilverSeatsBooked, strSlot, dtOfShow, dblTtlPrice);
			
			out.println("ticekt generated is "+ intTicketId);
			//response.sendRedirect(request.getContextPath()+"/WelcomePageUser.jsp");
			
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
