package honux;

import java.util.Scanner;

public class Prompt {

    private final static String PROMPT = "cal> ";

    /*
        @param week 요일명
        @return 0 ~ 6 (0 = Sunday, 1 = Saturday)
     */
    public int parseDay(String week) {
//        if (week.equals("su")) return 0;
//        else if (week.equals("mo")) return 1;
//        else if (week.equals("tu")) return 2;
//        else if (week.equals("we")) return 3;
//        else if (week.equals("th")) return 4;
//        else if (week.equals("fr")) return 5;
//        else if (week.equals("sa")) return 6;
//        else return 0;
        int week_num = 0;

        switch (week){
            case "su":
                week_num = 0;
                break;
            case "mo":
                week_num = 1;
                break;
            case "tu":
                week_num = 2;
                break;
            case "we":
                week_num = 3;
                break;
            case "th":
                week_num = 4;
                break;
            case "fr":
                week_num = 5;
                break;
            case "sa":
                week_num = 6;
                break;
            default:
                System.out.println("잘못 입력 ");
        }
        return week_num;
    }

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            System.out.println("년도를 입력하시오.(exit : -1)");
            System.out.print("YEAR> ");
            int year = sc.nextInt();
            if (year == -1) {
                break;
            }
            System.out.println("달을 입력하시오.");
            System.out.print("MONTH> ");
            int month = sc.nextInt();
            System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
            System.out.println("WEEKDAY> ");
            String str_weekday = sc.next();
            int weekday = parseDay(str_weekday);
            System.out.println(weekday);
            if (month > 12 || month < 1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            cal.printCalendar(year, month, weekday);
        }

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();

    }
}
