package Collection;

import java.util.ArrayList;
import java.util.Random;


public class NewClass {
    
   public static ArrayList<String> geMass(int countWords){
       ArrayList<String> mass = new ArrayList<>();
       
       String[] alf = {"a","b","c","d","e","r","z"};
       
       Random lenWord = new Random();
       Random index = new Random();
       String word = "";
       for (int i = 0; i < countWords; i++) {
          int len = lenWord.nextInt(7);
           for (int j = 0; j < len+1; j++) {
               
               word += alf[index.nextInt(alf.length)];
           }
           mass.add(word);
           word = "";
       }
       
       return mass;
   }
}
