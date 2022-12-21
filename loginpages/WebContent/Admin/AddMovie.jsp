<%@page import="icsd.DBHandle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="AdminHeader.jsp"%>
<!-- link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!-- desc tblmovies;
MOVIEID           NUMBER(5)    
MOVIENAME         VARCHAR2(20) 
STARS             VARCHAR2(5)  
STARTDATE         DATE         
ENDDATE           DATE         
SLOT912           VARCHAR2(10) 
SLOT1215          VARCHAR2(10) 
SLOT1518          VARCHAR2(10) 
SLOT1821          VARCHAR2(10) 
GOLDPRICE         NUMBER(3)    
SILVERPRICE       NUMBER(3)    
IMAGENAME         VARCHAR2(20) 
LANGUAGE          VARCHAR2(20) -->

<%
         DBHandle objDH=new DBHandle();

		 int movieId=objDH.getMaxId("tblMovies", "movieid");
		 movieId++;
%>
<div class="container">
            <form class="form-horizontal" action="../AddMovie" method="get" role="form">
                <h2>Add Movie Form</h2>
                 <div class="form-group">
                    <label for="movieId" class="col-sm-3 control-label">Movie id</label>
                    <div class="col-sm-9">
                        <input type="number" id="txtMid" placeholder="Movie id" name="txtMid" class="form-control" value="<%=movieId%>" readonly autofocus>
                        <span class="help-block">it is auto generated </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="movieName" class="col-sm-3 control-label">Movie Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="txtMovieName" name="txtMovieName" placeholder="Movie Name" class="form-control" autofocus>
                        <span class="help-block">Movie Name , eg.: Mission Impossible </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="stars" class="col-sm-3 control-label">Stars</label>
                    <div class="col-sm-9">
                        <select id="ddlStars" name="ddlStars" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            
                        </select>
                    </div>
                </div>
                  <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Start Date</label>
                    <div class="col-sm-9">
                        <input type="date" id="startDate" name="startDate" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">End Date</label>
                    <div class="col-sm-9">
                        <input type="date" id="endDate" name="endDate" class="form-control">
                    </div>
                </div>
                
                   <div class="form-group">
                    <label class="control-label col-sm-3">Slot Available</label>
                    <div class="col-sm-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="slot912" name="slot" value="slot912">9-12
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                 <input type="checkbox" id="slot1215" name="slot" value="slot1215">12-15
                            </label>
                        </div>
                    </div>
                      <div class="col-sm-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="slot1518" name="slot" value="slot1518">15-18
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                 <input type="checkbox" id="slot1821" name="slot" value="slot1821">18-21
                            </label>
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="goldPrice" class="col-sm-3 control-label">Gold Ticket Price in rs</label>
                    <div class="col-sm-9">
                        <input type="number" id="txtGoldPrice" name="txtGoldPrice" placeholder="Gold Ticket Price" class="form-control" autofocus>
                        <span class="help-block">Gold ticket price : ex 500 </span>
                    </div>
                </div>
               <div class="form-group">
                    <label for="goldPrice" class="col-sm-3 control-label">Silver Ticket Price in rs</label>
                    <div class="col-sm-9">
                        <input type="number" id="txtSilverPrice" name="txtSilverPrice" placeholder="Silver Ticket Price"  class="form-control" autofocus>
                        <span class="help-block">Silver ticket price : ex 500 </span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="movieName" class="col-sm-3 control-label">Language </label>
                    <div class="col-sm-9">
                        <input type="text" id="txtLanguage" name="txtLanguage" placeholder="language" class="form-control" autofocus>
                        <span class="help-block">English,Punjabi</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="movieName" class="col-sm-3 control-label">Image Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="txtImageName" name="txtImageName" placeholder="image Name" class="form-control" autofocus>
                        <span class="help-block">a1.jpg </span>
                    </div>
                </div>
                
                
                
              
            <!--     <div class="form-group">
                    <label class="control-label col-sm-3">Gender</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="femaleRadio" value="Female">Female
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="maleRadio" value="Male">Male
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" id="uncknownRadio" value="Unknown">Unknown
                                </label>
                            </div>
                        </div>
                    </div>
                </div>  -->
              <!-- 
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">I accept <a href="#">terms</a>
                            </label>
                        </div>
                    </div>
                </div> --> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">add movie</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
<%@include file="AdminFooter.jsp" %>