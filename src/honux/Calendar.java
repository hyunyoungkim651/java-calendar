package honux;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEEP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEKDAY = {"SU", "MO", "Tu", "WE", "TH", "FR", "SA"};

    private HashMap<Date, String> planMap;

    public Calendar() {
        planMap = new HashMap<Date, String>();
    }


    /**
     *
     * @param strdate ex : "2017-06-20"
     * @param plan
     */
    public void registerPlan(String strdate, String plan) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strdate);
        planMap.put(date1, plan);
    }

    public String searchPlan(String strDate) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        String plan = planMap.get(date1);
        return plan;
    }

    private int getWeekDay(int year, int month, int day) {
        // 기준 년도
        int syear = 1970;
        final int STANDARD_WEEKDAY = 4; // 1970/1/1 = Thursday

        int count = 0;

        for (int i = syear; i < year; i++) {
            int delta = isLeepYear(i) ? 366 : 365;
            count += delta;
        }

        for (int i = 1; i < month; i++) {
            int delta = getMaxDaysOfMonth(year, i);
            count += delta;
        }

        // 1월 1일은 더해줄 필요 없다.
        count += day - 1;

        int weekday = (count + STANDARD_WEEKDAY) % 7;

        return weekday;
    }

    public boolean isLeepYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeepYear(year)) {
            return LEEP_MAX_DAYS[month];
        }
        else{
            return MAX_DAYS[month];
        }
    }

    public void printCalendar(int year, int month) {

        System.out.println(String.format("    <<%4d년 %d월>>", year, month));
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");


        // get weekday automatically
        int weekday = getWeekDay(year, month, 1);

        for (int i = 0; i < weekday; i++) {
            System.out.print("   ");
        }

        int maxDay = MAX_DAYS[month];
        int count = 7 - weekday;
        int delim = (count < 7) ? count : 0;

        // print first line
        for (int i = 1; i <= count; i++) {
            System.out.print(String.format("%3d", i));
        }

        System.out.println();

        // print second line
        count++;
        for (int i = count; i <= maxDay; i++) {
            System.out.print(String.format("%3d", i));
            if (i % 7 == delim) {
                System.out.println();
            }
        }
        System.out.println();

//        System.out.println("1   2   3   4   5   6   7");
//        System.out.println("8   9   10  11  12  13  14");
//        System.out.println("15  16  17  18  19  20  21");
//        System.out.println("22  23  24  25  26  27  28");
    }

    public static void main(String[] args) throws ParseException {
        Calendar cal = new Calendar();
        cal.registerPlan("2017-06-23", "Let's eat beef!");
        System.out.println(cal.searchPlan("2017-06-23").equals("Let's eat beef!"));
    }
}
