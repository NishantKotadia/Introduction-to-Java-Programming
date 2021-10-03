package Exercise05;
import java.util.Scanner;
/**
 *
 * @author Nishant Kotadia 20CS029
 * @Email: 20cs029@charusat.edu.in
 * (Print calendar) Programming Exercise 3.21 uses Zeller’s congruence to 
 * calculate the day of the week. Simplify Listing 5.12, PrintCalendar.java, 
 * using Zeller’s algorithm to get the start day of the month.
 * 
 */
public class Exercise05_34 {
    

public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// get year from user
		System.out.print("Enter year : ");
		int year = keyboard.nextInt();
                
                //validate year input
		while (!isValidYear(year)) {				
			System.out.println("Invalid Year");
			System.out.print("Enter year : ");
			year = keyboard.nextInt();
		}
		
		// get month from user
		System.out.print("Enter month : ");
		int month = keyboard.nextInt();
                
                //validate month input
		while (!isValidMonth(month)) {			
			System.out.println("Invalid Month!");
			System.out.print("Enter month : ");
			month = keyboard.nextInt();
		}
		
		// print the calendar header
		monthAndYear(month, year);	

                // print the calendar first day
		firstDay(month, year);			

                // print the calendar itself
		calendar(month, year);
	}
        
        //For enter year above 0
	public static boolean isValidYear(int year) {
		return year > 0;		
	}

        //For input month between 1 to 12
	public static boolean isValidMonth(int month) {
		return month > 0  &&  month <= 12;
	}

	public static void monthAndYear(int month, int year) {
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

                //Print Month name on top
		System.out.print("\t"+months[month-1]+"\t");		
		System.out.println(year);
		
		//Print name of week day
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
	}

	public static void firstDay(int month, int year) {
		
            //For calculate 1st day
            int firstDay = dayOfWeek(1, month, year);
                
                //1 for first day
		String a = "1";		

                //If first day is between 2 to 6 than add tab 
                //If first day is 1 than 0 tab, 2 than 1 tab, and so on 
		for(int i = 1; i<firstDay; i++){
			a = "\t" + a;
		}
                //This is for reset and if it's is 0 than put 6 tabs for specific case
		if(firstDay == 0){			
			a = "\t\t\t\t\t\t1";
		}
		System.out.print(a + "\t");
	}

	public static void calendar(int month, int year) {
            
		// find out the last day of that month
		int lastDayOfMonth = lastDayOfMonth(month, year);

		// print the calendar
		for (int i = 2; i <= lastDayOfMonth; i++) {
			int printedDay = dayOfWeek(i, month, year);
			if (printedDay == 1) {
				System.out.println();
			}
			System.out.print(i + "\t");
		}
	}
	
	//Put Zeller's Algorithm
	public static int dayOfWeek(int dayOfMonth, int month, int year) {
		if (month == 1 || month == 2) {
			month = month + 12;
			year--;
		}
		int q, m, j, k;
		q = dayOfMonth;
		//for month
                m = month;
                //For find century
		j = year/100;
                //find which year in upper century
		k = year%100;
		int dayOfTheWeek = (q + (26*(m+1) /10) + k + k/4 + j/4 + (5*j)) % 7;		
		return dayOfTheWeek;
	}

	public static boolean leapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	public static int lastDayOfMonth(int month, int year) {
		int lastDayOfMonth;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			lastDayOfMonth = 31;
		} else if (month == 2) {
			if (leapYear(year)) {
				lastDayOfMonth = 29;
			} else {
				lastDayOfMonth = 28;
			}
		} else {
			lastDayOfMonth = 30;
		}
		return lastDayOfMonth;
	}
	
}