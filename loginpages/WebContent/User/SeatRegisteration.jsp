<!-- movieid - session mai hai 
session.setAttribute("ssnmid", intMovieId); 
User/SeatRegisteration.jsp?selctedDate=28-NOV-2020&selectedSlot=slot912
	session.setAttribute("ssnGoldPrice", dblGoldPrice);
		session.setAttribute("ssnSilverPrice", dblSilverPrice);

-->

<%@page import="util.CommonFunctions"%>
<%@page import="model.ClsSeatsBooked"%>
<%@page import="icsd.DBHandle"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>

<%@page import="java.util.LinkedList"%>
<%@include file="Header.jsp" %>
<title>Seat Registration</title>
 <!-- <link rel="stylesheet" href="css/style.css" /> --> 
<script>

var TtlSilverSeatsSelectedValue=0;//total silver ticket price =0 
//"calculateSilverTicketPrice(this.id,this,this.value)"//S20/htmlcode check //20
function calculateSilverTicketPrice(id,obj,value) 
{
	//value - seat no silver seat no - 3
	//alert("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log(obj);//<input onclick="calculateSilverTicketPrice(this.id,this,this.value)" type="checkbox" name="SilverSeatCheckBox" style="background-color: green" id="S7" value="7">
	
	
	
  var checkBox = document.getElementById(id);
  var silverTktPriceId = document.getElementById("intSilverPrice");//250
  var silverTktPrice=silverTktPriceId.value;//250rs 
//  alert("silverTktPrice= "+ silverTktPrice);
//alert(checkBox.checked+" icsd is checked ");
 if( checkBox.checked == true)
	 {
	 
	 TtlSilverSeatsSelectedValue=Number(TtlSilverSeatsSelectedValue)+Number(silverTktPrice);
	 //alert("checked TtlSilverSeatsSelectedValue"+ TtlSilverSeatsSelectedValue);
	 }
 if( checkBox.checked == false)
	 {
	 
  	TtlSilverSeatsSelectedValue=Number(TtlSilverSeatsSelectedValue)-Number(silverTktPrice);
  	//alert("now unchecked TtlSilverSeatsSelectedValue"+ TtlSilverSeatsSelectedValue);
	 }
  //document.getElementById("checkBox").disabled= true;
//  checkBox.disabled=true;
  
  var SilverPrice = document.getElementById("SilverPrice");//this is id of paragraph on page.-SilverPrice
  if (checkBox.checked == true){
	  //<p>hello icsd --innerhtml</p>
	  SilverPrice.style.display = "block";
	  SilverPrice.innerHTML="total Silver Ticket Price is "+TtlSilverSeatsSelectedValue+" Rs.";
	  document.getElementById("txtTtlSilverPrice").value=TtlSilverSeatsSelectedValue;
  } else {
	  document.getElementById("txtTtlSilverPrice").value=TtlSilverSeatsSelectedValue;
	  SilverPrice.style.display = "none";
  }
}
</script>


<script>
var TtlGoldSeatsSelectedValue=0;
function calculateGoldTicketPrice(id,obj,value) {
	//alert("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log("checkbox selected is : "+id+ " "+ obj+"  value= "+ value);
	console.log(obj);
	
	
	
  var checkBox = document.getElementById(id);
  var goldTktPriceId = document.getElementById("intGoldPrice");
  var goldTktPrice=goldTktPriceId.value;
//  alert("silverTktPrice= "+ silverTktPrice);
   if( checkBox.checked == true)
	 {
	 
	 TtlGoldSeatsSelectedValue=Number(TtlGoldSeatsSelectedValue)+Number(goldTktPrice);
	 //alert("checked TtlGoldSeatsSelectedValue"+ TtlGoldSeatsSelectedValue);
	 }
 if( checkBox.checked == false)
	 {
	 
	 TtlGoldSeatsSelectedValue=Number(TtlGoldSeatsSelectedValue)-Number(goldTktPrice);
  //	alert("now unchecked TtlGoldSeatsSelectedValue"+ TtlGoldSeatsSelectedValue);
	 }
  //document.getElementById("checkBox").disabled= true;
 // checkBox.disabled=true;
  
  var GoldPrice = document.getElementById("GoldPrice");
  if (checkBox.checked == true){
	  GoldPrice.style.display = "block";
	  GoldPrice.innerHTML="total Gold Ticket Price is "+TtlGoldSeatsSelectedValue+" Rs.";
	  document.getElementById("txtTtlGoldPrice").value=TtlGoldSeatsSelectedValue;
  } else {
	  document.getElementById("txtTtlGoldPrice").value=TtlGoldSeatsSelectedValue;
	  GoldPrice.style.display = "none";
  }
}
</script>

