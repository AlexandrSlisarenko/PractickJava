package Enum;

public enum EnumWeek {
    MONDAY("Понедельник","сорок рабочих часов"), TUESDAY("Вторник","тридцать два рабочих часа"),WEDNESDAY("Среда","двадцать четыре рабочих часа"),THURSDAY("Четверг","шестнадцать рабочих часов"),FRIDAY("Пятница","восемь рабочих часов"),SATURDAY("Суббота","Выходной(24 часа)!!!"),SUNDAY("Воскресение","Выходной(24 часа)!!!");


    private String nameDay;
    private String jobTime;

    public String getNameDay() {
        return nameDay;
    }

    public String getJobTime() {
        return jobTime;
    }

    EnumWeek(String nameDay, String jobTime){
        this.nameDay = nameDay;
        this.jobTime = jobTime;
    }


}



