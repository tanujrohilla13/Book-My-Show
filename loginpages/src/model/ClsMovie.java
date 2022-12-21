package model;

//CREATE TABLE "TBLMOVIES" 
//(
//"MOVIEID" NUMBER(5,0), 
//"MOVIENAME" VARCHAR2(20), 
//"STARS" VARCHAR2(5), 
//"STARTDATE" DATE, 
//"ENDDATE" DATE, 
//"SLOT912" VARCHAR2(10), 
//"SLOT1215" VARCHAR2(10), 
//"SLOT1518" VARCHAR2(10), 
//"SLOT1821" VARCHAR2(10), "
//GOLDPRICE" NUMBER(3,0), 
//"SILVERPRICE" NUMBER(3,0),
// "IMAGENAME" VARCHAR2(20),
//  "LANGUAGE" VARCHAR2(20)
//  )
public class ClsMovie {

	int intMovieId;
	String strMovieName,strStars,strStartDate,strEndDate,strSlot912,strSlot1215,strSlot1518,strSlot1821;
	double dblGoldPrice;
	double dblSilverPrice;
	String strImgName;
	String strLanguage;
	
	
	
	@Override
	public String toString() {
		return "ClsMovie [intMovieId=" + intMovieId + ", strMovieName=" + strMovieName + ", strStars=" + strStars
				+ ", strStartDate=" + strStartDate + ", strEndDate=" + strEndDate + ", strSlot912=" + strSlot912
				+ ", strSlot1215=" + strSlot1215 + ", strSlot1518=" + strSlot1518 + ", strSlot1821=" + strSlot1821
				+ ", dblGoldPrice=" + dblGoldPrice + ", dblSilverPrice=" + dblSilverPrice + ", strImgName=" + strImgName
				+ ", strLanguage=" + strLanguage + "]";
	}
	public ClsMovie() {
		super();
	}
	public ClsMovie(int intMovieId, String strMovieName, String strStars, String strStartDate, String strEndDate,
			String strSlot912, String strSlot1215, String strSlot1518, String strSlot1821, double dblGoldPrice,
			double dblSilverPrice, String strImgName, String strLanguage) {
		super();
		this.intMovieId = intMovieId;
		this.strMovieName = strMovieName;
		this.strStars = strStars;
		this.strStartDate = strStartDate;
		this.strEndDate = strEndDate;
		this.strSlot912 = strSlot912;
		this.strSlot1215 = strSlot1215;
		this.strSlot1518 = strSlot1518;
		this.strSlot1821 = strSlot1821;
		this.dblGoldPrice = dblGoldPrice;
		this.dblSilverPrice = dblSilverPrice;
		this.strImgName = strImgName;
		this.strLanguage = strLanguage;
	}
	public int getIntMovieId() {
		return intMovieId;
	}
	public void setIntMovieId(int intMovieId) {
		this.intMovieId = intMovieId;
	}
	public String getStrMovieName() {
		return strMovieName;
	}
	public void setStrMovieName(String strMovieName) {
		this.strMovieName = strMovieName;
	}
	public String getStrStars() {
		return strStars;
	}
	public void setStrStars(String strStars) {
		this.strStars = strStars;
	}
	public String getStrStartDate() {
		return strStartDate;
	}
	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	public String getStrEndDate() {
		return strEndDate;
	}
	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}
	public String getStrSlot912() {
		return strSlot912;
	}
	public void setStrSlot912(String strSlot912) {
		this.strSlot912 = strSlot912;
	}
	public String getStrSlot1215() {
		return strSlot1215;
	}
	public void setStrSlot1215(String strSlot1215) {
		this.strSlot1215 = strSlot1215;
	}
	public String getStrSlot1518() {
		return strSlot1518;
	}
	public void setStrSlot1518(String strSlot1518) {
		this.strSlot1518 = strSlot1518;
	}
	public String getStrSlot1821() {
		return strSlot1821;
	}
	public void setStrSlot1821(String strSlot1821) {
		this.strSlot1821 = strSlot1821;
	}
	public double getDblGoldPrice() {
		return dblGoldPrice;
	}
	public void setDblGoldPrice(double dblGoldPrice) {
		this.dblGoldPrice = dblGoldPrice;
	}
	public double getDblSilverPrice() {
		return dblSilverPrice;
	}
	public void setDblSilverPrice(double dblSilverPrice) {
		this.dblSilverPrice = dblSilverPrice;
	}
	public String getStrImgName() {
		return strImgName;
	}
	public void setStrImgName(String strImgName) {
		this.strImgName = strImgName;
	}
	public String getStrLanguage() {
		return strLanguage;
	}
	public void setStrLanguage(String strLanguage) {
		this.strLanguage = strLanguage;
	}
	
	
	
	
	
}