</head>
<body >
  <%                                                                             
       
      String strMid= session.getAttribute("ssnmid").toString();//16
        double dblGoldPrice=Double.parseDouble(session.getAttribute("ssnGoldPrice").toString());
		double dblSilverPrice= Double.parseDouble(session.getAttribute("ssnSilverPrice").toString());
	//	int intGoldPrice=500;
		//int intSilverPrice= 250;
		
		System.out.println("intGoldPrice " +dblGoldPrice);//500
		System.out.println("intSilverPrice " + dblSilverPrice);//250
       
       // String strMid="17"; 
   int mid=Integer.parseInt(strMid);//16
   	String strSlotChoosen=request.getParameter("selectedSlot"),strDateOfShow=request.getParameter("selctedDate");
 //  	String strSlotChoosen="slot1912",strDateOfShow="28-NOV-2020";
 
 //=============================================================
   	//                     inside select seat .jsp   --- mid = 17  date of show 21-APR-2020  slot= 1215    
   	///////////////////////inside select seat .jsp   --- mid = 17  date of show 27-NOV-2020  slot= slot912
       System.out.println("inside select seat .jsp   --- mid = "+ mid +"  date of show "+ strDateOfShow+"  slot= "+strSlotChoosen);
       DBHandle objDBA=new DBHandle();
       System.out.println("seatregisteraiton -  1");
       
       SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
       java.util.Date date = sdf1.parse(strDateOfShow);
       java.sql.Date dt = new java.sql.Date(date.getTime()); //converting date from java to sqldate.
       //Date dt= Date.valueOf(strDateOfShow);
       //Date dt= Date.valueOf("17-APR-20");
       System.out.println("seatregisteraiton -  2");
       System.out.println("seatregisteraiton -  ");
       
       //=========================================================
  ClsSeatsBooked objClsTblSeatBooked=objDBA.getseatsbookedbyidandtimeandDateOfShowSql(strMid, strSlotChoosen, dt);
