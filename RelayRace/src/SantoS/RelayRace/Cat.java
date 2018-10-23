package SantoS.RelayRace;

public class Cat extends Animal{

    public Cat(String name, int run_d, int jump_h, int swim_d, boolean onDist, String type, String breed, String v) {
        super(name, run_d, jump_h, swim_d, onDist, type, breed, v);
    }
    public void getInfo() {
        if (this.isOnDistanc()) {
            String info = this.type + " породы " + this.breed + " по кличке " + this.name + " прошла препятствие!!!";
            this.info(info);
            this.info(this.vote);
        }else {
            String info = this.type + " породы " + this.breed + " по кличке " + this.name + " не прошла препятствие((((";
            this.info(info);
        }

    }
}
