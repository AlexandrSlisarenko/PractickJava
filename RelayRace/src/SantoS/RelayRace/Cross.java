package SantoS.RelayRace;

public class Cross extends Obstacle{
    int range;

    public Cross(int r){
        this.range = r;
    }

    public void doit(Competitor com){
        com.run(this.range);
    }

    public String name() {
        return "cross";
    }

}
