import java.util.*;

public class ComputeAge {

static int iYear = 0;
static int iMonth = 0;
static int iDay = 0;
static Calendar today_Date = Calendar.getInstance();

private static int getYear() {

try {
System.out.println("Enter the year you were born: ");

Scanner s = new Scanner(System.in);

int iYear = s.nextInt();
if (iYear < 1800)
{
System.out.println("Input must be at least 1800");
return 0;	
}
if (iYear > today_Date.get(Calendar.YEAR))
{
System.out.println("Input Year cannot be greater than current year");
return 0;	
}	

return iYear;	
}
catch(Exception ex)
{
System.out.println("Year is not valid");	
return 0;
}

}

public static int getMonth() {

try {
System.out.println("Enter the month you were born (1-12): ");

Scanner s = new Scanner(System.in);

int iMonth = s.nextInt();
if (iMonth < 1 || iMonth > 12)
{
System.out.println("Month must be 1-12");
return 0;	
}

return iMonth;	
}
catch(Exception ex)
{
System.out.println("Month must be 1-12");
return 0;
}

}

public static int getDay() {

try {
System.out.println("Enter the day you were born: ");

Scanner s = new Scanner(System.in);

int iDay = s.nextInt();

if (iDay < 1 || iDay > 31)
{
System.out.println("Day must be 1-31");
return 0;	
}
int numberOfDays = daysInMonth(iMonth, iYear);

if (iDay > numberOfDays)
{
System.out.println("Day is not valid for Month");
return 0;	
}

if(iYear == today_Date.get(Calendar.YEAR))
{ 
        if(iMonth == (today_Date.get(Calendar.MONTH)+1))
        { 
          if(iDay > today_Date.get(Calendar.DAY_OF_MONTH))
          { 
            System.out.println("Date cannot be greater than Today"); 
            return 0; 
          }
        }
        }

return iDay;	
}
catch(Exception ex)
{
System.out.println("Day must be 1-31");	
return 0;
}
}

private static int daysInMonth(int iMth, int iYr) {
    int numberOfDays = 31;
    
switch(iMth){	
case 2: numberOfDays = 28;
if (iYr % 4 == 0){
numberOfDays = 29;
if (iYr % 100 == 0 && iYr % 400 != 0)
numberOfDays = 28;
}
break;
case 4:
case 6:
case 9:
case 11:
numberOfDays = 30;
break;
}
return numberOfDays;
}

private static void getAge(int year, int month, int day)
{
// we add 1 to Calendar Month to get the correct month
int currentMonth = (today_Date.get(Calendar.MONDAY)+1);

// get age (year, month, day)
int iYr = today_Date.get(Calendar.YEAR) - year;
int iMth = (today_Date.get(Calendar.MONTH)+1) - month;
int iDy = (today_Date.get(Calendar.DAY_OF_MONTH) - day);	

if (iMth < 0)
{
iYr--;
iMth = 12 - month + currentMonth;
}
if (iDy < 0)
{
iMth--;
int numberOfDays = daysInMonth(iMonth, iYear);	
iDy += numberOfDays;
}

String sYear = "";
String sMonth = "";
String sDay = "";	

if (iYr < 2)
{
sYear = "year";
}
else
{
sYear = "years";	
}
if (iMth < 2)
{
sMonth = "month";	
}
else
{
sMonth = "months";	
}
if (iDy < 2)
{
sDay = "day";	
}
else
{
sDay = "days";	
}	

        System.out.println("You are " + iYr + " " + sYear + ", " + iMth + " " + sMonth +  ", and " + iDy + " " + sDay + " old");	

}

public static void main(String[] args) {

int iYr = 0;
int iMth = 0;
int iDy = 0;	

do
{
iYr = getYear();

} while (iYr == 0); // loop until Year is valid
iYear = iYr;

do
{
iMth = getMonth();

} while (iMth == 0); // loop until Month is valid
iMonth = iMth;

do
{
iDy = getDay();

} while (iDy == 0); // loop until Day is valid
iDay = iDy;

getAge(iYear, iMonth, iDay);
}
}