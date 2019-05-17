package SantoS.RelayRace.MARAFON;

abstract class Human {

    String name;
    int height;
    int weight;
    String sportTitle;
    int max_run;
    int max_swim;
    int max_jamp;
    boolean onDistans = true;

    public String getName(){
        return this.name;
    }
    public int getMax_run(){ return this.max_run;}
    public int getMax_swim(){ return this.max_swim;}
    public int getMax_jamp(){ return this.max_jamp;}
    public int getHeight(){ return this.height;}
    public void setSportTitle(String sportTitle){
        this.sportTitle = sportTitle;
    }
    public int getWeight(){
        return this.weight;
    }
    public String getSportTitle (){
        return this.sportTitle;
    }
    public void setOnDistans(boolean onDistans) {
        this.onDistans = onDistans;
    }

    public boolean isOnDistans() {
        return onDistans;
    }
}