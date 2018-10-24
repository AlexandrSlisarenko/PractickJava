package SantoS.RelayRace;

public abstract class Player implements Competitor{

    String name;

    private int maxRunDistanc;
    private int maxJumpHeight;
    private int maxSwimDistanc;
    private int obstacleYes;
    private int obstacleNo;
    private boolean onDistanc;

    public Player(String name, int maxRunDistanc, int maxJumpHeight, int maxSwimDistanc, boolean onDistanc) {
        this.name = name;
        this.maxRunDistanc = maxRunDistanc;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistanc = maxSwimDistanc;
        this.onDistanc = onDistanc;
        this.obstacleNo = 0;
        this.obstacleYes = 0;
    }

    @Override
    public void run(int dist) {
        if(dist <= maxRunDistanc){
            this.onDistanc = true;
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
            this.obstacleYes ++;
        }else{
            this.onDistanc = false;
            System.out.println("Спортсмен "+ this.name +" не справился с препятствием!");
            this.obstacleNo ++;
        }
    }

    @Override
    public void swim(int dist) {
        if(dist <= maxSwimDistanc){
            this.onDistanc = true;
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
            this.obstacleYes ++;
        }else{
            this.onDistanc = false;
            System.out.println("Спортсмен "+ this.name +" не справился с препятствием!");
            this.obstacleNo ++;
        }
    }

    @Override
    public void jump(int dist) {
        if(dist <= maxJumpHeight){
            this.onDistanc = true;
            System.out.println("Спортсмен "+ this.name +" справился с препятствием!");
            this.obstacleYes ++;
        }else{
            this.onDistanc = false;
            System.out.println("Спортсмен "+ this.name +" не справился с препятствием!");
            this.obstacleNo ++;
        }
    }

    @Override
    public boolean isOnDistanc() {
        return this.onDistanc;
    }

    @Override
    public void info() {
        String info = "Спортсмен "+this.name+" прошел "+this.obstacleYes+" препятствий и не прошол "+this.obstacleNo+" препятствий.";
        System.out.println(info);
    }

}
