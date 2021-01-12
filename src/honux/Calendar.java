package honux;

import java.util.Scanner;


public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 31, 30, 30, 31, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void printCalendar() {
        System.out.println("일  월  화  수  목  금  토");
        System.out.println("--------------------");
        System.out.println("1   2   3   4   5   6   7");
        System.out.println("8   9   10  11  12  13  14");
        System.out.println("15  16  17  18  19  20  21");
        System.out.println("22  23  24  25  26  27  28");
    }

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();

        System.out.println("반복 횟수를 입력하시오.");
        int repeat = sc.nextInt();

        for (int i = 0 ; i < repeat; i++){
            System.out.println("달을 입력하시오.");
            int month = sc.nextInt();
            System.out.println(month + "월은 " + cal.getMaxDaysOfMonth(month) + "일까지 있습니다.");
        }

        System.out.println("Bye~");
        cal.printCalendar();
    }
}
