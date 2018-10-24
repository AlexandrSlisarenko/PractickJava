package SantoS.RelayRace;

public abstract class Animal extends Player{


    String type;
    String breed;
    String vote;


    public Animal(String name, int run_d, int jump_h, int swim_d, boolean onDist, String type, String breed, String v) {
        super(name, run_d, jump_h, swim_d, onDist);
        this.type = type;
        this.breed = breed;

        this.vote = v;

    }


}
