package honux;



public class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEKDAY = {"SU", "MO", "WE", "TH", "FR", "SA"};

    private int getWeekDay(int year, int month, int day) {
        // 기준 년도
        int syear = 1970;
        final int STANDARD_WEEKDAY = 3; // 1970/1/1 = Thursday

        int count = 0;
        for (int i = syear; i < year; i++) {
            int delta = (MAX_DAYS[2] == 29) ? 366 : 365;
            count += delta;
        }

        for (int i = 1; i < month; i++) {
            int delta = MAX_DAYS[month];
            count += delta;
        }

        count += day - 1;

        int weekday = (count + STANDARD_WEEKDAY) % 7;

        return weekday;
    }

    public void isLeepYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            MAX_DAYS[2] = 29;
        }
    }

    public void printCalendar(int year, int month) {

        System.out.println(String.format("    <<%4d년 %d월>>", year, month));
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        isLeepYear(year);
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

        System.out.println("");

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
}
