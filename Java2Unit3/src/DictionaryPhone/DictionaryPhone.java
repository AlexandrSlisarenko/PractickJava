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

    public boolean addRecord(String fio, ArrayList<String> phone_number){
        ArrayList<String> tmpP = new ArrayList<>();
        for (int i = 0; i < phone_number.size(); i++) {
            if (testPhone(phone_number.get(i))){tmpP.add(phone_number.get(i));}
        }
        if(tmpP.size() > 0) {
            this.dictionary.put(fio,tmpP);
            this.persons.add(fio);
            return true;
        }
        else return false;
    }

    public boolean addPhoneInRecord(String fio,  ArrayList<String> numbers){
        if(findRecord(fio)) {
            for (int i = 0; i < numbers.size(); i++) {
                this.dictionary.get(fio).add(numbers.get(i));
            }
            return true;
        }else return false;
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
        if(findRecord(record[0])){
            if (record.length == 1){
                this.dictionary.remove(record[0]);
                this.persons.remove(record[0]);
                System.out.println("Записи "+record[0]+" удалена");
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
        else System.out.println("Такой записи нет");
    }

    public void printDictionary(){
        if(this.persons.size() > 0) {
            Iterator<String> it = this.persons.iterator();
            while (it.hasNext()) {
                String element = it.next();
                System.out.println(element);
                ArrayList<String> mPh = this.dictionary.get(element);
                System.out.println(mPh.toString());
            }
        }
        else System.out.println("Справочник пуст!");
    }

    public ArrayList<String> findPh(String fio){
            if(findRecord(fio)) return this.dictionary.get(fio);
            else return new ArrayList<>(1);
    }

    private boolean findRecord(String fio){
        if (this.dictionary.get(fio) == null)return false;
        else return true;
    }

}
