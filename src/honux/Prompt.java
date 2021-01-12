package honux;

import java.util.Scanner;

public class Prompt {

    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();


        while (true) {
            System.out.println("달을 입력하시오.");
            System.out.print(PROMPT);
            int month = sc.nextInt();
            if (month == -1) {
                break;
            } else if (month > 12) {
                continue;
            }
            cal.printCalendar(2021, month);
        }

        System.out.println("Bye~");
    }

    public static void main(String[] args) {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();

    }
}
