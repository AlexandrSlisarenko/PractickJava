package SantoS.RelayRace.MARAFON;

public class Stadium extends Obstacle {
    Stadium(String name, int param){
        super.name = name;
        if(param > 0) super.parametr = param;
    }

    public void doIt(Sportsmen sp){
        sp.doRun(this.parametr);
    }
}
