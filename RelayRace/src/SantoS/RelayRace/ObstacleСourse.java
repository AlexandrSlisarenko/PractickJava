package SantoS.RelayRace;

public class ObstacleСourse {
    private Obstacle [] track;
    private int countObstacl;

    public ObstacleСourse(){
        track = new Obstacle [6];
        countObstacl = 0;
        track[countObstacl] = new Wall(1);
        countObstacl++;
        track[countObstacl] = new Cross(900);
        countObstacl++;
        track[countObstacl] = new Cross(1200);
        countObstacl++;
        track[countObstacl] = new Pool(600);
        countObstacl++;
        track[countObstacl] = new Wall(2);
        countObstacl++;
        track[countObstacl] = new Cross(300);

    }

    public Obstacle getObstacle(int i){
        return this.track[i];
    }
    public int getCountObstacl(){
        return this.countObstacl;
    }
}
