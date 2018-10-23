package SantoS.RelayRace;

public abstract class Player implements Competitor{

    String name;

    int maxRunDistanc;
    int maxJumpHeight;
    int maxSwimDistanc;

    boolean onDistanc;

    public Player(String name, int maxRunDistanc, int maxJumpHeight, int maxSwimDistanc, boolean onDistanc) {
        this.name = name;
        this.maxRunDistanc = maxRunDistanc;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistanc = maxSwimDistanc;
        this.onDistanc = onDistanc;
    }

    @Override
    public void run(int dist) {
        if(dist <= maxRunDistanc){
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
        }else{
            this.onDistanc = false;
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
        }
    }

    @Override
    public void swim(int dist) {
        if(dist <= maxSwimDistanc){
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
        }else{
            this.onDistanc = false;
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
        }
    }

    @Override
    public void jump(int dist) {
        if(dist <= maxJumpHeight){
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
        }else{
            this.onDistanc = false;
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
        }
    }

    @Override
    public boolean isOnDistanc() {
        return this.onDistanc;
    }

    @Override
    public void info(String info) {
        System.out.println(info);
    }

}