//objClsTblSeatBooked [id=1, movieid=16, ttlGoldSeats=50, ttlSilverSeats=50, goldAvailseats=50, 
//silverAvailSeats=50, strSlotOfShow=912, strGoldSeatsBooked=31,2,3,4,5,17,18, 
//strSilverSeatsBooked=1,2,8,9,10,6,7, dateOfShow=2020-11-28]
       int intTtlGoldSeats=objClsTblSeatBooked.getIntTtlGoldSeats(),
    		   ttlSilverSeats=objClsTblSeatBooked.getIntTtlSiverSeats();//gs= 50 ,ss= 50
   //******************************************************   
       
       String SILVERSEATBOOKED=objClsTblSeatBooked.getStrSilverSeatsBooked(),//"1,2,8,9,10,6,7,"
       GOLDSEATBOOKED=objClsTblSeatBooked.getStrGoldSeatsbooked();//"31,2,3,4,5,17,18,"       
       System.out.println("silver"+SILVERSEATBOOKED);
    //String s ="hello,icsd,hi,how";
      //arr[]=s.split(',');
    		   
    		   
       String occupiedSilverSeats[]=SILVERSEATBOOKED.split(",");
       String occupiedGoldSeats[]=GOLDSEATBOOKED.split(",");//String occupiedSilverSeats[]={"1","2","8","9","10","6","7"};
     //******************************************************
     //"10"+"20"= 1020
     //10+20 = 30
       int intoccupiedSilverSeats[]=CommonFunctions.stringArrToIntArray(occupiedSilverSeats);
     //int intoccupiedSilverSeats[]={1,2,8,9,10,6,7};
     //String array converted into int array 
       int intoccupiedGoldSeats[]=CommonFunctions.stringArrToIntArray(occupiedGoldSeats);//{31,2,3,4,5,17,18}
      //***************************************************** 
       
       for(String str:occupiedGoldSeats)
       {
    	   System.out.println(str);
       }
       System.out.println("--gold seats up ------silver seats down---------");
       for(String str:occupiedSilverSeats)
       {
    	   System.out.println(str);
       }
     
       %>
       
	<div class="jumbotron text-center bg-dark form-control ">
			<h4 class="text-warning">Book My Show</h4>
		
	</div> 

	 <%@include file="navbar.jsp" %>	 



	<%--  <%@include file="selcetSeat.jsp" %> 	 --%>
	
    <div class="container ">
      <div class="screen"> </div>
      <h4 class="display-4 small text-center">SCREEN</h4>
    
     <h4 class="text-center"  style="margin-top:77px">SILVER Seats</h4>
     <p id="SilverPrice" style="display:none">Checkbox is CHECKED!</p>
     <p id="GoldPrice" style="display:none">Checkbox is CHECKED!</p>
    total Silver Price is :  <input type="text"   id="txtTtlSilverPrice" name="txtTtlSilverPrice">
    total Gold Price is :  <input type="text"   id="txtTtlGoldPrice" name="txtTtlGoldPrice">
    
	<!-- Checkbox: <input type="checkbox" id="myCheck" value="1" onclick="calculateSilverTicketPrice(this.id,this,this.value)"> -->
	<a href="SeatRegisteration.jsp?selctedDate=<%=strDateOfShow%>&selectedSlot=<%=strSlotChoosen%>" class="btn btn-warning">Reset Ticket Booking</a>
     <div class="row ">
     		
     </div>
     
     
       <form action="BookSeat" method="get">
         
         		
				      
					<div class="row">
					<%
					//Seats already booked - intoccupiedSilverSeats
					////{1,2,8,9,10,6,7};
		 	      		for(int isilverSeats=1 ;isilverSeats<=ttlSilverSeats;isilverSeats++)//1- 50
			    	 	{		 	      			
		 	      		System.out.println(isilverSeats+" isilverseats ");
			 	      		int notobematched=isilverSeats;				 	   		
				 	   		//intoccupiedSilverSeats[]={1,2};
				 	   			if(CommonFunctions.isIntInsideArray(intoccupiedSilverSeats, notobematched))
				 	   			{
				 	   				//yelllow checkbox 
				 	   			%>
				 	   			<!--<input type="checkbox" checked="" disabled="" name="SilverSeatCheckBox" style="background-color: red" id="S1" value="1"> -->
				 &nbsp;&nbsp;<p class="bg-warning">S<%=isilverSeats%></p>
				                    <input  type="checkbox" checked disabled name="SilverSeatCheckBox" style="background-color: red" id="S<%=isilverSeats%>" value="<%=isilverSeats%>">				 	   		
				 	   		<%
				 	   		} else {
				 	   			//green checkbox
				 	   			//onclick="calculateSilverTicketPrice(this.id,this,this.value)"//S20/htmlcode check //20
				 	   			%>
				 	   			
&nbsp;&nbsp;<p class="bg-success">S<%=isilverSeats%></p><input  onclick="calculateSilverTicketPrice(this.id,this,this.value)" 
type="checkbox"  name="SilverSeatCheckBox" style="background-color: green" id="S<%=isilverSeats%>" value="<%=isilverSeats%>">	
				 	   			<%
				 	   		}		 	      		
		 	      			if(isilverSeats%10==0)
		 	      			{
		 	      				%>	  </div>
		 	      					   <div class="row">
		 	      			<%
		 	      			}
		 	      			%>
			 			<%-- <input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>"> --%>
						  <%
				 	     }%>		
						</div>
						<div class="row" style="height:100px;">
						</div>
								<div class="row">
					<%					
		 	      		for(int igoldSeats=1 ;igoldSeats<=intTtlGoldSeats;igoldSeats++)
			    	 	{
		 	      		System.out.println(igoldSeats+" igoldSeats ");
		 	      		int notobematched=igoldSeats;
		 	   			if(CommonFunctions.isIntInsideArray(intoccupiedGoldSeats, notobematched))
	 	   				{
		 	      		%>		 	      		
		 	      		&nbsp;&nbsp;<p class="bg-warning">G<%=igoldSeats%></p> <input  type="checkbox" checked disabled name="GoldSeatCheckBox" class="seat" id="G<%=igoldSeats%>" value="<%=igoldSeats%>"> 
		 	      		<%
	 	   				}
		 	   			else
		 	   			{
		 	   				%>
&nbsp;&nbsp;<p class="bg-success">G<%=igoldSeats%></p> <input  type="checkbox" onclick="calculateGoldTicketPrice(this.id,this,this.value)"  name="GoldSeatCheckBox" class="seat" id="G<%=igoldSeats%>" value="<%=igoldSeats%>">
		 	   				<%
		 	   			}
		 	      			if(igoldSeats%10==0)
		 	      			{
		 	      				%>		 	      			
		 	      					   </div>
		 	      					   <div class="row">
		 	      			<%
		 	      			}
		 	      			%>
			 			       	<%-- <input  type="checkbox"  disabled name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="S<%=s%>"> --%>
						  <%	
						 	
				 	     }%>		
						</div>
						<div class="row">
							<div class="col-md-12">
							<input type="hidden" value="<%=dblGoldPrice%>" id="intGoldPrice" name="intGoldPrice">
							<input type="hidden" value="<%=dblSilverPrice%>" id="intSilverPrice" name="intSilverPrice">
							<input type="hidden" value="<%=strSlotChoosen%>" name="selectedSlot">
							<input type="hidden" value="<%=strDateOfShow%>" name="selctedDate">
							
							
							<input type="submit" value="Book Seats" id="btnBook" class="btn btn-success"/>
							</div>
						</div>
						   	<%-- <%if(found!=1){%>
									<input  type="checkbox" name="SilverSeatCheckBox" class="seat" id="<%=s%>" value="<%=s%>">
							<%} %>  --%>

					   <%-- <%found=0;}%> --%>
      					
      	
		
       </form>
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       ---------------------------------
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       
  

 

   
	
	
	


<%@include file="Footer.jsp"%>
</body>