package SantoS.RelayRace.MARAFON;

public class Team {
    private String name;
    private Sportsmen [] st;


    Team(String name, int count_sp){
        this.name = name;
        if(count_sp > 1){ st = new Sportsmen[count_sp];}
    }

    public String getName(){
        return name;
    }
    public void addSportsmen(Sportsmen sp){
        for (int i = 0;i<this.st.length;i++){
            if (st[i] == null) st[i] = sp;
        }
    }
    public void dellSportsmen(int i){
        st[i] = null;

    }

    public int countSportsmen(){
        return st.length;
    }

    public Sportsmen getSportsmen(int i){
        return this.st[i];
    }

    public void getInfoTeam(){
        int da = 0;
        int net = 0;
        int tmp = 0;
        while(tmp < st.length){
            if(st[tmp].sportsmenOnDistans()) da++;
            else net++;

        }
        System.out.println("Команда называется: "+this.name);
        System.out.println("Количество спортсменов прошедших соревнование: " + da);
        System.out.println("Количество сошедших с дистанции спортсменов: " + net);

    }
}
