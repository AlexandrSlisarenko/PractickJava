package SantoS.RelayRace;

public class ObstacleСourse {
    Obstacle [] line;
    int countObstacl;

    public ObstacleСourse(){
        countObstacl = 0;
        line[countObstacl] = new Wall(1);
        countObstacl++;
        line[countObstacl] = new Cross(900);
        countObstacl++;
        line[countObstacl] = new Cross(1200);
        countObstacl++;
        line[countObstacl] = new Pool(600);
        countObstacl++;
        line[countObstacl] = new Wall(2);
        countObstacl++;
        line[countObstacl] = new Cross(300);
          
    }
}
