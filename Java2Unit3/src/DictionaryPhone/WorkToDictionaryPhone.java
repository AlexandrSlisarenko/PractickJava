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
        System.out.println("3 - удалить номер");
        System.out.println("4 - добавить номер");
        System.out.println("5 - роказать весь справочник");
        System.out.println("6 - найти запись");
        System.out.println("0 - выход/завершение ввода");

       while (this.start){
           System.out.println("Введите номер команду:");
           switch (this.setComand.nextInt()){
               case 1:
                   System.out.println("Введите ФИО:");
                   this.fio = this.setComand.next();
                   System.out.println("Введите телефон или телефоны в столбик, если закончили введите 0 и нажмите enter:");
                    while (this.setComand.next() != "0"){
                        this.numbers.add(this.setComand.next());
                    }
                    this.dictionaryP.addRecord(this.fio,this.numbers);
                    break;

           }
       }
    }
}
