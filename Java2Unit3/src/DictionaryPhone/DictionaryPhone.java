package DictionaryPhone;
import java.util.*;

public class DictionaryPhone
{
    private HashMap<String,ArrayList<String>> dictionary;
    private HashSet<String> persons;
   // private ArrayList<String[]> phones;



    public DictionaryPhone() {
        this.persons = new HashSet<>();
     //   this.phones = new ArrayList<>();

        this.dictionary = new HashMap<>();
    }

    public void addRecord(String fio, ArrayList<String> phone_number){
        ArrayList<String> tmpP = new ArrayList<>();
        for (int i = 0; i < phone_number.size(); i++) {
            if (testPhone(phone_number.get(i))){tmpP.add(phone_number.get(i));}
        }
        if(tmpP.size() > 0) {
            this.dictionary.put(fio,tmpP);
            this.persons.add(fio);
            //this.phones.add(tmpP);
            System.out.println("Запись создана корректно");
        }
    }

    private boolean testPhone(String ph){
        if(ph.length() != 10){
            System.out.println("Номер не корретной длинны, необходимо указать 10 символов  +7__________");
            return false;
        }else {
            if(ph.matches("\\d.*")){
                return true;
            }else{
                System.out.println("номер должен содержать тольуо цифры без пробела");
                return false;
            }
        }


    }

    public void removeRecordOrPhone(String... record){
        if (record.length == 1){
            this.dictionary.remove(record[0]);
        }
        else {
            if(testPhone(record[1])){
                if(this.dictionary.get(record[0]).remove(record[1]))
                    System.out.println("Из записи "+record[0]+" удален номер "+record[1]);
                else
                    System.out.println("Что то полшло не так!!!");
            }


        }
    }

    public void printDictionary(){
        Iterator<String> it = this.persons.iterator();
        while (it.hasNext()){
            String element = it.next();
            System.out.println(element);
            ArrayList<String> mPh = this.dictionary.get(element);
            System.out.println(mPh.toString());
        }
    }

    public ArrayList<String> findPh(String fio){
            return this.dictionary.get(fio);
    }

}
