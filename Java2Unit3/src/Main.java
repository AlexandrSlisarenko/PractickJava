import DictionaryPhone.WorkToDictionaryPhone;
import TestRassword.TestPassword;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задания:");
        switch (sc.nextInt()){
            case 1:
                System.out.println("Введите пароль:");

                String pass = sc.next();
                System.out.println("Введите ограничение по длинне:");
                int l = sc.nextInt();
                TestPassword testP = new TestPassword(l,pass);
                if(testP.test())System.out.println("Можно воспользоваться данным поролем для защиты вашего аккаунта!");
                else System.out.println("Пожалуйста, измените пароль согласно требований(цыфры и буквы латинского алфавита)!");
                break;
            case 2:
                WorkToDictionaryPhone w = new WorkToDictionaryPhone();
                w.use();
                break;
            case 3:

                System.out.println("Введите строку:");
                Scanner sc1 = new Scanner(System.in);

                    String line = sc1.nextLine();
                sc1.close();
                    System.out.println(line);



                break;

        }

    }
}
