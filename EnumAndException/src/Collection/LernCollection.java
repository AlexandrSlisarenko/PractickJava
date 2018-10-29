
package Collection;

import java.util.ArrayList;
import java.util.HashMap;


public class LernCollection {
    
    public static void printWords(ArrayList <String> masWords){
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Integer key;
        
        for (int i = 0; i < masWords.size(); i++) {
            key = hm.get(masWords.get(i));
            hm.put(masWords.get(i), key == null ? 1 : key + 1);
            
        }
        
        System.out.println("Список уникальный слов:");
        
       for (int i = 0; i < hm.size(); i++) {
           if(hm.get(masWords.get(i)) == 1){
               System.out.println(masWords.get(i)+" ");
           }
       }
       
        System.out.println("Колличество раз вывода каждого слова:");
        
       
               System.out.println(hm);
          
       
    }
    
}
