package SantoS.RelayRace;

import SantoS.RelayRace.Number_of_vowels.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Reading_from_file red = new Reading_from_file();
        String [] f = red.read();
        MyRegEx reg = new MyRegEx();
        System.out.println(reg.getCountMatchesInFile("aueiy",f));

    }
}
