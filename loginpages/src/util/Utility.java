package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Utility {

	
	public static String addOneDayToDate(String strDate)
	{
			String oldDate = strDate;  
			System.out.println("Date before Addition: "+oldDate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   c.setTime(sdf.parse(oldDate));
			}catch(ParseException e){
			   e.printStackTrace();
			 }
			//Incrementing the date by 1 day
			c.add(Calendar.DAY_OF_MONTH, 1);  
			String newDate = sdf.format(c.getTime());  
			//System.out.println("Date Incremented by One: "+newDate);
			return newDate;
	}
	
	
	public String dateInDDMMYYFromDDMMYYYY(String strIpDate)
	{
		
		//strIpDate=dd-mm-yyyy
		//strOpDate=dd-mm-yy
		String strOpDate=null;
		try {
			Date dateIpDate = StringToDate(strIpDate);
			strOpDate=new SimpleDateFormat("dd-MM-yy").format(dateIpDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strOpDate;
		
	}
	
	//dob= dd-MM-yyyy
	   public  Date StringToDate(String dob) throws ParseException {
		      //Instantiating the SimpleDateFormat class
		      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		      //Parsing the given String to Date object
		      Date date = formatter.parse(dob);
		      System.out.println("Date object value: "+date);
		      return date;
		   }
}
