package SantoS.RelayRace;

public class Wall extends Obstacle{
    int height;

    public Wall(int h){
        this.height = h;
    }

    public void doit(Competitor com){
        com.jump(this.height);
    }

    @Override
    public String name() {
        return "wall";
    }

}
