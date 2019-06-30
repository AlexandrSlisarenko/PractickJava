package SantoS.RelayRace.Patterns.Created.AbstractFactory.banking;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.Manager;

public class BankingManagerProject implements Manager {

    @Override
    public void managerProject() {
        System.out.println("BankingManager maneges project...");
    }
}
