package Enum;
import Exception.*;



public class WorkToEnum {
    public DayOfWeek getDay (int i)throws NoSuchDay {
        if(0 > i || i >7) throw new NoSuchDay("Такого дня нет!!!",1);
        for (DayOfWeek d: DayOfWeek.values()){
            if(i == d.ordinal()) return d;
        }
        return null;
    }

    public String getCountHours(DayOfWeek d){
        if(d.getCounеHours() != 0) return "Осталось работать " + d.getCounеHours() + " часов!";
        else{
            return "Сегодня выходной! Ура!!!";
        }
    }
}
