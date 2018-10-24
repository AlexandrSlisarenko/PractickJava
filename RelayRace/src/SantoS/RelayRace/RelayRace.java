package SantoS.RelayRace;

public class RelayRace {
    //Входные данные команд//
    String [] player1 = {"Men","Иван","1000","3","500","20"};
    String [] player2 = {"Men","Маша","800","2","800","50"};
    String [] player3 = {"Cat","Барсик","100","2","0","кот","чеширский","Муууррр"};
    String [] player4 = {"Cat","Мурзик","120","1","0","кот","дворовый","Мяяяу"};
    String [] player5 = {"Cat","Ириска","80","2","0","кошка","веслоухая","МурррМяяяяяуу"};
    String [] player6 = {"Dog","Полкан","1500","3","400","пес","сторожевой","Гав"};
    String [] player7 = {"Dog","Шарик","1200","2","700","пес","спаниель","РРР Гав"};
    String [] player8 = {"Dog","Волга","900","1","400","собака","дворовая","Гав Гав Гав"};
    String [][] team1data = {player1, player3,player5,player8};

    String [][] team2data = {player2, player4,player6,player7};
    //Входные данные команд//

    private Team team1;
    private Team team2;

    private ObstacleСourse track;

    public RelayRace(){
        this.team1 = new Team("Звезда", team1data);
        this.team2 = new Team("Победа", team2data);
        this.track = new ObstacleСourse();
    }

    void  transit(int n_obstac, int n_plauer, Team team){
        track.getObstacle(n_obstac).doit(team.getPlayer(n_plauer));
        if(team.getPlayer(n_plauer).isOnDistanc()){
            team.addBal();
            //team.getPlayer(n_plauer).
        }

    }




    void start(){
        for (int i = 0; i < this.track.getCountObstacl(); i++) {
            for (int j = 0; j < team1.getCountPlayers(); j++) {
                transit(i, j, team1);
            }
            for (int k = 0; k < team1.getCountPlayers(); k++) {
                transit(i, k, team2);
            }
        }
    }

    void result(){
        if(team1.getBal() > team2.getBal()){
            System.out.println("Победила команда "+team1.getName()+" набрав "+team1.getBal()+" очков!!! УРА");
            team1.setBest();
        }
        else{
            System.out.println("Победила команда "+team2.getName()+" набрав "+team2.getBal()+"!!! УРА");
            team2.setBest();
        }


    }

    void inforAllPlauers(){
        System.out.println("Команда "+team1.getName());
        for (int i = 0; i < team1.getCountPlayers(); i++) {
            team1.getPlayer(i).info();
        }
        System.out.println("Команда "+team2.getName());
        for (int i = 0; i < team2.getCountPlayers(); i++) {
            team2.getPlayer(i).info();
        }
    }




}
