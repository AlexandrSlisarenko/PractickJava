package Enum;

public class JobHours {


    public void getJobHours(EnumWeek day){
            for (EnumWeek dayWeek: EnumWeek.values()) {
                if(dayWeek == day){
                    System.out.println(dayWeek.getNameDay()+"("+dayWeek+") - осталось работать "+dayWeek.getJobTime());
                    break;
                }
            }
        }

}
