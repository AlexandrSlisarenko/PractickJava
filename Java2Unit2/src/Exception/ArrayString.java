package Exception;

import java.util.Scanner;

public class ArrayString {
    private String [][] arr;
    private int gorizont;
    private int vertical;

    public ArrayString(int i, int j) throws ParamArrayException{

        if(i < 0 || j < 0 ) throw new ParamArrayException("Параметры массива должы быть больше 0",1);
        this.vertical = i;
        this.gorizont = j;
        this.arr = new String[vertical][gorizont];
    }

    public void fillingMassiv(){
        Scanner inC = new Scanner(System.in);
        for (int i = 0; i < this.vertical; i++) {
            for (int j = 0; j < this.gorizont; j++) {
                System.out.print("Введите число: ");
                this.arr[i][j] = inC.next();
            }
        }

    }


    public void addItem(String str){
        ex:{
            for (int i = 0; i < this.vertical; i++) {
                for (int j = 0; j < this.gorizont; j++) {
                    if(this.arr[i][j] == null){
                        this.arr[i][j] = str;
                        break ex;
                    }
                }
            }
        }
    }

    private void testStr(String str, int i, int j) throws SummException{
        if(!str.matches("^\\d*$"))throw new SummException("Элемент("+i+" "+j+") не является числом",1);
    }

    public int summElement(){
        int res = 0;
        for (int i = 0; i < this.vertical; i++) {
            for (int j = 0; j < this.gorizont; j++) {
                    try {
                       testStr(this.arr[i][j], i,j);
                        res += Integer.parseInt(this.arr[i][j]);
                    }
                    catch (SummException e){
                        e.printStackTrace();
                    }

            }
        }
        return res;
    }

}
