package model;
//CREATE TABLE "TBLTICKET" 
//(
//"ID" NUMBER(8,0),
// "MOVIEID" NUMBER(8,0), 
// "TICKETID" NUMBER(4,0),
//  "UNM" VARCHAR2(30),
//   "MOB" VARCHAR2(30),
//    "EMAILID" VARCHAR2(30),
//     "GOLDSEATSBOOKED" VARCHAR2(300), 
//     "SILVERSEATSBOOKED" VARCHAR2(300),
//      "DATEOFSHOW" DATE,
//       "SLOT" VARCHAR2(30), 
//       "TOTALPRICE" NUMBER(5,0)
//      )
public class ClsTicket {
	int id;
	int intMovieId,intTicketId;
	String strUnm,strMob,strEmailid,strGoldSeatsBooked,strSilverSeatsBooked,strDateOfShow,strSlot;
	double dblTTlPrice;
	
	@Override
	public String toString() {
		return "ClsTicket [id=" + id + ", intMovieId=" + intMovieId + ", intTicketId=" + intTicketId + ", strUnm="
				+ strUnm + ", strMob=" + strMob + ", strEmailid=" + strEmailid + ", strGoldSeatsBooked="
				+ strGoldSeatsBooked + ", strSilverSeatsBooked=" + strSilverSeatsBooked + ", strDateOfShow="
				+ strDateOfShow + ", strSlot=" + strSlot + ", dblTTlPrice=" + dblTTlPrice + "]";
	}
	public ClsTicket() {
		super();
	}
	public ClsTicket(int id, int intMovieId, int intTicketId, String strUnm, String strMob, String strEmailid,
			String strGoldSeatsBooked, String strSilverSeatsBooked, String strDateOfShow, String strSlot,
			double dblTTlPrice) {
		super();
		this.id = id;
		this.intMovieId = intMovieId;
		this.intTicketId = intTicketId;
		this.strUnm = strUnm;
		this.strMob = strMob;
		this.strEmailid = strEmailid;
		this.strGoldSeatsBooked = strGoldSeatsBooked;
		this.strSilverSeatsBooked = strSilverSeatsBooked;
		this.strDateOfShow = strDateOfShow;
		this.strSlot = strSlot;
		this.dblTTlPrice = dblTTlPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIntMovieId() {
		return intMovieId;
	}
	public void setIntMovieId(int intMovieId) {
		this.intMovieId = intMovieId;
	}
	public int getIntTicketId() {
		return intTicketId;
	}
	public void setIntTicketId(int intTicketId) {
		this.intTicketId = intTicketId;
	}
	public String getStrUnm() {
		return strUnm;
	}
	public void setStrUnm(String strUnm) {
		this.strUnm = strUnm;
	}
	public String getStrMob() {
		return strMob;
	}
	public void setStrMob(String strMob) {
		this.strMob = strMob;
	}
	public String getStrEmailid() {
		return strEmailid;
	}
	public void setStrEmailid(String strEmailid) {
		this.strEmailid = strEmailid;
	}
	public String getStrGoldSeatsBooked() {
		return strGoldSeatsBooked;
	}
	public void setStrGoldSeatsBooked(String strGoldSeatsBooked) {
		this.strGoldSeatsBooked = strGoldSeatsBooked;
	}
	public String getStrSilverSeatsBooked() {
		return strSilverSeatsBooked;
	}
	public void setStrSilverSeatsBooked(String strSilverSeatsBooked) {
		this.strSilverSeatsBooked = strSilverSeatsBooked;
	}
	public String getStrDateOfShow() {
		return strDateOfShow;
	}
	public void setStrDateOfShow(String strDateOfShow) {
		this.strDateOfShow = strDateOfShow;
	}
	public String getStrSlot() {
		return strSlot;
	}
	public void setStrSlot(String strSlot) {
		this.strSlot = strSlot;
	}
	public double getDblTTlPrice() {
		return dblTTlPrice;
	}
	public void setDblTTlPrice(double dblTTlPrice) {
		this.dblTTlPrice = dblTTlPrice;
	}
	
	
}
