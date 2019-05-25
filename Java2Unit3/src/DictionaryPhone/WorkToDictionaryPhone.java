package DictionaryPhone;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkToDictionaryPhone {
    private DictionaryPhone dictionaryP;
    private boolean start;
    private Scanner setComand;
    private String fio;
    private ArrayList<String> numbers;

    public WorkToDictionaryPhone(){
        this.start = true;
        this.dictionaryP = new DictionaryPhone();
        this.setComand = new Scanner(System.in);
        this.numbers = new ArrayList<>();
    }

    public void use(){
        System.out.println("Телефонный справочник приветствует вас! Прошу вас ввести номер команды длс работоты:");
        System.out.println("1 - добавить запись");
        System.out.println("2 - удалить запись");
        System.out.println("3 - удалить номер/номера");
        System.out.println("4 - добавить номер/номера");
        System.out.println("5 - показать весь справочник");
        System.out.println("6 - найти запись");
        System.out.println("0 - выход/завершение ввода");

       while (this.start){
           System.out.println("Введите номер команду:");
           switch (this.setComand.nextInt()){
               case 1:
                   this.setFIO();
                   this.setNumbers();
                   this.dictionaryP.addRecord(this.fio,this.numbers);
                   break;
               case 2:
                   this.setFIO();
                   this.dictionaryP.removeRecordOrPhone(this.fio);
                   break;
               case 3:
                   this.setFIO();
                   this.setNumbers();
                   for (int i = 0; i < numbers.size(); i++) {
                       this.dictionaryP.removeRecordOrPhone(this.fio, this.numbers.get(i));
                   }
                   break;
               case 4:
                   this.setFIO();
                   this.setNumbers();
                   this.dictionaryP.addPhoneInRecord(this.fio,this.numbers);
                   break;
               case 5:
                   this.dictionaryP.printDictionary();
                   break;
               case 6:
                   this.setFIO();
                   this.dictionaryP.findPh(this.fio);
                   break;
               case 0:
                   this.start = false;
                   break;

           }
       }
    }

    private void setFIO(){
        Scanner scFIO = new Scanner(System.in);
        System.out.println("Введите ФИО:");
        this.fio = scFIO.nextLine();

    }
    private void setNumbers(){
        System.out.println("Введите телефон или телефоны в столбик, если закончили введите 0 и нажмите enter:");
        while (!this.setComand.next().equals("0")){

            this.numbers.add(this.setComand.next());
            System.out.println("Введите телефон или 0:");
        }
    }
}
