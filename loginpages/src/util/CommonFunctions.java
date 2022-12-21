package util;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonFunctions 
{
	
	//	//Seats already booked - intoccupiedSilverSeats
	////1,2,5,18,19,20,11,12,13,7,8,10
	public static boolean isIntInsideArray(int arr[],int notobematched )//80
	{
		//intoccupiedSilverSeats[]={1,2,8,9,10};---9
		return IntStream.of(arr).anyMatch(myValue -> myValue == notobematched);
//		Returns whether any elements of this stream match the provided predicate. May not evaluate the 
		//predicate on all elements if not necessary for determining the result. If the stream is empty then 
		//false is returned and the predicate is not evaluated. 
	}
	//String arr[]={"1","2","3"}===> int arr[]={1,2,3};
	//String arr[]={"sachin","rohan","sohan"};
	//
	public  static int[] stringArrToIntArray(String[] arr) {
		try
		{
	    return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
		}
		catch(NumberFormatException nfe)
		{
			int arr1[]= {0};
			return arr1;
		}
	}
}