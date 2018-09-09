import java.util.Scanner;

public class MyClass {
    public static void main(String args[]){
        System.out.println("Hello World!!!");
        float volume;
        float radius = 2.0f , height = 10.0f;
        volume = 3.1416f * radius * radius * height;
        System.out.println("Объем цилиндра равен "+ volume+"m2");

        selectorTask();


    }

    public static void selectorTask(){
        Scanner insertInput = new Scanner(System.in);
        System.out.println("Введите номер задание");
        String numberTask = insertInput.nextLine();
        int operand1;
        int operand2;
        String operand3;
        switch (numberTask){
            case "1":
                task();
                selectorTask();
                break;
            case "2":
                System.out.println("Введите значение переменной a типа int");
                int a = insertInput.nextInt();
                System.out.println("Введите значение переменной b типа int");
                int b = insertInput.nextInt();
                System.out.println("Введите значение переменной c типа int");
                int c = insertInput.nextInt();
                System.out.println("Введите значение переменной d типа int");
                int d = insertInput.nextInt();
                int res = task(a,b,c,d);
                System.out.println("Итог выражения a*(b+(c/d))="+res);
                selectorTask();
                break;
            case "3":
                System.out.println("Введите значение переменной operand1 типа int");
                operand1 = insertInput.nextInt();
                System.out.println("Введите значение переменной operand2 типа int");
                operand2 = insertInput.nextInt();
                System.out.println("Результат = "+task(operand1,operand2));
                selectorTask();
                break;
            case "4":
                System.out.println("Введите значение переменной operand1 типа int");
                operand1 = insertInput.nextInt();
                System.out.println("Результат = "+task(operand1));
                selectorTask();
                break;
            case "5":
                System.out.println("Введите имя");
                operand3 = insertInput.nextLine();
                System.out.println(task(operand3));
                selectorTask();
                break;
            case "6":
                System.out.println("Введите год");
                long year = insertInput.nextLong();
                System.out.println(task(year));
                selectorTask();
                break;
            default:
                    System.out.println("Такого номер нет");
                    insertInput.close();
        }

    }


    public static void task(){
        byte b = 10; System.out.println("Переменнная типа byte = "+b);
        short s = 2000; System.out.println("Переменнная типа short = "+s);
        int i  = 25036; System.out.println("Переменнная типа int = "+i);
        long l = 19000L; System.out.println("Переменнная типа long = "+l);
        float f = 123.23f; System.out.println("Переменнная типа float = "+f);
        boolean bool = true; System.out.println("Переменнная типа boolean = "+bool);
        char c = 'X'; System.out.println("Переменнная типа char = "+c);
        String S = "Hello World!!!"; System.out.println("Переменнная типа String = "+S);
    }

    public static int task(int a,int b,int c,int d){
        return a*(b+(c/d));
    }
    public static boolean task(int a, int b){

       return  ((a+b >=10)&&((a+b <=20)))? true : false;

    }
    public static String task(int a){

        return  (a >= 0)? "положительное" : "отрицательное";

    }
    public static String task(String a){

        return  "Привет, " + a + "!";

    }
    public static String task(long year){

        String res;
        if((year % 100 == 0)&&(year % 400 != 0)){
            return  "Год не высокосный!";
        }
        else if((year % 4 == 0)||(year % 400 == 0)){
            return  "Год высокосный!";
        }else{
            return  "Год не высокосный!";
        }

    }

}
