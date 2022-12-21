<%@page import="model.ClsMovie"%>
<%@page import="icsd.DBHandle"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Date"%>


<%@include file="Header.jsp" %>
<title>MOVIE DETAILS</title>
</head>
<body class="bg-dark">
	<div class="jumbotron  bg-dark form-control ">
			<h4 class="muted text-warning">Book My Show</h4>
		
	</div>
	<%@include file="navbar.jsp" %>	
	
	<div class="container" style="margin-top:77px; margin-bottom:700px">
		
	<%
		String strMovieID=request.getParameter("movieid");
	
		DBHandle objDbU= new DBHandle();
		ClsMovie objMovie =new ClsMovie();
		
		objMovie=objDbU.getMovieDetailsByMovieId(Integer.parseInt(strMovieID));//now it has all details of 
		//movieid =9 - ek tha tiger
/* 		int  intMovieId,intGoldPrice,intSilverPrice;
	
	String strMovieName,strMovieStar,strMovieLanguage
			,strSlot912,strSlot1215,strSlot1518,strSlot1821,strMovieImageName;
		
	Date strStartDate,strEndDate; */
		
		
		
		
		
		int  intMovieId;
	double dblGoldPrice,dblSilverPrice;
			
		String strMovieName,strMovieStar,strMovieLanguage
					,strSlot912,strSlot1215,strSlot1518,strSlot1821,strMovieImageName;
				
		String StartDate,EndDate;
			
			
		intMovieId		=	objMovie.getIntMovieId();
		session.setAttribute("ssnmid", intMovieId);
		
		strMovieName	=	objMovie.getStrMovieName();
		strMovieStar	=	objMovie.getStrStars() ;
		strSlot912		=	objMovie.getStrSlot912() ;
		strSlot1215		=	objMovie.getStrSlot1215() ;
		strSlot1518		=	objMovie.getStrSlot1518() ;
		strSlot1821		= 	objMovie.getStrSlot1821();
		dblGoldPrice	= 	objMovie.getDblGoldPrice();
		dblSilverPrice	= 	objMovie.getDblSilverPrice();
		session.setAttribute("ssnGoldPrice", dblGoldPrice);
		session.setAttribute("ssnSilverPrice", dblSilverPrice);
		StartDate		=	objMovie.getStrStartDate();
		EndDate			= 	objMovie.getStrEndDate();
	   strMovieImageName=	objMovie.getStrImgName();
		strMovieLanguage=	objMovie.getStrLanguage();
		
		
		
		System.out.println("**************SLECTED MOVIE DETAIS********************");
		
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
			
		System.out.println("**************ττττ********************");
		
	%>	
	<div class="row align-items-center">
		<div class="col" style="padding:0px 177px">	
					<div class="card" style="margin-bottom: 37px">
					    <img class="card-img-top " src="projectImgs/<%=strMovieImageName%>"style="padding:7px" width="400" height="700" alt="Card image cap">
					    <div class="card-body">
					      <h1 class="card-title text-primary text-center"><%=strMovieName %></h1>
					      <h5 class="card-text">
					      	Rating  	: <%=strMovieStar %> Stars<br>
					       	<%-- Language	: <%=strMovieLanguage %><br> --%>
					       	Cast    	:  A,B,C,D,E<br>
					       	Discription :  description description description description 	
					      </h5>
					    </div>
					    <div class="card-footer">
					      <%-- <small class="text-muted">Last Date <%=EndDate %></small> --%>
					    </div>
					 </div>
	    	</div>
	  </div>
	  
	  
	  <div class="row align-items-center" >
	  	<div class="offset-xl-3 col-xl-5">
	  	
	  		<h3 class="text-warning text-center" style="margin:25px 0px" >
	  			GOLD PRICE		:    <%=dblGoldPrice %><br>		
	  		</h3>
	  		<h3 class=" text-white text-center"style="margin:25px 0px" >
	  			SILVER PRICE	:    <%=dblSilverPrice %>
	  		</h3>
	  	
	  	<%
	  	DBHandle objDHA=new DBHandle();
	  	System.out.println("11111111111111111111111111111111111111111");
	  		LinkedList<String> lstUniqueDate=objDHA.lstGetUniqueDateseatsbookedbyid(strMovieID);
	  		System.out.println("22222222222222222222222222222222222222");	
	  	%>
	  		<form  action="SeatRegisteration.jsp">
	  		
	  			<div class="input-group mb-3" style="margin:25px 0px">
					  <div class="input-group-prepend">
					    <label class="input-group-text" for="selctedDate">Select Date</label>
					  </div>
			  			<select class="custom-select" id="selctedDate" name="selctedDate">
	   				 	<option ></option>
	   				 	<%
	   				 	for(String obj:lstUniqueDate)
	   				 	{
	   				 	%>
					     <option selected  value="<%=obj%>"><%=obj%></option> 
					    <%
					    }
					 %>
		 			</select>
		 			
		  		</div>
		  		
		  		<div class="row align-items-center "style="margin:25px 0px" >
		  			<div class=" col-xl-3">
			  			<h5 class=" text-white text-center" >TIME</h5>
	  				</div>
		  			
		  			<%if(strSlot912.equals("true")){
		  					System.out.println("checking slot 912");
		  			%>
		  					<div class=" col-xl-2 text-center">
		  						<input type="radio" name="selectedSlot" value="slot912">
		  						<h6 class=" text-white text-center  small" >9-12</h6>
		  					</div>
		  			<%  } %>
		  			
		  		 	<%if(strSlot1215.equals("true")){%>
		  		 			<div class=" col-xl-2 text-center">
		  						<input type="radio" name="selectedSlot" value="slot1215">
		  						<h6 class=" text-white text-center  small" >12-15</h6>
		  					</div>
		  			<%  } %>
		  			
		  			<%if(strSlot1518.equals("true")){%>
		  					<div class=" col-xl-2 text-center">
		  						<input type="radio"  name="selectedSlot" value="slot1518">
		  						<h6 class=" text-white text-center  small" >15-18</h6>
		  					</div>
		  			<%  } %>
		  			
		  			<%if(strSlot1821.equals("true")){%>
		  					<div class=" col-xl-2 text-center">
		  						<input type="radio"  name="selectedSlot" value="slot1821">
		  						<h6 class=" text-white text-center  small" >18-21</h6>
		  					</div>
		  			<%  } %> 
		  			
		  		</div>
		  		
		  		<div class="row align-items-center" style="margin:25px 0px">
			  		<div class=" col text-center">
			  			<input class="btn btn-outline-primary text-center" type="submit" value="SELECT SEAT NOW">
			  		</div>	
		  		</div>
		  			
	  		</form>
	  		
	  	</div>
	  </div>
	
		
		
		
		
			
	</div>
	
</body>
<%@include file="Footer.jsp"%>