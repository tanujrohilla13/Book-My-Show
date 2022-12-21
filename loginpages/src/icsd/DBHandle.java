package icsd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import model.ClsMovie;
import model.ClsSeatsBooked;

import oracle.jdbc.pool.OracleDataSource;

/*
CREATE TABLE "TBLMOVIES" 
(
"MOVIEID" NUMBER(5,0), 
"MOVIENAME" VARCHAR2(20), 
"STARS" VARCHAR2(5), 
"STARTDATE" DATE, 
"ENDDATE" DATE, 
"SLOT912" VARCHAR2(10), 
"SLOT1215" VARCHAR2(10), 
"SLOT1518" VARCHAR2(10), 
"SLOT1821" VARCHAR2(10), "
GOLDPRICE" NUMBER(3,0), 
"SILVERPRICE" NUMBER(3,0),
 "IMAGENAME" VARCHAR2(20),
  "LANGUAGE" VARCHAR2(20)
  )
  
  
CREATE TABLE "TBLSEATSBOOKED" 
(
"ID" NUMBER(10,0), 
"MOVIEID" NUMBER(8,0), 
"TTLGOLDSEATS" NUMBER(8,0),
 "TTLSILVERSEATS" NUMBER(8,0), 
 "GOLDSEATSBOOKED" VARCHAR2(300),
  "SILVERSEATSBOOKED" VARCHAR2(300),
   "DATEOFSHOW" DATE,
    "GOLDAVAILSEATS" NUMBER(8,0),
     "SILVERAVAILSEATS" NUMBER(8,0), 
     "SLOTOFSHOW" VARCHAR2(10)
    )

CREATE TABLE "TBLTICKET" 
(
"ID" NUMBER(8,0),
 "MOVIEID" NUMBER(8,0), 
 "TICKETID" NUMBER(4,0),
  "UNM" VARCHAR2(30),
   "MOB" VARCHAR2(30),
    "EMAILID" VARCHAR2(30),
     "GOLDSEATSBOOKED" VARCHAR2(300), 
     "SILVERSEATSBOOKED" VARCHAR2(300),
      "DATEOFSHOW" DATE,
       "SLOT" VARCHAR2(30), 
       "TOTALPRICE" NUMBER(5,0)
      )

select * from tblmovies;
create table tblUser
(
  usid number(4) primary key,
  unm varchar(20),
  upwd varchar(20),
  urole varchar(20)
)
*/
public class DBHandle 
{

