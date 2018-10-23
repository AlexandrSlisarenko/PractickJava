package SantoS.RelayRace;

public class Pool extends Obstacle{
    int range;

    public Pool(int r){
        this.range = r;
    }

    @Override
    public void doit(Competitor com){
        com.swim(this.range);
    }
}
