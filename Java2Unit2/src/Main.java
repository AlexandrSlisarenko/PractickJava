import Exception.*;
import Enum.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inC = new Scanner(System.in);
       /* try {

            System.out.print("Введите длинну массива: ");
            int i = inC.nextInt();
            System.out.print("Введите высоту массива: ");
            int j = inC.nextInt();
            ArrayString arr = new ArrayString(i,j);
            arr.fillingMassiv();
            System.out.println(arr.summElement());
        } catch (ParamArrayException e) {
            e.printStackTrace();
        }
*/
        WorkToEnum wte = new WorkToEnum();
        System.out.print("Введите номер для: ");
        try {
            System.out.print(wte.getCountHours(wte.getDay(inC.nextInt() -1)));
        }
        catch (NoSuchDay e){
            e.printStackTrace();
        }


    }
}
