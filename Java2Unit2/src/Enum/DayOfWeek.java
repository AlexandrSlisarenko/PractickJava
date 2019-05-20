package Enum;

public enum DayOfWeek {

    MONDAY("Понедельник",40), TUESDAY("Вторник",32), WENESDAY("Среда",24), THURSDAY("Четверг",16),FRIDAY("Пятница",8),SATUREDAY("Суббота",0),SUNDAY("Воскресенье Христово!!!",0);

    private int counеHours;
    private String name;

    DayOfWeek(String name, int hours){
        this.name = name;
        this.counеHours = hours;
    }

    public int getCounеHours(){
        return this.counеHours;
    }



}
