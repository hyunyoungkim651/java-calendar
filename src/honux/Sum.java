package honux;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int num1, num2, result;
        System.out.println("두 수를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        result = num1 + num2;
        System.out.println("두 수의 합은 "+ result +"입니다.");
    }
}
