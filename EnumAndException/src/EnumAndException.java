import  Enum.*;
import  Exception.*;
public class EnumAndException {


    public static void main(String[] args){
        JobHours jh = new JobHours();
        jh.getJobHours(EnumWeek.FRIDAY);


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

    }
}
