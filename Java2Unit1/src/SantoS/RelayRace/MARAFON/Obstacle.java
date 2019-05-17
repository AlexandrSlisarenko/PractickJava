package SantoS.RelayRace.MARAFON;

abstract class Obstacle {
    String name;
    int parametr;

    public int getParametr() {
        return parametr;
    }

    public String getName() {
        return name;
    }

    public void doIt(Sportsmen sp){}


}
