package SantoS.RelayRace;

public class Team {
    private String name;
    private Competitor [] comp;
    private int countPlayers;

    public Team(String name, String [][] dataTeam){
        this.name = name;
        this.countPlayers = 0;
        for (int i = 0; i < dataTeam.length;i++){
            addPlayer(dataTeam[i]);
        }
    }

    public int getCountPlayers(){
        return this.countPlayers;
    }
    public String getName(){return this.name;}
    public Competitor [] getTeam(){ return this.comp;}

    void addPlayer(String [] dataPlayer){
        switch(dataPlayer[0]){
            case "Men":
                this.countPlayers++;
                comp[this.countPlayers] = new Men(dataPlayer[1], Integer.parseInt(dataPlayer[2]),Integer.parseInt(dataPlayer[3]),Integer.parseInt(dataPlayer[4]),true,Integer.parseInt(dataPlayer[5]));
                break;
            case "Cat":
                this.countPlayers++;
                comp[this.countPlayers] = new Cat(dataPlayer[1], Integer.parseInt(dataPlayer[2]),Integer.parseInt(dataPlayer[3]),Integer.parseInt(dataPlayer[4]),true, dataPlayer[5], dataPlayer[6],dataPlayer[7]);
                break;
            case "Dog":
                this.countPlayers++;
                comp[this.countPlayers] = new Dog(dataPlayer[1], Integer.parseInt(dataPlayer[2]),Integer.parseInt(dataPlayer[3]),Integer.parseInt(dataPlayer[4]),true, dataPlayer[5], dataPlayer[6],dataPlayer[7]);
                break;
        }
    }





}
