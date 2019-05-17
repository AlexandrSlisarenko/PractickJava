package SantoS.RelayRace.MARAFON;

public class Wall extends Obstacle {
    Wall(String name, int param){
        super.name = name;
        if(param > 0) super.parametr = param;
    }

    public void doIt(Sportsmen sp){
        sp.doJump(this.parametr);
    }
}
