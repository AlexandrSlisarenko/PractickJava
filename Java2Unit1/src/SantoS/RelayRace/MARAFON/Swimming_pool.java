package SantoS.RelayRace.MARAFON;

public class Swimming_pool extends Obstacle {
    Swimming_pool(String name, int param){
        super.name = name;
        if(param > 0) super.parametr = param;
    }

    public void doIt(Sportsmen sp){
        sp.doSwim(this.parametr);
    }
}

