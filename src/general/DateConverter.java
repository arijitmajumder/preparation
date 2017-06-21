package general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateConverter 
{

	public static void main(String[] args) throws ParseException {
		String dateStr = "Mon Jun 18 00:00:00 IST 2012";
		String date1 = "Mon Feb 20 2017 05:30:00 GMT+0530 (India Standard Time)";
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat formatter1 = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
		Date date = (Date)formatter.parse(dateStr);
		//System.out.println(date);        

		Date date2 = (Date)formatter1.parse(date1);
		System.out.println("SAGAR "+date2);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
		System.out.println("formatedDate : " + formatedDate);    
	}
}
