package model;

//CREATE TABLE "TBLSEATSBOOKED" 
//(
//"ID" NUMBER(10,0), 
//"MOVIEID" NUMBER(8,0), 
//"TTLGOLDSEATS" NUMBER(8,0),
//"TTLSILVERSEATS" NUMBER(8,0), 
//"GOLDSEATSBOOKED" VARCHAR2(300),
//"SILVERSEATSBOOKED" VARCHAR2(300),
// "DATEOFSHOW" DATE,
//  "GOLDAVAILSEATS" NUMBER(8,0),
//   "SILVERAVAILSEATS" NUMBER(8,0), 
//   "SLOTOFSHOW" VARCHAR2(10)
//  )
public class ClsSeatsBooked {

	int id,intMovieId,intTtlGoldSeats,intTtlSiverSeats,intGoldAvailSeats,intSilverAvailseats;
	String strDateOfshow;
	String strGoldSeatsbooked,strSilverSeatsBooked;
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
	public int getIntTtlGoldSeats() {
		return intTtlGoldSeats;
	}
	public void setIntTtlGoldSeats(int intTtlGoldSeats) {
		this.intTtlGoldSeats = intTtlGoldSeats;
	}
	public int getIntTtlSiverSeats() {
		return intTtlSiverSeats;
	}
	public void setIntTtlSiverSeats(int intTtlSiverSeats) {
		this.intTtlSiverSeats = intTtlSiverSeats;
	}
	public int getIntGoldAvailSeats() {
		return intGoldAvailSeats;
	}
	public void setIntGoldAvailSeats(int intGoldAvailSeats) {
		this.intGoldAvailSeats = intGoldAvailSeats;
	}
	public int getIntSilverAvailseats() {
		return intSilverAvailseats;
	}
	public void setIntSilverAvailseats(int intSilverAvailseats) {
		this.intSilverAvailseats = intSilverAvailseats;
	}
	public String getStrDateOfshow() {
		return strDateOfshow;
	}
	public void setStrDateOfshow(String strDateOfshow) {
		this.strDateOfshow = strDateOfshow;
	}
	public String getStrGoldSeatsbooked() {
		return strGoldSeatsbooked;
	}
	public void setStrGoldSeatsbooked(String strGoldSeatsbooked) {
		this.strGoldSeatsbooked = strGoldSeatsbooked;
	}
	public String getStrSilverSeatsBooked() {
		return strSilverSeatsBooked;
	}
	public void setStrSilverSeatsBooked(String strSilverSeatsBooked) {
		this.strSilverSeatsBooked = strSilverSeatsBooked;
	}
	@Override
	public String toString() {
		return "ClsSeatsBooked [id=" + id + ", intMovieId=" + intMovieId + ", intTtlGoldSeats=" + intTtlGoldSeats
				+ ", intTtlSiverSeats=" + intTtlSiverSeats + ", intGoldAvailSeats=" + intGoldAvailSeats
				+ ", intSilverAvailseats=" + intSilverAvailseats + ", strDateOfshow=" + strDateOfshow
				+ ", strGoldSeatsbooked=" + strGoldSeatsbooked + ", strSilverSeatsBooked=" + strSilverSeatsBooked + "]";
	}
	public ClsSeatsBooked(int id, int intMovieId, int intTtlGoldSeats, int intTtlSiverSeats, int intGoldAvailSeats,
			int intSilverAvailseats, String strDateOfshow, String strGoldSeatsbooked, String strSilverSeatsBooked) {
		super();
		this.id = id;
		this.intMovieId = intMovieId;
		this.intTtlGoldSeats = intTtlGoldSeats;
		this.intTtlSiverSeats = intTtlSiverSeats;
		this.intGoldAvailSeats = intGoldAvailSeats;
		this.intSilverAvailseats = intSilverAvailseats;
		this.strDateOfshow = strDateOfshow;
		this.strGoldSeatsbooked = strGoldSeatsbooked;
		this.strSilverSeatsBooked = strSilverSeatsBooked;
	}
	public ClsSeatsBooked() {
		super();
	}
	
	
}
