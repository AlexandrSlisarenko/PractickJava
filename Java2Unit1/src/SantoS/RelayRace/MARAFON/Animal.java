package SantoS.RelayRace.MARAFON;

abstract class Animal {
    String name;
    String breed;
    int max_run;
    int max_swim;
    int max_jamp;
    boolean onDistans = true;

    public int getMax_run(){ return this.max_run;}
    public int getMax_swim(){ return this.max_swim;}
    public int getMax_jamp(){ return this.max_jamp;}
    public String getName(){
        return this.name;
    }
    public String getBreed(){
        return this.breed;
    }

    public void setOnDistans(boolean onDistans) {
        this.onDistans = onDistans;
    }

    public boolean isOnDistans() {
        return onDistans;
    }
}
