package SantoS.RelayRace;

public class Men extends Human {

    public Men(String name, int maxRunDistanc, int maxJumpHeight, int maxSwimDistanc, boolean onDistanc, int cooke) {
        super(name, maxRunDistanc, maxJumpHeight, maxSwimDistanc, onDistanc, cooke);
    }
    public void getInfo() {
        if (this.isOnDistanc()) {
            String info =  "Участник " + this.name + " прошла препятствие!!!";
            this.info(info);

        }else {
            String info =  "Участник " + this.name + " не прошла препятствие";
            this.info(info);
        }

    }
}
