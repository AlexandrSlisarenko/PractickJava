package SantoS.RelayRace.Number_of_vowels;
import java.util.Scanner;
import java.io.*;
public class Reading_from_file {
    public String [] read() {

        Scanner inC = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int countL = inC.nextInt();
        String [] lines = new String[countL];
        Scanner inp = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String patch = inp.nextLine();
        try{

            int i = 0;
            FileInputStream fstream = new FileInputStream(patch);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
                lines[i] = strLine;
                i++;
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        //System.out.printf("Путь к файлу: %s \n", patch);
        inC.close();
        inp.close();
        return lines;
    }
}
