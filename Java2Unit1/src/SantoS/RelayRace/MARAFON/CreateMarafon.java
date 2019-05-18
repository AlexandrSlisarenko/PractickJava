package SantoS.RelayRace.MARAFON;


public class CreateMarafon {
    String[] teams;
    String[] obstkl;
    Team[] teamsM;
    Obstacle[] obstacles;
    public CreateMarafon(String[] teams, String[] obstkl){
        this.teams = teams;
        this.obstkl = obstkl;
    }
    public void create(){
        teamsM = new Team[countTeam()];
        addTeam();
        addSportsmetToTeam();
        initObstakl();
    }

    private int countTeam(){
        int result = 0;
        for (int i = 0; i < this.teams.length; i++){
            if(this.teams[i].contains("команда")){
                result++;

            }
        }
        return result;
    }

    private void addTeam(){
        String[] tmpM;
        int j = 0;
        for (int i = 0;i<this.teams.length;i++){
            if(this.teams[i].contains("команда")){
                tmpM = this.teams[i].split(":");
                tmpM = tmpM[1].split(",");
                while(j<teamsM.length){
                    if(this.teamsM[j] == null){
                        this.teamsM[j] = new Team(tmpM[0],Integer.parseInt(tmpM[1]));
                        this.teams[i] = "";
                        break;
                    }
                    j++;
                }

            }
        }

    }

    private void addSportsmetToTeam(){
        String[] tmpM;
        String[] sportsmenParam;
        int j = 0;
        for (int i = 0;i<this.teams.length;i++) {
            if (this.teams[i] != "") {
                tmpM = this.teams[i].split(":");
                sportsmenParam = tmpM[1].split(",");
                switch (tmpM[0]){
                    case "муж":
                        this.teamsM[findTeam(sportsmenParam[0])].addSportsmen(new Men(sportsmenParam[1],Integer.parseInt(sportsmenParam[2]),Integer.parseInt(sportsmenParam[3]),sportsmenParam[4],Integer.parseInt(sportsmenParam[5]),Integer.parseInt(sportsmenParam[6]),Integer.parseInt(sportsmenParam[7])));
                        break;
                    case "жена":
                        this.teamsM[findTeam(sportsmenParam[0])].addSportsmen(new Woman(sportsmenParam[1],Integer.parseInt(sportsmenParam[2]),Integer.parseInt(sportsmenParam[3]),sportsmenParam[4],Integer.parseInt(sportsmenParam[5]),Integer.parseInt(sportsmenParam[6]),Integer.parseInt(sportsmenParam[7])));
                        break;
                    case "собака":
                        this.teamsM[findTeam(sportsmenParam[0])].addSportsmen(new Dog(sportsmenParam[1],sportsmenParam[2],Integer.parseInt(sportsmenParam[3]),Integer.parseInt(sportsmenParam[4]),Integer.parseInt(sportsmenParam[5])));
                        break;
                }

            }
        }

    }

    private int findTeam(String name){
        for (int i = 0;i < this.teamsM.length; i++){
            if(this.teamsM[i].getName().equals(name)) return i;
        }
        return -1;
    }

    private void initObstakl(){
        this.obstacles = new Obstacle[this.obstkl.length];
        String[] tmpO;
        String[] params;
        for (int i = 0;i<this.obstkl.length;i++) {
                tmpO = this.obstkl[i].split(":");
                params = tmpO[1].split(",");
                switch (tmpO[0]){
                    case "стадион":
                        this.obstacles[i] = new Stadium(params[0],Integer.parseInt(params[1]));
                        break;
                    case "стена":
                        this.obstacles[i] = new Wall(params[0],Integer.parseInt(params[1]));
                        break;
                    case "бассейн":
                        this.obstacles[i] = new Swimming_pool(params[0],Integer.parseInt(params[1]));
                        break;
                }


        }

    }

    public void start(){
        for (int i = 0; i < this.obstacles.length; i++){
            for (int j = 0; j < this.teamsM.length; j++) {
                doItOdstakle(this.obstacles[i],this.teamsM[j]);
            }
        }
    }

    private void doItOdstakle(Obstacle O, Team t){
        for (int i = 0; i < t.countSportsmen(); i++) {
            O.doIt(t.getSportsmen(i));
        }
    }
    public void finish(){
        for (int i = 0; i < teamsM.length; i++) {
            teamsM[i].getInfoTeam();
        }
        System.out.println("Участники команд");
        for (int i = 0; i < teamsM.length; i++) {
            for (int j = 0; j < teamsM[i].countSportsmen(); j++) {
                teamsM[i].getSportsmen(j).getInfo();
            }

        }
    }
}
