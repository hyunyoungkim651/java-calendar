package honux;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

    public void printMenu() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+----------------------+");
    }

    /**
     * 1. switch case - String 적용
     * 2. Plan class - refactoring
     *
     */

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
//        else return;

        switch (week) {
            case "mo":
                return 1;
            case "tu":
                return 2;
            case "we":
                return 3;
            case "th":
                return 4;
            case "fr":
                return 5;
            case "sa":
                return 6;
            default:
                return 0;
        }
    }

    public void runPrompt() throws ParseException {
        printMenu();
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();


        boolean isLoop = true;
        while (isLoop) {
            System.out.println("명령 (1, 2, 3, h, q)");
            String cmd = sc.next();
            switch (cmd) {
                case "1":
                    cmdRegister(sc, cal);
                    break;
                case "2":
                    cmdSearch(sc, cal);
                    break;
                case "3":
                    cmdCal(sc, cal);
                    break;
                case "h":
                    printMenu();
                    break;
                case "q":
                    isLoop = false;
                    break;
            }
        }
        System.out.println("Thank you, Bye~");
    }

    private void cmdCal (Scanner s, Calendar c){
        System.out.println("년도를 입력하시오.(exit : -1)");
        System.out.print("YEAR> ");
        int year = s.nextInt();

        System.out.println("달을 입력하시오.");
        System.out.print("MONTH> ");
        int month = s.nextInt();

        if (month > 12 || month < 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        c.printCalendar(year, month);
    }


    private void cmdSearch(Scanner s, Calendar c) {
        System.out.println("[일정 검색]");
        System.out.println("[날짜를 입력해 주세요(yyyy-MM--dd).]");
        String date = s.next();
        String plan = "";
        try {
            plan = c.searchPlan(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("일정 검색 중 오류가 발생했습니다.");
        }
        System.out.println(plan);
    }

    private void cmdRegister(Scanner s,  Calendar c) throws ParseException {
        System.out.println("[새 일정 등록]");
        System.out.println("[날짜를 입력해 주세요(yyyy-MM--dd).]");
        String date = s.next();
        String text = "";
        s.nextLine();
        System.out.println("일정을 입력해 주세요.");
        text = s.nextLine();

        c.registerPlan(date, text);
    }

    public static void main(String[] args) throws ParseException {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();

    }
}
