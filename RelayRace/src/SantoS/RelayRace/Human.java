package SantoS.RelayRace;

public abstract class Human extends Player {

    int countCookeInBag;

    public Human(String name, int maxRunDistanc, int maxJumpHeight, int maxSwimDistanc, boolean onDistanc, int cooke) {
        super(name, maxRunDistanc, maxJumpHeight, maxSwimDistanc, onDistanc);
        this.countCookeInBag = cooke;
    }

    int getCountCookeInBag(){
        return countCookeInBag;
    }

    void getCooke(){
        this.countCookeInBag -= 1;
    }
    abstract void getInfo();
}
