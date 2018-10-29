import  Enum.*;
import  Exception.*;
import Collection.*;

import java.util.ArrayList;

public class EnumAndException {


    public static void main(String[] args){

       /*
        енумы
        *JobHours jh = new JobHours();
        *jh.getJobHours(EnumWeek.FRIDAY);
        *
        */

/*
    исключения
        CreatedDate mass = new CreatedDate(4,4);
        mass.getMassData()[1][1] = "qwer";
        JobToException jE = new JobToException(mass.getMassData(),4);
        try {
            jE.summElement();
        }catch (MyDataException e){
            System.out.println(e);
        }catch (MyArraySizeException e){
            System.out.println(e);
        }
*/
        ArrayList<String> masw = NewClass.geMass(20);
        masw.set(3, masw.get(15));
        masw.set(10, masw.get(2));
        masw.set(13, masw.get(5));
        masw.set(11, masw.get(5));
        LernCollection.printWords(masw);


        PhoneBook pb = new PhoneBook();

        pb.addRecord("Иван",new String[]{"+3(234)123-3234-234","9(234)234234","123452"});
        pb.addRecord("Александр",new String[]{"+7(956)123-3234-234","9(234)234234","123452"});
        pb.addRecord("Николай",new String[]{"+7(956)123-3234-234","9(234)234234","123452"});
        pb.addRecord("Петр",new String[]{"+7(956)123-3234-234","9(234)234234","123452"});
        pb.printAllRecords();
        pb.addRecord("Петр",new String[]{"765876587658","3333333"});
        pb.delRecord("Александр");
        pb.findRecord("Николай");
        pb.printAllRecords();

    }
}