	public LinkedList<ClsMovie> getLinkListMovie ()
	{
		LinkedList<ClsMovie> lst =new LinkedList<ClsMovie>();
		
		Connection  con=getDBCon();
		
		try 
		{
			PreparedStatement stmt=con.prepareStatement("select  * from TBLMOVIES");
			ResultSet rset=stmt.executeQuery();
			
			
//			desc TBLMOVIES
//			Name        Null     Type         
//			----------- -------- ------------ 
//		1	MOVIEID NOT NULL NUMBER(5) 
//		2	MOVIENAME          VARCHAR2(20) 
//		3	STARS           VARCHAR2(5) 
//		4	STARTDATE          DATE    
//		5	ENDDATE          DATE    
//		6	SLOT912          VARCHAR2(10) 
//		7	SLOT1215          VARCHAR2(10) 
//		8	SLOT1518          VARCHAR2(10) 
//		9	SLOT1821          VARCHAR2(10) 
//		10	GOLDPRICE          NUMBER(3) 
//		11	SILVERPRICE          NUMBER(3) 
//		12  IMAGENAME          VARCHAR2(20) 
//		13	LANGUAGE          VARCHAR2(20) 
			while(rset.next())
			{
				
				String strStartDate=rset.getString("STARTDATE"),
						strEndDate=rset.getString("ENDDATE");
						
		
				 
				
				
				
				int  intMovieId=rset.getInt("MOVIEID");
					double dblGoldPrice=rset.getDouble("GOLDPRICE")
					,dblSilverPrice=rset.getDouble("SILVERPRICE");
				
				String   strMovieName=rset.getString("MOVIENAME")
					    ,strStars=rset.getString("STARS")
					    ,strLanguage=rset.getString("LANGUAGE")
						,strSlot912=rset.getString("SLOT912")
						,strSlot1215=rset.getString("SLOT1215")
						,strSlot1518=rset.getString("SLOT1518")
						,strSlot1821=rset.getString("SLOT1821")
					    ,strImgName=rset.getString("IMAGENAME");
//				Date strStartDate=rset.getDate("STARTDATE"),
//						strEndDate=rset.getDate("ENDDATE");
				
			//	Blob blobMovieImage=rset.getBlob("");
				
				 ClsMovie objClsMovie=new ClsMovie(intMovieId, strMovieName, strStars, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
				
				 lst.add(objClsMovie);
				
				
				
			}//while
				
			 con.close();
		} catch (SQLException e) {e.printStackTrace();}

		return lst;
		
	
		
	}
	
	
	public ClsMovie getMovieDetailsByMovieId ( int movieID)
	{
		ClsMovie objClsMovie =new ClsMovie();
		
	 	Connection con=getDBCon();
		
		try 
		{
			PreparedStatement stmt=con.prepareStatement("select  * from TBLMOVIES where MOVIEID=?");
			stmt.setInt(1, movieID);
			ResultSet rset=stmt.executeQuery();
			
			
//			desc TBLMOVIES
//			Name        Null     Type         
//			----------- -------- ------------ 
//		1	MOVIEID NOT NULL NUMBER(5) 
//		2	MOVIENAME          VARCHAR2(20) 
//		3	STARS           VARCHAR2(5) 
//		4	STARTDATE          DATE    
//		5	ENDDATE          DATE    
//		6	SLOT912          VARCHAR2(10) 
//		7	SLOT1215          VARCHAR2(10) 
//		8	SLOT1518          VARCHAR2(10) 
//		9	SLOT1821          VARCHAR2(10) 
//		10	GOLDPRICE          NUMBER(3) 
//		11	SILVERPRICE          NUMBER(3) 
//		12  IMAGENAME          VARCHAR2(20) 
//		13	LANGUAGE          VARCHAR2(20) 
			if(rset.next())
			{
				String strStartDate=rset.getString("STARTDATE"),
						strEndDate=rset.getString("ENDDATE");
						
		
				 
				
				
				
				int  intMovieId=rset.getInt("MOVIEID");
					double dblGoldPrice=rset.getDouble("GOLDPRICE")
					,dblSilverPrice=rset.getDouble("SILVERPRICE");
				
				String   strMovieName=rset.getString("MOVIENAME")
					    ,strStars=rset.getString("STARS")
					    ,strLanguage=rset.getString("LANGUAGE")
						,strSlot912=rset.getString("SLOT912")
						,strSlot1215=rset.getString("SLOT1215")
						,strSlot1518=rset.getString("SLOT1518")
						,strSlot1821=rset.getString("SLOT1821")
					    ,strImgName=rset.getString("IMAGENAME");
				
//				int  intMovieId=rset.getInt("MOVIEID")
//					,intGoldPrice=rset.getInt("GOLDPRICE")
//					,intSilverPrice=rset.getInt("SILVERPRICE");
//				
//				String   strMovieName=rset.getString("MOVIENAME")
//					    ,strMovieStar=rset.getString("STARS")
//					    ,strMovieLanguage=rset.getString("LANGUAGE")
//						,strSlot912=rset.getString("SLOT912")
//						,strSlot1215=rset.getString("SLOT1215")
//						,strSlot1518=rset.getString("SLOT1518")
//						,strSlot1821=rset.getString("SLOT1821")
//					    ,strMovieImageName=rset.getString("IMAGENAME");
//				Date strStartDate=rset.getDate("STARTDATE"),
//						strEndDate=rset.getDate("ENDDATE");
				
			//	Blob blobMovieImage=rset.getBlob("");
				
				 objClsMovie=new ClsMovie(intMovieId, strMovieName, strStars, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
				
			}//while
				
			 con.close();
		} catch (SQLException e) {e.printStackTrace();}

		return objClsMovie;
		
	}
	
	
	
	//========================================================
	
	//differnece between 2 dates
	public int getDaysShowWillGoByMovieId(String strMovieId)
	{
		int daysShowWillGo=0;
		Connection con=getDBCon();
		try {
			System.out.println("strmovieid : "+ strMovieId);
			PreparedStatement stmt=con.prepareStatement("select enddate-startdate as res  from tblmovies where movieid=?");
			stmt.setString(1, strMovieId);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				daysShowWillGo=rset.getInt("res");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daysShowWillGo;
	}
	public int getMaxId(String strTblName,String strColName)
	{
		int maxid=0;
		Connection con=getDBCon();
		try {
			PreparedStatement stmt=con.prepareStatement("select max("+strColName+") as id from "+ strTblName);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				maxid=rset.getInt("id");
			}
			else
			{
				maxid=0;
			}
			con.close();stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxid;
	}
	
	public void uploadMovie(int  intMovieId,String strMovieName,String strMovieStar
			,String  strStartDate,String  strEndDate
			,String strSlot912,String strSlot1215,String strSlot1518,String strSlot1821
			,double dblGoldPrice,double dblSilverPrice,
			/////// image paerameter.............. 
			String strMovieLanguage,String strMovieImageName)
{

			
			Date StartDate= Date.valueOf(strStartDate),
			EndDate=Date.valueOf(strEndDate);
			System.out.println(StartDate);
			System.out.println(EndDate);
//			CREATE TABLE "TBLMOVIES" 
//			(
//			"MOVIEID" NUMBER(5,0), 
//			"MOVIENAME" VARCHAR2(20), 
//			"STARS" VARCHAR2(5), 
//			"STARTDATE" DATE, 
//			"ENDDATE" DATE, 
//			"SLOT912" VARCHAR2(10), 
//			"SLOT1215" VARCHAR2(10), 
//			"SLOT1518" VARCHAR2(10), 
//			"SLOT1821" VARCHAR2(10), "
//			GOLDPRICE" NUMBER(3,0), 
//			"SILVERPRICE" NUMBER(3,0),
//			 "IMAGENAME" VARCHAR2(20),
//			  "LANGUAGE" VARCHAR2(20)
//			  )
			//desc TBLMOVIES
			//Name        Null     Type         
			//----------- -------- ------------ 
			//1	MOVIEID NOT NULL NUMBER(5) 
			//2	MOVIENAME          VARCHAR2(20) 
			//3	STARS           VARCHAR2(5) 
			//4	STARTDATE          DATE    
			//5	ENDDATE          DATE    
			//6	SLOT912          VARCHAR2(10) 
			//7	SLOT1215          VARCHAR2(10) 
			//8	SLOT1518          VARCHAR2(10) 
			//9	SLOT1821          VARCHAR2(10) 
			//10	GOLDPRICE          NUMBER(3) 
			//11	SILVERPRICE          NUMBER(3) 
			//12  IMAGENAME          VARCHAR2(20) 
			//13	LANGUAGE          VARCHAR2(20) 
			
			Connection con=getDBCon();
			try 
			{
			//......................................................1  2   3   4   5   6   7   8   9  10  11  12   13
			PreparedStatement  stmt=con.prepareStatement("insert into TBLMOVIES values(?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)");
			
			stmt.setInt(1, intMovieId);
			stmt.setString(2, strMovieName);
			stmt.setString(3, strMovieStar);
			stmt.setDate(4,StartDate);
			stmt.setDate(5,EndDate);
			stmt.setString(6,strSlot912);
			stmt.setString(7,strSlot1215);
			stmt.setString(8,strSlot1518);
			stmt.setString(9,strSlot1821);
			stmt.setDouble(10,dblGoldPrice);
			stmt.setDouble(11,dblSilverPrice);
			stmt.setString(12,strMovieImageName);
			stmt.setString(13, strMovieLanguage);
			
			ClsMovie obj=new ClsMovie(intMovieId, strMovieName, strMovieStar, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strMovieImageName, strMovieLanguage);
			System.out.println(obj);
			stmt.executeUpdate();
			con.close();
			
			} catch (SQLException e) {e.printStackTrace();}


}
//	desc tblseatbooked
//	Name              Null?    Type          
//			----------------- -------- ------------- 
//			ID                NOT NULL NUMBER(10)    
//			MOVIEID                    NUMBER(8)     
//			TTLGOLDSEATS               NUMBER(8)     
//			TTLSILVERSEATS             NUMBER(8)     
//			GOLDSEATSBOOKED            VARCHAR2(300) 
//			SILVERSEATSBOOKED          VARCHAR2(300) 
//			DATEOFSHOW                 DATE          
//			GOLDAVAILSEATS             NUMBER(8)     
//			SILVERAVAILSEATS           NUMBER(8)     
//			SLOTOFSHOW                 VARCHAR2(10)  

//	Name             Null Type          
//	---------------- ---- ------------- 
//	ID                    NUMBER(10)    
//	MOVIEID               NUMBER(8)     
//	TTLGOLDSEATS          NUMBER(8)     
//	TTLSILVERSEATS        NUMBER(8)     
//	GOLDSEATBOOKED        VARCHAR2(300) 
//	SILVERSEATBOOKED      VARCHAR2(300) 
//	DATEOFSHOW            VARCHAR2(50)  
//	GOLDAVAILSEATS        NUMBER(8)     
//	SILVERAVAILSEATS      NUMBER(8)     
//	SLOTOFSHOW            VARCHAR2(10)  
	public void insertintotblseatbooked( String strmid, String totalgseats,
			String totalsseats, String strgoldseatbooked, String strsilverseatbooked, String strdateofshow,
			String strgoldseatsremaining, String strsilverseatsavailable, String strslotofshow)
	{

		Connection con=getDBCon();

		try {
			Date StartDate= Date.valueOf(strdateofshow);
					;
			PreparedStatement stmt=con.prepareStatement("insert into tblseatsbooked values(?,?,?,?,?,?,?,?,?,?)");
			int  intId=getMaxId("tblseatsbooked", "ID");
			intId++;
			String strId=String.valueOf(intId);
			
			stmt.setString(1,strId);
			stmt.setString(2,strmid);
			stmt.setString(3,totalgseats);
			stmt.setString(4,totalsseats);
			stmt.setString(5,strgoldseatbooked);
			stmt.setString(6,strsilverseatbooked);
			stmt.setDate(7,StartDate);
			stmt.setString(8,strgoldseatsremaining);
			stmt.setString(9,strsilverseatsavailable);
			stmt.setString(10,strslotofshow);
		
			
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableseatbooked");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
	}
	
	public int addMovie(ClsMovie obj)
	{
		int res=0;
		Connection con=getDBCon();
		try {
			System.out.println(obj);
			PreparedStatement stmt=con.prepareStatement("insert into tblmovies values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, obj.getIntMovieId());
			stmt.setString(2, obj.getStrMovieName());
			stmt.setString(3, obj.getStrStars());
			
			Date StartDate= Date.valueOf(obj.getStrStartDate());
			Date EndDate= Date.valueOf(obj.getStrEndDate());
			stmt.setDate(4, StartDate);
			stmt.setDate(5, EndDate);
//			stmt.setString(4, "20-11-20");
//			stmt.setString(5, "20-11-20");
			stmt.setString(6, obj.getStrSlot912());
			stmt.setString(7, obj.getStrSlot1215());
			stmt.setString(8, obj.getStrSlot1518());
			stmt.setString(9, obj.getStrSlot1821());
			stmt.setDouble(10, obj.getDblGoldPrice());
			stmt.setDouble(11, obj.getDblSilverPrice());
			stmt.setString(12, obj.getStrImgName());
			stmt.setString(13, obj.getStrLanguage());
			
			res=stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("data insrted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public void deleteMovie()
	{
		
	}
	public int updateMovie(ClsMovie obj)
	{

		int res=0;
		Connection con=getDBCon();
		try {
			PreparedStatement stmt=con.prepareStatement
		("update tblmovies set moviename=?,stars=?,startdate=?,enddate=?,slot912=?,slot1215=?,slot1518=?,slot1821=?,goldprice=?,silverprice=?,imagename=?,language=? where movieid=?");
			stmt.setInt(13, obj.getIntMovieId());
			stmt.setString(1, obj.getStrMovieName());
			stmt.setString(2, obj.getStrStars());
			stmt.setString(3, obj.getStrStartDate());
			stmt.setString(4, obj.getStrEndDate());
			stmt.setString(5, obj.getStrSlot912());
			stmt.setString(6, obj.getStrSlot1215());
			stmt.setString(7, obj.getStrSlot1518());
			stmt.setString(8, obj.getStrSlot1821());
			stmt.setDouble(9, obj.getDblGoldPrice());
			stmt.setDouble(10, obj.getDblSilverPrice());
			stmt.setString(11, obj.getStrImgName());
			stmt.setString(12, obj.getStrLanguage());
			
			res=stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("data insrted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public LinkedList<ClsMovie>  getTblMovie()
	{
		LinkedList<ClsMovie> lst=new LinkedList<>();
		 ClsMovie obj=null;
		  Connection con=getDBCon();
		  try {
			PreparedStatement stmt=con.prepareStatement("select * from tblmovies ");
			
			ResultSet rset=stmt.executeQuery();
			while(rset.next())
			{
				int intMovieId=rset.getInt("MOVIEID");
				String strMovieName=rset.getString("moviename"),
						strStars=rset.getString("stars"),
						strStartDate=rset.getString("startdate"),
						strEndDate=rset.getString("enddate"),
						strSlot912=rset.getString("slot912"),
						strSlot1215=rset.getString("slot1215"),
						strSlot1518=rset.getString("slot1518"),
						strSlot1821=rset.getString("slot1821");
				double dblGoldPrice=rset.getDouble("goldprice");
				double dblSilverPrice=rset.getDouble("silverprice");
				String strImgName=rset.getString("imagename");
				String strLanguage=rset.getString("language");
				obj=new ClsMovie(intMovieId, strMovieName, strStars, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
				System.out.println("inside getTblMovie");
				System.out.println(obj);
				lst.add(obj);
				System.out.println("************end getTblMovie*********************************");
				
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return lst;
	}
	public ClsMovie getMovieRowFromTblMOvieBYMovieId(int intMoiveId )
	{
		
//		CREATE TABLE "TBLMOVIES" 
//		(
//		"MOVIEID" NUMBER(5,0), 
//		"MOVIENAME" VARCHAR2(20), 
//		"STARS" VARCHAR2(5), 
//		"STARTDATE" DATE, 
//		"ENDDATE" DATE, 
//		"SLOT912" VARCHAR2(10), 
//		"SLOT1215" VARCHAR2(10), 
//		"SLOT1518" VARCHAR2(10), 
//		"SLOT1821" VARCHAR2(10), "
//		GOLDPRICE" NUMBER(3,0), 
//		"SILVERPRICE" NUMBER(3,0),
//		 "IMAGENAME" VARCHAR2(20),
//		  "LANGUAGE" VARCHAR2(20)
//		  )
		  ClsMovie obj=null;
		  Connection con=getDBCon();
		  try {
			PreparedStatement stmt=con.prepareStatement("select * from tblmovies where movieid=?");
			stmt.setInt(1, intMoiveId);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				
				String strMovieName=rset.getString("moviename"),
						strStars=rset.getString("stars"),
						strStartDate=rset.getString("startdate"),
						strEndDate=rset.getString("enddate"),
						strSlot912=rset.getString("slot912"),
						strSlot1215=rset.getString("slot1215"),
						strSlot1518=rset.getString("slot1518"),
						strSlot1821=rset.getString("slot1821");
				double dblGoldPrice=rset.getDouble("goldprice");
				double dblSilverPrice=rset.getDouble("silverprice");
				String strImgName=rset.getString("imagename");
				String strLanguage=rset.getString("language");
				obj=new ClsMovie(intMoiveId, strMovieName, strStars, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
				System.out.println("inside getMovieRowFromTblMOvieBYMovieId");
				System.out.println(obj);
				System.out.println("************end getMovieRowFromTblMOvieBYMovieId*********************************");
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return obj;
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
	 
	 public boolean isValidAdmin(String strUnm,String strPwd)
	 {
		 System.out.print(strUnm);
		 boolean res=false;
		 Connection con=getDBCon();
		 try {
PreparedStatement stmt=con.prepareStatement("select * from tbluser where unm=? and upwd=? and urole='admin'");
			stmt.setString(1, strUnm);
			stmt.setString(2, strPwd);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				res=true;//valid admin 
			}
			else
			{
				res=false;//invalid admin 
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return res;		 
	 }
	 
	 public boolean isValidUser(String strUnm,String strPwd)
	 {
		 boolean res=false;
		 Connection con=getDBCon();
		 try {
			PreparedStatement stmt=con.prepareStatement("select * from tbluser where unm=? and upwd=? and urole='user'");
			stmt.setString(1, strUnm);stmt.setString(2, strPwd);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				res=true;//valid user 
			}
			else
			{
				res=false;//invalid user 
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return res;
		 
	 }
public void Insert(String strunm,String strpwd,String strrole)
{
	
	try 
	{
		 Connection con=getDBCon();
     PreparedStatement stmt=con.prepareStatement("insert into UserLogin1 values(?,?,?)");
	    stmt.setString(1,strunm);
	    stmt.setString(2,strpwd);
	    stmt.setString(3,strrole);
	    stmt.executeUpdate();
	    System.out.println("inserted values ");
	    con.close();
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	 public boolean isValidUser1(String strUnm,String strPwd)
	 {
		 boolean res=false;
		 Connection con=getDBCon();
		 try {
			PreparedStatement stmt=con.prepareStatement("select * from UserLogin1 where userid=? and UserPassword=? and  productname ='user'");
			stmt.setString(1, strUnm);stmt.setString(2, strPwd);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				res=true;//valid user 
			}
			else
			{
				res=false;//invalid user 
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return res;
		 
	 }
	 
	 
	 
//		desc tblticket
//		Name              Null     Type          
//		----------------- -------- ------------- 
//		ID                NOT NULL NUMBER(8)     
//		MOVIEID                    NUMBER(8)     
//		TICKETID                   NUMBER(4)     
//		UNM                        VARCHAR2(30)  
//		MOB                        VARCHAR2(30)  
//		EMAILID                    VARCHAR2(30)  
//		GOLDSEATSBOOKED            VARCHAR2(300) 
//		SILVERSEATSBOOKED          VARCHAR2(300) 
//		DATEOFSHOW                 DATE          
//		SLOT                       VARCHAR2(30)  
//		TOTALPRICE                 NUMBER(5) 
		public void insertintotblticket(int ticketid,String strMovieId,String strMid,String strunm,String strMob,String Eid,String strGoldSeatsBooked,
				String strSilverSeatsBooked,String strSlot,Date dtOfShow,double dblTtlPrice)	
		{

			Connection con=getDBCon();

			try {
				PreparedStatement stmt=con.prepareStatement("insert into tblticket values(?,?,?,?,?,?,?,?,?,?,?)");
				
				
				stmt.setInt(1,ticketid);
				stmt.setString(2,strMid);
				stmt.setInt(3,ticketid);
				stmt.setString(4,strunm);
				stmt.setString(5,strMob);
				stmt.setString(6,Eid);
				stmt.setString(7,strGoldSeatsBooked);
				stmt.setString(8,strSilverSeatsBooked);
				stmt.setDate(9,dtOfShow);
				stmt.setString(10,strSlot);
				stmt.setDouble(11,dblTtlPrice);
				
				
				stmt.executeUpdate();
				System.out.println("data inserted into tableticket");

			con.close();
			stmt.close();
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

		
		
//		desc tblmovies
//		Name        Null Type         
//		----------- ---- ------------ 
//		MOVIEID          NUMBER(5)    
//		MOVIENAME        VARCHAR2(20) 
//		STARS            VARCHAR2(5)  
//		STARTDATE        DATE         
//		ENDDATE          DATE         
//		SLOT912          VARCHAR2(10) 
//		SLOT1215         VARCHAR2(10) 
//		SLOT1518         VARCHAR2(10) 
//		SLOT1821         VARCHAR2(10) 
//		GOLDPRICE        NUMBER(3)    
//		SILVERPRICE      NUMBER(3)    
//		IMAGENAME        VARCHAR2(20) 
//		LANGUAGE         VARCHAR2(20) 
//		Name        Null? Type         
//				----------- ----- ------------ 
//				MOVIEID           NUMBER(5)    
//				MOVIENAME         VARCHAR2(20) 
//				STARS             VARCHAR2(5)  
//				STARTDATE         DATE         
//				ENDDATE           DATE         
//				SLOT912           VARCHAR2(10) 
//				SLOT1215          VARCHAR2(10) 
//				SLOT1518          VARCHAR2(10) 
//				SLOT1821          VARCHAR2(10) 
//				GOLDPRICE         NUMBER(3)    
//				SILVERPRICE       NUMBER(3)    
//				IMAGENAME         VARCHAR2(20) 
//				LANGUAGE          VARCHAR2(20) 
		public ClsMovie getmoviedetailbymovieid(String strmid)
		{
			ClsMovie objci=null;
			
			
			Connection con=getDBCon();
			try
			{
				PreparedStatement stmt= con.prepareStatement("select * from tblmovies where movieid=?");
				stmt.setString(1,strmid);
				ResultSet rset=stmt.executeQuery();
				//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
				if(rset.next())
				{
					int intMovieId=rset.getInt("movieid");
					String strStartDate=rset.getString("STARTDATE"),strEndDate=rset.getString("ENDDATE");
							
					
					String 
							strMovieName=rset.getString("moviename"),
							strStars=rset.getString("stars"),
							strSlot912=rset.getString("SLOT912"),
							strSlot1215=rset.getString("SLOT1215"),
							strSlot1518=rset.getString("SLOT1518"),
							strSlot1821=rset.getString("SLOT1821"),
									strImgName=rset.getString("IMAGENAME"),
											strLanguage=rset.getString("LANGUAGE");
					Date dtStartDate=rset.getDate("STARTDATE"),
					dtEndDate=rset.getDate("ENDDATE");
					double dblGoldPrice=rset.getDouble("GOLDPRICE"),
					dblSilverPrice=rset.getDouble("SILVERPRICE");
					objci=new ClsMovie(intMovieId, strMovieName, strStars, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, dblGoldPrice, dblSilverPrice, strImgName, strLanguage);
					System.out.println(objci);
				}
				
				con.close();//to close tht connection'
			
				stmt.close();//to close tht statement
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		return objci;
			// TODO Auto-generated method stub

		}

		

//		desc tblseatsbooked
//		Name             Null Type          
//		---------------- ---- ------------- 
//		ID                    NUMBER(10)    
//		MOVIEID               NUMBER(8)     
//		TTLGOLDSEATS          NUMBER(8)     
//		TTLSILVERSEATS        NUMBER(8)     
//		GOLDSEATBOOKED        VARCHAR2(300) 
//		SILVERSEATBOOKED      VARCHAR2(300) 
//		DATEOFSHOW            DATE          
//		GOLDAVAILSEATS        NUMBER(8)     
//		SILVERAVAILSEATS      NUMBER(8)     
//		SLOTOFSHOW            VARCHAR2(10)
		//GOLDAVAILSEATS,SILVERAVAILSEATS,SLOTOFSHOW
//		
//		ID                NOT NULL NUMBER(10)    
//		MOVIEID                    NUMBER(8)     
//		TTLGOLDSEATS               NUMBER(8)     
//		TTLSILVERSEATS             NUMBER(8)     
//		GOLDSEATSBOOKED            VARCHAR2(300) 
//		SILVERSEATSBOOKED          VARCHAR2(300) 
//		DATEOFSHOW                 DATE          
//		GOLDAVAILSEATS             NUMBER(8)     
//		SILVERAVAILSEATS           NUMBER(8)     
//		SLOTOFSHOW                 VARCHAR2(10) 

		public void updatesilverseatsbooked(String strNewSilverSeats, String strmid, String strshowtime,Date dtOfShow)
		{
			
		     SimpleDateFormat dfDateFormat = new SimpleDateFormat("dd-MMM-yy");

		    

		        
		        System.out.println("inside getsetatsbookedbyidanditineanddateofshow = formatted  "+dfDateFormat.format(dtOfShow));
		        String strDateOfShow=dfDateFormat.format(dtOfShow);
		    
		    
			
		        System.out.println("strshowtime : "+ strshowtime);
		        System.out.println("strDateofshow "+ strDateOfShow);
		      //  stmt.setString(2,strDateOfShow);
		        
		        
		        
			Connection con=getDBCon();

			try {
				
				PreparedStatement stmt=con.prepareStatement("update tblseatsbooked set SILVERSEATSBOOKED=? where movieid=? and slotofshow=? and dateofshow=to_date(?,'dd-MON-yy')");
			
				stmt.setString(1,strNewSilverSeats);
				stmt.setString(2,strmid);
				stmt.setString(3, strshowtime);
				stmt.setString(4, strDateOfShow);
				
				stmt.executeUpdate();
				System.out.println("data inserted into tableseatbooked");
				//dispTblmovies()
			con.close();
			stmt.close();
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
		}


		public void updateGoldseatsbooked(String strNewGoldSeats, String strmid, String strshowtime,Date dtOfShow)
		{
		     SimpleDateFormat dfDateFormat = new SimpleDateFormat("dd-MMM-yy");
  
		        System.out.println("inside getsetatsbookedbyidanditineanddateofshow = formatted  "+dfDateFormat.format(dtOfShow));
		        String strDateOfShow=dfDateFormat.format(dtOfShow);
		    
		        System.out.println("strshowtime : "+ strshowtime);
		        System.out.println("strDateofshow "+ strDateOfShow);
		        
			Connection con=getDBCon();

			try {
				
				PreparedStatement stmt=con.prepareStatement("update tblseatsbooked set GOLDSEATSBOOKED=? where movieid=? and slotofshow=? and dateofshow=to_date(?,'dd-MON-yy')");
				System.out.println("ethe hun bauji");
				stmt.setString(1,strNewGoldSeats);
				stmt.setString(2,strmid);
				stmt.setString(3, strshowtime);
				stmt.setString(4, strDateOfShow);
				
				stmt.executeUpdate();
				System.out.println("data inserted into tableseatbooked");
				//dispTblmovies()
			con.close();
			stmt.close();
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
		}


		
		
		
		public LinkedList< ClsSeatsBooked> lstGetseatsbookedbyidandtimeandDateOfShowSql(String strmid, String strshowtime,Date strDateOfShow)
		{
			LinkedList<ClsSeatsBooked> lst=new LinkedList<>();
			ClsSeatsBooked objTblSeatsBooked=null;
			
			
			Connection con=getDBCon();
			try
			{
				//select  * FROM tblseatbooked where movieid=12 and dateofshow='15-apr-2020' and slotofshow=912;
				PreparedStatement stmt= con.prepareStatement("select  * FROM tblseatsbooked where movieid=? and dateofshow=? and slotofshow=?");
				stmt.setString(1,strmid);
				stmt.setString(2,strshowtime);
				stmt.setDate(3, strDateOfShow);

		
				
				ResultSet rset=stmt.executeQuery();
				//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
				while(rset.next())
				{
					
					String strDateOfshow=rset.getString("dateofshow");
					
					
					int id=rset.getInt("id"),intMovieId=rset.getInt("movieid"),intTtlGoldSeats=rset.getInt("TTLGOLDSEATS"),
							intTtlSiverSeats=rset.getInt("TTLSILVERSEATS"),
									intGoldAvailSeats=rset.getInt("GOLDAVAILSEATS"),
											intSilverAvailseats=rset.getInt("SILVERAVAILSEATS");
					String strSlotOfShow=rset.getString("SLOTOFSHOW"),strGoldSeatsbooked=rset.getString("GOLDSEATBOOKED"),
							strSilverSeatsBooked=rset.getString("SILVERSEATBOOKED");
					Date dateOfShow=rset.getDate("dateofshow");
					
					objTblSeatsBooked=new ClsSeatsBooked(id, intMovieId, intTtlGoldSeats, intTtlSiverSeats, intGoldAvailSeats, intSilverAvailseats, strDateOfshow, strGoldSeatsbooked, strSilverSeatsBooked);
				System.out.println("inside getseatsbookedbyidandtimeandDateOfShowSql "+objTblSeatsBooked);
					lst.add(objTblSeatsBooked);
				}
				
				con.close();//to close tht connection'
			
				stmt.close();//to close tht statement
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		return lst;


			
		}
		
		
		
		public LinkedList<String> lstGetUniqueDateseatsbookedbyid(String strmid)
		{
			LinkedList<String> lst=new LinkedList<>();
			ClsSeatsBooked objTblSeatsBooked=null;
			
			
			Connection con=getDBCon();
			try
			{
				//select  * FROM tblseatbooked where movieid=12 and dateofshow='15-apr-2020' and slotofshow=912;
				//PreparedStatement stmt= con.prepareStatement("select  DISTINCT to_char(dateofshow,'dd-MON-yyyy') AS DATEOFSHOW FROM tblseatsbooked where movieid=?");
				PreparedStatement stmt= con.prepareStatement("select  DISTINCT to_char(dateofshow,'dd-MON-yyyy') AS DATEOFSHOW FROM tblseatsbooked where movieid=?");
				stmt.setString(1,strmid);
		
				
				ResultSet rset=stmt.executeQuery();
				//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
				while(rset.next())
				{
					
					System.out.println("1.1");			
					//Date dateOfShow=rset.getDate("DATEOFSHOW");
					 String dateOfShow=rset.getString("DATEOFSHOW");
					 
					System.out.println("1.2");
					
					System.out.println("lstGetUniqueDateseatsbookedbyid "+dateOfShow+" ");
					lst.add(dateOfShow);
				}
				
				con.close();//to close tht connection'
			
				stmt.close();//to close tht statement
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		return lst;


			
		}
		public ClsSeatsBooked getseatsbookedbyidandtimeandDateOfShowSql(String strmid, String strshowtime,Date sqlDateOfShow)
		{
			ClsSeatsBooked objTblSeatsBooked=null;
			
			System.out.println("strmid= "+ strmid+" strshowtime= "+ strshowtime+"  sqldateoshow= "+ sqlDateOfShow);
			Connection con=getDBCon();
			try
			{
				//select  * FROM tblseatbooked where movieid=9 and dateofshow='21-apr-2020' and slotofshow=912;
//				PreparedStatement stmt= con.prepareStatement("select  ID,MOVIEID,TTLGOLDSEATS,TTLSILVERSEATS,GOLDSEATBOOKED,SILVERSEATBOOKED,to_char(dateofshow,'dd-MON-yyyy') AS DATEOFSHOW,GOLDAVAILSEATS,SILVERAVAILSEATS,SLOTOFSHOW FROM tblseatbooked where movieid=? and dateofshow=? and slotofshow=?");
				//PreparedStatement stmt=con.prepareStatement("select to_date('"+strStartDate+"')- to_date('"+strEndDate+"') as diff from dual");
				PreparedStatement stmt= con.prepareStatement("select  * FROM tblseatsbooked where movieid=? and dateofshow=to_date(?,'dd-MON-yy') and slotofshow=?");
				//											  select  * FROM tblseatbooked where movieid=12 and dateofshow=to_date('17-Apr-2020','dd-MON-yy') and slotofshow=912;
				stmt.setString(1,strmid);
				stmt.setString(3,strshowtime);
			     SimpleDateFormat dfDateFormat = new SimpleDateFormat("dd-MMM-yy");

			    

			        
			        System.out.println("inside getsetatsbookedbyidanditineanddateofshow = formatted  "+dfDateFormat.format(sqlDateOfShow));
			        String strDateOfShow=dfDateFormat.format(sqlDateOfShow);
			        //                  inside getsetatsbookedbyidanditineanddateofshow = formatted  17-Apr-20
			    
				//stmt.setDate(3, sqlDateOfShow);
			        System.out.println("strshowtime : "+ strshowtime);
			        System.out.println("strDateofshow "+ strDateOfShow);
			        stmt.setString(2,strDateOfShow);
				////////////////////////strDateofShow inside getseatsbookedbyidandtimeanddateofshowsql 2020-04-17                                                             2020-04-17
				System.out.println("strDateofShow inside getseatsbookedbyidandtimeanddateofshowsql "+sqlDateOfShow);
				ResultSet rset=stmt.executeQuery();
				//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
				if(rset.next())
				{
					
					
String strDateOfshow=rset.getString("dateofshow");
					
					
					int id=rset.getInt("id"),intMovieId=rset.getInt("movieid"),intTtlGoldSeats=rset.getInt("TTLGOLDSEATS"),
							intTtlSiverSeats=rset.getInt("TTLSILVERSEATS"),
									intGoldAvailSeats=rset.getInt("GOLDAVAILSEATS"),
											intSilverAvailseats=rset.getInt("SILVERAVAILSEATS");

//ID                NOT NULL NUMBER(10)    
//MOVIEID                    NUMBER(8)     
//TTLGOLDSEATS               NUMBER(8)     
//TTLSILVERSEATS             NUMBER(8)     
//GOLDSEATSBOOKED            VARCHAR2(300) 
//SILVERSEATSBOOKED          VARCHAR2(300) 
//DATEOFSHOW                 DATE          
//GOLDAVAILSEATS             NUMBER(8)     
//SILVERAVAILSEATS           NUMBER(8)     
//SLOTOFSHOW                 VARCHAR2(10) 

					String strSlotOfShow=rset.getString("SLOTOFSHOW"),strGoldSeatsbooked=rset.getString("GOLDSEATSBOOKED"),
							strSilverSeatsBooked=rset.getString("SILVERSEATSBOOKED");
					Date dateOfShow=rset.getDate("dateofshow");
					
					objTblSeatsBooked=new ClsSeatsBooked(id, intMovieId, intTtlGoldSeats, intTtlSiverSeats, intGoldAvailSeats, intSilverAvailseats, strDateOfshow, strGoldSeatsbooked, strSilverSeatsBooked);
				System.out.println("inside getseatsbookedbyidandtimeandDateOfShowSql "+objTblSeatsBooked);
				
				
				
//					int id=rset.getInt("id"),movieid=rset.getInt("movieid"),ttlGoldSeats=rset.getInt("TTLGOLDSEATS"),
//							ttlSilverSeats=rset.getInt("TTLSILVERSEATS"),goldAvailseats=rset.getInt("GOLDAVAILSEATS"),
//					silverAvailSeats=rset.getInt("SILVERAVAILSEATS");
//					String strSlotOfShow=rset.getString("SLOTOFSHOW"),strGoldSeatsBooked=rset.getString("GOLDSEATBOOKED"),
//							strSilverSeatsBooked=rset.getString("SILVERSEATBOOKED");
//					Date dateOfShow=rset.getDate("dateofshow");
//				
					
					//objTblSeatsBooked=new ClsTblSeatBooked(id, movieid, ttlGoldSeats, ttlSilverSeats, goldAvailseats, silverAvailSeats, strSlotOfShow, strGoldSeatsBooked, strSilverSeatsBooked, dateOfShow);
					
				System.out.println("inside getseatsbookedbyidandtimeandDateOfShowSql "+objTblSeatsBooked);
					
				}
				else
				{
					//JOptionPane.showMessageDialog(null,"no record found");
				}
				con.close();//to close tht connection'
			
				stmt.close();//to close tht statement
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		return objTblSeatsBooked;
			

			
		}
//		public int getMaxId(String strTblNm,String strcolnM)
//		{
//			int maxId=0;
//			Connection con=getDbCon();
//			
//			try {
//				//select to_date('22-Feb-81') - to_date('20-Feb-81')  as res from dual;
//				//int d =rset.getInt("res");
//				PreparedStatement stmt=con.prepareStatement("select max("+strcolnM+")as id from "+strTblNm);
//				ResultSet rset=stmt.executeQuery();
//				if(rset.next())
//				{
//					maxId=rset.getInt("id");
//				}
//				else
//				{
//					maxId=0;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			  maxId+=1;
//			return maxId;
//		}

//		desc tblseatbooked
//		Name             Null Type          
//		---------------- ---- ------------- 
//		ID                    NUMBER(10)    
//		MOVIEID               NUMBER(8)     
//		TTLGOLDSEATS          NUMBER(8)     
//		TTLSILVERSEATS        NUMBER(8)     
//		GOLDSEATBOOKED        VARCHAR2(300) 
//		SILVERSEATBOOKED      VARCHAR2(300) 
//		DATEOFSHOW            VARCHAR2(50)  
//		GOLDAVAILSEATS        NUMBER(8)     
//		SILVERAVAILSEATS      NUMBER(8)     
//		SLOTOFSHOW            VARCHAR2(10)  
		
		
		
		
}
