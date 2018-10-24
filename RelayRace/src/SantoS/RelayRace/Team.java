package SantoS.RelayRace;

public class Team {
    private String name;
    private Competitor [] comp;
    private int countPlayers;
    private int bal;
    private boolean best;

    public Team(String name, String [][] dataTeam){
        this.name = name;
        this.countPlayers = 0;
        this.bal = 0;
        this.best = false;
        this.comp =  new Competitor [dataTeam.length];
        for (int i = 0; i < dataTeam.length;i++){
            addPlayer(dataTeam[i]);
        }
    }

    public boolean getBest(){
        return this.best;
    }
    public void setBest(){
        this.best = true;
    }
    public void addBal(){
        this.bal++;
    }
    public int getBal(){
        return this.bal;
    }

    public int getCountPlayers(){
        return this.countPlayers;
    }
    public String getName(){return this.name;}
    public Competitor [] getTeam(){ return this.comp;}
    public Competitor getPlayer(int i){ return this.comp[i];}

    void addPlayer(String [] dataPlayer){
        switch(dataPlayer[0]){
            case "Men":

                comp[this.countPlayers] = new Men(dataPlayer[1], Integer.parseInt(dataPlayer[2]),Integer.parseInt(dataPlayer[3]),Integer.parseInt(dataPlayer[4]),true,Integer.parseInt(dataPlayer[5]));
                this.countPlayers++;
                break;
            case "Cat":

                comp[this.countPlayers] = new Cat(dataPlayer[1], Integer.parseInt(dataPlayer[2]),Integer.parseInt(dataPlayer[3]),Integer.parseInt(dataPlayer[4]),true, dataPlayer[5], dataPlayer[6],dataPlayer[7]);
                this.countPlayers++;
                break;
            case "Dog":

                comp[this.countPlayers] = new Dog(dataPlayer[1], Integer.parseInt(dataPlayer[2]),Integer.parseInt(dataPlayer[3]),Integer.parseInt(dataPlayer[4]),true, dataPlayer[5], dataPlayer[6],dataPlayer[7]);
                this.countPlayers++;
                break;
        }
    }





}
