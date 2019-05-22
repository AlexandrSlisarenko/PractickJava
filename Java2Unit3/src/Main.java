import TestRassword.TestPassword;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println("Введите пароль:");
        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        System.out.println("Введите ограничение по длинне:");
        int l = sc.nextInt();
        TestPassword testP = new TestPassword(l,pass);
        if(testP.test())System.out.println("Можно воспользоваться данным поролем для защиты вашего аккаунта!");
        else System.out.println("Пожалуйста, измените пароль согласно требований(цыфры и буквы латинского алфавита)!");
        System.out.println("Hello World!");
    }
}
