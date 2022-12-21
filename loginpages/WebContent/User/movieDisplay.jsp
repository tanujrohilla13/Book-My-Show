
<%@page import="model.ClsMovie"%>
<%@page import="icsd.DBHandle"%>
<%@page import="java.sql.Date"%>

<%@page import="java.util.LinkedList"%>

<% 
	DBHandle objDbUser =new DBHandle();
	
	LinkedList<ClsMovie> lst=objDbUser.getLinkListMovie();
	
	session.setAttribute("listmovie", lst);
	
int  intMovieId;
double dblGoldPrice,dblSilverPrice;
	
	String strMovieName,strMovieStar,strMovieLanguage
			,strSlot912,strSlot1215,strSlot1518,strSlot1821,strMovieImageName;
		
	String StartDate,EndDate;
	
	
%>
	<div class="row">
	<%
	
	for(ClsMovie obj:lst)
    {
    	
		intMovieId		=	obj.getIntMovieId();
		strMovieName	=	obj.getStrMovieName();
		strMovieStar	=	obj.getStrStars() ;
		strSlot912		=	obj.getStrSlot912() ;
		strSlot1215		=	obj.getStrSlot1215() ;
		strSlot1518		=	obj.getStrSlot1518() ;
		strSlot1821		= 	obj.getStrSlot1821();
		dblGoldPrice	= 	obj.getDblGoldPrice();
		dblSilverPrice	= 	obj.getDblSilverPrice();
		StartDate		=	obj.getStrStartDate() ;
		EndDate			= 	obj.getStrEndDate();
	   strMovieImageName=	obj.getStrImgName();
		strMovieLanguage=	obj.getStrLanguage();
		
    	System.out.println(intMovieId);
		System.out.println(strMovieName);
		System.out.println(strMovieStar);
		System.out.println(strSlot912);
		System.out.println(strSlot1215);
		System.out.println(strSlot1518);
		System.out.println(strSlot1821);
		System.out.println(dblGoldPrice);
		System.out.println(dblSilverPrice);
		System.out.println(StartDate);
		System.out.println(EndDate);
		System.out.println(strMovieImageName);
		System.out.println(strMovieLanguage);
		
		%>
			<div class="col-xs-7 col-sm-6 col-md-4 col-lg-4 col-xl-3 ">	
			<%--  <a href="SeatRegisteration.jsp?movieid=<%=intMovieId%>"> --%>
			 <a href="MovieDetails.jsp?movieid=<%=intMovieId%>">
				<div class="card" style="margin-bottom: 37px">
				    <img class="card-img-top" src="projectImgs/<%=strMovieImageName%>" height="400" alt="Card image cap">
				    <div class="card-body">
				      <h5 class="card-title"><%=strMovieName %></h5>
				      <p class="card-text">
				       Rating  : <%=strMovieStar %> Stars<br>
				       Language: <%=strMovieLanguage %>
				      </p>
				    </div>
				    <div class="card-footer">
				      <small class="text-muted">Last Date <%=EndDate %></small>
				    </div>
				 </div>
			</a>
    	</div>
    		
   		<% }//foreach loop%>

		
      </div>



